package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Response containing newly created refund transactions.
 */
public class RefundCreateResponse {
    /** List of newly created refunds. */
    @SerializedName("refunds")
    private List<Refund> refunds;

    // Getters and Setters
    public List<Refund> getRefunds() { return refunds; }
    public void setRefunds(List<Refund> refunds) { this.refunds = refunds; }
}
