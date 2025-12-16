package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * OrderCustomer represents the customer information associated with an order.
 *
 * This model contains essential customer details needed for order processing,
 * shipping, and communication purposes. It captures the identity and contact
 * information of the person or entity placing an order.
 *
 * Key use cases:
 * - Identifying the purchaser of an order
 * - Providing contact information for order updates and notifications
 * - Enabling customer service communications
 * - Supporting order history tracking per customer
 *
 * The customer data is typically populated from:
 * - User account information during checkout
 * - Guest checkout form submissions
 * - Payment provider customer data
 * - External system integrations
 */
public class OrderCustomer {
    /**
     * Unique identifier for the customer.
     * Format: Typically cus_[random_id] or merchant-specific customer ID
     */
    @SerializedName("id")
    private String id;

    /**
     * Full name of the customer.
     * This is the display name used for shipping labels and order communications.
     * Example: "John Smith", "Acme Corporation"
     */
    @SerializedName("name")
    private String name;

    /**
     * Email address of the customer.
     * Used for sending order confirmations, shipping updates, and receipts.
     * Must be a valid email format.
     */
    @SerializedName("email")
    private String email;

    /**
     * Phone number of the customer.
     * Used for delivery coordination and urgent order-related communications.
     * May include country code and formatted in various international formats.
     * Example: "+1-555-0123", "555-0123"
     */
    @SerializedName("phone")
    private String phone;

    /**
     * Default constructor for OrderCustomer.
     */
    public OrderCustomer() {
    }

    /**
     * Gets the unique identifier for the customer.
     * @return The customer ID
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the customer.
     * @param id The customer ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the full name of the customer.
     * @return The customer's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the full name of the customer.
     * @param name The customer's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the email address of the customer.
     * @return The customer's email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the customer.
     * @param email The customer's email address
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the phone number of the customer.
     * @return The customer's phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone number of the customer.
     * @param phone The customer's phone number
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
