package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * PayrollDirectCreateRequest creates a payroll directly without CSV upload
 */
public class PayrollDirectCreateRequest {
    /**
     * ExternalID is the external ID for idempotency
     */
    @SerializedName("external_id")
    private String externalId;

    /**
     * Items is the list of payroll recipients
     */
    @SerializedName("items")
    private List<PayrollDirectItem> items;

    /**
     * AutoApprove indicates whether to automatically approve the payroll
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
