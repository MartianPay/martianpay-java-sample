package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

public class InvoiceLineItemDetails {
    @SerializedName("description")
    private String description;

    @SerializedName("product_id")
    private String productId;

    @SerializedName("variant_id")
    private String variantId;

    @SerializedName("quantity")
    private Integer quantity;

    @SerializedName("unit_amount")
    private String unitAmount;

    @SerializedName("amount")
    private String amount;

    @SerializedName("currency")
    private String currency;

    @SerializedName("period_start")
    private Long periodStart;

    @SerializedName("period_end")
    private Long periodEnd;

    @SerializedName("metadata")
    private Map<String, Object> metadata;

    @SerializedName("product_name")
    private String productName;

    @SerializedName("variant_title")
    private String variantTitle;

    public InvoiceLineItemDetails() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getVariantId() {
        return variantId;
    }

    public void setVariantId(String variantId) {
        this.variantId = variantId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getUnitAmount() {
        return unitAmount;
    }

    public void setUnitAmount(String unitAmount) {
        this.unitAmount = unitAmount;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Long getPeriodStart() {
        return periodStart;
    }

    public void setPeriodStart(Long periodStart) {
        this.periodStart = periodStart;
    }

    public Long getPeriodEnd() {
        return periodEnd;
    }

    public void setPeriodEnd(Long periodEnd) {
        this.periodEnd = periodEnd;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getVariantTitle() {
        return variantTitle;
    }

    public void setVariantTitle(String variantTitle) {
        this.variantTitle = variantTitle;
    }
}
