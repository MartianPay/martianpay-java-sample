package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Request for retrieving time-series chart data with period-over-period comparison.
 * Supports category-based metrics and configurable time granularity.
 */
public class StatsChartReq {
    /**
     * Category identifier for the metric (e.g., "revenue", "transactions", "orders").
     */
    @SerializedName("category")
    private String category;

    /**
     * Display title for the chart (e.g., "Total Revenue", "Transaction Count").
     */
    @SerializedName("title")
    private String title;

    /**
     * Time unit for data aggregation (e.g., "hour", "day", "week", "month", "year").
     */
    @SerializedName("unit")
    private String unit;

    /**
     * Start timestamp for the current period (Unix timestamp in seconds).
     */
    @SerializedName("current_start_time")
    private Long currentStartTime;

    /**
     * End timestamp for the current period (Unix timestamp in seconds).
     */
    @SerializedName("current_end_time")
    private Long currentEndTime;

    /**
     * Start timestamp for the previous period (Unix timestamp in seconds).
     */
    @SerializedName("previous_start_time")
    private Long previousStartTime;

    /**
     * End timestamp for the previous period (Unix timestamp in seconds).
     */
    @SerializedName("previous_end_time")
    private Long previousEndTime;

    public StatsChartReq() {
    }

    /**
     * @return The category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category The category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return The unit
     */
    public String getUnit() {
        return unit;
    }

    /**
     * @param unit The unit
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * @return The current start time
     */
    public Long getCurrentStartTime() {
        return currentStartTime;
    }

    /**
     * @param currentStartTime The current start time
     */
    public void setCurrentStartTime(Long currentStartTime) {
        this.currentStartTime = currentStartTime;
    }

    /**
     * @return The current end time
     */
    public Long getCurrentEndTime() {
        return currentEndTime;
    }

    /**
     * @param currentEndTime The current end time
     */
    public void setCurrentEndTime(Long currentEndTime) {
        this.currentEndTime = currentEndTime;
    }

    /**
     * @return The previous start time
     */
    public Long getPreviousStartTime() {
        return previousStartTime;
    }

    /**
     * @param previousStartTime The previous start time
     */
    public void setPreviousStartTime(Long previousStartTime) {
        this.previousStartTime = previousStartTime;
    }

    /**
     * @return The previous end time
     */
    public Long getPreviousEndTime() {
        return previousEndTime;
    }

    /**
     * @param previousEndTime The previous end time
     */
    public void setPreviousEndTime(Long previousEndTime) {
        this.previousEndTime = previousEndTime;
    }
}
