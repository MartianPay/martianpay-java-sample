package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * PaymentIntentInvoiceCreateResponse represents the response after creating a payment intent from an invoice.
 *
 * This response is returned when a merchant creates a payment intent based on an existing invoice.
 * It combines invoice billing information with payment intent functionality, enabling customers
 * to pay invoices through various payment methods supported by MartianPay.
 *
 * The payment intent contains:
 * - Invoice details and line items
 * - Payment amount and currency
 * - Customer information
 * - Available payment methods
 * - Payment status and tracking
 *
 * Workflow:
 * 1. Merchant creates/sends invoice to customer
 * 2. System generates payment intent from invoice
 * 3. Customer receives payment link or interface
 * 4. Customer completes payment using preferred method
 * 5. Invoice is marked as paid upon successful payment
 *
 * Use cases:
 * - Convert invoices into payable payment intents
 * - Enable invoice payment through multiple payment methods
 * - Track invoice payment status and history
 * - Integrate invoice billing with payment processing
 * - Send payment requests for outstanding invoices
 */
public class PaymentIntentInvoiceCreateResponse {
    /**
     * The payment intent created from the invoice.
     * Contains all payment details, customer information, and payment tracking data.
     */
    @SerializedName("payment_intent")
    private PaymentIntent paymentIntent;

    /**
     * Default constructor for PaymentIntentInvoiceCreateResponse.
     */
    public PaymentIntentInvoiceCreateResponse() {
    }

    /**
     * Gets the payment intent created from the invoice.
     * @return The payment intent object
     */
    public PaymentIntent getPaymentIntent() {
        return paymentIntent;
    }

    /**
     * Sets the payment intent created from the invoice.
     * @param paymentIntent The payment intent object
     */
    public void setPaymentIntent(PaymentIntent paymentIntent) {
        this.paymentIntent = paymentIntent;
    }
}
