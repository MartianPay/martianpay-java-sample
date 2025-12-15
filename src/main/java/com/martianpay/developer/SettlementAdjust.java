package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

public class SettlementAdjust {
    public static final String SETTLEMENT_ADJUST_OPERATION_TYPE_MANUAL_AMOUNT = "MANUAL_AMOUNT";
    public static final String SETTLEMENT_ADJUST_OPERATION_TYPE_MANUAL_FROZEN_AMOUNT = "MANUAL_FROZEN_AMOUNT";
    public static final String SETTLEMENT_ADJUST_OPERATION_TYPE_MANUAL_TX_FEE = "MANUAL_TX_FEE";
    public static final String SETTLEMENT_ADJUST_OPERATION_TYPE_MANUAL_TAX_FEE = "MANUAL_TAX_FEE";
    public static final String SETTLEMENT_ADJUST_OPERATION_TYPE_MANUAL_GAS_FEE = "MANUAL_GAS_FEE";

    public static final String SETTLEMENT_ADJUST_STATUS_PENDING = "PENDING";
    public static final String SETTLEMENT_ADJUST_STATUS_APPROVED = "APPROVED";
    public static final String SETTLEMENT_ADJUST_STATUS_REJECTED = "REJECTED";

    @SerializedName("id")
    private String id;

    @SerializedName("statement_id")
    private String settlementId;

    @SerializedName("operation_type")
    private String operationType;

    @SerializedName("amount")
    private String amount;

    @SerializedName("original_amount")
    private String originalAmount;

    @SerializedName("status")
    private String status;

    @SerializedName("operator")
    private String operator;

    @SerializedName("remark")
    private String remark;

    @SerializedName("approver")
    private String approver;

    @SerializedName("approve_remark")
    private String approveRemark;

    @SerializedName("created_at")
    private Long createdAt;

    @SerializedName("updated_at")
    private Long updatedAt;

    public SettlementAdjust() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSettlementId() {
        return settlementId;
    }

    public void setSettlementId(String settlementId) {
        this.settlementId = settlementId;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getOriginalAmount() {
        return originalAmount;
    }

    public void setOriginalAmount(String originalAmount) {
        this.originalAmount = originalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public String getApproveRemark() {
        return approveRemark;
    }

    public void setApproveRemark(String approveRemark) {
        this.approveRemark = approveRemark;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }
}
