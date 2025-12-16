package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * DepositAccount represents a cryptocurrency deposit account for receiving payments.
 *
 * A deposit account provides a blockchain address where customers can send cryptocurrency
 * payments for charges or invoices. Deposit accounts can be either temporary (for a single
 * payment) or permanent (for recurring payments or static addresses).
 *
 * Account types:
 * - Temporary deposit account: Generated dynamically for a specific charge, expires after payment
 * - Permanent deposit account: Static address that can receive multiple payments over time
 *
 * Key features:
 * - Unique blockchain address generation for each account
 * - Support for multiple cryptocurrency assets (BTC, ETH, USDT, etc.)
 * - Transaction history tracking for all deposits to the address
 * - Automatic amount aggregation from multiple transactions
 * - User and merchant association for payment attribution
 *
 * Lifecycle:
 * 1. Account created with a specific asset type
 * 2. Blockchain address generated or assigned
 * 3. Customer sends cryptocurrency to the address
 * 4. System monitors blockchain for incoming transactions
 * 5. Transactions are recorded and amounts aggregated
 * 6. Payment is confirmed once sufficient funds are received
 *
 * Use cases:
 * - One-time payment collection for e-commerce orders
 * - Recurring payments with static addresses
 * - Multi-transaction partial payments
 * - Customer-specific deposit addresses for tracking
 * - Invoice payment collection
 *
 * Security considerations:
 * - Each address should be unique to prevent payment conflicts
 * - Permanent addresses require careful user identity verification
 * - Transaction monitoring should detect double-spend attempts
 * - Amount verification ensures correct payment amounts
 */
public class DepositAccount {
    /**
     * Unique identifier of the merchant who owns this deposit account.
     * Links the deposit account to the merchant's business account.
     * Format: merch_[random_id]
     */
    @SerializedName("merchant_id")
    private String merchantId;

    /**
     * Unique identifier of the user/customer associated with this deposit account.
     * Used to track which customer is making the payment.
     * Format: user_[random_id]
     */
    @SerializedName("user_id")
    private String userId;

    /**
     * Unique identifier of the charge that this deposit account is associated with.
     * Links the deposit account to a specific payment charge.
     * Format: ch_[random_id]
     * May be null for permanent deposit accounts.
     */
    @SerializedName("charge_id")
    private String chargeId;

    /**
     * Unique identifier of the cryptocurrency asset type for this account.
     * Determines which blockchain and cryptocurrency this address accepts.
     * Format: asset_[random_id]
     * Examples: asset_btc_mainnet, asset_eth_mainnet, asset_usdt_erc20
     */
    @SerializedName("asset_id")
    private String assetId;

    /**
     * The blockchain address where customers send cryptocurrency deposits.
     * This is the actual wallet address on the blockchain network.
     * Format varies by blockchain (e.g., 0x... for Ethereum, 1... or 3... for Bitcoin)
     * This address is monitored for incoming transactions.
     */
    @SerializedName("deposit_address")
    private String depositAddress;

    /**
     * The total amount of cryptocurrency deposited to this address across all transactions.
     * Represented as a string to maintain precision for large numbers and many decimals.
     * Amount is in the smallest unit of the cryptocurrency (e.g., wei for ETH, satoshis for BTC).
     * This value is cumulative and updated as new transactions are detected.
     */
    @SerializedName("deposited_amount")
    private String depositedAmount;

    /**
     * List of all blockchain transactions that have sent funds to this deposit address.
     * Each transaction includes details such as:
     * - Transaction hash for blockchain verification
     * - Sender address
     * - Amount transferred
     * - Confirmation status
     * - Timestamp
     * This list grows as new deposits are detected and confirmed.
     */
    @SerializedName("transactions")
    private List<Transaction> transactions;

    /**
     * Indicates whether this deposit address is permanent or temporary.
     * - true: Permanent address that can receive multiple payments over time
     * - false: Temporary address for a single charge, expires after use
     * Permanent addresses are useful for recurring customers or static payment pages.
     */
    @SerializedName("is_permanent")
    private Boolean isPermanent;

    /**
     * Unique identifier for permanent deposit addresses.
     * Only populated when isPermanent is true.
     * Used to retrieve or reference the permanent address in future operations.
     * Format: dep_[random_id]
     * Null or empty for temporary deposit accounts.
     */
    @SerializedName("unique_id")
    private String uniqueId;

    /**
     * Creates a new DepositAccount instance with default values.
     */
    public DepositAccount() {
    }

    // Getters and Setters

    /**
     * Gets the unique identifier of the merchant who owns this deposit account.
     * @return The merchant ID
     */
    public String getMerchantId() {
        return merchantId;
    }

    /**
     * Sets the unique identifier of the merchant who owns this deposit account.
     * @param merchantId The merchant ID
     */
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * Gets the unique identifier of the user/customer associated with this deposit account.
     * @return The user ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the unique identifier of the user/customer associated with this deposit account.
     * @param userId The user ID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Gets the unique identifier of the charge associated with this deposit account.
     * @return The charge ID, or null for permanent deposit accounts
     */
    public String getChargeId() {
        return chargeId;
    }

    /**
     * Sets the unique identifier of the charge associated with this deposit account.
     * @param chargeId The charge ID
     */
    public void setChargeId(String chargeId) {
        this.chargeId = chargeId;
    }

    /**
     * Gets the unique identifier of the cryptocurrency asset type.
     * @return The asset ID
     */
    public String getAssetId() {
        return assetId;
    }

    /**
     * Sets the unique identifier of the cryptocurrency asset type.
     * @param assetId The asset ID
     */
    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    /**
     * Gets the blockchain address where deposits are received.
     * @return The deposit address
     */
    public String getDepositAddress() {
        return depositAddress;
    }

    /**
     * Sets the blockchain address where deposits are received.
     * @param depositAddress The deposit address
     */
    public void setDepositAddress(String depositAddress) {
        this.depositAddress = depositAddress;
    }

    /**
     * Gets the total amount deposited to this address.
     * @return The deposited amount as a string
     */
    public String getDepositedAmount() {
        return depositedAmount;
    }

    /**
     * Sets the total amount deposited to this address.
     * @param depositedAmount The deposited amount as a string
     */
    public void setDepositedAmount(String depositedAmount) {
        this.depositedAmount = depositedAmount;
    }

    /**
     * Gets the list of all blockchain transactions to this address.
     * @return List of transactions
     */
    public List<Transaction> getTransactions() {
        return transactions;
    }

    /**
     * Sets the list of all blockchain transactions to this address.
     * @param transactions List of transactions
     */
    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    /**
     * Gets whether this is a permanent deposit address.
     * @return true if permanent, false if temporary
     */
    public Boolean getIsPermanent() {
        return isPermanent;
    }

    /**
     * Sets whether this is a permanent deposit address.
     * @param isPermanent true if permanent, false if temporary
     */
    public void setIsPermanent(Boolean isPermanent) {
        this.isPermanent = isPermanent;
    }

    /**
     * Gets the unique identifier for permanent deposit addresses.
     * @return The unique ID, or null for temporary accounts
     */
    public String getUniqueId() {
        return uniqueId;
    }

    /**
     * Sets the unique identifier for permanent deposit addresses.
     * @param uniqueId The unique ID
     */
    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }
}
