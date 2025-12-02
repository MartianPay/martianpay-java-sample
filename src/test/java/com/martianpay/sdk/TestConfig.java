package com.martianpay.sdk;

/**
 * Test configuration for MartianPay SDK tests.
 * This class contains common configuration constants used across all test cases.
 */
public class TestConfig {

    /**
     * API key for testing.
     * Replace with your actual test API key from the MartianPay dashboard.
     */
    public static final String API_KEY = "your_api_key_here";

    /**
     * Private constructor to prevent instantiation.
     */
    private TestConfig() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
