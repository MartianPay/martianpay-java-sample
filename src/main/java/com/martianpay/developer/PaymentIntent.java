package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

/**
 * PaymentIntent represents a payment intent in the system.
 *
 * Status lifecycle:
 * 1. Created - Payment intent has just been created and is waiting for user to select payment method
 * 2. Waiting - Payment method has been selected and is waiting for payment
 * 3. Partially Paid - At least one blockchain tx with status Submitted/Completed/Confirmed exists, but total amount is insufficient
 * 4. Paid - At least one blockchain tx with status Submitted/Completed/Confirmed exists, with sufficient total amount
 * 5. Completed - At least one blockchain tx with status Completed/Confirmed exists, with sufficient total amount
 * 6. Confirmed - At least one blockchain tx with status Confirmed exists, with sufficient total amount
 * 7. Frozen - Payment has been received but funds are frozen due to AML rejection
 * 8. Unfrozen - Previously frozen funds have been successfully unfrozen
 * 9. Cancelled - Payment intent was cancelled due to timeout (20min for Created, 60min for Partially Paid/Paid, 120min for Completed)
 */
public class PaymentIntent {
    public static final String PAYMENT_INTENT_OBJECT = "payment_intent";

    public static final String STATUS_CREATED = "Created";
    public static final String STATUS_WAITING = "Waiting";
    public static final String STATUS_PARTIALLY_PAID = "Partially Paid";
    public static final String STATUS_PAID = "Paid";
    public static final String STATUS_COMPLETED = "Completed";
    public static final String STATUS_CONFIRMED = "Confirmed";
    public static final String STATUS_FROZEN = "Frozen";
    public static final String STATUS_UNFROZEN = "Unfrozen";
    public static final String STATUS_CANCELLED = "Cancelled";

    public static final String PAYMENT_METHOD_TYPE_CRYPTO = "crypto";
    public static final String PAYMENT_METHOD_TYPE_TRON = "tron";
    public static final String PAYMENT_METHOD_TYPE_WALLET_CONNECT = "wallet_connect";
    public static final String PAYMENT_METHOD_TYPE_CARDS = "cards";
    public static final String PAYMENT_METHOD_TYPE_OTHERS = "others";

    public static final String CANCELLATION_REASON_ABANDONED = "abandoned";
    public static final String CANCELLATION_REASON_AUTOMATIC = "automatic";
    public static final String CANCELLATION_REASON_DUPLICATE = "duplicate";
    public static final String CANCELLATION_REASON_FAILED_INVOICE = "failed_invoice";
    public static final String CANCELLATION_REASON_FRAUDULENT = "fraudulent";
    public static final String CANCELLATION_REASON_REQUESTED_BY_CUSTOMER = "requested_by_customer";
    public static final String CANCELLATION_REASON_VOID_INVOICE = "void_invoice";

    /**
     * ID is the unique identifier for the payment intent
     */
    @SerializedName("id")
    private String id;

    /**
     * Object is the object type, always "payment_intent"
     */
    @SerializedName("object")
    private String object;

    /**
     * Amount is the amount to be collected by this payment intent
     */
    @SerializedName("amount")
    private AssetAmount amount;

    /**
     * PaymentDetails contains details about the payment including settled amounts and fees
     */
    @SerializedName("payment_details")
    private PaymentDetails paymentDetails;

    /**
     * CanceledAt is the Unix timestamp when the payment intent was canceled
     */
    @SerializedName("canceled_at")
    private Long canceledAt;

    /**
     * CancellationReason is the reason why the payment intent was canceled
     */
    @SerializedName("cancellation_reason")
    private String cancellationReason;

    /**
     * ClientSecret is the client secret used for client-side confirmation
     */
    @SerializedName("client_secret")
    private String clientSecret;

    /**
     * Created is the Unix timestamp when the payment intent was created
     */
    @SerializedName("created")
    private Long created;

    /**
     * Updated is the Unix timestamp when the payment intent was last updated
     */
    @SerializedName("updated")
    private Long updated;

    /**
     * Currency is the currency of the payment intent
     */
    @SerializedName("currency")
    private String currency;

    /**
     * Customer is the customer associated with this payment intent
     */
    @SerializedName("customer")
    private Customer customer;

    /**
     * Description is the description of the payment intent
     */
    @SerializedName("description")
    private String description;

    /**
     * Livemode indicates whether the object exists in live mode (true) or test mode (false)
     */
    @SerializedName("livemode")
    private Boolean livemode;

    /**
     * Metadata contains key-value pairs attached to the payment intent
     */
    @SerializedName("metadata")
    private Map<String, Object> metadata;

    /**
     * PaymentLinkDetails contains details about the payment link if this payment intent was created through a payment link
     */
    @SerializedName("payment_link_details")
    private PaymentLinkDetails paymentLinkDetails;

    /**
     * MerchantOrderId is the merchant-specified order ID associated with this payment intent
     */
    @SerializedName("merchant_order_id")
    private String merchantOrderId;

    /**
     * Charges is the list of charges associated with this payment intent
     */
    @SerializedName("charges")
    private List<Charge> charges;

    /**
     * ReceiptEmail is the email address to send the receipt to
     */
    @SerializedName("receipt_email")
    private String receiptEmail;

