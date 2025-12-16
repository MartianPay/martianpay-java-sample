package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

/**
 * Request to create a new payment intent.
 */
public class PaymentIntentCreateRequest {
    /**
     * Amount to be charged. Currently only USD is supported.
     */
    @SerializedName("amount")
    private String amount;

    /**
     * Currency code (ISO 4217). Currently only USD is supported.
     */
    @SerializedName("currency")
    private String currency;

    /**
     * Customer identifier.
     */
    @SerializedName("customer")
    private String customer;

    /**
     * Description of the payment.
     */
    @SerializedName("description")
    private String description;

    /**
     * Custom key-value pairs for additional data.
     */
    @SerializedName("metadata")
    private Map<String, String> metadata;

    /**
     * Unique identifier for the order on the merchant's side.
     */
    @SerializedName("merchant_order_id")
    private String merchantOrderId;

    /**
     * Email address to send the receipt to.
     */
    @SerializedName("receipt_email")
    private String receiptEmail;

    /**
     * URL to redirect the customer to after payment.
     */
    @SerializedName("return_url")
    private String returnUrl;

    /**
     * ID of a saved payment method to use.
     */
    @SerializedName("payment_method_id")
    private String paymentMethodId;

    /**
     * Payment link ID used to create this payment intent.
     */
    @SerializedName("payment_link_id")
    private String paymentLinkId;

    /**
     * Version of the product catalog to use.
     */
    @SerializedName("product_version")
    private Long productVersion;

    /**
     * Primary variant selection.
     */
    @SerializedName("primary_variant")
    private VariantSelectionRequest primaryVariant;

    /**
     * List of addon variant selections.
     */
    @SerializedName("addons")
    private List<VariantSelectionRequest> addons;

    /**
     * Shipping address for the payment intent.
     */
    @SerializedName("shipping_address")
    private PaymentIntentShippingAddress shippingAddress;

    /**
     * Tax jurisdiction for the payment intent.
     */
    @SerializedName("tax_region")
    private PaymentIntentTaxRegion taxRegion;

    public PaymentIntentCreateRequest() {
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

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    public String getMerchantOrderId() {
        return merchantOrderId;
    }

    public void setMerchantOrderId(String merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
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

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
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
