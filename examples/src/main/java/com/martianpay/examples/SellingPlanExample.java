package com.martianpay.examples;

import com.martianpay.developer.*;
import com.martianpay.sdk.MartianPayClient;

import java.io.IOException;
import java.util.*;

/**
 * Selling Plan Examples
 *
 * This class demonstrates how to use the SellingPlanService to manage selling plan groups
 * and selling plans for subscription and recurring payment products.
 */
public class SellingPlanExample {

    // ==================== Selling Plan Group Examples ====================

    /**
     * Lists all selling plan groups
     */
    public static void listSellingPlanGroups(MartianPayClient client) {
        System.out.println("Listing Selling Plan Groups...");

        Pagination params = new Pagination();
        params.setPage(0);
        params.setPageSize(10);

        try {
            ListSellingPlanGroupsResponse response = client.getSellingPlanService().listSellingPlanGroups(params);

            System.out.printf("\n✓ Total Selling Plan Groups: %d%n", response.getTotal());
            System.out.printf("  Offset: %d, Limit: %d%n%n", response.getOffset(), response.getLimit());

            if (response.getData() == null || response.getData().isEmpty()) {
                System.out.println("  No selling plan groups found");
                return;
            }

            int index = 1;
            for (SellingPlanGroupResponse group : response.getData()) {
                System.out.printf("[%d] %s%n", index++, group.getName());
                System.out.printf("    ID: %s%n", group.getId());
                System.out.printf("    Status: %s%n", group.getStatus());
                if (group.getDescription() != null && !group.getDescription().isEmpty()) {
                    System.out.printf("    Description: %s%n", group.getDescription());
                }
                if (group.getOptions() != null && !group.getOptions().isEmpty()) {
                    System.out.printf("    Options: %s%n", group.getOptions());
                }
                if (group.getSellingPlans() != null && !group.getSellingPlans().isEmpty()) {
                    System.out.printf("    Selling Plans: %d%n", group.getSellingPlans().size());
                }
                System.out.printf("    Created: %d%n", group.getCreatedAt());
                System.out.println();
            }
        } catch (IOException e) {
            System.out.printf("✗ API Error: %s%n", e.getMessage());
        }
    }

    /**
     * Creates a new selling plan group
     */
    public static void createSellingPlanGroup(MartianPayClient client) {
        System.out.println("Creating Selling Plan Group...");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter group name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            name = "Subscription Plans";
        }

        System.out.print("Enter description: ");
        String description = scanner.nextLine().trim();
        if (description.isEmpty()) {
            description = "Flexible subscription options for recurring purchases";
        }

        CreateSellingPlanGroupRequest req = new CreateSellingPlanGroupRequest();
        req.setName(name);
        req.setDescription(description);
        req.setOptions(Arrays.asList("Billing Frequency"));