    /**
     * ReturnURL is the URL to redirect the customer to after payment
     */
    @SerializedName("return_url")
    private String returnUrl;

    /**
     * Status is the current status of the payment intent
     */
    @SerializedName("status")
    private String status;

    /**
     * PaymentIntentStatus is the standardized status of the payment intent
     */
    @SerializedName("payment_intent_status")
    private String paymentIntentStatus;

    /**
     * CompleteOnFirstPayment indicates whether to complete payment immediately when first transaction arrives, regardless of amount
     */
    @SerializedName("complete_on_first_payment")
    private Boolean completeOnFirstPayment;

    /**
     * PermanentDeposit indicates if this payment is a permanent deposit
     */
    @SerializedName("permanent_deposit")
    private Boolean permanentDeposit;

    /**
     * PermanentDepositAssetId is the asset ID for the permanent deposit
     */
    @SerializedName("permanent_deposit_asset_id")
    private String permanentDepositAssetId;

    /**
     * ExpiredAt is the Unix timestamp when the payment intent expires
     */
    @SerializedName("expired_at")
    private Long expiredAt;

    /**
     * UnfreezeWithdraws is the list of unfreeze withdrawals for previously frozen funds
     */
    @SerializedName("unfreeze_withdraws")
    private List<UnfreezeWithdraw> unfreezeWithdraws;

    /**
     * Invoice is the invoice ID if this payment is for an invoice (subscriptions)
     */
    @SerializedName("invoice")
    private String invoice;

    /**
     * InvoiceDetails contains expanded invoice details
     */
    @SerializedName("invoice_details")
    private InvoiceDetails invoiceDetails;

    /**
     * Subscription is the subscription ID (resolved through invoice)
     */
    @SerializedName("subscription")
    private String subscription;

    /**
     * SubscriptionDetails contains expanded subscription details
     */
    @SerializedName("subscription_details")
    private SubscriptionDetails subscriptionDetails;

    /**
     * MerchantID is the merchant ID who owns this payment intent
     */
    @SerializedName("merchant_id")
    private String merchantId;

    /**
     * MerchantName is the merchant name for display
     */
    @SerializedName("merchant_name")
    private String merchantName;

    public PaymentIntent() {
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

    public Long getCanceledAt() {
        return canceledAt;
    }

    public void setCanceledAt(Long canceledAt) {
        this.canceledAt = canceledAt;
    }

    public String getCancellationReason() {
        return cancellationReason;
    }

    public void setCancellationReason(String cancellationReason) {
        this.cancellationReason = cancellationReason;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getLivemode() {
        return livemode;
    }

    public void setLivemode(Boolean livemode) {
        this.livemode = livemode;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    public PaymentLinkDetails getPaymentLinkDetails() {
        return paymentLinkDetails;
    }

    public void setPaymentLinkDetails(PaymentLinkDetails paymentLinkDetails) {
        this.paymentLinkDetails = paymentLinkDetails;
    }

    public String getMerchantOrderId() {
        return merchantOrderId;
    }

    public void setMerchantOrderId(String merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
    }

    public List<Charge> getCharges() {
        return charges;
    }

    public void setCharges(List<Charge> charges) {
        this.charges = charges;
    }

    public String getReceiptEmail() {
        return receiptEmail;
    }

    public void setReceiptEmail(String receiptEmail) {
        this.receiptEmail = receiptEmail;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentIntentStatus() {
        return paymentIntentStatus;
    }

    public void setPaymentIntentStatus(String paymentIntentStatus) {
        this.paymentIntentStatus = paymentIntentStatus;
    }

    public Boolean getCompleteOnFirstPayment() {
        return completeOnFirstPayment;
    }

    public void setCompleteOnFirstPayment(Boolean completeOnFirstPayment) {
        this.completeOnFirstPayment = completeOnFirstPayment;
    }

    public Boolean getPermanentDeposit() {
        return permanentDeposit;
    }

    public void setPermanentDeposit(Boolean permanentDeposit) {
        this.permanentDeposit = permanentDeposit;
    }

    public String getPermanentDepositAssetId() {
        return permanentDepositAssetId;
    }

    public void setPermanentDepositAssetId(String permanentDepositAssetId) {
        this.permanentDepositAssetId = permanentDepositAssetId;
    }

    public Long getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(Long expiredAt) {
        this.expiredAt = expiredAt;
    }

    public List<UnfreezeWithdraw> getUnfreezeWithdraws() {
        return unfreezeWithdraws;
    }

    public void setUnfreezeWithdraws(List<UnfreezeWithdraw> unfreezeWithdraws) {
        this.unfreezeWithdraws = unfreezeWithdraws;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public InvoiceDetails getInvoiceDetails() {
        return invoiceDetails;
    }

    public void setInvoiceDetails(InvoiceDetails invoiceDetails) {
        this.invoiceDetails = invoiceDetails;
    }

    public String getSubscription() {
        return subscription;
    }

    public void setSubscription(String subscription) {
        this.subscription = subscription;
    }

    public SubscriptionDetails getSubscriptionDetails() {
        return subscriptionDetails;
    }

    public void setSubscriptionDetails(SubscriptionDetails subscriptionDetails) {
        this.subscriptionDetails = subscriptionDetails;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }
}
