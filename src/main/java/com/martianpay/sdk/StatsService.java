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
        @SerializedName("currency")
        private String currency;

        @SerializedName("available_balance")
        private String availableBalance;

        @SerializedName("pending_balance")
        private String pendingBalance;

        @SerializedName("locked_balance")
        private String lockedBalance;

        @SerializedName("frozen_balance")
        private String frozenBalance;

        @SerializedName("total_balance")
        private String totalBalance;

        public String getCurrency() { return currency; }
        public String getAvailableBalance() { return availableBalance; }
        public String getPendingBalance() { return pendingBalance; }
        public String getLockedBalance() { return lockedBalance; }
        public String getFrozenBalance() { return frozenBalance; }
        public String getTotalBalance() { return totalBalance; }

        // Legacy compatibility methods
        public String getAssetId() { return currency; }
        public String getAvailable() { return availableBalance; }
        public String getFrozen() { return frozenBalance; }
        public String getTotal() { return totalBalance; }
    }

    /**
     * Merchant balance response
     */
    public static class BalanceResponse {
        @SerializedName("currency")
        private String currency;

        @SerializedName("available_balance")
        private String availableBalance;

        @SerializedName("pending_balance")
        private String pendingBalance;

        @SerializedName("locked_balance")
        private String lockedBalance;

        @SerializedName("frozen_balance")
        private String frozenBalance;

        @SerializedName("total_balance")
        private String totalBalance;

        @SerializedName("balance_details")
        private List<BalanceDetail> balanceDetails;

        public String getCurrency() { return currency; }
        public String getAvailableBalance() { return availableBalance; }
        public String getPendingBalance() { return pendingBalance; }
        public String getLockedBalance() { return lockedBalance; }
        public String getFrozenBalance() { return frozenBalance; }
        public String getTotalBalance() { return totalBalance; }
        public List<BalanceDetail> getBalanceDetails() { return balanceDetails; }

        // Legacy compatibility method
        public List<BalanceDetail> getBalances() { return balanceDetails; }
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
