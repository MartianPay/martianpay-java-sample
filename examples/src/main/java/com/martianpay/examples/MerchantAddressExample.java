package com.martianpay.examples;

import com.martianpay.model.MerchantAddress;
import com.martianpay.sdk.MerchantAddressService;
import com.martianpay.sdk.MerchantAddressService.MerchantAddressCreateRequest;
import com.martianpay.sdk.MerchantAddressService.MerchantAddressListRequest;
import com.martianpay.sdk.MerchantAddressService.MerchantAddressListResponse;
import com.martianpay.sdk.MerchantAddressService.MerchantAddressUpdateRequest;
import com.martianpay.sdk.MerchantAddressService.MerchantAddressVerifyRequest;

import java.io.IOException;
import java.util.Scanner;

/**
 * Merchant Address Examples
 *
 * This class demonstrates how to use the MerchantAddressService to manage merchant addresses (wallets).
 */
public class MerchantAddressExample {

    private final MerchantAddressService merchantAddressService;
    private final Scanner scanner;

    public MerchantAddressExample() {
        this.merchantAddressService = new MerchantAddressService(Common.API_KEY);
        this.scanner = new Scanner(System.in);
    }

    /**
     * Creates a new merchant address.
     */
    public void createMerchantAddress() {
        System.out.println("Creating Merchant Address...");

        MerchantAddressCreateRequest request = new MerchantAddressCreateRequest();
        request.setNetwork("Ethereum Sepolia");
        request.setAddress("0x742d35Cc6634C0532925a3b844Bc9e7595f0bEb");

        try {
            MerchantAddress response = merchantAddressService.createMerchantAddress(request);

            System.out.println("✓ Merchant Address Created:");
            System.out.println("  ID: " + response.getId());
            System.out.println("  Network: " + response.getNetwork());
            System.out.println("  Address: " + response.getAddress());
            System.out.println("  Status: " + response.getStatus());
        } catch (IOException e) {
            System.out.println("✗ API Error: " + e.getMessage());
        }
    }

    /**
     * Retrieves a merchant address by ID.
     */
    public void getMerchantAddress() {
        System.out.println("Getting Merchant Address...");
        System.out.print("Enter Address ID: ");

        String id = scanner.nextLine().trim();
        if (id.isEmpty()) {
            id = "ma_example_id";
        }

        try {
            MerchantAddress response = merchantAddressService.getMerchantAddress(id);

            System.out.println("✓ Merchant Address Retrieved:");
            System.out.println("  ID: " + response.getId());
            System.out.println("  Network: " + response.getNetwork());
            System.out.println("  Address: " + response.getAddress());
            System.out.println("  Status: " + response.getStatus());
            System.out.println("  Alias: " + response.getAlias());
        } catch (IOException e) {
            System.out.println("✗ API Error: " + e.getMessage());
        }
    }

    /**
     * Updates a merchant address.
     */
    public void updateMerchantAddress() {
        System.out.println("Updating Merchant Address...");
        System.out.print("Enter Address ID: ");

        String id = scanner.nextLine().trim();
        if (id.isEmpty()) {
            id = "ma_example_id";
        }

        MerchantAddressUpdateRequest request = new MerchantAddressUpdateRequest();
        request.setAlias("My Main Wallet");

        try {
            MerchantAddress response = merchantAddressService.updateMerchantAddress(id, request);

            System.out.println("✓ Merchant Address Updated:");
            System.out.println("  ID: " + response.getId());
            System.out.println("  Alias: " + response.getAlias());
        } catch (IOException e) {
            System.out.println("✗ API Error: " + e.getMessage());
        }
    }

    /**
     * Verifies a merchant address.
     * Note: You need to send a test transaction to the address first.
     */
    public void verifyMerchantAddress() {
        System.out.println("Verifying Merchant Address...");
        System.out.println("Note: You need to send a test transaction first");
        System.out.print("Enter Address ID: ");

        String id = scanner.nextLine().trim();
        if (id.isEmpty()) {
            id = "ma_example_id";
        }

        MerchantAddressVerifyRequest request = new MerchantAddressVerifyRequest();
        request.setAmount("0.01");

        try {
            MerchantAddress response = merchantAddressService.verifyMerchantAddress(id, request);

            System.out.println("✓ Verification Initiated:");
            System.out.println("  ID: " + response.getId());
            System.out.println("  Status: " + response.getStatus());
        } catch (IOException e) {
            System.out.println("✗ API Error: " + e.getMessage());
        }
    }

