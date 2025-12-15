package com.martianpay.examples;

import com.martianpay.developer.*;
import com.martianpay.sdk.MartianPayClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Payment Link Examples
 */
public class PaymentLinkExample {

    // List all payment links with pagination
    public static void listPaymentLinks(MartianPayClient client) {
        System.out.println("Listing Payment Links...");

        PaymentLinkListRequest req = new PaymentLinkListRequest();
        req.setPage(0);
        req.setPageSize(10);

        try {
            PaymentLinkListResponse response = client.getPaymentLinkService().listPaymentLinks(req);

            System.out.printf("✓ Total Payment Links: %d%n", response.getTotal());
            System.out.printf("  Page: %d, Page Size: %d%n%n", response.getPage(), response.getPageSize());

            if (response.getPaymentLinks() == null || response.getPaymentLinks().isEmpty()) {
                System.out.println("  No payment links found");
                return;
            }

            int index = 1;
            for (PaymentLink link : response.getPaymentLinks()) {
                System.out.printf("[%d] ID: %s%n", index++, link.getId());
                if (link.getProduct() != null) {
                    System.out.printf("    Product: %s%n", link.getProduct().getName());
                }
                System.out.printf("    Active: %b%n", link.getActive());
                if (link.getUrl() != null) {
                    System.out.printf("    URL: %s%n", link.getUrl());
                }
                if (link.getPriceRange() != null && link.getPriceRange().getMin() != null) {
                    System.out.printf("    Price Range: %s", link.getPriceRange().getMin().getAmount());
                    if (link.getPriceRange().getMax() != null &&
                        !link.getPriceRange().getMax().getAmount().equals(link.getPriceRange().getMin().getAmount())) {
                        System.out.printf(" - %s", link.getPriceRange().getMax().getAmount());
                    }
                    System.out.printf(" %s%n", link.getPriceRange().getMin().getAssetId());
                }
                if (link.getPrimaryVariants() != null && !link.getPrimaryVariants().isEmpty()) {
                    System.out.printf("    Primary Variants: %d%n", link.getPrimaryVariants().size());
                }
                if (link.getAddonVariants() != null && !link.getAddonVariants().isEmpty()) {
                    System.out.printf("    Addon Variants: %d%n", link.getAddonVariants().size());
                }
                System.out.printf("    Created: %d%n", link.getCreatedAt());
                System.out.println();
            }
        } catch (IOException e) {
            System.out.printf("✗ API Error: %s%n", e.getMessage());
        }
    }

    // Create a new payment link for a product
    public static void createPaymentLink(MartianPayClient client) {
        System.out.println("Creating Payment Link...");
        Scanner scanner = new Scanner(System.in);

        // First, list products to select from
        System.out.println("  Fetching products...");
        ProductListRequest productsReq = new ProductListRequest();
        productsReq.setPage(0);
        productsReq.setPageSize(10);

        try {
            ProductListResp productsResp = client.getProductService().listProducts(productsReq);

            if (productsResp.getProducts() == null || productsResp.getProducts().isEmpty()) {
                System.out.println("✗ No products found. Please create a product first.");
                return;
            }

            System.out.println("\n  Available Products:");
            for (int i = 0; i < productsResp.getProducts().size(); i++) {
                Product product = productsResp.getProducts().get(i);
                System.out.printf("  [%d] %s (ID: %s)%n", i + 1, product.getName(), product.getId());
                if (product.getVariants() != null && !product.getVariants().isEmpty()) {
                    System.out.printf("      Variants: %d%n", product.getVariants().size());
                }
            }

            System.out.print("\nEnter product number (or press Enter for first): ");
            String productChoice = scanner.nextLine().trim();

            int selectedIdx = 0;
            if (!productChoice.isEmpty()) {
                try {
                    int idx = Integer.parseInt(productChoice);
                    if (idx > 0 && idx <= productsResp.getProducts().size()) {
                        selectedIdx = idx - 1;
                    }
                } catch (NumberFormatException e) {
                    // Use default
                }
            }

            Product selectedProduct = productsResp.getProducts().get(selectedIdx);
            System.out.printf("  Selected: %s%n", selectedProduct.getName());

            PaymentLinkCreateRequest req = new PaymentLinkCreateRequest();
            req.setProductID(selectedProduct.getId());

            // If product has variants, select which ones to include
            if (selectedProduct.getVariants() != null && !selectedProduct.getVariants().isEmpty()) {
                System.out.printf("\n  Product has %d variants. Including all as primary variants.%n",
                    selectedProduct.getVariants().size());

                List<String> primaryVariantIDs = new ArrayList<>();
                for (ProductVariant variant : selectedProduct.getVariants()) {
                    if (variant.getActive()) {
                        primaryVariantIDs.add(variant.getId());
                    }
                }
                req.setPrimaryVariantIDs(primaryVariantIDs);

                // Set first variant as default
                if (!primaryVariantIDs.isEmpty()) {
                    req.setDefaultVariantID(primaryVariantIDs.get(0));
                }
            }

            PaymentLink paymentLink = client.getPaymentLinkService().createPaymentLink(req);

            System.out.println("\n✓ Payment Link Created:");
            System.out.printf("  ID: %s%n", paymentLink.getId());
            if (paymentLink.getUrl() != null) {
                System.out.printf("  URL: %s%n", paymentLink.getUrl());
                System.out.println("\n  🔗 Share this URL to accept payments!");
            }
            if (paymentLink.getProduct() != null) {
                System.out.printf("  Product: %s%n", paymentLink.getProduct().getName());
            }
            System.out.printf("  Active: %b%n", paymentLink.getActive());
            if (paymentLink.getPrimaryVariants() != null && !paymentLink.getPrimaryVariants().isEmpty()) {
                System.out.printf("  Primary Variants: %d%n", paymentLink.getPrimaryVariants().size());
            }
        } catch (IOException e) {
            System.out.printf("✗ API Error: %s%n", e.getMessage());
        }
    }

