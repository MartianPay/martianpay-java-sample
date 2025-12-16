package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * PayrollDirectCreateResponse represents the response after creating a direct payroll batch.
 *
 * This response contains comprehensive information about a newly created payroll batch that
 * will be processed directly without requiring additional confirmation. Direct payroll creation
 * immediately initiates the payout process for all included recipients.
 *
 * Response components:
 * - payroll: Main payroll batch information (ID, status, total amount, etc.)
 * - items: Individual payout items for each recipient
 * - swap_items: Currency conversion operations if different payout currencies are used
 * - binance_from_items: Binance-specific transaction items if using Binance integration
 *
 * The direct creation flow:
 * 1. Merchant submits payroll batch with all recipient details
 * 2. System validates all addresses and amounts
 * 3. Payroll batch is created and immediately queued for processing
 * 4. Individual payout items are generated for each recipient
 * 5. Swap operations are prepared if currency conversions are needed
 * 6. Batch moves to processing state for execution
 *
 * Use cases:
 * - Automated salary/wage payments to employees
 * - Bulk vendor/supplier payments
 * - Affiliate/partner commission distributions
 * - Contest/reward payouts to multiple winners
 * - Dividend distributions to token holders
 */
public class PayrollDirectCreateResponse {
    /**
     * The main payroll batch object containing batch-level information.
     * Includes batch ID, total amount, status, creation time, and processing details.
     */
    @SerializedName("payroll")
    private Payroll payroll;

    /**
     * List of individual payout items for each recipient in the batch.
     * Each item contains recipient address, amount, currency, and payout status.
     */
    @SerializedName("items")
    private List<PayrollItems> items;

    /**
     * List of currency swap operations required for this payroll batch.
     * Generated when payouts use different currencies than the source balance.
     */
    @SerializedName("swap_items")
    private List<PayrollSwapItems> swapItems;

    /**
     * List of Binance-specific transaction items.
     * Populated when using Binance integration for certain payout operations.
     */
    @SerializedName("binance_from_items")
    private List<BinanceFromItems> binanceFromItems;

    /**
     * Default constructor for PayrollDirectCreateResponse.
     */
    public PayrollDirectCreateResponse() {
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
