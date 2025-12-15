package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * DepositAccount represents a cryptocurrency deposit account for receiving payments
 */
public class DepositAccount {
    /**
     * MerchantId is the unique identifier of the merchant
     */
    @SerializedName("merchant_id")
    private String merchantId;

    /**
     * UserId is the unique identifier of the user
     */
    @SerializedName("user_id")
    private String userId;

    /**
     * ChargeId is the unique identifier of the associated charge
     */
    @SerializedName("charge_id")
    private String chargeId;

    /**
     * AssetId is the unique identifier of the cryptocurrency asset
     */
    @SerializedName("asset_id")
    private String assetId;

    /**
     * DepositAddress is the blockchain address for receiving deposits
     */
    @SerializedName("deposit_address")
    private String depositAddress;

    /**
     * DepositedAmount is the total amount deposited to this address
     */
    @SerializedName("deposited_amount")
    private String depositedAmount;

    /**
     * Transactions is the list of blockchain transactions on this deposit address
     */
    @SerializedName("transactions")
    private List<Transaction> transactions;

    /**
     * IsPermanent indicates whether this is a permanent deposit address
     */
    @SerializedName("is_permanent")
    private Boolean isPermanent;

    /**
     * UniqueId is the unique identifier for permanent deposit addresses (only valid when IsPermanent is true)
     */
    @SerializedName("unique_id")
    private String uniqueId;

    public DepositAccount() {
    }

    // Getters and Setters
    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getChargeId() {
        return chargeId;
    }

    public void setChargeId(String chargeId) {
        this.chargeId = chargeId;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getDepositAddress() {
        return depositAddress;
    }

    public void setDepositAddress(String depositAddress) {
        this.depositAddress = depositAddress;
    }

    public String getDepositedAmount() {
        return depositedAmount;
    }

    public void setDepositedAmount(String depositedAmount) {
        this.depositedAmount = depositedAmount;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Boolean getIsPermanent() {
        return isPermanent;
    }

    public void setIsPermanent(Boolean isPermanent) {
        this.isPermanent = isPermanent;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }
}
