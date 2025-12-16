package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Request to create a payroll directly without CSV upload.
 */
public class PayrollDirectCreateRequest {
    /**
     * External ID for idempotency.
     */
    @SerializedName("external_id")
    private String externalId;

    /**
     * List of payroll recipients.
     */
    @SerializedName("items")
    private List<PayrollDirectItem> items;

    /**
     * Whether to automatically approve the payroll.
     */
    @SerializedName("auto_approve")
    private Boolean autoApprove;

    public PayrollDirectCreateRequest() {
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public List<PayrollDirectItem> getItems() {
        return items;
    }

    public void setItems(List<PayrollDirectItem> items) {
        this.items = items;
    }

    public Boolean getAutoApprove() {
        return autoApprove;
    }

    public void setAutoApprove(Boolean autoApprove) {
        this.autoApprove = autoApprove;
    }
}