    // Get details of a specific payment link
    public static void getPaymentLink(MartianPayClient client) {
        System.out.println("Getting Payment Link...");
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter Payment Link ID: ");
        String id = scanner.nextLine().trim();
        if (id.isEmpty()) {
            id = "plink_example_id";
        }

        try {
            PaymentLink link = client.getPaymentLinkService().getPaymentLink(id);

            System.out.println("\n✓ Payment Link Details:");
            System.out.printf("  ID: %s%n", link.getId());
            if (link.getUrl() != null) {
                System.out.printf("  URL: %s%n", link.getUrl());
            }
            System.out.printf("  Active: %b%n", link.getActive());
            System.out.printf("  Created: %d%n", link.getCreatedAt());
            System.out.printf("  Updated: %d%n%n", link.getUpdatedAt());

            if (link.getProduct() != null) {
                System.out.println("Product:");
                System.out.printf("  Name: %s%n", link.getProduct().getName());
                System.out.printf("  ID: %s%n", link.getProduct().getId());
                if (link.getProduct().getDescription() != null && !link.getProduct().getDescription().isEmpty()) {
                    System.out.printf("  Description: %s%n", link.getProduct().getDescription());
                }
            }

            if (link.getPriceRange() != null) {
                System.out.println("\nPrice Range:");
                if (link.getPriceRange().getMin() != null) {
                    System.out.printf("  Min: %s %s%n",
                        link.getPriceRange().getMin().getAmount(),
                        link.getPriceRange().getMin().getAssetId());
                }
                if (link.getPriceRange().getMax() != null) {
                    System.out.printf("  Max: %s %s%n",
                        link.getPriceRange().getMax().getAmount(),
                        link.getPriceRange().getMax().getAssetId());
                }
            }
        } catch (IOException e) {
            System.out.printf("✗ API Error: %s%n", e.getMessage());
        }
    }

    // Update a payment link's active status
    public static void updatePaymentLink(MartianPayClient client) {
        System.out.println("Updating Payment Link...");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Payment Link ID: ");
        String id = scanner.nextLine().trim();
        if (id.isEmpty()) {
            System.out.println("✗ Payment Link ID is required");
            return;
        }

        try {
            // First get the current link
            PaymentLink current = client.getPaymentLinkService().getPaymentLink(id);

            System.out.printf("\nCurrent Status: Active = %b%n", current.getActive());
            System.out.print("Set active status (true/false/toggle): ");

            String activeStr = scanner.nextLine().trim().toLowerCase();

            boolean active;
            switch (activeStr) {
                case "true":
                case "t":
                case "1":
                case "yes":
                case "y":
                    active = true;
                    break;
                case "false":
                case "f":
                case "0":
                case "no":
                case "n":
                    active = false;
                    break;
                case "toggle":
                case "":
                    active = !current.getActive();
                    break;
                default:
                    System.out.printf("Invalid input '%s', toggling current status%n", activeStr);
                    active = !current.getActive();
                    break;
            }

            PaymentLinkUpdateRequest req = new PaymentLinkUpdateRequest();
            req.setActive(active);

            System.out.printf("Sending update request with Active = %b%n", req.getActive());

            PaymentLink link = client.getPaymentLinkService().updatePaymentLink(id, req);

            System.out.println("\n✓ Payment Link Updated:");
            System.out.printf("  ID: %s%n", link.getId());
            System.out.printf("  Active: %b%n", link.getActive());
            if (link.getUrl() != null) {
                System.out.printf("  URL: %s%n", link.getUrl());
            }
        } catch (IOException e) {
            System.out.printf("✗ API Error: %s%n", e.getMessage());
        }
    }