    /**
     * Lists all merchant addresses.
     */
    public void listMerchantAddresses() {
        System.out.println("Listing Merchant Addresses...");

        MerchantAddressListRequest request = new MerchantAddressListRequest();
        request.setPage(0);
        request.setPageSize(10);

        try {
            MerchantAddressListResponse response = merchantAddressService.listMerchantAddresses(request);

            System.out.println("✓ Total Addresses: " + response.getTotal());
            System.out.println();

            if (response.getMerchantAddresses() != null) {
                for (int i = 0; i < response.getMerchantAddresses().size(); i++) {
                    MerchantAddress addr = response.getMerchantAddresses().get(i);
                    System.out.println("  [" + (i + 1) + "] ID: " + addr.getId());
                    System.out.println("      Network: " + addr.getNetwork() + ", Status: " + addr.getStatus());
                    System.out.println("      Address: " + addr.getAddress());
                }
            }
        } catch (IOException e) {
            System.out.println("✗ API Error: " + e.getMessage());
        }
    }

    /**
     * Lists merchant addresses filtered by network.
     */
    public void listMerchantAddressesByNetwork() {
        System.out.println("Listing Merchant Addresses by Network...");
        System.out.print("Enter Network (e.g., Ethereum Sepolia): ");

        String network = scanner.nextLine().trim();
        if (network.isEmpty()) {
            network = "Ethereum Sepolia";
        }

        MerchantAddressListRequest request = new MerchantAddressListRequest();
        request.setPage(0);
        request.setPageSize(10);
        request.setNetwork(network);

        try {
            MerchantAddressListResponse response = merchantAddressService.listMerchantAddresses(request);

            System.out.println("✓ Total Addresses for " + network + ": " + response.getTotal());
            System.out.println();

            if (response.getMerchantAddresses() != null) {
                for (int i = 0; i < response.getMerchantAddresses().size(); i++) {
                    MerchantAddress addr = response.getMerchantAddresses().get(i);
                    System.out.println("  [" + (i + 1) + "] ID: " + addr.getId() + ", Address: " + addr.getAddress());
                }
            }
        } catch (IOException e) {
            System.out.println("✗ API Error: " + e.getMessage());
        }
    }

    /**
     * Deletes a merchant address.
     */
    public void deleteMerchantAddress() {
        System.out.println("Deleting Merchant Address...");
        System.out.print("Enter Address ID: ");

        String id = scanner.nextLine().trim();
        if (id.isEmpty()) {
            System.out.println("  Address ID required");
            return;
        }

        try {
            merchantAddressService.deleteMerchantAddress(id);
            System.out.println("✓ Merchant Address Deleted: " + id);
        } catch (IOException e) {
            System.out.println("✗ API Error: " + e.getMessage());
        }
    }

    /**
     * Demonstrates the complete workflow of creating and verifying a merchant address.
     */
    public void createAndVerifyMerchantAddress() {
        System.out.println("Create and Verify Merchant Address (Full Workflow)...");

        MerchantAddressCreateRequest request = new MerchantAddressCreateRequest();
        request.setNetwork("Ethereum Sepolia");
        request.setAddress("0x742d35Cc6634C0532925a3b844Bc9e7595f0bEb");

        try {
            MerchantAddress response = merchantAddressService.createMerchantAddress(request);

            System.out.println("✓ Step 1: Address Created");
            System.out.println("  ID: " + response.getId());
            System.out.println("  Address: " + response.getAddress());
            System.out.println();
            System.out.println("Step 2: Send a test transaction to this address");
            System.out.println("Step 3: Call verify API with the transaction amount");
            System.out.println();
            System.out.println("(Skipping verification - requires manual transaction)");
        } catch (IOException e) {
            System.out.println("✗ API Error: " + e.getMessage());
        }
    }
}
