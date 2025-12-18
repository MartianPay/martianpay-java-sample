package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * ProrationDetails contains detailed proration calculation breakdown for update/preview operations
 */
public class ProrationDetails {
    @SerializedName("credited_amount")
    private String creditedAmount;

    @SerializedName("charged_amount")
    private String chargedAmount;

    @SerializedName("net_amount")
    private String netAmount;

    @SerializedName("days_remaining")
    private Integer daysRemaining;

    @SerializedName("total_days")
    private Integer totalDays;

    @SerializedName("current_price")
    private String currentPrice;

    @SerializedName("target_price")
    private String targetPrice;

    public ProrationDetails() {
    }

    public String getCreditedAmount() {
        return creditedAmount;
    }

    public void setCreditedAmount(String creditedAmount) {
        this.creditedAmount = creditedAmount;
    }

    public String getChargedAmount() {
        return chargedAmount;
    }

    public void setChargedAmount(String chargedAmount) {
        this.chargedAmount = chargedAmount;
    }

    public String getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(String netAmount) {
        this.netAmount = netAmount;
    }

    public Integer getDaysRemaining() {
        return daysRemaining;
    }

    public void setDaysRemaining(Integer daysRemaining) {
        this.daysRemaining = daysRemaining;
    }

    public Integer getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(Integer totalDays) {
        this.totalDays = totalDays;
    }

    public String getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(String currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getTargetPrice() {
        return targetPrice;
    }

    public void setTargetPrice(String targetPrice) {
        this.targetPrice = targetPrice;
    }
}
