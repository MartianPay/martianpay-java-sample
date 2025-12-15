package com.martianpay.examples;

import com.martianpay.developer.*;
import com.martianpay.sdk.MartianPayClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Payout Examples
 */
public class PayoutExample {

    // Preview a payout to estimate fees and amounts
    public static void previewPayout(MartianPayClient client) {
        System.out.println("Previewing Payout...");
        Scanner scanner = new Scanner(System.in);

        // First, get merchant addresses to select one
        System.out.println("  Fetching merchant addresses...");
        MerchantAddressListRequest addressReq = new MerchantAddressListRequest();
        addressReq.setPage(0);
        addressReq.setPageSize(10);

        try {
            MerchantAddressListResponse addressResp = client.getMerchantAddressService().listMerchantAddresses(addressReq);

            if (addressResp.getMerchantAddresses() == null || addressResp.getMerchantAddresses().isEmpty()) {
                System.out.println("✗ No merchant addresses found. Please create one first.");
                return;
            }

            // Display available addresses
            System.out.println("\n  Available Merchant Addresses:");
            int index = 1;
            for (MerchantAddress addr : addressResp.getMerchantAddresses()) {
                System.out.printf("  [%d] ID: %s, Network: %s, Address: %s%n",
                    index++, addr.getId(), addr.getNetwork(), addr.getAddress());
                if (addr.getVerification() != null) {
                    System.out.printf("      Status: %s, AML Status: %s%n",
                        addr.getVerification().getStatus(),
                        addr.getVerification().getAmlStatus());
                }
            }

            System.out.print("\nEnter address number (or press Enter for first): ");
            String addrChoice = scanner.nextLine().trim();

            int selectedIdx = 0;
            if (!addrChoice.isEmpty()) {
                try {
                    int idx = Integer.parseInt(addrChoice);
                    if (idx > 0 && idx <= addressResp.getMerchantAddresses().size()) {
                        selectedIdx = idx - 1;
                    }
                } catch (NumberFormatException e) {
                    // Use default
                }
            }

            MerchantAddress selectedAddr = addressResp.getMerchantAddresses().get(selectedIdx);
            System.out.printf("  Selected: %s (%s)%n", selectedAddr.getId(), selectedAddr.getNetwork());

            // Get asset ID from the selected address verification
            String assetID;
            if (selectedAddr.getVerification() != null &&
                selectedAddr.getVerification().getAssetID() != null &&
                !selectedAddr.getVerification().getAssetID().isEmpty()) {
                assetID = selectedAddr.getVerification().getAssetID();
            } else {
                System.out.print("\nEnter Asset ID (e.g., USDC-Solana-TEST): ");
                assetID = scanner.nextLine().trim();
            }

            // Get amount
            System.out.print("Enter source amount: ");
            String amount = scanner.nextLine().trim();
            if (amount.isEmpty()) {
                amount = "15";
            }

            PayoutPreviewRequest req = new PayoutPreviewRequest();
            req.setSourceCoin("USDC");
            req.setSourceAmount(amount);
            req.setDestinationAssetId(assetID);
            req.setDestinationAccountType("wallet");
            req.setDestinationAccountId(selectedAddr.getId());

            PayoutPreviewResp response = client.getPayoutService().previewPayout(req);

            System.out.println("\n✓ Payout Preview:");
            System.out.printf("  ID: %s%n", response.getId());
            System.out.printf("  Source Amount: %s %s%n", response.getSourceAmount(), response.getSourceCoin());
            System.out.printf("  Receive Amount: %s %s%n", response.getReceiveAmount(), response.getReceiveCoin());
            System.out.printf("  Exchange Rate: %s%n", response.getExchangeRate());
            System.out.printf("  Network Fee: %s%n", response.getPaymentNetworkFee());
            System.out.printf("  Service Fee: %s%n", response.getPaymentServiceFee());
            System.out.printf("  Total Fee: %s%n", response.getPaymentTotalFee());
            System.out.printf("  Net Amount: %s%n", response.getPaymentNetAmount());
            System.out.printf("  Status: %s%n", response.getStatus());
            System.out.printf("  Approval Status: %s%n", response.getApprovalStatus());

            if (response.getReceiveWalletAddress() != null) {
                System.out.println("\n  Destination:");
                System.out.printf("    Network: %s%n", response.getReceiveWalletAddress().getNetwork());
                System.out.printf("    Address: %s%n", response.getReceiveWalletAddress().getAddress());
            }

            if (response.getSwapItems() != null && !response.getSwapItems().isEmpty()) {
                System.out.println("\n  Swap Items:");
                index = 1;
                for (PayoutSwapItem swap : response.getSwapItems()) {
                    System.out.printf("  [%d] From: %s %s -> To: %s %s%n",
                        index++,
                        swap.getEstimatedFromAmount(),
                        swap.getFromAssetId(),
                        swap.getEstimatedToAmount(),
                        swap.getToAssetId());
                    System.out.printf("      Quote ID: %s%n", swap.getQuoteId());
                }
            }
        } catch (IOException e) {
            System.out.printf("✗ API Error: %s%n", e.getMessage());
        }
    }

