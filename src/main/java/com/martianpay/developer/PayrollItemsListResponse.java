package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * PayrollItemsListResponse represents a paginated list of payroll items
 */
public class PayrollItemsListResponse {
    /**
     * PayrollItems is the list of payroll items in the current page
     */
    @SerializedName("payroll_items")
    private List<PayrollItems> payrollItems;

    /**
     * Total is the total number of payroll items matching the query
     */
    @SerializedName("total")
    private Long total;

    public PayrollItemsListResponse() {
    }

    public List<PayrollItems> getPayrollItems() {
        return payrollItems;
    }

    public void setPayrollItems(List<PayrollItems> payrollItems) {
        this.payrollItems = payrollItems;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
