package com.martianpay.developer;

import java.math.BigDecimal;
import java.math.RoundingMode;
import com.google.gson.annotations.SerializedName;

/**
 * Amount of a specific asset with decimal precision handling.
 * Uses BigDecimal for exact arithmetic and converts between human-readable decimals and blockchain integers.
 * Different assets have different decimals: USD(2), USDC(6), BTC(8), ETH(18).
 */
public class AssetAmount {
    /** Asset/currency identifier (e.g., "USD", "USDC_ETH", "BTC_BTC"). Currently only USD is supported. */
    @SerializedName("asset_id")
    private String assetId;

    /** Decimal amount in human-readable format (e.g., 1.50). */
    @SerializedName("amount")
    private BigDecimal amount;

    /** Number of decimal places for this asset (not serialized). */
    private Integer decimalDigits;

    public AssetAmount() {
    }

    public AssetAmount(BigDecimal amount, String assetId, Integer decimals) {
        this.assetId = assetId;
        this.amount = amount;
        this.decimalDigits = decimals;
    }

    /** Creates AssetAmount from blockchain integer amount. */
    public static AssetAmount newAssetAmountFromBigInt(BigDecimal intAmount, String assetId, Integer decimals) {
        BigDecimal amount = intAmount.scaleByPowerOfTen(-decimals);
        return new AssetAmount(amount, assetId, decimals);
    }

    /** Converts decimal amount to blockchain integer format. */
    public BigDecimal bigInt() {
        return this.amount.scaleByPowerOfTen(this.decimalDigits);
    }

    /** Gets the decimal amount. */
    public BigDecimal value() {
        return this.amount;
    }

    /** Checks if amount has excessive decimal places. */
    public boolean decimalOverflow() {
        BigDecimal inter = this.bigInt().setScale(0, RoundingMode.DOWN);
        return this.amount.compareTo(inter) == 0;
    }

    /** Validates if this is a valid positive price. */
    public boolean isValidPrice() {
        if (this == null || this.amount == null) {
            return false;
        }
        return this.value().compareTo(BigDecimal.ZERO) > 0 && !this.decimalOverflow();
    }

    public String getAssetId() { return assetId; }
    public void setAssetId(String assetId) { this.assetId = assetId; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public Integer getDecimalDigits() { return decimalDigits; }
    public void setDecimalDigits(Integer decimalDigits) { this.decimalDigits = decimalDigits; }

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
