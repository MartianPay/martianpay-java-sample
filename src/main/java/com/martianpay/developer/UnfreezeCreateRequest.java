package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * UnfreezeCreateRequest creates an unfreeze request
 */
public class UnfreezeCreateRequest {
    /**
     * PaymentIntentID is the ID of the payment intent with frozen funds
     */
    @SerializedName("payment_intent_id")
    private String paymentIntentId;

    /**
     * Type is the unfreeze type (unfreeze_reverse or unfreeze_release)
     */
    @SerializedName("type")
    private String type;

    /**
     * Address is the destination address for reversed funds (required when Type is unfreeze_reverse)
     */
    @SerializedName("address")
    private String address;

    /**
     * ExternalID is an optional external identifier for idempotency
     */
    @SerializedName("external_id")
    private String externalId;

    /**
     * Description is an optional description of the unfreeze reason
     */
    @SerializedName("description")
    private String description;

    public UnfreezeCreateRequest() {
    }

    // Getters and Setters
    public String getPaymentIntentId() {
        return paymentIntentId;
    }

    public void setPaymentIntentId(String paymentIntentId) {
        this.paymentIntentId = paymentIntentId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
