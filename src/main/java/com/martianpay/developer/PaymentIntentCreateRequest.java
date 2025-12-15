package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

/**
 * PaymentIntentCreateRequest represents a request to create a new payment intent
 */
public class PaymentIntentCreateRequest {
    /**
     * Amount is the amount to be charged in the specified currency (required for traditional mode, optional for payment link mode)
     */
    @SerializedName("amount")
    private String amount;

    /**
     * Currency is the ISO 4217 currency code (required for traditional mode, optional for payment link mode)
     */
    @SerializedName("currency")
    private String currency;

    /**
     * Customer is the identifier of the customer this payment intent belongs to
     */
    @SerializedName("customer")
    private String customer;

    /**
     * Description is an arbitrary string attached to the object, often useful for displaying to users
     */
    @SerializedName("description")
    private String description;

    /**
     * Metadata is a set of key-value pairs that you can attach to the object
     */
    @SerializedName("metadata")
    private Map<String, String> metadata;

    /**
     * MerchantOrderId is an optional unique identifier for the order on the merchant's side (must be unique per merchant if provided)
     */
    @SerializedName("merchant_order_id")
    private String merchantOrderId;

    /**
     * ReceiptEmail is the email address to send the receipt to
     */
    @SerializedName("receipt_email")
    private String receiptEmail;

    /**
     * ReturnURL is the URL to redirect the customer to after payment
     */
    @SerializedName("return_url")
    private String returnUrl;

    /**
     * PaymentMethodID is the ID of a saved payment method to use for this payment (Stripe only)
     */
    @SerializedName("payment_method_id")
    private String paymentMethodId;

    /**
     * PaymentLinkID is the optional ID of the payment link used to create this payment intent
     */
    @SerializedName("payment_link_id")
    private String paymentLinkId;

    /**
     * ProductVersion is the optional version of the product catalog to use
     */
    @SerializedName("product_version")
    private Long productVersion;

    /**
     * PrimaryVariant is the optional primary variant selection
     */
    @SerializedName("primary_variant")
    private VariantSelectionRequest primaryVariant;

    /**
     * Addons is the optional list of addon variant selections
     */
    @SerializedName("addons")
    private List<VariantSelectionRequest> addons;

    /**
     * ShippingAddress is the optional shipping address for the payment intent
     */
    @SerializedName("shipping_address")
    private PaymentIntentShippingAddress shippingAddress;

    /**
     * TaxRegion is the optional tax jurisdiction for the payment intent
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
