package com.martianpay.developer;

/**
 * GetMerchantSubscriptionRequest represents a request to retrieve subscription details from the merchant's perspective.
 *
 * This request allows merchants to fetch complete information about any subscription
 * created under their account, with full access to financial details, internal metadata,
 * and complete billing history.
 *
 * Merchant subscription information includes:
 * - Complete subscription status and lifecycle
 * - Detailed plan configuration and pricing
 * - Full billing history and upcoming invoices
 * - Customer payment method details
 * - Revenue metrics and MRR calculations
 * - Discount and coupon details
 * - Trial period configuration and status
 * - Cancellation and pause history
 * - Failed payment attempts and retry schedule
 * - Internal notes and custom metadata
 * - Settlement and payout information
 * - Proration calculations
 *
 * Use cases:
 * - Monitor active subscriptions and revenue
 * - Review customer subscription details for support
 * - Track subscription lifecycle and changes
 * - Generate subscription reports and analytics
 * - Manage failed payments and retries
 * - Calculate MRR (Monthly Recurring Revenue)
 * - Analyze churn and retention
 * - Reconcile subscription billing
 * - Audit subscription modifications
 * - Export data for accounting systems
 *
 * Access control:
 * - Merchants can retrieve any subscription from their account
 * - Requires merchant API authentication
 * - Full access to all subscription states and history
 * - Can view internal fields not shown to customers
 * - Access to complete financial details
 *
 * Subscription states accessible to merchants:
 * - active: Currently active and billing normally
 * - trialing: In trial period, not yet billing
 * - paused: Temporarily paused by customer or merchant
 * - canceled: Canceled but may still be active until period end
 * - past_due: Payment failed, awaiting retry or cancellation
 * - unpaid: All payment attempts failed, awaiting action
 * - incomplete: Initial setup not completed
 * - incomplete_expired: Setup expired without completion
 *
 * Merchant vs Customer access differences:
 * - Merchants see complete financial breakdown
 * - Merchants see all failed payment attempts
 * - Merchants see internal notes and tags
 * - Merchants see revenue metrics (MRR, etc.)
 * - Merchants see settlement details
 * - Merchants can access all historical states
 * - Merchants see upcoming billing projections
 *
 * Workflow:
 * 1. Customer subscribes to merchant's plan
 * 2. Merchant queries subscription for details
 * 3. Monitors subscription status and payments
 * 4. Handles failed payments and retries
 * 5. Tracks revenue and billing cycles
 * 6. Manages modifications and cancellations
 * 7. Accesses for reporting and analytics
 */
public class GetMerchantSubscriptionRequest {
    /**
     * The unique identifier of the subscription to retrieve.
     * Format: sub_[random_id]
     *
     * This subscription must:
     * - Belong to the authenticated merchant's account
     * - Exist in the system
     *
     * The system will return complete subscription details including:
     * - Current status and lifecycle state
     * - Complete plan and pricing configuration
     * - Full billing history
     * - Customer payment method details
     * - Internal metadata and notes
     * - Revenue metrics
     * - Upcoming billing information
     * - Modification history
     */
    private String subscriptionId;

    /**
     * Creates a new GetMerchantSubscriptionRequest instance.
     */
    public GetMerchantSubscriptionRequest() {
    }

    /**
     * Gets the subscription ID to retrieve.
     * @return The subscription ID
     */
    public String getSubscriptionId() {
        return subscriptionId;
    }

    /**
     * Sets the subscription ID to retrieve.
     * @param subscriptionId The subscription ID
     */
    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }
}
