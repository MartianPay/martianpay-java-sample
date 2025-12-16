package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * PayerMaxDropinOrderResponse represents the response after creating a PayerMax drop-in order.
 *
 * This response is returned when integrating with PayerMax payment gateway using their
 * drop-in UI solution. PayerMax is a payment service provider that supports various
 * payment methods popular in different regions, particularly in Asia and emerging markets.
 *
 * The drop-in integration provides:
 * - Pre-built payment UI components
 * - Support for local payment methods
 * - Streamlined checkout experience
 * - Automatic payment method detection based on region
 *
 * Response contains:
 * - success: Indicates if the order creation was successful
 * - charge_id: Unique identifier for the payment charge in PayerMax
 * - payment_intent: Associated MartianPay payment intent with full details
 *
 * Typical workflow:
 * 1. Merchant initiates PayerMax drop-in order creation
 * 2. System creates charge in PayerMax and payment intent in MartianPay
 * 3. Customer is presented with PayerMax payment interface
 * 4. Customer completes payment through their preferred method
 * 5. Payment status is synchronized between PayerMax and MartianPay
 *
 * Use cases:
 * - Accept payments through PayerMax gateway
 * - Support region-specific payment methods
 * - Integrate drop-in payment UI for faster implementation
 * - Process payments in markets where PayerMax is prevalent
 * - Provide localized payment experience to customers
 */
public class PayerMaxDropinOrderResponse {
    /**
     * Indicates whether the PayerMax order was successfully created.
     * true if creation succeeded, false otherwise.
     */
    @SerializedName("success")
    private Boolean success;

    /**
     * Unique charge identifier from PayerMax system.
     * Used to track and reference this payment in PayerMax.
     */
    @SerializedName("charge_id")
    private String chargeId;

    /**
     * The associated payment intent in MartianPay system.
     * Contains complete payment details, status, and tracking information.
     */
    @SerializedName("payment_intent")
    private PaymentIntent paymentIntent;

    /**
     * Default constructor for PayerMaxDropinOrderResponse.
     */
    public PayerMaxDropinOrderResponse() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getChargeId() {
        return chargeId;
    }

    public void setChargeId(String chargeId) {
        this.chargeId = chargeId;
    }

    public PaymentIntent getPaymentIntent() {
        return paymentIntent;
    }

    public void setPaymentIntent(PaymentIntent paymentIntent) {
        this.paymentIntent = paymentIntent;
    }
}
