package com.martianpay.examples;

import com.martianpay.sdk.StatsService;
import com.martianpay.developer.BalanceResponse;
import com.martianpay.developer.BalanceDetail;

import java.io.IOException;
import java.util.Scanner;

/**
 * Balance Examples
 *
 * This class demonstrates how to use the StatsService to view merchant balance.
 */
public class BalanceExample {

    private final StatsService statsService;
    private final Scanner scanner;

    public BalanceExample() {
        this.statsService = new StatsService(Common.currentAPIKey);
        this.scanner = new Scanner(System.in);
    }

    /**
     * Shows the merchant's current balance
     */
    public void showBalance() {
        System.out.println("Getting Merchant Balance...");

        try {
            BalanceResponse balance = statsService.getBalance();

            System.out.println("\n================================================================================");
            System.out.println("Merchant Balance Summary");
            System.out.println("================================================================================");

            System.out.println("\nPrimary Currency: " + balance.getCurrency());
            System.out.println("\n  Available Balance:  " + balance.getAvailableBalance());
            System.out.println("  Pending Balance:    " + balance.getPendingBalance());
            System.out.println("  Locked Balance:     " + balance.getLockedBalance());
            System.out.println("  Frozen Balance:     " + balance.getFrozenBalance());
            System.out.println("  ───────────────────────────");
            System.out.println("  Total Balance:      " + balance.getTotalBalance());

            if (balance.getBalanceDetails() != null && !balance.getBalanceDetails().isEmpty()) {
                System.out.println("\n================================================================================");
                System.out.println(String.format("Balance Details by Currency/Asset (%d)", balance.getBalanceDetails().size()));
                System.out.println("================================================================================");

                int index = 1;
                for (BalanceDetail detail : balance.getBalanceDetails()) {
                    System.out.println(String.format("\n[%d] %s", index++, detail.getCurrency()));
                    System.out.println("    Available:      " + detail.getAvailableBalance());
                    System.out.println("    Pending:        " + detail.getPendingBalance());
                    System.out.println("    Locked:         " + detail.getLockedBalance());
                    System.out.println("    Frozen:         " + detail.getFrozenBalance());
                    System.out.println("    Total:          " + detail.getTotalBalance());
                }
            }

            System.out.println("\n================================================================================");
            System.out.println("\nBalance Types Explained:");
            System.out.println("  • Available: Funds ready for immediate use in transactions");
            System.out.println("  • Pending:   Unreconciled deposits awaiting confirmation");
            System.out.println("  • Locked:    Funds reserved for pending payouts");
            System.out.println("  • Frozen:    Funds restricted due to compliance/security");
            System.out.println("================================================================================");

        } catch (IOException e) {
            System.out.println("✗ API Error: " + e.getMessage());
        }
    }

    /**
     * Shows only available balances (non-zero)
     */
    public void showAvailableBalancesOnly() {
        System.out.println("Showing Available Balances Only...");

        try {
            BalanceResponse balance = statsService.getBalance();

            System.out.println("\n================================================================================");
            System.out.println("Available Balances (Ready for Use)");
            System.out.println("================================================================================");

            boolean hasAvailableBalance = false;

            if (balance.getBalanceDetails() != null) {
                int index = 1;
                for (BalanceDetail detail : balance.getBalanceDetails()) {
                    // Skip if available balance is 0 or empty
                    if ("0".equals(detail.getAvailableBalance()) || detail.getAvailableBalance() == null || detail.getAvailableBalance().isEmpty()) {
                        continue;
                    }

                    hasAvailableBalance = true;
                    System.out.println(String.format("\n[%d] %s", index++, detail.getCurrency()));
                    System.out.println("    Available: " + detail.getAvailableBalance());
                }
            }

            if (!hasAvailableBalance) {
                System.out.println("\n  No available balance found in any currency.");
            }

            System.out.println("\n================================================================================");
            System.out.println(String.format("Total Available (Primary Currency): %s %s", balance.getAvailableBalance(), balance.getCurrency()));
            System.out.println("================================================================================");

        } catch (IOException e) {
            System.out.println("✗ API Error: " + e.getMessage());
        }
    }

    /**
     * Shows locked and pending balances
     */
    public void showLockedAndPendingBalances() {
        System.out.println("Showing Locked and Pending Balances...");

        try {
            BalanceResponse balance = statsService.getBalance();

            System.out.println("\n================================================================================");
            System.out.println("Locked and Pending Balances");
            System.out.println("================================================================================");

            boolean hasLockedOrPending = false;

            if (balance.getBalanceDetails() != null) {
                int index = 1;
                for (BalanceDetail detail : balance.getBalanceDetails()) {
                    boolean hasLocked = !"0".equals(detail.getLockedBalance()) && detail.getLockedBalance() != null && !detail.getLockedBalance().isEmpty();
                    boolean hasPending = !"0".equals(detail.getPendingBalance()) && detail.getPendingBalance() != null && !detail.getPendingBalance().isEmpty();

                    if (!hasLocked && !hasPending) {
                        continue;
                    }

                    hasLockedOrPending = true;
                    System.out.println(String.format("\n[%d] %s", index++, detail.getCurrency()));

                    if (hasLocked) {
                        System.out.println("    🔒 Locked:  " + detail.getLockedBalance() + " (Reserved for pending payouts)");
                    }

                    if (hasPending) {
                        System.out.println("    ⏳ Pending: " + detail.getPendingBalance() + " (Awaiting reconciliation)");
                    }
                }
            }

            if (!hasLockedOrPending) {
                System.out.println("\n  No locked or pending balances found.");
            }

            System.out.println("\n================================================================================");
            System.out.println("Summary:");
            System.out.println("  Total Locked:  " + balance.getLockedBalance() + " " + balance.getCurrency());
            System.out.println("  Total Pending: " + balance.getPendingBalance() + " " + balance.getCurrency());
            System.out.println("================================================================================");

        } catch (IOException e) {
            System.out.println("✗ API Error: " + e.getMessage());
        }
    }

