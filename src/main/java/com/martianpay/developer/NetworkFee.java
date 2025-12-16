package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;

/**
 * NetworkFee represents blockchain network fee information and constraints.
 *
 * Each blockchain network has different fee structures and minimum transaction requirements.
 * This class encapsulates the fee and limit information specific to a blockchain network,
 * helping merchants understand the costs and constraints when making payouts or withdrawals.
 *
 * Network fee characteristics:
 * - Fixed per transaction (not percentage-based)
 * - Varies by blockchain network (Ethereum, Bitcoin, TRON, etc.)
 * - Covers blockchain transaction costs (gas fees, miner fees)
 * - Independent of transaction amount
 * - Changes based on network congestion and platform policies
 *
 * Use cases:
 * - Displaying payout fees to merchants before transaction
 * - Validating payout amounts against minimum thresholds
 * - Calculating net payout amount (amount - fee)
 * - Comparing costs across different networks
 * - Determining optimal payout timing and batching
 * - Setting up automated payout strategies
 *
 * Example networks and typical characteristics:
 * - Ethereum (ETH): Higher fees during congestion, ERC-20 tokens cost more
 * - Bitcoin (BTC): Fees vary by network load, SegWit addresses cheaper
 * - TRON (TRX): Generally lower fees, TRC-20 tokens supported
 * - Binance Smart Chain (BSC): Lower fees than Ethereum, BEP-20 tokens
 * - Polygon (MATIC): Very low fees, fast confirmation
 *
 * Important considerations:
 * - Minimum payout amounts prevent uneconomical small transactions
 * - Network fees are deducted from the payout amount
 * - Fees displayed in the network's native currency
 * - Actual blockchain fees may vary, platform absorbs the difference
 * - Minimum amounts ensure fees don't exceed transaction value
 */
public class NetworkFee {
    /**
     * Minimum payout amount allowed for this blockchain network.
     * Transactions below this amount will be rejected.
     *
     * Purpose:
     * - Ensures payout amount exceeds network transaction fees
     * - Prevents uneconomical micro-transactions
     * - Covers operational costs of processing
     * - Maintains efficient batch processing
     *
     * Represented as BigDecimal to maintain precision across different currencies.
     *
     * Example minimums:
     * - BTC: 0.001 BTC (varies by network fee conditions)
     * - ETH: 0.01 ETH
     * - USDT: 10 USDT
     * - TRON: 1 TRX
     *
     * When requesting a payout:
     * - Validate amount >= min_payout_amount
     * - Consider the network fee will be deducted
     * - Ensure sufficient balance to cover both amount + fee
     * - Display minimum requirement to users
     */
    @SerializedName("min_payout_amount")
    private BigDecimal minPayoutAmount;

    /**
     * Fixed fee amount charged for transactions on this network.
     * This fee covers the blockchain network costs (gas, miner fees).
     *
     * Fee characteristics:
     * - Fixed amount, not a percentage of transaction value
     * - Charged per transaction, not per unit of currency
     * - Same fee whether sending 10 or 1000 units
     * - Deducted from the payout amount
     * - Denominated in the network's currency
     *
     * Represented as BigDecimal to maintain precision.
     *
     * Example fees (illustrative):
     * - BTC: 0.0005 BTC
     * - ETH: 0.005 ETH
     * - USDT (ERC-20): ~0.002 ETH equivalent
     * - USDT (TRC-20): ~1 TRX equivalent
     *
     * Payout calculation:
     * - If merchant requests 100 USDT payout
     * - And fee is 1 USDT
     * - Merchant receives: 100 USDT
     * - Platform deducts: 100 + 1 = 101 USDT from merchant balance
     *
     * OR (depending on platform policy):
     * - Merchant requests 100 USDT payout
     * - Fee is 1 USDT
     * - Platform deducts 100 from balance
     * - Merchant receives: 100 - 1 = 99 USDT (fee deducted from payout)
     *
     * Best practices:
     * - Always show fee to merchants before confirming payout
     * - Consider batching payouts to reduce per-transaction costs
     * - Choose networks with lower fees when possible
     * - Monitor fee changes over time
     * - Factor fees into profitability calculations
     */
    @SerializedName("fee_amount")
    private BigDecimal feeAmount;

    // Getters and Setters
    public BigDecimal getMinPayoutAmount() { return minPayoutAmount; }
    public void setMinPayoutAmount(BigDecimal minPayoutAmount) { this.minPayoutAmount = minPayoutAmount; }

    public BigDecimal getFeeAmount() { return feeAmount; }
    public void setFeeAmount(BigDecimal feeAmount) { this.feeAmount = feeAmount; }
}
