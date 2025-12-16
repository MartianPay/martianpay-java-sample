package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Detailed balance breakdown for a specific asset.
 * Categories: Available (ready for use), Pending (settling), Locked (disputes), Frozen (compliance), Total (sum).
 */
public class BalanceDetail {
    /** Currency or asset identifier. Currently only USD is supported. */
    @SerializedName("currency")
    private String currency;

    /** Available balance ready for immediate withdrawal. */
    @SerializedName("available_balance")
    private String availableBalance;

    /** Pending balance awaiting settlement. */
    @SerializedName("pending_balance")
    private String pendingBalance;

    /** Locked balance held for disputes or chargebacks. */
    @SerializedName("locked_balance")
    private String lockedBalance;

    /** Frozen balance due to AML or compliance review. */
    @SerializedName("frozen_balance")
    private String frozenBalance;

    /** Total balance (sum of all states). */
    @SerializedName("total_balance")
    private String totalBalance;

    public BalanceDetail() {
    }

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
}
