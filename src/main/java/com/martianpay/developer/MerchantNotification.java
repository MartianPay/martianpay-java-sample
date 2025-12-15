package com.martianpay.developer;

import java.security.SecureRandom;

/**
 * MerchantNotification contains constants and utility methods for merchant notifications
 */
public class MerchantNotification {
    public static final int MERCHANT_NOTIFICATION_CONFIG_ID_LENGTH = 24;
    public static final String MERCHANT_NOTIFICATION_CONFIG_ID_PREFIX = "mnc_";

    public static final int MERCHANT_NOTIFICATION_LOG_ID_LENGTH = 24;
    public static final String MERCHANT_NOTIFICATION_LOG_ID_PREFIX = "mnl_";

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom RANDOM = new SecureRandom();

    /**
     * GenerateMerchantNotificationConfigID generates a unique ID for merchant notification config
     */
    public static String generateMerchantNotificationConfigId() {
        return MERCHANT_NOTIFICATION_CONFIG_ID_PREFIX + generateRandomString(MERCHANT_NOTIFICATION_CONFIG_ID_LENGTH);
    }

    /**
     * GenerateMerchantNotificationLogID generates a unique ID for merchant notification log
     */
    public static String generateMerchantNotificationLogId() {
        return MERCHANT_NOTIFICATION_LOG_ID_PREFIX + generateRandomString(MERCHANT_NOTIFICATION_LOG_ID_LENGTH);
    }

    private static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }
}
