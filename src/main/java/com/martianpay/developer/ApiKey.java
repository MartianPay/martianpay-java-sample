package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.security.SecureRandom;

/**
 * ApiKey represents an API key used for authenticating requests to the MartianPay API.
 *
 * API keys are credentials that merchants use to access the MartianPay platform programmatically.
 * They provide secure, token-based authentication for server-to-server communication.
 *
 * Key types:
 * - Secret keys (sk_live_*, sk_test_*): Full API access for server-side use only
 * - Publishable keys (pk_live_*, pk_test_*): Limited access for client-side use
 * - Restricted keys: Custom permissions for specific operations
 *
 * Security best practices:
 * - Never expose secret keys in client-side code or version control
 * - Rotate keys periodically (e.g., every 90 days)
 * - Use restricted keys with minimum required permissions
 * - Monitor last_accessed_at to detect unauthorized usage
 * - Revoke keys immediately if compromised
 * - Set expiration dates for temporary integrations
 *
 * Key lifecycle:
 * 1. Created - Key is generated and active
 * 2. Active - Key can be used for API requests
 * 3. Expired - Key has passed its expiration date
 * 4. Revoked - Key has been manually disabled
 * 5. Deleted - Key is permanently removed (cannot be recovered)
 *
 * Use cases:
 * - Server-side payment processing
 * - Automated payout operations
 * - Webhook signature verification
 * - Integration testing (test keys)
 * - Third-party platform integrations
 */
public class ApiKey {
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final SecureRandom RANDOM = new SecureRandom();

    /**
     * Unique identifier for this API key.
     * Format: key_[random_id]
     */
    @SerializedName("id")
    private String id;

    /**
     * Object type identifier, always "api_key".
     */
    @SerializedName("object")
    private String object;

    /**
     * The actual API key string used for authentication.
     * Format depends on key type:
     * - Secret key: sk_live_[random] or sk_test_[random]
     * - Publishable key: pk_live_[random] or pk_test_[random]
     * This value is only shown once at creation time for security.
     */
    @SerializedName("key")
    private String key;

    /**
     * Type of API key indicating its permissions and usage.
     * Possible values:
     * - "secret" - Full API access for server-side operations
     * - "publishable" - Limited access for client-side operations
     * - "restricted" - Custom permissions for specific operations
     */
    @SerializedName("key_type")
    private String keyType;

    /**
     * Human-readable name for this API key.
     * Used to identify the key's purpose (e.g., "Production Server", "Mobile App", "Test Integration").
     * Helps with key management when multiple keys exist.
     */
    @SerializedName("name")
    private String name;

    /**
     * Optional description providing additional context about the key's usage.
     * Can include information about:
     * - Which application or service uses this key
     * - Team or developer responsible for the key
     * - Intended use case or environment
     */
    @SerializedName("description")
    private String description;

    /**
     * Unix timestamp (in seconds) when this API key was created.
     */
    @SerializedName("created")
    private Long created;

    /**
     * Unix timestamp (in seconds) when this key was last used for an API request.
     * Useful for:
     * - Identifying inactive keys that can be revoked
     * - Detecting unauthorized access
     * - Auditing API key usage patterns
     * Null if the key has never been used.
     */
    @SerializedName("last_accessed_at")
    private Long lastAccessedAt;

    /**
     * Current status of the API key.
     * Possible values:
     * - "active" - Key can be used for API requests
     * - "expired" - Key has passed its expiration date
     * - "revoked" - Key has been manually disabled
     */
    @SerializedName("status")
    private String status;

    /**
     * Unix timestamp (in seconds) when this key will expire and become unusable.
     * Null indicates no expiration date (key remains valid until revoked).
     * Setting an expiration date is recommended for:
     * - Temporary integrations
     * - Testing environments
     * - Contractor/partner access
     * - Compliance requirements
     */
    @SerializedName("expired_at")
    private Long expiredAt;

    /**
     * Constructs a new empty ApiKey object.
     */
    public ApiKey() {
    }

    /**
     * Generates a new unique API key ID.
     * @return A new API key ID with the format: key_prefix + random_string
     */
    public static String generateApiKeyId() {
        return DeveloperConstants.API_KEY_ID_PREFIX + generateRandomString(DeveloperConstants.API_KEY_ID_LENGTH);
    }

    /**
     * Generates a cryptographically secure random string.
     * @param length The length of the random string to generate
     * @return A random string of the specified length
     */
    private static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }

    /**
     * Gets the unique identifier for this API key.
     * @return The API key ID
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the unique identifier for this API key.
     * @param id The API key ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the object type identifier.
     * @return Always "api_key"
     */
    public String getObject() {
        return object;
    }

    /**
     * Sets the object type identifier.
     * @param object The object type
     */
    public void setObject(String object) {
        this.object = object;
    }

    /**
     * Gets the actual API key string.
     * @return The API key string
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets the actual API key string.
     * @param key The API key string
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Gets the type of API key.
     * @return The key type ("secret", "publishable", or "restricted")
     */
    public String getKeyType() {
        return keyType;
    }

    /**
     * Sets the type of API key.
     * @param keyType The key type
     */
    public void setKeyType(String keyType) {
        this.keyType = keyType;
    }

    /**
     * Gets the human-readable name for this key.
     * @return The key name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the human-readable name for this key.
     * @param name The key name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the optional description of this key.
     * @return The key description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the optional description of this key.
     * @param description The key description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the Unix timestamp when this key was created.
     * @return Creation timestamp in seconds
     */
    public Long getCreated() {
        return created;
    }

    /**
     * Sets the Unix timestamp when this key was created.
     * @param created Creation timestamp in seconds
     */
    public void setCreated(Long created) {
        this.created = created;
    }

    /**
     * Gets the Unix timestamp when this key was last accessed.
     * @return Last access timestamp in seconds, or null if never accessed
     */
    public Long getLastAccessedAt() {
        return lastAccessedAt;
    }

    /**
     * Sets the Unix timestamp when this key was last accessed.
     * @param lastAccessedAt Last access timestamp in seconds
     */
    public void setLastAccessedAt(Long lastAccessedAt) {
        this.lastAccessedAt = lastAccessedAt;
    }

    /**
     * Gets the current status of the API key.
     * @return The key status ("active", "expired", or "revoked")
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the current status of the API key.
     * @param status The key status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the Unix timestamp when this key will expire.
     * @return Expiration timestamp in seconds, or null if no expiration
     */
    public Long getExpiredAt() {
        return expiredAt;
    }

    /**
     * Sets the Unix timestamp when this key will expire.
     * @param expiredAt Expiration timestamp in seconds
     */
    public void setExpiredAt(Long expiredAt) {
        this.expiredAt = expiredAt;
    }
}
