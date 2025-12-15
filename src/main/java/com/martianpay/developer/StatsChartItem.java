package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class StatsChartItem {
    @SerializedName("category")
    private String category;

    @SerializedName("title")
    private String title;

    @SerializedName("unit")
    private String unit;

    @SerializedName("value_unit")
    private String valueUnit;

    @SerializedName("total_current_value")
    private String totalCurrentValue;

    @SerializedName("total_previous_value")
    private String totalPreviousValue;

    @SerializedName("total_percent")
    private Long totalPercent;

    @SerializedName("current_value")
    private List<ValueList> currentValue;

    @SerializedName("previous_value")
    private List<ValueList> previousValue;

    public StatsChartItem() {
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

    public String getValueUnit() {
        return valueUnit;
    }

    public void setValueUnit(String valueUnit) {
        this.valueUnit = valueUnit;
    }

    public String getTotalCurrentValue() {
        return totalCurrentValue;
    }

    public void setTotalCurrentValue(String totalCurrentValue) {
        this.totalCurrentValue = totalCurrentValue;
    }

    public String getTotalPreviousValue() {
        return totalPreviousValue;
    }

    public void setTotalPreviousValue(String totalPreviousValue) {
        this.totalPreviousValue = totalPreviousValue;
    }

    public Long getTotalPercent() {
        return totalPercent;
    }

    public void setTotalPercent(Long totalPercent) {
        this.totalPercent = totalPercent;
    }

    public List<ValueList> getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(List<ValueList> currentValue) {
        this.currentValue = currentValue;
    }

    public List<ValueList> getPreviousValue() {
        return previousValue;
    }

    public void setPreviousValue(List<ValueList> previousValue) {
        this.previousValue = previousValue;
    }
}
