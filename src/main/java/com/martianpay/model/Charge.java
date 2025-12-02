package com.martianpay.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

/**
 * Represents a charge (payment attempt) in the MartianPay system.
 */
public class Charge {
    public static final String OBJECT_TYPE = "charge";

    @SerializedName("id")
    private String id;

    @SerializedName("object")
    private String object;

    @SerializedName("amount")
    private AssetAmount amount;

    @SerializedName("payment_details")
    private PaymentIntent.PaymentDetails paymentDetails;

    @SerializedName("exchange_rate")
    private String exchangeRate;

    @SerializedName("calculated_statement_descriptor")
    private String calculatedStatementDescriptor;

    @SerializedName("captured")
    private Boolean captured;

    @SerializedName("created")
    private Long created;

    @SerializedName("customer")
    private String customer;

    @SerializedName("description")
    private String description;

    @SerializedName("disputed")
    private Boolean disputed;

    @SerializedName("failure_code")
    private String failureCode;

    @SerializedName("failure_message")
    private String failureMessage;

    @SerializedName("fraud_details")
    private FraudDetails fraudDetails;

    @SerializedName("livemode")
    private Boolean livemode;

    @SerializedName("metadata")
    private Map<String, String> metadata;

    @SerializedName("paid")
    private Boolean paid;

    @SerializedName("payment_intent")
    private String paymentIntent;

    @SerializedName("payment_method_type")
    private String paymentMethodType;

    @SerializedName("payment_method_options")
    private PaymentMethodOptions paymentMethodOptions;

    @SerializedName("transactions")
    private List<Refund.TransactionDetails> transactions;

    @SerializedName("receipt_email")
    private String receiptEmail;

    @SerializedName("receipt_url")
    private String receiptUrl;

    @SerializedName("refunded")
    private Boolean refunded;

    @SerializedName("refunds")
    private List<Refund> refunds;

    @SerializedName("review")
    private Review review;

    @SerializedName("payer_max_payload")
    private PayerMaxPayload payerMaxPayload;

    @SerializedName("stripe_payload")
    private StripePayload stripePayload;

    @SerializedName("payment_provider")
    private String paymentProvider;

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

    public AssetAmount getAmount() {
        return amount;
    }

    public void setAmount(AssetAmount amount) {
        this.amount = amount;
    }

