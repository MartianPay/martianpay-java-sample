package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Billing policy configuration for subscription plans.
 * Defines billing frequency, interval, and minimum cycles for prepaid plans.
 */
public class BillingPolicyRequest {
    /**
     * Billing interval unit (day, week, month, year).
     */
    @SerializedName("interval")
    private String interval;

    /**
     * Multiplier for the billing interval.
     */
    @SerializedName("interval_count")
    private String intervalCount;

    /**
     * Minimum number of billing cycles for prepaid plans.
     */
    @SerializedName("min_cycles")
    private String minCycles;

    /**
     * Gets the billing interval unit.
     * @return The interval (day, week, month, year)
     */
    public String getInterval() { return interval; }

    /**
     * Sets the billing interval unit.
     * @param interval The interval (day, week, month, year)
     */
    public void setInterval(String interval) { this.interval = interval; }

    /**
     * Gets the billing interval multiplier.
     * @return The interval count as a string
     */
    public String getIntervalCount() { return intervalCount; }

    /**
     * Sets the billing interval multiplier.
     * @param intervalCount The interval count as a string
     */
    public void setIntervalCount(String intervalCount) { this.intervalCount = intervalCount; }

    /**
     * Gets the minimum billing cycles for prepaid plans.
     * @return The minimum cycles as a string, or null if not applicable
     */
    public String getMinCycles() { return minCycles; }

    /**
     * Sets the minimum billing cycles for prepaid plans.
     * @param minCycles The minimum cycles as a string
     */
    public void setMinCycles(String minCycles) { this.minCycles = minCycles; }
}
