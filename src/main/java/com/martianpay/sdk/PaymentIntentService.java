package com.martianpay.sdk;

import com.google.gson.annotations.SerializedName;
import com.martianpay.model.PaymentIntent;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * PaymentIntentService provides methods for managing payment intents
 */
public class PaymentIntentService extends MartianPayClient {

    public PaymentIntentService(String apiKey) {
        super(apiKey);
    }

    public PaymentIntentService(String apiKey, String baseUrl) {
        super(apiKey, baseUrl);
    }

    /**
     * Request parameters for creating a payment intent
     */
    public static class PaymentIntentCreateRequest {
        @SerializedName("amount")
        private String amount;

        @SerializedName("currency")
        private String currency;

        @SerializedName("customer")
        private String customer;

        @SerializedName("description")
        private String description;

        @SerializedName("metadata")
        private Map<String, String> metadata;

        @SerializedName("merchant_order_id")
        private String merchantOrderId;

        @SerializedName("receipt_email")
        private String receiptEmail;

        @SerializedName("return_url")
        private String returnUrl;

        @SerializedName("payment_method_id")
        private String paymentMethodId;

        @SerializedName("complete_on_first_payment")
        private Boolean completeOnFirstPayment;

        // Getters and Setters
        public String getAmount() { return amount; }
        public void setAmount(String amount) { this.amount = amount; }
        public String getCurrency() { return currency; }
        public void setCurrency(String currency) { this.currency = currency; }
        public String getCustomer() { return customer; }
        public void setCustomer(String customer) { this.customer = customer; }
        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }
        public Map<String, String> getMetadata() { return metadata; }
        public void setMetadata(Map<String, String> metadata) { this.metadata = metadata; }
        public String getMerchantOrderId() { return merchantOrderId; }
        public void setMerchantOrderId(String merchantOrderId) { this.merchantOrderId = merchantOrderId; }
        public String getReceiptEmail() { return receiptEmail; }
        public void setReceiptEmail(String receiptEmail) { this.receiptEmail = receiptEmail; }
        public String getReturnUrl() { return returnUrl; }
        public void setReturnUrl(String returnUrl) { this.returnUrl = returnUrl; }
        public String getPaymentMethodId() { return paymentMethodId; }
        public void setPaymentMethodId(String paymentMethodId) { this.paymentMethodId = paymentMethodId; }
        public Boolean getCompleteOnFirstPayment() { return completeOnFirstPayment; }
        public void setCompleteOnFirstPayment(Boolean completeOnFirstPayment) { this.completeOnFirstPayment = completeOnFirstPayment; }
    }

    /**
     * Request parameters for updating a payment intent
     */
    public static class PaymentIntentUpdateRequest {
        private String id;

        @SerializedName("payment_link_id")
        private String paymentLinkId;

        @SerializedName("payment_method_type")
        private String paymentMethodType;

        @SerializedName("payment_method_options")
        private PaymentMethodOptions paymentMethodOptions;

        public static class PaymentMethodOptions {
            @SerializedName("crypto")
            private CryptoOptions crypto;

            @SerializedName("fiat")
            private FiatOptions fiat;

            public CryptoOptions getCrypto() { return crypto; }
            public void setCrypto(CryptoOptions crypto) { this.crypto = crypto; }
            public FiatOptions getFiat() { return fiat; }
            public void setFiat(FiatOptions fiat) { this.fiat = fiat; }
        }

        public static class CryptoOptions {
            @SerializedName("asset_id")
            private String assetId;

            public String getAssetId() { return assetId; }
            public void setAssetId(String assetId) { this.assetId = assetId; }
        }

        public static class FiatOptions {
            @SerializedName("currency")
            private String currency;

            @SerializedName("payment_method_id")
            private String paymentMethodId;

            @SerializedName("save_payment_method")
            private Boolean savePaymentMethod;

            public String getCurrency() { return currency; }
            public void setCurrency(String currency) { this.currency = currency; }
            public String getPaymentMethodId() { return paymentMethodId; }
            public void setPaymentMethodId(String paymentMethodId) { this.paymentMethodId = paymentMethodId; }
            public Boolean getSavePaymentMethod() { return savePaymentMethod; }
            public void setSavePaymentMethod(Boolean savePaymentMethod) { this.savePaymentMethod = savePaymentMethod; }
        }

        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
        public String getPaymentLinkId() { return paymentLinkId; }
        public void setPaymentLinkId(String paymentLinkId) { this.paymentLinkId = paymentLinkId; }
        public String getPaymentMethodType() { return paymentMethodType; }
        public void setPaymentMethodType(String paymentMethodType) { this.paymentMethodType = paymentMethodType; }
        public PaymentMethodOptions getPaymentMethodOptions() { return paymentMethodOptions; }
        public void setPaymentMethodOptions(PaymentMethodOptions paymentMethodOptions) { this.paymentMethodOptions = paymentMethodOptions; }
    }

    /**
     * Request parameters for listing payment intents
     */
    public static class PaymentIntentListRequest {
        @SerializedName("page")
        private int page;

        @SerializedName("page_size")
        private int pageSize;

        @SerializedName("customer")
        private String customer;

        @SerializedName("customer_email")
        private String customerEmail;

        @SerializedName("permanent_deposit")
        private Boolean permanentDeposit;

        @SerializedName("permanent_deposit_asset_id")
        private String permanentDepositAssetId;

        public int getPage() { return page; }
        public void setPage(int page) { this.page = page; }
        public int getPageSize() { return pageSize; }
        public void setPageSize(int pageSize) { this.pageSize = pageSize; }
        public String getCustomer() { return customer; }
        public void setCustomer(String customer) { this.customer = customer; }
        public String getCustomerEmail() { return customerEmail; }
        public void setCustomerEmail(String customerEmail) { this.customerEmail = customerEmail; }
        public Boolean getPermanentDeposit() { return permanentDeposit; }
        public void setPermanentDeposit(Boolean permanentDeposit) { this.permanentDeposit = permanentDeposit; }
        public String getPermanentDepositAssetId() { return permanentDepositAssetId; }
        public void setPermanentDepositAssetId(String permanentDepositAssetId) { this.permanentDepositAssetId = permanentDepositAssetId; }
    }

    /**
     * Response for listing payment intents
     */
    public static class PaymentIntentListResponse {
        @SerializedName("payment_intents")
        private List<PaymentIntent> paymentIntents;

        @SerializedName("total")
        private long total;

        @SerializedName("page")
        private int page;

        @SerializedName("page_size")
        private int pageSize;

        public List<PaymentIntent> getPaymentIntents() { return paymentIntents; }
        public long getTotal() { return total; }
        public int getPage() { return page; }
        public int getPageSize() { return pageSize; }
    }

    /**
     * Request parameters for canceling a payment intent
     */
    public static class PaymentIntentCancelRequest {
        @SerializedName("reason")
        private String reason;

        public String getReason() { return reason; }
        public void setReason(String reason) { this.reason = reason; }
    }

    /**
     * Creates a new payment intent
     *
     * @param request Payment intent creation parameters
     * @return Created payment intent
     * @throws IOException if request fails
     */
    public PaymentIntent createPaymentIntent(PaymentIntentCreateRequest request) throws IOException {
        return sendRequest("POST", "/v1/payment_intents", request, PaymentIntent.class);
    }

    /**
     * Updates an existing payment intent
     *
     * @param request Payment intent update parameters
     * @return Updated payment intent
     * @throws IOException if request fails
     */
    public PaymentIntent updatePaymentIntent(PaymentIntentUpdateRequest request) throws IOException {
        return sendRequest("POST", "/v1/payment_intents/" + request.getId(), request, PaymentIntent.class);
    }

    /**
     * Retrieves a specific payment intent by ID
     *
     * @param paymentIntentId Payment intent ID
     * @return Payment intent details
     * @throws IOException if request fails
     */
    public PaymentIntent getPaymentIntent(String paymentIntentId) throws IOException {
        return sendRequest("GET", "/v1/payment_intents/" + paymentIntentId, null, PaymentIntent.class);
    }

    /**
     * Retrieves a list of payment intents
     *
     * @param request List parameters
     * @return Payment intent list response
     * @throws IOException if request fails
     */
    public PaymentIntentListResponse listPaymentIntents(PaymentIntentListRequest request) throws IOException {
        StringBuilder query = new StringBuilder();
        query.append("page=").append(request.getPage());
        query.append("&page_size=").append(request.getPageSize());

        if (request.getCustomer() != null && !request.getCustomer().isEmpty()) {
            try {
                query.append("&customer=").append(URLEncoder.encode(request.getCustomer(), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                throw new IOException("Failed to encode customer parameter", e);
            }
        }

        if (request.getCustomerEmail() != null && !request.getCustomerEmail().isEmpty()) {
            try {
                query.append("&customer_email=").append(URLEncoder.encode(request.getCustomerEmail(), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                throw new IOException("Failed to encode customer_email parameter", e);
            }
        }

        if (request.getPermanentDeposit() != null) {
            query.append("&permanent_deposit=").append(request.getPermanentDeposit());
        }

        if (request.getPermanentDepositAssetId() != null && !request.getPermanentDepositAssetId().isEmpty()) {
            try {
                query.append("&permanent_deposit_asset_id=").append(URLEncoder.encode(request.getPermanentDepositAssetId(), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                throw new IOException("Failed to encode permanent_deposit_asset_id parameter", e);
            }
        }

        return sendRequestWithQuery("/v1/payment_intents", query.toString(), PaymentIntentListResponse.class);
    }

    /**
     * Cancels a payment intent
     *
     * @param paymentIntentId Payment intent ID to cancel
     * @param request Cancel request parameters
     * @return Canceled payment intent
     * @throws IOException if request fails
     */
    public PaymentIntent cancelPaymentIntent(String paymentIntentId, PaymentIntentCancelRequest request) throws IOException {
        return sendRequest("POST", "/v1/payment_intents/" + paymentIntentId + "/cancel", request, PaymentIntent.class);
    }
}
