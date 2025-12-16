package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * AddressVerification represents the verification record for a merchant's blockchain address.
 *
 * When a merchant provides a cryptocurrency withdrawal address, it must undergo verification
 * to ensure:
 * - The address is valid and properly formatted for the blockchain network
 * - The address passes Anti-Money Laundering (AML) screening
 * - The merchant has control/ownership of the address
 *
 * Verification process:
 * 1. Pending - Address submitted for verification
 * 2. Verifying - System is checking address validity and AML status
 * 3. Verified - Address passed all checks and can be used for withdrawals
 * 4. Failed - Verification failed (invalid format, AML issues, or ownership proof failed)
 *
 * Key features:
 * - Automatic validation of address format for different blockchain networks
 * - AML screening against known risky addresses
 * - Support for multiple verification attempts if initial verification fails
 * - Tracking of verification timestamp for audit purposes
 *
 * Use cases:
 * - Merchant withdrawal address verification before payouts
 * - Compliance with AML/KYC requirements
 * - Prevention of fraudulent or high-risk addresses
 * - Audit trail for address verification history
 */
public class AddressVerification {
    /**
     * Unique identifier for this address verification record.
     * Format: verification_[random_id]
     */
    @SerializedName("id")
    private String id;

    /**
     * Current status of the address verification.
     * Possible values: "pending", "verifying", "verified", "failed"
     */
    @SerializedName("status")
    private String status;

    /**
     * ID of the merchant address being verified.
     * Links this verification to a specific merchant blockchain address.
     */
    @SerializedName("merchant_address_id")
    private String merchantAddressID;

    /**
     * ID of the cryptocurrency asset associated with this address.
     * Specifies which blockchain network and token this address is for.
     * Example: "USDC_ETH", "BTC_BTC"
     */
    @SerializedName("asset_id")
    private String assetID;

    /**
     * Unix timestamp (in seconds) when the address was successfully verified.
     * Null if verification is still pending or failed.
     */
    @SerializedName("verified_at")
    private Long verifiedAt;

    /**
     * Number of verification attempts made for this address.
     * Increments each time verification is retried after a failure.
     * Used to limit retry attempts and flag problematic addresses.
     */
    @SerializedName("tried_times")
    private Integer triedTimes;

    /**
     * Anti-Money Laundering (AML) screening status for this address.
     * Possible values:
     * - "clean" - Address passed AML screening
     * - "risky" - Address flagged as potentially risky
     * - "blocked" - Address blocked due to AML concerns
     * - "pending" - AML screening in progress
     */
    @SerializedName("aml_status")
    private String amlStatus;

    // Getters and Setters

    /**
     * Gets the unique identifier for this verification record.
     * @return The verification ID
     */
    public String getId() { return id; }

    /**
     * Sets the unique identifier for this verification record.
     * @param id The verification ID
     */
    public void setId(String id) { this.id = id; }

    /**
     * Gets the current verification status.
     * @return The verification status
     */
    public String getStatus() { return status; }

    /**
     * Sets the current verification status.
     * @param status The verification status
     */
    public void setStatus(String status) { this.status = status; }

    /**
     * Gets the merchant address ID being verified.
     * @return The merchant address ID
     */
    public String getMerchantAddressID() { return merchantAddressID; }

    /**
     * Sets the merchant address ID being verified.
     * @param merchantAddressID The merchant address ID
     */
    public void setMerchantAddressID(String merchantAddressID) { this.merchantAddressID = merchantAddressID; }

    /**
     * Gets the cryptocurrency asset ID for this address.
     * @return The asset ID
     */
    public String getAssetID() { return assetID; }

    /**
     * Sets the cryptocurrency asset ID for this address.
     * @param assetID The asset ID
     */
    public void setAssetID(String assetID) { this.assetID = assetID; }

    /**
     * Gets the Unix timestamp when verification completed.
     * @return Verification timestamp in seconds, or null if not yet verified
     */
    public Long getVerifiedAt() { return verifiedAt; }

    /**
     * Sets the Unix timestamp when verification completed.
     * @param verifiedAt Verification timestamp in seconds
     */
    public void setVerifiedAt(Long verifiedAt) { this.verifiedAt = verifiedAt; }

    /**
     * Gets the number of verification attempts made.
     * @return Number of attempts
     */
    public Integer getTriedTimes() { return triedTimes; }

    /**
     * Sets the number of verification attempts made.
     * @param triedTimes Number of attempts
     */
    public void setTriedTimes(Integer triedTimes) { this.triedTimes = triedTimes; }

    /**
     * Gets the AML screening status for this address.
     * @return The AML status
     */
    public String getAmlStatus() { return amlStatus; }

    /**
     * Sets the AML screening status for this address.
     * @param amlStatus The AML status
     */
    public void setAmlStatus(String amlStatus) { this.amlStatus = amlStatus; }
}
