package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.security.SecureRandom;
import java.util.Map;

/**
 * MerchantContract represents a formal agreement between MartianPay and a merchant.
 *
 * Merchant contracts define the terms of service, fee structure, and business relationship
 * between the payment processor and the merchant. Contracts must be reviewed and approved
 * before merchants can begin processing live transactions.
 *
 * Contract lifecycle:
 * 1. pending: Contract created, awaiting merchant submission or platform review
 * 2. active: Contract approved and in effect, merchant can process payments
 * 3. rejected: Contract declined, merchant must revise and resubmit
 * 4. terminated: Contract ended, merchant cannot process new transactions
 *
 * Contract contents:
 * - Business information: Legal entity details, registration numbers, tax information
 * - Contact information: Email, phone, physical address
 * - Banking details: For settlement of funds to merchant
 * - Fee structure: Processing fees and rates
 * - Terms and conditions: Legal agreements and compliance requirements
 * - Expiration date: Contract validity period
 *
 * Fee structure:
 * - fee_rate: Percentage-based fee per transaction (in basis points, 100 = 1%)
 * - fixed_fee: Fixed fee per transaction (in smallest currency unit)
 * - Example: 2.9% + $0.30 per transaction = fee_rate: 290, fixed_fee: 30
 *
 * Use cases:
 * - Merchant onboarding and KYC (Know Your Customer) process
 * - Compliance and regulatory requirements
 * - Fee negotiation and custom pricing
 * - Contract renewals and amendments
 * - Audit trail of business agreements
 * - Integration with external contract management systems via external_id
 *
 * Security and compliance:
 * - Contracts contain sensitive business information
 * - Must be stored securely and access controlled
 * - Support for metadata to track custom compliance requirements
 * - Deletion flag for soft deletes while maintaining audit trail
 */
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

    /**
     * Unique identifier for the merchant contract.
     * Format: mc_[24 random alphanumeric characters]
     */
    @SerializedName("id")
    private String id;

    /**
     * Type identifier, always "merchant_contract".
     */
    @SerializedName("object")
    private String object;

    /**
     * ID of the merchant this contract belongs to.
     * Links the contract to the merchant account.
     */
    @SerializedName("merchant_id")
    private String merchantId;

    /**
     * Legal business name of the merchant.
     * Official registered name used for legal and tax purposes.
     */
    @SerializedName("name")
    private String name;

    /**
     * Description of the merchant's business or this specific contract.
     * May include business type, products sold, or contract notes.
     */
    @SerializedName("description")
    private String description;

    /**
     * Primary email address for contract communications.
     * Used for contract notifications and legal correspondence.
     */
    @SerializedName("email")
    private String email;

    /**
     * Primary phone number for the merchant business.
     * Used for verification and emergency contact.
     */
    @SerializedName("phone")
    private String phone;

    /**
     * Company registration number or business license number.
     * Required for KYC and regulatory compliance.
     */
    @SerializedName("company_number")
    private String companyNumber;

    /**
     * Name of the legal representative or authorized signatory.
     * Person authorized to enter into contracts on behalf of the business.
     */
    @SerializedName("legal_person")
    private String legalPerson;

    /**
     * Bank account number for settlement payments.
     * Where funds from transactions will be deposited.
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
     * Required for cross-border settlements.
     */
    @SerializedName("bank_swift_code")
    private String bankSwiftCode;

    /**
     * Country where the business is registered.
     * ISO 3166-1 alpha-2 country code.
     * Used for regulatory compliance and tax purposes.
     */
    @SerializedName("country")
    private String country;

    /**
     * Physical business address.
     * Required for legal correspondence and compliance.
     */
    @SerializedName("address")
    private String address;

    /**
     * Tax identification number (TIN/EIN/VAT number).
     * Required for tax reporting and compliance.
     */
    @SerializedName("tax_number")
    private String taxNumber;

    /**
     * Custom metadata for additional contract information.
     * Key-value pairs for tracking custom attributes or integration data.
     */
    @SerializedName("metadata")
    private Map<String, String> metadata;

    /**
     * Current status of the contract.
     * Values: "pending", "active", "rejected", "terminated"
     */
    @SerializedName("status")
    private String status;

    /**
     * Unix timestamp (in seconds) when the contract was created.
     */
    @SerializedName("created")
    private Long created;

    /**
     * Soft delete flag indicating if the contract has been deleted.
     * True if deleted, false otherwise. Deleted contracts are retained for audit purposes.
     */
    @SerializedName("deleted")
    private Boolean deleted;

    /**
     * Unix timestamp (in seconds) when the contract expires.
     * After expiration, contract must be renewed for continued service.
     */
    @SerializedName("expires_at")
    private Long expiresAt;

    /**
     * Transaction fee rate as a percentage in basis points.
     * 100 basis points = 1%. Example: 290 = 2.9%
     * Applied as a percentage of each transaction amount.
     */
    @SerializedName("fee_rate")
    private Long feeRate;

    /**
     * Fixed fee per transaction in smallest currency unit.
     * Example: 30 = $0.30 for USD (Currently only USD is supported for fiat)
     * Added to each transaction regardless of amount.
     */
    @SerializedName("fixed_fee")
    private Long fixedFee;

    /**
     * Reason for contract rejection or termination.
     * Provides explanation when status is "rejected" or "terminated".
     * Null for active or pending contracts.
     */
    @SerializedName("reason")
    private String reason;

    /**
     * Indicates whether this is a live mode or test mode contract.
     * True for live mode (real transactions), false for test mode.
     */
    @SerializedName("livemode")
    private Boolean livemode;

    public MerchantContract() {
    }

    /**
     * Generates a new unique merchant contract ID.
     * @return A newly generated contract ID
     */
    public static String generateMerchantContractId() {
        return MERCHANT_CONTRACT_ID_PREFIX + generateRandomString(MERCHANT_CONTRACT_ID_LENGTH);
    }

    /**
     * Generates a random alphanumeric string of specified length.
     * @param length The length of the random string
     * @return A random alphanumeric string
     */
    private static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }

    /**
     * Gets the unique identifier for the contract.
     * @return The contract ID
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the contract.
     * @param id The contract ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the type identifier.
     * @return The object type
     */
    public String getObject() {
        return object;
    }

    /**
     * Sets the type identifier.
     * @param object The object type
     */
    public void setObject(String object) {
        this.object = object;
    }

    /**
     * Gets the merchant ID.
     * @return The merchant ID
     */
    public String getMerchantId() {
        return merchantId;
    }

    /**
     * Sets the merchant ID.
     * @param merchantId The merchant ID
     */
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
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
     * Gets the contract status.
     * @return The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the contract status.
     * @param status The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the creation timestamp.
     * @return The creation timestamp in seconds
     */
    public Long getCreated() {
        return created;
    }

    /**
     * Sets the creation timestamp.
     * @param created The creation timestamp in seconds
     */
    public void setCreated(Long created) {
        this.created = created;
    }

    /**
     * Gets the deleted flag.
     * @return True if deleted, false otherwise
     */
    public Boolean getDeleted() {
        return deleted;
    }

    /**
     * Sets the deleted flag.
     * @param deleted True if deleted, false otherwise
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
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

    /**
     * Gets the fee rate in basis points.
     * @return The fee rate
     */
    public Long getFeeRate() {
        return feeRate;
    }

    /**
     * Sets the fee rate in basis points.
     * @param feeRate The fee rate
     */
    public void setFeeRate(Long feeRate) {
        this.feeRate = feeRate;
    }

    /**
     * Gets the fixed fee per transaction.
     * @return The fixed fee
     */
    public Long getFixedFee() {
        return fixedFee;
    }

    /**
     * Sets the fixed fee per transaction.
     * @param fixedFee The fixed fee
     */
    public void setFixedFee(Long fixedFee) {
        this.fixedFee = fixedFee;
    }

    /**
     * Gets the rejection or termination reason.
     * @return The reason, or null if not applicable
     */
    public String getReason() {
        return reason;
    }

    /**
     * Sets the rejection or termination reason.
     * @param reason The reason
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * Gets whether this is a live mode contract.
     * @return True for live mode, false for test mode
     */
    public Boolean getLivemode() {
        return livemode;
    }

    /**
     * Sets whether this is a live mode contract.
     * @param livemode True for live mode, false for test mode
     */
    public void setLivemode(Boolean livemode) {
        this.livemode = livemode;
    }
}
