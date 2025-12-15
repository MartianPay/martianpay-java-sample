package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

public class OrderDetailResponse {
    @SerializedName("order")
    private OrderDetail order;

    public OrderDetailResponse() {
    }

    public OrderDetail getOrder() {
        return order;
    }

    public void setOrder(OrderDetail order) {
        this.order = order;
    }
}
