package com.martianpay.developer;

/**
 * Developer Constants
 *
 * This class contains constant values used throughout the MartianPay SDK.
 * It defines API versions, webhook configurations, API key formats, and status values.
 * All constants are immutable and accessed statically.
 */
public class DeveloperConstants {

    /**
     * Current version of the MartianPay API.
     * This version is used in API requests to ensure compatibility.
     */
    public static final String MARTIAN_PAY_API_VERSION = "2025-01-22";

    // Webhook Endpoint Configuration Constants

    /**
     * Standard length for webhook endpoint IDs.
     * Webhook endpoint IDs are fixed at 24 characters (excluding prefix).
     */
    public static final int WEBHOOK_ENDPOINT_ID_LENGTH = 24;

    /**
     * Prefix used for all webhook endpoint IDs.
     * All webhook endpoint IDs start with "wh_".
     */
    public static final String WEBHOOK_ENDPOINT_ID_PREFIX = "wh_";

    /**
     * Prefix used for webhook endpoint secret keys.
     * Webhook secrets start with "whsec_" for identification.
     */
    public static final String WEBHOOK_ENDPOINT_PREFIX_KEY = "whsec_";

    /**
     * Object type identifier for webhook endpoints.
     * Used in API responses to identify webhook endpoint objects.
     */
    public static final String WEBHOOK_ENDPOINT_OBJECT = "webhook_endpoint";

    // API Key Configuration Constants

    /**
     * Standard length for API key IDs.
     * API key IDs are fixed at 24 characters (excluding prefix).
     */
    public static final int API_KEY_ID_LENGTH = 24;

    /**
     * Prefix used for all API key IDs.
     * All API key IDs start with "ak_".
     */
    public static final String API_KEY_ID_PREFIX = "ak_";

    /**
     * Object type identifier for API keys.
     * Used in API responses to identify API key objects.
     */
    public static final String API_KEY_OBJECT = "api_key";

    // API Key Type Prefixes

    /**
     * Prefix for public test API keys.
     * Public test keys start with "pk_test_" and are used for client-side operations in test mode.
     */
    public static final String API_KEY_PREFIX_PUBLIC_TEST = "pk_test_";

    /**
     * Prefix for secret test API keys.
     * Secret test keys start with "sk_test_" and are used for server-side operations in test mode.
     */
    public static final String API_KEY_PREFIX_SECRET_TEST = "sk_test_";

    /**
     * Prefix for public live API keys.
     * Public live keys start with "pk_live_" and are used for client-side operations in production.
     */
    public static final String API_KEY_PREFIX_PUBLIC_LIVE = "pk_live_";

    /**
     * Prefix for secret live API keys.
     * Secret live keys start with "sk_live_" and are used for server-side operations in production.
     */
    public static final String API_KEY_PREFIX_SECRET_LIVE = "sk_live_";

    /**
     * Length of the random part of an API key.
     * The random portion contains 96 characters for security.
     */
    public static final int API_KEY_RANDOM_PART_LENGTH = 96;

    // API Key Types

    /**
     * Identifier for public API key type.
     * Public keys can be safely used in client-side code.
     */
    public static final String DEVELOPER_KEY_TYPE_PUBLIC = "public";

    /**
     * Identifier for secret API key type.
     * Secret keys should only be used in secure server-side environments.
     */
    public static final String DEVELOPER_KEY_TYPE_SECRET = "secret";

    // Status Values

    /**
     * Status indicating an entity is active and operational.
     */
    public static final String DEVELOPER_STATUS_ACTIVE = "active";

    /**
     * Status indicating an entity is inactive but not deleted.
     */
    public static final String DEVELOPER_STATUS_INACTIVE = "inactive";

    /**
     * Status indicating an entity has been deleted.
     */
    public static final String DEVELOPER_STATUS_DELETED = "deleted";

    /**
     * Status indicating an entity is in the process of being deleted.
     */
    public static final String DEVELOPER_STATUS_DELETING = "deleting";

    /**
     * Status indicating an entity's state is unknown or undefined.
     */
    public static final String DEVELOPER_STATUS_UNKNOWN = "unknown";

    /**
     * Private constructor to prevent instantiation.
     * This class only contains static constants and should not be instantiated.
     */
    private DeveloperConstants() {
    }
}
