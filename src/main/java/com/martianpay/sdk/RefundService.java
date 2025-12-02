package com.martianpay.sdk;

import com.google.gson.annotations.SerializedName;
import com.martianpay.model.Refund;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * RefundService provides methods for managing refunds
 */
public class RefundService extends MartianPayClient {

    public RefundService(String apiKey) {
        super(apiKey);
    }

    public RefundService(String apiKey, String baseUrl) {
        super(apiKey, baseUrl);
    }

    /**
     * Request parameters for creating a refund
     */
    public static class RefundCreateRequest {
        @SerializedName("payment_intent")
        private String paymentIntent;

        @SerializedName("amount")
        private String amount;

        @SerializedName("reason")
        private String reason;

        public String getPaymentIntent() { return paymentIntent; }
        public void setPaymentIntent(String paymentIntent) { this.paymentIntent = paymentIntent; }
        public String getAmount() { return amount; }
        public void setAmount(String amount) { this.amount = amount; }
        public String getReason() { return reason; }
        public void setReason(String reason) { this.reason = reason; }
    }

    /**
     * Response for creating a refund
     */
    public static class RefundCreateResponse {
        @SerializedName("refunds")
        private List<Refund> refunds;

        public List<Refund> getRefunds() { return refunds; }
    }

    /**
     * Request parameters for listing refunds
     */
    public static class RefundListRequest {
        @SerializedName("page")
        private int page;

        @SerializedName("page_size")
        private int pageSize;

        @SerializedName("payment_intent")
        private String paymentIntent;

        public int getPage() { return page; }
        public void setPage(int page) { this.page = page; }
        public int getPageSize() { return pageSize; }
        public void setPageSize(int pageSize) { this.pageSize = pageSize; }
        public String getPaymentIntent() { return paymentIntent; }
        public void setPaymentIntent(String paymentIntent) { this.paymentIntent = paymentIntent; }
    }

    /**
     * Response for listing refunds
     */
    public static class RefundListResponse {
        @SerializedName("refunds")
        private List<Refund> refunds;

        @SerializedName("total")
        private long total;

        @SerializedName("page")
        private int page;

        @SerializedName("page_size")
        private int pageSize;

        public List<Refund> getRefunds() { return refunds; }
        public long getTotal() { return total; }
        public int getPage() { return page; }
        public int getPageSize() { return pageSize; }
    }

    /**
     * Creates a new refund
     *
     * @param request Refund creation parameters
     * @return Created refund response
     * @throws IOException if request fails
     */
    public RefundCreateResponse createRefund(RefundCreateRequest request) throws IOException {
        return sendRequest("POST", "/v1/refunds", request, RefundCreateResponse.class);
    }

    /**
     * Retrieves a specific refund by ID
     *
     * @param refundId Refund ID
     * @return Refund details
     * @throws IOException if request fails
     */
    public Refund getRefund(String refundId) throws IOException {
        return sendRequest("GET", "/v1/refunds/" + refundId, null, Refund.class);
    }

    /**
     * Retrieves a list of refunds
     *
     * @param request List parameters
     * @return Refund list response
     * @throws IOException if request fails
     */
    public RefundListResponse listRefunds(RefundListRequest request) throws IOException {
        StringBuilder query = new StringBuilder();
        query.append("page=").append(request.getPage());
        query.append("&page_size=").append(request.getPageSize());

        if (request.getPaymentIntent() != null && !request.getPaymentIntent().isEmpty()) {
            try {
                query.append("&payment_intent=").append(URLEncoder.encode(request.getPaymentIntent(), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                throw new IOException("Failed to encode payment_intent parameter", e);
            }
        }

        return sendRequestWithQuery("/v1/refunds", query.toString(), RefundListResponse.class);
    }
}
