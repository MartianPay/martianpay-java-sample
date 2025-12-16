package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Represents a single data point in a time-series dataset with timestamp, value, and optional percentage.
 * Used for chart data points and statistical visualizations.
 */
public class ValueList {
    /**
     * Unix timestamp in seconds for this data point.
     */
    @SerializedName("time")
    private Long time;

    /**
     * The metric value as a string to preserve precision.
     */
    @SerializedName("value")
    private String value;

    /**
     * Optional percentage metric (e.g., percentage of total or growth rate).
     */
    @SerializedName("percent")
    private Long percent;

    public ValueList() {
    }

    /**
     * @return The timestamp
     */
    public Long getTime() {
        return time;
    }

    /**
     * @param time The timestamp
     */
    public void setTime(Long time) {
        this.time = time;
    }

    /**
     * @return The value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value The value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return The percentage
     */
    public Long getPercent() {
        return percent;
    }

    /**
     * @param percent The percentage
     */
    public void setPercent(Long percent) {
        this.percent = percent;
    }
}
