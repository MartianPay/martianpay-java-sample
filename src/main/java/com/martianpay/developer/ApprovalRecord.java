package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * ApprovalRecord represents a single action taken within an approval workflow instance.
 *
 * Each approval record captures one decision or action by an authorized approver.
 * Records are immutable and create a complete audit trail of all approval activities.
 *
 * Record types include:
 * - Approval actions (approver agreed to the operation)
 * - Rejection actions (approver denied the operation)
 * - Comments and reasoning for the decision
 * - System-generated records (timeouts, auto-approvals, etc.)
 *
 * Key features:
 * - Immutable audit trail (records cannot be modified or deleted)
 * - Approver identification and authentication
 * - Timestamp for compliance and accountability
 * - Optional comments explaining the decision
 * - Role and namespace tracking for access control
 *
 * Use cases:
 * - Compliance audits and regulatory reporting
 * - Investigating approval decision history
 * - Understanding why operations were approved/rejected
 * - Verifying proper authorization procedures
 * - Dispute resolution and investigation
 */
public class ApprovalRecord {
    /**
     * Unique identifier for this approval record.
     * Format: record_[random_id]
     */
    @SerializedName("id")
    private String id;

    /**
     * The action taken by the approver.
     *
     * Possible values:
     * - "approve" - Approver authorized the operation
     * - "reject" - Approver denied the operation
     * - "comment" - Approver added a comment without decision
     * - "timeout" - System auto-action due to deadline
     * - "escalate" - Escalated to higher authority
     */
    @SerializedName("action")
    private String action;

    /**
     * Optional comment or reasoning provided by the approver.
     *
     * Approvers can explain their decision, which is valuable for:
     * - Understanding rejection reasons
     * - Documenting approval conditions or concerns
     * - Providing guidance for future similar requests
     * - Compliance and audit documentation
     *
     * Examples:
     * - "Approved - verified customer identity documents"
     * - "Rejected - amount exceeds daily limit"
     * - "Approved with condition - monitor transaction for 24 hours"
     */
    @SerializedName("comment")
    private String comment;

    /**
     * ID of the user who performed this approval action.
     * Links the action to a specific authenticated user account.
     * Format: user_[random_id]
     */
    @SerializedName("approver_id")
    private String approverID;

    /**
     * Full name of the approver for display purposes.
     * Example: "John Smith"
     *
     * Useful for:
     * - Displaying approval history to end users
     * - Generating approval reports
     * - Dashboard and UI display
     */
    @SerializedName("approver_name")
    private String approverName;

    /**
     * Role ID of the approver at the time of action.
     *
     * Captures which role granted the approval permission:
     * - "role_finance_manager"
     * - "role_cfo"
     * - "role_compliance_officer"
     * - "role_admin"
     *
     * Important for:
     * - Verifying proper authorization level
     * - Compliance requirements
     * - Audit trail accuracy
     * - Role-based access control validation
     */
    @SerializedName("approver_role")
    private String approverRole;

    /**
     * Unix timestamp (in seconds) when this action was performed.
     * Used for chronological ordering and compliance reporting.
     */
    @SerializedName("created_at")
    private Long createdAt;

    /**
     * Namespace for role-based access control.
     *
     * Defines the scope or context for role permissions:
     * - "merchant" - Merchant-level permissions
     * - "platform" - Platform-wide permissions
     * - "department" - Department-specific permissions
     *
     * Ensures approvers have authority in the correct context.
     */
    @SerializedName("namespace")
    private String namespace;

    /**
     * Gets the unique identifier for this record.
     * @return The record ID
     */
    public String getId() { return id; }

    /**
     * Sets the unique identifier for this record.
     * @param id The record ID
     */
    public void setId(String id) { this.id = id; }

    /**
     * Gets the action taken by the approver.
     * @return The action type ("approve", "reject", etc.)
     */
    public String getAction() { return action; }

    /**
     * Sets the action taken by the approver.
     * @param action The action type
     */
    public void setAction(String action) { this.action = action; }

    /**
     * Gets the optional comment from the approver.
     * @return The comment text, or null if no comment provided
     */
    public String getComment() { return comment; }

    /**
     * Sets the optional comment from the approver.
     * @param comment The comment text
     */
    public void setComment(String comment) { this.comment = comment; }

    /**
     * Gets the approver's user ID.
     * @return The approver ID
     */
    public String getApproverID() { return approverID; }

    /**
     * Sets the approver's user ID.
     * @param approverID The approver ID
     */
    public void setApproverID(String approverID) { this.approverID = approverID; }

    /**
     * Gets the approver's full name.
     * @return The approver name
     */
    public String getApproverName() { return approverName; }

    /**
     * Sets the approver's full name.
     * @param approverName The approver name
     */
    public void setApproverName(String approverName) { this.approverName = approverName; }

    /**
     * Gets the approver's role ID.
     * @return The role ID
     */
    public String getApproverRole() { return approverRole; }

    /**
     * Sets the approver's role ID.
     * @param approverRole The role ID
     */
    public void setApproverRole(String approverRole) { this.approverRole = approverRole; }

    /**
     * Gets the Unix timestamp when the action was performed.
     * @return Creation timestamp in seconds
     */
    public Long getCreatedAt() { return createdAt; }

    /**
     * Sets the Unix timestamp when the action was performed.
     * @param createdAt Creation timestamp in seconds
     */
    public void setCreatedAt(Long createdAt) { this.createdAt = createdAt; }

    /**
     * Gets the namespace for role-based access control.
     * @return The namespace identifier
     */
    public String getNamespace() { return namespace; }

    /**
     * Sets the namespace for role-based access control.
     * @param namespace The namespace identifier
     */
    public void setNamespace(String namespace) { this.namespace = namespace; }
}
