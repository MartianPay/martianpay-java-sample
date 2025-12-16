package com.martianpay.developer;

/**
 * GetMerchantInvoicePaymentIntentRequest represents a request to retrieve the payment intent
 * associated with an invoice from the merchant's perspective.
 *
 * This request allows merchants to access the payment intent for any invoice they have
 * created, providing complete visibility into the payment status, methods, and history.
 * Merchants have full access to all payment intent details including internal metadata.
 *
 * Merchant payment intent information includes:
 * - Complete payment status and lifecycle
 * - All attempted payment methods
 * - Detailed transaction history
 * - Blockchain confirmation details
 * - Payment amounts and conversions
 * - Customer payment actions
 * - Internal notes and metadata
 * - Fee breakdowns and settlements
 * - Refund and adjustment information
 *
 * Use cases:
 * - Monitor payment progress for customer invoices
 * - Track payment confirmations on blockchain
 * - Review payment method attempts and failures
 * - Access complete payment history for reconciliation
 * - Retrieve payment details for customer support
 * - Analyze payment patterns and success rates
 * - Generate financial reports and statements
 * - Debug payment issues
 *
 * Access control:
 * - Merchants can access payment intents for any of their invoices
 * - Requires merchant API authentication
 * - Full access to all payment intent states and details
 * - Can view draft and internal payment information
 *
 * Merchant vs Customer access differences:
 * - Merchants see internal notes and metadata
 * - Merchants see all payment attempts (not just successful)
 * - Merchants see complete fee breakdowns
 * - Merchants see settlement details
 * - Merchants can access payment intents in any state
 *
 * Workflow:
 * 1. Merchant creates invoice for customer
 * 2. Customer initiates payment (creating payment intent)
 * 3. Merchant queries payment intent for status updates
 * 4. Monitors payment progress and confirmations
 * 5. Accesses complete payment details for records
 */
public class GetMerchantInvoicePaymentIntentRequest {
    /**
     * The unique identifier of the invoice to retrieve the payment intent for.
     * Format: inv_[random_id]
     *
     * This invoice must:
     * - Belong to the authenticated merchant's account
     * - Exist in the system
     * - Have an associated payment intent
     *
     * The system will return the complete payment intent with:
     * - All payment status updates
     * - Complete transaction history
     * - Internal notes and metadata
     * - Fee and settlement details
     * - Customer payment actions
     */
    private String invoiceId;

    /**
     * Creates a new GetMerchantInvoicePaymentIntentRequest instance.
     */
    public GetMerchantInvoicePaymentIntentRequest() {
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
