package com.martianpay.model;

import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;

/**
 * AssetAmount represents a cryptocurrency asset with its amount and decimal precision
 */
public class AssetAmount {
    @SerializedName("asset_id")
    private String assetId;

    @SerializedName("amount")
    private String amount;  // Using String to match API response format

    // Not serialized to JSON
    private transient int decimalDigits;

    public AssetAmount() {
    }

    public AssetAmount(String assetId, String amount) {
        this.assetId = assetId;
        this.amount = amount;
    }

    public AssetAmount(String assetId, BigDecimal amount, int decimals) {
        this.assetId = assetId;
        this.amount = amount.toPlainString();
        this.decimalDigits = decimals;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public int getDecimalDigits() {
        return decimalDigits;
    }

    public void setDecimalDigits(int decimalDigits) {
        this.decimalDigits = decimalDigits;
    }

    public BigDecimal getAmountAsBigDecimal() {
        return new BigDecimal(amount);
    }

    @Override
    public String toString() {
        return "AssetAmount{" +
                "assetId='" + assetId + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
