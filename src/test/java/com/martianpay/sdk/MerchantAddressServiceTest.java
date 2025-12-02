package com.martianpay.sdk;

import com.martianpay.model.MerchantAddress;
import com.martianpay.sdk.MerchantAddressService.MerchantAddressCreateRequest;
import com.martianpay.sdk.MerchantAddressService.MerchantAddressListRequest;
import com.martianpay.sdk.MerchantAddressService.MerchantAddressListResponse;
import com.martianpay.sdk.MerchantAddressService.MerchantAddressUpdateRequest;
import com.martianpay.sdk.MerchantAddressService.MerchantAddressVerifyRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for MerchantAddressService
 *
 * Before running tests, update TestConfig.API_KEY with your actual API key.
 */
class MerchantAddressServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(MerchantAddressServiceTest.class);

    private MerchantAddressService merchantAddressService;

    @BeforeEach
    void setUp() {
        merchantAddressService = new MerchantAddressService(TestConfig.API_KEY);
    }

    @Test
    void testCreateMerchantAddress() throws IOException {
        logger.info("=== Test: Create Merchant Address ===");

        // Create a merchant address
        // Note: Replace with your actual blockchain address
        MerchantAddressCreateRequest request = new MerchantAddressCreateRequest();
        request.setNetwork("Ethereum Sepolia"); // Test network
        request.setAddress("0x742d35Cc6634C0532925a3b844Bc9e7595f0bEb"); // Your Ethereum address

        try {
            MerchantAddress response = merchantAddressService.createMerchantAddress(request);

            assertNotNull(response);
            assertNotNull(response.getId());
            assertEquals(request.getNetwork(), response.getNetwork());
            assertEquals(request.getAddress(), response.getAddress());
            assertNotNull(response.getStatus()); // Should be "created" initially

            logger.info("Successfully created merchant address:");
            logger.info("  Address ID: {}", response.getId());
            logger.info("  Network: {}", response.getNetwork());
            logger.info("  Address: {}", response.getAddress());
            logger.info("  Status: {}", response.getStatus());

            // If verification is returned, log it
            if (response.getVerification() != null) {
                logger.info("Address verification details:");
                logger.info("  Verification ID: {}", response.getVerification().getId());
                logger.info("  Status: {}", response.getVerification().getStatus());
                logger.info("  Asset ID: {}", response.getVerification().getAssetId());
            }
        } catch (IOException e) {
            logger.warn("Failed to create merchant address: {}", e.getMessage());
        }
    }

    @Test
    void testGetMerchantAddress() throws IOException {
        logger.info("=== Test: Get Merchant Address ===");

        // Replace with an actual address ID from your account
        String addressId = "ma_xxxxxxxxxxxxxxxxxxxxxx";

        try {
            MerchantAddress response = merchantAddressService.getMerchantAddress(addressId);

            assertNotNull(response);
            assertEquals(addressId, response.getId());

            logger.info("Successfully retrieved merchant address:");
            logger.info("  Address ID: {}", response.getId());
            logger.info("  Network: {}", response.getNetwork());
            logger.info("  Address: {}", response.getAddress());
            logger.info("  Status: {}", response.getStatus());
            logger.info("  Alias: {}", response.getAlias());
            logger.info("  Created At: {}", response.getCreatedAt());

            if (response.getVerification() != null) {
                logger.info("Verification details:");
                logger.info("  Verification Status: {}", response.getVerification().getStatus());
                logger.info("  Tried Times: {}", response.getVerification().getTriedTimes());
                logger.info("  AML Status: {}", response.getVerification().getAmlStatus());
            }
        } catch (IOException e) {
            logger.warn("Failed to get merchant address (may not exist): {}", e.getMessage());
        }
    }

    @Test
    void testUpdateMerchantAddress() throws IOException {
        logger.info("=== Test: Update Merchant Address ===");

        // Replace with an actual address ID from your account
        String addressId = "ma_xxxxxxxxxxxxxxxxxxxxxx";

        MerchantAddressUpdateRequest request = new MerchantAddressUpdateRequest();
        request.setAlias("My Main Wallet");

        try {
            MerchantAddress response = merchantAddressService.updateMerchantAddress(addressId, request);

            assertNotNull(response);
            assertEquals(addressId, response.getId());
            assertEquals(request.getAlias(), response.getAlias());

            logger.info("Successfully updated merchant address:");
            logger.info("  Address ID: {}", response.getId());
            logger.info("  Alias: {}", response.getAlias());
            logger.info("  Network: {}", response.getNetwork());
            logger.info("  Address: {}", response.getAddress());
        } catch (IOException e) {
            logger.warn("Failed to update merchant address: {}", e.getMessage());
        }
    }

    @Test
    void testVerifyMerchantAddress() throws IOException {
        logger.info("=== Test: Verify Merchant Address ===");

        // Replace with an actual address ID from your account
        // You need to send a small test transaction to this address first
        String addressId = "ma_xxxxxxxxxxxxxxxxxxxxxx";

        MerchantAddressVerifyRequest request = new MerchantAddressVerifyRequest();
        request.setAmount("0.01"); // The amount you sent to verify ownership

        try {
            MerchantAddress response = merchantAddressService.verifyMerchantAddress(addressId, request);

            assertNotNull(response);
            assertEquals(addressId, response.getId());

            logger.info("Successfully initiated address verification:");
            logger.info("  Address ID: {}", response.getId());
            logger.info("  Status: {}", response.getStatus());

            if (response.getVerification() != null) {
                logger.info("Verification details:");
                logger.info("  Verification ID: {}", response.getVerification().getId());
                logger.info("  Verification Status: {}", response.getVerification().getStatus());
                logger.info("  Asset ID: {}", response.getVerification().getAssetId());
                logger.info("  Tried Times: {}", response.getVerification().getTriedTimes());
            }
        } catch (IOException e) {
            logger.warn("Failed to verify merchant address: {}", e.getMessage());
        }
    }

    @Test
    void testListMerchantAddresses() throws IOException {
        logger.info("=== Test: List Merchant Addresses ===");

        MerchantAddressListRequest request = new MerchantAddressListRequest();
        request.setPage(0);
        request.setPageSize(10);
        // Optional: filter by network
        // request.setNetwork("Ethereum Sepolia");

        MerchantAddressListResponse response = merchantAddressService.listMerchantAddresses(request);

        assertNotNull(response);

        logger.info("Successfully listed merchant addresses:");
        logger.info("  Total: {}", response.getTotal());
        logger.info("  Page: {}, Page Size: {}", response.getPage(), response.getPageSize());
        logger.info("  Count: {}", response.getMerchantAddresses() != null ?
                response.getMerchantAddresses().size() : 0);

        // Log each address
        if (response.getMerchantAddresses() != null) {
            for (int i = 0; i < response.getMerchantAddresses().size(); i++) {
                MerchantAddress addr = response.getMerchantAddresses().get(i);
                logger.info("  Merchant address details [{}]:", i);
                logger.info("    Address ID: {}", addr.getId());
                logger.info("    Network: {}", addr.getNetwork());
                logger.info("    Address: {}", addr.getAddress());
                logger.info("    Status: {}", addr.getStatus());
                logger.info("    Alias: {}", addr.getAlias());
            }
        }
    }

    @Test
    void testListMerchantAddressesByNetwork() throws IOException {
        logger.info("=== Test: List Merchant Addresses by Network ===");

        String network = "Ethereum Sepolia";
        MerchantAddressListRequest request = new MerchantAddressListRequest();
        request.setPage(0);
        request.setPageSize(10);
        request.setNetwork(network);

        MerchantAddressListResponse response = merchantAddressService.listMerchantAddresses(request);

        assertNotNull(response);

        logger.info("Successfully listed merchant addresses for network: {}", network);
        logger.info("  Total: {}", response.getTotal());
        logger.info("  Count: {}", response.getMerchantAddresses() != null ?
                response.getMerchantAddresses().size() : 0);

        // Verify all addresses are from the specified network
        if (response.getMerchantAddresses() != null) {
            for (MerchantAddress addr : response.getMerchantAddresses()) {
                assertEquals(network, addr.getNetwork());
                logger.info("  Address: ID={}, Address={}", addr.getId(), addr.getAddress());
            }
        }
    }

    @Test
    void testDeleteMerchantAddress() throws IOException {
        logger.info("=== Test: Delete Merchant Address ===");

        // Replace with an actual address ID from your account
        // WARNING: This will permanently delete the address
        String addressId = "ma_xxxxxxxxxxxxxxxxxxxxxx";

        try {
            merchantAddressService.deleteMerchantAddress(addressId);
            logger.info("Successfully deleted merchant address: {}", addressId);

            // Verify the address is deleted by trying to get it
            try {
                merchantAddressService.getMerchantAddress(addressId);
                fail("Should have thrown exception for deleted address");
            } catch (IOException e) {
                // Expected - address is deleted
                logger.info("Confirmed address is deleted (get returned error as expected)");
            }
        } catch (IOException e) {
            logger.warn("Failed to delete merchant address: {}", e.getMessage());
        }
    }

    @Test
    void testCreateAndVerifyMerchantAddress() throws IOException {
        // This test demonstrates the complete workflow:
        // 1. Create an address
        // 2. Send a test transaction to it (manual step)
        // 3. Verify ownership with the transaction amount

        logger.info("=== Test: Create and Verify Merchant Address (Full Workflow) ===");

        // Step 1: Create a merchant address
        MerchantAddressCreateRequest createRequest = new MerchantAddressCreateRequest();
        createRequest.setNetwork("Ethereum Sepolia");
        createRequest.setAddress("0x742d35Cc6634C0532925a3b844Bc9e7595f0bEb");

        try {
            MerchantAddress createResponse = merchantAddressService.createMerchantAddress(createRequest);
            assertNotNull(createResponse);

            String addressId = createResponse.getId();
            logger.info("Step 1: Created merchant address:");
            logger.info("  Address ID: {}", addressId);
            logger.info("  Network: {}", createResponse.getNetwork());
            logger.info("  Address: {}", createResponse.getAddress());

            // Step 2: Manual step - send a test transaction
            logger.info("\nStep 2: Send a test transaction to the address to verify ownership");
            logger.info("  MANUAL ACTION REQUIRED:");
            logger.info("    Address: {}", createResponse.getAddress());
            logger.info("    Network: {}", createResponse.getNetwork());
            logger.info("    Note: Send a small amount (e.g., 0.01 USDC) and note the exact amount");

            // For testing purposes, we'll skip the actual verification
            // In a real scenario, after sending the transaction, you would call:
            /*
            MerchantAddressVerifyRequest verifyRequest = new MerchantAddressVerifyRequest();
            verifyRequest.setAmount("0.01"); // The exact amount you sent
            MerchantAddress verifyResponse = merchantAddressService.verifyMerchantAddress(addressId, verifyRequest);
            logger.info("Step 3: Verification initiated: Status={}", verifyResponse.getStatus());
            */

            logger.info("\nSkipping verification step - requires manual transaction");
        } catch (IOException e) {
            logger.warn("Failed in create and verify workflow: {}", e.getMessage());
        }
    }
}
