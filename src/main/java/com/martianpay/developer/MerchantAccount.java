package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.security.SecureRandom;

/**
 * MerchantAccount represents a merchant's payout account (bank or wallet)
 */
public class MerchantAccount {
    public static final String MERCHANT_ACCOUNT_TYPE_WALLET = "wallet";
    public static final String MERCHANT_ACCOUNT_TYPE_BANK = "bank";

    public static final String MERCHANT_ACCOUNT_OBJECT = "merchant_account";
    public static final String MERCHANT_ACCOUNT_PREFIX = "ma_";
    public static final int MERCHANT_ACCOUNT_ID_LENGTH = 24;

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom RANDOM = new SecureRandom();

    /**
     * ID is the unique identifier for the merchant account
     */
    @SerializedName("id")
    private String id;

    /**
     * Object is the type identifier, always "merchant_account"
     */
    @SerializedName("object")
    private String object;

    /**
     * CreatedAt is the Unix timestamp when the account was created
     */
    @SerializedName("created_at")
    private Long createdAt;

    /**
     * AccountType is the type of account ("wallet" or "bank")
     */
    @SerializedName("account_type")
    private String accountType;

    /**
     * Alias is the user-defined name for this account
     */
    @SerializedName("alias")
    private String alias;

    /**
     * IsDefault indicates whether this is the default payout account
     */
    @SerializedName("is_default")
    private Boolean isDefault;

    /**
     * AccountStatus is the current status of the account
     */
    @SerializedName("account_status")
    private String accountStatus;

    /**
     * BankAccount contains bank account details (only for bank account type)
     */
    @SerializedName("bank_account")
    private BankAccount bankAccount;

    public MerchantAccount() {
    }

    public static String generateMerchantAccountId() {
        return MERCHANT_ACCOUNT_PREFIX + generateRandomString(MERCHANT_ACCOUNT_ID_LENGTH);
    }

    private static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }

    // Getters and Setters
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

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
}
