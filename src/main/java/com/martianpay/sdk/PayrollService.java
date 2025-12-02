package com.martianpay.sdk;

import com.google.gson.annotations.SerializedName;
import com.martianpay.model.Payroll;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

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
     * Direct payroll item
     */
    public static class PayrollDirectItem {
        @SerializedName("external_id")
        private String externalId;

        @SerializedName("name")
        private String name;

        @SerializedName("email")
        private String email;

        @SerializedName("phone")
        private String phone;

        @SerializedName("coin")
        private String coin;

        @SerializedName("network")
        private String network;

        @SerializedName("address")
        private String address;

        @SerializedName("amount")
        private String amount;

        @SerializedName("payment_method")
        private String paymentMethod;

        // Getters and Setters
        public String getExternalId() { return externalId; }
        public void setExternalId(String externalId) { this.externalId = externalId; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public String getPhone() { return phone; }
        public void setPhone(String phone) { this.phone = phone; }
        public String getCoin() { return coin; }
        public void setCoin(String coin) { this.coin = coin; }
        public String getNetwork() { return network; }
        public void setNetwork(String network) { this.network = network; }
        public String getAddress() { return address; }
        public void setAddress(String address) { this.address = address; }
        public String getAmount() { return amount; }
        public void setAmount(String amount) { this.amount = amount; }
        public String getPaymentMethod() { return paymentMethod; }
        public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
    }

    /**
     * Request parameters for creating a direct payroll
     */
    public static class PayrollDirectCreateRequest {
        @SerializedName("external_id")
        private String externalId;

        @SerializedName("items")
        private List<PayrollDirectItem> items;

        @SerializedName("auto_approve")
        private boolean autoApprove;

        public String getExternalId() { return externalId; }
        public void setExternalId(String externalId) { this.externalId = externalId; }
        public List<PayrollDirectItem> getItems() { return items; }
        public void setItems(List<PayrollDirectItem> items) { this.items = items; }
        public boolean isAutoApprove() { return autoApprove; }
        public void setAutoApprove(boolean autoApprove) { this.autoApprove = autoApprove; }
    }

    /**
     * Response for creating a direct payroll
     */
    public static class PayrollDirectCreateResponse {
        @SerializedName("payroll")
        private Payroll payroll;

        public Payroll getPayroll() { return payroll; }
    }

    /**
     * Request parameters for listing payrolls
     */
    public static class PayrollListRequest {
        @SerializedName("page")
        private int page;

        @SerializedName("page_size")
        private int pageSize;

        @SerializedName("start_date")
        private String startDate;

        @SerializedName("end_date")
        private String endDate;

        @SerializedName("external_id")
        private String externalId;

        @SerializedName("payroll_id")
        private String payrollId;

        @SerializedName("status")
        private String status;

        public int getPage() { return page; }
        public void setPage(int page) { this.page = page; }
        public int getPageSize() { return pageSize; }
        public void setPageSize(int pageSize) { this.pageSize = pageSize; }
        public String getStartDate() { return startDate; }
        public void setStartDate(String startDate) { this.startDate = startDate; }
        public String getEndDate() { return endDate; }
        public void setEndDate(String endDate) { this.endDate = endDate; }
        public String getExternalId() { return externalId; }
        public void setExternalId(String externalId) { this.externalId = externalId; }
        public String getPayrollId() { return payrollId; }
        public void setPayrollId(String payrollId) { this.payrollId = payrollId; }
        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }
    }

    /**
     * Response for listing payrolls
     */
    public static class PayrollListResponse {
        @SerializedName("payrolls")
        private List<Payroll> payrolls;

        @SerializedName("total")
        private long total;

        public List<Payroll> getPayrolls() { return payrolls; }
        public long getTotal() { return total; }
    }

    /**
     * Creates a direct payroll with optional auto-approval
     *
     * @param request Payroll creation parameters
     * @return Created payroll response
     * @throws IOException if request fails
     */
    public PayrollDirectCreateResponse createDirectPayroll(PayrollDirectCreateRequest request) throws IOException {
        return sendRequest("POST", "/v1/payrolls/direct", request, PayrollDirectCreateResponse.class);
    }

    /**
     * Retrieves a specific payroll by ID
     *
     * @param payrollId Payroll ID
     * @return Payroll details
     * @throws IOException if request fails
     */
    public Payroll getPayroll(String payrollId) throws IOException {
        return sendRequest("GET", "/v1/payrolls/" + payrollId, null, Payroll.class);
    }

    /**
     * Retrieves a list of payrolls
     *
     * @param request List parameters
     * @return Payroll list response
     * @throws IOException if request fails
     */
    public PayrollListResponse listPayrolls(PayrollListRequest request) throws IOException {
        StringBuilder query = new StringBuilder();
        query.append("page=").append(request.getPage());
        query.append("&page_size=").append(request.getPageSize());

        if (request.getStartDate() != null && !request.getStartDate().isEmpty()) {
            try {
                query.append("&start_date=").append(URLEncoder.encode(request.getStartDate(), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                throw new IOException("Failed to encode start_date parameter", e);
            }
        }

        if (request.getEndDate() != null && !request.getEndDate().isEmpty()) {
            try {
                query.append("&end_date=").append(URLEncoder.encode(request.getEndDate(), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                throw new IOException("Failed to encode end_date parameter", e);
            }
        }

        if (request.getExternalId() != null && !request.getExternalId().isEmpty()) {
            try {
                query.append("&external_id=").append(URLEncoder.encode(request.getExternalId(), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                throw new IOException("Failed to encode external_id parameter", e);
            }
        }

        if (request.getPayrollId() != null && !request.getPayrollId().isEmpty()) {
            try {
                query.append("&payroll_id=").append(URLEncoder.encode(request.getPayrollId(), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                throw new IOException("Failed to encode payroll_id parameter", e);
            }
        }

        if (request.getStatus() != null && !request.getStatus().isEmpty()) {
            try {
                query.append("&status=").append(URLEncoder.encode(request.getStatus(), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                throw new IOException("Failed to encode status parameter", e);
            }
        }

        return sendRequestWithQuery("/v1/payrolls", query.toString(), PayrollListResponse.class);
    }
}
