package com.martianpay.examples;

import com.martianpay.developer.*;
import com.martianpay.sdk.AssetsService;
import com.martianpay.sdk.PayrollService;
import com.martianpay.sdk.StatsService;

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
        this.payrollService = new PayrollService(Common.currentAPIKey);
        this.assetsService = new AssetsService(Common.currentAPIKey);
        this.statsService = new StatsService(Common.currentAPIKey);
        this.scanner = new Scanner(System.in);
    }

    /**
     * Creates a direct payroll with auto-approval.
     */
    public void createDirectPayroll() {
        System.out.println("Creating Direct Payroll...");

        try {
            // Query assets
            AssetListResponse assetsResponse = assetsService.listAssets();
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
            if (balance == null || balance.getBalanceDetails() == null) {
                System.out.println("✗ Failed to get balance or balance list is empty");
                return;
            }

            // Match assets with balance and let user choose
            class AssetOption {
                String coin;
                String network;
                String assetId;
                String availableBalance;

                AssetOption(String coin, String network, String assetId, String availableBalance) {
                    this.coin = coin;
                    this.network = network;
                    this.assetId = assetId;
                    this.availableBalance = availableBalance;
                }
            }

            List<AssetOption> availableAssets = new ArrayList<>();
            for (Asset asset : cryptoAssets) {
                for (BalanceDetail detail : balance.getBalanceDetails()) {
                    if (detail.getCurrency().equals(asset.getId()) &&
                        detail.getAvailableBalance() != null &&
                        !detail.getAvailableBalance().equals("0") &&
                        !detail.getAvailableBalance().isEmpty()) {

                        try {
                            double availableFloat = Double.parseDouble(detail.getAvailableBalance());
                            if (availableFloat >= 0.1) {
                                availableAssets.add(new AssetOption(
                                    asset.getCoin(),
                                    asset.getCryptoAssetParams().network,
                                    asset.getId(),
                                    detail.getAvailableBalance()
                                ));
                            }
                        } catch (NumberFormatException e) {
                            // Skip invalid balance
                        }
                    }
                }
            }

            if (availableAssets.isEmpty()) {
                System.out.println("  No sufficient balance found (>= 0.1)");
                return;
            }

            // Display available assets for user to choose
            System.out.println("\n  Available assets with sufficient balance:");
            for (int i = 0; i < availableAssets.size(); i++) {
                AssetOption option = availableAssets.get(i);
                System.out.printf("  [%d] %s on %s (Balance: %s)%n",
                    i + 1, option.coin, option.network, option.availableBalance);
            }

            System.out.print("\nSelect asset number: ");
            String assetChoiceStr = scanner.nextLine().trim();
            int assetChoice;
            try {
                assetChoice = Integer.parseInt(assetChoiceStr);
                if (assetChoice < 1 || assetChoice > availableAssets.size()) {
                    System.out.println("Invalid choice");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
                return;
            }

            AssetOption selectedAsset = availableAssets.get(assetChoice - 1);
            System.out.printf("\n✓ Selected: %s on %s%n", selectedAsset.coin, selectedAsset.network);

            // Ask user to input recipient address
            System.out.printf("\nEnter recipient address for %s on %s: ", selectedAsset.coin, selectedAsset.network);
            String recipientAddress = scanner.nextLine().trim();
            if (recipientAddress.isEmpty()) {
                System.out.println("Error: Address cannot be empty");
                return;
            }

            System.out.printf("✓ Recipient address: %s%n", recipientAddress);

            // Ask user to input amount
            System.out.print("\nEnter amount to send (or press Enter for default 0.1): ");
            String amountInput = scanner.nextLine().trim();
            if (amountInput.isEmpty()) {
                amountInput = "0.1";
            }

            // Validate amount
            try {
                double amountFloat = Double.parseDouble(amountInput);
                if (amountFloat <= 0) {
                    System.out.println("Error: Invalid amount");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid amount");
                return;
            }

            System.out.printf("✓ Amount: %s%n", amountInput);

            long timestamp = System.nanoTime();
            String externalId = "ORDER-" + timestamp;

            PayrollDirectCreateRequest request = new PayrollDirectCreateRequest();
            request.setExternalId(externalId);
            request.setAutoApprove(true);

            List<PayrollDirectItem> items = new ArrayList<>();

            PayrollDirectItem item1 = new PayrollDirectItem();
            item1.setExternalId("ITEM-" + timestamp + "-001");
            item1.setName("John Doe");
            item1.setEmail(generatePayrollEmail("john"));
            item1.setPhone("+1234567890");
            item1.setCoin(selectedAsset.coin);
            item1.setNetwork(selectedAsset.network);
            item1.setAddress(recipientAddress);
            item1.setAmount(amountInput);
            item1.setPaymentMethod("normal");
            items.add(item1);

            request.setItems(items);

            PayrollDirectCreateResponse response = payrollService.createDirectPayroll(request);

            System.out.println("\n✓ Payroll Created:");
            System.out.println("  ID: " + response.getPayroll().getId());
            System.out.println("  External ID: " + response.getPayroll().getExternalID());
            System.out.println("  Status: " + response.getPayroll().getStatus());
            System.out.println("  Total Amount: " + response.getPayroll().getTotalAmount());

        } catch (IOException e) {
            System.out.println("✗ API Error: " + e.getMessage());
        }
    }

    /**
     * Creates a direct payroll with Binance payment method.
     */
    public void createDirectPayrollBinance() {
        System.out.println("Creating Direct Payroll (Binance Payment Method)...");

        try {
            // Query assets
            AssetListResponse assetsResponse = assetsService.listAssets();
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
            if (balance == null || balance.getBalanceDetails() == null) {
                System.out.println("✗ Failed to get balance or balance list is empty");
                return;
            }

            // Match assets with balance and let user choose
            class AssetOption {
                String coin;
                String network;
                String assetId;
                String availableBalance;

                AssetOption(String coin, String network, String assetId, String availableBalance) {
                    this.coin = coin;
                    this.network = network;
                    this.assetId = assetId;
                    this.availableBalance = availableBalance;
                }
            }

            List<AssetOption> availableAssets = new ArrayList<>();
            for (Asset asset : cryptoAssets) {
                for (BalanceDetail detail : balance.getBalanceDetails()) {
                    if (detail.getCurrency().equals(asset.getId()) &&
                        detail.getAvailableBalance() != null &&
                        !detail.getAvailableBalance().equals("0") &&
                        !detail.getAvailableBalance().isEmpty()) {

                        try {
                            double availableFloat = Double.parseDouble(detail.getAvailableBalance());
                            if (availableFloat >= 0.1) {
                                availableAssets.add(new AssetOption(
                                    asset.getCoin(),
                                    asset.getCryptoAssetParams().network,
                                    asset.getId(),
                                    detail.getAvailableBalance()
                                ));
                            }
                        } catch (NumberFormatException e) {
                            // Skip invalid balance
                        }
                    }
                }
            }

            if (availableAssets.isEmpty()) {
                System.out.println("  No sufficient balance found (>= 0.1)");
                return;
            }

            // Display available assets for user to choose
            System.out.println("\n  Available assets with sufficient balance:");
            for (int i = 0; i < availableAssets.size(); i++) {
                AssetOption option = availableAssets.get(i);
                System.out.printf("  [%d] %s on %s (Balance: %s)%n",
                    i + 1, option.coin, option.network, option.availableBalance);
            }

            System.out.print("\nSelect asset number: ");
            String assetChoiceStr = scanner.nextLine().trim();
            int assetChoice;
            try {
                assetChoice = Integer.parseInt(assetChoiceStr);
                if (assetChoice < 1 || assetChoice > availableAssets.size()) {
                    System.out.println("Invalid choice");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
                return;
            }

            AssetOption selectedAsset = availableAssets.get(assetChoice - 1);
            System.out.printf("\n✓ Selected: %s on %s%n", selectedAsset.coin, selectedAsset.network);

            // Ask user to input recipient address
            System.out.printf("\nEnter recipient address for %s on %s (Binance): ", selectedAsset.coin, selectedAsset.network);
            String recipientAddress = scanner.nextLine().trim();
            if (recipientAddress.isEmpty()) {
                System.out.println("Error: Address cannot be empty");
                return;
            }

            System.out.printf("✓ Recipient address: %s%n", recipientAddress);

            // Ask user to input amount
            System.out.print("\nEnter amount to send (or press Enter for default 0.1): ");
            String amountInput = scanner.nextLine().trim();
            if (amountInput.isEmpty()) {
                amountInput = "0.1";
            }

            // Validate amount
            try {
                double amountFloat = Double.parseDouble(amountInput);
                if (amountFloat <= 0) {
                    System.out.println("Error: Invalid amount");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid amount");
                return;
            }

            System.out.printf("✓ Amount: %s%n", amountInput);

            long timestamp = System.nanoTime();
            String externalId = "ORDER-" + timestamp;

            PayrollDirectCreateRequest request = new PayrollDirectCreateRequest();
            request.setExternalId(externalId);
            request.setAutoApprove(true);

            List<PayrollDirectItem> items = new ArrayList<>();

            PayrollDirectItem item1 = new PayrollDirectItem();
            item1.setExternalId("ITEM-" + timestamp + "-001");
            item1.setName("Jane Smith");
            item1.setEmail(generatePayrollEmail("jane"));
            item1.setPhone("+1234567891");
            item1.setCoin(selectedAsset.coin);
            item1.setNetwork(selectedAsset.network);
            item1.setAddress(recipientAddress);
            item1.setAmount(amountInput);
            item1.setPaymentMethod("binance");
            items.add(item1);

            request.setItems(items);

            PayrollDirectCreateResponse response = payrollService.createDirectPayroll(request);

            System.out.println("\n✓ Payroll Created:");
            System.out.println("  ID: " + response.getPayroll().getId());
            System.out.println("  External ID: " + response.getPayroll().getExternalID());
            System.out.println("  Status: " + response.getPayroll().getStatus());
            System.out.println("  Total Amount: " + response.getPayroll().getTotalAmount());

        } catch (IOException e) {
            System.out.println("✗ API Error: " + e.getMessage());
        }
    }

    /**
     * Generates a unique email for payroll testing.
     */
    private String generatePayrollEmail(String prefix) {
        long timestamp = System.currentTimeMillis() / 1000;
        int randomNum = (int) (Math.random() * 1000000);
        return String.format("%s_%d_%d@example.com", prefix, timestamp, randomNum);
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
            PayrollGetResponse response = payrollService.getPayroll(id);

            System.out.println("✓ Payroll Retrieved:");
            System.out.println("  ID: " + response.getPayroll().getId());
            System.out.println("  External ID: " + response.getPayroll().getExternalID());
            System.out.println("  Status: " + response.getPayroll().getStatus());
            System.out.println("  Total Amount: " + response.getPayroll().getTotalAmount());
            System.out.println("  Total Items: " + response.getPayroll().getTotalItemNum());
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

    /**
     * Lists payroll items for a specific payroll.
     */
    public void listPayrollItems() {
        System.out.println("Listing Payroll Items...");
        System.out.print("Enter Payroll ID: ");

        String payrollId = scanner.nextLine().trim();
        if (payrollId.isEmpty()) {
            payrollId = "payroll_example_id";
        }

        PayrollItemsListRequest request = new PayrollItemsListRequest();
        request.setPayrollId(payrollId);
        request.setPage(0);
        request.setPageSize(10);

        try {
            PayrollItemsListResponse response = payrollService.listPayrollItems(request);

            System.out.println("✓ Total Items: " + response.getTotal());
            System.out.println();

            if (response.getPayrollItems() != null) {
                for (int i = 0; i < response.getPayrollItems().size(); i++) {
                    PayrollItems item = response.getPayrollItems().get(i);
                    System.out.println("  [" + (i + 1) + "] ID: " + item.getId());
                    System.out.println("      Amount: " + item.getAmount() + ", Status: " + item.getStatus());
                    System.out.println("      Network: " + item.getNetwork());
                }
            }
        } catch (IOException e) {
            System.out.println("✗ API Error: " + e.getMessage());
        }
    }
}
