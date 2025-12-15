package com.martianpay.examples;

import com.martianpay.developer.Asset;
import com.martianpay.developer.AssetListResponse;
import com.martianpay.developer.NetworkFeesResponse;
import com.martianpay.sdk.AssetsService;

import java.io.IOException;
import java.util.Scanner;

/**
 * Assets Examples
 *
 * This class demonstrates how to use the AssetsService to manage assets.
 */
public class AssetsExample {

    private final AssetsService assetsService;
    private final Scanner scanner;

    public AssetsExample() {
        this.assetsService = new AssetsService(Common.currentAPIKey);
        this.scanner = new Scanner(System.in);
    }

    /**
     * Lists all assets enabled for the merchant
     */
    public void listAssets() {
        System.out.println("Listing Enabled Assets...");

        try {
            AssetListResponse response = assetsService.listAssets();

            if (response.getAssets() == null || response.getAssets().isEmpty()) {
                System.out.println("✓ No assets found");
                return;
            }

            // Separate crypto and fiat assets
            int cryptoCount = 0;
            int fiatCount = 0;

            for (Asset asset : response.getAssets()) {
                if (asset.getIsFiat() != null && asset.getIsFiat()) {
                    fiatCount++;
                } else {
                    cryptoCount++;
                }
            }

            System.out.println(String.format("✓ Total Assets: %d (Crypto: %d, Fiat: %d)\n",
                    response.getAssets().size(), cryptoCount, fiatCount));

            // Display crypto assets
            if (cryptoCount > 0) {
                System.out.println(String.format("Cryptocurrency Assets (%d):", cryptoCount));
                System.out.println("--------------------------------------------------------------------------------");

                int index = 1;
                for (Asset asset : response.getAssets()) {
                    if (asset.getIsFiat() != null && asset.getIsFiat()) {
                        continue;
                    }

                    System.out.println(String.format("\n[%d] %s", index++, asset.getDisplayName()));
                    System.out.println("    ID: " + asset.getId());
                    System.out.println("    Coin: " + asset.getCoin());
                    System.out.println("    Decimals: " + asset.getDecimals());
                    System.out.println("    Payable: " + asset.getPayable());

                    if (asset.getNetwork() != null) {
                        System.out.println("    Network: " + asset.getNetwork());
                        System.out.println("    Mainnet: " + asset.getIsMainnet());
                        if (asset.getContractAddress() != null && !asset.getContractAddress().isEmpty()) {
                            System.out.println("    Contract: " + asset.getContractAddress());
                        }
                    }
                }
                System.out.println();
            }

            // Display fiat assets
            if (fiatCount > 0) {
                System.out.println(String.format("\nFiat Currency Assets (%d):", fiatCount));
                System.out.println("--------------------------------------------------------------------------------");

                int index = 1;
                for (Asset asset : response.getAssets()) {
                    if (asset.getIsFiat() == null || !asset.getIsFiat()) {
                        continue;
                    }

                    System.out.println(String.format("\n[%d] %s", index++, asset.getDisplayName()));
                    System.out.println("    ID: " + asset.getId());
                    System.out.println("    Coin: " + asset.getCoin());
                    System.out.println("    Decimals: " + asset.getDecimals());
                    System.out.println("    Payable: " + asset.getPayable());

                    if (asset.getSymbol() != null) {
                        System.out.println("    Symbol: " + asset.getSymbol());
                    }
                    if (asset.getProvider() != null) {
                        System.out.println("    Provider: " + asset.getProvider());
                    }
                }
                System.out.println();
            }

        } catch (IOException e) {
            System.out.println("✗ API Error: " + e.getMessage());
        }
    }

    /**
     * Lists network fee information for all assets
     */
    public void listAssetFees() {
        System.out.println("Listing Asset Network Fees...");

        try {
            NetworkFeesResponse response = assetsService.listAssetFees();

            if (response.getNetworkFees() == null || response.getNetworkFees().isEmpty()) {
                System.out.println("✓ No network fees found");
                return;
            }

            System.out.println(String.format("✓ Network Fees for %d Networks:\n", response.getNetworkFees().size()));
            System.out.println("================================================================================");

            int index = 1;
            for (String network : response.getNetworkFees().keySet()) {
                var fee = response.getNetworkFees().get(network);

                System.out.println(String.format("\n[%d] %s", index++, network));
                System.out.println("    Minimum Payout Amount: " + fee.getMinPayoutAmount());
                System.out.println("    Network Fee Amount: " + fee.getFeeAmount());
            }

            System.out.println("\n================================================================================");

        } catch (IOException e) {
            System.out.println("✗ API Error: " + e.getMessage());
        }
    }

