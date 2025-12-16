package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Batch payment operation for distributing funds to multiple recipients.
 * Status lifecycle: created -> pending -> executing -> completed/failed/canceled.
 */
public class Payroll {
    /** Unique identifier for the payroll batch (format: payroll_[random_id]). */
    @SerializedName("id")
    private String id;

    /** Unix timestamp when the payroll was created. */
    @SerializedName("created_at")
    private Long createdAt;

    /** Unix timestamp when the payroll was last updated. */
    @SerializedName("updated_at")
    private Long updatedAt;

    /** Unix timestamp when the payroll was canceled (null if not canceled). */
    @SerializedName("canceled_at")
    private Long canceledAt;

    /** Merchant ID who created this payroll. */
    @SerializedName("merchant_id")
    private String merchantID;

    /** External reference ID for idempotency and tracking. */
    @SerializedName("external_id")
    private String externalID;

    /** Approval status (pending, approved, rejected, or null). */
    @SerializedName("approval_status")
    private String approvalStatus;

    /** Processing status (created, pending, executing, completed, failed, canceled). */
    @SerializedName("status")
    private String status;

    /** Total number of payment items in this batch. */
    @SerializedName("total_item_num")
    private Long totalItemNum;

    /** Total amount to be paid across all items (before fees). */
    @SerializedName("total_amount")
    private String totalAmount;

    /** Total service fee for processing the payroll batch. */
    @SerializedName("total_service_fee")
    private String totalServiceFee;

    /** Currency used for all payments (e.g., "USDT", "USDC"). Currently only USD is supported. */
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
