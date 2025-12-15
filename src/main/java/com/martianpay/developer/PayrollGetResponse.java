package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class PayrollGetResponse {
    @SerializedName("payroll")
    private Payroll payroll;

    @SerializedName("items")
    private List<PayrollItems> items;

    @SerializedName("swap_items")
    private List<PayrollSwapItems> swapItems;

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
