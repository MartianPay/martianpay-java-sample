package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Request to create a payment intent from an existing payment link.
 */
public class PaymentIntentLinkCreateRequest {
    /**
     * Unique identifier of the payment link to use.
     */
    @SerializedName("payment_link_id")
    private String paymentLinkId;

    /**
     * Version of the product catalog to use.
     */
    @SerializedName("product_version")
    private Long productVersion;

    /**
     * Selected primary variant for the purchase.
     */
    @SerializedName("primary_variant")
    private VariantSelectionRequest primaryVariant;

    /**
     * List of selected addon variants.
     */
    @SerializedName("addons")
    private List<VariantSelectionRequest> addons;

    /**
     * Customer ID for this payment intent.
     */
    @SerializedName("customer")
    private String customer;

    /**
     * Authentication token for the customer.
     */
    @SerializedName("customer_auth_token")
    private String customerAuthToken;

    /**
     * Unique identifier for this order from the merchant's system.
     */
    @SerializedName("merchant_order_id")
    private String merchantOrderId;

    /**
     * Description of this payment intent.
     */
    @SerializedName("description")
    private String description;

    /**
     * Email address to send the payment receipt to.
     */
    @SerializedName("receipt_email")
    private String receiptEmail;

    /**
     * URL to redirect the customer to after payment completion.
     */
    @SerializedName("return_url")
    private String returnUrl;

    /**
     * Shipping address for physical product delivery.
     */
    @SerializedName("shipping_address")
    private PaymentIntentShippingAddress shippingAddress;

    /**
     * Tax jurisdiction information for tax calculation.
     */
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
