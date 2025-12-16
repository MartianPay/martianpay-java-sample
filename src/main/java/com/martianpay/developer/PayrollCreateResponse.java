package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Response after creating a payroll batch with individual payout items.
 */
public class PayrollCreateResponse {
    /** The newly created payroll batch. */
    @SerializedName("payroll")
    private Payroll payroll;

    /** List of individual payout items for each recipient. */
    @SerializedName("items")
    private List<PayrollItems> items;

    /** List of currency swap operations (if applicable). */
    @SerializedName("swap_items")
    private List<PayrollSwapItems> swapItems;

    /** List of Binance-specific items (if applicable). */
    @SerializedName("binance_from_items")
    private List<BinanceFromItems> binanceFromItems;

    public PayrollCreateResponse() {
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
