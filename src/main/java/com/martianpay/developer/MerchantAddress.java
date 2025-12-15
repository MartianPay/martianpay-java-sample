package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * MerchantAddress represents a merchant's blockchain address
 */
public class MerchantAddress {
    /**
     * ID is the unique identifier for the merchant address
     */
    @SerializedName("id")
    private String id;

    /**
     * MerchantID is the ID of the merchant who owns this address
     */
    @SerializedName("merchant_id")
    private String merchantID;

    /**
     * Network is the blockchain network (e.g., ETH, BTC)
     */
    @SerializedName("network")
    private String network;

    /**
     * Address is the actual blockchain address
     */
    @SerializedName("address")
    private String address;

    /**
     * VerificationID is the reference to the verification record ID
     */
    @SerializedName("verification_id")
    private String verificationID;

    /**
     * Status is the current status of the address (created, verifying, success, failed)
     */
    @SerializedName("status")
    private String status;

    /**
     * Alias is the user-defined name for this address
     */
    @SerializedName("alias")
    private String alias;

    /**
     * CreatedAt is the Unix timestamp when the address was created
     */
    @SerializedName("created_at")
    private Long createdAt;

    /**
     * UpdatedAt is the Unix timestamp when the address was last updated
     */
    @SerializedName("updated_at")
    private Long updatedAt;

    /**
     * Verification contains nested verification details
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
