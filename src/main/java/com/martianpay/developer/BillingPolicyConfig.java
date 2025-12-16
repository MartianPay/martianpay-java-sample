package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Billing cycle configuration for subscription plans.
 * Defines billing frequency, interval, and minimum cycles for prepaid plans.
 */
public class BillingPolicyConfig {
    /**
     * Billing interval unit (day, week, month, year).
     */
    @SerializedName("interval")
    private String interval;

    /**
     * Number of intervals between billings.
     */
    @SerializedName("interval_count")
    private String intervalCount;

    /**
     * Minimum number of billing cycles for prepaid plans.
     */
    @SerializedName("min_cycles")
    private String minCycles;

    /**
     * Constructs an empty BillingPolicyConfig.
     */
    public BillingPolicyConfig() {
    }

    /**
     * Gets the billing interval type.
     * @return The interval (day, week, month, or year)
     */
    public String getInterval() {
        return interval;
    }

    /**
     * Sets the billing interval type.
     * @param interval The interval (day, week, month, or year)
     */
    public void setInterval(String interval) {
        this.interval = interval;
    }

    /**
     * Gets the interval count as a string.
     * @return The number of intervals between billings
     */
    public String getIntervalCount() {
        return intervalCount;
    }

    /**
     * Sets the interval count.
     * @param intervalCount The number of intervals between billings (as string)
     */
    public void setIntervalCount(String intervalCount) {
        this.intervalCount = intervalCount;
    }

    /**
     * Gets the minimum cycles for prepaid plans.
     * @return The minimum billing cycles required for prepaid subscriptions
     */
    public String getMinCycles() {
        return minCycles;
    }

    /**
     * Sets the minimum cycles for prepaid plans.
     * @param minCycles The minimum billing cycles (as string)
     */
    public void setMinCycles(String minCycles) {
        this.minCycles = minCycles;
    }
}
