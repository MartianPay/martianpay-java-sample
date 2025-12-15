package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

public class SettlementResult {
    @SerializedName("created_at")
    private Long createdAt;

    @SerializedName("statement_id")
    private String settlementId;

    @SerializedName("statement_abstract_info")
    private SettlementAbstractInfo settlementAbstractInfo;

    @SerializedName("merchant")
    private Merchant merchant;

    @SerializedName("type")
    private String type;

    @SerializedName("charge_id")
    private String chargeId;

    @SerializedName("charge_abstract_info")
    private SettlementAbstractInfo chargeAbstractInfo;

    @SerializedName("refund_id")
    private String refundId;

    @SerializedName("refund_abstract_info")
    private SettlementAbstractInfo refundAbstractInfo;

    @SerializedName("status")
    private String status;

    @SerializedName("review_comment")
    private String reviewComment;

    @SerializedName("statement_date")
    private String settlementDate;

    public SettlementResult() {
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public String getSettlementId() {
        return settlementId;
    }

    public void setSettlementId(String settlementId) {
        this.settlementId = settlementId;
    }

    public SettlementAbstractInfo getSettlementAbstractInfo() {
        return settlementAbstractInfo;
    }

    public void setSettlementAbstractInfo(SettlementAbstractInfo settlementAbstractInfo) {
        this.settlementAbstractInfo = settlementAbstractInfo;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getChargeId() {
        return chargeId;
    }

    public void setChargeId(String chargeId) {
        this.chargeId = chargeId;
    }

    public SettlementAbstractInfo getChargeAbstractInfo() {
        return chargeAbstractInfo;
    }

    public void setChargeAbstractInfo(SettlementAbstractInfo chargeAbstractInfo) {
        this.chargeAbstractInfo = chargeAbstractInfo;
    }

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    public SettlementAbstractInfo getRefundAbstractInfo() {
        return refundAbstractInfo;
    }

    public void setRefundAbstractInfo(SettlementAbstractInfo refundAbstractInfo) {
        this.refundAbstractInfo = refundAbstractInfo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReviewComment() {
        return reviewComment;
    }

    public void setReviewComment(String reviewComment) {
        this.reviewComment = reviewComment;
    }

    public String getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(String settlementDate) {
        this.settlementDate = settlementDate;
    }
}
