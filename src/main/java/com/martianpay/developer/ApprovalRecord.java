package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * ApprovalRecord represents a single approval action record
 */
public class ApprovalRecord {
    @SerializedName("id")
    private String id;

    @SerializedName("action")
    private String action;

    @SerializedName("comment")
    private String comment;

    @SerializedName("approver_id")
    private String approverID;

    @SerializedName("approver_name")
    private String approverName;

    @SerializedName("approver_role")
    private String approverRole;

    @SerializedName("created_at")
    private Long createdAt;

    @SerializedName("namespace")
    private String namespace;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public String getApproverID() { return approverID; }
    public void setApproverID(String approverID) { this.approverID = approverID; }

    public String getApproverName() { return approverName; }
    public void setApproverName(String approverName) { this.approverName = approverName; }

    public String getApproverRole() { return approverRole; }
    public void setApproverRole(String approverRole) { this.approverRole = approverRole; }

    public Long getCreatedAt() { return createdAt; }
    public void setCreatedAt(Long createdAt) { this.createdAt = createdAt; }

    public String getNamespace() { return namespace; }
    public void setNamespace(String namespace) { this.namespace = namespace; }
}
