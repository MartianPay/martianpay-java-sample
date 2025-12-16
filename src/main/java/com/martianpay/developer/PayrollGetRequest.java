package com.martianpay.developer;

/**
 * Request to retrieve a specific payroll batch by ID.
 */
public class PayrollGetRequest {
    /**
     * Unique identifier of the payroll batch to retrieve.
     */
    private String id;

    public PayrollGetRequest() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
