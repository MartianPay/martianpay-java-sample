package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class PayrollCreateResponse {
    @SerializedName("payroll")
    private Payroll payroll;

    @SerializedName("items")
    private List<PayrollItems> items;

    @SerializedName("swap_items")
    private List<PayrollSwapItems> swapItems;

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
