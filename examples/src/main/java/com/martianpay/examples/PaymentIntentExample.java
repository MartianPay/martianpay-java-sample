package com.martianpay.examples;

import com.martianpay.model.Customer;
import com.martianpay.model.PaymentIntent;
import com.martianpay.model.PaymentMethodCard;
import com.martianpay.sdk.CustomerService;
import com.martianpay.sdk.CustomerService.CustomerCreateRequest;
import com.martianpay.sdk.CustomerService.CustomerListRequest;
import com.martianpay.sdk.CustomerService.CustomerListResponse;
import com.martianpay.sdk.CustomerService.CustomerPaymentMethodListResponse;
import com.martianpay.sdk.PaymentIntentService;
import com.martianpay.sdk.PaymentIntentService.PaymentIntentCancelRequest;
import com.martianpay.sdk.PaymentIntentService.PaymentIntentCreateRequest;
import com.martianpay.sdk.PaymentIntentService.PaymentIntentListRequest;
import com.martianpay.sdk.PaymentIntentService.PaymentIntentListResponse;
import com.martianpay.sdk.PaymentIntentService.PaymentIntentUpdateRequest;

import java.io.IOException;
import java.util.Scanner;

/**
 * Payment Intent Examples
 *
 * This class demonstrates how to use the PaymentIntentService for various payment operations.
 */
public class PaymentIntentExample {

    private final PaymentIntentService paymentIntentService;
    private final CustomerService customerService;
    private final Scanner scanner;

    public PaymentIntentExample() {
        this.paymentIntentService = new PaymentIntentService(Common.API_KEY);
        this.customerService = new CustomerService(Common.API_KEY);
        this.scanner = new Scanner(System.in);
    }

    /**
     * Creates and updates a payment intent with crypto payment method.
     */
    public void createAndUpdatePaymentIntent() {
        System.out.println("Creating and Updating Payment Intent (Crypto)...");

        try {
            // Step 1: Create payment intent
            PaymentIntentCreateRequest createRequest = new PaymentIntentCreateRequest();
            createRequest.setAmount("10.00");
            createRequest.setCurrency("USD");
            createRequest.setMerchantOrderId("order_123");
            createRequest.setDescription("Test payment intent");

            PaymentIntent createResponse = paymentIntentService.createPaymentIntent(createRequest);

            System.out.println("✓ Step 1 - Payment Intent Created:");
            System.out.println("  ID: " + createResponse.getId());
            System.out.println("  Amount: " + createResponse.getAmount());
            System.out.println("  Currency: " + createResponse.getCurrency());
            System.out.println("  Status: " + createResponse.getStatus());
            System.out.println();

            // Step 2: Update with crypto payment method
            PaymentIntentUpdateRequest updateRequest = new PaymentIntentUpdateRequest();
            updateRequest.setId(createResponse.getId());
            updateRequest.setPaymentMethodType("crypto");

            PaymentIntentUpdateRequest.PaymentMethodOptions options =
                    new PaymentIntentUpdateRequest.PaymentMethodOptions();
            PaymentIntentUpdateRequest.CryptoOptions cryptoOptions =
                    new PaymentIntentUpdateRequest.CryptoOptions();
            cryptoOptions.setAssetId("USDC-Ethereum-TEST");
            options.setCrypto(cryptoOptions);
            updateRequest.setPaymentMethodOptions(options);

            PaymentIntent updateResponse = paymentIntentService.updatePaymentIntent(updateRequest);

            System.out.println("✓ Step 2 - Payment Intent Updated (Crypto Payment Details):");
            if (updateResponse.getCharges() != null && !updateResponse.getCharges().isEmpty() &&
                updateResponse.getCharges().get(0).getPaymentMethodOptions() != null &&
                updateResponse.getCharges().get(0).getPaymentMethodOptions().getCrypto() != null) {
                System.out.println("  Deposit Address: " +
                        updateResponse.getCharges().get(0).getPaymentMethodOptions().getCrypto().getDepositAddress());
                System.out.println("  Asset ID: " +
                        updateResponse.getCharges().get(0).getPaymentMethodOptions().getCrypto().getAssetId());
                System.out.println("  Network: " +
                        updateResponse.getCharges().get(0).getPaymentMethodOptions().getCrypto().getNetwork());
                System.out.println("  Amount: " +
                        updateResponse.getCharges().get(0).getPaymentMethodOptions().getCrypto().getAmount());
            }

        } catch (IOException e) {
            System.out.println("✗ API Error: " + e.getMessage());
        }
    }