        try {
            SellingPlanGroupResponse response = client.getSellingPlanService().createSellingPlanGroup(req);

            System.out.println("\n✓ Selling Plan Group Created:");
            System.out.printf("  ID: %s%n", response.getId());
            System.out.printf("  Name: %s%n", response.getName());
            System.out.printf("  Description: %s%n", response.getDescription());
            System.out.printf("  Status: %s%n", response.getStatus());
            if (response.getOptions() != null && !response.getOptions().isEmpty()) {
                System.out.printf("  Options: %s%n", response.getOptions());
            }
        } catch (IOException e) {
            System.out.printf("✗ API Error: %s%n", e.getMessage());
        }
    }

    /**
     * Retrieves details of a specific selling plan group
     */
    public static void getSellingPlanGroup(MartianPayClient client) {
        System.out.println("Getting Selling Plan Group...");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Selling Plan Group ID: ");
        String id = scanner.nextLine().trim();
        if (id.isEmpty()) {
            id = "spg_example_id";
        }

        try {
            SellingPlanGroupResponse response = client.getSellingPlanService().getSellingPlanGroup(id);

            System.out.println("\n✓ Selling Plan Group Details:");
            System.out.printf("  ID: %s%n", response.getId());
            System.out.printf("  Name: %s%n", response.getName());
            System.out.printf("  Description: %s%n", response.getDescription());
            System.out.printf("  Status: %s%n", response.getStatus());
            if (response.getOptions() != null && !response.getOptions().isEmpty()) {
                System.out.printf("  Options: %s%n", response.getOptions());
            }
            System.out.printf("  Created: %d%n", response.getCreatedAt());
            System.out.printf("  Updated: %d%n%n", response.getUpdatedAt());

            if (response.getSellingPlans() != null && !response.getSellingPlans().isEmpty()) {
                System.out.printf("  Selling Plans (%d):%n", response.getSellingPlans().size());
                int index = 1;
                for (SellingPlanResponse plan : response.getSellingPlans()) {
                    System.out.printf("    [%d] %s (ID: %s)%n", index++, plan.getName(), plan.getId());
                    System.out.printf("        Type: %s%n", plan.getBillingPolicyType());
                    System.out.printf("        Interval: Every %s %s%n",
                        plan.getBillingPolicy().getIntervalCount(),
                        plan.getBillingPolicy().getInterval());
                    if (plan.getTrialPeriodDays() != null && !plan.getTrialPeriodDays().equals("0")) {
                        System.out.printf("        Trial: %s days%n", plan.getTrialPeriodDays());
                    }
                    System.out.printf("        Status: %s%n", plan.getStatus());
                }
            }
        } catch (IOException e) {
            System.out.printf("✗ API Error: %s%n", e.getMessage());
        }
    }

    /**
     * Updates an existing selling plan group
     */
    public static void updateSellingPlanGroup(MartianPayClient client) {
        System.out.println("Updating Selling Plan Group...");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Selling Plan Group ID: ");
        String id = scanner.nextLine().trim();
        if (id.isEmpty()) {
            System.out.println("✗ Selling Plan Group ID is required");
            return;
        }

        try {
            // First get the current group
            SellingPlanGroupResponse current = client.getSellingPlanService().getSellingPlanGroup(id);

            System.out.printf("\nCurrent Group: %s%n", current.getName());
            System.out.print("Enter new name (press Enter to keep current): ");
            String newName = scanner.nextLine().trim();
            if (newName.isEmpty()) {
                newName = current.getName();
            }

            System.out.printf("Status (current: %s). Change? (active/disabled/keep): ", current.getStatus());
            String statusStr = scanner.nextLine().trim().toLowerCase();

            String status = current.getStatus();
            if (statusStr.equals("active") || statusStr.equals("disabled")) {
                status = statusStr;
            }

            UpdateSellingPlanGroupRequest req = new UpdateSellingPlanGroupRequest();
            req.setName(newName);
            req.setDescription(current.getDescription());
            req.setOptions(current.getOptions());
            req.setStatus(status);

            SellingPlanGroupResponse response = client.getSellingPlanService().updateSellingPlanGroup(id, req);

            System.out.println("\n✓ Selling Plan Group Updated:");
            System.out.printf("  ID: %s%n", response.getId());
            System.out.printf("  Name: %s%n", response.getName());
            System.out.printf("  Status: %s%n", response.getStatus());
        } catch (IOException e) {
            System.out.printf("✗ API Error: %s%n", e.getMessage());
        }
    }

    /**
     * Deletes a selling plan group
     */
    public static void deleteSellingPlanGroup(MartianPayClient client) {
        System.out.println("Deleting Selling Plan Group...");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Selling Plan Group ID: ");
        String id = scanner.nextLine().trim();
        if (id.isEmpty()) {
            System.out.println("✗ Selling Plan Group ID is required");
            return;
        }

        System.out.print("Are you sure? (yes/no): ");
        String confirm = scanner.nextLine().trim().toLowerCase();
        if (!confirm.equals("yes")) {
            System.out.println("  Cancelled");
            return;
        }

        try {
            client.getSellingPlanService().deleteSellingPlanGroup(id);
            System.out.printf("✓ Selling Plan Group Deleted: %s%n", id);
        } catch (IOException e) {
            System.out.printf("✗ API Error: %s%n", e.getMessage());
            System.out.println("  Note: Cannot delete a group that has active selling plans");
        }
    }

    // ==================== Selling Plan Examples ====================

    /**
     * Lists all selling plans
     */
    public static void listSellingPlans(MartianPayClient client) {
        System.out.println("Listing Selling Plans...");

        Pagination params = new Pagination();
        params.setPage(0);
        params.setPageSize(20);

        try {
            ListSellingPlansResponse response = client.getSellingPlanService().listSellingPlans(params);

            System.out.printf("\n✓ Total Selling Plans: %d%n", response.getTotal());
            System.out.printf("  Page: %d/%d (Page Size: %d)%n%n",
                response.getOffset() / response.getLimit() + 1,
                (response.getTotal() + response.getLimit() - 1) / response.getLimit(),
                response.getLimit());

            if (response.getData() == null || response.getData().isEmpty()) {
                System.out.println("  No selling plans found");
                return;
            }

            int index = 1;
            for (SellingPlanResponse plan : response.getData()) {
                System.out.printf("[%d] %s%n", index++, plan.getName());
                System.out.printf("    ID: %s%n", plan.getId());
                System.out.printf("    Group ID: %s%n", plan.getSellingPlanGroupID());
                System.out.printf("    Type: %s%n", plan.getBillingPolicyType());
                System.out.printf("    Interval: Every %s %s%n",
                    plan.getBillingPolicy().getIntervalCount(),
                    plan.getBillingPolicy().getInterval());
                if (plan.getTrialPeriodDays() != null && !plan.getTrialPeriodDays().equals("0")) {
                    System.out.printf("    Trial: %s days%n", plan.getTrialPeriodDays());
                }
                if (plan.getPricingPolicy() != null && !plan.getPricingPolicy().isEmpty()) {
                    System.out.println("    Pricing Policies:");
                    for (PricingPolicyItem policy : plan.getPricingPolicy()) {
                        System.out.printf("      - %s: %s%% %s",
                            policy.getPolicyType(),
                            policy.getAdjustmentValue(),
                            policy.getAdjustmentType());
                        if (policy.getAfterCycle() != null) {
                            System.out.printf(" (after cycle %s)", policy.getAfterCycle());
                        }
                        System.out.println();
                    }
                }
                System.out.printf("    Priority: %s%n", plan.getPriority());
                System.out.printf("    Status: %s%n", plan.getStatus());
                System.out.printf("    Created: %d%n", plan.getCreatedAt());
                System.out.println();
            }
        } catch (IOException e) {
            System.out.printf("✗ API Error: %s%n", e.getMessage());
        }
    }

    /**
     * Creates a new selling plan
     */
    public static void createSellingPlan(MartianPayClient client) {
        System.out.println("Creating Selling Plan...");
        Scanner scanner = new Scanner(System.in);

        // First, list groups to select from
        System.out.println("  Fetching selling plan groups...");
        Pagination groupParams = new Pagination();
        groupParams.setPage(0);
        groupParams.setPageSize(10);

        try {
            ListSellingPlanGroupsResponse groupsResp = client.getSellingPlanService().listSellingPlanGroups(groupParams);

            if (groupsResp.getData() == null || groupsResp.getData().isEmpty()) {
                System.out.println("✗ No selling plan groups found. Please create one first.");
                return;
            }

            System.out.println("\n  Available Selling Plan Groups:");
            for (int i = 0; i < groupsResp.getData().size(); i++) {
                SellingPlanGroupResponse group = groupsResp.getData().get(i);
                System.out.printf("  [%d] %s (ID: %s)%n", i + 1, group.getName(), group.getId());
            }

            System.out.print("\nEnter group number or ID (or press Enter for first): ");
            String groupChoice = scanner.nextLine().trim();

            int selectedIdx = 0;
            if (!groupChoice.isEmpty()) {
                // Try to find by ID first
                boolean foundByID = false;
                for (int i = 0; i < groupsResp.getData().size(); i++) {
                    if (groupsResp.getData().get(i).getId().equals(groupChoice)) {
                        selectedIdx = i;
                        foundByID = true;
                        break;
                    }
                }

                // If not found by ID, try as number
                if (!foundByID) {
                    try {
                        int idx = Integer.parseInt(groupChoice);
                        if (idx > 0 && idx <= groupsResp.getData().size()) {
                            selectedIdx = idx - 1;
                        }
                    } catch (NumberFormatException e) {
                        // Use default
                    }
                }
            }

            SellingPlanGroupResponse selectedGroup = groupsResp.getData().get(selectedIdx);
            System.out.printf("  Selected: %s (ID: %s)%n%n", selectedGroup.getName(), selectedGroup.getId());

            // Provide example options
            System.out.println("  Example Selling Plans:");
            System.out.println("  [1] Monthly Subscription (10% off)");
            System.out.println("  [2] Quarterly Subscription (15% off)");
            System.out.println("  [3] Annual Subscription (20% off)");
            System.out.print("\nSelect example (or press Enter for #1): ");

            String exampleChoice = scanner.nextLine().trim();

            String name, description, interval, intervalCount, trialDays;
            List<PricingPolicyItemRequest> pricingPolicy = new ArrayList<>();

            switch (exampleChoice) {
                case "2":
                    name = "Quarterly Subscription";
                    description = "Save 15% with quarterly billing";
                    interval = "month";
                    intervalCount = "3";
                    trialDays = "7";
                    PricingPolicyItemRequest quarterlyPolicy = new PricingPolicyItemRequest();
                    quarterlyPolicy.setPolicyType("FIXED");
                    quarterlyPolicy.setAdjustmentType("PERCENTAGE");
                    quarterlyPolicy.setAdjustmentValue("15");
                    pricingPolicy.add(quarterlyPolicy);
                    break;
                case "3":
                    name = "Annual Subscription";
                    description = "Save 20% with annual billing";
                    interval = "year";
                    intervalCount = "1";
                    trialDays = "14";
                    PricingPolicyItemRequest annualPolicy = new PricingPolicyItemRequest();
                    annualPolicy.setPolicyType("FIXED");
                    annualPolicy.setAdjustmentType("PERCENTAGE");
                    annualPolicy.setAdjustmentValue("20");
                    pricingPolicy.add(annualPolicy);
                    break;
                default:
                    name = "Monthly Subscription";
                    description = "Save 10% with monthly billing";
                    interval = "month";
                    intervalCount = "1";
                    trialDays = "7";
                    PricingPolicyItemRequest monthlyPolicy = new PricingPolicyItemRequest();
                    monthlyPolicy.setPolicyType("FIXED");
                    monthlyPolicy.setAdjustmentType("PERCENTAGE");
                    monthlyPolicy.setAdjustmentValue("10");
                    pricingPolicy.add(monthlyPolicy);
                    break;
            }

            CreateSellingPlanRequest req = new CreateSellingPlanRequest();
            req.setSellingPlanGroupID(selectedGroup.getId());
            req.setName(name);
            req.setDescription(description);
            req.setBillingPolicyType("RECURRING");

            BillingPolicyRequest billingPolicy = new BillingPolicyRequest();
            billingPolicy.setInterval(interval);
            billingPolicy.setIntervalCount(intervalCount);
            req.setBillingPolicy(billingPolicy);

            req.setPricingPolicy(pricingPolicy);
            req.setTrialPeriodDays(trialDays);
            req.setPriority("1");

            System.out.println("\nSending request:");
            System.out.printf("  Group ID: %s%n", req.getSellingPlanGroupID());
            System.out.printf("  Name: %s%n", req.getName());
            System.out.printf("  Billing: Every %s %s%n", req.getBillingPolicy().getIntervalCount(), req.getBillingPolicy().getInterval());
            System.out.printf("  Trial Days: %s%n", req.getTrialPeriodDays());
            System.out.printf("  Priority: %s%n", req.getPriority());
            if (req.getPricingPolicy() != null && !req.getPricingPolicy().isEmpty()) {
                System.out.printf("  Pricing Policy: %d policies%n", req.getPricingPolicy().size());
            }

            SellingPlanResponse response = client.getSellingPlanService().createSellingPlan(req);

            System.out.println("\n✓ Selling Plan Created:");
            System.out.printf("  ID: %s%n", response.getId());
            System.out.printf("  Name: %s%n", response.getName());
            System.out.printf("  Description: %s%n", response.getDescription());
            System.out.printf("  Type: %s%n", response.getBillingPolicyType());
            System.out.printf("  Interval: Every %s %s%n",
                response.getBillingPolicy().getIntervalCount(),
                response.getBillingPolicy().getInterval());
            System.out.printf("  Trial Period: %s days%n", response.getTrialPeriodDays());
            if (response.getPricingPolicy() != null && !response.getPricingPolicy().isEmpty()) {
                System.out.println("  Pricing Policy:");
                for (PricingPolicyItem policy : response.getPricingPolicy()) {
                    System.out.printf("    - Type: %s, Adjustment: %s%% %s%n",
                        policy.getPolicyType(),
                        policy.getAdjustmentValue(),
                        policy.getAdjustmentType());
                }
            }
            System.out.printf("  Status: %s%n", response.getStatus());
        } catch (IOException e) {
            System.out.printf("✗ API Error: %s%n", e.getMessage());
        }
    }

    /**
     * Retrieves details of a specific selling plan
     */
    public static void getSellingPlan(MartianPayClient client) {
        System.out.println("Getting Selling Plan...");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Selling Plan ID: ");
        String id = scanner.nextLine().trim();
        if (id.isEmpty()) {
            id = "sp_example_id";
        }

        try {
            SellingPlanResponse response = client.getSellingPlanService().getSellingPlan(id);

            System.out.println("\n✓ Selling Plan Details:");
            System.out.printf("  ID: %s%n", response.getId());
            System.out.printf("  Group ID: %s%n", response.getSellingPlanGroupID());
            System.out.printf("  Name: %s%n", response.getName());
            System.out.printf("  Description: %s%n", response.getDescription());
            System.out.printf("  Type: %s%n", response.getBillingPolicyType());
            System.out.printf("  Status: %s%n", response.getStatus());
            System.out.printf("  Priority: %s%n", response.getPriority());

            System.out.println("\n  Billing Policy:");
            System.out.printf("    Interval: Every %s %s%n",
                response.getBillingPolicy().getIntervalCount(),
                response.getBillingPolicy().getInterval());
            if (response.getBillingPolicy().getMinCycles() != null) {
                System.out.printf("    Min Cycles: %s%n", response.getBillingPolicy().getMinCycles());
            }

            if (response.getTrialPeriodDays() != null && !response.getTrialPeriodDays().equals("0")) {
                System.out.printf("\n  Trial Period: %s days%n", response.getTrialPeriodDays());
            }

            if (response.getPricingPolicy() != null && !response.getPricingPolicy().isEmpty()) {
                System.out.println("\n  Pricing Policy:");
                int index = 1;
                for (PricingPolicyItem policy : response.getPricingPolicy()) {
                    System.out.printf("    [%d] Policy Type: %s%n", index++, policy.getPolicyType());
                    System.out.printf("        Adjustment: %s %s%n",
                        policy.getAdjustmentValue(),
                        policy.getAdjustmentType());
                    if (policy.getAfterCycle() != null) {
                        System.out.printf("        After Cycle: %s%n", policy.getAfterCycle());
                    }
                }
            }

            if (response.getValidFrom() != null) {
                System.out.printf("\n  Valid From: %d%n", response.getValidFrom());
            }
            if (response.getValidUntil() != null) {
                System.out.printf("  Valid Until: %d%n", response.getValidUntil());
            }

            System.out.printf("\n  Created: %d%n", response.getCreatedAt());
            System.out.printf("  Updated: %d%n", response.getUpdatedAt());
        } catch (IOException e) {
            System.out.printf("✗ API Error: %s%n", e.getMessage());
        }
    }

    /**
     * Updates an existing selling plan
     */
    public static void updateSellingPlan(MartianPayClient client) {
        System.out.println("Updating Selling Plan...");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Selling Plan ID: ");
        String id = scanner.nextLine().trim();
        if (id.isEmpty()) {
            System.out.println("✗ Selling Plan ID is required");
            return;
        }

        try {
            // First get the current plan
            SellingPlanResponse current = client.getSellingPlanService().getSellingPlan(id);

            System.out.printf("\nCurrent Plan: %s%n", current.getName());
            System.out.printf("Status (current: %s). Change? (active/disabled/keep): ", current.getStatus());
            String statusStr = scanner.nextLine().trim().toLowerCase();

            String status = current.getStatus();
            if (statusStr.equals("active") || statusStr.equals("disabled")) {
                status = statusStr;
            }

            UpdateSellingPlanRequest req = new UpdateSellingPlanRequest();
            req.setName(current.getName());
            req.setDescription(current.getDescription());
            req.setBillingPolicyType(current.getBillingPolicyType());
            req.setTrialPeriodDays(current.getTrialPeriodDays());
            req.setPriority(current.getPriority());
            req.setStatus(status);

            SellingPlanResponse response = client.getSellingPlanService().updateSellingPlan(id, req);

            System.out.println("\n✓ Selling Plan Updated:");
            System.out.printf("  ID: %s%n", response.getId());
            System.out.printf("  Name: %s%n", response.getName());
            System.out.printf("  Status: %s%n", response.getStatus());
        } catch (IOException e) {
            System.out.printf("✗ API Error: %s%n", e.getMessage());
        }
    }

    /**
     * Deletes a selling plan
     */
    public static void deleteSellingPlan(MartianPayClient client) {
        System.out.println("Deleting Selling Plan...");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Selling Plan ID: ");
        String id = scanner.nextLine().trim();
        if (id.isEmpty()) {
            System.out.println("✗ Selling Plan ID is required");
            return;
        }

        System.out.print("Are you sure? (yes/no): ");
        String confirm = scanner.nextLine().trim().toLowerCase();
        if (!confirm.equals("yes")) {
            System.out.println("  Cancelled");
            return;
        }

        try {
            client.getSellingPlanService().deleteSellingPlan(id);
            System.out.printf("✓ Selling Plan Deleted: %s%n", id);
        } catch (IOException e) {
            System.out.printf("✗ API Error: %s%n", e.getMessage());
        }
    }

    /**
     * Calculates subscription price for a variant
     */
    public static void calculateSellingPlanPrice(MartianPayClient client) {
        System.out.println("Calculating Selling Plan Price...");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Variant ID: ");
        String variantID = scanner.nextLine().trim();
        if (variantID.isEmpty()) {
            System.out.println("✗ Variant ID is required");
            return;
        }

        System.out.print("Enter Base Price: ");
        String basePrice = scanner.nextLine().trim();
        if (basePrice.isEmpty()) {
            basePrice = "29.99";
        }

        System.out.print("Enter Currency (e.g., USD): ");
        String currency = scanner.nextLine().trim();
        if (currency.isEmpty()) {
            currency = "USD";
        }

        System.out.print("Enter Selling Plan ID: ");
        String planID = scanner.nextLine().trim();
        if (planID.isEmpty()) {
            System.out.println("✗ Selling Plan ID is required");
            return;
        }

        Map<String, Object> params = new HashMap<>();
        params.put("variant_id", variantID);
        params.put("base_price", basePrice);
        params.put("currency", currency);
        params.put("plan_id", planID);

        try {
            CalculatePriceResponse response = client.getSellingPlanService().calculateSellingPlanPrice(params);

            System.out.println("\n✓ Subscription Price Calculation:");
            System.out.printf("  Base Price: %s %s%n", response.getBasePrice(), response.getCurrency());
            System.out.printf("  Billing Cycle: %s%n", response.getBillingCycle());
            System.out.printf("  Total Cycles: %d%n", response.getTotalCycles());
            if (response.getTrialPeriodDays() > 0) {
                System.out.printf("  Trial Period: %d days%n", response.getTrialPeriodDays());
            }
            System.out.printf("\n  Subtotal Before Discount: %s %s%n",
                response.getSubtotalBeforePolicy(), response.getCurrency());
            System.out.printf("  Selling Plan Discount: %s %s%n",
                response.getSellingPlanDiscount(), response.getCurrency());
            System.out.printf("  Final Subscription Price: %s %s%n",
                response.getSubtotalAfterPolicy(), response.getCurrency());
        } catch (IOException e) {
            System.out.printf("✗ API Error: %s%n", e.getMessage());
        }
    }
}
