package com.martianpay.developer;

/**
 * Request to retrieve a specific payout by ID.
 */
public class PayoutGetRequest {
    /**
     * Unique identifier of the payout to retrieve.
     */
    private String id;

    public PayoutGetRequest() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
