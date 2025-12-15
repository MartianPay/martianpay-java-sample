package com.martianpay.sdk;

import com.martianpay.developer.BalanceResponse;

import java.io.IOException;

/**
 * StatsService provides methods for querying merchant statistics and balance
 */
public class StatsService extends MartianPayClient {

    public StatsService(String apiKey) {
        super(apiKey);
    }

    public StatsService(String apiKey, String baseUrl) {
        super(apiKey, baseUrl);
    }

    /**
     * Retrieves the merchant's balance
     *
     * @return Merchant balance
     * @throws IOException if request fails
     */
    public BalanceResponse getBalance() throws IOException {
        return sendRequest("GET", "/v1/stats/balance", null, BalanceResponse.class);
    }
}
