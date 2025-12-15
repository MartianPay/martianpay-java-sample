package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * PayrollListResponse represents a paginated list of payroll batches
 */
public class PayrollListResponse {
    /**
     * Payrolls is the list of payroll batches in the current page
     */
    @SerializedName("payrolls")
    private List<Payroll> payrolls;

    /**
     * Total is the total number of payrolls matching the query
     */
    @SerializedName("total")
    private Long total;

    public PayrollListResponse() {
    }

    public List<Payroll> getPayrolls() {
        return payrolls;
    }

    public void setPayrolls(List<Payroll> payrolls) {
        this.payrolls = payrolls;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
