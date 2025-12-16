package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Product with quantity for cart and order line items. Combines product details with quantity for total calculation.
 */
public class ProductItem {
    /**
     * Product being purchased with complete details including ID, name, pricing, and variants.
     */
    @SerializedName("product")
    private Product product;

    /**
     * Number of units being purchased. Must be a positive integer.
     */
    @SerializedName("quantity")
    private Integer quantity;

    /**
     * Default constructor for ProductItem.
     */
    public ProductItem() {
    }

    /**
     * Gets the product.
     * @return The product object with full details
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Sets the product.
     * @param product The product object
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Gets the quantity.
     * @return The number of units
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity.
     * @param quantity The number of units (must be positive)
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
