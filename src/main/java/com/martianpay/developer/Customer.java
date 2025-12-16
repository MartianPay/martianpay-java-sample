package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.security.SecureRandom;
import java.util.Map;

/**
 * Customer represents a customer in the system
 */
public class Customer {
    public static final String CUSTOMER_OBJECT = "customer";
    public static final int CUSTOMER_ID_LENGTH = 24;
    public static final String CUSTOMER_ID_PREFIX = "cus_";

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom RANDOM = new SecureRandom();

    /**
     * ID is the unique customer identifier (e.g., "cus_abc123")
     */
    @SerializedName("id")
    private String id;

    /**
     * Object is always "customer" for this resource type
     */
    @SerializedName("object")
    private String object;

    /**
     * TotalExpense is the total amount this customer has spent (in smallest currency unit, e.g., cents)
     */
    @SerializedName("total_expense")
    private Long totalExpense;

    /**
     * TotalPayment is the total amount of successful payments (in smallest currency unit)
     */
    @SerializedName("total_payment")
    private Long totalPayment;

    /**
     * TotalRefund is the total amount refunded to this customer (in smallest currency unit)
     */
    @SerializedName("total_refund")
    private Long totalRefund;

    /** Currency is the three-letter ISO currency code. Currently only USD is supported. */
    @SerializedName("currency")
    private String currency;

    /**
     * Created is the Unix timestamp when this customer was created
     */
    @SerializedName("created")
    private Long created;

    /**
     * Name is the customer's full name
     */
    @SerializedName("name")
    private String name;

    /**
     * Email is the customer's email address (must be unique per merchant)
     */
    @SerializedName("email")
    private String email;

    /**
     * Description is an optional text description for internal reference
     */
    @SerializedName("description")
    private String description;

    /**
     * Metadata is a set of key-value pairs for storing additional information
     */
    @SerializedName("metadata")
    private Map<String, String> metadata;

    /**
     * Phone is the customer's phone number in E.164 format (e.g., +1234567890)
     */
    @SerializedName("phone")
    private String phone;

    public Customer() {
    }

    public String generateCustomerId() {
        return CUSTOMER_ID_PREFIX + generateRandomString(CUSTOMER_ID_LENGTH);
    }

    private static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }

    // Getters and Setters
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

    public Long getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(Long totalExpense) {
        this.totalExpense = totalExpense;
    }

    public Long getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(Long totalPayment) {
        this.totalPayment = totalPayment;
    }

    public Long getTotalRefund() {
        return totalRefund;
    }

    public void setTotalRefund(Long totalRefund) {
        this.totalRefund = totalRefund;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
