package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Transaction represents a blockchain transaction on the MartianPay platform.
 *
 * A transaction records the transfer of cryptocurrency funds on a blockchain network.
 * It includes comprehensive information about the transfer, including addresses, amounts,
 * fees, and compliance screening results.
 *
 * Transaction types:
 * - Type 0 (Deposit): Incoming cryptocurrency payment to a merchant address
 * - Type 1 (Refund): Outgoing cryptocurrency payment back to a customer
 *
 * Transaction lifecycle:
 * 1. Submitted - Transaction broadcast to blockchain network
 * 2. Pending - Waiting for blockchain confirmations
 * 3. Completed - Required confirmations received
 * 4. Confirmed - Final state after maximum confirmations
 * 5. Failed - Transaction failed on blockchain or was rejected
 *
 * AML screening:
 * All transactions undergo Anti-Money Laundering (AML) screening.
 * A transaction is considered successful only when:
 * - status is "confirmed"
 * - amlStatus is "approved"
 *
 * Key features:
 * - Blockchain transaction hash for verification
 * - Source and destination address tracking
 * - Amount and asset identification
 * - Fee breakdown (network fees and service fees)
 * - AML compliance screening
 * - Association with charges or refunds
 * - Real-time status updates
 *
 * Use cases:
 * - Track customer deposits to payment addresses
 * - Monitor refund transactions to customer addresses
 * - Verify blockchain confirmations
 * - Generate transaction history reports
 * - Audit trails for compliance
 * - Fee reconciliation
 * - Fraud detection and prevention
 *
 * Security considerations:
 * - All transactions are screened for AML compliance
 * - High-risk transactions may be flagged or rejected
 * - Transaction hashes can be verified on public blockchains
 * - Double-spend detection through blockchain monitoring
 */
public class Transaction {
    /**
     * The blockchain address sending the funds.
     * This is the wallet address initiating the transaction.
     * For deposits: Customer's cryptocurrency wallet address
     * For refunds: Merchant's refund address
     * Format varies by blockchain (e.g., 0x... for Ethereum, bc1... for Bitcoin)
     */
    @SerializedName("source_address")
    private String sourceAddress;

    /**
     * The blockchain address receiving the funds.
     * This is the wallet address where funds are being sent.
     * For deposits: Merchant's deposit address
     * For refunds: Customer's refund address
     * Format varies by blockchain (e.g., 0x... for Ethereum, bc1... for Bitcoin)
     */
    @SerializedName("destination_address")
    private String destinationAddress;

    /**
     * The unique transaction hash on the blockchain.
     * This hash uniquely identifies the transaction on the blockchain network
     * and can be used to verify the transaction on blockchain explorers.
     * Format: Hexadecimal string (e.g., 0x... for Ethereum, 64-char hex for Bitcoin)
     * Immutable once set - serves as the transaction's permanent identifier.
     */
    @SerializedName("tx_hash")
    private String txHash;

    /**
     * The transaction amount in the smallest unit of the cryptocurrency.
     * Represented as a string to maintain precision for large numbers and many decimals.
     * Examples:
     * - For Bitcoin: amount in satoshis (1 BTC = 100,000,000 satoshis)
     * - For Ethereum: amount in wei (1 ETH = 10^18 wei)
     * - For USDT: amount in smallest unit based on token decimals
     * This is the gross amount before any fees are deducted.
     */
    @SerializedName("amount")
    private String amount;

    /**
     * Unique identifier of the cryptocurrency asset.
     * Maps to a specific token symbol and blockchain network combination.
     * Format: asset_[random_id] or token symbol
     * Examples: "asset_btc_mainnet", "asset_eth_erc20", "BTC", "ETH", "USDT"
     * Used to identify which cryptocurrency and on which network this transaction occurs.
     */
    @SerializedName("asset_id")
    private String assetId;

    /**
     * Transaction type identifier.
     * Values:
     * - 0: Deposit transaction (incoming payment to merchant)
     * - 1: Refund transaction (outgoing refund to customer)
     * This field determines the direction and purpose of the transaction.
     */
    @SerializedName("type")
    private Integer type;

    /**
     * Unix timestamp (in seconds) when the transaction was created in the system.
     * This is when MartianPay first detected or initiated the transaction,
     * not necessarily when it was confirmed on the blockchain.
     * Used for chronological ordering and age calculations.
     */
    @SerializedName("created_at")
    private Long createdAt;

