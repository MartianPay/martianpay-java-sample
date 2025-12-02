package com.martianpay.model;

import com.google.gson.annotations.SerializedName;

/**
 * Represents a merchant's blockchain address for withdrawals.
 */
public class MerchantAddress {
    @SerializedName("id")
    private String id;

    @SerializedName("merchant_id")
    private String merchantId;

    @SerializedName("network")
    private String network;

    @SerializedName("address")
    private String address;

    @SerializedName("verification_id")
    private String verificationId;

    @SerializedName("status")
    private String status;

    @SerializedName("alias")
    private String alias;

    @SerializedName("created_at")
    private Long createdAt;

    @SerializedName("updated_at")
    private Long updatedAt;

    @SerializedName("verification")
    private AddressVerification verification;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getVerificationId() {
        return verificationId;
    }

    public void setVerificationId(String verificationId) {
        this.verificationId = verificationId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public AddressVerification getVerification() {
        return verification;
    }

    public void setVerification(AddressVerification verification) {
        this.verification = verification;
    }

    /**
     * Address verification details
     */
    public static class AddressVerification {
        @SerializedName("id")
        private String id;

        @SerializedName("status")
        private String status;

        @SerializedName("merchant_address_id")
        private String merchantAddressId;

        @SerializedName("asset_id")
        private String assetId;

        @SerializedName("verified_at")
        private Long verifiedAt;

        @SerializedName("tried_times")
        private Integer triedTimes;

        @SerializedName("aml_status")
        private String amlStatus;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getMerchantAddressId() {
            return merchantAddressId;
        }

        public void setMerchantAddressId(String merchantAddressId) {
            this.merchantAddressId = merchantAddressId;
        }

        public String getAssetId() {
            return assetId;
        }

        public void setAssetId(String assetId) {
            this.assetId = assetId;
        }

        public Long getVerifiedAt() {
            return verifiedAt;
        }

        public void setVerifiedAt(Long verifiedAt) {
            this.verifiedAt = verifiedAt;
        }

        public Integer getTriedTimes() {
            return triedTimes;
        }

        public void setTriedTimes(Integer triedTimes) {
            this.triedTimes = triedTimes;
        }

        public String getAmlStatus() {
            return amlStatus;
        }

        public void setAmlStatus(String amlStatus) {
            this.amlStatus = amlStatus;
        }
    }
}
