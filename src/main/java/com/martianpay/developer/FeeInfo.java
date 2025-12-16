package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * FeeInfo contains comprehensive fee information for a blockchain transaction.
 *
 * This class breaks down the various fees associated with cryptocurrency transactions
 * on the MartianPay platform, providing transparency into costs for both network
 * operations and platform services.
 *
 * Fee components:
 * - Network Fee: Cost paid to blockchain miners/validators for transaction processing
 * - Service Fee: Platform fee charged by MartianPay for using the service
 *
 * Network fees:
 * - Vary by blockchain network (Bitcoin, Ethereum, etc.)
 * - Fluctuate based on network congestion
 * - Paid to miners/validators, not to MartianPay
 * - Required for transaction confirmation
 * - Can be estimated before transaction
 * - Examples: Gas fees on Ethereum, miner fees on Bitcoin
 *
 * Service fees:
 * - Charged by MartianPay for platform services
 * - Typically a percentage of transaction amount
 * - May include fixed components
 * - Calculation: serviceFee = grossAmount - netAmount
 * - Covers payment processing, fraud prevention, customer support
 * - May vary by merchant agreement and transaction volume
 *
 * Use cases:
 * - Display fee breakdown to merchants
 * - Calculate total transaction costs
 * - Generate financial reports and statements
 * - Reconcile payments and settlements
 * - Provide transparency in invoices
 * - Track platform revenue
 *
 * Fee calculation example:
 * - Gross amount: 100.00 USDT
 * - Service fee: 2.50 USDT (2.5%)
 * - Net amount: 97.50 USDT (amount merchant receives)
 * - Network fee: 0.30 USDT (blockchain transaction cost)
 *
 * Important notes:
 * - All amounts are represented as strings to preserve precision
 * - Amounts are in the cryptocurrency's base units
 * - Network fees are separate from service fees
 * - Network fees are paid by the sender or deducted from amount
 * - Service fees affect merchant settlement amounts
 */
public class FeeInfo {
    /**
     * The fee paid to the blockchain network for processing the transaction.
     * This fee goes to miners (Bitcoin) or validators (Ethereum) who confirm
     * the transaction on the blockchain.
     *
     * Characteristics:
     * - Varies by network congestion and transaction priority
     * - Denominated in the blockchain's native currency (ETH for Ethereum, etc.)
     * - Required for transaction to be included in a block
     * - Higher fees typically result in faster confirmation
     * - Not controlled by MartianPay
     *
     * Examples:
     * - Ethereum: Gas fee in wei or gwei
     * - Bitcoin: Miner fee in satoshis
     * - Solana: Transaction fee in lamports
     *
     * Represented as a string to maintain precision for fractional amounts.
     */
    @SerializedName("network_fee")
    private String networkFee;

    /**
     * The service fee charged by the MartianPay platform.
     * This is the platform's fee for providing payment processing services.
     *
     * Calculation:
     * serviceFee = grossAmount - netAmount
     * where:
     * - grossAmount: Total amount before fees
     * - netAmount: Amount merchant receives after fees
     *
     * This fee covers:
     * - Payment processing infrastructure
     * - Fraud detection and prevention
     * - Customer support
     * - API and developer tools
     * - Compliance and regulatory requirements
     * - Platform maintenance and operations
     *
     * Fee structure:
     * - Typically a percentage of transaction amount
     * - May include fixed minimum fees
     * - Can vary by merchant agreement
     * - Volume discounts may apply
     * - Different rates for different payment methods
     *
     * Represented as a string to maintain precision for fractional amounts.
     */
    @SerializedName("service_fee")
    private String serviceFee;

    /**
     * Creates a new FeeInfo instance.
     */
    public FeeInfo() {
    }

    // Getters and Setters

    /**
     * Gets the fee paid to the blockchain network.
     * @return The network fee as a string
     */
    public String getNetworkFee() {
        return networkFee;
    }

    /**
     * Sets the fee paid to the blockchain network.
     * @param networkFee The network fee as a string
     */
    public void setNetworkFee(String networkFee) {
        this.networkFee = networkFee;
    }

    /**
     * Gets the service fee charged by the platform.
     * @return The service fee as a string
     */
    public String getServiceFee() {
        return serviceFee;
    }

    /**
     * Sets the service fee charged by the platform.
     * @param serviceFee The service fee as a string
     */
    public void setServiceFee(String serviceFee) {
        this.serviceFee = serviceFee;
    }
}
