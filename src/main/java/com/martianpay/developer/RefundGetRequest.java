package com.martianpay.developer;

/**
 * Request to retrieve a specific refund by ID.
 */
public class RefundGetRequest {
    /**
     * Unique identifier of the refund to retrieve.
     */
    private String id;

    public RefundGetRequest() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