    /**
     * Shows balance grouped by currency type (crypto vs fiat)
     */
    public void showBalanceByCurrency() {
        System.out.println("Showing Balance by Currency...");

        try {
            BalanceResponse balance = statsService.getBalance();

            if (balance.getBalanceDetails() == null || balance.getBalanceDetails().isEmpty()) {
                System.out.println("✓ No balance details found");
                return;
            }

            // Group by currency type (detect crypto vs fiat by currency name pattern)
            class BalanceInfo {
                String currency;
                String available;
                String pending;
                String locked;
                String frozen;
                String total;

                BalanceInfo(String currency, String available, String pending, String locked, String frozen, String total) {
                    this.currency = currency;
                    this.available = available;
                    this.pending = pending;
                    this.locked = locked;
                    this.frozen = frozen;
                    this.total = total;
                }
            }

            java.util.Map<String, BalanceInfo> cryptoBalances = new java.util.HashMap<>();
            java.util.Map<String, BalanceInfo> fiatBalances = new java.util.HashMap<>();

            for (BalanceDetail detail : balance.getBalanceDetails()) {
                BalanceInfo info = new BalanceInfo(
                    detail.getCurrency(),
                    detail.getAvailableBalance(),
                    detail.getPendingBalance(),
                    detail.getLockedBalance(),
                    detail.getFrozenBalance(),
                    detail.getTotalBalance()
                );

                // Detect if it's crypto (contains "-" separator like "USDC-Ethereum-TEST") or fiat
                if (detail.getCurrency().contains("-")) {
                    cryptoBalances.put(detail.getCurrency(), info);
                } else {
                    fiatBalances.put(detail.getCurrency(), info);
                }
            }

            // Display crypto balances
            if (!cryptoBalances.isEmpty()) {
                System.out.println("\n================================================================================");
                System.out.printf("Cryptocurrency Balances (%d)%n", cryptoBalances.size());
                System.out.println("================================================================================");

                for (java.util.Map.Entry<String, BalanceInfo> entry : cryptoBalances.entrySet()) {
                    BalanceInfo info = entry.getValue();
                    System.out.printf("%n%s:%n", entry.getKey());
                    System.out.printf("  Available: %-20s  Locked: %-20s%n", info.available, info.locked);
                    System.out.printf("  Pending:   %-20s  Frozen: %-20s%n", info.pending, info.frozen);
                    System.out.printf("  Total:     %s%n", info.total);
                }
            }

            // Display fiat balances
            if (!fiatBalances.isEmpty()) {
                System.out.println("\n================================================================================");
                System.out.printf("Fiat Currency Balances (%d)%n", fiatBalances.size());
                System.out.println("================================================================================");

                for (java.util.Map.Entry<String, BalanceInfo> entry : fiatBalances.entrySet()) {
                    BalanceInfo info = entry.getValue();
                    System.out.printf("%n%s:%n", entry.getKey());
                    System.out.printf("  Available: %-20s  Locked: %-20s%n", info.available, info.locked);
                    System.out.printf("  Pending:   %-20s  Frozen: %-20s%n", info.pending, info.frozen);
                    System.out.printf("  Total:     %s%n", info.total);
                }
            }

            System.out.println("\n================================================================================");

        } catch (IOException e) {
            System.out.println("✗ API Error: " + e.getMessage());
        }
    }

    /**
     * Provides a side-by-side comparison of balance types
     */
    public void compareBalanceTypes() {
        System.out.println("Comparing Balance Types...");

        try {
            BalanceResponse balance = statsService.getBalance();

            System.out.println("\n================================================================================");
            System.out.println("Balance Types Comparison");
            System.out.println("================================================================================");

            // Calculate totals
            System.out.printf("%n%-20s: %s %s%n", "Available", balance.getAvailableBalance(), balance.getCurrency());
            System.out.printf("%-20s: %s %s%n", "Pending", balance.getPendingBalance(), balance.getCurrency());
            System.out.printf("%-20s: %s %s%n", "Locked", balance.getLockedBalance(), balance.getCurrency());
            System.out.printf("%-20s: %s %s%n", "Frozen", balance.getFrozenBalance(), balance.getCurrency());
            System.out.println("--------------------------------------------------------------------------------");
            System.out.printf("%-20s: %s %s%n", "Total", balance.getTotalBalance(), balance.getCurrency());

            System.out.println("\n================================================================================");
            System.out.println("Details by Asset:");
            System.out.println("================================================================================");

            // Print header
            System.out.printf("%n%-30s | %-12s | %-12s | %-12s | %-12s%n",
                "Currency/Asset", "Available", "Pending", "Locked", "Frozen");
            System.out.println("------------------------------------------------------------------------------------------");

            if (balance.getBalanceDetails() != null) {
                for (BalanceDetail detail : balance.getBalanceDetails()) {
                    System.out.printf("%-30s | %-12s | %-12s | %-12s | %-12s%n",
                        detail.getCurrency(),
                        detail.getAvailableBalance(),
                        detail.getPendingBalance(),
                        detail.getLockedBalance(),
                        detail.getFrozenBalance());
                }
            }

            System.out.println("==========================================================================================");

        } catch (IOException e) {
            System.out.println("✗ API Error: " + e.getMessage());
        }
    }
}
