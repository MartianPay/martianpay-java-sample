package com.martianpay.developer;

/**
 * GetMerchantInvoiceRequest represents a request to retrieve invoice details from the merchant's perspective.
 *
 * This request allows merchants to fetch complete information about any invoice they have
 * created, including all states (draft, open, paid, void), with full access to internal
 * details, metadata, and financial information.
 *
 * Merchant invoice information includes:
 * - Complete line items and pricing details
 * - All payment status history and transitions
 * - Customer information and billing details
 * - Internal notes and custom metadata
 * - Complete tax calculations and breakdowns
 * - Fee structures and merchant settlements
 * - Payment method details and preferences
 * - Associated subscriptions and recurring billing
 * - Refund and adjustment history
 * - Audit trail of all modifications
 *
 * Use cases:
 * - Review invoice details before finalizing
 * - Monitor payment status for customer invoices
 * - Access complete financial data for accounting
 * - Generate reports and statements
 * - Customer support and dispute resolution
 * - Reconcile payments and settlements
 * - Track invoice lifecycle and modifications
 * - Export data for external systems
 * - Audit and compliance reviews
 *
 * Access control:
 * - Merchants can retrieve any invoice from their account
 * - Requires merchant API authentication
 * - Full access to all invoice states including drafts
 * - Can view internal fields not shown to customers
 * - Access to complete audit and modification history
 *
 * Invoice states accessible to merchants:
 * - draft: Invoice being prepared, not yet sent to customer
 * - open: Invoice sent to customer, awaiting payment
 * - paid: Invoice has been fully paid
 * - void: Invoice has been voided and cannot be paid
 * - uncollectible: Marked as uncollectible after payment attempts
 *
 * Merchant vs Customer access differences:
 * - Merchants see draft invoices
 * - Merchants see internal notes and metadata
 * - Merchants see complete fee breakdowns
 * - Merchants see settlement amounts
 * - Merchants see all status history
 * - Merchants can access voided and uncollectible invoices
 *
 * Workflow:
 * 1. Merchant creates invoice
 * 2. Queries invoice to review details
 * 3. Modifies if needed (while in draft)
 * 4. Sends to customer
 * 5. Monitors payment status
 * 6. Accesses for reporting and reconciliation
 */
public class GetMerchantInvoiceRequest {
    /**
     * The unique identifier of the invoice to retrieve.
     * Format: inv_[random_id]
     *
     * This invoice must:
     * - Belong to the authenticated merchant's account
     * - Exist in the system
     *
     * The system will return complete invoice details including:
     * - All line items and charges
     * - Complete payment status history
     * - Internal notes and metadata
     * - Fee and settlement breakdowns
     * - Customer details
     * - Tax calculations
     * - Audit trail of modifications
     */
    private String invoiceId;

    /**
     * Creates a new GetMerchantInvoiceRequest instance.
     */
    public GetMerchantInvoiceRequest() {
    }

    /**
     * Gets the invoice ID to retrieve.
     * @return The invoice ID
     */
    public String getInvoiceId() {
        return invoiceId;
    }

    /**
     * Sets the invoice ID to retrieve.
     * @param invoiceId The invoice ID
     */
    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }
}