    /**
     * Retrieves a payment intent by ID.
     */
    public void getPaymentIntent() {
        System.out.println("Getting Payment Intent...");
        System.out.print("Enter Payment Intent ID: ");

        String id = scanner.nextLine().trim();
        if (id.isEmpty()) {
            id = "pi_example_id";
        }

        try {
            PaymentIntent response = paymentIntentService.getPaymentIntent(id);

            System.out.println("✓ Payment Intent Retrieved:");
            System.out.println("  ID: " + response.getId());
            System.out.println("  Amount: " + response.getAmount());
            System.out.println("  Currency: " + response.getCurrency());
            System.out.println("  Status: " + response.getStatus());
        } catch (IOException e) {
            System.out.println("✗ API Error: " + e.getMessage());
        }
    }

    /**
     * Lists payment intents with pagination.
     */
    public void listPaymentIntents() {
        System.out.println("Listing Payment Intents...");

        PaymentIntentListRequest request = new PaymentIntentListRequest();
        request.setPage(0);
        request.setPageSize(10);
        request.setCustomerEmail("user@example.com");

        try {
            PaymentIntentListResponse response = paymentIntentService.listPaymentIntents(request);

            System.out.println("✓ Total Records: " + response.getTotal());
            System.out.println("  Page: " + response.getPage() + ", Page Size: " + response.getPageSize());
            System.out.println();

            if (response.getPaymentIntents() != null) {
                for (int i = 0; i < response.getPaymentIntents().size(); i++) {
                    PaymentIntent intent = response.getPaymentIntents().get(i);
                    System.out.println("  [" + (i + 1) + "] ID: " + intent.getId() +
                            ", Amount: " + intent.getAmount());
                }
            }
        } catch (IOException e) {
            System.out.println("✗ API Error: " + e.getMessage());
        }
    }

    /**
     * Cancels a payment intent.
     */
    public void cancelPaymentIntent() {
        System.out.println("Canceling Payment Intent...");

        try {
            // First create a payment intent to cancel
            PaymentIntentCreateRequest createRequest = new PaymentIntentCreateRequest();
            createRequest.setAmount("10.00");
            createRequest.setCurrency("USD");
            createRequest.setMerchantOrderId("order_cancel_test");
            createRequest.setDescription("Test payment intent for cancellation");

            PaymentIntent createResponse = paymentIntentService.createPaymentIntent(createRequest);
            System.out.println("  Created Payment Intent: " + createResponse.getId());

            // Cancel it
            PaymentIntentCancelRequest cancelRequest = new PaymentIntentCancelRequest();
            cancelRequest.setReason("Customer requested cancellation");

            PaymentIntent cancelResponse = paymentIntentService.cancelPaymentIntent(
                    createResponse.getId(), cancelRequest);

            System.out.println("✓ Payment Intent Canceled:");
            System.out.println("  ID: " + cancelResponse.getId());
            System.out.println("  Status: " + cancelResponse.getPaymentIntentStatus());
            System.out.println("  Canceled At: " + cancelResponse.getCanceledAt());

        } catch (IOException e) {
            System.out.println("✗ API Error: " + e.getMessage());
        }
    }

