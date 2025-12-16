package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * API response containing detailed order information including customer data, items, shipping details, and status.
 */
public class OrderDetailResponse {
    /**
     * Complete order details including customer, items, pricing, and status.
     */
    @SerializedName("order")
    private OrderDetail order;

    /**
     * Default constructor for OrderDetailResponse.
     */
    public OrderDetailResponse() {
    }

    /**
     * Gets the complete order details.
     * @return The order details
     */
    public OrderDetail getOrder() {
        return order;
    }

    /**
     * Sets the complete order details.
     * @param order The order details
     */
    public void setOrder(OrderDetail order) {
        this.order = order;
    }
}