    /**
     * Shows only payable assets
     */
    public void showPayableAssets() {
        System.out.println("Showing Payable Assets...");

        try {
            AssetListResponse response = assetsService.listAssets();

            int payableCrypto = 0;
            int payableFiat = 0;

            System.out.println("\n================================================================================");
            System.out.println("Payable Assets");
            System.out.println("================================================================================");

            int index = 1;
            for (Asset asset : response.getAssets()) {
                if (asset.getPayable() == null || !asset.getPayable()) {
                    continue;
                }

                if (asset.getIsFiat() != null && asset.getIsFiat()) {
                    payableFiat++;
                } else {
                    payableCrypto++;
                }

                String assetType = (asset.getIsFiat() != null && asset.getIsFiat()) ? "Fiat" : "Crypto";
                String networkInfo = "";

                if (asset.getIsFiat() != null && asset.getIsFiat()) {
                    if (asset.getProvider() != null && !asset.getProvider().isEmpty()) {
                        networkInfo = " [" + asset.getProvider() + "]";
                    }
                } else if (asset.getNetwork() != null) {
                    networkInfo = " [" + asset.getNetwork() + "]";
                }

                System.out.println(String.format("\n[%d] %s (%s)%s", index++, asset.getDisplayName(), assetType, networkInfo));
                System.out.println("    ID: " + asset.getId());
                System.out.println(String.format("    Coin: %s, Decimals: %d", asset.getCoin(), asset.getDecimals()));
            }

            System.out.println("\n================================================================================");
            System.out.println(String.format("Total Payable: %d (Crypto: %d, Fiat: %d)", payableCrypto + payableFiat, payableCrypto, payableFiat));
            System.out.println("================================================================================");

        } catch (IOException e) {
            System.out.println("✗ API Error: " + e.getMessage());
        }
    }

    /**
     * Gets all available assets from the system
     */
    public void getAllAssets() {
        System.out.println("Getting All Available Assets...");

        try {
            java.util.List<Asset> assets = assetsService.getAllAssets();

            if (assets == null || assets.isEmpty()) {
                System.out.println("✓ No assets found");
                return;
            }

            // Count by type and network
            java.util.Map<String, Integer> cryptoByNetwork = new java.util.HashMap<>();
            int fiatCount = 0;
            int payableCount = 0;

            for (Asset asset : assets) {
                if (asset.getIsFiat() != null && asset.getIsFiat()) {
                    fiatCount++;
                } else if (asset.getNetwork() != null) {
                    cryptoByNetwork.put(asset.getNetwork(), cryptoByNetwork.getOrDefault(asset.getNetwork(), 0) + 1);
                }
                if (asset.getPayable() != null && asset.getPayable()) {
                    payableCount++;
                }
            }

            System.out.printf("✓ Total Assets: %d (Payable: %d)%n", assets.size(), payableCount);
            System.out.printf("  Fiat Assets: %d%n", fiatCount);
            System.out.printf("  Crypto Assets: %d%n%n", assets.size() - fiatCount);

            if (!cryptoByNetwork.isEmpty()) {
                System.out.println("Assets by Network:");
                for (java.util.Map.Entry<String, Integer> entry : cryptoByNetwork.entrySet()) {
                    System.out.printf("  - %s: %d%n", entry.getKey(), entry.getValue());
                }
                System.out.println();
            }

            // Show detailed list with option to filter
            System.out.print("Show detailed list? (y/N): ");
            String showDetails = scanner.nextLine().trim();

            if (!showDetails.equalsIgnoreCase("y")) {
                return;
            }

            System.out.print("\nFilter by: (1) All, (2) Crypto only, (3) Fiat only, (4) Payable only: ");
            String filterChoice = scanner.nextLine().trim();
            if (filterChoice.isEmpty()) {
                filterChoice = "1";
            }

            System.out.println("\n================================================================================");

            for (int i = 0; i < assets.size(); i++) {
                Asset asset = assets.get(i);

                // Apply filter
                boolean shouldShow = false;
                switch (filterChoice) {
                    case "1":
                        shouldShow = true;
                        break;
                    case "2":
                        shouldShow = asset.getIsFiat() == null || !asset.getIsFiat();
                        break;
                    case "3":
                        shouldShow = asset.getIsFiat() != null && asset.getIsFiat();
                        break;
                    case "4":
                        shouldShow = asset.getPayable() != null && asset.getPayable();
                        break;
                }

                if (!shouldShow) {
                    continue;
                }

                String assetType = "Crypto";
                if (asset.getIsFiat() != null && asset.getIsFiat()) {
                    assetType = "Fiat";
                }

                System.out.printf("\n[%d] %s (%s)%n", i + 1, asset.getDisplayName(), assetType);
                System.out.printf("    ID: %s, Coin: %s%n", asset.getId(), asset.getCoin());
                System.out.printf("    Decimals: %d, Payable: %s%n", asset.getDecimals(), asset.getPayable());

                if (asset.getNetwork() != null) {
                    System.out.printf("    Network: %s (Mainnet: %s)%n",
                        asset.getNetwork(),
                        asset.getIsMainnet());
                }

                if (asset.getSymbol() != null && !asset.getSymbol().isEmpty()) {
                    System.out.printf("    Symbol: %s%n", asset.getSymbol());
                }
            }

            System.out.println("\n================================================================================");

        } catch (IOException e) {
            System.out.println("✗ API Error: " + e.getMessage());
        }
    }

