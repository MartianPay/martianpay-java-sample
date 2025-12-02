package com.martianpay.sdk;

import com.martianpay.model.PaymentIntent;
import com.martianpay.model.PaymentMethodCard;
import com.martianpay.sdk.CustomerService.CustomerCreateRequest;
import com.martianpay.sdk.CustomerService.CustomerListRequest;
import com.martianpay.sdk.CustomerService.CustomerListResponse;
import com.martianpay.sdk.CustomerService.CustomerPaymentMethodListResponse;
import com.martianpay.sdk.PaymentIntentService.PaymentIntentCancelRequest;
import com.martianpay.sdk.PaymentIntentService.PaymentIntentCreateRequest;
import com.martianpay.sdk.PaymentIntentService.PaymentIntentListRequest;
import com.martianpay.sdk.PaymentIntentService.PaymentIntentListResponse;
import com.martianpay.sdk.PaymentIntentService.PaymentIntentUpdateRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for PaymentIntentService
 *
 * Before running tests, update TestConfig.API_KEY with your actual API key.
 */
class PaymentIntentServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(PaymentIntentServiceTest.class);

    private PaymentIntentService paymentIntentService;
    private CustomerService customerService;

    @BeforeEach
    void setUp() {
        paymentIntentService = new PaymentIntentService(TestConfig.API_KEY);
        customerService = new CustomerService(TestConfig.API_KEY);
    }

    @Test
    void testCreateAndUpdatePaymentIntent() throws IOException {
        // This test demonstrates the API-only integration approach for crypto payments.
        //
        // INTEGRATION OPTIONS:
        // --------------------
        // Option 1 (Recommended): MartianPay.js Widget
        // - Use MartianPay.js widget on your frontend (https://docs.martianpay.com/v1/docs/martianpay-js-usage)
        // - After creating payment intent, display the widget with payment_intent.client_secret
        // - The widget handles payment method selection and automatically calls UpdatePaymentIntent API
        // - NO NEED to call UpdatePaymentIntent from your backend
        //
        // Option 2 (API-only): Direct Backend Integration (this test)
        // - Create payment intent via API
        // - Call UpdatePaymentIntent with crypto asset_id
        // - API returns deposit address
        // - Display deposit address to user for payment
        // - Listen to webhooks for payment confirmation

        logger.info("=== Test: Create and Update Payment Intent (Crypto) ===");

        // Step 1: Create a payment intent
        PaymentIntentCreateRequest createRequest = new PaymentIntentCreateRequest();
        createRequest.setAmount("10.00");
        createRequest.setCurrency("USD");
        createRequest.setMerchantOrderId("order_123");
        createRequest.setDescription("Test payment intent");

        PaymentIntent createResponse = paymentIntentService.createPaymentIntent(createRequest);

        assertNotNull(createResponse);
        assertNotNull(createResponse.getId());
        logger.info("Payment Intent Created: ID={}, Amount={}",
                createResponse.getId(), createResponse.getAmount());

        // Step 2: Update payment intent to specify crypto payment method
        // NOTE: Skip this step if using MartianPay.js widget (widget handles it automatically)
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

        assertNotNull(updateResponse);
        assertEquals(createResponse.getId(), updateResponse.getId());

        // Step 3: Extract deposit address from response
        // The API returns a unique deposit address for this payment
        // User sends crypto to this address to complete the payment
        if (updateResponse.getCharges() != null && !updateResponse.getCharges().isEmpty()) {
            logger.info("Crypto payment details - display deposit address to user");
            logger.info("  Payment Intent ID: {}", updateResponse.getId());

            if (updateResponse.getCharges().get(0).getPaymentMethodOptions() != null &&
                updateResponse.getCharges().get(0).getPaymentMethodOptions().getCrypto() != null) {
                logger.info("  Deposit Address: {}",
                        updateResponse.getCharges().get(0).getPaymentMethodOptions().getCrypto().getDepositAddress());
                logger.info("  Asset ID: {}",
                        updateResponse.getCharges().get(0).getPaymentMethodOptions().getCrypto().getAssetId());
                logger.info("  Network: {}",
                        updateResponse.getCharges().get(0).getPaymentMethodOptions().getCrypto().getNetwork());
                logger.info("  Amount: {}",
                        updateResponse.getCharges().get(0).getPaymentMethodOptions().getCrypto().getAmount());
            }
        }
    }

    @Test
    void testGetPaymentIntent() throws IOException {
        logger.info("=== Test: Get Payment Intent ===");

        // Replace with a valid payment intent ID
        String paymentIntentId = "pi_bLwFdNH862WcOwryK0ThCpHL";

        try {
            PaymentIntent response = paymentIntentService.getPaymentIntent(paymentIntentId);

            assertNotNull(response);
            assertEquals(paymentIntentId, response.getId());
            logger.info("Successfully retrieved payment intent: ID={}, Amount={}",
                    response.getId(), response.getAmount());
        } catch (IOException e) {
            logger.warn("Failed to get payment intent (may not exist): {}", e.getMessage());
        }
    }

    @Test
    void testListPaymentIntents() throws IOException {
        logger.info("=== Test: List Payment Intents ===");

        PaymentIntentListRequest request = new PaymentIntentListRequest();
        request.setPage(0);
        request.setPageSize(10);
        request.setCustomerEmail("user@example.com");

        PaymentIntentListResponse response = paymentIntentService.listPaymentIntents(request);

        assertNotNull(response);
        assertEquals(0, response.getPage());
        assertEquals(10, response.getPageSize());
        logger.info("Successfully retrieved payment intents: Total={}, Page={}, PageSize={}",
                response.getTotal(), response.getPage(), response.getPageSize());

        if (response.getPaymentIntents() != null) {
            for (PaymentIntent intent : response.getPaymentIntents()) {
                logger.info("Payment Intent: ID={}, Amount={}", intent.getId(), intent.getAmount());
            }
        }
    }

    @Test
    void testCancelPaymentIntent() throws IOException {
        logger.info("=== Test: Cancel Payment Intent ===");

        // First, create a payment intent to cancel
        PaymentIntentCreateRequest createRequest = new PaymentIntentCreateRequest();
        createRequest.setAmount("10.00");
        createRequest.setCurrency("USD");
        createRequest.setMerchantOrderId("order_cancel_test");
        createRequest.setDescription("Test payment intent for cancellation");

        PaymentIntent createResponse = paymentIntentService.createPaymentIntent(createRequest);
        assertNotNull(createResponse);
        logger.info("Created Payment Intent: {}", createResponse.getId());

        // Now cancel the payment intent
        PaymentIntentCancelRequest cancelRequest = new PaymentIntentCancelRequest();
        cancelRequest.setReason("Customer requested cancellation");

        PaymentIntent cancelResponse = paymentIntentService.cancelPaymentIntent(
                createResponse.getId(), cancelRequest);

        assertNotNull(cancelResponse);
        assertEquals("Cancelled", cancelResponse.getPaymentIntentStatus());
        logger.info("Successfully canceled payment intent: ID={}, Status={}, CanceledAt={}",
                cancelResponse.getId(), cancelResponse.getPaymentIntentStatus(),
                cancelResponse.getCanceledAt());
    }

    @Test
    void testListPaymentIntentsWithPermanentDeposit() throws IOException {
        logger.info("=== Test: List Payment Intents with Permanent Deposit ===");

        PaymentIntentListRequest request = new PaymentIntentListRequest();
        request.setPage(0);
        request.setPageSize(10);
        request.setPermanentDeposit(true);
        request.setPermanentDepositAssetId("USDC-Ethereum-TEST");

        PaymentIntentListResponse response = paymentIntentService.listPaymentIntents(request);

        assertNotNull(response);
        assertEquals(0, response.getPage());
        assertEquals(10, response.getPageSize());
        logger.info("Successfully retrieved payment intents with permanent deposit filter: Total={}",
                response.getTotal());

        if (response.getPaymentIntents() != null) {
            for (PaymentIntent intent : response.getPaymentIntents()) {
                logger.info("Payment Intent: ID={}, Amount={}, PermanentDeposit={}, AssetId={}",
                        intent.getId(), intent.getAmount(),
                        intent.getPermanentDeposit(), intent.getPermanentDepositAssetId());
            }
        }
    }

    @Test
    void testFiatPaymentWithNewCard() throws IOException {
        // This test demonstrates two integration approaches for card payments:
        //
        // APPROACH 1 (Recommended): MartianPay.js Integration
        // -------------------------------------------------------
        // After creating a payment intent, use MartianPay.js on the frontend:
        // - Documentation: https://docs.martianpay.com/v1/docs/martianpay-js-usage
        // - The frontend widget handles payment method selection (cards or crypto)
        // - The widget automatically calls the update payment intent API
        // - No need to manually call UpdatePaymentIntent from backend
        //
        // APPROACH 2 (API-only): Direct API Integration (demonstrated in this test)
        // -------------------------------------------------------------------------
        // If you don't use MartianPay.js, you need to handle everything via API:
        //
        // For CRYPTO payments:
        // - Call UpdatePaymentIntent with crypto asset_id
        // - API returns deposit address for the selected crypto
        // - Display the address to user for payment
        //
        // For CARD payments (this test):
        // - Call UpdatePaymentIntent with cards payment method
        // - API returns stripe_payload (client_secret, public_key)
        // - Use Stripe.js on frontend to complete payment with the client_secret
        // - Integration guide: https://stripe.com/docs/payments/accept-a-payment
        //
        // Stripe Integration Flow:
        // 1. Backend: Create payment intent via MartianPay API
        // 2. Backend: Call UpdatePaymentIntent with cards payment method
        // 3. Backend: Get stripe_payload from response (client_secret, public_key)
        // 4. Frontend: Initialize Stripe.js with public_key
        // 5. Frontend: Use Stripe Elements to collect card details
        // 6. Frontend: Call stripe.confirmCardPayment(client_secret) with card details
        // 7. Stripe: Processes the payment and returns result
        // 8. MartianPay: Receives webhook from Stripe and updates payment intent status

        logger.info("=== Test: Fiat Payment with New Card ===");

        // Step 1: Query or create a customer
        String email = "fiat_test@example.com";
        CustomerListRequest listCustomerRequest = new CustomerListRequest();
        listCustomerRequest.setPage(0);
        listCustomerRequest.setPageSize(10);
        listCustomerRequest.setEmail(email);

        CustomerListResponse listResponse = customerService.listCustomers(listCustomerRequest);
        assertNotNull(listResponse);

        String customerId;
        if (listResponse.getCustomers() != null && !listResponse.getCustomers().isEmpty()) {
            customerId = listResponse.getCustomers().get(0).getId();
            logger.info("Using existing customer: {}", customerId);
        } else {
            CustomerCreateRequest createCustomerRequest = new CustomerCreateRequest();
            createCustomerRequest.setEmail(email);
            createCustomerRequest.setName("Fiat Test Customer");

            customerId = customerService.createCustomer(createCustomerRequest).getId();
            logger.info("Created new customer: {}", customerId);
        }

        // Step 2: Create a payment intent
        PaymentIntentCreateRequest createPIRequest = new PaymentIntentCreateRequest();
        createPIRequest.setAmount("25.00");
        createPIRequest.setCurrency("USD");
        createPIRequest.setMerchantOrderId("order_fiat_new_card");
        createPIRequest.setDescription("Test fiat payment with new card");
        createPIRequest.setCustomer(customerId);

        PaymentIntent piResponse = paymentIntentService.createPaymentIntent(createPIRequest);
        assertNotNull(piResponse);
        logger.info("Created payment intent for fiat payment: ID={}, Amount={}, Currency={}",
                piResponse.getId(), piResponse.getAmount(), piResponse.getCurrency());

        // Step 3: Update payment intent with cards payment method
        // This triggers MartianPay to prepare Stripe payment and return stripe_payload
        PaymentIntentUpdateRequest updatePIRequest = new PaymentIntentUpdateRequest();
        updatePIRequest.setId(piResponse.getId());
        updatePIRequest.setPaymentMethodType("cards");

        PaymentIntentUpdateRequest.PaymentMethodOptions options =
                new PaymentIntentUpdateRequest.PaymentMethodOptions();
        PaymentIntentUpdateRequest.FiatOptions fiatOptions =
                new PaymentIntentUpdateRequest.FiatOptions();
        fiatOptions.setCurrency("USD");
        fiatOptions.setSavePaymentMethod(true); // Save the card for future use
        options.setFiat(fiatOptions);
        updatePIRequest.setPaymentMethodOptions(options);

        try {
            PaymentIntent updateResponse = paymentIntentService.updatePaymentIntent(updatePIRequest);
            assertNotNull(updateResponse);
            logger.info("Updated payment intent with fiat payment method: Status={}",
                    updateResponse.getStatus());

            // Step 4: Extract and display stripe_payload
            // The API returns stripe_payload containing:
            // - client_secret: Used by Stripe.js to confirm payment on frontend
            // - public_key: Stripe publishable key for initializing Stripe.js
            // - customer_id: Stripe customer ID (if SavePaymentMethod is true)
            if (updateResponse.getCharges() != null && !updateResponse.getCharges().isEmpty()) {
                for (int i = 0; i < updateResponse.getCharges().size(); i++) {
                    if (updateResponse.getCharges().get(i).getStripePayload() != null) {
                        logger.info("Stripe payload details - use these values for frontend integration:");
                        logger.info("  Charge Index: {}", i);
                        logger.info("  Charge ID: {}", updateResponse.getCharges().get(i).getId());
                        logger.info("  Client Secret: {}",
                                updateResponse.getCharges().get(i).getStripePayload().getClientSecret());
                        logger.info("  Public Key: {}",
                                updateResponse.getCharges().get(i).getStripePayload().getPublicKey());
                        logger.info("  Status: {}",
                                updateResponse.getCharges().get(i).getStripePayload().getStatus());
                        logger.info("  Customer ID: {}",
                                updateResponse.getCharges().get(i).getStripePayload().getCustomerId());
                        logger.info("  Payment Provider: {}",
                                updateResponse.getCharges().get(i).getPaymentProvider());

                        // Frontend integration example (not executable in test):
                        logger.info("Frontend integration example:");
                        logger.info("  const stripe = Stripe('{}');",
                                updateResponse.getCharges().get(i).getStripePayload().getPublicKey());
                        logger.info("  const {{error}} = await stripe.confirmCardPayment('{}', {{",
                                updateResponse.getCharges().get(i).getStripePayload().getClientSecret());
                        logger.info("    payment_method: {{");
                        logger.info("      card: cardElement,");
                        logger.info("      billing_details: {{ name: 'Customer Name' }}");
                        logger.info("    }}");
                        logger.info("  }});");
                    }
                }
            }
        } catch (IOException e) {
            logger.warn("Payment intent update failed (expected in test without Stripe setup): {}",
                    e.getMessage());
        }
    }

    @Test
    void testFiatPaymentWithSavedCard() throws IOException {
        // This test demonstrates charging a saved card (previously saved payment method).
        //
        // INTEGRATION OPTIONS:
        // --------------------
        // Option 1 (Recommended): MartianPay.js Widget
        // - Use MartianPay.js widget on your frontend (https://docs.martianpay.com/v1/docs/martianpay-js-usage)
        // - After creating payment intent, display the widget with payment_intent.client_secret
        // - The widget shows saved payment methods and handles payment automatically
        // - NO NEED to call UpdatePaymentIntent from your backend
        //
        // Option 2 (API-only): Direct Backend Integration (this test)
        // - List customer's saved payment methods
        // - Create payment intent
        // - Call UpdatePaymentIntent with saved payment_method_id
        // - Payment is processed immediately with the saved card

        logger.info("=== Test: Fiat Payment with Saved Card ===");

        // Step 1: Use an existing customer with saved cards
        // In a real scenario, this customer would already have payment methods saved
        String customerId = "cus_7Xpxk2n22WAEBDaBVlG5dnRf"; // Replace with actual customer ID

        try {
            // Step 2: List customer's saved payment methods
            CustomerPaymentMethodListResponse pmListResponse =
                    customerService.listCustomerPaymentMethods(customerId);

            assertNotNull(pmListResponse);
            if (pmListResponse.getPaymentMethods() == null ||
                pmListResponse.getPaymentMethods().isEmpty()) {
                logger.warn("No saved payment methods found for customer - skipping test");
                return;
            }

            // Log saved cards
            for (PaymentMethodCard pm : pmListResponse.getPaymentMethods()) {
                logger.info("Saved payment method: ID={}, Brand={}, Last4={}, Exp={}/{}",
                        pm.getId(), pm.getBrand(), pm.getLast4(), pm.getExpMonth(), pm.getExpYear());
            }

            // Step 3: Create a payment intent
            PaymentIntentCreateRequest createPIRequest = new PaymentIntentCreateRequest();
            createPIRequest.setAmount("15.00");
            createPIRequest.setCurrency("USD");
            createPIRequest.setMerchantOrderId("order_fiat_saved_card");
            createPIRequest.setDescription("Test fiat payment with saved card");
            createPIRequest.setCustomer(customerId);

            PaymentIntent piResponse = paymentIntentService.createPaymentIntent(createPIRequest);
            assertNotNull(piResponse);
            logger.info("Created payment intent for saved card payment: ID={}, Amount={}",
                    piResponse.getId(), piResponse.getAmount());

            // Step 4: Update payment intent with saved card
            // NOTE: Skip this step if using MartianPay.js widget (widget handles it automatically)
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
            assertNotNull(updateResponse);
            logger.info("Successfully charged saved card - payment processed immediately: ID={}, Status={}",
                    updateResponse.getId(), updateResponse.getStatus());

        } catch (IOException e) {
            logger.warn("Failed to list payment methods or charge saved card: {}", e.getMessage());
        }
    }
}
