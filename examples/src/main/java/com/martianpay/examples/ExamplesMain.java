package com.martianpay.examples;

import java.util.Scanner;

/**
 * MartianPay SDK Examples Main Menu
 *
 * This interactive menu demonstrates all features of the MartianPay Java SDK.
 * It provides 28 examples covering:
 * - Payment Intents (7 examples)
 * - Customers (5 examples)
 * - Refunds (3 examples)
 * - Payrolls (3 examples)
 * - Merchant Addresses (7 examples)
 * - Webhooks (1 example)
 *
 * Before running, update the API_KEY in Common.java with your actual API key.
 */
public class ExamplesMain {

    private static final Scanner scanner = new Scanner(System.in);

    // Example instances
    private static PaymentIntentExample paymentIntentExample;
    private static CustomerExample customerExample;
    private static RefundExample refundExample;
    private static PayrollExample payrollExample;
    private static MerchantAddressExample merchantAddressExample;

    public static void main(String[] args) {
        // Initialize example instances
        paymentIntentExample = new PaymentIntentExample();
        customerExample = new CustomerExample();
        refundExample = new RefundExample();
        payrollExample = new PayrollExample();
        merchantAddressExample = new MerchantAddressExample();

        // Main loop
        while (true) {
            showMenu();
            System.out.print("\nEnter your choice (0 to exit): ");

            String choice = scanner.nextLine().trim();

            if ("0".equals(choice)) {
                System.out.println("Goodbye!");
                break;
            }

            int num;
            try {
                num = Integer.parseInt(choice);
                if (num < 0 || num > 28) {
                    System.out.println("Invalid choice. Please try again.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            System.out.println("\n" + "=".repeat(80));
            runExample(num);
            System.out.println("=".repeat(80));
            System.out.print("\nPress Enter to continue...");
            scanner.nextLine();
        }

        scanner.close();
    }

    /**
     * Displays the main menu
     */
    private static void showMenu() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("MartianPay SDK Examples");
        System.out.println("=".repeat(80));

        System.out.println("\n=== Payment Intent Examples ===");
        System.out.println(" 1. Create and Update Payment Intent (Crypto)");
        System.out.println(" 2. Get Payment Intent");
        System.out.println(" 3. List Payment Intents");
        System.out.println(" 4. Cancel Payment Intent");
        System.out.println(" 5. List Payment Intents with Permanent Deposit");
        System.out.println(" 6. Fiat Payment with New Card");
        System.out.println(" 7. Fiat Payment with Saved Card");

        System.out.println("\n=== Customer Examples ===");
        System.out.println(" 8. Create and Update Customer");
        System.out.println(" 9. Get Customer");
        System.out.println("10. List Customers");
        System.out.println("11. Delete Customer");
        System.out.println("12. List Customer Payment Methods");

        System.out.println("\n=== Refund Examples ===");
        System.out.println("13. Create Refund");
        System.out.println("14. Get Refund");
        System.out.println("15. List Refunds");

        System.out.println("\n=== Payroll Examples ===");
        System.out.println("16. Create Direct Payroll");
        System.out.println("17. Get Payroll");
        System.out.println("18. List Payrolls");

        System.out.println("\n=== Merchant Address Examples ===");
        System.out.println("19. Create Merchant Address");
        System.out.println("20. Get Merchant Address");
        System.out.println("21. Update Merchant Address");
        System.out.println("22. Verify Merchant Address");
        System.out.println("23. List Merchant Addresses");
        System.out.println("24. List Merchant Addresses by Network");
        System.out.println("25. Delete Merchant Address");
        System.out.println("26. Create and Verify Merchant Address (Full Workflow)");

        System.out.println("\n=== Webhook Examples ===");
        System.out.println("27. Start Webhook Event Receiver Server");

        System.out.println("\n 0. Exit");
    }

    /**
     * Runs the selected example
     */
    private static void runExample(int choice) {
        try {
            switch (choice) {
                // Payment Intent Examples
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

                // Customer Examples
                case 8:
                    customerExample.createAndUpdateCustomer();
                    break;
                case 9:
                    customerExample.getCustomer();
                    break;
                case 10:
                    customerExample.listCustomers();
                    break;
                case 11:
                    customerExample.deleteCustomer();
                    break;
                case 12:
                    customerExample.listCustomerPaymentMethods();
                    break;

                // Refund Examples
                case 13:
                    refundExample.createRefund();
                    break;
                case 14:
                    refundExample.getRefund();
                    break;
                case 15:
                    refundExample.listRefunds();
                    break;

                // Payroll Examples
                case 16:
                    payrollExample.createDirectPayroll();
                    break;
                case 17:
                    payrollExample.getPayroll();
                    break;
                case 18:
                    payrollExample.listPayrolls();
                    break;

                // Merchant Address Examples
                case 19:
                    merchantAddressExample.createMerchantAddress();
                    break;
                case 20:
                    merchantAddressExample.getMerchantAddress();
                    break;
                case 21:
                    merchantAddressExample.updateMerchantAddress();
                    break;
                case 22:
                    merchantAddressExample.verifyMerchantAddress();
                    break;
                case 23:
                    merchantAddressExample.listMerchantAddresses();
                    break;
                case 24:
                    merchantAddressExample.listMerchantAddressesByNetwork();
                    break;
                case 25:
                    merchantAddressExample.deleteMerchantAddress();
                    break;
                case 26:
                    merchantAddressExample.createAndVerifyMerchantAddress();
                    break;

                // Webhook Examples
                case 27:
                    WebhookExample.startWebhookServer();
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        } catch (Exception e) {
            System.out.println("✗ Error running example: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
