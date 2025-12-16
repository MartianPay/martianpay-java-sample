package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

/**
 * CustomerResolveResponse represents the response when resolving customer information.
 *
 * This response contains comprehensive customer data retrieved by resolving a customer
 * identifier (email, phone, customer ID, etc.). It includes customer profile information,
 * authentication tokens, addresses, tax regions, and integration details with third-party
 * payment providers.
 *
 * Customer resolution is used to:
 * - Look up existing customer records by various identifiers
 * - Retrieve complete customer profile for payment processing
 * - Obtain authentication tokens for customer sessions
 * - Access customer addresses for shipping/billing
 * - Get tax region information for compliance
 * - Check provider-specific customer IDs (Stripe, PayerMax)
 *
 * The response includes multiple identifier types to support various payment flows
 * and integration scenarios. Provider-specific IDs enable seamless integration with
 * external payment gateways.
 *
 * Use cases:
 * - Customer lookup during checkout process
 * - Retrieving saved payment methods and addresses
 * - Validating customer identity before transactions
 * - Obtaining customer auth tokens for secure operations
 * - Accessing tax information for accurate billing
 * - Cross-referencing customers across payment providers
 */
public class CustomerResolveResponse {
    /**
     * The unique customer identifier in MartianPay system.
     * Primary key for customer records.
     */
    @SerializedName("customer_id")
    private String customerId;

    /**
     * Customer's email address.
     * Used for communication and as an alternative identifier.
     */
    @SerializedName("email")
    private String email;

    /**
     * Customer's phone number.
     * Used for verification and as an alternative identifier.
     */
    @SerializedName("phone")
    private String phone;

    /**
     * Universally unique identifier (UUID) for this customer.
     * Alternative unique identifier for cross-system references.
     */
    @SerializedName("uuid")
    private String uuid;

    /**
     * Customer ID in Stripe payment system.
     * Populated if customer exists in Stripe integration.
     */
    @SerializedName("stripe_customer_id")
    private String stripeCustomerId;

    /**
     * Customer ID in PayerMax payment system.
     * Populated if customer exists in PayerMax integration.
     */
    @SerializedName("payermax_customer_id")
    private String payermaxCustomerId;

    /**
     * Payment provider identifier.
     * Indicates which payment provider is associated with this customer.
     */
    @SerializedName("provider")
    private String provider;

    /**
     * Provider-specific metadata for payment channel configuration.
     * Contains custom fields required by specific payment providers.
     */
    @SerializedName("channel_metadata")
    private Map<String, Object> channelMetadata;

    /**
     * Identifier of the system or entity that issued this customer record.
     * Tracks the source of customer creation.
     */
    @SerializedName("issued_by")
    private String issuedBy;

    /**
     * Order ID associated with this customer resolution request.
     * Links the customer lookup to a specific order or transaction.
     */
    @SerializedName("order_id")
    private String orderId;

    /**
     * URL to redirect customer after completing operations.
     * Used in payment flows to return customer to merchant site.
     */
    @SerializedName("return_url")
    private String returnUrl;

    /**
     * Authentication token for secure customer operations.
     * Used to authorize customer-specific API calls and sessions.
     */
    @SerializedName("auth_token")
    private CustomerAuthToken authToken;

    /**
     * List of customer's saved addresses.
     * Includes shipping and billing addresses with full details.
     */
    @SerializedName("addresses")
    private List<CustomerAddress> addresses;

    /**
     * List of tax regions applicable to this customer.
     * Used for calculating taxes and ensuring tax compliance.
     */
    @SerializedName("tax_regions")
    private List<CustomerTaxRegion> taxRegions;

    /**
     * Default constructor for CustomerResolveResponse.
     */
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
