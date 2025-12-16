package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

/**
 * Parameters for creating a payment intent.
 */
public class PaymentIntentParams {
    /**
     * Amount to charge in smallest currency unit (e.g., "10000" for $100.00 USD or 100 USDT).
     */
    @SerializedName("amount")
    private String amount;

    /**
     * Currency or asset code (e.g., "USD", "USDT", "BTC", "ETH"). Currently only USD is supported for fiat.
     */
    @SerializedName("currency")
    private String currency;

    /**
     * Customer ID (starts with "cus_").
     */
    @SerializedName("customer")
    private String customer;

    /**
     * Human-readable description of the payment.
     */
    @SerializedName("description")
    private String description;

    /**
     * Key-value pairs for storing additional information.
     */
    @SerializedName("metadata")
    private Map<String, String> metadata;

    /**
     * Your internal order or transaction identifier.
     */
    @SerializedName("merchant_order_id")
    private String merchantOrderId;

    /**
     * Email address for sending payment receipt.
     */
    @SerializedName("receipt_email")
    private String receiptEmail;

    /**
     * URL for redirecting customer after payment completion.
     */
    @SerializedName("return_url")
    private String returnUrl;

    /**
     * ID of a saved payment method (starts with "pm_").
     */
    @SerializedName("payment_method_id")
    private String paymentMethodId;

    public PaymentIntentParams() {
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
}
