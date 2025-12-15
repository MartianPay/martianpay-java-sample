package com.martianpay.sdk;

import com.martianpay.developer.ApprovalInstance;
import com.martianpay.developer.Payout;
import com.martianpay.developer.PayoutPreviewRequest;
import com.martianpay.developer.PayoutPreviewResp;
import com.martianpay.developer.PayoutCreateRequest;
import com.martianpay.developer.PayoutCreateResp;
import com.martianpay.developer.PayoutGetResp;
import com.martianpay.developer.PayoutListRequest;
import com.martianpay.developer.PayoutListResp;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * PayoutService provides methods for managing payouts
 */
public class PayoutService extends MartianPayClient {

    public PayoutService(String apiKey) {
        super(apiKey);
    }

    public PayoutService(String apiKey, String baseUrl) {
        super(apiKey, baseUrl);
    }

    /**
     * Previews a payout before creation
     *
     * @param request Preview request parameters
     * @return Payout preview response
     * @throws IOException if request fails
     */
    public PayoutPreviewResp previewPayout(PayoutPreviewRequest request) throws IOException {
        return sendRequest("POST", "/v1/payouts/preview", request, PayoutPreviewResp.class);
    }

    /**
     * Creates a new payout
     *
     * @param request Payout creation parameters
     * @return Payout creation response
     * @throws IOException if request fails
     */
    public PayoutCreateResp createPayout(PayoutCreateRequest request) throws IOException {
        return sendRequest("POST", "/v1/payouts", request, PayoutCreateResp.class);
    }

    /**
     * Retrieves payout details
     *
     * @param payoutID Payout ID
     * @return Payout details
     * @throws IOException if request fails
     */
    public PayoutGetResp getPayout(String payoutID) throws IOException {
        String path = String.format("/v1/payouts/%s", payoutID);
        return sendRequest("GET", path, null, PayoutGetResp.class);
    }

    /**
     * Lists all payouts with pagination
     *
     * @param request Payout list request parameters
     * @return Payout list response
     * @throws IOException if request fails
     */
    public PayoutListResp listPayouts(PayoutListRequest request) throws IOException {
        return sendRequestWithQuery("GET", "/v1/payouts", request, PayoutListResp.class);
    }

    /**
     * Cancels a pending payout
     *
     * @param payoutID Payout ID
     * @return Updated payout
     * @throws IOException if request fails
     */
    public Payout cancelPayout(String payoutID) throws IOException {
        String path = String.format("/v1/payouts/%s/cancel", payoutID);
        return sendRequest("POST", path, null, Payout.class);
    }

    /**
     * Retrieves approval instance details
     *
     * @param resourceID Resource ID
     * @return Approval instance
     * @throws IOException if request fails
     */
    public ApprovalInstance getApprovalInstance(String resourceID) throws IOException {
        Map<String, String> params = new HashMap<>();
        params.put("resource_id", resourceID);
        return sendRequestWithQuery("GET", "/v1/approval/detail", params, ApprovalInstance.class);
    }

    /**
     * Approves a payout
     *
     * @param approvalID Approval ID
     * @param comment Comment explaining the approval
     * @throws IOException if request fails
     */
    public void approvePayout(String approvalID, String comment) throws IOException {
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("comment", comment);
        String path = String.format("/v1/approval/%s/approve", approvalID);
        sendRequest("POST", path, requestBody, Void.class);
    }

    /**
     * Rejects a payout
     *
     * @param approvalID Approval ID
     * @param reason Reason for rejection
     * @throws IOException if request fails
     */
    public void rejectPayout(String approvalID, String reason) throws IOException {
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("comment", reason);
        String path = String.format("/v1/approval/%s/reject", approvalID);
        sendRequest("POST", path, requestBody, Void.class);
    }
}
