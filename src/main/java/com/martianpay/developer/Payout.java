package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.List;
import java.util.Map;

/**
 * Payout represents a payout transaction.
 *
 * Status lifecycle: pending -> in_swap (optional) -> in_transit -> paid/failed/canceled.
 * A payout is pending until submitted to the bank, then becomes in_transit. The status changes
 * to paid if successful, or to failed/canceled (within 5 business days). Some failed payouts
 * might initially show as paid, then change to failed.
 */
public class Payout {
    public static final String PAYOUT_ID_PREFIX = "payout_";
    public static final int PAYOUT_ID_LENGTH = 24;
    public static final String PAYOUT_OBJECT = "payout";

    public static final String STATUS_CANCELED = "canceled";
    public static final String STATUS_FAILED = "failed";
    public static final String STATUS_IN_SWAP = "in_swap";
    public static final String STATUS_IN_TRANSIT = "in_transit";
    public static final String STATUS_PAID = "paid";
    public static final String STATUS_PENDING = "pending";
    public static final String STATUS_APPROVED = "approved";
    public static final String STATUS_REJECTED = "rejected";

    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final SecureRandom RANDOM = new SecureRandom();

    /**
     * ID is the unique identifier for the payout
     */
    @SerializedName("id")
    private String id;

    /**
     * Object is the type of object, always "payout"
     */
    @SerializedName("object")
    private String object;

    /**
     * Livemode indicates whether this payout was created in live mode or test mode
     */
    @SerializedName("livemode")
    private Boolean livemode;

    /**
     * ArrivalDate is the date the payout is expected to arrive in the bank, factoring in delays for weekends or bank holidays
     */
    @SerializedName("arrival_date")
    private Long arrivalDate;

    /**
     * Automatic indicates whether the payout is created by an automated payout schedule (true) or requested manually (false)
     */
    @SerializedName("automatic")
    private Boolean automatic;

    /**
     * Transactions is the list of transactions associated with this payout
     */
    @SerializedName("transactions")
    private List<TransactionDetails> transactions;

    /**
     * Created is the Unix timestamp when the payout was created
     */
    @SerializedName("created")
    private Long created;

    /**
     * Updated is the Unix timestamp when the payout was last updated
     */
    @SerializedName("updated")
    private Long updated;

    /**
     * MerchantId is the ID of the merchant who owns this payout
     */
    @SerializedName("merchant_id")
    private String merchantId;

    /**
     * SourceAmount is the original amount to be paid out
     */
    @SerializedName("source_amount")
    private BigDecimal sourceAmount;

    /**
     * SourceCoin is the currency code of the source amount
     */
    @SerializedName("source_coin")
    private String sourceCoin;

    /**
     * ExchangeRate is the exchange rate used for currency conversion
     */
    @SerializedName("exchange_rate")
    private BigDecimal exchangeRate;

    /**
     * ReceiveCoin is the currency code of the destination amount
     */
    @SerializedName("receive_coin")
    private String receiveCoin;

    /**
     * ReceiveAssetId is the asset ID of the destination currency
     */
    @SerializedName("receive_asset_id")
    private String receiveAssetId;

    /**
     * ReceiveAccountType is the type of the destination account (bank or wallet)
     */
    @SerializedName("receive_account_type")
    private String receiveAccountType;

    /**
     * ReceiveBankAccount is the destination bank account information
     */
    @SerializedName("receive_bank_account")
    private MerchantAccount receiveBankAccount;

    /**
     * ReceiveWalletAddress is the destination wallet address information
     */
    @SerializedName("receive_wallet_address")
    private MerchantAddress receiveWalletAddress;

    /**
     * ReceiveAmount is the amount to be received after conversion
     */
    @SerializedName("receive_amount")
    private BigDecimal receiveAmount;

    /**
     * ReceiveAmountMin is the minimum amount guaranteed to be received
     */
    @SerializedName("receive_amount_min")
    private BigDecimal receiveAmountMin;

    /**
     * PaymentMaxAmount is the maximum amount that can be paid
     */
    @SerializedName("payment_max_amount")
    private BigDecimal paymentMaxAmount;

    /**
     * PaymentNetworkFee is the network fee charged for the payout
     */
    @SerializedName("payment_network_fee")
    private BigDecimal paymentNetworkFee;

    /**
     * PaymentServiceFee is the service fee charged for the payout
     */
    @SerializedName("payment_service_fee")
    private BigDecimal paymentServiceFee;

    /**
     * PaymentTotalFee is the total fee (network + service) for the payout
     */
    @SerializedName("payment_total_fee")
    private BigDecimal paymentTotalFee;

    /**
     * PaymentNetAmount is the net amount after deducting all fees
     */
    @SerializedName("payment_net_amount")
    private BigDecimal paymentNetAmount;

    /**
     * Status is the current status of the payout (paid, pending, in_transit, canceled, failed, approved, rejected)
     */
    @SerializedName("status")
    private String status;

    /**
     * ApprovalStatus is the approval status of the payout
     */
    @SerializedName("approval_status")
    private String approvalStatus;

    /**
     * InternalNote contains internal notes for record keeping
     */
    @SerializedName("internal_note")
    private String internalNote;

