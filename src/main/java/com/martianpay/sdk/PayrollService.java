package com.martianpay.sdk;

import com.martianpay.developer.PayrollDirectCreateRequest;
import com.martianpay.developer.PayrollDirectCreateResponse;
import com.martianpay.developer.PayrollConfirmRequest;
import com.martianpay.developer.PayrollConfirmResponse;
import com.martianpay.developer.PayrollGetResponse;
import com.martianpay.developer.PayrollListRequest;
import com.martianpay.developer.PayrollListResponse;
import com.martianpay.developer.PayrollItemsListRequest;
import com.martianpay.developer.PayrollItemsListResponse;

import java.io.IOException;

/**
 * PayrollService provides methods for managing payrolls
 */
public class PayrollService extends MartianPayClient {

    public PayrollService(String apiKey) {
        super(apiKey);
    }

    public PayrollService(String apiKey, String baseUrl) {
        super(apiKey, baseUrl);
    }

    /**
     * Creates a direct payroll
     *
     * @param request Payroll creation parameters
     * @return Payroll creation response
     * @throws IOException if request fails
     */
    public PayrollDirectCreateResponse createDirectPayroll(PayrollDirectCreateRequest request) throws IOException {
        return sendRequest("POST", "/v1/payrolls/direct", request, PayrollDirectCreateResponse.class);
    }

    /**
     * Confirms a payroll
     *
     * @param payrollID Payroll ID
     * @param request Confirm request parameters
     * @return Payroll confirm response
     * @throws IOException if request fails
     */
    public PayrollConfirmResponse confirmPayroll(String payrollID, PayrollConfirmRequest request) throws IOException {
        String path = String.format("/v1/payrolls/%s/confirm", payrollID);
        return sendRequest("POST", path, request, PayrollConfirmResponse.class);
    }

    /**
     * Retrieves payroll details
     *
     * @param payrollID Payroll ID
     * @return Payroll details
     * @throws IOException if request fails
     */
    public PayrollGetResponse getPayroll(String payrollID) throws IOException {
        String path = String.format("/v1/payrolls/%s", payrollID);
        return sendRequest("GET", path, null, PayrollGetResponse.class);
    }

    /**
     * Lists all payrolls with pagination
     *
     * @param request Payroll list request parameters
     * @return Payroll list response
     * @throws IOException if request fails
     */
    public PayrollListResponse listPayrolls(PayrollListRequest request) throws IOException {
        return sendRequestWithQuery("GET", "/v1/payrolls", request, PayrollListResponse.class);
    }

    /**
     * Lists payroll items with pagination
     *
     * @param request Payroll items list request parameters
     * @return Payroll items list response
     * @throws IOException if request fails
     */
    public PayrollItemsListResponse listPayrollItems(PayrollItemsListRequest request) throws IOException {
        return sendRequestWithQuery("GET", "/v1/payrolls/items/list", request, PayrollItemsListResponse.class);
    }
}