    /**
     * Current status of the transaction in its lifecycle.
     * Possible values:
     * - "submitted": Transaction broadcast to blockchain, awaiting confirmations
     * - "completed": Transaction has reached required confirmations for business logic
     * - "confirmed": Transaction has maximum confirmations and is finalized
     * - "failed": Transaction failed on blockchain or was rejected by the network
     *
     * A transaction is considered fully successful when:
     * - status is "confirmed" AND
     * - amlStatus is "approved"
     *
     * Status progression: submitted → completed → confirmed (or failed at any stage)
     */
    @SerializedName("status")
    private String status;

    /**
     * Anti-Money Laundering (AML) screening status for this transaction.
     * Possible values:
     * - "" (empty string): AML screening not yet performed or not required
     * - "approved": Transaction passed AML compliance checks and can proceed
     * - "rejected": Transaction failed AML checks and is flagged for review
     *
     * All transactions undergo AML screening for regulatory compliance.
     * High-risk transactions (based on AmlInfo score and rules) may be rejected.
     * A transaction is only considered successful when amlStatus is "approved".
     */
    @SerializedName("aml_status")
    private String amlStatus;

    /**
     * Detailed Anti-Money Laundering screening information.
     * Contains the risk score (0-10) and list of triggered compliance rules.
     * Provides transparency into why a transaction may have been flagged.
     * Null if AML screening has not been performed yet.
     * See AmlInfo class for detailed field descriptions.
     */
    @SerializedName("aml_info")
    private AmlInfo amlInfo;

    /**
     * Unique identifier of the charge or payment intent this transaction is associated with.
     * Format: ch_[random_id] or pi_[random_id]
     * Links this blockchain transaction to the payment charge it fulfills.
     * Used to track which payment this transaction is paying for.
     * Always populated for deposit transactions (type=0).
     */
    @SerializedName("charge_id")
    private String chargeId;

    /**
     * Unique identifier of the refund this transaction is associated with.
     * Format: re_[random_id]
     * Only populated when type=1 (refund transaction).
     * Links this blockchain transaction to the refund it executes.
     * Null for deposit transactions (type=0).
     */
    @SerializedName("refund_id")
    private String refundId;

    /**
     * Detailed fee breakdown for this transaction.
     * Contains both network fees (paid to blockchain) and service fees (paid to platform).
     * Provides transparency in fee structure and total cost breakdown.
     * Null if fee information is not yet available or not applicable.
     * See FeeInfo class for detailed field descriptions.
     */
    @SerializedName("fee_info")
    private FeeInfo feeInfo;

    /**
     * The cryptocurrency asset used to pay the blockchain transaction fee.
     * Often different from the asset being transferred in the transaction.
     * Examples:
     * - "ETH" when sending ERC-20 tokens (gas fees paid in ETH)
     * - "BNB" when sending BEP-20 tokens (gas fees paid in BNB)
     * - "BTC" when sending Bitcoin (fees paid in BTC)
     * Format: Token symbol or asset identifier
     * Used to correctly account for transaction costs in different currencies.
     */
    @SerializedName("fee_currency")
    private String feeCurrency;

    public Transaction() {
    }

    // Getters and Setters
    public String getSourceAddress() {
        return sourceAddress;
    }

    public void setSourceAddress(String sourceAddress) {
        this.sourceAddress = sourceAddress;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public String getTxHash() {
        return txHash;
    }

    public void setTxHash(String txHash) {
        this.txHash = txHash;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAmlStatus() {
        return amlStatus;
    }

    public void setAmlStatus(String amlStatus) {
        this.amlStatus = amlStatus;
    }

    public AmlInfo getAmlInfo() {
        return amlInfo;
    }

    public void setAmlInfo(AmlInfo amlInfo) {
        this.amlInfo = amlInfo;
    }

    public String getChargeId() {
        return chargeId;
    }

    public void setChargeId(String chargeId) {
        this.chargeId = chargeId;
    }

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    public FeeInfo getFeeInfo() {
        return feeInfo;
    }

    public void setFeeInfo(FeeInfo feeInfo) {
        this.feeInfo = feeInfo;
    }

    public String getFeeCurrency() {
        return feeCurrency;
    }

    public void setFeeCurrency(String feeCurrency) {
        this.feeCurrency = feeCurrency;
    }
}
