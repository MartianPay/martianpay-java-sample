package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Payroll represents a payroll batch
 */
public class Payroll {
    /**
     * ID is the unique identifier for the payroll
     */
    @SerializedName("id")
    private String id;

    /**
     * CreatedAt is the Unix timestamp when the payroll was created
     */
    @SerializedName("created_at")
    private Long createdAt;

    /**
     * UpdatedAt is the Unix timestamp when the payroll was last updated
     */
    @SerializedName("updated_at")
    private Long updatedAt;

    /**
     * CanceledAt is the Unix timestamp when the payroll was canceled, if applicable
     */
    @SerializedName("canceled_at")
    private Long canceledAt;

    /**
     * MerchantID is the ID of the merchant who created the payroll
     */
    @SerializedName("merchant_id")
    private String merchantID;

    /**
     * ExternalID is the external ID for idempotency
     */
    @SerializedName("external_id")
    private String externalID;

    /**
     * ApprovalStatus is the current approval status of the payroll
     */
    @SerializedName("approval_status")
    private String approvalStatus;

    /**
     * Status is the current processing status of the payroll
     */
    @SerializedName("status")
    private String status;

    /**
     * TotalItemNum is the total number of items in the payroll
     */
    @SerializedName("total_item_num")
    private Long totalItemNum;

    /**
     * TotalAmount is the total amount to be paid in the payroll
     */
    @SerializedName("total_amount")
    private String totalAmount;

    /**
     * TotalServiceFee is the total service fee for the payroll
     */
    @SerializedName("total_service_fee")
    private String totalServiceFee;

    /**
     * Currency is the currency used for the payroll
     */
    @SerializedName("currency")
    private String currency;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Long getCreatedAt() { return createdAt; }
    public void setCreatedAt(Long createdAt) { this.createdAt = createdAt; }

    public Long getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Long updatedAt) { this.updatedAt = updatedAt; }

    public Long getCanceledAt() { return canceledAt; }
    public void setCanceledAt(Long canceledAt) { this.canceledAt = canceledAt; }

    public String getMerchantID() { return merchantID; }
    public void setMerchantID(String merchantID) { this.merchantID = merchantID; }

    public String getExternalID() { return externalID; }
    public void setExternalID(String externalID) { this.externalID = externalID; }

    public String getApprovalStatus() { return approvalStatus; }
    public void setApprovalStatus(String approvalStatus) { this.approvalStatus = approvalStatus; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Long getTotalItemNum() { return totalItemNum; }
    public void setTotalItemNum(Long totalItemNum) { this.totalItemNum = totalItemNum; }

    public String getTotalAmount() { return totalAmount; }
    public void setTotalAmount(String totalAmount) { this.totalAmount = totalAmount; }

    public String getTotalServiceFee() { return totalServiceFee; }
    public void setTotalServiceFee(String totalServiceFee) { this.totalServiceFee = totalServiceFee; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
}