    // Create a new payout request
    public static void createPayout(MartianPayClient client) {
        System.out.println("Creating Payout...");
        System.out.println("  Step 1: Preview payout to get quote IDs...");
        Scanner scanner = new Scanner(System.in);

        // Get merchant addresses
        MerchantAddressListRequest addressReq = new MerchantAddressListRequest();
        addressReq.setPage(0);
        addressReq.setPageSize(10);

        try {
            MerchantAddressListResponse addressResp = client.getMerchantAddressService().listMerchantAddresses(addressReq);

            if (addressResp.getMerchantAddresses() == null || addressResp.getMerchantAddresses().isEmpty()) {
                System.out.println("✗ No merchant addresses found. Please create one first.");
                return;
            }

            // Display available addresses
            System.out.println("\n  Available Merchant Addresses:");
            int index = 1;
            for (MerchantAddress addr : addressResp.getMerchantAddresses()) {
                System.out.printf("  [%d] ID: %s, Network: %s, Address: %s%n",
                    index++, addr.getId(), addr.getNetwork(), addr.getAddress());
            }

            System.out.print("\nEnter address number (or press Enter for first): ");
            String addrChoice = scanner.nextLine().trim();

            int selectedIdx = 0;
            if (!addrChoice.isEmpty()) {
                try {
                    int idx = Integer.parseInt(addrChoice);
                    if (idx > 0 && idx <= addressResp.getMerchantAddresses().size()) {
                        selectedIdx = idx - 1;
                    }
                } catch (NumberFormatException e) {
                    // Use default
                }
            }

            MerchantAddress selectedAddr = addressResp.getMerchantAddresses().get(selectedIdx);

            // Get asset ID
            String assetID;
            if (selectedAddr.getVerification() != null &&
                selectedAddr.getVerification().getAssetID() != null &&
                !selectedAddr.getVerification().getAssetID().isEmpty()) {
                assetID = selectedAddr.getVerification().getAssetID();
            } else {
                System.out.print("\nEnter Asset ID (e.g., USDC-Solana-TEST): ");
                assetID = scanner.nextLine().trim();
            }

            // Get amount
            System.out.print("Enter source amount: ");
            String amount = scanner.nextLine().trim();
            if (amount.isEmpty()) {
                amount = "15";
            }

            // Preview first
            PayoutPreviewRequest previewReq = new PayoutPreviewRequest();
            previewReq.setSourceCoin("USDC");
            previewReq.setSourceAmount(amount);
            previewReq.setDestinationAssetId(assetID);
            previewReq.setDestinationAccountType("wallet");
            previewReq.setDestinationAccountId(selectedAddr.getId());

            PayoutPreviewResp previewResp = client.getPayoutService().previewPayout(previewReq);

            // Extract quote IDs from swap items
            List<String> quoteIDs = new ArrayList<>();
            if (previewResp.getSwapItems() != null && !previewResp.getSwapItems().isEmpty()) {
                System.out.printf("  Found %d swap items%n", previewResp.getSwapItems().size());
                for (PayoutSwapItem swap : previewResp.getSwapItems()) {
                    quoteIDs.add(swap.getQuoteId());
                }
            }

            // Create payout
            System.out.println("\n  Step 2: Creating payout...");
            PayoutCreateRequest createReq = new PayoutCreateRequest();
            createReq.setSourceCoin("USDC");
            createReq.setSourceAmount(amount);
            createReq.setDestinationAssetId(assetID);
            createReq.setDestinationAccountType("wallet");
            createReq.setDestinationAccountId(selectedAddr.getId());
            createReq.setQuoteIds(quoteIDs);

            PayoutCreateResp response = client.getPayoutService().createPayout(createReq);

            System.out.println("\n✓ Payout Created:");
            System.out.printf("  ID: %s%n", response.getId());
            System.out.printf("  Source Amount: %s %s%n", response.getSourceAmount(), response.getSourceCoin());
            System.out.printf("  Receive Amount: %s %s%n", response.getReceiveAmount(), response.getReceiveCoin());
            System.out.printf("  Network Fee: %s%n", response.getPaymentNetworkFee());
            System.out.printf("  Total Fee: %s%n", response.getPaymentTotalFee());
            System.out.printf("  Status: %s%n", response.getStatus());
            System.out.printf("  Approval Status: %s%n", response.getApprovalStatus());

            System.out.println("\n  Note: If amount > $200 USD, approval is required.");
            System.out.println("        Use the approval functions to approve/reject this payout.");
        } catch (IOException e) {
            System.out.printf("✗ API Error: %s%n", e.getMessage());
        }
    }

