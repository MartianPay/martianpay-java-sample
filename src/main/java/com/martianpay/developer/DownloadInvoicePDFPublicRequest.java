package com.martianpay.developer;

/**
 * DownloadInvoicePDFPublicRequest represents a request to download an invoice PDF using a public link.
 *
 * This request enables invoice PDF downloads without requiring authentication, using a
 * publicly accessible link. This is useful for sharing invoices with customers who may
 * not have an account or for embedding invoices in emails.
 *
 * Public access characteristics:
 * - No authentication required to download
 * - Uses a unique, secure invoice identifier
 * - Link can be shared via email or messaging
 * - Access is typically time-limited or one-time use
 * - Cannot modify or delete the invoice
 *
 * PDF content includes:
 * - Invoice number and date
 * - Line items with descriptions and amounts
 * - Payment status and due date
 * - Merchant branding and information
 * - Customer information
 * - Tax calculations and totals
 * - Payment instructions with clickable links
 *
 * Use cases:
 * - Merchant sends invoice PDF link to customer via email
 * - Customer downloads invoice without logging in
 * - Share invoice with third parties (accountants, managers)
 * - Embed invoice links in customer portal pages
 * - Mobile-friendly invoice access
 *
 * Security considerations:
 * - Invoice ID should be cryptographically secure and unpredictable
 * - Public links should have expiration time
 * - Rate limiting prevents abuse
 * - No sensitive authentication data in response
 * - PDF generation is server-side to prevent tampering
 * - Consider adding download count limits
 *
 * Best practices:
 * - Generate unique public URLs per invoice
 * - Use HTTPS for all PDF downloads
 * - Set appropriate Content-Disposition headers
 * - Log access attempts for audit trail
 * - Consider adding watermarks to public PDFs
 */
public class DownloadInvoicePDFPublicRequest {
    /**
     * The unique identifier of the invoice to download via public link.
     * Format: inv_[random_id]
     * This identifier must be valid and allow public access.
     * No authentication is required, but the link may have usage restrictions.
     */
    private String invoiceId;

    /**
     * Creates a new DownloadInvoicePDFPublicRequest instance.
     */
    public DownloadInvoicePDFPublicRequest() {
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
