package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

public class CustomerResolveResponse {
    @SerializedName("customer_id")
    private String customerId;

    @SerializedName("email")
    private String email;

    @SerializedName("phone")
    private String phone;

    @SerializedName("uuid")
    private String uuid;

    @SerializedName("stripe_customer_id")
    private String stripeCustomerId;

    @SerializedName("payermax_customer_id")
    private String payermaxCustomerId;

    @SerializedName("provider")
    private String provider;

    @SerializedName("channel_metadata")
    private Map<String, Object> channelMetadata;

    @SerializedName("issued_by")
    private String issuedBy;

    @SerializedName("order_id")
    private String orderId;

    @SerializedName("return_url")
    private String returnUrl;

    @SerializedName("auth_token")
    private CustomerAuthToken authToken;

    @SerializedName("addresses")
    private List<CustomerAddress> addresses;

    @SerializedName("tax_regions")
    private List<CustomerTaxRegion> taxRegions;

    public CustomerResolveResponse() {
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getStripeCustomerId() {
        return stripeCustomerId;
    }

    public void setStripeCustomerId(String stripeCustomerId) {
        this.stripeCustomerId = stripeCustomerId;
    }

    public String getPayermaxCustomerId() {
        return payermaxCustomerId;
    }

    public void setPayermaxCustomerId(String payermaxCustomerId) {
        this.payermaxCustomerId = payermaxCustomerId;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public Map<String, Object> getChannelMetadata() {
        return channelMetadata;
    }

    public void setChannelMetadata(Map<String, Object> channelMetadata) {
        this.channelMetadata = channelMetadata;
    }

    public String getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public CustomerAuthToken getAuthToken() {
        return authToken;
    }

    public void setAuthToken(CustomerAuthToken authToken) {
        this.authToken = authToken;
    }

    public List<CustomerAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<CustomerAddress> addresses) {
        this.addresses = addresses;
    }

    public List<CustomerTaxRegion> getTaxRegions() {
        return taxRegions;
    }

    public void setTaxRegions(List<CustomerTaxRegion> taxRegions) {
        this.taxRegions = taxRegions;
    }
}
