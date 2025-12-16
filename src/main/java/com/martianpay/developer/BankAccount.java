package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Bank account details for fiat currency payouts and withdrawals.
 * Supports domestic and international transfers via SWIFT/BIC codes.
 */
public class BankAccount {
    /**
     * Name of the bank account holder.
     */
    @SerializedName("account_holder_name")
    private String accountHolderName;

    /**
     * Name of the bank or financial institution.
     */
    @SerializedName("bank_name")
    private String bankName;

    /**
     * Name of the specific bank branch (optional).
     */
    @SerializedName("branch_name")
    private String branchName;

    /**
     * SWIFT/BIC code for international wire transfers.
     */
    @SerializedName("swift_code")
    private String swiftCode;

    /**
     * Bank account number or IBAN.
     */
    @SerializedName("account_number")
    private String accountNumber;

    /**
     * Constructs an empty BankAccount.
     */
    public BankAccount() {
    }

    /**
     * Gets the account holder name.
     * @return The name of the account holder
     */
    public String getAccountHolderName() {
        return accountHolderName;
    }

    /**
     * Sets the account holder name.
     * @param accountHolderName The name of the account holder
     */
    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    /**
     * Gets the bank name.
     * @return The name of the bank
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * Sets the bank name.
     * @param bankName The name of the bank
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * Gets the branch name.
     * @return The name of the bank branch, or null if not specified
     */
    public String getBranchName() {
        return branchName;
    }

    /**
     * Sets the branch name.
     * @param branchName The name of the bank branch
     */
    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    /**
     * Gets the SWIFT/BIC code.
     * @return The SWIFT/BIC code, or null for domestic-only accounts
     */
    public String getSwiftCode() {
        return swiftCode;
    }

    /**
     * Sets the SWIFT/BIC code.
     * @param swiftCode The SWIFT/BIC code
     */
    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

    /**
     * Gets the account number.
     * @return The bank account number or IBAN
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the account number.
     * @param accountNumber The bank account number or IBAN
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
