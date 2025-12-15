package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

public class OrderItem {
    @SerializedName("product_id")
    private String productId;

    @SerializedName("product_name")
    private String productName;

    @SerializedName("product_description")
    private String productDescription;

    @SerializedName("variant_id")
    private String variantId;

    @SerializedName("option_values")
    private Map<String, String> optionValues;

    @SerializedName("quantity")
    private Integer quantity;

    @SerializedName("unit_price")
    private AssetAmount unitPrice;

    @SerializedName("total")
    private AssetAmount total;

    @SerializedName("media_order")
    private List<String> mediaOrder;

    @SerializedName("product")
    private Product product;

    @SerializedName("variant")
    private ProductVariant variant;

    public OrderItem() {
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getVariantId() {
        return variantId;
    }

    public void setVariantId(String variantId) {
        this.variantId = variantId;
    }

    public Map<String, String> getOptionValues() {
        return optionValues;
    }

    public void setOptionValues(Map<String, String> optionValues) {
        this.optionValues = optionValues;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public AssetAmount getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(AssetAmount unitPrice) {
        this.unitPrice = unitPrice;
    }

    public AssetAmount getTotal() {
        return total;
    }

    public void setTotal(AssetAmount total) {
        this.total = total;
    }

    public List<String> getMediaOrder() {
        return mediaOrder;
    }

    public void setMediaOrder(List<String> mediaOrder) {
        this.mediaOrder = mediaOrder;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductVariant getVariant() {
        return variant;
    }

    public void setVariant(ProductVariant variant) {
        this.variant = variant;
    }
}