    // Get details of a specific payout
    public static void getPayout(MartianPayClient client) {
        System.out.println("Getting Payout...");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Payout ID: ");
        String id = scanner.nextLine().trim();
        if (id.isEmpty()) {
            id = "payout_example_id";
        }

        try {
            PayoutGetResp response = client.getPayoutService().getPayout(id);

            System.out.println("\n✓ Payout Retrieved:");
            System.out.printf("  ID: %s%n", response.getId());
            System.out.printf("  Source Amount: %s %s%n", response.getSourceAmount(), response.getSourceCoin());
            System.out.printf("  Receive Amount: %s %s%n", response.getReceiveAmount(), response.getReceiveCoin());
            System.out.printf("  Exchange Rate: %s%n", response.getExchangeRate());
            System.out.printf("  Network Fee: %s%n", response.getPaymentNetworkFee());
            System.out.printf("  Total Fee: %s%n", response.getPaymentTotalFee());
            System.out.printf("  Status: %s%n", response.getStatus());
            System.out.printf("  Approval Status: %s%n", response.getApprovalStatus());
            System.out.printf("  Created: %d%n", response.getCreated());
            System.out.printf("  Updated: %d%n", response.getUpdated());

            if (response.getReceiveWalletAddress() != null) {
                System.out.println("\n  Destination:");
                System.out.printf("    Network: %s%n", response.getReceiveWalletAddress().getNetwork());
                System.out.printf("    Address: %s%n", response.getReceiveWalletAddress().getAddress());
            }
        } catch (IOException e) {
            System.out.printf("✗ API Error: %s%n", e.getMessage());
        }
    }

