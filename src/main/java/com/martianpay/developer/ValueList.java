package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

public class ValueList {
    @SerializedName("time")
    private Long time;

    @SerializedName("value")
    private String value;

    @SerializedName("percent")
    private Long percent;

    public ValueList() {
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getPercent() {
        return percent;
    }

    public void setPercent(Long percent) {
        this.percent = percent;
    }
}
