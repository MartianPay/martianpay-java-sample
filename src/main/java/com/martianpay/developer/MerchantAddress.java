package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * MerchantAddress represents a merchant's blockchain wallet address for receiving payments.
 *
 * Merchant addresses are the destination addresses where merchants receive cryptocurrency payments.
 * These addresses must be verified before they can be used for payouts or withdrawals, ensuring
 * they are controlled by the merchant and reducing fraud risk.
 *
 * Address lifecycle:
 * 1. created: Address registered but verification not yet initiated
 * 2. verifying: Verification process in progress (email confirmation, small amount test, etc.)
 * 3. success: Address successfully verified and ready for use
 * 4. failed: Verification failed, address cannot be used
 *
 * Verification process:
 * - Merchants provide their wallet address for a specific blockchain network
 * - System sends a verification request (email link, test transaction, etc.)
 * - Merchant confirms ownership through the verification method
 * - Upon successful verification, address becomes active for payouts
 *
 * Multi-chain support:
 * - Each merchant can register addresses on multiple blockchain networks
 * - Supported networks: Ethereum (ETH), Bitcoin (BTC), TRON (TRX), Polygon (MATIC), etc.
 * - Each network has its own address format and validation rules
 * - Merchants can set an alias to easily identify different addresses
 *
 * Use cases:
 * - Receiving cryptocurrency payouts from the platform
 * - Withdrawing funds to personal or business wallets
 * - Setting up multi-network payout destinations
 * - Managing multiple addresses per network (with unique aliases)
 * - Automated payout routing based on currency/network
 *
 * Security features:
 * - Address ownership verification required before activation
 * - Verification status tracking and audit trail
 * - Cannot use unverified addresses for financial operations
 * - Address format validation per blockchain network
 * - Support for adding/updating addresses with re-verification
 */
public class MerchantAddress {
    /**
     * Unique identifier for the merchant address.
     * Format: addr_[random_id] or similar prefix
     * Used to reference this address in payout and withdrawal operations.
     */
    @SerializedName("id")
    private String id;

    /**
     * ID of the merchant who owns this address.
     * Links the address to a specific merchant account.
     * Format: merch_[random_id] or similar prefix
     */
    @SerializedName("merchant_id")
    private String merchantID;

    /**
     * Blockchain network for this address.
     * Identifies which blockchain this address belongs to.
     *
     * Common values:
     * - "ETH" - Ethereum
     * - "BTC" - Bitcoin
     * - "TRX" - TRON
     * - "MATIC" - Polygon
     * - "BSC" - Binance Smart Chain
     * - "SOL" - Solana
     *
     * The network determines:
     * - Address format and validation rules
     * - Supported cryptocurrencies on this address
     * - Transaction fees and confirmation times
     * - Compatible tokens (e.g., ERC-20 for Ethereum)
     */
    @SerializedName("network")
    private String network;

    /**
     * The actual blockchain wallet address.
     * This is the public address where funds will be sent.
     *
     * Format varies by network:
     * - Ethereum: Starts with "0x", 42 characters (e.g., 0x742d35Cc6634C0532925a3b844Bc9e7595f0bEb2)
     * - Bitcoin: Starts with 1, 3, or bc1 (e.g., 1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa)
     * - TRON: Starts with "T", 34 characters (e.g., TN3W4H6rK2ce4vX9YnFQHwKENnHjoxb3m9)
     *
     * This address must:
     * - Be valid for the specified network
     * - Be under merchant's control
     * - Pass verification before use in payouts
     */
    @SerializedName("address")
    private String address;

    /**
     * Reference ID to the address verification record.
     * Links to detailed verification information and history.
     * Format: verify_[random_id]
     * Used to track the verification process and results.
     */
    @SerializedName("verification_id")
    private String verificationID;

    /**
     * Current status of the address in the verification lifecycle.
     *
     * Possible values:
     * - "created": Address registered but verification not started
     * - "verifying": Verification process is in progress
     * - "success": Address verified and active for use
     * - "failed": Verification failed, address cannot be used
     *
     * Only addresses with "success" status can be used for payouts and withdrawals.
     * Failed addresses can be re-verified or replaced with new addresses.
     */
    @SerializedName("status")
    private String status;

    /**
     * User-defined name or label for this address.
     * Helps merchants identify and manage multiple addresses.
     *
     * Examples:
     * - "Main Business Wallet"
     * - "Cold Storage"
     * - "ETH Payouts"
     * - "BTC Reserves"
     *
     * Benefits:
     * - Easy identification in payout configurations
     * - Better organization of multiple addresses
     * - Clearer audit trails and reporting
     * - Simplified address selection in UI
     */
    @SerializedName("alias")
    private String alias;

    /**
     * Unix timestamp (in seconds) when the address was first created.
     * Records when the merchant registered this address in the system.
     */
    @SerializedName("created_at")
    private Long createdAt;

    /**
     * Unix timestamp (in seconds) when the address was last updated.
     * Updates when address details change or verification status is modified.
     */
    @SerializedName("updated_at")
    private Long updatedAt;

    /**
     * Detailed verification information for this address.
     * Contains the verification method, status, timestamps, and any failure reasons.
     * Provides complete audit trail of the verification process.
     * See AddressVerification for detailed structure.
     */
    @SerializedName("verification")
    private AddressVerification verification;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getMerchantID() { return merchantID; }
    public void setMerchantID(String merchantID) { this.merchantID = merchantID; }

    public String getNetwork() { return network; }
    public void setNetwork(String network) { this.network = network; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getVerificationID() { return verificationID; }
    public void setVerificationID(String verificationID) { this.verificationID = verificationID; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getAlias() { return alias; }
    public void setAlias(String alias) { this.alias = alias; }

    public Long getCreatedAt() { return createdAt; }
    public void setCreatedAt(Long createdAt) { this.createdAt = createdAt; }

    public Long getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Long updatedAt) { this.updatedAt = updatedAt; }

    public AddressVerification getVerification() { return verification; }
    public void setVerification(AddressVerification verification) { this.verification = verification; }
}
