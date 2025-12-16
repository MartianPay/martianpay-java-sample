package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

/**
 * Parameters for creating or updating a merchant contract.
 */
public class MerchantContractParams {
    /**
     * Legal business name of the merchant.
     */
    @SerializedName("name")
    private String name;

    /**
     * Description of the merchant's business.
     */
    @SerializedName("description")
    private String description;

    /**
     * Primary email address for contract communications.
     */
    @SerializedName("email")
    private String email;

    /**
     * Primary phone number for the merchant business.
     */
    @SerializedName("phone")
    private String phone;

    /**
     * Company registration number or business license number.
     */
    @SerializedName("company_number")
    private String companyNumber;

    /**
     * Name of the legal representative or authorized signatory.
     */
    @SerializedName("legal_person")
    private String legalPerson;

    /**
     * Bank account number for settlement payments.
     */
    @SerializedName("bank_account")
    private String bankAccount;

    /**
     * Name of the bank where the settlement account is held.
     */
    @SerializedName("bank_name")
    private String bankName;

    /**
     * SWIFT/BIC code for international bank transfers.
     */
    @SerializedName("bank_swift_code")
    private String bankSwiftCode;

    /**
     * Country where the business is registered (ISO 3166-1 alpha-2 code).
     */
    @SerializedName("country")
    private String country;

    /**
     * Physical business address.
     */
    @SerializedName("address")
    private String address;

    /**
     * Tax identification number (TIN/EIN/VAT number).
     */
    @SerializedName("tax_number")
    private String taxNumber;

    /**
     * Custom metadata for additional contract information.
     */
    @SerializedName("metadata")
    private Map<String, String> metadata;

    /**
     * Unix timestamp (in seconds) when the contract expires.
     */
    @SerializedName("expires_at")
    private Long expiresAt;

    public MerchantContractParams() {
    }

    /**
     * Gets the legal business name.
     * @return The business name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the legal business name.
     * @param name The business name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the business description.
     * @return The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the business description.
     * @param description The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the primary email address.
     * @return The email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the primary email address.
     * @param email The email address
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the primary phone number.
     * @return The phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the primary phone number.
     * @param phone The phone number
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets the company registration number.
     * @return The company number
     */
    public String getCompanyNumber() {
        return companyNumber;
    }

    /**
     * Sets the company registration number.
     * @param companyNumber The company number
     */
    public void setCompanyNumber(String companyNumber) {
        this.companyNumber = companyNumber;
    }

    /**
     * Gets the name of the legal representative.
     * @return The legal person name
     */
    public String getLegalPerson() {
        return legalPerson;
    }

    /**
     * Sets the name of the legal representative.
     * @param legalPerson The legal person name
     */
    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    /**
     * Gets the bank account number.
     * @return The bank account number
     */
    public String getBankAccount() {
        return bankAccount;
    }

    /**
     * Sets the bank account number.
     * @param bankAccount The bank account number
     */
    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    /**
     * Gets the bank name.
     * @return The bank name
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * Sets the bank name.
     * @param bankName The bank name
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * Gets the bank SWIFT/BIC code.
     * @return The SWIFT code
     */
    public String getBankSwiftCode() {
        return bankSwiftCode;
    }

    /**
     * Sets the bank SWIFT/BIC code.
     * @param bankSwiftCode The SWIFT code
     */
    public void setBankSwiftCode(String bankSwiftCode) {
        this.bankSwiftCode = bankSwiftCode;
    }

    /**
     * Gets the country code.
     * @return The country code
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the country code.
     * @param country The country code
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets the physical business address.
     * @return The address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the physical business address.
     * @param address The address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the tax identification number.
     * @return The tax number
     */
    public String getTaxNumber() {
        return taxNumber;
    }

    /**
     * Sets the tax identification number.
     * @param taxNumber The tax number
     */
    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    /**
     * Gets the custom metadata.
     * @return The metadata map
     */
    public Map<String, String> getMetadata() {
        return metadata;
    }

    /**
     * Sets the custom metadata.
     * @param metadata The metadata map
     */
    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    /**
     * Gets the expiration timestamp.
     * @return The expiration timestamp in seconds
     */
    public Long getExpiresAt() {
        return expiresAt;
    }

    /**
     * Sets the expiration timestamp.
     * @param expiresAt The expiration timestamp in seconds
     */
    public void setExpiresAt(Long expiresAt) {
        this.expiresAt = expiresAt;
    }
}
