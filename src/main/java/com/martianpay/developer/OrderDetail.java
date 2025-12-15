package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class OrderDetail {
    @SerializedName("order_number")
    private String orderNumber;

    @SerializedName("external_id")
    private String externalId;

    @SerializedName("customer")
    private OrderCustomer customer;

    @SerializedName("shipping_address")
    private OrderShippingAddress shippingAddress;

    @SerializedName("tax_region")
    private OrderTaxRegion taxRegion;

    @SerializedName("items")
    private List<OrderItem> items;

    @SerializedName("total_amount")
    private AssetAmount totalAmount;

    @SerializedName("status")
    private String status;

    @SerializedName("payment_method")
    private String paymentMethod;

    @SerializedName("created_at")
    private Long createdAt;

    @SerializedName("updated_at")
    private Long updatedAt;

    public OrderDetail() {
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public OrderCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(OrderCustomer customer) {
        this.customer = customer;
    }

    public OrderShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(OrderShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public OrderTaxRegion getTaxRegion() {
        return taxRegion;
    }

    public void setTaxRegion(OrderTaxRegion taxRegion) {
        this.taxRegion = taxRegion;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public AssetAmount getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(AssetAmount totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }
}
