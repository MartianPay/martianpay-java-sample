package com.martianpay.examples;

import com.martianpay.model.Asset;
import com.martianpay.model.Payroll;
import com.martianpay.sdk.AssetsService;
import com.martianpay.sdk.AssetsService.AssetsListResponse;
import com.martianpay.sdk.PayrollService;
import com.martianpay.sdk.PayrollService.PayrollDirectCreateRequest;
import com.martianpay.sdk.PayrollService.PayrollDirectCreateResponse;
import com.martianpay.sdk.PayrollService.PayrollDirectItem;
import com.martianpay.sdk.PayrollService.PayrollListRequest;
import com.martianpay.sdk.PayrollService.PayrollListResponse;
import com.martianpay.sdk.StatsService;
import com.martianpay.sdk.StatsService.BalanceDetail;
import com.martianpay.sdk.StatsService.BalanceResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Payroll Examples
 *
 * This class demonstrates how to use the PayrollService to manage payrolls.
 */
public class PayrollExample {

    private final PayrollService payrollService;
    private final AssetsService assetsService;
    private final StatsService statsService;
    private final Scanner scanner;

    public PayrollExample() {
        this.payrollService = new PayrollService(Common.API_KEY);
        this.assetsService = new AssetsService(Common.API_KEY);
        this.statsService = new StatsService(Common.API_KEY);
        this.scanner = new Scanner(System.in);
    }

