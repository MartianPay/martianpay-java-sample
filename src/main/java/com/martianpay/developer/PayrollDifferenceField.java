package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

public class PayrollDifferenceField {
    public static final String STATUS_ADDED = "added";
    public static final String STATUS_MODIFIED = "modified";
    public static final String STATUS_UNCHANGED = "unchanged";

    @SerializedName("previous")
    private String previous;

    @SerializedName("current")
    private String current;

    @SerializedName("status")
    private String status;

    public PayrollDifferenceField() {
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
