package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * SettlementAdjust represents a manual adjustment request for a settlement transaction.
 *
 * Settlement adjustments allow operators to manually modify settlement amounts, fees, or frozen funds
 * when discrepancies are identified or corrections are needed. All adjustments require approval
 * through a multi-step workflow to ensure financial accuracy and audit compliance.
 *
 * Key features:
 * - Multiple adjustment types (amount, fees, frozen funds)
 * - Approval workflow with status tracking
 * - Audit trail with operator and approver information
 * - Original and adjusted amount tracking
 * - Remarks for justification and approval notes
 *
 * Use cases:
 * - Correcting settlement calculation errors
 * - Adjusting fees after disputes or negotiations
 * - Releasing or increasing frozen amounts based on compliance review
 * - Fixing gas fee miscalculations
 * - Manual tax adjustments for special circumstances
 *
 * Example workflow:
 * 1. Operator creates adjustment request to reduce tx_fee from $5 to $3
 * 2. Status: PENDING
 * 3. Finance manager reviews and approves
 * 4. Status: APPROVED
 * 5. Settlement is updated with new amount
 * 6. Full audit trail is maintained
 */
public class SettlementAdjust {
    /**
     * Adjustment type for manually correcting the main settlement amount.
     * Used when the settled amount needs to be increased or decreased.
     */
    public static final String SETTLEMENT_ADJUST_OPERATION_TYPE_MANUAL_AMOUNT = "MANUAL_AMOUNT";

    /**
     * Adjustment type for modifying frozen amounts.
     * Used to release frozen funds or increase frozen amount for compliance.
     */
    public static final String SETTLEMENT_ADJUST_OPERATION_TYPE_MANUAL_FROZEN_AMOUNT = "MANUAL_FROZEN_AMOUNT";

    /**
     * Adjustment type for correcting transaction processing fees.
     * Used when fees need adjustment due to errors or negotiations.
     */
    public static final String SETTLEMENT_ADJUST_OPERATION_TYPE_MANUAL_TX_FEE = "MANUAL_TX_FEE";

    /**
     * Adjustment type for correcting tax amounts.
     * Used for tax rate changes or jurisdiction corrections.
     */
    public static final String SETTLEMENT_ADJUST_OPERATION_TYPE_MANUAL_TAX_FEE = "MANUAL_TAX_FEE";

    /**
     * Adjustment type for correcting blockchain gas fees.
     * Used when gas fees were miscalculated or need reimbursement.
     */
    public static final String SETTLEMENT_ADJUST_OPERATION_TYPE_MANUAL_GAS_FEE = "MANUAL_GAS_FEE";

    /**
     * Status indicating the adjustment is awaiting approval.
     * Initial state when adjustment is created.
     */
    public static final String SETTLEMENT_ADJUST_STATUS_PENDING = "PENDING";

    /**
     * Status indicating the adjustment has been approved and applied.
     * Settlement has been updated with the adjusted values.
     */
    public static final String SETTLEMENT_ADJUST_STATUS_APPROVED = "APPROVED";

    /**
     * Status indicating the adjustment was rejected and not applied.
     * Settlement remains unchanged.
     */
    public static final String SETTLEMENT_ADJUST_STATUS_REJECTED = "REJECTED";

    /**
     * Unique identifier for this settlement adjustment.
     * Format: sadj_[random_id]
     */
    @SerializedName("id")
    private String id;

    /**
     * ID of the settlement being adjusted.
     * Links this adjustment to the target settlement transaction.
     * Format: settlement_[random_id]
     */
    @SerializedName("statement_id")
    private String settlementId;

    /**
     * Type of adjustment operation being performed.
     * Determines which field of the settlement is being modified.
     * Values: MANUAL_AMOUNT, MANUAL_FROZEN_AMOUNT, MANUAL_TX_FEE, MANUAL_TAX_FEE, MANUAL_GAS_FEE
     */
    @SerializedName("operation_type")
    private String operationType;

    /**
     * New amount after the adjustment.
     * The corrected value that will replace the original if approved.
     * Stored as string for precision.
     */
    @SerializedName("amount")
    private String amount;

    /**
     * Original amount before the adjustment.
     * Preserved for audit trail and comparison purposes.
     * Stored as string for precision.
     */
    @SerializedName("original_amount")
    private String originalAmount;

