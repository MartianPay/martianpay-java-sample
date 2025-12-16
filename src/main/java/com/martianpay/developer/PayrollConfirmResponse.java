package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * PayrollConfirmResponse represents the response after confirming a payroll batch.
 *
 * This response is returned when a merchant confirms a previously created payroll batch,
 * authorizing it for execution. The confirmation step provides a final review opportunity
 * before funds are distributed to recipients, ensuring accuracy and preventing errors.
 *
 * Response components:
 * - payroll: Updated payroll batch with confirmed status
 * - items: Individual payout items ready for execution
 * - swap_items: Finalized currency conversion operations
 * - binance_from_items: Confirmed Binance transaction items
 *
 * Confirmation workflow:
 * 1. Merchant creates payroll batch (in draft/pending state)
 * 2. System calculates fees and validates all items
 * 3. Merchant reviews batch details and amounts
 * 4. Merchant calls confirm endpoint
 * 5. Batch status changes to confirmed/processing
 * 6. System begins executing individual payouts
 *
 * The confirmation ensures:
 * - All recipient addresses are valid
 * - Sufficient balance is available
 * - Fee calculations are accurate
 * - No duplicate payments exist
 * - Merchant explicitly authorizes the batch
 *
 * Use cases:
 * - Two-step payroll processing for added security
 * - Review batch totals before execution
 * - Approve large payout batches with management oversight
 * - Validate all calculations before fund distribution
 * - Implement approval workflows for payroll operations
 */
public class PayrollConfirmResponse {
    /**
     * The confirmed payroll batch object.
     * Status is updated to reflect confirmation and processing state.
     */
    @SerializedName("payroll")
    private Payroll payroll;

    /**
     * List of individual payout items that will be executed.
     * Each item is validated and ready for processing.
     */
    @SerializedName("items")
    private List<PayrollItems> items;

    /**
     * List of confirmed currency swap operations.
     * All conversions are locked in and ready for execution.
     */
    @SerializedName("swap_items")
    private List<PayrollSwapItems> swapItems;

    /**
     * List of confirmed Binance-specific transaction items.
     * Prepared for execution through Binance integration.
     */
    @SerializedName("binance_from_items")
    private List<BinanceFromItems> binanceFromItems;

    /**
     * Default constructor for PayrollConfirmResponse.
     */
    public PayrollConfirmResponse() {
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

    public List<BinanceFromItems> getBinanceFromItems() {
        return binanceFromItems;
    }

    public void setBinanceFromItems(List<BinanceFromItems> binanceFromItems) {
        this.binanceFromItems = binanceFromItems;
    }
}
