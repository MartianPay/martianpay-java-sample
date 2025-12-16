package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.security.SecureRandom;
import java.util.List;

/**
 * Merchant represents a merchant account in the MartianPay system.
 *
 * A merchant account is the top-level entity for businesses using MartianPay to accept payments.
 * Each merchant has a unique identifier, configuration settings, team members, and associated
 * resources such as customers, products, subscriptions, and transactions.
 *
 * Merchant account structure:
 * - Unique merchant ID with "accu_" prefix
 * - Business information (name, country, timezone)
 * - Owner and team member relationships
 * - Role-based access control for team collaboration
 * - API keys for integration (public and secret keys)
 * - Configuration settings for payment processing
 *
 * Account types and relationships:
 * - One merchant can have multiple members (team collaboration)
 * - Each member has specific roles defining their permissions
 * - One designated owner with full administrative access
 * - Merchant can manage multiple customers and their subscriptions
 * - Merchant can create products and pricing plans
 *
 * Use cases:
 * - Creating new merchant accounts for businesses
 * - Managing merchant profile and settings
 * - Team member access and authentication
 * - Displaying merchant information in dashboards
 * - Multi-merchant platform support (for platforms managing multiple businesses)
 * - Timezone-specific reporting and scheduling
 * - Country-specific compliance and regulations
 *
 * Key features:
 * - Secure ID generation with cryptographic randomness
 * - Multi-timezone support for global businesses
 * - Role-based team access control
 * - User ID (uid) linking to authentication system
 * - Creation timestamp for audit trails
 */
public class Merchant {
    public static final int MERCHANT_ID_LENGTH = 24;
    public static final String MERCHANT_ID_PREFIX = "accu_";
    public static final String MERCHANT_OBJECT = "merchant";

    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final SecureRandom RANDOM = new SecureRandom();

    /**
     * Unique identifier for the merchant account.
     * Format: accu_[24 random alphanumeric characters]
     * This ID is used throughout the system to reference this merchant.
     */
    @SerializedName("id")
    private String id;

    /**
     * Type identifier, always "merchant".
     * Used for API response typing and validation.
     */
    @SerializedName("object")
    private String object;

    /**
     * Unix timestamp (in seconds) when the merchant account was created.
     * Used for audit trails and account age calculations.
     */
    @SerializedName("created_at")
    private Long createdAt;

    /**
     * Display name of the merchant business.
     * This name appears in customer-facing interfaces, emails, and invoices.
     * Example: "Acme Corporation"
     */
    @SerializedName("name")
    private String name;

    /**
     * User ID of the merchant in the authentication system.
     * Links the merchant account to the authentication provider (e.g., Firebase, Auth0).
     * Used for login, session management, and identity verification.
     */
    @SerializedName("uid")
    private String uid;

    /**
     * Primary email address for the merchant account.
     * Used for important notifications, billing communications, and account recovery.
     * Typically the email of the account owner.
     */
    @SerializedName("email")
    private String email;

    /**
     * Country code where the merchant business is located.
     * ISO 3166-1 alpha-2 country code (e.g., "US", "GB", "CA").
     * Used for compliance, tax calculations, and regional settings.
     */
    @SerializedName("country")
    private String country;

    /**
     * Timezone identifier for the merchant's location.
     * IANA timezone format (e.g., "America/New_York", "Europe/London", "Asia/Tokyo").
     * Used for displaying times in the merchant's local timezone and scheduling operations.
     */
    @SerializedName("timezone")
    private String timezone;

    /**
     * Indicates whether the current user is the owner of this merchant account.
     * True if the current user is the account owner, false otherwise.
     * Owners have full administrative privileges including account deletion.
     */
    @SerializedName("owner")
    private Boolean owner;

    /**
     * List of roles assigned to the current user for this merchant account.
     * Defines what actions the user can perform within this merchant account.
     * Roles include: owner, admin, developer, finance, support, and custom roles.
     */
    @SerializedName("roles")
    private List<Role> roles;

    public Merchant() {
    }

    /**
     * Generates a new unique merchant ID.
     * Uses secure random generation to ensure uniqueness and prevent guessing.
     * Format: accu_[24 random alphanumeric characters]
     * @return A newly generated merchant ID
     */
    public static String generateMerchantId() {
        return MERCHANT_ID_PREFIX + generateRandomString(MERCHANT_ID_LENGTH);
    }

    /**
     * Generates a random alphanumeric string of the specified length.
     * Uses SecureRandom for cryptographically strong random generation.
     * @param length The length of the random string to generate
     * @return A random alphanumeric string
     */
    private static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }

    /**
     * Gets the unique identifier for the merchant account.
     * @return The merchant ID
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the merchant account.
     * @param id The merchant ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the type identifier, always "merchant".
     * @return The object type
     */
    public String getObject() {
        return object;
    }

    /**
     * Sets the type identifier.
     * @param object The object type
     */
    public void setObject(String object) {
        this.object = object;
    }

    /**
     * Gets the Unix timestamp when the merchant account was created.
     * @return The creation timestamp in seconds
     */
    public Long getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the Unix timestamp when the merchant account was created.
     * @param createdAt The creation timestamp in seconds
     */
    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets the display name of the merchant business.
     * @return The merchant name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the display name of the merchant business.
     * @param name The merchant name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the user ID in the authentication system.
     * @return The user ID
     */
    public String getUid() {
        return uid;
    }

    /**
     * Sets the user ID in the authentication system.
     * @param uid The user ID
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * Gets the primary email address for the merchant account.
     * @return The email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the primary email address for the merchant account.
     * @param email The email address
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the country code where the merchant is located.
     * @return The ISO 3166-1 alpha-2 country code
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the country code where the merchant is located.
     * @param country The ISO 3166-1 alpha-2 country code
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets the timezone identifier for the merchant's location.
     * @return The IANA timezone identifier
     */
    public String getTimezone() {
        return timezone;
    }

    /**
     * Sets the timezone identifier for the merchant's location.
     * @param timezone The IANA timezone identifier
     */
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    /**
     * Gets whether the current user is the owner of this merchant account.
     * @return True if owner, false otherwise
     */
    public Boolean getOwner() {
        return owner;
    }

    /**
     * Sets whether the current user is the owner of this merchant account.
     * @param owner True if owner, false otherwise
     */
    public void setOwner(Boolean owner) {
        this.owner = owner;
    }

    /**
     * Gets the list of roles assigned to the current user.
     * @return The list of roles
     */
    public List<Role> getRoles() {
        return roles;
    }

    /**
     * Sets the list of roles assigned to the current user.
     * @param roles The list of roles
     */
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