    /**
     * Shows crypto assets grouped by blockchain network
     */
    public void showCryptoAssetsByNetwork() {
        System.out.println("Showing Crypto Assets Grouped by Network...");

        try {
            java.util.List<Asset> assets = assetsService.getAllAssets();

            // Group assets by network
            java.util.Map<String, java.util.List<String>> assetsByNetwork = new java.util.HashMap<>();
            for (Asset asset : assets) {
                if ((asset.getIsFiat() == null || !asset.getIsFiat()) && asset.getNetwork() != null) {
                    String network = asset.getNetwork();
                    String displayInfo = String.format("%s (%s)", asset.getDisplayName(), asset.getId());
                    if (asset.getPayable() != null && asset.getPayable()) {
                        displayInfo += " [Payable]";
                    }
                    assetsByNetwork.computeIfAbsent(network, k -> new java.util.ArrayList<>()).add(displayInfo);
                }
            }

            if (assetsByNetwork.isEmpty()) {
                System.out.println("✓ No crypto assets found");
                return;
            }

            System.out.printf("✓ Found assets on %d blockchain networks:%n%n", assetsByNetwork.size());

            for (java.util.Map.Entry<String, java.util.List<String>> entry : assetsByNetwork.entrySet()) {
                String network = entry.getKey();
                java.util.List<String> networkAssets = entry.getValue();

                System.out.printf("━━━ %s (%d assets) ━━━%n", network, networkAssets.size());
                for (int i = 0; i < networkAssets.size(); i++) {
                    System.out.printf("  %d. %s%n", i + 1, networkAssets.get(i));
                }
                System.out.println();
            }

        } catch (IOException e) {
            System.out.println("✗ API Error: " + e.getMessage());
        }
    }

    /**
     * Compares mainnet and testnet assets
     */
    public void compareMainnetVsTestnet() {
        System.out.println("Comparing Mainnet vs Testnet Assets...");

        try {
            java.util.List<Asset> assets = assetsService.getAllAssets();

            int mainnetCount = 0;
            int testnetCount = 0;
            java.util.Map<String, Integer> mainnetByNetwork = new java.util.HashMap<>();
            java.util.Map<String, Integer> testnetByNetwork = new java.util.HashMap<>();

            for (Asset asset : assets) {
                if (asset.getIsFiat() != null && asset.getIsFiat()) {
                    continue;
                }
                if (asset.getNetwork() == null) {
                    continue;
                }

                if (asset.getIsMainnet() != null && asset.getIsMainnet()) {
                    mainnetCount++;
                    mainnetByNetwork.put(asset.getNetwork(), mainnetByNetwork.getOrDefault(asset.getNetwork(), 0) + 1);
                } else {
                    testnetCount++;
                    testnetByNetwork.put(asset.getNetwork(), testnetByNetwork.getOrDefault(asset.getNetwork(), 0) + 1);
                }
            }

            System.out.printf("%n✓ Mainnet Assets: %d%n", mainnetCount);
            System.out.printf("✓ Testnet Assets: %d%n%n", testnetCount);

            if (!mainnetByNetwork.isEmpty()) {
                System.out.println("Mainnet Assets by Network:");
                for (java.util.Map.Entry<String, Integer> entry : mainnetByNetwork.entrySet()) {
                    System.out.printf("  - %s: %d%n", entry.getKey(), entry.getValue());
                }
                System.out.println();
            }

            if (!testnetByNetwork.isEmpty()) {
                System.out.println("Testnet Assets by Network:");
                for (java.util.Map.Entry<String, Integer> entry : testnetByNetwork.entrySet()) {
                    System.out.printf("  - %s: %d%n", entry.getKey(), entry.getValue());
                }
                System.out.println();
            }

        } catch (IOException e) {
            System.out.println("✗ API Error: " + e.getMessage());
        }
    }
}
