package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

public class OrderDetailRequest {
    @SerializedName("order_number")
    private String orderNumber;

    public OrderDetailRequest() {
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}
