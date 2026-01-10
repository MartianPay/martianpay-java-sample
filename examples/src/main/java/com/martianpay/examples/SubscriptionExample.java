package com.martianpay.examples;

import com.martianpay.developer.*;
import com.martianpay.sdk.MartianPayClient;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Subscription Examples
 */
public class SubscriptionExample {

    // Shared Scanner instance to avoid resource leak
    private static final Scanner scanner = new Scanner(System.in);

    // Thread-safe date formatter (SimpleDateFormat is not thread-safe, but static examples run sequentially)
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * Format amount in cents to dollars display (e.g., "1234" cents -> "$12.34")
     */
    private static String formatCentsToDisplay(String cents) {
        if (cents == null || cents.isEmpty()) {
            return "$0.00";
        }
        try {
            long centsValue = Long.parseLong(cents);
            return String.format("$%.2f", centsValue / 100.0);
        } catch (NumberFormatException e) {
            return "$" + cents; // fallback if not a number
        }
    }

    // List all subscriptions
    public static void listSubscriptions(MartianPayClient client) {
        System.out.println("Listing Subscriptions...");

        ListMerchantSubscriptionsRequest req = new ListMerchantSubscriptionsRequest();
        req.setOffset(0);
        req.setLimit(10);

        try {
            ListSubscriptionsResponse response = client.getSubscriptionService().listSubscriptions(req);

            System.out.printf("✓ Total Subscriptions: %d%n", response.getTotal());
            System.out.printf("  Offset: %d, Limit: %d%n%n", response.getOffset(), response.getLimit());

            if (response.getData() == null || response.getData().isEmpty()) {
                System.out.println("  No subscriptions found");
                return;
            }

            int index = 1;
            for (SubscriptionDetails sub : response.getData()) {
                System.out.printf("[%d] ID: %s%n", index++, sub.getId());
                System.out.printf("    Customer ID: %s%n", sub.getCustomerId());
                if (sub.getCustomerName() != null) {
                    System.out.print("    Customer: " + sub.getCustomerName());
                    if (sub.getCustomerEmail() != null) {
                        System.out.print(" (" + sub.getCustomerEmail() + ")");
                    }
                    System.out.println();
                }
                if (sub.getProductName() != null) {
                    System.out.printf("    Product: %s%n", sub.getProductName());
                }
                System.out.printf("    Status: %s%n", sub.getStatus());
                if (sub.getCurrentPricingTier() != null) {
                    System.out.printf("    Current Price: %s %s%n",
                        sub.getCurrentPricingTier().getFinalPrice(),
                        sub.getCurrentPricingTier().getCurrency());
                }
                if (sub.getNextChargeAmount() != null && !sub.getNextChargeAmount().isEmpty()) {
                    System.out.printf("    Next Charge: %s%n", sub.getNextChargeAmountDisplay());
                }
                System.out.printf("    Current Period: %s - %s%n",
                    formatTimestamp(sub.getCurrentPeriodStart()),
                    formatTimestamp(sub.getCurrentPeriodEnd()));
                if (Boolean.TRUE.equals(sub.getCancelAtPeriodEnd())) {
                    System.out.println("    ⚠️  Will cancel at period end");
                }
                if (sub.getPausedAt() != null) {
                    System.out.printf("    ⏸️  Paused since %s%n", formatTimestamp(sub.getPausedAt()));
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.printf("✗ API Error: %s%n", e.getMessage());
        }
    }

    // List subscriptions filtered by status
    public static void listSubscriptionsByStatus(MartianPayClient client) {
        System.out.println("Listing Subscriptions by Status...");
        System.out.println("\nAvailable statuses:");
        System.out.println("  1. incomplete - Initial state, awaiting first payment");
        System.out.println("  2. active - Active and billing normally");
        System.out.println("  3. paused - Temporarily paused");
        System.out.println("  4. past_due - Payment failed");
        System.out.println("  5. canceled - Canceled");

        System.out.print("\nSelect status (1-5): ");
        String choice = scanner.nextLine().trim();

        String status;
        switch (choice) {
            case "1":
                status = "incomplete";
                break;
            case "2":
                status = "active";
                break;
            case "3":
                status = "paused";
                break;
            case "4":
                status = "past_due";
                break;
            case "5":
                status = "canceled";
                break;
            default:
                status = "active";
                break;
        }

        ListMerchantSubscriptionsRequest req = new ListMerchantSubscriptionsRequest();
        req.setStatus(status);
        req.setOffset(0);
        req.setLimit(10);

        try {
            ListSubscriptionsResponse response = client.getSubscriptionService().listSubscriptions(req);

            System.out.printf("\n✓ %s Subscriptions: %d%n%n", status.toUpperCase(), response.getTotal());

            if (response.getData() == null || response.getData().isEmpty()) {
                System.out.printf("  No %s subscriptions found%n", status);
                return;
            }

            int index = 1;
            for (SubscriptionDetails sub : response.getData()) {
                System.out.printf("[%d] ID: %s%n", index++, sub.getId());
                System.out.printf("    Customer ID: %s%n", sub.getCustomerId());
                if (sub.getCustomerName() != null) {
                    System.out.printf("    Customer: %s%n", sub.getCustomerName());
                }
                if (sub.getProductName() != null) {
                    System.out.printf("    Product: %s%n", sub.getProductName());
                }

                // Show status-specific information
                switch (status) {
                    case "incomplete":
                        if (sub.getPaymentRequired() != null && sub.getPaymentRequired()) {
                            System.out.println("    ⚠️  Payment Required");
                            if (sub.getPaymentUrl() != null) {
                                System.out.printf("    Payment URL: %s%n", sub.getPaymentUrl());
                            }
                            if (sub.getHoursSinceCreation() != null) {
                                System.out.printf("    Hours Since Creation: %.1f%n", sub.getHoursSinceCreation());
                            }
                        }
                        break;
                    case "paused":
                        if (sub.getPausedAt() != null) {
                            System.out.printf("    Paused: %s%n", formatTimestamp(sub.getPausedAt()));
                        }
                        if (sub.getResumesAt() != null) {
                            System.out.printf("    Auto-Resume: %s%n", formatTimestamp(sub.getResumesAt()));
                        }
                        break;
                    case "canceled":
                        if (sub.getCanceledAt() != null) {
                            System.out.printf("    Canceled: %s%n", formatTimestamp(sub.getCanceledAt()));
                        }
                        if (sub.getCancelReason() != null) {
                            System.out.printf("    Reason: %s%n", sub.getCancelReason());
                        }
                        break;
                }

                System.out.println();
            }
        } catch (IOException e) {
            System.out.printf("✗ API Error: %s%n", e.getMessage());
        }
    }

    // List subscriptions for a specific customer
    public static void listSubscriptionsByCustomer(MartianPayClient client) {
        System.out.println("Listing Subscriptions by Customer...");

        System.out.print("Enter Customer ID: ");
        String customerID = scanner.nextLine().trim();
        if (customerID.isEmpty()) {
            System.out.println("✗ Customer ID is required");
            return;
        }

        ListMerchantSubscriptionsRequest req = new ListMerchantSubscriptionsRequest();
        req.setCustomerId(customerID);
        req.setOffset(0);
        req.setLimit(10);

        try {
            ListSubscriptionsResponse response = client.getSubscriptionService().listSubscriptions(req);

            System.out.printf("\n✓ Subscriptions for Customer %s: %d%n%n", customerID, response.getTotal());

            if (response.getData() == null || response.getData().isEmpty()) {
                System.out.println("  No subscriptions found for this customer");
                return;
            }

            int index = 1;
            for (SubscriptionDetails sub : response.getData()) {
                System.out.printf("[%d] %s%n", index++, sub.getId());
                if (sub.getProductName() != null) {
                    System.out.printf("    Product: %s%n", sub.getProductName());
                }
                if (sub.getVariantTitle() != null) {
                    System.out.printf("    Variant: %s%n", sub.getVariantTitle());
                }
                System.out.printf("    Status: %s%n", sub.getStatus());
                if (sub.getCurrentPricingTier() != null) {
                    System.out.printf("    Price: %s %s / %s%n",
                        sub.getCurrentPricingTier().getFinalPrice(),
                        sub.getCurrentPricingTier().getCurrency(),
                        sub.getCurrentPricingTier().getBillingCycle());
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.printf("✗ API Error: %s%n", e.getMessage());
        }
    }

    // Get details of a specific subscription
    public static void getSubscription(MartianPayClient client) {
        System.out.println("Getting Subscription...");

        System.out.print("Enter Subscription ID: ");
        String id = scanner.nextLine().trim();
        if (id.isEmpty()) {
            id = "sub_example_id";
        }

        try {
            SubscriptionDetails response = client.getSubscriptionService().getSubscription(id);

            System.out.println("\n✓ Subscription Details:");
            System.out.printf("  ID: %s%n", response.getId());
            System.out.printf("  Status: %s%n", response.getStatus());

            // Customer Information
            System.out.println("\n  Customer:");
            if (response.getCustomerName() != null) {
                System.out.printf("    Name: %s%n", response.getCustomerName());
            }
            if (response.getCustomerEmail() != null) {
                System.out.printf("    Email: %s%n", response.getCustomerEmail());
            }
            System.out.printf("    ID: %s%n", response.getCustomerId());

            // Product Information
            if (response.getProductName() != null) {
                System.out.println("\n  Product:");
                System.out.printf("    Name: %s%n", response.getProductName());
                if (response.getProductDescription() != null) {
                    System.out.printf("    Description: %s%n", response.getProductDescription());
                }
                if (response.getVariantTitle() != null) {
                    System.out.printf("    Variant: %s%n", response.getVariantTitle());
                }
            }

            // Selling Plan Information
            if (response.getSellingPlanName() != null) {
                System.out.println("\n  Selling Plan:");
                System.out.printf("    Name: %s%n", response.getSellingPlanName());
                if (response.getSellingPlanDescription() != null) {
                    System.out.printf("    Description: %s%n", response.getSellingPlanDescription());
                }
            }

            // Pricing Information
            if (response.getCurrentPricingTier() != null) {
                System.out.println("\n  Current Pricing:");
                System.out.printf("    Cycle: %d%n", response.getCurrentPricingTier().getCycleNumber());
                System.out.printf("    Base Price: %s %s%n",
                    response.getCurrentPricingTier().getBasePrice(),
                    response.getCurrentPricingTier().getCurrency());
                if (response.getCurrentPricingTier().getDiscountPercentage() != null) {
                    System.out.printf("    Discount: %s%%%n", response.getCurrentPricingTier().getDiscountPercentage());
                }
                System.out.printf("    Discount Amount: %s%n", response.getCurrentPricingTier().getSellingPlanDiscount());
                System.out.printf("    Final Price: %s %s%n",
                    response.getCurrentPricingTier().getFinalPrice(),
                    response.getCurrentPricingTier().getCurrency());
                System.out.printf("    Billing Frequency: %s%n", response.getCurrentPricingTier().getBillingCycle());
            }

            // Billing Information
            System.out.println("\n  Billing:");
            System.out.printf("    Current Period: %s - %s%n",
                formatTimestamp(response.getCurrentPeriodStart()),
                formatTimestamp(response.getCurrentPeriodEnd()));
            if (response.getNextChargeAmount() != null) {
                System.out.printf("    Next Charge: %s%n", response.getNextChargeAmountDisplay());
            }
            System.out.printf("    Billing Cycle Anchor: %s%n", formatTimestamp(response.getBillingCycleAnchor()));

            // Trial Information
            if (response.getTrialStart() != null && response.getTrialEnd() != null) {
                System.out.println("\n  Trial Period:");
                System.out.printf("    Start: %s%n", formatTimestamp(response.getTrialStart()));
                System.out.printf("    End: %s%n", formatTimestamp(response.getTrialEnd()));
            }

            // Cancellation Information
            if (Boolean.TRUE.equals(response.getCancelAtPeriodEnd())) {
                System.out.println("\n  ⚠️  Cancellation:");
                System.out.printf("    Will cancel at: %s%n", formatTimestamp(response.getCurrentPeriodEnd()));
                if (response.getCancelReason() != null) {
                    System.out.printf("    Reason: %s%n", response.getCancelReason());
                }
            } else if (response.getCanceledAt() != null) {
                System.out.println("\n  Cancellation:");
                System.out.printf("    Canceled at: %s%n", formatTimestamp(response.getCanceledAt()));
                if (response.getCancelReason() != null) {
                    System.out.printf("    Reason: %s%n", response.getCancelReason());
                }
            }

            // Timestamps
            System.out.println("\n  Timestamps:");
            System.out.printf("    Created: %s%n", formatTimestamp(response.getCreatedAt()));
            System.out.printf("    Updated: %s%n", formatTimestamp(response.getUpdatedAt()));
        } catch (IOException e) {
            System.out.printf("✗ API Error: %s%n", e.getMessage());
        }
    }

    // Cancel a subscription at the end of the current period
    public static void cancelSubscriptionAtPeriodEnd(MartianPayClient client) {
        System.out.println("Canceling Subscription at Period End...");

        System.out.print("Enter Subscription ID: ");
        String id = scanner.nextLine().trim();
        if (id.isEmpty()) {
            System.out.println("✗ Subscription ID is required");
            return;
        }

        System.out.print("Enter cancellation reason (optional): ");
        String reason = scanner.nextLine().trim();
        if (reason.isEmpty()) {
            reason = "Customer requested cancellation";
        }

        CancelMerchantSubscriptionRequest req = new CancelMerchantSubscriptionRequest();
        req.setCancelAtPeriodEnd(true);
        req.setCancelReason(reason);

        try {
            SubscriptionDetails response = client.getSubscriptionService().cancelSubscription(id, req);

            System.out.println("\n✓ Subscription Scheduled for Cancellation:");
            System.out.printf("  ID: %s%n", response.getId());
            System.out.printf("  Status: %s (remains active until period end)%n", response.getStatus());
            System.out.printf("  Will cancel at: %s%n", formatTimestamp(response.getCurrentPeriodEnd()));
            System.out.printf("  Reason: %s%n", reason);
            System.out.printf("\n  Note: Customer will retain access until %s%n",
                formatTimestamp(response.getCurrentPeriodEnd()));
        } catch (IOException e) {
            System.out.printf("✗ API Error: %s%n", e.getMessage());
        }
    }

    // Cancel a subscription immediately
    public static void cancelSubscriptionImmediately(MartianPayClient client) {
        System.out.println("Canceling Subscription Immediately...");

        System.out.print("Enter Subscription ID: ");
        String id = scanner.nextLine().trim();
        if (id.isEmpty()) {
            System.out.println("✗ Subscription ID is required");
            return;
        }

        System.out.print("Enter cancellation reason (optional): ");
        String reason = scanner.nextLine().trim();
        if (reason.isEmpty()) {
            reason = "Immediate cancellation requested";
        }

        System.out.print("\n⚠️  This will cancel the subscription immediately. Continue? (yes/no): ");
        String confirm = scanner.nextLine().trim().toLowerCase();
        if (!confirm.equals("yes")) {
            System.out.println("  Cancelled");
            return;
        }

        CancelMerchantSubscriptionRequest req = new CancelMerchantSubscriptionRequest();
        req.setCancelAtPeriodEnd(false);
        req.setCancelReason(reason);

        try {
            SubscriptionDetails response = client.getSubscriptionService().cancelSubscription(id, req);

            System.out.println("\n✓ Subscription Canceled Immediately:");
            System.out.printf("  ID: %s%n", response.getId());
            System.out.printf("  Status: %s%n", response.getStatus());
            if (response.getCanceledAt() != null) {
                System.out.printf("  Canceled at: %s%n", formatTimestamp(response.getCanceledAt()));
            }
            System.out.printf("  Reason: %s%n", reason);
            System.out.println("\n  Note: Customer access has been revoked");
        } catch (IOException e) {
            System.out.printf("✗ API Error: %s%n", e.getMessage());
        }
    }

    // Pause a subscription indefinitely
    public static void pauseSubscription(MartianPayClient client) {
        System.out.println("Pausing Subscription...");

        System.out.print("Enter Subscription ID: ");
        String id = scanner.nextLine().trim();
        if (id.isEmpty()) {
            System.out.println("✗ Subscription ID is required");
            return;
        }

        System.out.println("\nPause behaviors:");
        System.out.println("  1. void - Cancel pending invoices (recommended)");
        System.out.println("  2. keep_as_draft - Keep invoices as draft");
        System.out.print("\nSelect behavior (1-2, default: 1): ");

        String behaviorChoice = scanner.nextLine().trim();

        String behavior = "void";
        if (behaviorChoice.equals("2")) {
            behavior = "keep_as_draft";
        }

        PauseMerchantSubscriptionRequest req = new PauseMerchantSubscriptionRequest();
        req.setBehavior(behavior);

        try {
            SubscriptionDetails response = client.getSubscriptionService().pauseSubscription(id, req);

            System.out.println("\n✓ Subscription Paused:");
            System.out.printf("  ID: %s%n", response.getId());
            System.out.printf("  Status: %s%n", response.getStatus());
            if (response.getPausedAt() != null) {
                System.out.printf("  Paused at: %s%n", formatTimestamp(response.getPausedAt()));
            }
            if (response.getPauseCollectionBehavior() != null) {
                System.out.printf("  Behavior: %s%n", response.getPauseCollectionBehavior());
            }
            System.out.println("\n  Note: Subscription will remain paused until manually resumed");
        } catch (IOException e) {
            System.out.printf("✗ API Error: %s%n", e.getMessage());
        }
    }

    // Pause a subscription with automatic resumption
    public static void pauseSubscriptionWithAutoResume(MartianPayClient client) {
        System.out.println("Pausing Subscription with Auto-Resume...");

        System.out.print("Enter Subscription ID: ");
        String id = scanner.nextLine().trim();
        if (id.isEmpty()) {
            System.out.println("✗ Subscription ID is required");
            return;
        }

        System.out.print("Enter number of days to pause (e.g., 30): ");
        String daysStr = scanner.nextLine().trim();
        if (daysStr.isEmpty()) {
            daysStr = "30";
        }

        int daysInt;
        try {
            daysInt = Integer.parseInt(daysStr);
            if (daysInt <= 0) {
                daysInt = 30;
            }
        } catch (NumberFormatException e) {
            daysInt = 30;
        }

        // Calculate resumption time (current time + days)
        long resumesAt = System.currentTimeMillis() / 1000 + (daysInt * 24 * 60 * 60);

        PauseMerchantSubscriptionRequest req = new PauseMerchantSubscriptionRequest();
        req.setBehavior("void");
        req.setResumesAt(resumesAt);

        try {
            SubscriptionDetails response = client.getSubscriptionService().pauseSubscription(id, req);

            System.out.println("\n✓ Subscription Paused with Auto-Resume:");
            System.out.printf("  ID: %s%n", response.getId());
            System.out.printf("  Status: %s%n", response.getStatus());
            if (response.getPausedAt() != null) {
                System.out.printf("  Paused at: %s%n", formatTimestamp(response.getPausedAt()));
            }
            if (response.getResumesAt() != null) {
                System.out.printf("  Will resume at: %s%n", formatTimestamp(response.getResumesAt()));
                System.out.printf("  Days paused: %d%n", daysInt);
            }
        } catch (IOException e) {
            System.out.printf("✗ API Error: %s%n", e.getMessage());
        }
    }

    // Resume a paused subscription
    public static void resumeSubscription(MartianPayClient client) {
        System.out.println("Resuming Subscription...");

        System.out.print("Enter Subscription ID: ");
        String id = scanner.nextLine().trim();
        if (id.isEmpty()) {
            System.out.println("✗ Subscription ID is required");
            return;
        }

        try {
            SubscriptionDetails response = client.getSubscriptionService().resumeSubscription(id);

            System.out.println("\n✓ Subscription Resumed:");
            System.out.printf("  ID: %s%n", response.getId());
            System.out.printf("  Status: %s%n", response.getStatus());
            System.out.printf("  New Period: %s - %s%n",
                formatTimestamp(response.getCurrentPeriodStart()),
                formatTimestamp(response.getCurrentPeriodEnd()));
            if (response.getNextChargeAmount() != null) {
                System.out.printf("  Next Charge: %s%n", response.getNextChargeAmountDisplay());
            }
            System.out.println("\n  Note: Billing has resumed according to the original schedule");
        } catch (IOException e) {
            System.out.printf("✗ API Error: %s%n", e.getMessage());
        }
    }

    // Update subscription plan (upgrade or downgrade)
    public static void updateSubscription(MartianPayClient client) {
        System.out.println("Updating Subscription Plan...");

        System.out.print("Enter Subscription ID: ");
        String id = scanner.nextLine().trim();
        if (id.isEmpty()) {
            System.out.println("✗ Subscription ID is required");
            return;
        }

        System.out.print("Enter new Selling Plan ID: ");
        String sellingPlanId = scanner.nextLine().trim();
        if (sellingPlanId.isEmpty()) {
            System.out.println("✗ Selling Plan ID is required");
            return;
        }

        System.out.println("\nProration behaviors:");
        System.out.println("  1. always_invoice - Create and charge proration invoice immediately (recommended for upgrades)");
        System.out.println("  2. create_prorations - Add proration items to next invoice");
        System.out.println("  3. none - No proration calculation");
        System.out.print("\nSelect behavior (1-3, default: 1): ");

        String behaviorChoice = scanner.nextLine().trim();

        String prorationBehavior = UpdateSubscriptionPlanRequest.PRORATION_ALWAYS_INVOICE;
        switch (behaviorChoice) {
            case "2":
                prorationBehavior = UpdateSubscriptionPlanRequest.PRORATION_CREATE_PRORATIONS;
                break;
            case "3":
                prorationBehavior = UpdateSubscriptionPlanRequest.PRORATION_NONE;
                break;
        }

        System.out.println("\nBilling cycle anchor:");
        System.out.println("  1. now - Reset billing cycle to today");
        System.out.println("  2. unchanged - Keep existing billing cycle");
        System.out.print("\nSelect option (1-2, default: 2): ");

        String anchorChoice = scanner.nextLine().trim();

        String billingCycleAnchor = UpdateSubscriptionPlanRequest.BILLING_ANCHOR_UNCHANGED;
        if (anchorChoice.equals("1")) {
            billingCycleAnchor = UpdateSubscriptionPlanRequest.BILLING_ANCHOR_NOW;
        }

        UpdateSubscriptionPlanRequest req = new UpdateSubscriptionPlanRequest();
        req.setPrimaryVariant(new SubscriptionItemUpdate(sellingPlanId));
        req.setProrationBehavior(prorationBehavior);
        req.setBillingCycleAnchor(billingCycleAnchor);

        try {
            SubscriptionDetails response = client.getSubscriptionService().updateSubscription(id, req);

            System.out.println("\n✓ Subscription Updated:");
            System.out.printf("  ID: %s%n", response.getId());
            System.out.printf("  Status: %s%n", response.getStatus());

            if (response.getApplied() != null && response.getApplied()) {
                System.out.println("  ✓ Change Applied Immediately");
            } else {
                System.out.println("  ⏳ Change Scheduled");
            }

            if (response.getIsUpgrade() != null) {
                if (response.getIsUpgrade()) {
                    System.out.println("  Change Type: Upgrade");
                } else {
                    System.out.println("  Change Type: Downgrade");
                }
            }

            if (response.getEffectiveDate() != null) {
                System.out.printf("  Effective Date: %s%n", formatTimestamp(response.getEffectiveDate()));
            }

            if (response.getChargeToday() != null && !response.getChargeToday().isEmpty() && !response.getChargeToday().equals("0")) {
                System.out.printf("  Charge Today: $%s%n", response.getChargeToday());
            }

            if (response.getProrationCredit() != null && !response.getProrationCredit().isEmpty()) {
                System.out.printf("  Proration Credit: $%s%n", response.getProrationCredit());
            }

            // Show proration details
            if (response.getProrationDetails() != null) {
                ProrationDetails pd = response.getProrationDetails();
                System.out.println("\n  Proration Details:");
                System.out.printf("    Current Price: %s%n", formatCentsToDisplay(pd.getCurrentPrice()));
                System.out.printf("    Target Price: %s%n", formatCentsToDisplay(pd.getTargetPrice()));
                System.out.printf("    Days Remaining: %d / %d%n", pd.getDaysRemaining(), pd.getTotalDays());
                System.out.printf("    Credit Amount: %s%n", formatCentsToDisplay(pd.getCreditedAmount()));
                System.out.printf("    Charge Amount: %s%n", formatCentsToDisplay(pd.getChargedAmount()));
                System.out.printf("    Net Amount: %s%n", formatCentsToDisplay(pd.getNetAmount()));
            }

            // Show pending update if downgrade
            if (response.getPendingUpdate() != null) {
                SubscriptionPendingUpdate pu = response.getPendingUpdate();
                System.out.println("\n  Pending Update (Scheduled Downgrade):");
                if (pu.getTargetSellingPlanName() != null) {
                    System.out.printf("    Target Plan: %s%n", pu.getTargetSellingPlanName());
                }
                System.out.printf("    Effective Date: %s%n", formatTimestamp(pu.getEffectiveDate()));
                if (pu.getNextChargeAmount() != null) {
                    System.out.printf("    Next Charge: $%s%n", pu.getNextChargeAmount());
                }
            }

            if (response.getNextChargeAmount() != null) {
                System.out.printf("\n  Next Charge: %s%n", response.getNextChargeAmountDisplay());
            }
            if (response.getNextChargeDate() != null) {
                System.out.printf("  Next Charge Date: %s%n", formatTimestamp(response.getNextChargeDate()));
            }
        } catch (IOException e) {
            System.out.printf("✗ API Error: %s%n", e.getMessage());
        }
    }

    // Preview subscription plan change without applying it
    public static void previewSubscriptionUpdate(MartianPayClient client) {
        System.out.println("Previewing Subscription Plan Change...");

        System.out.print("Enter Subscription ID: ");
        String id = scanner.nextLine().trim();
        if (id.isEmpty()) {
            System.out.println("✗ Subscription ID is required");
            return;
        }

        System.out.print("Enter new Selling Plan ID to preview: ");
        String sellingPlanId = scanner.nextLine().trim();
        if (sellingPlanId.isEmpty()) {
            System.out.println("✗ Selling Plan ID is required");
            return;
        }

        UpdateSubscriptionPlanRequest req = new UpdateSubscriptionPlanRequest();
        req.setPrimaryVariant(new SubscriptionItemUpdate(sellingPlanId));
        req.setProrationBehavior(UpdateSubscriptionPlanRequest.PRORATION_ALWAYS_INVOICE);
        req.setBillingCycleAnchor(UpdateSubscriptionPlanRequest.BILLING_ANCHOR_UNCHANGED);

        try {
            SubscriptionDetails response = client.getSubscriptionService().previewSubscriptionUpdate(id, req);

            System.out.println("\n✓ Subscription Plan Change Preview:");
            System.out.println("  (No changes have been made - this is a preview only)\n");
            System.out.printf("  Subscription ID: %s%n", response.getId());
            System.out.printf("  Current Status: %s%n", response.getStatus());

            if (response.getIsUpgrade() != null) {
                if (response.getIsUpgrade()) {
                    System.out.println("\n  This would be an UPGRADE");
                } else {
                    System.out.println("\n  This would be a DOWNGRADE");
                }
            }

            if (response.getEffectiveDate() != null) {
                System.out.printf("  Effective Date: %s%n", formatTimestamp(response.getEffectiveDate()));
            }

            // Show what would be charged
            System.out.println("\n  Billing Preview:");
            if (response.getChargeToday() != null && !response.getChargeToday().isEmpty() && !response.getChargeToday().equals("0")) {
                System.out.printf("    Would Charge Today: $%s%n", response.getChargeToday());
            } else {
                System.out.println("    Would Charge Today: $0.00 (no immediate charge)");
            }

            if (response.getProrationCredit() != null && !response.getProrationCredit().isEmpty()) {
                System.out.printf("    Proration Credit: $%s%n", response.getProrationCredit());
            }

            // Show proration details
            if (response.getProrationDetails() != null) {
                ProrationDetails pd = response.getProrationDetails();
                System.out.println("\n  Proration Calculation:");
                System.out.printf("    Current Price: %s cents%n", pd.getCurrentPrice());
                System.out.printf("    Target Price: %s cents%n", pd.getTargetPrice());
                System.out.printf("    Days Remaining: %d / %d total days%n", pd.getDaysRemaining(), pd.getTotalDays());
                System.out.printf("    Credit (unused time): %s cents%n", pd.getCreditedAmount());
                System.out.printf("    Charge (new plan): %s cents%n", pd.getChargedAmount());
                System.out.printf("    Net Amount: %s cents%n", pd.getNetAmount());
            }

            // Show future billing info
            if (response.getNextChargeAmount() != null) {
                System.out.println("\n  Future Billing:");
                System.out.printf("    Next Charge Amount: %s%n", response.getNextChargeAmountDisplay());
            }
            if (response.getNextChargeDate() != null) {
                System.out.printf("    Next Charge Date: %s%n", formatTimestamp(response.getNextChargeDate()));
            }

            System.out.println("\n  Note: Use 'Update Subscription' to apply this change.");
        } catch (IOException e) {
            System.out.printf("✗ API Error: %s%n", e.getMessage());
        }
    }

    // Revoke a pending cancellation
    public static void revokeCancelSubscription(MartianPayClient client) {
        System.out.println("Revoking Subscription Cancellation...");

        System.out.print("Enter Subscription ID: ");
        String id = scanner.nextLine().trim();
        if (id.isEmpty()) {
            System.out.println("✗ Subscription ID is required");
            return;
        }

        try {
            // First check if the subscription has a pending cancellation
            SubscriptionDetails current = client.getSubscriptionService().getSubscription(id);
            if (!Boolean.TRUE.equals(current.getCancelAtPeriodEnd())) {
                System.out.println("\n⚠️  This subscription does not have a pending cancellation.");
                System.out.println("  Use this method only for subscriptions scheduled to cancel at period end.");
                return;
            }

            System.out.printf("\nSubscription %s is scheduled to cancel at %s%n",
                id, formatTimestamp(current.getCurrentPeriodEnd()));
            System.out.print("Revoke cancellation and continue subscription? (yes/no): ");
            String confirm = scanner.nextLine().trim().toLowerCase();
            if (!confirm.equals("yes")) {
                System.out.println("  Cancelled");
                return;
            }

            SubscriptionDetails response = client.getSubscriptionService().revokeCancelSubscription(id);

            System.out.println("\n✓ Subscription Cancellation Revoked:");
            System.out.printf("  ID: %s%n", response.getId());
            System.out.printf("  Status: %s%n", response.getStatus());
            System.out.printf("  Current Period: %s - %s%n",
                formatTimestamp(response.getCurrentPeriodStart()),
                formatTimestamp(response.getCurrentPeriodEnd()));
            if (response.getNextChargeAmount() != null) {
                System.out.printf("  Next Charge: %s%n", response.getNextChargeAmountDisplay());
            }
            System.out.println("\n  Note: Subscription will now continue billing as normal");
        } catch (IOException e) {
            System.out.printf("✗ API Error: %s%n", e.getMessage());
        }
    }

    // Format Unix timestamp to human-readable format
    private static String formatTimestamp(Long timestamp) {
        if (timestamp == null) {
            return "N/A";
        }
        Date date = new Date(timestamp * 1000);
        return DATE_FORMAT.format(date);
    }
}
