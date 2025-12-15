package com.martianpay.developer;

public class DeveloperConstants {
    public static final String MARTIAN_PAY_API_VERSION = "2025-01-22";

    public static final int WEBHOOK_ENDPOINT_ID_LENGTH = 24;
    public static final String WEBHOOK_ENDPOINT_ID_PREFIX = "wh_";
    public static final String WEBHOOK_ENDPOINT_PREFIX_KEY = "whsec_";
    public static final String WEBHOOK_ENDPOINT_OBJECT = "webhook_endpoint";

    public static final int API_KEY_ID_LENGTH = 24;
    public static final String API_KEY_ID_PREFIX = "ak_";
    public static final String API_KEY_OBJECT = "api_key";

    public static final String API_KEY_PREFIX_PUBLIC_TEST = "pk_test_";
    public static final String API_KEY_PREFIX_SECRET_TEST = "sk_test_";
    public static final String API_KEY_PREFIX_PUBLIC_LIVE = "pk_live_";
    public static final String API_KEY_PREFIX_SECRET_LIVE = "sk_live_";
    public static final int API_KEY_RANDOM_PART_LENGTH = 96;

    public static final String DEVELOPER_KEY_TYPE_PUBLIC = "public";
    public static final String DEVELOPER_KEY_TYPE_SECRET = "secret";

    public static final String DEVELOPER_STATUS_ACTIVE = "active";
    public static final String DEVELOPER_STATUS_INACTIVE = "inactive";
    public static final String DEVELOPER_STATUS_DELETED = "deleted";
    public static final String DEVELOPER_STATUS_DELETING = "deleting";
    public static final String DEVELOPER_STATUS_UNKNOWN = "unknown";

    private DeveloperConstants() {
    }
}
