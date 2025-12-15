package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * BillingPolicyRequest represents billing policy configuration in a request
 */
public class BillingPolicyRequest {
    /** Interval is the billing interval ("day" | "week" | "month" | "year") */
    @SerializedName("interval")
    private String interval;

    /** IntervalCount is the cycle multiplier as string (e.g., "1"=monthly, "3"=quarterly) */
    @SerializedName("interval_count")
    private String intervalCount;

    /** MinCycles is the minimum cycles for PREPAID (as string) */
    @SerializedName("min_cycles")
    private String minCycles;

    // Getters and Setters
    public String getInterval() { return interval; }
    public void setInterval(String interval) { this.interval = interval; }

    public String getIntervalCount() { return intervalCount; }
    public void setIntervalCount(String intervalCount) { this.intervalCount = intervalCount; }

    public String getMinCycles() { return minCycles; }
    public void setMinCycles(String minCycles) { this.minCycles = minCycles; }
}