    /**
     * StatementDescriptor is the description that appears on the statement
     */
    @SerializedName("statement_descriptor")
    private String statementDescriptor;

    /**
     * ExternalId is the external reference ID
     */
    @SerializedName("external_id")
    private String externalId;

    /**
     * FailureMessage contains the reason for payout failure if applicable
     */
    @SerializedName("failure_message")
    private String failureMessage;

    /**
     * AmlStatus is the AML check status for this payout
     */
    @SerializedName("aml_status")
    private String amlStatus;

    /**
     * AmlInfo contains detailed AML check information
     */
    @SerializedName("aml_info")
    private String amlInfo;

    /**
     * Metadata contains additional metadata as key-value pairs
     */
    @SerializedName("metadata")
    private Map<String, String> metadata;

    public Payout() {
    }

    public static String generatePayoutId() {
        return PAYOUT_ID_PREFIX + generateRandomString(PAYOUT_ID_LENGTH);
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

    public Boolean getLivemode() {
        return livemode;
    }

    public void setLivemode(Boolean livemode) {
        this.livemode = livemode;
    }

    public Long getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Long arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Boolean getAutomatic() {
        return automatic;
    }

    public void setAutomatic(Boolean automatic) {
        this.automatic = automatic;
    }

    public List<TransactionDetails> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionDetails> transactions) {
        this.transactions = transactions;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Long getUpdated() {
        return updated;
    }

    public void setUpdated(Long updated) {
        this.updated = updated;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public BigDecimal getSourceAmount() {
        return sourceAmount;
    }

    public void setSourceAmount(BigDecimal sourceAmount) {
        this.sourceAmount = sourceAmount;
    }

    public String getSourceCoin() {
        return sourceCoin;
    }

    public void setSourceCoin(String sourceCoin) {
        this.sourceCoin = sourceCoin;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getReceiveCoin() {
        return receiveCoin;
    }

    public void setReceiveCoin(String receiveCoin) {
        this.receiveCoin = receiveCoin;
    }

    public String getReceiveAssetId() {
        return receiveAssetId;
    }

    public void setReceiveAssetId(String receiveAssetId) {
        this.receiveAssetId = receiveAssetId;
    }

    public String getReceiveAccountType() {
        return receiveAccountType;
    }

    public void setReceiveAccountType(String receiveAccountType) {
        this.receiveAccountType = receiveAccountType;
    }

    public MerchantAccount getReceiveBankAccount() {
        return receiveBankAccount;
    }

    public void setReceiveBankAccount(MerchantAccount receiveBankAccount) {
        this.receiveBankAccount = receiveBankAccount;
    }

    public MerchantAddress getReceiveWalletAddress() {
        return receiveWalletAddress;
    }

    public void setReceiveWalletAddress(MerchantAddress receiveWalletAddress) {
        this.receiveWalletAddress = receiveWalletAddress;
    }

    public BigDecimal getReceiveAmount() {
        return receiveAmount;
    }

    public void setReceiveAmount(BigDecimal receiveAmount) {
        this.receiveAmount = receiveAmount;
    }

    public BigDecimal getReceiveAmountMin() {
        return receiveAmountMin;
    }

    public void setReceiveAmountMin(BigDecimal receiveAmountMin) {
        this.receiveAmountMin = receiveAmountMin;
    }

    public BigDecimal getPaymentMaxAmount() {
        return paymentMaxAmount;
    }

    public void setPaymentMaxAmount(BigDecimal paymentMaxAmount) {
        this.paymentMaxAmount = paymentMaxAmount;
    }

    public BigDecimal getPaymentNetworkFee() {
        return paymentNetworkFee;
    }

    public void setPaymentNetworkFee(BigDecimal paymentNetworkFee) {
        this.paymentNetworkFee = paymentNetworkFee;
    }

    public BigDecimal getPaymentServiceFee() {
        return paymentServiceFee;
    }

    public void setPaymentServiceFee(BigDecimal paymentServiceFee) {
        this.paymentServiceFee = paymentServiceFee;
    }

    public BigDecimal getPaymentTotalFee() {
        return paymentTotalFee;
    }

    public void setPaymentTotalFee(BigDecimal paymentTotalFee) {
        this.paymentTotalFee = paymentTotalFee;
    }

    public BigDecimal getPaymentNetAmount() {
        return paymentNetAmount;
    }

    public void setPaymentNetAmount(BigDecimal paymentNetAmount) {
        this.paymentNetAmount = paymentNetAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getInternalNote() {
        return internalNote;
    }

    public void setInternalNote(String internalNote) {
        this.internalNote = internalNote;
    }

    public String getStatementDescriptor() {
        return statementDescriptor;
    }

    public void setStatementDescriptor(String statementDescriptor) {
        this.statementDescriptor = statementDescriptor;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getFailureMessage() {
        return failureMessage;
    }

    public void setFailureMessage(String failureMessage) {
        this.failureMessage = failureMessage;
    }

    public String getAmlStatus() {
        return amlStatus;
    }

    public void setAmlStatus(String amlStatus) {
        this.amlStatus = amlStatus;
    }

    public String getAmlInfo() {
        return amlInfo;
    }

    public void setAmlInfo(String amlInfo) {
        this.amlInfo = amlInfo;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }
}
