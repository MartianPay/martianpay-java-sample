package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

public class ReviewSession {
    @SerializedName("browser")
    private String browser;

    @SerializedName("device")
    private String device;

    @SerializedName("platform")
    private String platform;

    @SerializedName("version")
    private String version;

    public ReviewSession() {
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
