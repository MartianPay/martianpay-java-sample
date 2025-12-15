package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * AddressVerification represents a verification record for a merchant's address
 */
public class AddressVerification {
    @SerializedName("id")
    private String id;

    @SerializedName("status")
    private String status;

    @SerializedName("merchant_address_id")
    private String merchantAddressID;

    @SerializedName("asset_id")
    private String assetID;

    @SerializedName("verified_at")
    private Long verifiedAt;

    @SerializedName("tried_times")
    private Integer triedTimes;

    @SerializedName("aml_status")
    private String amlStatus;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getMerchantAddressID() { return merchantAddressID; }
    public void setMerchantAddressID(String merchantAddressID) { this.merchantAddressID = merchantAddressID; }

    public String getAssetID() { return assetID; }
    public void setAssetID(String assetID) { this.assetID = assetID; }

    public Long getVerifiedAt() { return verifiedAt; }
    public void setVerifiedAt(Long verifiedAt) { this.verifiedAt = verifiedAt; }

    public Integer getTriedTimes() { return triedTimes; }
    public void setTriedTimes(Integer triedTimes) { this.triedTimes = triedTimes; }

    public String getAmlStatus() { return amlStatus; }
    public void setAmlStatus(String amlStatus) { this.amlStatus = amlStatus; }
}
