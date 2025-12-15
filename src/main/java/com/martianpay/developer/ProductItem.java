package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

public class ProductItem {
    @SerializedName("product")
    private Product product;

    @SerializedName("quantity")
    private Integer quantity;

    public ProductItem() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
