package com.martianpay.examples;

import com.martianpay.developer.*;
import com.martianpay.sdk.RefundService;

import java.io.IOException;
import java.util.Scanner;

/**
 * Refund Examples
 *
 * This class demonstrates how to use the RefundService to manage refunds.
 */
public class RefundExample {

    private final RefundService refundService;
    private final Scanner scanner;

    public RefundExample() {
        this.refundService = new RefundService(Common.currentAPIKey);
        this.scanner = new Scanner(System.in);
    }

    /**
     * Creates a new refund for a payment intent.
     */
    public void createRefund() {
        System.out.println("Creating Refund...");
        System.out.print("Enter Payment Intent ID (or press Enter for demo): ");

        String paymentIntentId = scanner.nextLine().trim();
        if (paymentIntentId.isEmpty()) {
            paymentIntentId = "pi_example_id";
        }

        System.out.print("Enter refund amount (or press Enter for default 10.00): ");
        String amountInput = scanner.nextLine().trim();
        if (amountInput.isEmpty()) {
            amountInput = "10.00";
        }

        String reason = "Customer requested refund";
        RefundCreateRequest request = new RefundCreateRequest();
        request.setPaymentIntent(paymentIntentId);
        request.setAmount(amountInput);
        request.setReason(reason);

        try {
            RefundCreateResponse response = refundService.createRefund(request);

            System.out.println("✓ Refund Created:");
            if (response.getRefunds() != null && !response.getRefunds().isEmpty()) {
                Refund refund = response.getRefunds().get(0);
                System.out.println("  ID: " + refund.getId());
                System.out.println("  Amount: " + refund.getAmount());
                System.out.println("  Status: " + refund.getStatus());
                System.out.println("  Payment Intent: " + refund.getPaymentIntent());
            }
        } catch (IOException e) {
            System.out.println("✗ API Error: " + e.getMessage());
        }
    }

    /**
     * Retrieves a refund by ID.
     */
    public void getRefund() {
        System.out.println("Getting Refund...");
        System.out.print("Enter Refund ID: ");

        String id = scanner.nextLine().trim();
        if (id.isEmpty()) {
            id = "rf_example_id";
        }

        try {
            Refund response = refundService.getRefund(id);

            System.out.println("✓ Refund Retrieved:");
            System.out.println("  ID: " + response.getId());
            System.out.println("  Amount: " + response.getAmount());
            System.out.println("  Status: " + response.getStatus());
            System.out.println("  Payment Intent: " + response.getPaymentIntent());
        } catch (IOException e) {
            System.out.println("✗ API Error: " + e.getMessage());
        }
    }

    /**
     * Lists all refunds with pagination.
     */
    public void listRefunds() {
        System.out.println("Listing Refunds...");

        RefundListRequest request = new RefundListRequest();
        request.setPage(0);
        request.setPageSize(10);

        try {
            RefundListResponse response = refundService.listRefunds(request);

            System.out.println("✓ Total Refunds: " + response.getTotal());
            System.out.println("  Page: " + response.getPage() + ", Page Size: " + response.getPageSize());
            System.out.println();

            if (response.getRefunds() != null) {
                for (int i = 0; i < response.getRefunds().size(); i++) {
                    Refund refund = response.getRefunds().get(i);
                    System.out.println("  [" + (i + 1) + "] ID: " + refund.getId() +
                            ", Amount: " + refund.getAmount() +
                            ", Status: " + refund.getStatus());
                }
            }
        } catch (IOException e) {
            System.out.println("✗ API Error: " + e.getMessage());
        }
    }
}
