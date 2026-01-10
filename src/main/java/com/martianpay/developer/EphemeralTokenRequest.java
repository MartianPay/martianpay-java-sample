package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

/**
 * EphemeralTokenRequest contains parameters for issuing ephemeral tokens.
 * Ephemeral tokens are short-lived tokens (typically 5-15 minutes) used for
 * customer authentication in social media integrations and third-party systems.
 */
public class EphemeralTokenRequest {

    // Identity provider type constants
    /** Identify customer by email address */
    public static final String IDP_KEY_EMAIL = "email";
    /** Identify customer by phone number */
    public static final String IDP_KEY_PHONE = "phone";
    /** Identify customer by UUID */
    public static final String IDP_KEY_UUID = "uuid";

    /**
     * IDPKey is the identity provider type - determines how to identify the customer.
     * Valid values: "email", "phone", "uuid"
     * Example: "email" means the customer is identified by their email address
     * Optional: If not provided, creates an anonymous ephemeral token (only order_id based)
     */
    @SerializedName("idp_key")
    private String idpKey;

    /**
     * IDPSubject is the unique identifier under the specified IDP.
     * When idp_key="email", this should be the email address (e.g., "user@example.com")
     * When idp_key="phone", this should be the phone number (e.g., "+1234567890")
     * When idp_key="uuid", this should be a UUID
     * Optional: If not provided along with idp_key, creates an anonymous ephemeral token
     */
    @SerializedName("idp_subject")
    private String idpSubject;

    /**
     * Provider identifies the channel or platform initiating the request.
     * Examples: "instagram", "whatsapp", "wechat", "telegram"
     * Used for tracking and channel-specific business logic.
     * Optional: If not provided, creates an anonymous ephemeral token
     */
    @SerializedName("provider")
    private String provider;

    /**
     * AllowCreate determines whether to create a new customer if not found (default: true).
     * Set to false to return an error if customer doesn't exist.
     */
    @SerializedName("allow_create")
    private Boolean allowCreate;

    /**
     * ChannelMetadata stores arbitrary channel-specific data.
     * Examples: {"instagram_user_id": "12345", "dm_thread_id": "67890"}
     */
    @SerializedName("channel_metadata")
    private Map<String, Object> channelMetadata;

    /**
     * IssuedBy identifies the system or service issuing this token request.
     * Used for audit logging and tracking token origin.
     */
    @SerializedName("issued_by")
    private String issuedBy;

    /**
     * ReturnURL is the URL to redirect the customer after authentication/payment.
     * Used in social media integrations where the flow needs to return to a specific page.
     */
    @SerializedName("return_url")
    private String returnUrl;

    /**
     * OrderID is an optional order identifier to associate with this ephemeral token.
     * When provided, this order_id will be returned when the token is resolved.
     * Useful for tracking which order the customer authentication is for.
     */
    @SerializedName("order_id")
    private String orderId;

    // Getters and Setters

    public String getIdpKey() {
        return idpKey;
    }

    public void setIdpKey(String idpKey) {
        this.idpKey = idpKey;
    }

    public String getIdpSubject() {
        return idpSubject;
    }

    public void setIdpSubject(String idpSubject) {
        this.idpSubject = idpSubject;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public Boolean getAllowCreate() {
        return allowCreate;
    }

    public void setAllowCreate(Boolean allowCreate) {
        this.allowCreate = allowCreate;
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

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
