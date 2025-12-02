package com.martianpay.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Represents a payroll in the MartianPay system.
 * Payrolls are used for batch cryptocurrency payments to employees or recipients.
 */
public class Payroll {
    @SerializedName("id")
    private String id;

    @SerializedName("created_at")
    private Long createdAt;

    @SerializedName("updated_at")
    private Long updatedAt;

    @SerializedName("canceled_at")
    private Long canceledAt;

    @SerializedName("merchant_id")
    private String merchantId;

    @SerializedName("external_id")
    private String externalId;

    @SerializedName("approval_status")
    private String approvalStatus;

    @SerializedName("status")
    private String status;

    @SerializedName("total_item_num")
    private Long totalItemNum;

    @SerializedName("total_amount")
    private String totalAmount;

    @SerializedName("total_service_fee")
    private String totalServiceFee;

    @SerializedName("currency")
    private String currency;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Long getCanceledAt() {
        return canceledAt;
    }

    public void setCanceledAt(Long canceledAt) {
        this.canceledAt = canceledAt;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getTotalItemNum() {
        return totalItemNum;
    }

    public void setTotalItemNum(Long totalItemNum) {
        this.totalItemNum = totalItemNum;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getTotalServiceFee() {
        return totalServiceFee;
    }

    public void setTotalServiceFee(String totalServiceFee) {
        this.totalServiceFee = totalServiceFee;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * Represents a single payroll item (recipient)
     */
    public static class PayrollItem {
        @SerializedName("id")
        private String id;

        @SerializedName("created_at")
        private Long createdAt;

        @SerializedName("updated_at")
        private Long updatedAt;

        @SerializedName("payroll_id")
        private String payrollId;

        @SerializedName("payroll")
        private Payroll payroll;

        @SerializedName("external_id")
        private String externalId;

        @SerializedName("name")
        private String name;

        @SerializedName("email")
        private String email;

        @SerializedName("phone")
        private String phone;

        @SerializedName("amount")
        private String amount;

        @SerializedName("service_fee")
        private String serviceFee;

        @SerializedName("exchange_rate_to_usd")
        private String exchangeRateToUsd;

        @SerializedName("coin")
        private String coin;

        @SerializedName("network")
        private String network;

        @SerializedName("asset_id")
        private String assetId;

        @SerializedName("address")
        private String address;

        @SerializedName("address_verified")
        private Boolean addressVerified;

        @SerializedName("status")
        private String status;

        @SerializedName("transactions")
        private List<Refund.TransactionDetails> transactions;

        @SerializedName("validation")
        private PayrollValidation validation;

        @SerializedName("differences")
        private PayrollDifference differences;

        @SerializedName("has_monthly_payment")
        private Boolean hasMonthlyPayment;

        @SerializedName("payment_method")
        private String paymentMethod;

        @SerializedName("is_binance")
        private Boolean isBinance;

        @SerializedName("binance_tag")
        private String binanceTag;

        @SerializedName("binance_task_id")
        private String binanceTaskId;

        @SerializedName("aml_info")
        private String amlInfo;

        @SerializedName("tx_id")
        private String txId;

        // Getters and Setters
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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

        public String getPayrollId() {
            return payrollId;
        }

        public void setPayrollId(String payrollId) {
            this.payrollId = payrollId;
        }

        public Payroll getPayroll() {
            return payroll;
        }

        public void setPayroll(Payroll payroll) {
            this.payroll = payroll;
        }

        public String getExternalId() {
            return externalId;
        }

        public void setExternalId(String externalId) {
            this.externalId = externalId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
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

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getServiceFee() {
            return serviceFee;
        }

        public void setServiceFee(String serviceFee) {
            this.serviceFee = serviceFee;
        }

        public String getExchangeRateToUsd() {
            return exchangeRateToUsd;
        }

        public void setExchangeRateToUsd(String exchangeRateToUsd) {
            this.exchangeRateToUsd = exchangeRateToUsd;
        }

        public String getCoin() {
            return coin;
        }

        public void setCoin(String coin) {
            this.coin = coin;
        }

        public String getNetwork() {
            return network;
        }

        public void setNetwork(String network) {
            this.network = network;
        }

        public String getAssetId() {
            return assetId;
        }

        public void setAssetId(String assetId) {
            this.assetId = assetId;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public Boolean getAddressVerified() {
            return addressVerified;
        }

        public void setAddressVerified(Boolean addressVerified) {
            this.addressVerified = addressVerified;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public List<Refund.TransactionDetails> getTransactions() {
            return transactions;
        }

        public void setTransactions(List<Refund.TransactionDetails> transactions) {
            this.transactions = transactions;
        }

        public PayrollValidation getValidation() {
            return validation;
        }

        public void setValidation(PayrollValidation validation) {
            this.validation = validation;
        }

        public PayrollDifference getDifferences() {
            return differences;
        }

        public void setDifferences(PayrollDifference differences) {
            this.differences = differences;
        }

        public Boolean getHasMonthlyPayment() {
            return hasMonthlyPayment;
        }

        public void setHasMonthlyPayment(Boolean hasMonthlyPayment) {
            this.hasMonthlyPayment = hasMonthlyPayment;
        }

        public String getPaymentMethod() {
            return paymentMethod;
        }

        public void setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
        }

        public Boolean getIsBinance() {
            return isBinance;
        }

        public void setIsBinance(Boolean isBinance) {
            this.isBinance = isBinance;
        }

        public String getBinanceTag() {
            return binanceTag;
        }

        public void setBinanceTag(String binanceTag) {
            this.binanceTag = binanceTag;
        }

        public String getBinanceTaskId() {
            return binanceTaskId;
        }

        public void setBinanceTaskId(String binanceTaskId) {
            this.binanceTaskId = binanceTaskId;
        }

        public String getAmlInfo() {
            return amlInfo;
        }

        public void setAmlInfo(String amlInfo) {
            this.amlInfo = amlInfo;
        }

        public String getTxId() {
            return txId;
        }

        public void setTxId(String txId) {
            this.txId = txId;
        }
    }

    /**
     * Payroll validation status
     */
    public static class PayrollValidation {
        @SerializedName("name_valid")
        private Boolean nameValid;

        @SerializedName("email_valid")
        private Boolean emailValid;

        @SerializedName("phone_valid")
        private Boolean phoneValid;

        @SerializedName("amount_valid")
        private Boolean amountValid;

        @SerializedName("coin_valid")
        private Boolean coinValid;

        @SerializedName("network_valid")
        private Boolean networkValid;

        @SerializedName("address_valid")
        private Boolean addressValid;

        @SerializedName("balance_enough")
        private Boolean balanceEnough;

        public Boolean getNameValid() {
            return nameValid;
        }

        public void setNameValid(Boolean nameValid) {
            this.nameValid = nameValid;
        }

        public Boolean getEmailValid() {
            return emailValid;
        }

        public void setEmailValid(Boolean emailValid) {
            this.emailValid = emailValid;
        }

        public Boolean getPhoneValid() {
            return phoneValid;
        }

        public void setPhoneValid(Boolean phoneValid) {
            this.phoneValid = phoneValid;
        }

        public Boolean getAmountValid() {
            return amountValid;
        }

        public void setAmountValid(Boolean amountValid) {
            this.amountValid = amountValid;
        }

        public Boolean getCoinValid() {
            return coinValid;
        }

        public void setCoinValid(Boolean coinValid) {
            this.coinValid = coinValid;
        }

        public Boolean getNetworkValid() {
            return networkValid;
        }

        public void setNetworkValid(Boolean networkValid) {
            this.networkValid = networkValid;
        }

        public Boolean getAddressValid() {
            return addressValid;
        }

        public void setAddressValid(Boolean addressValid) {
            this.addressValid = addressValid;
        }

        public Boolean getBalanceEnough() {
            return balanceEnough;
        }

        public void setBalanceEnough(Boolean balanceEnough) {
            this.balanceEnough = balanceEnough;
        }

        public boolean isWalletInfoValid() {
            return Boolean.TRUE.equals(amountValid) && Boolean.TRUE.equals(coinValid) &&
                   Boolean.TRUE.equals(networkValid) && Boolean.TRUE.equals(addressValid);
        }
    }

    /**
     * Payroll difference tracking
     */
    public static class PayrollDifference {
        @SerializedName("name")
        private PayrollDifferenceField name;

        @SerializedName("email")
        private PayrollDifferenceField email;

        @SerializedName("phone")
        private PayrollDifferenceField phone;

        @SerializedName("amount")
        private PayrollDifferenceField amount;

        @SerializedName("coin")
        private PayrollDifferenceField coin;

        @SerializedName("network")
        private PayrollDifferenceField network;

        @SerializedName("address")
        private PayrollDifferenceField address;

        public PayrollDifferenceField getName() {
            return name;
        }

        public void setName(PayrollDifferenceField name) {
            this.name = name;
        }

        public PayrollDifferenceField getEmail() {
            return email;
        }

        public void setEmail(PayrollDifferenceField email) {
            this.email = email;
        }

        public PayrollDifferenceField getPhone() {
            return phone;
        }

        public void setPhone(PayrollDifferenceField phone) {
            this.phone = phone;
        }

        public PayrollDifferenceField getAmount() {
            return amount;
        }

        public void setAmount(PayrollDifferenceField amount) {
            this.amount = amount;
        }

        public PayrollDifferenceField getCoin() {
            return coin;
        }

        public void setCoin(PayrollDifferenceField coin) {
            this.coin = coin;
        }

        public PayrollDifferenceField getNetwork() {
            return network;
        }

        public void setNetwork(PayrollDifferenceField network) {
            this.network = network;
        }

        public PayrollDifferenceField getAddress() {
            return address;
        }

        public void setAddress(PayrollDifferenceField address) {
            this.address = address;
        }
    }

    /**
     * Individual field difference
     */
    public static class PayrollDifferenceField {
        @SerializedName("previous")
        private String previous;

        @SerializedName("current")
        private String current;

        @SerializedName("status")
        private String status;

        public String getPrevious() {
            return previous;
        }

        public void setPrevious(String previous) {
            this.previous = previous;
        }

        public String getCurrent() {
            return current;
        }

        public void setCurrent(String current) {
            this.current = current;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

    /**
     * Payroll swap items for currency conversion
     */
    public static class PayrollSwapItem {
        @SerializedName("id")
        private String id;

        @SerializedName("lifi_quote_id")
        private String lifiQuoteId;

        @SerializedName("created_at")
        private Long createdAt;

        @SerializedName("updated_at")
        private Long updatedAt;

        @SerializedName("sent_at")
        private Long sentAt;

        @SerializedName("merchant_id")
        private String merchantId;

        @SerializedName("payroll_id")
        private String payrollId;

        @SerializedName("payroll")
        private Payroll payroll;

        @SerializedName("from_asset_id")
        private String fromAssetId;

        @SerializedName("expected_from_amount")
        private String expectedFromAmount;

        @SerializedName("estimated_from_amount")
        private String estimatedFromAmount;

        @SerializedName("estimated_from_amount_usd")
        private String estimatedFromAmountUsd;

        @SerializedName("actual_from_amount")
        private String actualFromAmount;

        @SerializedName("network_fee")
        private String networkFee;

        @SerializedName("to_asset_id")
        private String toAssetId;

        @SerializedName("expected_to_amount")
        private String expectedToAmount;

        @SerializedName("estimated_to_amount")
        private String estimatedToAmount;

        @SerializedName("estimated_to_amount_min")
        private String estimatedToAmountMin;

        @SerializedName("estimated_to_amount_usd")
        private String estimatedToAmountUsd;

        @SerializedName("actual_to_amount")
        private String actualToAmount;

        @SerializedName("status")
        private String status;

        // Getters and Setters (省略以节省空间,但实际应包含所有字段的getter/setter)
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
    }
}
