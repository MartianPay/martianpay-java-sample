package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * BankAccount represents bank account details for payouts
 */
public class BankAccount {
    /**
     * AccountHolderName is the name of the account holder
     */
    @SerializedName("account_holder_name")
    private String accountHolderName;

    /**
     * BankName is the name of the bank
     */
    @SerializedName("bank_name")
    private String bankName;

    /**
     * BranchName is the name of the bank branch
     */
    @SerializedName("branch_name")
    private String branchName;

    /**
     * SwiftCode is the SWIFT/BIC code for international transfers
     */
    @SerializedName("swift_code")
    private String swiftCode;

    /**
     * AccountNumber is the bank account number
     */
    @SerializedName("account_number")
    private String accountNumber;

    public BankAccount() {
    }

    // Getters and Setters
    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