    // Delete an inactive payment link
    public static void deletePaymentLink(MartianPayClient client) {
        System.out.println("Deleting Payment Link...");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Payment Link ID: ");
        String id = scanner.nextLine().trim();
        if (id.isEmpty()) {
            System.out.println("✗ Payment Link ID is required");
            return;
        }

        System.out.print("Are you sure? (yes/no): ");
        String confirm = scanner.nextLine().trim().toLowerCase();
        if (!confirm.equals("yes")) {
            System.out.println("  Cancelled");
            return;
        }

        try {
            client.getPaymentLinkService().deletePaymentLink(id);
            System.out.printf("✓ Payment Link Deleted: %s%n", id);
        } catch (IOException e) {
            System.out.printf("✗ API Error: %s%n", e.getMessage());
            System.out.println("  Note: Only inactive payment links can be deleted");
        }
    }

    // List only active payment links
    public static void listActivePaymentLinks(MartianPayClient client) {
        System.out.println("Listing Active Payment Links...");

        PaymentLinkListRequest req = new PaymentLinkListRequest();
        req.setPage(0);
        req.setPageSize(10);
        req.setActive(true);

        try {
            PaymentLinkListResponse response = client.getPaymentLinkService().listPaymentLinks(req);

            System.out.printf("✓ Active Payment Links: %d%n%n", response.getTotal());

            if (response.getPaymentLinks() == null || response.getPaymentLinks().isEmpty()) {
                System.out.println("  No active payment links found");
                return;
            }

            int index = 1;
            for (PaymentLink link : response.getPaymentLinks()) {
                System.out.printf("[%d] ID: %s%n", index++, link.getId());
                if (link.getProduct() != null) {
                    System.out.printf("    Product: %s%n", link.getProduct().getName());
                }
                if (link.getUrl() != null) {
                    System.out.printf("    URL: %s%n", link.getUrl());
                }
                if (link.getPriceRange() != null && link.getPriceRange().getMin() != null) {
                    System.out.printf("    Price: %s %s",
                        link.getPriceRange().getMin().getAmount(),
                        link.getPriceRange().getMin().getAssetId());
                    if (link.getPriceRange().getMax() != null &&
                        !link.getPriceRange().getMax().getAmount().equals(link.getPriceRange().getMin().getAmount())) {
                        System.out.printf(" - %s %s",
                            link.getPriceRange().getMax().getAmount(),
                            link.getPriceRange().getMax().getAssetId());
                    }
                    System.out.println();
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.printf("✗ API Error: %s%n", e.getMessage());
        }
    }

    // List payment links for a specific product
    public static void listPaymentLinksByProduct(MartianPayClient client) {
        System.out.println("Listing Payment Links by Product...");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Product ID: ");
        String productID = scanner.nextLine().trim();
        if (productID.isEmpty()) {
            System.out.println("✗ Product ID is required");
            return;
        }

        PaymentLinkListRequest req = new PaymentLinkListRequest();
        req.setPage(0);
        req.setPageSize(10);
        req.setProduct(productID);

        try {
            PaymentLinkListResponse response = client.getPaymentLinkService().listPaymentLinks(req);

            System.out.printf("✓ Payment Links for Product %s: %d%n%n", productID, response.getTotal());

            if (response.getPaymentLinks() == null || response.getPaymentLinks().isEmpty()) {
                System.out.println("  No payment links found for this product");
                return;
            }

            int index = 1;
            for (PaymentLink link : response.getPaymentLinks()) {
                System.out.printf("[%d] ID: %s%n", index++, link.getId());
                System.out.printf("    Active: %b%n", link.getActive());
                if (link.getUrl() != null) {
                    System.out.printf("    URL: %s%n", link.getUrl());
                }
                if (link.getPrimaryVariants() != null && !link.getPrimaryVariants().isEmpty()) {
                    System.out.printf("    Primary Variants: %d%n", link.getPrimaryVariants().size());
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.printf("✗ API Error: %s%n", e.getMessage());
        }
    }
}
