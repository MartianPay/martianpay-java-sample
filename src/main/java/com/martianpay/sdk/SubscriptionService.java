package com.martianpay.sdk;

import com.martianpay.developer.ListMerchantSubscriptionsRequest;
import com.martianpay.developer.ListSubscriptionsResponse;
import com.martianpay.developer.SubscriptionDetails;
import com.martianpay.developer.CancelMerchantSubscriptionRequest;
import com.martianpay.developer.PauseMerchantSubscriptionRequest;

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
}
