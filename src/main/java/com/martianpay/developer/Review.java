package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

public class Review {
    public static final String REVIEW_CLOSED_REASON_APPROVED = "approved";
    public static final String REVIEW_CLOSED_REASON_DISPUTED = "disputed";
    public static final String REVIEW_CLOSED_REASON_REDACTED = "redacted";
    public static final String REVIEW_CLOSED_REASON_REFUNDED = "refunded";
    public static final String REVIEW_CLOSED_REASON_REFUNDED_AS_FRAUD = "refunded_as_fraud";

    public static final String REVIEW_OPENED_REASON_MANUAL = "manual";
    public static final String REVIEW_OPENED_REASON_RULE = "rule";

    public static final String REVIEW_REASON_APPROVED = "approved";
    public static final String REVIEW_REASON_DISPUTED = "disputed";
    public static final String REVIEW_REASON_MANUAL = "manual";
    public static final String REVIEW_REASON_REFUNDED = "refunded";
    public static final String REVIEW_REASON_REFUNDED_AS_FRAUD = "refunded_as_fraud";
    public static final String REVIEW_REASON_REDACTED = "redacted";
    public static final String REVIEW_REASON_RULE = "rule";

    @SerializedName("id")
    private String id;

    @SerializedName("object")
    private String object;

    @SerializedName("charge")
    private String charge;

    @SerializedName("closed_reason")
    private String closedReason;

    @SerializedName("created")
    private Long created;

    @SerializedName("ip_address")
    private String ipAddress;

    @SerializedName("ip_address_location")
    private ReviewIPAddressLocation ipAddressLocation;

    @SerializedName("livemode")
    private Boolean livemode;

    @SerializedName("open")
    private Boolean open;

    @SerializedName("opened_reason")
    private String openedReason;

    @SerializedName("payment_intent")
    private String paymentIntent;

    @SerializedName("reason")
    private String reason;

    @SerializedName("session")
    private ReviewSession session;

    public Review() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public String getClosedReason() {
        return closedReason;
    }

    public void setClosedReason(String closedReason) {
        this.closedReason = closedReason;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public ReviewIPAddressLocation getIpAddressLocation() {
        return ipAddressLocation;
    }

    public void setIpAddressLocation(ReviewIPAddressLocation ipAddressLocation) {
        this.ipAddressLocation = ipAddressLocation;
    }

    public Boolean getLivemode() {
        return livemode;
    }

    public void setLivemode(Boolean livemode) {
        this.livemode = livemode;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public String getOpenedReason() {
        return openedReason;
    }

    public void setOpenedReason(String openedReason) {
        this.openedReason = openedReason;
    }

    public String getPaymentIntent() {
        return paymentIntent;
    }

    public void setPaymentIntent(String paymentIntent) {
        this.paymentIntent = paymentIntent;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ReviewSession getSession() {
        return session;
    }

    public void setSession(ReviewSession session) {
        this.session = session;
    }
}
