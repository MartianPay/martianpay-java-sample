package com.martianpay.sdk;

import com.martianpay.model.Refund;
import com.martianpay.sdk.RefundService.RefundCreateRequest;
import com.martianpay.sdk.RefundService.RefundCreateResponse;
import com.martianpay.sdk.RefundService.RefundListRequest;
import com.martianpay.sdk.RefundService.RefundListResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for RefundService
 *
 * Before running tests, update TestConfig.API_KEY with your actual API key.
 */
class RefundServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(RefundServiceTest.class);

    private RefundService refundService;

    @BeforeEach
    void setUp() {
        refundService = new RefundService(TestConfig.API_KEY);
    }

    @Test
    void testCreateRefund() throws IOException {
        logger.info("=== Test: Create Refund ===");

        // Create request
        RefundCreateRequest request = new RefundCreateRequest();
        request.setPaymentIntent("pi_m3cL1pixO1D3c8A5iC18iGZo"); // Replace with valid payment intent ID
        request.setAmount("1");
        request.setReason("requested_by_customer");

        try {
            RefundCreateResponse response = refundService.createRefund(request);

            assertNotNull(response);
            assertNotNull(response.getRefunds());
            assertFalse(response.getRefunds().isEmpty());

            Refund refund = response.getRefunds().get(0);
            logger.info("Successfully created refund:");
            logger.info("  Refund ID: {}", refund.getId());
            logger.info("  Amount: {}", refund.getAmount());
            logger.info("  Payment Intent: {}", refund.getPaymentIntent());
            logger.info("  Status: {}", refund.getStatus());
        } catch (IOException e) {
            logger.warn("Failed to create refund (payment intent may not exist or not refundable): {}",
                    e.getMessage());
        }
    }

    @Test
    void testGetRefund() throws IOException {
        logger.info("=== Test: Get Refund ===");

        // Replace with a valid refund ID
        String refundId = "rf_ZTqX7HuMtGxaJ1KnizURLU9m";

        try {
            Refund response = refundService.getRefund(refundId);

            assertNotNull(response);
            assertEquals(refundId, response.getId());
            logger.info("Successfully retrieved refund:");
            logger.info("  ID: {}", response.getId());
            logger.info("  Amount: {}", response.getAmount());
            logger.info("  Status: {}", response.getStatus());
            logger.info("  Payment Intent: {}", response.getPaymentIntent());
        } catch (IOException e) {
            logger.warn("Failed to get refund (may not exist): {}", e.getMessage());
        }
    }

    @Test
    void testListRefunds() throws IOException {
        logger.info("=== Test: List Refunds ===");

        RefundListRequest request = new RefundListRequest();
        request.setPage(0);
        request.setPageSize(10);

        RefundListResponse response = refundService.listRefunds(request);

        assertNotNull(response);
        assertEquals(0, response.getPage());
        assertEquals(10, response.getPageSize());
        logger.info("Successfully retrieved refunds:");
        logger.info("  Total Records: {}", response.getTotal());
        logger.info("  Page: {}, Page Size: {}", response.getPage(), response.getPageSize());

        if (response.getRefunds() != null) {
            for (Refund refund : response.getRefunds()) {
                logger.info("  Refund Details:");
                logger.info("    ID: {}", refund.getId());
                logger.info("    Amount: {}", refund.getAmount());
                logger.info("    Status: {}", refund.getStatus());
                logger.info("    Payment Intent: {}", refund.getPaymentIntent());
            }
        }
    }
}
