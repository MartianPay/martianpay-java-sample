package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * BalanceResponse represents the merchant's balance information
 */
public class BalanceResponse {
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
