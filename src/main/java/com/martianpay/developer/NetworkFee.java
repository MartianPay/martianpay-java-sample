package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;

/**
 * NetworkFee represents fee information for a specific network
 */
public class NetworkFee {
    /**
     * MinPayoutAmount is the minimum payout amount allowed for this network
     */
    @SerializedName("min_payout_amount")
    private BigDecimal minPayoutAmount;

    /**
     * FeeAmount is the fixed fee amount for transactions on this network
     */
    @SerializedName("fee_amount")
    private BigDecimal feeAmount;

    // Getters and Setters
    public BigDecimal getMinPayoutAmount() { return minPayoutAmount; }
    public void setMinPayoutAmount(BigDecimal minPayoutAmount) { this.minPayoutAmount = minPayoutAmount; }

    public BigDecimal getFeeAmount() { return feeAmount; }
    public void setFeeAmount(BigDecimal feeAmount) { this.feeAmount = feeAmount; }
}
