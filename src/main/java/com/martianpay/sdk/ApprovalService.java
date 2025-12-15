package com.martianpay.sdk;

import com.martianpay.developer.ApprovalGetRequest;
import com.martianpay.developer.ApprovalInstance;

import java.io.IOException;

/**
 * ApprovalService provides methods for managing approvals
 */
public class ApprovalService extends MartianPayClient {

    public ApprovalService(String apiKey) {
        super(apiKey);
    }

    public ApprovalService(String apiKey, String baseUrl) {
        super(apiKey, baseUrl);
    }

    /**
     * Gets approval details
     *
     * @param params Approval get request parameters
     * @return Approval instance details
     * @throws IOException if request fails
     */
    public ApprovalInstance getApprovalDetail(ApprovalGetRequest params) throws IOException {
        return sendRequestWithQuery("GET", "/v1/approval/detail", params, ApprovalInstance.class);
    }

    /**
     * Approves approval
     *
     * @param approvalID Approval ID to approve
     * @return Updated approval instance
     * @throws IOException if request fails
     */
    public ApprovalInstance approveApproval(String approvalID) throws IOException {
        String path = String.format("/v1/approval/%s/approve", approvalID);
        return sendRequest("POST", path, null, ApprovalInstance.class);
    }

    /**
     * Rejects approval
     *
     * @param approvalID Approval ID to reject
     * @return Updated approval instance
     * @throws IOException if request fails
     */
    public ApprovalInstance rejectApproval(String approvalID) throws IOException {
        String path = String.format("/v1/approval/%s/reject", approvalID);
        return sendRequest("POST", path, null, ApprovalInstance.class);
    }
}
