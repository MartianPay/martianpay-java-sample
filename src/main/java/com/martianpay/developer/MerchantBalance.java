package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * MerchantBalance represents a merchant's balance for a specific currency
 */
public class MerchantBalance {
    /**
     * Currency is the currency code for this balance
     */
    @SerializedName("currency")
    private String currency;

    /**
     * AvailableBalance is the balance available for immediate withdrawal
     */
    @SerializedName("available_balance")
    private String availableBalance;

    /**
     * PendingBalance is the balance pending settlement
     */
    @SerializedName("pending_balance")
    private String pendingBalance;

    /**
     * LockedBalance is the balance locked for disputes or holds
     */
    @SerializedName("locked_balance")
    private String lockedBalance;

    /**
     * FrozenBalance is the balance frozen due to AML or risk checks
     */
    @SerializedName("frozen_balance")
    private String frozenBalance;

    /**
     * TotalBalance is the total balance (sum of all balance types)
     */
    @SerializedName("total_balance")
    private String totalBalance;

    /**
     * BalanceDetails contains detailed breakdown of balances by asset
     */
    @SerializedName("balance_details")
    private List<BalanceDetail> balanceDetails;

    public MerchantBalance() {
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(String availableBalance) {
        this.availableBalance = availableBalance;
    }

    public String getPendingBalance() {
        return pendingBalance;
    }

    public void setPendingBalance(String pendingBalance) {
        this.pendingBalance = pendingBalance;
    }

    public String getLockedBalance() {
        return lockedBalance;
    }

    public void setLockedBalance(String lockedBalance) {
        this.lockedBalance = lockedBalance;
    }

    public String getFrozenBalance() {
        return frozenBalance;
    }

    public void setFrozenBalance(String frozenBalance) {
        this.frozenBalance = frozenBalance;
    }

    public String getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(String totalBalance) {
        this.totalBalance = totalBalance;
    }

    public List<BalanceDetail> getBalanceDetails() {
        return balanceDetails;
    }

    public void setBalanceDetails(List<BalanceDetail> balanceDetails) {
        this.balanceDetails = balanceDetails;
    }
}