    /**
     * Creates a direct payroll with auto-approval.
     */
    public void createDirectPayroll() {
        System.out.println("Creating Direct Payroll...");

        try {
            // Query assets
            AssetsListResponse assetsResponse = assetsService.listAssets();
            if (assetsResponse == null || assetsResponse.getAssets() == null) {
                System.out.println("✗ Failed to get assets");
                return;
            }

            List<Asset> cryptoAssets = new ArrayList<>();
            for (Asset asset : assetsResponse.getAssets()) {
                if (!asset.isFiat() && asset.isPayable() && asset.getCryptoAssetParams() != null) {
                    cryptoAssets.add(asset);
                }
            }

            System.out.println("  Found " + cryptoAssets.size() + " crypto assets");

            // Query balance
            BalanceResponse balance = statsService.getBalance();
            if (balance == null || balance.getBalances() == null) {
                System.out.println("✗ Failed to get balance or balance list is empty");
                return;
            }

            // Match assets with balance
            String selectedCoin = null;
            String selectedNetwork = null;

            for (Asset asset : cryptoAssets) {
                for (BalanceDetail detail : balance.getBalances()) {
                    if (detail.getAssetId().equals(asset.getId()) &&
                        detail.getAvailable() != null &&
                        !detail.getAvailable().equals("0") &&
                        !detail.getAvailable().isEmpty()) {

                        try {
                            double availableFloat = Double.parseDouble(detail.getAvailable());
                            if (availableFloat >= 0.1) {
                                selectedCoin = asset.getCoin();
                                selectedNetwork = asset.getCryptoAssetParams().network;
                                System.out.println("  Selected: " + selectedCoin + " on " +
                                        selectedNetwork + " (Balance: " + detail.getAvailable() + ")");
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

            if (selectedCoin == null) {
                System.out.println("  No sufficient balance found (>= 0.1)");
                return;
            }

            // Get appropriate test address for the selected network
            String testAddress = getTestAddress(selectedNetwork);
            if (testAddress == null) {
                System.out.println("  No test address available for network: " + selectedNetwork);
                return;
            }

            long timestamp = System.nanoTime();
            String externalId = "ORDER-" + timestamp;

            PayrollDirectCreateRequest request = new PayrollDirectCreateRequest();
            request.setExternalId(externalId);
            request.setAutoApprove(true);

            List<PayrollDirectItem> items = new ArrayList<>();

            PayrollDirectItem item1 = new PayrollDirectItem();
            item1.setExternalId("ITEM-" + timestamp + "-001");
            item1.setName("John Doe");
            item1.setEmail("john@example.com");
            item1.setPhone("+1234567890");
            item1.setCoin(selectedCoin);
            item1.setNetwork(selectedNetwork);
            item1.setAddress(testAddress);
            item1.setAmount("0.1");
            item1.setPaymentMethod("normal");
            items.add(item1);

            request.setItems(items);

            PayrollDirectCreateResponse response = payrollService.createDirectPayroll(request);

            System.out.println("✓ Payroll Created:");
            System.out.println("  ID: " + response.getPayroll().getId());
            System.out.println("  External ID: " + response.getPayroll().getExternalId());
            System.out.println("  Status: " + response.getPayroll().getStatus());
            System.out.println("  Total Amount: " + response.getPayroll().getTotalAmount());

        } catch (IOException e) {
            System.out.println("✗ API Error: " + e.getMessage());
        }
    }

    /**
     * Gets a test address for the specified network
     */
    private String getTestAddress(String network) {
        switch (network) {
            case "Solana Devnet":
                return "9B5XszUGdMaxCZ7uSQhPzdks5ZQSmWxrmzCSvtJ6Ns6g";
            case "Ethereum Sepolia":
                return "0x742d35Cc6634C0532925a3b844Bc454e4438f44e";
            case "TRON Testnet Shasta":
                return "TN9RRaXkCFtTXRso2GdTZxSxxwufzxLQPP";
            case "BSC Test":
                return "0x742d35Cc6634C0532925a3b844Bc454e4438f44e";
            case "Algorand Test":
                return "UWVYY2WRT5GY6R7F2XFQXQXQXQXQXQXQXQXQXQXQXQXQXQXQXQXQXQXQ";
            case "Stellar Test":
                return "GDQP2KPQGKIHYJGXNUIYOMHARUARCA7DJT5FO2FFOOKY3B2WSQHG4W37";
            case "Noble Test":
                return "noble1qy3n5t6l8z7r5s2a9w3k8r7n2m4v9x8c6d5e3f2g1h0j9i8u7y6t5r4e3w2q1";
            default:
                return null;
        }
    }

    /**
     * Retrieves a payroll by ID.
     */
    public void getPayroll() {
        System.out.println("Getting Payroll...");
        System.out.print("Enter Payroll ID: ");

        String id = scanner.nextLine().trim();
        if (id.isEmpty()) {
            id = "payroll_example_id";
        }

        try {
            Payroll response = payrollService.getPayroll(id);

            System.out.println("✓ Payroll Retrieved:");
            System.out.println("  ID: " + response.getId());
            System.out.println("  External ID: " + response.getExternalId());
            System.out.println("  Status: " + response.getStatus());
            System.out.println("  Total Amount: " + response.getTotalAmount());
            System.out.println("  Total Items: " + response.getTotalItemNum());
        } catch (IOException e) {
            System.out.println("✗ API Error: " + e.getMessage());
        }
    }

    /**
     * Lists all payrolls with pagination.
     */
    public void listPayrolls() {
        System.out.println("Listing Payrolls...");

        PayrollListRequest request = new PayrollListRequest();
        request.setPage(0);
        request.setPageSize(10);

        try {
            PayrollListResponse response = payrollService.listPayrolls(request);

            System.out.println("✓ Total Payrolls: " + response.getTotal());
            System.out.println();

            if (response.getPayrolls() != null) {
                for (int i = 0; i < response.getPayrolls().size(); i++) {
                    Payroll payroll = response.getPayrolls().get(i);
                    System.out.println("  [" + (i + 1) + "] ID: " + payroll.getId() +
                            ", Status: " + payroll.getStatus() +
                            ", Amount: " + payroll.getTotalAmount());
                }
            }
        } catch (IOException e) {
            System.out.println("✗ API Error: " + e.getMessage());
        }
    }
}
