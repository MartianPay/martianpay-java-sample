package com.martianpay.sdk;

import com.martianpay.developer.RefundCreateRequest;
import com.martianpay.developer.RefundCreateResponse;
import com.martianpay.developer.RefundGetResp;
import com.martianpay.developer.RefundListRequest;
import com.martianpay.developer.RefundListResponse;

import java.io.IOException;

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
     * Creates a refund for a payment
     *
     * @param request Refund creation parameters
     * @return Refund creation response
     * @throws IOException if request fails
     */
    public RefundCreateResponse createRefund(RefundCreateRequest request) throws IOException {
        return sendRequest("POST", "/v1/refunds", request, RefundCreateResponse.class);
    }

    /**
     * Retrieves a specific refund by ID
     *
     * @param refundID Refund ID
     * @return Refund details
     * @throws IOException if request fails
     */
    public RefundGetResp getRefund(String refundID) throws IOException {
        String path = String.format("/v1/refunds/%s", refundID);
        return sendRequest("GET", path, null, RefundGetResp.class);
    }

    /**
     * Lists all refunds with optional filters
     *
     * @param request Refund list request parameters
     * @return Refund list response
     * @throws IOException if request fails
     */
    public RefundListResponse listRefunds(RefundListRequest request) throws IOException {
        return sendRequestWithQuery("GET", "/v1/refunds", request, RefundListResponse.class);
    }
}
