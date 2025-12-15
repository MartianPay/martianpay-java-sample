package com.martianpay.examples;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.martianpay.developer.Event;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * Webhook Example
 *
 * This class demonstrates how to receive and verify webhook events from MartianPay.
 */
public class WebhookExample {

    private static final String WEBHOOK_SECRET = Common.WEBHOOK_SECRET;
    private static final String MARTIANPAY_SIGNATURE_HEADER = Event.MARTIAN_PAY_SIGNATURE;
    private static final int PORT = 8080;
    private static final Gson gson = new Gson();

    /**
     * Webhook event data structure
     */
    public static class WebhookEvent {
        private String id;
        private String type;
        private long created;
        private JsonObject data;

        public String getId() { return id; }
        public String getType() { return type; }
        public long getCreated() { return created; }
        public JsonObject getData() { return data; }
    }

    /**
     * HTTP handler for webhook requests
     */
    static class WebhookHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if (!"POST".equals(exchange.getRequestMethod())) {
                sendResponse(exchange, 405, createErrorResponse(405, "Method Not Allowed"));
                return;
            }

            try {
                // Read request body
                String requestBody = readRequestBody(exchange.getRequestBody());

                // Get signature from header
                String signature = exchange.getRequestHeaders().getFirst(MARTIANPAY_SIGNATURE_HEADER);
                if (signature == null || signature.isEmpty()) {
                    System.out.println("✗ Missing Martian-Pay-Signature header");
                    sendResponse(exchange, 400, createErrorResponse(400, "Missing signature header"));
                    return;
                }

                // Verify webhook signature
                WebhookEvent event = verifyAndParseWebhook(requestBody, signature);
                if (event == null) {
                    System.out.println("✗ Invalid webhook signature");
                    sendResponse(exchange, 400, createErrorResponse(400, "Invalid signature"));
                    return;
                }

                // Process webhook event
                processWebhookEvent(event);

                // Send success response
                sendResponse(exchange, 200, createSuccessResponse());

            } catch (Exception e) {
                System.out.println("✗ Error processing webhook: " + e.getMessage());
                e.printStackTrace();
                sendResponse(exchange, 500, createErrorResponse(500, "Internal server error"));
            }
        }

        private String readRequestBody(InputStream inputStream) throws IOException {
            ByteArrayOutputStream result = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                result.write(buffer, 0, length);
            }
            return result.toString(StandardCharsets.UTF_8.name());
        }

        private void sendResponse(HttpExchange exchange, int statusCode, String response) throws IOException {
            byte[] responseBytes = response.getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.sendResponseHeaders(statusCode, responseBytes.length);
            OutputStream os = exchange.getResponseBody();
            os.write(responseBytes);
            os.close();
        }

        private String createSuccessResponse() {
            Map<String, Object> response = new HashMap<>();
            response.put("code", 0);
            response.put("msg", "success");
            return gson.toJson(response);
        }

        private String createErrorResponse(int code, String msg) {
            Map<String, Object> response = new HashMap<>();
            response.put("code", code);
            response.put("msg", msg);
            return gson.toJson(response);
        }
    }

    /**
     * Verifies webhook signature and parses event
     */
    private static WebhookEvent verifyAndParseWebhook(String payload, String signatureHeader) {
        try {
            // Parse signature header: "t=timestamp,v1=signature"
            SignatureData sigData = parseSignatureHeader(signatureHeader);
            if (sigData == null) {
                System.out.println("✗ Invalid signature header format");
                return null;
            }

            // Verify HMAC signature
            if (!verifySignature(payload, sigData, WEBHOOK_SECRET)) {
                return null;
            }

            // Parse webhook event
            return gson.fromJson(payload, WebhookEvent.class);
        } catch (Exception e) {
            System.out.println("✗ Error verifying webhook: " + e.getMessage());
            return null;
        }
    }

    /**
     * SignatureData holds parsed signature information
     */
    private static class SignatureData {
        long timestamp;
        String signature;
    }

    /**
     * Parses signature header in format "t=timestamp,v1=signature"
     */
    private static SignatureData parseSignatureHeader(String header) {
        if (header == null || header.isEmpty()) {
            return null;
        }

        SignatureData data = new SignatureData();
        String[] pairs = header.split(",");

        for (String pair : pairs) {
            String[] parts = pair.split("=", 2);
            if (parts.length != 2) {
                continue;
            }

            String key = parts[0].trim();
            String value = parts[1].trim();

            if ("t".equals(key)) {
                try {
                    data.timestamp = Long.parseLong(value);
                } catch (NumberFormatException e) {
                    return null;
                }
            } else if ("v1".equals(key)) {
                data.signature = value;
            }
        }

        if (data.timestamp == 0 || data.signature == null) {
            return null;
        }

        return data;
    }

    /**
     * Verifies HMAC-SHA256 signature
     * Computes: HMAC-SHA256(timestamp + "." + payload, secret)
     */
    private static boolean verifySignature(String payload, SignatureData sigData, String secret) {
        try {
            // Compute expected signature: HMAC-SHA256(timestamp + "." + payload, secret)
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
            mac.init(secretKeySpec);

            // Add timestamp
            mac.update(String.valueOf(sigData.timestamp).getBytes(StandardCharsets.UTF_8));
            // Add separator
            mac.update(".".getBytes(StandardCharsets.UTF_8));
            // Add payload
            mac.update(payload.getBytes(StandardCharsets.UTF_8));

            byte[] hmacBytes = mac.doFinal();

            // Convert to hex string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hmacBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            String expectedSignature = hexString.toString();

            // Compare signatures
            boolean isValid = expectedSignature.equals(sigData.signature);
            if (!isValid) {
                System.out.println("✗ Signature mismatch");
                System.out.println("  Expected: " + expectedSignature);
                System.out.println("  Received: " + sigData.signature);
            }

            return isValid;
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            System.out.println("✗ Error computing signature: " + e.getMessage());
            return false;
        }
    }

    /**
     * Processes webhook event based on event type
     */
    private static void processWebhookEvent(WebhookEvent event) {
        System.out.println("✓ Webhook event received:");
        System.out.println("  Event ID: " + event.getId());
        System.out.println("  Event Type: " + event.getType());
        System.out.println("  Created: " + event.getCreated());

        String eventType = event.getType();

        if (eventType.startsWith("payment_intent")) {
            System.out.println("\n  Payment Intent Event:");
            JsonObject data = event.getData();
            if (data != null) {
                System.out.println("    ID: " + data.get("id"));
                System.out.println("    Status: " + data.get("status"));
                if (data.has("amount")) {
                    System.out.println("    Amount: " + data.get("amount"));
                }
            }
        } else if (eventType.startsWith("refund")) {
            System.out.println("\n  Refund Event:");
            JsonObject data = event.getData();
            if (data != null) {
                System.out.println("    ID: " + data.get("id"));
                System.out.println("    Status: " + data.get("status"));
                if (data.has("amount")) {
                    System.out.println("    Amount: " + data.get("amount"));
                }
                if (data.has("payment_intent")) {
                    System.out.println("    Payment Intent: " + data.get("payment_intent"));
                }
            }
        } else if (eventType.startsWith("payroll_item")) {
            // Handle payroll_item events (must check before payroll to avoid prefix conflict)
            System.out.println("\n  Payroll Item Event:");
            JsonObject data = event.getData();
            if (data != null) {
                System.out.println("    ID: " + data.get("id"));
                System.out.println("    Payroll ID: " + data.get("payroll_id"));
                System.out.println("    Status: " + data.get("status"));
                if (data.has("amount")) {
                    System.out.println("    Amount: " + data.get("amount"));
                }
            }
        } else if (eventType.startsWith("payroll")) {
            System.out.println("\n  Payroll Event:");
            JsonObject data = event.getData();
            if (data != null) {
                System.out.println("    ID: " + data.get("id"));
                System.out.println("    Status: " + data.get("status"));
                if (data.has("total_amount")) {
                    System.out.println("    Total Amount: " + data.get("total_amount"));
                }
                if (data.has("total_item_num")) {
                    System.out.println("    Item Count: " + data.get("total_item_num"));
                }
            }
        } else if (eventType.startsWith("payout")) {
            System.out.println("\n  Payout Event:");
            JsonObject data = event.getData();
            if (data != null) {
                System.out.println("    ID: " + data.get("id"));
                System.out.println("    Status: " + data.get("status"));
            }
        }
    }

    /**
     * Starts the webhook event receiver server
     */
    public static void startWebhookServer() {
        HttpServer server = null;
        try {
            System.out.println("\n=== Webhook Event Receiver ===");
            System.out.println("\nStarting webhook server on http://localhost:" + PORT + "...");

            server = HttpServer.create(new InetSocketAddress(PORT), 0);
            server.createContext("/v1/webhook_test", new WebhookHandler());
            server.setExecutor(null); // creates a default executor
            server.start();

            System.out.println("✓ Server started successfully!");
            System.out.println("\nServer is listening for webhook events at POST /v1/webhook_test");
            System.out.println("\nPress Enter to stop the server...");

            // Wait for user input to stop the server
            new BufferedReader(new InputStreamReader(System.in)).readLine();

            System.out.println("\nStopping webhook server...");
            server.stop(0);
            System.out.println("✓ Server stopped successfully!");

        } catch (IOException e) {
            System.out.println("✗ Failed to start webhook server: " + e.getMessage());
            if (e.getMessage() != null && e.getMessage().contains("Address already in use")) {
                System.out.println("  Port " + PORT + " is already in use. Please stop any running webhook servers first.");
            }
            e.printStackTrace();
        } finally {
            if (server != null) {
                server.stop(0);
            }
        }
    }
}
