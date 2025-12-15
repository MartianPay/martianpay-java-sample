package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

/**
 * Charge represents a payment charge
 */
public class Charge {
    public static final String CHARGE_OBJECT = "charge";

    public static final String FRAUD_MARTIAN_REPORT_FRAUDULENT = "fraudulent";
    public static final String FRAUD_USER_REPORT_FRAUDULENT = "fraudulent";
    public static final String FRAUD_USER_REPORT_SAFE = "safe";

    /**
     * ID is the unique identifier for the charge
     */
    @SerializedName("id")
    private String id;

    /**
     * Object is the type identifier, always "charge"
     */
    @SerializedName("object")
    private String object;

    /**
     * Amount contains the charged amount with asset information
     */
    @SerializedName("amount")
    private AssetAmount amount;

    /**
     * PaymentDetails contains detailed payment information
     */
    @SerializedName("payment_details")
    private PaymentDetails paymentDetails;

    /**
     * ExchangeRate is the exchange rate applied for currency conversion
     */
    @SerializedName("exchange_rate")
    private String exchangeRate;

    /**
     * CalculatedStatementDescriptor is the description shown on the customer's statement
     */
    @SerializedName("calculated_statement_descriptor")
    private String calculatedStatementDescriptor;

    /**
     * Captured indicates whether the charge has been captured
     */
    @SerializedName("captured")
    private Boolean captured;

    /**
     * Created is the Unix timestamp when the charge was created
     */
    @SerializedName("created")
    private Long created;

    /**
     * Customer is the ID of the customer associated with this charge
     */
    @SerializedName("customer")
    private String customer;

    /**
     * Description is a description of the charge
     */
    @SerializedName("description")
    private String description;

    /**
     * Disputed indicates whether the charge has been disputed
     */
    @SerializedName("disputed")
    private Boolean disputed;

    /**
     * FailureCode is the error code if the charge failed
     */
    @SerializedName("failure_code")
    private String failureCode;

    /**
     * FailureMessage is the error message if the charge failed
     */
    @SerializedName("failure_message")
    private String failureMessage;

    /**
     * FraudDetails contains fraud assessment information
     */
    @SerializedName("fraud_details")
    private ChargeFraudDetails fraudDetails;

    /**
     * Livemode indicates if this is a live transaction (true) or test (false)
     */
    @SerializedName("livemode")
    private Boolean livemode;

    /**
     * Metadata is a set of key-value pairs for storing additional information
     */
    @SerializedName("metadata")
    private Map<String, String> metadata;

    /**
     * Paid indicates whether the charge was successfully paid
     */
    @SerializedName("paid")
    private Boolean paid;

    /**
     * PaymentIntent is the ID of the associated payment intent
     */
    @SerializedName("payment_intent")
    private String paymentIntent;

    /**
     * PaymentMethodType indicates the type of payment method used
     */
    @SerializedName("payment_method_type")
    private String paymentMethodType;

    /**
     * PaymentMethodOptions contains payment method-specific options
     */
    @SerializedName("payment_method_options")
    private PaymentMethodOptions paymentMethodOptions;

    /**
     * Transactions contains the list of blockchain transactions for this charge
     */
    @SerializedName("transactions")
    private List<TransactionDetails> transactions;

    /**
     * ReceiptEmail is the email address to send the receipt to
     */
    @SerializedName("receipt_email")
    private String receiptEmail;

    /**
     * ReceiptUrl is the URL for the receipt
     */
    @SerializedName("receipt_url")
    private String receiptUrl;

    /**
     * Refunded indicates whether the charge has been refunded
     */
    @SerializedName("refunded")
    private Boolean refunded;

    /**
     * Refunds is the list of refunds associated with this charge
     */
    @SerializedName("refunds")
    private List<Refund> refunds;

    /**
     * Review contains fraud review information
     */
    @SerializedName("review")
    private Review review;

    /**
     * PayerMaxPayload contains PayerMax-specific payment data
     */
    @SerializedName("payer_max_payload")
    private PayerMaxPayload payerMaxPayload;

    /**
     * StripePayload contains Stripe-specific payment data
     */
    @SerializedName("stripe_payload")
    private StripePayload stripePayload;

    /**
     * PaymentProvider is the payment provider used for this charge
     */
    @SerializedName("payment_provider")
    private String paymentProvider;

    public Charge() {
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

    public AssetAmount getAmount() {
        return amount;
    }

    public void setAmount(AssetAmount amount) {
        this.amount = amount;
    }

    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(PaymentDetails paymentDetails) {
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

    public ChargeFraudDetails getFraudDetails() {
        return fraudDetails;
    }

    public void setFraudDetails(ChargeFraudDetails fraudDetails) {
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

    public List<TransactionDetails> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionDetails> transactions) {
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
}
