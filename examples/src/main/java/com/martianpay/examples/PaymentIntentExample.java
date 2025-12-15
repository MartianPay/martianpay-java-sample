package com.martianpay.examples;

import com.martianpay.developer.*;
import com.martianpay.sdk.CustomerService;
import com.martianpay.sdk.PaymentIntentService;
import com.martianpay.sdk.PaymentLinkService;
import com.martianpay.sdk.MartianPayClient;

import java.io.IOException;
import java.util.*;

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
        this.paymentIntentService = new PaymentIntentService(Common.currentAPIKey);
        this.customerService = new CustomerService(Common.currentAPIKey);
        this.scanner = new Scanner(System.in);
    }

    /**
     * Generates a unique merchant order ID with timestamp and random number
     */
    private String generateOrderID(String prefix) {
        long timestamp = System.currentTimeMillis() / 1000;
        int randomNum = (int) (Math.random() * 1000000);
        return String.format("%s_%d_%d", prefix, timestamp, randomNum);
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
            createRequest.setMerchantOrderId(generateOrderID("order"));
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
            updateRequest.setPaymentMethodType("crypto");

            PaymentMethodConfirmOptions options = new PaymentMethodConfirmOptions();
            CryptoOption cryptoOption = new CryptoOption();
            cryptoOption.setAssetId("USDC-Ethereum-TEST");
            options.setCrypto(cryptoOption);
            updateRequest.setPaymentMethodData(options);

            PaymentIntent updateResponse = paymentIntentService.updatePaymentIntent(createResponse.getId(), updateRequest);

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
            createRequest.setMerchantOrderId(generateOrderID("order_cancel"));
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
            createPIRequest.setMerchantOrderId(generateOrderID("order_fiat_new_card"));
            createPIRequest.setDescription("Test fiat payment with new card");
            createPIRequest.setCustomer(customerId);

            PaymentIntent piResponse = paymentIntentService.createPaymentIntent(createPIRequest);

            System.out.println("\n✓ Step 2 - Payment Intent Created:");
            System.out.println("  ID: " + piResponse.getId());
            System.out.println("  Amount: " + piResponse.getAmount());
            System.out.println("  Currency: " + piResponse.getCurrency());

            // Step 3: Update with cards payment method
            PaymentIntentUpdateRequest updatePIRequest = new PaymentIntentUpdateRequest();
            updatePIRequest.setPaymentMethodType("cards");

            PaymentMethodConfirmOptions options = new PaymentMethodConfirmOptions();
            FiatOption fiatOption = new FiatOption();
            fiatOption.setCurrency("USD");
            fiatOption.setSavePaymentMethod(true);
            options.setFiat(fiatOption);
            updatePIRequest.setPaymentMethodData(options);

            PaymentIntent updateResponse = paymentIntentService.updatePaymentIntent(piResponse.getId(), updatePIRequest);

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
            PaymentMethodListResponse pmListResponse =
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
            createPIRequest.setMerchantOrderId(generateOrderID("order_fiat_saved_card"));
            createPIRequest.setDescription("Test fiat payment with saved card");
            createPIRequest.setCustomer(customerId);

            PaymentIntent piResponse = paymentIntentService.createPaymentIntent(createPIRequest);
            System.out.println("\n✓ Payment Intent Created: " + piResponse.getId());

            // Step 3: Update with saved card
            String savedPaymentMethodId = pmListResponse.getPaymentMethods().get(0).getId();

            PaymentIntentUpdateRequest updatePIRequest = new PaymentIntentUpdateRequest();
            updatePIRequest.setPaymentMethodType("cards");

            PaymentMethodConfirmOptions options = new PaymentMethodConfirmOptions();
            FiatOption fiatOption = new FiatOption();
            fiatOption.setCurrency("USD");
            fiatOption.setPaymentMethodId(savedPaymentMethodId);
            options.setFiat(fiatOption);
            updatePIRequest.setPaymentMethodData(options);

            PaymentIntent updateResponse = paymentIntentService.updatePaymentIntent(piResponse.getId(), updatePIRequest);

            System.out.println("\n✓ Step 3 - Payment Processed with Saved Card:");
            System.out.println("  Payment Intent ID: " + updateResponse.getId());
            System.out.println("  Status: " + updateResponse.getStatus());

        } catch (IOException e) {
            System.out.println("✗ API Error: " + e.getMessage());
        }
    }

    /**
     * Creates a payment intent using a payment link with variant and subscription
     */
    public static void createPaymentIntentWithPaymentLink(MartianPayClient client) {
        Scanner scanner = new Scanner(System.in);
        PaymentLinkService paymentLinkService = client.getPaymentLinkService();
        PaymentIntentService paymentIntentService = client.getPaymentIntentService();
        CustomerService customerService = client.getCustomerService();

        System.out.println("Creating Payment Intent with Payment Link...");
        System.out.println("This example creates a payment intent from a payment link with variant and subscription");

        try {
            // Step 1: List payment links
            System.out.println("\n  Step 1 - Fetching payment links...");
            PaymentLinkListRequest plReq = new PaymentLinkListRequest();
            plReq.setPage(0);
            plReq.setPageSize(10);

            PaymentLinkListResponse plResp = paymentLinkService.listPaymentLinks(plReq);

            if (plResp.getPaymentLinks() == null || plResp.getPaymentLinks().isEmpty()) {
                System.out.println("✗ No payment links found. Please create one first.");
                return;
            }

            // Categorize payment links
            List<PaymentLink> withSellingPlan = new ArrayList<>();
            List<PaymentLink> withoutSellingPlan = new ArrayList<>();

            for (PaymentLink link : plResp.getPaymentLinks()) {
                boolean hasSellingPlan = false;
                if (link.getProduct() != null && link.getProduct().getSellingPlanGroups() != null
                    && !link.getProduct().getSellingPlanGroups().isEmpty()) {
                    hasSellingPlan = true;
                }

                if (hasSellingPlan) {
                    withSellingPlan.add(link);
                } else {
                    withoutSellingPlan.add(link);
                }
            }

            System.out.println("\n  Available Payment Links:");

            // Display with selling plans first
            if (!withSellingPlan.isEmpty()) {
                System.out.println("\n  With Subscription Plans:");
                for (int i = 0; i < withSellingPlan.size(); i++) {
                    PaymentLink link = withSellingPlan.get(i);
                    System.out.printf("  [%d] ", i + 1);
                    if (link.getProduct() != null) {
                        System.out.print(link.getProduct().getName());
                    }
                    System.out.printf(" (ID: %s)%n", link.getId());
                    if (link.getPriceRange() != null && link.getPriceRange().getMin() != null) {
                        System.out.printf("      Price: %s", link.getPriceRange().getMin());
                        if (link.getPriceRange().getMax() != null &&
                            !link.getPriceRange().getMax().getAmount().equals(link.getPriceRange().getMin().getAmount())) {
                            System.out.printf(" - %s", link.getPriceRange().getMax());
                        }
                        System.out.println();
                    }
                    if (link.getProduct() != null && link.getProduct().getSellingPlanGroups() != null) {
                        System.out.printf("      Plans: %d selling plan group(s)%n",
                            link.getProduct().getSellingPlanGroups().size());
                    }
                }
            }

            // Display without selling plans
            if (!withoutSellingPlan.isEmpty()) {
                System.out.println("\n  One-Time Payment:");
                int startIdx = withSellingPlan.size();
                for (int i = 0; i < withoutSellingPlan.size(); i++) {
                    PaymentLink link = withoutSellingPlan.get(i);
                    System.out.printf("  [%d] ", startIdx + i + 1);
                    if (link.getProduct() != null) {
                        System.out.print(link.getProduct().getName());
                    }
                    System.out.printf(" (ID: %s)%n", link.getId());
                    if (link.getPriceRange() != null && link.getPriceRange().getMin() != null) {
                        System.out.printf("      Price: %s", link.getPriceRange().getMin());
                        if (link.getPriceRange().getMax() != null &&
                            !link.getPriceRange().getMax().getAmount().equals(link.getPriceRange().getMin().getAmount())) {
                            System.out.printf(" - %s", link.getPriceRange().getMax());
                        }
                        System.out.println();
                    }
                }
            }

            // Rebuild full list in display order
            List<PaymentLink> allLinks = new ArrayList<>();
            allLinks.addAll(withSellingPlan);
            allLinks.addAll(withoutSellingPlan);

            System.out.print("\nEnter payment link number (or press Enter for first): ");
            String linkChoice = scanner.nextLine().trim();

            int selectedIdx = 0;
            if (!linkChoice.isEmpty()) {
                try {
                    int idx = Integer.parseInt(linkChoice);
                    if (idx > 0 && idx <= allLinks.size()) {
                        selectedIdx = idx - 1;
                    }
                } catch (NumberFormatException e) {
                    // Use default
                }
            }

            PaymentLink selectedLink = allLinks.get(selectedIdx);
            System.out.println("  Selected: " + selectedLink.getId());

            // Step 2: Get payment link details
            System.out.println("\n  Step 2 - Getting payment link details...");
            PaymentLink linkDetails = paymentLinkService.getPaymentLink(selectedLink.getId());

            if (linkDetails.getPrimaryVariants() == null || linkDetails.getPrimaryVariants().isEmpty()) {
                System.out.println("✗ No variants found in this payment link");
                return;
            }

            // Step 3: Select variant
            System.out.println("\n  Available Variants:");
            for (int i = 0; i < linkDetails.getPrimaryVariants().size(); i++) {
                PaymentLinkVariant pv = linkDetails.getPrimaryVariants().get(i);
                System.out.printf("  [%d] Variant ID: %s%n", i + 1, pv.getVariantID());
                if (pv.getVariant() != null) {
                    System.out.print("      Options: ");
                    if (pv.getVariant().getOptionValues() != null) {
                        for (Map.Entry<String, String> entry : pv.getVariant().getOptionValues().entrySet()) {
                            System.out.printf("%s=%s ", entry.getKey(), entry.getValue());
                        }
                    }
                    System.out.println();
                    if (pv.getVariant().getPrice() != null) {
                        System.out.printf("      Price: %s%n", pv.getVariant().getPrice());
                    }
                }
            }

            System.out.print("\nEnter variant number (or press Enter for first): ");
            String variantChoice = scanner.nextLine().trim();

            int selectedVariantIdx = 0;
            if (!variantChoice.isEmpty()) {
                try {
                    int idx = Integer.parseInt(variantChoice);
                    if (idx > 0 && idx <= linkDetails.getPrimaryVariants().size()) {
                        selectedVariantIdx = idx - 1;
                    }
                } catch (NumberFormatException e) {
                    // Use default
                }
            }

            PaymentLinkVariant selectedVariant = linkDetails.getPrimaryVariants().get(selectedVariantIdx);
            System.out.println("  Selected Variant: " + selectedVariant.getVariantID());

            // Step 4: Check for selling plans
            String sellingPlanID = null;
            if (linkDetails.getProduct() != null && linkDetails.getProduct().getSellingPlanGroups() != null
                && !linkDetails.getProduct().getSellingPlanGroups().isEmpty()) {
                System.out.println("\n  This product has selling plans (subscriptions)");

                List<Map<String, Object>> allPlans = new ArrayList<>();

                for (SellingPlanGroupWithPlans spg : linkDetails.getProduct().getSellingPlanGroups()) {
                    System.out.println("\n  Selling Plan Group: " + spg.getName());
                    if (spg.getSellingPlans() != null) {
                        for (SellingPlan sp : spg.getSellingPlans()) {
                            Map<String, Object> plan = new HashMap<>();
                            plan.put("id", sp.getId());
                            plan.put("name", sp.getName());
                            plan.put("plan", sp);
                            allPlans.add(plan);

                            System.out.printf("    [%d] ID: %s%n", allPlans.size(), sp.getId());
                            System.out.printf("        Name: %s%n", sp.getName());
                            if (sp.getBillingPolicy() != null) {
                                System.out.printf("        Billing: Every %s %s%n",
                                    sp.getBillingPolicy().getIntervalCount(),
                                    sp.getBillingPolicy().getInterval());
                            }
                            if (sp.getPricingPolicy() != null && !sp.getPricingPolicy().isEmpty()) {
                                System.out.println("        Discounts:");
                                for (PricingPolicyItem policy : sp.getPricingPolicy()) {
                                    System.out.printf("          - %s%% off (%s)%n",
                                        policy.getAdjustmentValue(),
                                        policy.getPolicyType());
                                }
                            }
                        }
                    }
                }

                System.out.print("\nEnter selling plan number or ID (or press Enter to skip): ");
                String spChoice = scanner.nextLine().trim();

                if (!spChoice.isEmpty()) {
                    // Try to find by ID first
                    boolean foundByID = false;
                    for (Map<String, Object> plan : allPlans) {
                        if (plan.get("id").equals(spChoice)) {
                            sellingPlanID = spChoice;
                            foundByID = true;
                            System.out.printf("  Selected: %s (%s)%n", plan.get("name"), plan.get("id"));
                            break;
                        }
                    }

                    // If not found by ID, try as number
                    if (!foundByID) {
                        try {
                            int idx = Integer.parseInt(spChoice);
                            if (idx > 0 && idx <= allPlans.size()) {
                                sellingPlanID = (String) allPlans.get(idx - 1).get("id");
                                System.out.printf("  Selected: %s (%s)%n",
                                    allPlans.get(idx - 1).get("name"),
                                    allPlans.get(idx - 1).get("id"));
                            } else {
                                sellingPlanID = spChoice;
                                System.out.println("  Using ID: " + spChoice);
                            }
                        } catch (NumberFormatException e) {
                            sellingPlanID = spChoice;
                            System.out.println("  Using ID: " + spChoice);
                        }
                    }
                }
            }

            // Step 5: Get quantity
            System.out.print("\nEnter quantity [1]: ");
            String qtyStr = scanner.nextLine().trim();
            int quantity = 1;
            if (!qtyStr.isEmpty()) {
                try {
                    quantity = Integer.parseInt(qtyStr);
                } catch (NumberFormatException e) {
                    quantity = 1;
                }
            }

            // Step 6: Get shipping address
            System.out.println("\n  Shipping Address:");
            System.out.print("Country [US]: ");
            String country = scanner.nextLine().trim();
            if (country.isEmpty()) country = "US";

            System.out.print("Line1 [123 Main St]: ");
            String line1 = scanner.nextLine().trim();
            if (line1.isEmpty()) line1 = "123 Main St";

            System.out.print("City [New York]: ");
            String city = scanner.nextLine().trim();
            if (city.isEmpty()) city = "New York";

            System.out.print("State [NY]: ");
            String state = scanner.nextLine().trim();
            if (state.isEmpty()) state = "NY";

            System.out.print("Postal Code [10001]: ");
            String postalCode = scanner.nextLine().trim();
            if (postalCode.isEmpty()) postalCode = "10001";

            // Step 7: Get customer ID
            System.out.println("\n  Select Customer (optional):");
            System.out.println("  Fetching customers...");

            CustomerListRequest custReq = new CustomerListRequest();
            custReq.setPage(0);
            custReq.setPageSize(10);

            String customerID = null;
            try {
                CustomerListResponse custResp = customerService.listCustomers(custReq);
                if (custResp.getCustomers() != null && !custResp.getCustomers().isEmpty()) {
                    System.out.println("\n  Available Customers:");
                    for (int i = 0; i < custResp.getCustomers().size(); i++) {
                        Customer cust = custResp.getCustomers().get(i);
                        System.out.printf("  [%d] ID: %s", i + 1, cust.getId());
                        if (cust.getEmail() != null && !cust.getEmail().isEmpty()) {
                            System.out.printf(" - %s", cust.getEmail());
                        }
                        if (cust.getName() != null && !cust.getName().isEmpty()) {
                            System.out.printf(" (%s)", cust.getName());
                        }
                        System.out.println();
                    }
                    System.out.print("\nEnter customer number or ID (or press Enter to skip): ");
                    String customerChoice = scanner.nextLine().trim();

                    if (!customerChoice.isEmpty()) {
                        // Try to find by ID first
                        boolean foundByID = false;
                        for (Customer cust : custResp.getCustomers()) {
                            if (cust.getId().equals(customerChoice)) {
                                customerID = cust.getId();
                                foundByID = true;
                                break;
                            }
                        }
                        // If not found by ID, try as number
                        if (!foundByID) {
                            try {
                                int idx = Integer.parseInt(customerChoice);
                                if (idx > 0 && idx <= custResp.getCustomers().size()) {
                                    customerID = custResp.getCustomers().get(idx - 1).getId();
                                } else {
                                    customerID = customerChoice;
                                }
                            } catch (NumberFormatException e) {
                                customerID = customerChoice;
                            }
                        }
                    }
                } else {
                    System.out.print("\nEnter Customer ID (or press Enter to skip): ");
                    String customerChoice = scanner.nextLine().trim();
                    if (!customerChoice.isEmpty()) {
                        customerID = customerChoice;
                    }
                }
            } catch (IOException e) {
                System.out.print("\nEnter Customer ID (or press Enter to skip): ");
                String customerChoice = scanner.nextLine().trim();
                if (!customerChoice.isEmpty()) {
                    customerID = customerChoice;
                }
            }

            if (customerID != null) {
                System.out.println("  Selected Customer: " + customerID);
            }

            // Step 8: Get receipt email
            System.out.print("Enter Receipt Email: ");
            String receiptEmail = scanner.nextLine().trim();

            // Step 9: Get merchant order ID
            long timestamp = System.currentTimeMillis() / 1000;
            int randomNum = (int) (Math.random() * 1000000);
            String merchantOrderID = String.format("order_%d_%d", timestamp, randomNum);
            System.out.println("Generated Merchant Order ID: " + merchantOrderID);
            System.out.print("Press Enter to use this, or enter custom order ID: ");
            String customOrderID = scanner.nextLine().trim();
            if (!customOrderID.isEmpty()) {
                merchantOrderID = customOrderID;
            }

            // Step 10: Get metadata
            System.out.println("\n  Metadata (key-value pairs):");
            System.out.print("Enter number of metadata entries [0]: ");
            String metadataCountStr = scanner.nextLine().trim();
            int metadataCount = 0;
            if (!metadataCountStr.isEmpty()) {
                try {
                    metadataCount = Integer.parseInt(metadataCountStr);
                } catch (NumberFormatException e) {
                    metadataCount = 0;
                }
            }

            Map<String, String> metadata = new HashMap<>();
            for (int i = 0; i < metadataCount; i++) {
                System.out.printf("  Entry %d:%n", i + 1);
                System.out.print("    Key: ");
                String key = scanner.nextLine().trim();
                System.out.print("    Value: ");
                String value = scanner.nextLine().trim();
                if (!key.isEmpty()) {
                    metadata.put(key, value);
                }
            }

            // Step 11: Create payment intent
            System.out.println("\n  Creating Payment Intent...");

            PaymentIntentCreateRequest req = new PaymentIntentCreateRequest();
            req.setMerchantOrderId(merchantOrderID);
            req.setReceiptEmail(receiptEmail);
            req.setMetadata(metadata);
            req.setPaymentLinkId(selectedLink.getId());

            VariantSelectionRequest primaryVariant = new VariantSelectionRequest();
            primaryVariant.setVariantId(selectedVariant.getVariantID());
            primaryVariant.setQuantity(quantity);
            primaryVariant.setSellingPlanId(sellingPlanID);
            req.setPrimaryVariant(primaryVariant);

            req.setAddons(new ArrayList<>());

            PaymentIntentShippingAddress shippingAddr = new PaymentIntentShippingAddress();
            shippingAddr.setCountry(country);
            shippingAddr.setState(state);
            shippingAddr.setCity(city);
            shippingAddr.setLine1(line1);
            shippingAddr.setPostalCode(postalCode);
            req.setShippingAddress(shippingAddr);

            if (customerID != null) {
                req.setCustomer(customerID);
            }

            if (linkDetails.getProduct() != null) {
                req.setDescription(linkDetails.getProduct().getName());
                req.setProductVersion(linkDetails.getProduct().getVersion());
            }

            PaymentIntent piResponse = paymentIntentService.createPaymentIntent(req);

            System.out.println("\n✓ Payment Intent Created:");
            System.out.println("  ID: " + piResponse.getId());
            System.out.println("  Amount: " + piResponse.getAmount());
            System.out.println("  Status: " + piResponse.getStatus());
            if (piResponse.getPaymentLinkDetails() != null && piResponse.getPaymentLinkDetails().getPaymentLink() != null) {
                System.out.println("  Payment Link ID: " + piResponse.getPaymentLinkDetails().getPaymentLink().getId());
            }

        } catch (IOException e) {
            System.out.println("✗ API Error: " + e.getMessage());
        }
    }
}
