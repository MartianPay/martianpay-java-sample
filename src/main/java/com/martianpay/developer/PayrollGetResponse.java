package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * PayrollGetResponse represents the response when retrieving payroll batch details.
 *
 * This response contains complete information about an existing payroll batch, including
 * its current status, all payout items, and any associated currency swap operations.
 * It's used to check batch progress, review details, and monitor individual payout statuses.
 *
 * Response components:
 * - payroll: Main batch object with status and summary information
 * - items: List of all individual payout items with their current statuses
 * - swap_items: Currency conversion operations associated with this batch
 *
 * Status tracking:
 * The response includes real-time status for both the batch and individual items:
 * - Batch status: pending, confirmed, processing, completed, failed, cancelled
 * - Item status: pending, processing, completed, failed
 *
 * Use this endpoint to:
 * - Monitor payroll batch execution progress
 * - Check individual payout completion status
 * - Verify transaction details and amounts
 * - Retrieve transaction hashes for completed payouts
 * - Identify failed items for retry or investigation
 * - Track currency conversions and fees
 *
 * Use cases:
 * - Display payroll batch status in admin dashboards
 * - Monitor bulk payment progress
 * - Generate payout reports and receipts
 * - Troubleshoot failed or pending payouts
 * - Verify successful fund distribution
 * - Reconcile payroll transactions
 */
public class PayrollGetResponse {
    /**
     * The payroll batch object with current status and summary data.
     * Includes batch ID, total amounts, recipient count, and processing state.
     */
    @SerializedName("payroll")
    private Payroll payroll;

    /**
     * List of individual payout items in this batch.
     * Each item shows recipient details, amount, status, and transaction information.
     */
    @SerializedName("items")
    private List<PayrollItems> items;

    /**
     * List of currency swap operations for this batch.
     * Shows conversions performed and their status.
     */
    @SerializedName("swap_items")
    private List<PayrollSwapItems> swapItems;

    /**
     * Default constructor for PayrollGetResponse.
     */
    public PayrollGetResponse() {
    }

    public Payroll getPayroll() {
        return payroll;
    }

    public void setPayroll(Payroll payroll) {
        this.payroll = payroll;
    }

    public List<PayrollItems> getItems() {
        return items;
    }

    public void setItems(List<PayrollItems> items) {
        this.items = items;
    }

    public List<PayrollSwapItems> getSwapItems() {
        return swapItems;
    }

    public void setSwapItems(List<PayrollSwapItems> swapItems) {
        this.swapItems = swapItems;
    }
}
