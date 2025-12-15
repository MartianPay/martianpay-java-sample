package com.martianpay.examples;

import com.martianpay.developer.*;
import com.martianpay.sdk.MartianPayClient;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Product Examples
 */
public class ProductExample {

    // List all products with pagination
    public static void listProducts(MartianPayClient client) {
        System.out.println("Listing Products...");

        ProductListRequest req = new ProductListRequest();
        req.setPage(0);
        req.setPageSize(10);

        try {
            ProductListResp response = client.getProductService().listProducts(req);

            System.out.printf("✓ Total Products: %d%n", response.getTotal());
            System.out.printf("  Page: %d, Page Size: %d%n%n", response.getPage(), response.getPageSize());

            if (response.getProducts() == null || response.getProducts().isEmpty()) {
                System.out.println("  No products found");
                return;
            }

            int index = 1;
            for (Product product : response.getProducts()) {
                System.out.printf("[%d] %s%n", index++, product.getName());
                System.out.printf("    ID: %s%n", product.getId());
                System.out.printf("    Active: %b%n", product.getActive());
                if (product.getDescription() != null && !product.getDescription().isEmpty()) {
                    String desc = product.getDescription();
                    if (desc.length() > 60) {
                        desc = desc.substring(0, 60) + "...";
                    }
                    System.out.printf("    Description: %s%n", desc);
                }
                if (product.getPrice() != null) {
                    System.out.printf("    Price: %s %s%n",
                        product.getPrice().getAmount(), product.getPrice().getAssetId());
                }
                if (product.getVariants() != null && !product.getVariants().isEmpty()) {
                    System.out.printf("    Variants: %d%n", product.getVariants().size());
                }
                if (product.getRequiresSellingPlan()) {
                    System.out.println("    Type: Subscription Only");
                }
                System.out.printf("    Created: %d%n", product.getCreatedAt());
                System.out.println();
            }
        } catch (IOException e) {
            System.out.printf("✗ API Error: %s%n", e.getMessage());
        }
    }

