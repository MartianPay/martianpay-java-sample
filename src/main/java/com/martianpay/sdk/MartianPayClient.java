package com.martianpay.sdk;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

/**
 * MartianPayClient is the main client for interacting with the MartianPay API
 */
public class MartianPayClient {
    private static final Logger logger = LoggerFactory.getLogger(MartianPayClient.class);
    private static final String DEFAULT_API_URL = "https://api.martianpay.com";
    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    private final String apiKey;
    private final String baseUrl;
    private final OkHttpClient httpClient;
    private final Gson gson;

    /**
     * Creates a new MartianPayClient with the given API key
     *
     * @param apiKey Your MartianPay API key
     */
    public MartianPayClient(String apiKey) {
        this(apiKey, DEFAULT_API_URL);
    }

    /**
     * Creates a new MartianPayClient with custom base URL
     *
     * @param apiKey  Your MartianPay API key
     * @param baseUrl Custom API base URL
     */
    public MartianPayClient(String apiKey, String baseUrl) {
        this.apiKey = apiKey;
        this.baseUrl = baseUrl;
        this.httpClient = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    /**
     * Common response wrapper for MartianPay API
     */
    public static class CommonResponse {
        private int code;
        private String error_code;
        private String msg;
        private JsonObject data;

        public int getCode() {
            return code;
        }

        public String getErrorCode() {
            return error_code;
        }

        public String getMsg() {
            return msg;
        }

        public JsonObject getData() {
            return data;
        }
    }

    /**
     * Sends an HTTP request to the MartianPay API
     *
     * @param method       HTTP method (GET, POST, DELETE, etc.)
     * @param path         API endpoint path
     * @param requestBody  Request body object (can be null for GET requests)
     * @param responseType Response type class
     * @param <T>          Response type
     * @return Parsed response object
     * @throws IOException if request fails
     */
    protected <T> T sendRequest(String method, String path, Object requestBody, Class<T> responseType) throws IOException {
        String url = baseUrl + path;
        Request.Builder requestBuilder = new Request.Builder().url(url);

        // Add authorization header
        String auth = apiKey + ":";
        String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes(StandardCharsets.UTF_8));
        requestBuilder.header("Authorization", "Basic " + encodedAuth);
        requestBuilder.header("Content-Type", "application/json");

        // Build request body
        RequestBody body = null;
        if (requestBody != null) {
            String jsonBody = gson.toJson(requestBody);
            body = RequestBody.create(jsonBody, JSON);
        }

        // Set HTTP method
        switch (method.toUpperCase()) {
            case "GET":
                requestBuilder.get();
                break;
            case "POST":
                requestBuilder.post(body != null ? body : RequestBody.create("", null));
                break;
            case "DELETE":
                requestBuilder.delete(body);
                break;
            case "PUT":
                requestBuilder.put(body != null ? body : RequestBody.create("", null));
                break;
            default:
                throw new IllegalArgumentException("Unsupported HTTP method: " + method);
        }

        Request request = requestBuilder.build();

        try (Response response = httpClient.newCall(request).execute()) {
            String responseBody = response.body() != null ? response.body().string() : "";

            // Check HTTP status code
            if (!response.isSuccessful()) {
                String statusText = getHTTPStatusText(response.code());
                if (!responseBody.isEmpty()) {
                    throw new IOException(String.format("HTTP %d %s: %s", response.code(), statusText, responseBody));
                }
                throw new IOException(String.format("HTTP %d %s", response.code(), statusText));
            }

            // Parse common response
            CommonResponse commonResponse = gson.fromJson(responseBody, CommonResponse.class);

            // Check for business-level errors
            if (commonResponse.getErrorCode() != null &&
                    !commonResponse.getErrorCode().isEmpty() &&
                    !"ok".equals(commonResponse.getErrorCode()) &&
                    !"success".equals(commonResponse.getErrorCode())) {
                throw new IOException(String.format("API error [%s]: %s",
                        commonResponse.getErrorCode(), commonResponse.getMsg()));
            }

            // Legacy: check deprecated Code field
            if (commonResponse.getCode() != 0) {
                throw new IOException("API error: " + commonResponse.getMsg());
            }

            // Parse data field
            if (responseType == Void.class || responseType == void.class) {
                return null;
            }

            return gson.fromJson(commonResponse.getData(), responseType);
        }
    }

    /**
     * Sends an HTTP GET request with query parameters
     *
     * @param path         API endpoint path
     * @param queryParams  Query parameters (can be null)
     * @param responseType Response type class
     * @param <T>          Response type
     * @return Parsed response object
     * @throws IOException if request fails
     */
    protected <T> T sendRequestWithQuery(String path, String queryParams, Class<T> responseType) throws IOException {
        String fullPath = queryParams != null && !queryParams.isEmpty() ? path + "?" + queryParams : path;
        return sendRequest("GET", fullPath, null, responseType);
    }

    /**
     * Returns human-readable text for HTTP status codes
     */
    private String getHTTPStatusText(int statusCode) {
        switch (statusCode) {
            case 400: return "Bad Request";
            case 401: return "Unauthorized";
            case 402: return "Payment Required";
            case 403: return "Forbidden";
            case 404: return "Not Found";
            case 405: return "Method Not Allowed";
            case 409: return "Conflict";
            case 422: return "Unprocessable Entity";
            case 429: return "Too Many Requests";
            case 500: return "Internal Server Error";
            case 502: return "Bad Gateway";
            case 503: return "Service Unavailable";
            case 504: return "Gateway Timeout";
            default:
                if (statusCode >= 400 && statusCode < 500) {
                    return "Client Error";
                } else if (statusCode >= 500) {
                    return "Server Error";
                }
                return "Unknown Status";
        }
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    protected Gson getGson() {
        return gson;
    }
}
