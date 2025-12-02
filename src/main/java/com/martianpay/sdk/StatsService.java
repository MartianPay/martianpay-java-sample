package com.martianpay.sdk;

import com.google.gson.annotations.SerializedName;
import com.martianpay.model.AssetAmount;

import java.io.IOException;
import java.util.List;

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
     * Balance detail for a specific asset
     */
    public static class BalanceDetail {
        @SerializedName("asset_id")
        private String assetId;

        @SerializedName("available")
        private String available;

        @SerializedName("frozen")
        private String frozen;

        @SerializedName("total")
        private String total;

        public String getAssetId() { return assetId; }
        public String getAvailable() { return available; }
        public String getFrozen() { return frozen; }
        public String getTotal() { return total; }
    }

    /**
     * Merchant balance response
     */
    public static class BalanceResponse {
        @SerializedName("balances")
        private List<BalanceDetail> balances;

        public List<BalanceDetail> getBalances() { return balances; }
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
