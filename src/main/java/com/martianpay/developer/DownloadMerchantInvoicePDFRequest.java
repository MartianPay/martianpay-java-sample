package com.martianpay.developer;

/**
 * DownloadMerchantInvoicePDFRequest represents a request to download an invoice PDF from the merchant's perspective.
 *
 * This request is used by merchants to download PDF versions of invoices they have issued
 * to their customers. Merchants have full access to all invoices created under their account,
 * regardless of the invoice status.
 *
 * Merchant access control:
 * - Merchants can download any invoice they have created
 * - Requires merchant authentication with appropriate API keys
 * - Access includes invoices in all states (draft, open, paid, void, etc.)
 * - Can download invoices for any customer under the merchant account
 *
 * PDF content includes:
 * - Invoice number and date
 * - Complete line items with descriptions and amounts
 * - Payment status and due date
 * - Merchant branding and business information
 * - Customer billing and shipping information
 * - Detailed tax calculations and breakdowns
 * - Payment instructions and methods
 * - Internal notes and metadata (if configured)
 * - Transaction history and payment records
 *
 * Use cases:
 * - Merchant downloads invoice for record keeping
 * - Export invoices for accounting software integration
 * - Print invoices for mailing to customers
 * - Archive invoices for tax compliance
 * - Generate reports from invoice data
 * - Share invoices with accounting team
 * - Audit and reconciliation purposes
 *
 * Merchant vs Customer PDF differences:
 * - Merchant PDFs may include internal notes and metadata
 * - Merchant PDFs show complete payment history
 * - Merchant PDFs include all financial details
 * - Customer PDFs may have simplified information
 *
 * Security considerations:
 * - Requires valid merchant API authentication
 * - Invoice ID must belong to the merchant's account
 * - Access logs maintained for audit trail
 * - PDF generation uses merchant's branding settings
 * - Sensitive customer data handled according to privacy policies
 */
public class DownloadMerchantInvoicePDFRequest {
    /**
     * The unique identifier of the invoice to download.
     * Format: inv_[random_id]
     * This invoice must belong to the authenticated merchant's account.
     * The merchant has full access to download invoices in any state.
     */
    private String invoiceId;

    /**
     * Creates a new DownloadMerchantInvoicePDFRequest instance.
     */
    public DownloadMerchantInvoicePDFRequest() {
    }

    /**
     * Gets the unique identifier of the invoice to download.
     * @return The invoice ID
     */
    public String getInvoiceId() {
        return invoiceId;
    }

    /**
     * Sets the unique identifier of the invoice to download.
     * @param invoiceId The invoice ID
     */
    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }
}
