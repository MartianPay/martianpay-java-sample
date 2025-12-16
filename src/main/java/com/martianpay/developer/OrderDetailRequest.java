package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Request to retrieve detailed information about a specific order.
 */
public class OrderDetailRequest {
    /**
     * The unique order number identifying the order to retrieve.
     */
    @SerializedName("order_number")
    private String orderNumber;

    /**
     * Default constructor for OrderDetailRequest.
     */
    public OrderDetailRequest() {
    }

    /**
     * Gets the order number for the order to retrieve.
     * @return The order number
     */
    public String getOrderNumber() {
        return orderNumber;
    }

    /**
     * Sets the order number for the order to retrieve.
     * @param orderNumber The order number
     */
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}
