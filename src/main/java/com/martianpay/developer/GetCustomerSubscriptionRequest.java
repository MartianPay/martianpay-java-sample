package com.martianpay.developer;

/**
 * GetCustomerSubscriptionRequest represents a request to retrieve subscription details from the customer's perspective.
 *
 * This request allows customers to fetch complete information about their subscription,
 * including plan details, billing cycle, payment status, and subscription history.
 *
 * Subscription information typically includes:
 * - Subscription status (active, paused, canceled, past_due)
 * - Plan details (name, price, billing interval)
 * - Current billing period and next renewal date
 * - Payment method information
 * - Pricing and discounts
 * - Trial period information (if applicable)
 * - Subscription start and end dates
 * - Billing history and upcoming invoices
 *
 * Use cases:
 * - Customer views current subscription details
 * - Check next billing date and amount
 * - Review subscription plan and features
 * - Verify subscription status before renewal
 * - Access billing history
 * - Prepare to modify or cancel subscription
 * - View applied coupons or discounts
 * - Check trial period status
 *
 * Access control:
 * - Customers can only retrieve their own subscriptions
 * - Requires customer authentication
 * - Subscription must belong to the requesting customer
 * - Cannot access other customers' subscriptions
 *
 * Subscription states:
 * - active: Subscription is currently active and billing
 * - trialing: In trial period, not yet billing
 * - paused: Temporarily paused, will resume later
 * - canceled: Canceled but may still be active until period end
 * - past_due: Payment failed, awaiting retry
 * - unpaid: Payment attempts exhausted
 *
 * Workflow:
 * 1. Customer receives subscription ID (from confirmation, dashboard, etc.)
 * 2. Requests subscription details using this API
 * 3. Reviews subscription information
 * 4. Can view upcoming charges
 * 5. May proceed to modify or cancel subscription
 */
public class GetCustomerSubscriptionRequest {
    /**
     * The unique identifier of the subscription to retrieve.
     * Format: sub_[random_id]
     *
     * This subscription must:
     * - Belong to the authenticated customer
     * - Exist in the system
     * - Be accessible to the customer
     *
     * The system will return complete subscription details including:
     * - Current subscription status
     * - Plan details and pricing
     * - Billing cycle information
     * - Payment method details
     * - Trial information (if applicable)
     * - Next billing date and amount
     */
    private String subscriptionId;

    /**
     * Creates a new GetCustomerSubscriptionRequest instance.
     */
    public GetCustomerSubscriptionRequest() {
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