    /**
     * Current status of the adjustment request.
     * Values: PENDING (awaiting approval), APPROVED (applied), REJECTED (denied).
     */
    @SerializedName("status")
    private String status;

    /**
     * Identifier of the operator who created the adjustment request.
     * Typically a user ID or email for audit purposes.
     */
    @SerializedName("operator")
    private String operator;

    /**
     * Explanation or justification for the adjustment.
     * Should describe why the adjustment is needed and provide supporting details.
     * Required for approval review.
     */
    @SerializedName("remark")
    private String remark;

    /**
     * Identifier of the user who approved or rejected the adjustment.
     * Null if still pending. Populated when status changes to APPROVED or REJECTED.
     */
    @SerializedName("approver")
    private String approver;

    /**
     * Approver's comments when approving or rejecting the adjustment.
     * Provides rationale for the approval decision.
     * Null if still pending.
     */
    @SerializedName("approve_remark")
    private String approveRemark;

    /**
     * Unix timestamp (in seconds) when this adjustment was created.
     */
    @SerializedName("created_at")
    private Long createdAt;

    /**
     * Unix timestamp (in seconds) when this adjustment was last updated.
     * Updates when status changes or approval is processed.
     */
    @SerializedName("updated_at")
    private Long updatedAt;

    public SettlementAdjust() {
    }

    /**
     * Gets the adjustment ID.
     * @return The adjustment ID
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the adjustment ID.
     * @param id The adjustment ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the settlement ID being adjusted.
     * @return The settlement ID
     */
    public String getSettlementId() {
        return settlementId;
    }

    /**
     * Sets the settlement ID being adjusted.
     * @param settlementId The settlement ID
     */
    public void setSettlementId(String settlementId) {
        this.settlementId = settlementId;
    }

    /**
     * Gets the operation type for this adjustment.
     * @return The operation type constant
     */
    public String getOperationType() {
        return operationType;
    }

    /**
     * Sets the operation type for this adjustment.
     * @param operationType The operation type constant
     */
    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    /**
     * Gets the new adjusted amount.
     * @return The amount after adjustment
     */
    public String getAmount() {
        return amount;
    }

    /**
     * Sets the new adjusted amount.
     * @param amount The amount after adjustment
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * Gets the original amount before adjustment.
     * @return The original amount
     */
    public String getOriginalAmount() {
        return originalAmount;
    }

    /**
     * Sets the original amount before adjustment.
     * @param originalAmount The original amount
     */
    public void setOriginalAmount(String originalAmount) {
        this.originalAmount = originalAmount;
    }

    /**
     * Gets the current adjustment status.
     * @return The status (PENDING, APPROVED, or REJECTED)
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the current adjustment status.
     * @param status The status (PENDING, APPROVED, or REJECTED)
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the operator who created this adjustment.
     * @return The operator identifier
     */
    public String getOperator() {
        return operator;
    }

    /**
     * Sets the operator who created this adjustment.
     * @param operator The operator identifier
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * Gets the justification remark.
     * @return The remark explaining the adjustment
     */
    public String getRemark() {
        return remark;
    }

    /**
     * Sets the justification remark.
     * @param remark The remark explaining the adjustment
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * Gets the approver identifier.
     * @return The approver, or null if pending
     */
    public String getApprover() {
        return approver;
    }

    /**
     * Sets the approver identifier.
     * @param approver The approver, or null if pending
     */
    public void setApprover(String approver) {
        this.approver = approver;
    }

    /**
     * Gets the approver's remark.
     * @return The approval/rejection comment, or null if pending
     */
    public String getApproveRemark() {
        return approveRemark;
    }

    /**
     * Sets the approver's remark.
     * @param approveRemark The approval/rejection comment
     */
    public void setApproveRemark(String approveRemark) {
        this.approveRemark = approveRemark;
    }

    /**
     * Gets the creation timestamp.
     * @return Unix timestamp in seconds
     */
    public Long getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the creation timestamp.
     * @param createdAt Unix timestamp in seconds
     */
    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets the last update timestamp.
     * @return Unix timestamp in seconds
     */
    public Long getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Sets the last update timestamp.
     * @param updatedAt Unix timestamp in seconds
     */
    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }
}
