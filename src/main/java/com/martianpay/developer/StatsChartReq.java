package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

public class StatsChartReq {
    @SerializedName("category")
    private String category;

    @SerializedName("title")
    private String title;

    @SerializedName("unit")
    private String unit;

    @SerializedName("current_start_time")
    private Long currentStartTime;

    @SerializedName("current_end_time")
    private Long currentEndTime;

    @SerializedName("previous_start_time")
    private Long previousStartTime;

    @SerializedName("previous_end_time")
    private Long previousEndTime;

    public StatsChartReq() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Long getCurrentStartTime() {
        return currentStartTime;
    }

    public void setCurrentStartTime(Long currentStartTime) {
        this.currentStartTime = currentStartTime;
    }

    public Long getCurrentEndTime() {
        return currentEndTime;
    }

    public void setCurrentEndTime(Long currentEndTime) {
        this.currentEndTime = currentEndTime;
    }

    public Long getPreviousStartTime() {
        return previousStartTime;
    }

    public void setPreviousStartTime(Long previousStartTime) {
        this.previousStartTime = previousStartTime;
    }

    public Long getPreviousEndTime() {
        return previousEndTime;
    }

    public void setPreviousEndTime(Long previousEndTime) {
        this.previousEndTime = previousEndTime;
    }
}