    public PaymentIntent.PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(PaymentIntent.PaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public String getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(String exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getCalculatedStatementDescriptor() {
        return calculatedStatementDescriptor;
    }

    public void setCalculatedStatementDescriptor(String calculatedStatementDescriptor) {
        this.calculatedStatementDescriptor = calculatedStatementDescriptor;
    }

    public Boolean getCaptured() {
        return captured;
    }

    public void setCaptured(Boolean captured) {
        this.captured = captured;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDisputed() {
        return disputed;
    }

    public void setDisputed(Boolean disputed) {
        this.disputed = disputed;
    }

    public String getFailureCode() {
        return failureCode;
    }

    public void setFailureCode(String failureCode) {
        this.failureCode = failureCode;
    }

    public String getFailureMessage() {
        return failureMessage;
    }

    public void setFailureMessage(String failureMessage) {
        this.failureMessage = failureMessage;
    }

    public FraudDetails getFraudDetails() {
        return fraudDetails;
    }

    public void setFraudDetails(FraudDetails fraudDetails) {
        this.fraudDetails = fraudDetails;
    }

    public Boolean getLivemode() {
        return livemode;
    }

    public void setLivemode(Boolean livemode) {
        this.livemode = livemode;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public String getPaymentIntent() {
        return paymentIntent;
    }

    public void setPaymentIntent(String paymentIntent) {
        this.paymentIntent = paymentIntent;
    }

    public String getPaymentMethodType() {
        return paymentMethodType;
    }

    public void setPaymentMethodType(String paymentMethodType) {
        this.paymentMethodType = paymentMethodType;
    }

    public PaymentMethodOptions getPaymentMethodOptions() {
        return paymentMethodOptions;
    }

    public void setPaymentMethodOptions(PaymentMethodOptions paymentMethodOptions) {
        this.paymentMethodOptions = paymentMethodOptions;
    }

    public List<Refund.TransactionDetails> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Refund.TransactionDetails> transactions) {
        this.transactions = transactions;
    }

    public String getReceiptEmail() {
        return receiptEmail;
    }

    public void setReceiptEmail(String receiptEmail) {
        this.receiptEmail = receiptEmail;
    }

    public String getReceiptUrl() {
        return receiptUrl;
    }

    public void setReceiptUrl(String receiptUrl) {
        this.receiptUrl = receiptUrl;
    }

    public Boolean getRefunded() {
        return refunded;
    }

    public void setRefunded(Boolean refunded) {
        this.refunded = refunded;
    }

    public List<Refund> getRefunds() {
        return refunds;
    }

    public void setRefunds(List<Refund> refunds) {
        this.refunds = refunds;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public PayerMaxPayload getPayerMaxPayload() {
        return payerMaxPayload;
    }

    public void setPayerMaxPayload(PayerMaxPayload payerMaxPayload) {
        this.payerMaxPayload = payerMaxPayload;
    }

    public StripePayload getStripePayload() {
        return stripePayload;
    }

    public void setStripePayload(StripePayload stripePayload) {
        this.stripePayload = stripePayload;
    }

    public String getPaymentProvider() {
        return paymentProvider;
    }

    public void setPaymentProvider(String paymentProvider) {
        this.paymentProvider = paymentProvider;
    }

    /**
     * Fraud details for a charge
     */
    public static class FraudDetails {
        @SerializedName("martian_report")
        private String martianReport;

        @SerializedName("user_report")
        private String userReport;

        public String getMartianReport() {
            return martianReport;
        }

        public void setMartianReport(String martianReport) {
            this.martianReport = martianReport;
        }

        public String getUserReport() {
            return userReport;
        }

        public void setUserReport(String userReport) {
            this.userReport = userReport;
        }
    }

    /**
     * Review information for disputed charges
     */
    public static class Review {
        @SerializedName("id")
        private String id;

        @SerializedName("object")
        private String object;

        @SerializedName("charge")
        private String charge;

        @SerializedName("closed_reason")
        private String closedReason;

        @SerializedName("created")
        private Long created;

        @SerializedName("ip_address")
        private String ipAddress;

        @SerializedName("livemode")
        private Boolean livemode;

        @SerializedName("open")
        private Boolean open;

        @SerializedName("opened_reason")
        private String openedReason;

        @SerializedName("payment_intent")
        private String paymentIntent;

        @SerializedName("reason")
        private String reason;

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

        public String getCharge() {
            return charge;
        }

        public void setCharge(String charge) {
            this.charge = charge;
        }

        public String getClosedReason() {
            return closedReason;
        }

        public void setClosedReason(String closedReason) {
            this.closedReason = closedReason;
        }

        public Long getCreated() {
            return created;
        }

        public void setCreated(Long created) {
            this.created = created;
        }

        public String getIpAddress() {
            return ipAddress;
        }

        public void setIpAddress(String ipAddress) {
            this.ipAddress = ipAddress;
        }

        public Boolean getLivemode() {
            return livemode;
        }

        public void setLivemode(Boolean livemode) {
            this.livemode = livemode;
        }

        public Boolean getOpen() {
            return open;
        }

        public void setOpen(Boolean open) {
            this.open = open;
        }

        public String getOpenedReason() {
            return openedReason;
        }

        public void setOpenedReason(String openedReason) {
            this.openedReason = openedReason;
        }

        public String getPaymentIntent() {
            return paymentIntent;
        }

        public void setPaymentIntent(String paymentIntent) {
            this.paymentIntent = paymentIntent;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }
    }

    /**
     * PayerMax payment payload
     */
    public static class PayerMaxPayload {
        @SerializedName("cashier_url")
        private String cashierUrl;

        @SerializedName("status")
        private String status;

        @SerializedName("session_key")
        private String sessionKey;

        @SerializedName("client_key")
        private String clientKey;

        public String getCashierUrl() {
            return cashierUrl;
        }

        public void setCashierUrl(String cashierUrl) {
            this.cashierUrl = cashierUrl;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getSessionKey() {
            return sessionKey;
        }

        public void setSessionKey(String sessionKey) {
            this.sessionKey = sessionKey;
        }

        public String getClientKey() {
            return clientKey;
        }

        public void setClientKey(String clientKey) {
            this.clientKey = clientKey;
        }
    }

    /**
     * Stripe payment payload
     */
    public static class StripePayload {
        @SerializedName("client_secret")
        private String clientSecret;

        @SerializedName("public_key")
        private String publicKey;

        @SerializedName("status")
        private String status;

        @SerializedName("customer_id")
        private String customerId;

        public String getClientSecret() {
            return clientSecret;
        }

        public void setClientSecret(String clientSecret) {
            this.clientSecret = clientSecret;
        }

        public String getPublicKey() {
            return publicKey;
        }

        public void setPublicKey(String publicKey) {
            this.publicKey = publicKey;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }
    }

    /**
     * Payment method options
     */
    public static class PaymentMethodOptions {
        @SerializedName("crypto")
        private CryptoOptions crypto;

        @SerializedName("fiat")
        private FiatOptions fiat;

        public CryptoOptions getCrypto() {
            return crypto;
        }

        public void setCrypto(CryptoOptions crypto) {
            this.crypto = crypto;
        }

        public FiatOptions getFiat() {
            return fiat;
        }

        public void setFiat(FiatOptions fiat) {
            this.fiat = fiat;
        }
    }

    /**
     * Crypto payment options
     */
    public static class CryptoOptions {
        @SerializedName("amount")
        private String amount;

        @SerializedName("token")
        private String token;

        @SerializedName("asset_id")
        private String assetId;

        @SerializedName("network")
        private String network;

        @SerializedName("decimals")
        private Integer decimals;

        @SerializedName("exchange_rate")
        private String exchangeRate;

        @SerializedName("deposit_address")
        private String depositAddress;

        @SerializedName("expired_at")
        private Long expiredAt;

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getAssetId() {
            return assetId;
        }

        public void setAssetId(String assetId) {
            this.assetId = assetId;
        }

        public String getNetwork() {
            return network;
        }

        public void setNetwork(String network) {
            this.network = network;
        }

        public Integer getDecimals() {
            return decimals;
        }

        public void setDecimals(Integer decimals) {
            this.decimals = decimals;
        }

        public String getExchangeRate() {
            return exchangeRate;
        }

        public void setExchangeRate(String exchangeRate) {
            this.exchangeRate = exchangeRate;
        }

        public String getDepositAddress() {
            return depositAddress;
        }

        public void setDepositAddress(String depositAddress) {
            this.depositAddress = depositAddress;
        }

        public Long getExpiredAt() {
            return expiredAt;
        }

        public void setExpiredAt(Long expiredAt) {
            this.expiredAt = expiredAt;
        }
    }

    /**
     * Fiat payment options
     */
    public static class FiatOptions {
        @SerializedName("amount")
        private String amount;

        @SerializedName("asset_id")
        private String assetId;

        @SerializedName("currency")
        private String currency;

        @SerializedName("decimals")
        private Integer decimals;

        @SerializedName("exchange_rate")
        private String exchangeRate;

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getAssetId() {
            return assetId;
        }

        public void setAssetId(String assetId) {
            this.assetId = assetId;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public Integer getDecimals() {
            return decimals;
        }

        public void setDecimals(Integer decimals) {
            this.decimals = decimals;
        }

        public String getExchangeRate() {
            return exchangeRate;
        }

        public void setExchangeRate(String exchangeRate) {
            this.exchangeRate = exchangeRate;
        }
    }
}