    /**
     * Lists payment intents with permanent deposit filter.
     */
    public void listPaymentIntentsWithPermanentDeposit() {
        System.out.println("Listing Payment Intents with Permanent Deposit...");

        PaymentIntentListRequest request = new PaymentIntentListRequest();
        request.setPage(0);
        request.setPageSize(10);
        request.setPermanentDeposit(true);
        request.setPermanentDepositAssetId("USDC-Ethereum-TEST");

        try {
            PaymentIntentListResponse response = paymentIntentService.listPaymentIntents(request);

            System.out.println("✓ Total Records: " + response.getTotal());
            System.out.println();

            if (response.getPaymentIntents() != null) {
                for (int i = 0; i < response.getPaymentIntents().size(); i++) {
                    PaymentIntent intent = response.getPaymentIntents().get(i);
                    System.out.println("  [" + (i + 1) + "] ID: " + intent.getId() +
                            ", Permanent Deposit: " + intent.getPermanentDeposit() +
                            ", Asset: " + intent.getPermanentDepositAssetId());
                }
            }
        } catch (IOException e) {
            System.out.println("✗ API Error: " + e.getMessage());
        }
    }

    /**
     * Demonstrates fiat payment with a new card using Stripe integration.
     */
    public void fiatPaymentWithNewCard() {
        System.out.println("Fiat Payment with New Card...");
        System.out.println("Note: This example shows the API-only approach with Stripe integration");

        try {
            // Step 1: Query or create customer
            String email = "fiat_test@example.com";
            CustomerListRequest listCustomerRequest = new CustomerListRequest();
            listCustomerRequest.setPage(0);
            listCustomerRequest.setPageSize(10);
            listCustomerRequest.setEmail(email);

            CustomerListResponse listResponse = customerService.listCustomers(listCustomerRequest);

            String customerId;
            if (listResponse.getCustomers() != null && !listResponse.getCustomers().isEmpty()) {
                customerId = listResponse.getCustomers().get(0).getId();
                System.out.println("✓ Step 1 - Using existing customer: " + customerId);
            } else {
                CustomerCreateRequest createCustomerRequest = new CustomerCreateRequest();
                createCustomerRequest.setEmail(email);
                createCustomerRequest.setName("Fiat Test Customer");

                Customer customer = customerService.createCustomer(createCustomerRequest);
                customerId = customer.getId();
                System.out.println("✓ Step 1 - Created new customer: " + customerId);
            }

            // Step 2: Create payment intent
            PaymentIntentCreateRequest createPIRequest = new PaymentIntentCreateRequest();
            createPIRequest.setAmount("25.00");
            createPIRequest.setCurrency("USD");
            createPIRequest.setMerchantOrderId("order_fiat_new_card");
            createPIRequest.setDescription("Test fiat payment with new card");
            createPIRequest.setCustomer(customerId);

            PaymentIntent piResponse = paymentIntentService.createPaymentIntent(createPIRequest);

            System.out.println("\n✓ Step 2 - Payment Intent Created:");
            System.out.println("  ID: " + piResponse.getId());
            System.out.println("  Amount: " + piResponse.getAmount());
            System.out.println("  Currency: " + piResponse.getCurrency());

            // Step 3: Update with cards payment method
            PaymentIntentUpdateRequest updatePIRequest = new PaymentIntentUpdateRequest();
            updatePIRequest.setId(piResponse.getId());
            updatePIRequest.setPaymentMethodType("cards");

            PaymentIntentUpdateRequest.PaymentMethodOptions options =
                    new PaymentIntentUpdateRequest.PaymentMethodOptions();
            PaymentIntentUpdateRequest.FiatOptions fiatOptions =
                    new PaymentIntentUpdateRequest.FiatOptions();
            fiatOptions.setCurrency("USD");
            fiatOptions.setSavePaymentMethod(true);
            options.setFiat(fiatOptions);
            updatePIRequest.setPaymentMethodOptions(options);

            PaymentIntent updateResponse = paymentIntentService.updatePaymentIntent(updatePIRequest);

            System.out.println("\n✓ Step 3 - Payment Intent Updated with Card Payment Method");
            System.out.println("  Status: " + updateResponse.getStatus());

            if (updateResponse.getCharges() != null && !updateResponse.getCharges().isEmpty()) {
                for (int i = 0; i < updateResponse.getCharges().size(); i++) {
                    if (updateResponse.getCharges().get(i).getStripePayload() != null) {
                        System.out.println("\n  Stripe Payload Details (Charge " + i + "):");
                        System.out.println("  ────────────────────────────────────────────");
                        System.out.println("  Client Secret: " +
                                updateResponse.getCharges().get(i).getStripePayload().getClientSecret());
                        System.out.println("  Public Key: " +
                                updateResponse.getCharges().get(i).getStripePayload().getPublicKey());
                        System.out.println("  ────────────────────────────────────────────");
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("✗ API Error: " + e.getMessage());
        }
    }

    /**
     * Demonstrates fiat payment with a saved card.
     */
    public void fiatPaymentWithSavedCard() {
        System.out.println("Fiat Payment with Saved Card...");
        System.out.print("Enter Customer ID (or press Enter for demo): ");

        String customerId = scanner.nextLine().trim();
        if (customerId.isEmpty()) {
            customerId = "cus_7Xpxk2n22WAEBDaBVlG5dnRf";
        }

        try {
            // Step 1: List customer's saved payment methods
            CustomerPaymentMethodListResponse pmListResponse =
                    customerService.listCustomerPaymentMethods(customerId);

            if (pmListResponse.getPaymentMethods() == null ||
                pmListResponse.getPaymentMethods().isEmpty()) {
                System.out.println("  No saved payment methods found");
                return;
            }

            System.out.println("✓ Found " + pmListResponse.getPaymentMethods().size() +
                    " saved payment method(s)");
            for (int i = 0; i < pmListResponse.getPaymentMethods().size(); i++) {
                PaymentMethodCard pm = pmListResponse.getPaymentMethods().get(i);
                System.out.println("  [" + (i + 1) + "] " + pm.getBrand() + " ending in " +
                        pm.getLast4() + " (expires " + pm.getExpMonth() + "/" + pm.getExpYear() + ")");
            }

            // Step 2: Create payment intent
            PaymentIntentCreateRequest createPIRequest = new PaymentIntentCreateRequest();
            createPIRequest.setAmount("15.00");
            createPIRequest.setCurrency("USD");
            createPIRequest.setMerchantOrderId("order_fiat_saved_card");
            createPIRequest.setDescription("Test fiat payment with saved card");
            createPIRequest.setCustomer(customerId);

            PaymentIntent piResponse = paymentIntentService.createPaymentIntent(createPIRequest);
            System.out.println("\n✓ Payment Intent Created: " + piResponse.getId());

            // Step 3: Update with saved card
            String savedPaymentMethodId = pmListResponse.getPaymentMethods().get(0).getId();

            PaymentIntentUpdateRequest updatePIRequest = new PaymentIntentUpdateRequest();
            updatePIRequest.setId(piResponse.getId());
            updatePIRequest.setPaymentMethodType("cards");

            PaymentIntentUpdateRequest.PaymentMethodOptions options =
                    new PaymentIntentUpdateRequest.PaymentMethodOptions();
            PaymentIntentUpdateRequest.FiatOptions fiatOptions =
                    new PaymentIntentUpdateRequest.FiatOptions();
            fiatOptions.setCurrency("USD");
            fiatOptions.setPaymentMethodId(savedPaymentMethodId);
            options.setFiat(fiatOptions);
            updatePIRequest.setPaymentMethodOptions(options);

            PaymentIntent updateResponse = paymentIntentService.updatePaymentIntent(updatePIRequest);

            System.out.println("\n✓ Step 3 - Payment Processed with Saved Card:");
            System.out.println("  Payment Intent ID: " + updateResponse.getId());
            System.out.println("  Status: " + updateResponse.getStatus());

        } catch (IOException e) {
            System.out.println("✗ API Error: " + e.getMessage());
        }
    }
}
