package com.martianpay.sdk;

import com.martianpay.developer.ListMerchantSubscriptionsRequest;
import com.martianpay.developer.ListSubscriptionsResponse;
import com.martianpay.developer.SubscriptionDetails;
import com.martianpay.developer.CancelMerchantSubscriptionRequest;
import com.martianpay.developer.PauseMerchantSubscriptionRequest;
import com.martianpay.developer.UpdateSubscriptionPlanRequest;

import java.io.IOException;

/**
 * SubscriptionService provides methods for managing subscriptions
 */
public class SubscriptionService extends MartianPayClient {

    public SubscriptionService(String apiKey) {
        super(apiKey);
    }

    public SubscriptionService(String apiKey, String baseUrl) {
        super(apiKey, baseUrl);
    }

    /**
     * Lists subscriptions
     *
     * @param params Subscription list request parameters
     * @return Subscription list response
     * @throws IOException if request fails
     */
    public ListSubscriptionsResponse listSubscriptions(ListMerchantSubscriptionsRequest params) throws IOException {
        return sendRequestWithQuery("GET", "/v1/subscriptions", params, ListSubscriptionsResponse.class);
    }

    /**
     * Gets subscription details
     *
     * @param subscriptionID Subscription ID
     * @return Subscription details
     * @throws IOException if request fails
     */
    public SubscriptionDetails getSubscription(String subscriptionID) throws IOException {
        String path = String.format("/v1/subscriptions/%s", subscriptionID);
        return sendRequest("GET", path, null, SubscriptionDetails.class);
    }

    /**
     * Cancels a subscription
     *
     * @param subscriptionID Subscription ID
     * @param params Cancellation parameters
     * @return Updated subscription details
     * @throws IOException if request fails
     */
    public SubscriptionDetails cancelSubscription(String subscriptionID, CancelMerchantSubscriptionRequest params) throws IOException {
        String path = String.format("/v1/subscriptions/%s/cancel", subscriptionID);
        return sendRequest("POST", path, params, SubscriptionDetails.class);
    }

    /**
     * Pauses a subscription
     *
     * @param subscriptionID Subscription ID
     * @param params Pause parameters
     * @return Updated subscription details
     * @throws IOException if request fails
     */
    public SubscriptionDetails pauseSubscription(String subscriptionID, PauseMerchantSubscriptionRequest params) throws IOException {
        String path = String.format("/v1/subscriptions/%s/pause", subscriptionID);
        return sendRequest("POST", path, params, SubscriptionDetails.class);
    }

    /**
     * Resumes a subscription
     *
     * @param subscriptionID Subscription ID
     * @return Updated subscription details
     * @throws IOException if request fails
     */
    public SubscriptionDetails resumeSubscription(String subscriptionID) throws IOException {
        String path = String.format("/v1/subscriptions/%s/resume", subscriptionID);
        return sendRequest("POST", path, null, SubscriptionDetails.class);
    }

    /**
     * Updates a subscription's plan (upgrade or downgrade)
     *
     * For upgrades (new price > current price):
     * - Applied immediately
     * - Customer charged prorated difference today
     * - Billing cycle can be reset with billing_cycle_anchor: "now"
     *
     * For downgrades (new price < current price):
     * - Scheduled as pending update
     * - Takes effect at end of current billing period
     * - Customer continues on current plan until effective_date
     *
     * @param subscriptionID Subscription ID
     * @param params Update parameters including new selling plan, proration behavior, etc.
     * @return Updated subscription details with proration info
     * @throws IOException if request fails
     */
    public SubscriptionDetails updateSubscription(String subscriptionID, UpdateSubscriptionPlanRequest params) throws IOException {
        String path = String.format("/v1/subscriptions/%s", subscriptionID);
        return sendRequest("POST", path, params, SubscriptionDetails.class);
    }

    /**
     * Previews a subscription plan change without applying it
     *
     * Use this to show customers what they'll be charged before confirming the change.
     * The preview does NOT modify the subscription, create invoices, or charge the customer.
     *
     * @param subscriptionID Subscription ID
     * @param params Preview parameters (same as updateSubscription)
     * @return Preview with proration calculation (applied=false)
     * @throws IOException if request fails
     */
    public SubscriptionDetails previewSubscriptionUpdate(String subscriptionID, UpdateSubscriptionPlanRequest params) throws IOException {
        String path = String.format("/v1/subscriptions/%s/preview", subscriptionID);
        return sendRequest("POST", path, params, SubscriptionDetails.class);
    }

    /**
     * Revokes a pending cancellation for a subscription.
     * This is used when a subscription was previously scheduled to cancel (cancel_at_period_end=true)
     * but the customer or merchant wants to continue the subscription.
     *
     * @param subscriptionID Subscription ID
     * @return Updated subscription details with cancellation revoked
     * @throws IOException if request fails
     */
    public SubscriptionDetails revokeCancelSubscription(String subscriptionID) throws IOException {
        String path = String.format("/v1/subscriptions/%s/revoke-cancel", subscriptionID);
        return sendRequest("POST", path, null, SubscriptionDetails.class);
    }
}
