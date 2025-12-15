package com.martianpay.examples;

/**
 * Common configuration for MartianPay SDK examples.
 * This class contains API keys and other configuration constants.
 */
public class Common {

    /**
     * API key for MartianPay API.
     * Replace with your actual API key from the MartianPay dashboard.
     */
    public static final String API_KEY = "your_api_key_here";

    /**
     * Current API key used at runtime (can be overridden by user input)
     */
    public static String currentAPIKey = API_KEY;

    /**
     * Webhook secret for verifying webhook signatures.
     * Replace with your actual webhook secret from the MartianPay dashboard.
     */
    public static final String WEBHOOK_SECRET = "whsec_51b0f300f018596566c3dbd86ef2c8adee14673f6fde28f20be1ccc82e171f2f";

    /**
     * Private constructor to prevent instantiation.
     */
    private Common() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
