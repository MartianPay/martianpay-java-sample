package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Request to list individual payroll items with optional filtering.
 */
public class PayrollItemsListRequest {
    /**
     * Page number for pagination (zero-indexed).
     */
    @SerializedName("page")
    private Integer page;

    /**
     * Number of payroll items to return per page.
     */
    @SerializedName("page_size")
    private Integer pageSize;

    /**
     * Filter by start date (ISO 8601 format: YYYY-MM-DD).
     */
    @SerializedName("start_date")
    private String startDate;

    /**
     * Filter by end date (ISO 8601 format: YYYY-MM-DD).
     */
    @SerializedName("end_date")
    private String endDate;

    /**
     * Filter by employee name.
     */
    @SerializedName("employee_name")
    private String employeeName;

    /**
     * Filter by payroll batch external ID.
     */
    @SerializedName("external_id")
    private String externalId;

    /**
     * Filter by payroll batch ID.
     */
    @SerializedName("payroll_id")
    private String payrollId;

    /**
     * Filter by individual item external ID.
     */
    @SerializedName("item_external_id")
    private String itemExternalId;

    public PayrollItemsListRequest() {
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getPayrollId() {
        return payrollId;
    }

    public void setPayrollId(String payrollId) {
        this.payrollId = payrollId;
    }

    public String getItemExternalId() {
        return itemExternalId;
    }

    public void setItemExternalId(String itemExternalId) {
        this.itemExternalId = itemExternalId;
    }
}
