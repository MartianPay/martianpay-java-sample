package com.martianpay.developer;

/**
 * GetCustomerInvoicePaymentIntentRequest represents a request to retrieve the payment intent
 * associated with an invoice from the customer's perspective.
 *
 * A payment intent represents a customer's intention to pay an invoice and tracks the
 * payment lifecycle from creation through completion. This request allows customers to
 * retrieve the payment intent details to complete or monitor their payment.
 *
 * Use cases:
 * - Customer retrieves payment details to complete an unpaid invoice
 * - Check payment status and progress
 * - Get payment instructions (crypto addresses, amounts, etc.)
 * - Resume an incomplete payment flow
 * - Verify payment has been processed
 * - Access payment history for an invoice
 *
 * Payment intent information typically includes:
 * - Payment status (pending, processing, succeeded, failed)
 * - Supported payment methods (crypto, fiat)
 * - Payment amounts in various currencies
 * - Deposit addresses for cryptocurrency payments
 * - Expiration time for payment
 * - Transaction history and confirmations
 *
 * Access control:
 * - Customers can only access payment intents for their own invoices
 * - Requires customer authentication
 * - Invoice must be accessible to the requesting customer
 * - Cannot access other customers' payment intents
 *
 * Workflow:
 * 1. Customer receives invoice ID (from email, dashboard, etc.)
 * 2. Requests payment intent using this API
 * 3. Receives payment intent with current status and payment options
 * 4. Uses payment intent information to complete payment
 * 5. Can re-query to check payment status updates
 */
public class GetCustomerInvoicePaymentIntentRequest {
    /**
     * The unique identifier of the invoice to retrieve the payment intent for.
     * Format: inv_[random_id]
     *
     * This invoice must:
     * - Belong to the authenticated customer
     * - Have an associated payment intent
     * - Be in a state that allows payment (open, unpaid)
     *
     * The system will return the payment intent associated with this invoice,
     * which contains all the information needed to complete the payment.
     */
    private String invoiceId;

    /**
     * Creates a new GetCustomerInvoicePaymentIntentRequest instance.
     */
    public GetCustomerInvoicePaymentIntentRequest() {
    }

    /**
     * Gets the invoice ID for which to retrieve the payment intent.
     * @return The invoice ID
     */
    public String getInvoiceId() {
        return invoiceId;
    }

    /**
     * Sets the invoice ID for which to retrieve the payment intent.
     * @param invoiceId The invoice ID
     */
    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }
}