    // List payouts
    public static void listPayouts(MartianPayClient client) {
        System.out.println("Listing Payouts...");

        PayoutListRequest req = new PayoutListRequest();
        req.setPage(0);
        req.setPageSize(10);

        try {
            PayoutListResp response = client.getPayoutService().listPayouts(req);

            System.out.printf("✓ Total Payouts: %d%n", response.getTotal());
            System.out.printf("  Page: %d, Page Size: %d%n%n", response.getPage(), response.getPageSize());

            if (response.getPayouts() == null || response.getPayouts().isEmpty()) {
                System.out.println("  No payouts found");
                return;
            }

            int index = 1;
            for (Payout payout : response.getPayouts()) {
                System.out.printf("  [%d] ID: %s%n", index++, payout.getId());
                System.out.printf("      Amount: %s %s -> %s %s%n",
                    payout.getSourceAmount(), payout.getSourceCoin(),
                    payout.getReceiveAmount(), payout.getReceiveCoin());
                System.out.printf("      Status: %s, Approval: %s%n",
                    payout.getStatus(), payout.getApprovalStatus());
                if (payout.getReceiveWalletAddress() != null) {
                    System.out.printf("      To: %s (%s)%n",
                        payout.getReceiveWalletAddress().getAddress(),
                        payout.getReceiveWalletAddress().getNetwork());
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.printf("✗ API Error: %s%n", e.getMessage());
        }
    }

    // Cancel a pending payout
    public static void cancelPayout(MartianPayClient client) {
        System.out.println("Canceling Payout...");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Payout ID: ");
        String payoutID = scanner.nextLine().trim();
        if (payoutID.isEmpty()) {
            payoutID = "payout_example_id";
        }

        try {
            Payout response = client.getPayoutService().cancelPayout(payoutID);

            System.out.println("\n✓ Payout Canceled:");
            System.out.printf("  ID: %s%n", response.getId());
            System.out.printf("  Status: %s%n", response.getStatus());
            System.out.printf("  Source Amount: %s %s%n", response.getSourceAmount(), response.getSourceCoin());

            System.out.println("\n  Note: Cancellation windows:");
            System.out.println("    ≤ $200: Can cancel within 10 minutes after creation");
            System.out.println("    $200-$2,000: Can cancel before merchant approval");
            System.out.println("    > $2,000: Can cancel before all approvals complete");
        } catch (IOException e) {
            System.out.printf("✗ API Error: %s%n", e.getMessage());
        }
    }

    // Get payout approval instance
    public static void getPayoutApprovalInstance(MartianPayClient client) {
        System.out.println("Getting Payout Approval Instance...");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Payout ID: ");
        String payoutID = scanner.nextLine().trim();
        if (payoutID.isEmpty()) {
            payoutID = "payout_example_id";
        }

        try {
            ApprovalInstance response = client.getPayoutService().getApprovalInstance(payoutID);

            System.out.println("\n✓ Approval Instance Retrieved:");
            System.out.println("  ID: " + response.getId());
            System.out.println("  Resource ID: " + response.getResourceID());
            System.out.println("  Resource Type: " + response.getResourceType());
            System.out.println("  Status: " + response.getStatus());
            System.out.println("  Created: " + response.getCreatedAt());
            System.out.println("  Updated: " + response.getUpdatedAt());
            System.out.println();

            if (response.getRecords() != null && !response.getRecords().isEmpty()) {
                System.out.println("  Approval Records:");
                for (int i = 0; i < response.getRecords().size(); i++) {
                    ApprovalRecord record = response.getRecords().get(i);
                    System.out.printf("  [%d] Action: %s%n", i + 1, record.getAction());
                    System.out.printf("      Approver: %s (%s)%n", record.getApproverName(), record.getApproverRole());
                    System.out.printf("      Comment: %s%n", record.getComment());
                    System.out.printf("      Namespace: %s%n", record.getNamespace());
                }
            }

            if (response.getCurrentStep() != null) {
                System.out.println("\n  Current Step:");
                System.out.println("    Step Order: " + response.getCurrentStep().getStepOrder());
                System.out.println("    Namespace: " + response.getCurrentStep().getNamespace());
                System.out.println("    Roles: " + response.getCurrentStep().getRoles());
            }
        } catch (IOException e) {
            System.out.printf("✗ API Error: %s%n", e.getMessage());
        }
    }

    // Approve a payout
    public static void approvePayout(MartianPayClient client) {
        System.out.println("Approving Payout...");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Approval Instance ID: ");
        String approvalID = scanner.nextLine().trim();
        if (approvalID.isEmpty()) {
            approvalID = "approval_instance_example_id";
        }

        System.out.print("Enter comment (optional): ");
        String comment = scanner.nextLine().trim();
        if (comment.isEmpty()) {
            comment = "Approved via SDK example";
        }

        try {
            client.getPayoutService().approvePayout(approvalID, comment);

            System.out.println("✓ Payout Approved Successfully");
            System.out.println("  Approval Instance ID: " + approvalID);
            System.out.println("  Comment: " + comment);
        } catch (IOException e) {
            System.out.printf("✗ API Error: %s%n", e.getMessage());
        }
    }

    // Reject a payout
    public static void rejectPayout(MartianPayClient client) {
        System.out.println("Rejecting Payout...");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Approval Instance ID: ");
        String approvalID = scanner.nextLine().trim();
        if (approvalID.isEmpty()) {
            approvalID = "approval_instance_example_id";
        }

        System.out.print("Enter rejection reason: ");
        String reason = scanner.nextLine().trim();
        if (reason.isEmpty()) {
            reason = "Rejected via SDK example";
        }

        try {
            client.getPayoutService().rejectPayout(approvalID, reason);

            System.out.println("✓ Payout Rejected Successfully");
            System.out.println("  Approval Instance ID: " + approvalID);
            System.out.println("  Reason: " + reason);
        } catch (IOException e) {
            System.out.printf("✗ API Error: %s%n", e.getMessage());
        }
    }
}