    // Create a product with multiple variants
    public static void createProductWithVariants(MartianPayClient client) {
        System.out.println("Creating Product with Variants...");
        System.out.println("This example creates a T-shirt with Size and Color variants");

        String name = "Premium T-Shirt";
        String description = "High-quality cotton t-shirt available in multiple sizes and colors";

        // Define options
        List<ProductOption> options = new ArrayList<>();

        // Color option
        ProductOption colorOption = new ProductOption();
        colorOption.setName("Color");
        colorOption.setSortOrder(0);

        List<ProductOptionValue> colorValues = new ArrayList<>();
        ProductOptionValue black = new ProductOptionValue();
        black.setValue("Black");
        black.setSortOrder(0);
        ProductOptionSwatch blackSwatch = new ProductOptionSwatch();
        blackSwatch.setType("color");
        blackSwatch.setValue("#000000");
        black.setSwatch(blackSwatch);
        colorValues.add(black);

        ProductOptionValue white = new ProductOptionValue();
        white.setValue("White");
        white.setSortOrder(1);
        ProductOptionSwatch whiteSwatch = new ProductOptionSwatch();
        whiteSwatch.setType("color");
        whiteSwatch.setValue("#FFFFFF");
        white.setSwatch(whiteSwatch);
        colorValues.add(white);

        ProductOptionValue blue = new ProductOptionValue();
        blue.setValue("Blue");
        blue.setSortOrder(2);
        ProductOptionSwatch blueSwatch = new ProductOptionSwatch();
        blueSwatch.setType("color");
        blueSwatch.setValue("#0000FF");
        blue.setSwatch(blueSwatch);
        colorValues.add(blue);

        colorOption.setValues(colorValues);
        options.add(colorOption);

        // Size option
        ProductOption sizeOption = new ProductOption();
        sizeOption.setName("Size");
        sizeOption.setSortOrder(1);

        List<ProductOptionValue> sizeValues = new ArrayList<>();
        ProductOptionValue small = new ProductOptionValue();
        small.setValue("Small");
        small.setSortOrder(0);
        ProductOptionSwatch textSwatch = new ProductOptionSwatch();
        textSwatch.setType("text");
        small.setSwatch(textSwatch);
        sizeValues.add(small);

        ProductOptionValue medium = new ProductOptionValue();
        medium.setValue("Medium");
        medium.setSortOrder(1);
        medium.setSwatch(textSwatch);
        sizeValues.add(medium);

        ProductOptionValue large = new ProductOptionValue();
        large.setValue("Large");
        large.setSortOrder(2);
        large.setSwatch(textSwatch);
        sizeValues.add(large);

        sizeOption.setValues(sizeValues);
        options.add(sizeOption);

        // Define variants - Must cover all option combinations (3 sizes × 3 colors = 9 variants)
        Integer inventoryQty = 100;
        List<ProductVariant> variants = new ArrayList<>();

        String[] colors = {"Black", "White", "Blue"};
        String[] sizes = {"Small", "Medium", "Large"};
        double[] prices = {25.00, 27.00, 29.00};

        for (String color : colors) {
            for (int i = 0; i < sizes.length; i++) {
                ProductVariant variant = new ProductVariant();
                Map<String, String> optionValues = new HashMap<>();
                optionValues.put("Size", sizes[i]);
                optionValues.put("Color", color);
                variant.setOptionValues(optionValues);

                AssetAmount price = new AssetAmount();
                price.setAmount(new BigDecimal(prices[i]));
                price.setAssetId("USD");
                variant.setPrice(price);

                variant.setInventoryQuantity(inventoryQty);
                variant.setActive(true);
                variants.add(variant);
            }
        }

        ProductCreateRequest req = new ProductCreateRequest();
        req.setName(name);
        req.setDescription(description);
        req.setActive(true);
        req.setDefaultCurrency("USD");
        req.setTaxCode("txcd_99999999"); // General tangible goods tax code
        req.setCollectShippingAddress(true);
        req.setCollectTaxAddress(true);
        req.setOptions(options);
        req.setVariants(variants);

        Map<String, String> metadata = new HashMap<>();
        metadata.put("category", "apparel");
        metadata.put("sku", "TSHIRT-001");
        req.setMetadata(metadata);

        try {
            Product response = client.getProductService().createProduct(req);

            System.out.println("\n✓ Product with Variants Created:");
            System.out.printf("  ID: %s%n", response.getId());
            System.out.printf("  Name: %s%n", response.getName());
            System.out.printf("  Options: %d%n", response.getOptions().size());
            for (ProductOption opt : response.getOptions()) {
                System.out.printf("    - %s: %d values%n", opt.getName(), opt.getValues().size());
            }
            System.out.printf("  Variants: %d%n", response.getVariants().size());
            int index = 1;
            for (ProductVariant variant : response.getVariants()) {
                System.out.printf("    [%d] ", index++);
                for (Map.Entry<String, String> entry : variant.getOptionValues().entrySet()) {
                    System.out.printf("%s: %s, ", entry.getKey(), entry.getValue());
                }
                if (variant.getPrice() != null) {
                    System.out.printf("Price: %s %s", variant.getPrice().getAmount(), variant.getPrice().getAssetId());
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.printf("✗ API Error: %s%n", e.getMessage());
        }
    }

    // Create a product with selling plan group attached
    public static void createProductWithSellingPlan(MartianPayClient client) {
        System.out.println("Creating Product with Selling Plan...");
        System.out.println("This example creates a subscription product with selling plan group");
        Scanner scanner = new Scanner(System.in);

        // First, list selling plan groups to select from
        System.out.println("\n  Fetching selling plan groups...");

        try {
            Pagination pagination = new Pagination();
            pagination.setPage(0);
            pagination.setPageSize(10);

            ListSellingPlanGroupsResponse groupsResp = client.getSellingPlanService().listSellingPlanGroups(pagination);

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
            System.out.printf("  Selected: %s (ID: %s)%n", selectedGroup.getName(), selectedGroup.getId());

            // Ask if subscription is required
            System.out.print("\nRequire subscription? (y=subscription only, n=one-time or subscription) [n]: ");
            String requiresSubStr = scanner.nextLine().trim().toLowerCase();
            boolean requiresSellingPlan = requiresSubStr.equals("y");

            String name = "Monthly Newsletter Subscription";
            String description = "Premium newsletter subscription with exclusive content";

            // Define simple variant structure for subscription product
            List<ProductOption> options = new ArrayList<>();

            // Tier option
            ProductOption tierOption = new ProductOption();
            tierOption.setName("Tier");
            tierOption.setSortOrder(0);

            List<ProductOptionValue> tierValues = new ArrayList<>();

            ProductOptionValue basicValue = new ProductOptionValue();
            basicValue.setValue("Basic");
            basicValue.setSortOrder(0);
            ProductOptionSwatch textSwatch = new ProductOptionSwatch();
            textSwatch.setType("text");
            basicValue.setSwatch(textSwatch);
            tierValues.add(basicValue);

            ProductOptionValue premiumValue = new ProductOptionValue();
            premiumValue.setValue("Premium");
            premiumValue.setSortOrder(1);
            premiumValue.setSwatch(textSwatch);
            tierValues.add(premiumValue);

            tierOption.setValues(tierValues);
            options.add(tierOption);

            // Define variants
            Integer inventoryQty = 999;
            List<ProductVariant> variants = new ArrayList<>();

            // Basic variant
            ProductVariant basicVariant = new ProductVariant();
            Map<String, String> basicOptionValues = new HashMap<>();
            basicOptionValues.put("Tier", "Basic");
            basicVariant.setOptionValues(basicOptionValues);
            AssetAmount basicPrice = new AssetAmount();
            basicPrice.setAmount(new BigDecimal("9.99"));
            basicPrice.setAssetId("USD");
            basicVariant.setPrice(basicPrice);
            basicVariant.setInventoryQuantity(inventoryQty);
            basicVariant.setActive(true);
            variants.add(basicVariant);

            // Premium variant
            ProductVariant premiumVariant = new ProductVariant();
            Map<String, String> premiumOptionValues = new HashMap<>();
            premiumOptionValues.put("Tier", "Premium");
            premiumVariant.setOptionValues(premiumOptionValues);
            AssetAmount premiumPrice = new AssetAmount();
            premiumPrice.setAmount(new BigDecimal("19.99"));
            premiumPrice.setAssetId("USD");
            premiumVariant.setPrice(premiumPrice);
            premiumVariant.setInventoryQuantity(inventoryQty);
            premiumVariant.setActive(true);
            variants.add(premiumVariant);

            ProductCreateRequest req = new ProductCreateRequest();
            req.setName(name);
            req.setDescription(description);
            req.setActive(true);
            req.setDefaultCurrency("USD");
            req.setTaxCode("txcd_10000000"); // Digital goods tax code
            req.setCollectShippingAddress(false); // No shipping for digital products
            req.setCollectTaxAddress(true);
            req.setRequiresSellingPlan(requiresSellingPlan);

            List<String> sellingPlanGroupIDs = new ArrayList<>();
            sellingPlanGroupIDs.add(selectedGroup.getId());
            req.setSellingPlanGroupIDs(sellingPlanGroupIDs);

            req.setOptions(options);
            req.setVariants(variants);

            Map<String, String> metadata = new HashMap<>();
            metadata.put("category", "subscription");
            metadata.put("type", "newsletter");
            req.setMetadata(metadata);

            Product response = client.getProductService().createProduct(req);

            System.out.println("\n✓ Product with Selling Plan Created:");
            System.out.printf("  ID: %s%n", response.getId());
            System.out.printf("  Name: %s%n", response.getName());
            System.out.printf("  Description: %s%n", response.getDescription());
            System.out.printf("  Requires Selling Plan: %b%n", response.getRequiresSellingPlan());
            if (response.getSellingPlanGroupIds() != null && !response.getSellingPlanGroupIds().isEmpty()) {
                System.out.printf("  Selling Plan Groups: %d%n", response.getSellingPlanGroupIds().size());
                for (String spgID : response.getSellingPlanGroupIds()) {
                    System.out.printf("    - %s%n", spgID);
                }
            }
            System.out.printf("  Options: %d%n", response.getOptions().size());
            for (ProductOption opt : response.getOptions()) {
                System.out.printf("    - %s: %d values%n", opt.getName(), opt.getValues().size());
            }
            System.out.printf("  Variants: %d%n", response.getVariants().size());
            int index = 1;
            for (ProductVariant variant : response.getVariants()) {
                System.out.printf("    [%d] ", index++);
                for (Map.Entry<String, String> entry : variant.getOptionValues().entrySet()) {
                    System.out.printf("%s: %s, ", entry.getKey(), entry.getValue());
                }
                if (variant.getPrice() != null) {
                    System.out.printf("Price: %s %s", variant.getPrice().getAmount(), variant.getPrice().getAssetId());
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.printf("✗ API Error: %s%n", e.getMessage());
        }
    }

    // Get details of a specific product
    public static void getProduct(MartianPayClient client) {
        System.out.println("Getting Product...");
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter Product ID: ");
        String id = scanner.nextLine().trim();
        if (id.isEmpty()) {
            id = "prod_example_id";
        }

        try {
            Product response = client.getProductService().getProduct(id);

            System.out.println("\n✓ Product Details:");
            System.out.printf("  ID: %s%n", response.getId());
            System.out.printf("  Name: %s%n", response.getName());
            System.out.printf("  Description: %s%n", response.getDescription());
            System.out.printf("  Active: %b%n", response.getActive());
            System.out.printf("  Default Currency: %s%n", response.getDefaultCurrency());
            if (response.getPrice() != null) {
                System.out.printf("  Price: %s %s%n",
                    response.getPrice().getAmount(), response.getPrice().getAssetId());
            }
            System.out.printf("  Collect Shipping: %b%n", response.getCollectShippingAddress());
            System.out.printf("  Collect Tax: %b%n", response.getCollectTaxAddress());
            System.out.printf("  Requires Subscription: %b%n", response.getRequiresSellingPlan());
            System.out.printf("  Version: %d%n", response.getVersion());
            System.out.printf("  Created: %d%n", response.getCreatedAt());
            System.out.printf("  Updated: %d%n%n", response.getUpdatedAt());

            if (response.getOptions() != null && !response.getOptions().isEmpty()) {
                System.out.println("  Options:");
                for (ProductOption opt : response.getOptions()) {
                    System.out.printf("    - %s:%n", opt.getName());
                    for (ProductOptionValue val : opt.getValues()) {
                        System.out.printf("      • %s%n", val.getValue());
                    }
                }
                System.out.println();
            }

            if (response.getVariants() != null && !response.getVariants().isEmpty()) {
                System.out.printf("  Variants (%d):%n", response.getVariants().size());
                int index = 1;
                for (ProductVariant variant : response.getVariants()) {
                    System.out.printf("    [%d] ID: %s%n", index++, variant.getId());
                    System.out.print("        Options: ");
                    for (Map.Entry<String, String> entry : variant.getOptionValues().entrySet()) {
                        System.out.printf("%s=%s ", entry.getKey(), entry.getValue());
                    }
                    System.out.println();
                    if (variant.getPrice() != null) {
                        System.out.printf("        Price: %s %s%n",
                            variant.getPrice().getAmount(), variant.getPrice().getAssetId());
                    }
                    System.out.printf("        Active: %b%n", variant.getActive());
                }
            }

            if (response.getMetadata() != null && !response.getMetadata().isEmpty()) {
                System.out.println("\n  Metadata:");
                for (Map.Entry<String, String> entry : response.getMetadata().entrySet()) {
                    System.out.printf("    %s: %s%n", entry.getKey(), entry.getValue());
                }
            }
        } catch (IOException e) {
            System.out.printf("✗ API Error: %s%n", e.getMessage());
        }
    }

    // Update an existing product
    public static void updateProduct(MartianPayClient client) {
        System.out.println("Updating Product...");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Product ID: ");
        String id = scanner.nextLine().trim();
        if (id.isEmpty()) {
            System.out.println("✗ Product ID is required");
            return;
        }

        try {
            // First get the current product
            Product current = client.getProductService().getProduct(id);

            System.out.printf("\nCurrent Product: %s%n", current.getName());
            System.out.print("Enter new name (press Enter to keep current): ");
            String newName = scanner.nextLine().trim();
            if (newName.isEmpty()) {
                newName = current.getName();
            }

            System.out.printf("Active status (current: %b). Change? (y/n): ", current.getActive());
            String changeActive = scanner.nextLine().trim().toLowerCase();

            boolean active = current.getActive();
            if (changeActive.equals("y")) {
                active = !active;
            }

            ProductUpdateRequest req = new ProductUpdateRequest();
            req.setName(newName);
            req.setDescription(current.getDescription());
            req.setActive(active);
            req.setDefaultCurrency(current.getDefaultCurrency());
            req.setTaxCode(current.getTaxCode());
            req.setCollectShippingAddress(current.getCollectShippingAddress());
            req.setCollectTaxAddress(current.getCollectTaxAddress());
            req.setRequiresSellingPlan(current.getRequiresSellingPlan());
            req.setSellingPlanGroupIDs(current.getSellingPlanGroupIds());
            req.setOptions(current.getOptions());
            req.setVariants(current.getVariants());
            req.setMetadata(current.getMetadata());
            req.setVersion(current.getVersion()); // Required for optimistic locking

            Product response = client.getProductService().updateProduct(id, req);

            System.out.println("\n✓ Product Updated:");
            System.out.printf("  ID: %s%n", response.getId());
            System.out.printf("  Name: %s%n", response.getName());
            System.out.printf("  Active: %b%n", response.getActive());
            System.out.printf("  Version: %d%n", response.getVersion());
        } catch (IOException e) {
            System.out.printf("✗ API Error: %s%n", e.getMessage());
        }
    }

    // Delete an inactive product
    public static void deleteProduct(MartianPayClient client) {
        System.out.println("Deleting Product...");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Product ID: ");
        String id = scanner.nextLine().trim();
        if (id.isEmpty()) {
            System.out.println("✗ Product ID is required");
            return;
        }

        System.out.print("Are you sure? (yes/no): ");
        String confirm = scanner.nextLine().trim().toLowerCase();
        if (!confirm.equals("yes")) {
            System.out.println("  Cancelled");
            return;
        }

        try {
            client.getProductService().deleteProduct(id);
            System.out.printf("✓ Product Deleted: %s%n", id);
        } catch (IOException e) {
            System.out.printf("✗ API Error: %s%n", e.getMessage());
            System.out.println("  Note: Only inactive products can be deleted");
        }
    }

    // List only active products
    public static void listActiveProducts(MartianPayClient client) {
        System.out.println("Listing Active Products...");

        ProductListRequest req = new ProductListRequest();
        req.setPage(0);
        req.setPageSize(10);
        req.setActive(true);

        try {
            ProductListResp response = client.getProductService().listProducts(req);

            System.out.printf("✓ Active Products: %d%n%n", response.getTotal());

            if (response.getProducts() == null || response.getProducts().isEmpty()) {
                System.out.println("  No active products found");
                return;
            }

            int index = 1;
            for (Product product : response.getProducts()) {
                System.out.printf("[%d] %s (ID: %s)%n", index++, product.getName(), product.getId());
                if (product.getPrice() != null) {
                    System.out.printf("    Price: %s %s%n",
                        product.getPrice().getAmount(), product.getPrice().getAssetId());
                }
                if (product.getVariants() != null && !product.getVariants().isEmpty()) {
                    System.out.printf("    Variants: %d%n", product.getVariants().size());
                }
            }
        } catch (IOException e) {
            System.out.printf("✗ API Error: %s%n", e.getMessage());
        }
    }
}
