package com.martianpay.developer;

import java.math.BigDecimal;
import java.math.RoundingMode;
import com.google.gson.annotations.SerializedName;

/**
 * AssetAmount represents a cryptocurrency asset with its amount and decimal precision
 */
public class AssetAmount {
    /**
     * AssetId is the unique identifier for the asset/currency
     */
    @SerializedName("asset_id")
    private String assetId;

    /**
     * Amount is the decimal amount of the asset
     */
    @SerializedName("amount")
    private BigDecimal amount;

    /**
     * DecimalDigits is the number of decimal places for this asset (not serialized to JSON)
     */
    private Integer decimalDigits;

    public AssetAmount() {
    }

    public AssetAmount(BigDecimal amount, String assetId, Integer decimals) {
        this.assetId = assetId;
        this.amount = amount;
        this.decimalDigits = decimals;
    }

    public static AssetAmount newAssetAmountFromBigInt(BigDecimal intAmount, String assetId, Integer decimals) {
        BigDecimal amount = intAmount.scaleByPowerOfTen(-decimals);
        return new AssetAmount(amount, assetId, decimals);
    }

    public BigDecimal bigInt() {
        return this.amount.scaleByPowerOfTen(this.decimalDigits);
    }

    public BigDecimal value() {
        return this.amount;
    }

    public boolean decimalOverflow() {
        BigDecimal inter = this.bigInt().setScale(0, RoundingMode.DOWN);
        return this.amount.compareTo(inter) == 0;
    }

    public boolean isValidPrice() {
        if (this == null || this.amount == null) {
            return false;
        }
        return this.value().compareTo(BigDecimal.ZERO) > 0 && !this.decimalOverflow();
    }

    // Getters and Setters
    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getDecimalDigits() {
        return decimalDigits;
    }

    public void setDecimalDigits(Integer decimalDigits) {
        this.decimalDigits = decimalDigits;
    }

    @Override
    public String toString() {
        if (amount == null) {
            return "null";
        }
        if (assetId != null) {
            return amount.toPlainString() + " " + assetId;
        }
        return amount.toPlainString();
    }
}
