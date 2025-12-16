package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Request to create an unfreeze request for frozen funds.
 */
public class UnfreezeCreateRequest {
    /**
     * ID of the payment intent with frozen funds.
     */
    @SerializedName("payment_intent_id")
    private String paymentIntentId;

    /**
     * Unfreeze type (unfreeze_reverse or unfreeze_release).
     */
    @SerializedName("type")
    private String type;

    /**
     * Destination address for reversed funds.
     */
    @SerializedName("address")
    private String address;

    /**
     * External identifier for idempotency.
     */
    @SerializedName("external_id")
    private String externalId;

    /**
     * Description of the unfreeze reason.
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
