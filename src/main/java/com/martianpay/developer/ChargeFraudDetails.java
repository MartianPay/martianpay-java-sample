package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

public class ChargeFraudDetails {
    @SerializedName("martian_report")
    private String martianReport;

    @SerializedName("user_report")
    private String userReport;

    public ChargeFraudDetails() {
    }

    public String getMartianReport() {
        return martianReport;
    }

    public void setMartianReport(String martianReport) {
        this.martianReport = martianReport;
    }

    public String getUserReport() {
        return userReport;
    }

    public void setUserReport(String userReport) {
        this.userReport = userReport;
    }
}
