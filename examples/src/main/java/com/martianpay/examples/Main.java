package com.martianpay.examples;

import com.martianpay.sdk.MartianPayClient;

import java.util.Scanner;

/**
 * MartianPay Go SDK Examples - Main Menu
 *
 * This interactive menu demonstrates all features of the MartianPay Java SDK.
 * Converted from martianpay-go-sample/examples/main.go
 */
public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("===========================================");
        System.out.println("  MartianPay Go SDK Examples");
        System.out.println("===========================================");
        System.out.print("\nEnter your API key (or press Enter to use default): ");

        String apiKeyInput = scanner.nextLine().trim();

        // Use input API key or fall back to default
        if (apiKeyInput.isEmpty()) {
            Common.currentAPIKey = Common.API_KEY;
            System.out.println("Using default API key from Common.java");
        } else {
            Common.currentAPIKey = apiKeyInput;
            System.out.println("Using custom API key");
        }
        System.out.println();

        while (true) {
            showMainMenu();
            System.out.print("\nEnter your choice (0 to exit): ");

            String choice = scanner.nextLine().trim();
            if ("0".equals(choice)) {
                System.out.println("Goodbye!");
                break;
            }

            int num;
            try {
                num = Integer.parseInt(choice);
                if (num < 0 || num > 12) {
                    System.out.println("Invalid choice. Please try again.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            // Show submenu based on category
            if (num > 0) {
                handleCategory(num);
            }
        }

        scanner.close();
    }

    private static void showMainMenu() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("MartianPay SDK Examples - Main Menu");
        System.out.println("=".repeat(80));

        System.out.println("\n1. Payment Intent Examples");
        System.out.println("2. Customer Examples");
        System.out.println("3. Refund Examples");
        System.out.println("4. Payroll Examples");
        System.out.println("5. Merchant Address Examples");
        System.out.println("6. Payout Examples");
        System.out.println("7. Assets Examples");
        System.out.println("8. Balance Examples");
        System.out.println("9. Product Examples");
        System.out.println("10. Payment Link Examples");
        System.out.println("11. Subscription Examples");
        System.out.println("12. Webhook Examples");

        System.out.println("\n0. Exit");
    }

    private static void handleCategory(int category) {
        while (true) {
            System.out.println("\n" + "=".repeat(80));

            String[] menuItems = null;
            String categoryName = "";

            switch (category) {
                case 1:
                    categoryName = "Payment Intent Examples";
                    menuItems = new String[]{
                            "Create and Update Payment Intent (Crypto)",
                            "Get Payment Intent",
                            "List Payment Intents",
                            "Cancel Payment Intent",
                            "List Payment Intents with Permanent Deposit",
                            "Fiat Payment with New Card",
                            "Fiat Payment with Saved Card",
                            "Create Payment Intent with Payment Link"
                    };
                    break;
                case 2:
                    categoryName = "Customer Examples";
                    menuItems = new String[]{
                            "Create and Update Customer",
                            "Get Customer",
                            "List Customers",
                            "Delete Customer",
                            "List Customer Payment Methods"
                    };
                    break;
                case 3:
                    categoryName = "Refund Examples";
                    menuItems = new String[]{
                            "Create Refund",
                            "Get Refund",
                            "List Refunds"
                    };
                    break;
                case 4:
                    categoryName = "Payroll Examples";
                    menuItems = new String[]{
                            "Create Direct Payroll (Normal Payment)",
                            "Create Direct Payroll (Binance Payment)",
                            "Get Payroll",
                            "List Payrolls",
                            "List Payroll Items"
                    };
                    break;
                case 5:
                    categoryName = "Merchant Address Examples";
                    menuItems = new String[]{
                            "Create Merchant Address",
                            "Get Merchant Address",
                            "Update Merchant Address",
                            "Verify Merchant Address",
                            "List Merchant Addresses",
                            "List Merchant Addresses by Network",
                            "Delete Merchant Address",
                            "Create and Verify Merchant Address (Full Workflow)"
                    };
                    break;
                case 6:
                    categoryName = "Payout Examples";
                    menuItems = new String[]{
                            "Preview Payout",
                            "Create Payout",
                            "Get Payout",
                            "List Payouts",
                            "Get Payout Approval Instance",
                            "Approve Payout",
                            "Reject Payout",
                            "Cancel Payout"
                    };
                    break;
                case 7:
                    categoryName = "Assets Examples";
                    menuItems = new String[]{
                            "List Enabled Assets",
                            "Get All Available Assets",
                            "List Asset Network Fees",
                            "Show Crypto Assets by Network",
                            "Show Payable Assets Only",
                            "Compare Mainnet vs Testnet Assets"
                    };
                    break;
                case 8:
                    categoryName = "Balance Examples";
                    menuItems = new String[]{
                            "Show Balance Summary",
                            "Show Balance by Currency",
                            "Show Available Balances Only",
                            "Show Locked and Pending Balances",
                            "Compare Balance Types"
                    };
                    break;
                case 9:
                    categoryName = "Product Examples";
                    menuItems = new String[]{
                            "List Products",
                            "Create Product with Variants",
                            "Create Product with Selling Plan",
                            "Get Product",
                            "Update Product",
                            "Delete Product",
                            "List Active Products",
                            "List Selling Plan Groups",
                            "Create Selling Plan Group",
                            "Get Selling Plan Group",
                            "Update Selling Plan Group",
                            "Delete Selling Plan Group",
                            "List Selling Plans",
                            "Create Selling Plan",
                            "Get Selling Plan",
                            "Update Selling Plan",
                            "Delete Selling Plan",
                            "Calculate Selling Plan Price"
                    };
                    break;
                case 10:
                    categoryName = "Payment Link Examples";
                    menuItems = new String[]{
                            "List Payment Links",
                            "Create Payment Link",
                            "Get Payment Link",
                            "Update Payment Link",
                            "Delete Payment Link",
                            "List Active Payment Links",
                            "List Payment Links by Product"
                    };
                    break;
                case 11:
                    categoryName = "Subscription Examples";
                    menuItems = new String[]{
                            "List Subscriptions",
                            "List Subscriptions by Customer",
                            "List Subscriptions by Status",
                            "Get Subscription",
                            "Cancel Subscription at Period End",
                            "Cancel Subscription Immediately",
                            "Pause Subscription",
                            "Pause Subscription with Auto-Resume",
                            "Resume Subscription"
                    };
                    break;
                case 12:
                    categoryName = "Webhook Examples";
                    menuItems = new String[]{
                            "Start Webhook Event Receiver Server"
                    };
                    break;
            }

            System.out.println(categoryName);
            System.out.println("=".repeat(80));

            if (menuItems != null) {
                for (int i = 0; i < menuItems.length; i++) {
                    System.out.printf("%2d. %s\n", i + 1, menuItems[i]);
                }
            }
            System.out.println("\n 0. Back to Main Menu");

            System.out.print("\nEnter your choice: ");
            String choice = scanner.nextLine().trim();
            if ("0".equals(choice)) {
                return;
            }

            int num;
            try {
                num = Integer.parseInt(choice);
                if (num < 0 || (menuItems != null && num > menuItems.length)) {
                    System.out.println("Invalid choice. Please try again.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            // Map to original example number
            int exampleNum = getExampleNumber(category, num);

            System.out.println("\n" + "=".repeat(80));
            runExample(exampleNum);
            System.out.println("=".repeat(80));
            System.out.print("\nPress Enter to continue...");
            scanner.nextLine();
        }
    }

    private static int getExampleNumber(int category, int choice) {
        int[] categoryOffsets = {
                0,  // Payment Intent: 1-8
                8,  // Customer: 9-13
                13, // Refund: 14-16
                16, // Payroll: 17-21
                21, // Merchant Address: 22-29
                29, // Payout: 30-37
                37, // Assets: 38-43
                43, // Balance: 44-48
                48, // Product: 49-66 (7 product + 11 selling plan)
                66, // Payment Link: 67-73
                73, // Subscription: 74-82 (9 examples)
                82  // Webhook: 83
        };

        return categoryOffsets[category - 1] + choice;
    }

    private static void runExample(int choice) {
        System.out.printf("Using API Key: %s\n", Common.currentAPIKey);
        MartianPayClient client = new MartianPayClient(Common.currentAPIKey);

        // Create example instances
        PaymentIntentExample paymentIntentExample = new PaymentIntentExample();
        CustomerExample customerExample = new CustomerExample();
        RefundExample refundExample = new RefundExample();
        PayrollExample payrollExample = new PayrollExample();
        MerchantAddressExample merchantAddressExample = new MerchantAddressExample();
        PaymentLinkExample paymentLinkExample = new PaymentLinkExample();
        PayoutExample payoutExample = new PayoutExample();
        AssetsExample assetsExample = new AssetsExample();
        BalanceExample balanceExample = new BalanceExample();
        ProductExample productExample = new ProductExample();
        SubscriptionExample subscriptionExample = new SubscriptionExample();
        WebhookExample webhookExample = new WebhookExample();

        try {
            switch (choice) {
                // Payment Intent Examples (1-8)
                case 1:
                    paymentIntentExample.createAndUpdatePaymentIntent();
                    break;
                case 2:
                    paymentIntentExample.getPaymentIntent();
                    break;
                case 3:
                    paymentIntentExample.listPaymentIntents();
                    break;
                case 4:
                    paymentIntentExample.cancelPaymentIntent();
                    break;
                case 5:
                    paymentIntentExample.listPaymentIntentsWithPermanentDeposit();
                    break;
                case 6:
                    paymentIntentExample.fiatPaymentWithNewCard();
                    break;
                case 7:
                    paymentIntentExample.fiatPaymentWithSavedCard();
                    break;
                case 8:
                    PaymentIntentExample.createPaymentIntentWithPaymentLink(client);
                    break;

                // Customer Examples (9-13)
                case 9:
                    customerExample.createAndUpdateCustomer();
                    break;
                case 10:
                    customerExample.getCustomer();
                    break;
                case 11:
                    customerExample.listCustomers();
                    break;
                case 12:
                    customerExample.deleteCustomer();
                    break;
                case 13:
                    customerExample.listCustomerPaymentMethods();
                    break;

                // Refund Examples (14-16)
                case 14:
                    refundExample.createRefund();
                    break;
                case 15:
                    refundExample.getRefund();
                    break;
                case 16:
                    refundExample.listRefunds();
                    break;

                // Payroll Examples (17-21)
                case 17:
                    payrollExample.createDirectPayroll();
                    break;
                case 18:
                    payrollExample.createDirectPayrollBinance();
                    break;
                case 19:
                    payrollExample.getPayroll();
                    break;
                case 20:
                    payrollExample.listPayrolls();
                    break;
                case 21:
                    payrollExample.listPayrollItems();
                    break;

                // Merchant Address Examples (22-29)
                case 22:
                    merchantAddressExample.createMerchantAddress();
                    break;
                case 23:
                    merchantAddressExample.getMerchantAddress();
                    break;
                case 24:
                    merchantAddressExample.updateMerchantAddress();
                    break;
                case 25:
                    merchantAddressExample.verifyMerchantAddress();
                    break;
                case 26:
                    merchantAddressExample.listMerchantAddresses();
                    break;
                case 27:
                    merchantAddressExample.listMerchantAddressesByNetwork();
                    break;
                case 28:
                    merchantAddressExample.deleteMerchantAddress();
                    break;
                case 29:
                    merchantAddressExample.createAndVerifyMerchantAddress();
                    break;

                // Payout Examples (30-37)
                case 30:
                    PayoutExample.previewPayout(client);
                    break;
                case 31:
                    PayoutExample.createPayout(client);
                    break;
                case 32:
                    PayoutExample.getPayout(client);
                    break;
                case 33:
                    PayoutExample.listPayouts(client);
                    break;
                case 34:
                    PayoutExample.getPayoutApprovalInstance(client);
                    break;
                case 35:
                    PayoutExample.approvePayout(client);
                    break;
                case 36:
                    PayoutExample.rejectPayout(client);
                    break;
                case 37:
                    PayoutExample.cancelPayout(client);
                    break;

                // Assets Examples (38-43)
                case 38:
                    assetsExample.listAssets();
                    break;
                case 39:
                    assetsExample.getAllAssets();
                    break;
                case 40:
                    assetsExample.listAssetFees();
                    break;
                case 41:
                    assetsExample.showCryptoAssetsByNetwork();
                    break;
                case 42:
                    assetsExample.showPayableAssets();
                    break;
                case 43:
                    assetsExample.compareMainnetVsTestnet();
                    break;

                // Balance Examples (44-48)
                case 44:
                    balanceExample.showBalance();
                    break;
                case 45:
                    balanceExample.showBalanceByCurrency();
                    break;
                case 46:
                    balanceExample.showAvailableBalancesOnly();
                    break;
                case 47:
                    balanceExample.showLockedAndPendingBalances();
                    break;
                case 48:
                    balanceExample.compareBalanceTypes();
                    break;

                // Product Examples (49-66)
                case 49:
                    ProductExample.listProducts(client);
                    break;
                case 50:
                    ProductExample.createProductWithVariants(client);
                    break;
                case 51:
                    ProductExample.createProductWithSellingPlan(client);
                    break;
                case 52:
                    ProductExample.getProduct(client);
                    break;
                case 53:
                    ProductExample.updateProduct(client);
                    break;
                case 54:
                    ProductExample.deleteProduct(client);
                    break;
                case 55:
                    ProductExample.listActiveProducts(client);
                    break;
                case 56:
                    SellingPlanExample.listSellingPlanGroups(client);
                    break;
                case 57:
                    SellingPlanExample.createSellingPlanGroup(client);
                    break;
                case 58:
                    SellingPlanExample.getSellingPlanGroup(client);
                    break;
                case 59:
                    SellingPlanExample.updateSellingPlanGroup(client);
                    break;
                case 60:
                    SellingPlanExample.deleteSellingPlanGroup(client);
                    break;
                case 61:
                    SellingPlanExample.listSellingPlans(client);
                    break;
                case 62:
                    SellingPlanExample.createSellingPlan(client);
                    break;
                case 63:
                    SellingPlanExample.getSellingPlan(client);
                    break;
                case 64:
                    SellingPlanExample.updateSellingPlan(client);
                    break;
                case 65:
                    SellingPlanExample.deleteSellingPlan(client);
                    break;
                case 66:
                    SellingPlanExample.calculateSellingPlanPrice(client);
                    break;

                // Payment Link Examples (67-73)
                case 67:
                    PaymentLinkExample.listPaymentLinks(client);
                    break;
                case 68:
                    PaymentLinkExample.createPaymentLink(client);
                    break;
                case 69:
                    PaymentLinkExample.getPaymentLink(client);
                    break;
                case 70:
                    PaymentLinkExample.updatePaymentLink(client);
                    break;
                case 71:
                    PaymentLinkExample.deletePaymentLink(client);
                    break;
                case 72:
                    PaymentLinkExample.listActivePaymentLinks(client);
                    break;
                case 73:
                    PaymentLinkExample.listPaymentLinksByProduct(client);
                    break;

                // Subscription Examples (74-82)
                case 74:
                    SubscriptionExample.listSubscriptions(client);
                    break;
                case 75:
                    SubscriptionExample.listSubscriptionsByCustomer(client);
                    break;
                case 76:
                    SubscriptionExample.listSubscriptionsByStatus(client);
                    break;
                case 77:
                    SubscriptionExample.getSubscription(client);
                    break;
                case 78:
                    SubscriptionExample.cancelSubscriptionAtPeriodEnd(client);
                    break;
                case 79:
                    SubscriptionExample.cancelSubscriptionImmediately(client);
                    break;
                case 80:
                    SubscriptionExample.pauseSubscription(client);
                    break;
                case 81:
                    SubscriptionExample.pauseSubscriptionWithAutoResume(client);
                    break;
                case 82:
                    SubscriptionExample.resumeSubscription(client);
                    break;

                // Webhook Examples (83)
                case 83:
                    webhookExample.startWebhookServer();
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
