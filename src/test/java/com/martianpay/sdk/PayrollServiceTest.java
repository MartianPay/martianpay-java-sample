package com.martianpay.sdk;

import com.martianpay.model.Asset;
import com.martianpay.model.Payroll;
import com.martianpay.sdk.AssetsService.AssetsListResponse;
import com.martianpay.sdk.PayrollService.PayrollDirectCreateRequest;
import com.martianpay.sdk.PayrollService.PayrollDirectCreateResponse;
import com.martianpay.sdk.PayrollService.PayrollDirectItem;
import com.martianpay.sdk.PayrollService.PayrollListRequest;
import com.martianpay.sdk.PayrollService.PayrollListResponse;
import com.martianpay.sdk.StatsService.BalanceResponse;
import com.martianpay.sdk.StatsService.BalanceDetail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for PayrollService
 *
 * Before running tests, update TestConfig.API_KEY with your actual API key.
 */
class PayrollServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(PayrollServiceTest.class);

    private PayrollService payrollService;
    private AssetsService assetsService;
    private StatsService statsService;

    @BeforeEach
    void setUp() {
        payrollService = new PayrollService(TestConfig.API_KEY);
        assetsService = new AssetsService(TestConfig.API_KEY);
        statsService = new StatsService(TestConfig.API_KEY);
    }

    @Test
    void testCreateDirectPayroll() throws IOException {
        logger.info("=== Test: Create Direct Payroll ===");

        // Step 1: Query assets to get crypto-only assets (payroll only supports crypto)
        AssetsListResponse assetsResponse = assetsService.listAssets();
        assertNotNull(assetsResponse);

        // Filter crypto assets that are payable
        List<Asset> cryptoAssets = new ArrayList<>();
        for (Asset asset : assetsResponse.getAssets()) {
            if (!asset.isFiat() && asset.isPayable() && asset.getCryptoAssetParams() != null) {
                cryptoAssets.add(asset);
            }
        }
        logger.info("Found {} crypto assets", cryptoAssets.size());

        // Step 2: Query merchant balance to find available coins
        BalanceResponse balance = statsService.getBalance();
        assertNotNull(balance);
        logger.info("Merchant balance summary: Currency={}, Available={}, Total={}",
                balance.getCurrency(), balance.getAvailableBalance(), balance.getTotalBalance());

        // Step 3: Match crypto assets with available balance >= 0.1
        String selectedCoin = null;
        String selectedNetwork = null;

        for (Asset asset : cryptoAssets) {
            for (BalanceDetail detail : balance.getBalanceDetails()) {
                if (detail.getCurrency().equals(asset.getId()) &&
                    detail.getAvailableBalance() != null &&
                    !detail.getAvailableBalance().equals("0") &&
                    !detail.getAvailableBalance().isEmpty()) {

                    try {
                        double availableFloat = Double.parseDouble(detail.getAvailableBalance());
                        if (availableFloat >= 0.1) {
                            selectedCoin = asset.getCoin();
                            selectedNetwork = asset.getCryptoAssetParams().getNetwork();
                            logger.info("Selected crypto asset with sufficient balance:");
                            logger.info("  Asset ID: {}", asset.getId());
                            logger.info("  Coin: {}", selectedCoin);
                            logger.info("  Network: {}", selectedNetwork);
                            logger.info("  Available Balance: {}", detail.getAvailableBalance());
                            break;
                        }
                    } catch (NumberFormatException e) {
                        // Skip invalid balance
                    }
                }
            }
            if (selectedCoin != null) {
                break;
            }
        }

        // Skip test if no sufficient balance available
        if (selectedCoin == null) {
            logger.warn("Skipping test - no crypto balance >= 0.1 found");
            return;
        }

        // Step 4: Generate unique external IDs using timestamp to avoid duplication
        long timestamp = System.nanoTime();
        String externalId = "ORDER-" + timestamp;
        String itemExternalId1 = "ITEM-" + timestamp + "-001";
        String itemExternalId2 = "ITEM-" + timestamp + "-002";

        // Step 5: Create request with auto-approval using selected coin/network
        PayrollDirectCreateRequest request = new PayrollDirectCreateRequest();
        request.setExternalId(externalId);
        request.setAutoApprove(true);

        List<PayrollDirectItem> items = new ArrayList<>();

        PayrollDirectItem item1 = new PayrollDirectItem();
        item1.setExternalId(itemExternalId1);
        item1.setName("John Doe");
        item1.setEmail("john@example.com");
        item1.setPhone("+1234567890");
        item1.setCoin(selectedCoin);
        item1.setNetwork(selectedNetwork);
        item1.setAddress("TN9RRaXkCFtTXRso2GdTZxSxxwufzxLQPP"); // TODO: Use dynamic address
        item1.setAmount("0.1");
        item1.setPaymentMethod("normal");
        items.add(item1);

        PayrollDirectItem item2 = new PayrollDirectItem();
        item2.setExternalId(itemExternalId2);
        item2.setCoin(selectedCoin);
        item2.setNetwork(selectedNetwork);
        item2.setAddress("TWd4WrZ9wn84f5x1hZhL4DHvk738ns5jwb"); // TODO: Use dynamic address
        item2.setAmount("0.1");
        item2.setPaymentMethod("normal");
        items.add(item2);

        request.setItems(items);

        // Call API
        PayrollDirectCreateResponse response = payrollService.createDirectPayroll(request);

        // Verify response
        assertNotNull(response);
        assertNotNull(response.getPayroll());
        assertNotNull(response.getPayroll().getId());
        assertEquals(externalId, response.getPayroll().getExternalId());
        assertEquals(2, response.getPayroll().getTotalItemNum());

        logger.info("Successfully created direct payroll:");
        logger.info("  Payroll ID: {}", response.getPayroll().getId());
        logger.info("  External ID: {}", response.getPayroll().getExternalId());
        logger.info("  Status: {}", response.getPayroll().getStatus());
        logger.info("  Approval Status: {}", response.getPayroll().getApprovalStatus());
        logger.info("  Total Items: {}", response.getPayroll().getTotalItemNum());
        logger.info("  Total Amount: {}", response.getPayroll().getTotalAmount());
        logger.info("  Total Service Fee: {}", response.getPayroll().getTotalServiceFee());
    }

    @Test
    void testGetPayroll() throws IOException {
        logger.info("=== Test: Get Payroll ===");

        // Replace with a valid payroll ID
        String payrollId = "payroll_I6mzarIW0qZ4itwGg7xCa9EA";

        try {
            Payroll response = payrollService.getPayroll(payrollId);

            assertNotNull(response);
            assertEquals(payrollId, response.getId());
            logger.info("Successfully retrieved payroll:");
            logger.info("  ID: {}", response.getId());
            logger.info("  External ID: {}", response.getExternalId());
            logger.info("  Status: {}", response.getStatus());
            logger.info("  Approval Status: {}", response.getApprovalStatus());
            logger.info("  Total Items: {}", response.getTotalItemNum());
            logger.info("  Total Amount: {}", response.getTotalAmount());
        } catch (IOException e) {
            logger.warn("Failed to get payroll (may not exist): {}", e.getMessage());
        }
    }

    @Test
    void testListPayrolls() throws IOException {
        logger.info("=== Test: List Payrolls ===");

        PayrollListRequest request = new PayrollListRequest();
        request.setPage(0);
        request.setPageSize(10);
        request.setExternalId("ORDER-2024-001"); // Optional filter

        PayrollListResponse response = payrollService.listPayrolls(request);

        assertNotNull(response);
        logger.info("Successfully retrieved payrolls:");
        logger.info("  Total Records: {}", response.getTotal());

        if (response.getPayrolls() != null) {
            for (Payroll payroll : response.getPayrolls()) {
                logger.info("  Payroll Details:");
                logger.info("    ID: {}", payroll.getId());
                logger.info("    External ID: {}", payroll.getExternalId());
                logger.info("    Status: {}", payroll.getStatus());
                logger.info("    Approval Status: {}", payroll.getApprovalStatus());
                logger.info("    Total Items: {}", payroll.getTotalItemNum());
                logger.info("    Total Amount: {}", payroll.getTotalAmount());
            }
        }
    }
}
