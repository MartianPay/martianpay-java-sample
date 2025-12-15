package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * CustomerPaymentMethodListRequest lists payment methods for a specific customer (merchant auth)
 */
public class CustomerPaymentMethodListRequest {
    @SerializedName("customer_id")
    private String customerID;

    // Getters and Setters
    public String getCustomerID() { return customerID; }
    public void setCustomerID(String customerID) { this.customerID = customerID; }
}
