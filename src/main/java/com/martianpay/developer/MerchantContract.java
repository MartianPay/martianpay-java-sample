package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.security.SecureRandom;
import java.util.Map;

public class MerchantContract {
    public static final String MERCHANT_CONTRACT_STATUS_PENDING = "pending";
    public static final String MERCHANT_CONTRACT_STATUS_ACTIVE = "active";
    public static final String MERCHANT_CONTRACT_STATUS_REJECTED = "rejected";
    public static final String MERCHANT_CONTRACT_STATUS_TERMINATED = "terminated";

    public static final int MERCHANT_CONTRACT_ID_LENGTH = 24;
    public static final String MERCHANT_CONTRACT_ID_PREFIX = "mc_";
    public static final String MERCHANT_CONTRACT_OBJECT = "merchant_contract";

    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final SecureRandom RANDOM = new SecureRandom();

    @SerializedName("id")
    private String id;

    @SerializedName("object")
    private String object;

    @SerializedName("merchant_id")
    private String merchantId;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("email")
    private String email;

    @SerializedName("phone")
    private String phone;

    @SerializedName("company_number")
    private String companyNumber;

    @SerializedName("legal_person")
    private String legalPerson;

    @SerializedName("bank_account")
    private String bankAccount;

    @SerializedName("bank_name")
    private String bankName;

    @SerializedName("bank_swift_code")
    private String bankSwiftCode;

    @SerializedName("country")
    private String country;

    @SerializedName("address")
    private String address;

    @SerializedName("tax_number")
    private String taxNumber;

    @SerializedName("metadata")
    private Map<String, String> metadata;

    @SerializedName("status")
    private String status;

    @SerializedName("created")
    private Long created;

    @SerializedName("deleted")
    private Boolean deleted;

    @SerializedName("expires_at")
    private Long expiresAt;

    @SerializedName("fee_rate")
    private Long feeRate;

    @SerializedName("fixed_fee")
    private Long fixedFee;

    @SerializedName("reason")
    private String reason;

    @SerializedName("livemode")
    private Boolean livemode;

    public MerchantContract() {
    }

    public static String generateMerchantContractId() {
        return MERCHANT_CONTRACT_ID_PREFIX + generateRandomString(MERCHANT_CONTRACT_ID_LENGTH);
    }

    private static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(String companyNumber) {
        this.companyNumber = companyNumber;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankSwiftCode() {
        return bankSwiftCode;
    }

    public void setBankSwiftCode(String bankSwiftCode) {
        this.bankSwiftCode = bankSwiftCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Long getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Long expiresAt) {
        this.expiresAt = expiresAt;
    }

    public Long getFeeRate() {
        return feeRate;
    }

    public void setFeeRate(Long feeRate) {
        this.feeRate = feeRate;
    }

    public Long getFixedFee() {
        return fixedFee;
    }

    public void setFixedFee(Long fixedFee) {
        this.fixedFee = fixedFee;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Boolean getLivemode() {
        return livemode;
    }

    public void setLivemode(Boolean livemode) {
        this.livemode = livemode;
    }
}
