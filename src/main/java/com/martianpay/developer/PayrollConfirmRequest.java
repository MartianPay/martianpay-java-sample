package com.martianpay.developer;

/**
 * Request to confirm and approve a payroll batch for processing.
 */
public class PayrollConfirmRequest {
    /**
     * Unique identifier of the payroll batch to confirm.
     */
    private String id;

    public PayrollConfirmRequest() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
