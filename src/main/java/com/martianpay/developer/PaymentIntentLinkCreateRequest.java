package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class PaymentIntentLinkCreateRequest {
    @SerializedName("payment_link_id")
    private String paymentLinkId;

    @SerializedName("product_version")
    private Long productVersion;

    @SerializedName("primary_variant")
    private VariantSelectionRequest primaryVariant;

    @SerializedName("addons")
    private List<VariantSelectionRequest> addons;

    @SerializedName("customer")
    private String customer;

    @SerializedName("customer_auth_token")
    private String customerAuthToken;

    @SerializedName("merchant_order_id")
    private String merchantOrderId;

    @SerializedName("description")
    private String description;

    @SerializedName("receipt_email")
    private String receiptEmail;

    @SerializedName("return_url")
    private String returnUrl;

    @SerializedName("shipping_address")
    private PaymentIntentShippingAddress shippingAddress;

    @SerializedName("tax_region")
    private PaymentIntentTaxRegion taxRegion;

    public PaymentIntentLinkCreateRequest() {
    }

    public String getPaymentLinkId() {
        return paymentLinkId;
    }

    public void setPaymentLinkId(String paymentLinkId) {
        this.paymentLinkId = paymentLinkId;
    }

    public Long getProductVersion() {
        return productVersion;
    }

    public void setProductVersion(Long productVersion) {
        this.productVersion = productVersion;
    }

    public VariantSelectionRequest getPrimaryVariant() {
        return primaryVariant;
    }

    public void setPrimaryVariant(VariantSelectionRequest primaryVariant) {
        this.primaryVariant = primaryVariant;
    }

    public List<VariantSelectionRequest> getAddons() {
        return addons;
    }

    public void setAddons(List<VariantSelectionRequest> addons) {
        this.addons = addons;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCustomerAuthToken() {
        return customerAuthToken;
    }

    public void setCustomerAuthToken(String customerAuthToken) {
        this.customerAuthToken = customerAuthToken;
    }

    public String getMerchantOrderId() {
        return merchantOrderId;
    }

    public void setMerchantOrderId(String merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReceiptEmail() {
        return receiptEmail;
    }

    public void setReceiptEmail(String receiptEmail) {
        this.receiptEmail = receiptEmail;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public PaymentIntentShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(PaymentIntentShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public PaymentIntentTaxRegion getTaxRegion() {
        return taxRegion;
    }

    public void setTaxRegion(PaymentIntentTaxRegion taxRegion) {
        this.taxRegion = taxRegion;
    }
}
