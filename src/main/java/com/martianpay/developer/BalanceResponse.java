package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Merchant balance information across different states (available, pending, locked, frozen).
 */
public class BalanceResponse {
    /** Currency or asset symbol (e.g., "USD", "BTC", "ETH"). Currently only USD is supported. */
    @SerializedName("currency")
    private String currency;

    /** Available balance ready for immediate use. */
    @SerializedName("available_balance")
    private String availableBalance;

    /** Pending balance currently being processed. */
    @SerializedName("pending_balance")
    private String pendingBalance;

    /** Locked balance reserved for refunds or disputes. */
    @SerializedName("locked_balance")
    private String lockedBalance;

    /** Frozen balance temporarily restricted. */
    @SerializedName("frozen_balance")
    private String frozenBalance;

    /** Total balance across all states. */
    @SerializedName("total_balance")
    private String totalBalance;

    /** Detailed balance breakdown by asset and network. */
    @SerializedName("balance_details")
    private List<BalanceDetail> balanceDetails;

    // Getters and Setters
    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public String getAvailableBalance() { return availableBalance; }
    public void setAvailableBalance(String availableBalance) { this.availableBalance = availableBalance; }

    public String getPendingBalance() { return pendingBalance; }
    public void setPendingBalance(String pendingBalance) { this.pendingBalance = pendingBalance; }

    public String getLockedBalance() { return lockedBalance; }
    public void setLockedBalance(String lockedBalance) { this.lockedBalance = lockedBalance; }

    public String getFrozenBalance() { return frozenBalance; }
    public void setFrozenBalance(String frozenBalance) { this.frozenBalance = frozenBalance; }

    public String getTotalBalance() { return totalBalance; }
    public void setTotalBalance(String totalBalance) { this.totalBalance = totalBalance; }

    public List<BalanceDetail> getBalanceDetails() { return balanceDetails; }
    public void setBalanceDetails(List<BalanceDetail> balanceDetails) { this.balanceDetails = balanceDetails; }
}
