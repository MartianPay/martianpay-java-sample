package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * ApprovalStep represents a single step in an approval workflow
 */
public class ApprovalStep {
    @SerializedName("id")
    private String id;

    @SerializedName("flow_id")
    private String flowID;

    @SerializedName("step_order")
    private Integer stepOrder;

    @SerializedName("namespace")
    private String namespace;

    @SerializedName("roles")
    private List<String> roles;

    @SerializedName("next_on_approve")
    private Integer nextOnApprove;

    @SerializedName("next_on_reject")
    private Integer nextOnReject;

    @SerializedName("created_at")
    private Long createdAt;

    @SerializedName("updated_at")
    private Long updatedAt;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getFlowID() { return flowID; }
    public void setFlowID(String flowID) { this.flowID = flowID; }

    public Integer getStepOrder() { return stepOrder; }
    public void setStepOrder(Integer stepOrder) { this.stepOrder = stepOrder; }

    public String getNamespace() { return namespace; }
    public void setNamespace(String namespace) { this.namespace = namespace; }

    public List<String> getRoles() { return roles; }
    public void setRoles(List<String> roles) { this.roles = roles; }

    public Integer getNextOnApprove() { return nextOnApprove; }
    public void setNextOnApprove(Integer nextOnApprove) { this.nextOnApprove = nextOnApprove; }

    public Integer getNextOnReject() { return nextOnReject; }
    public void setNextOnReject(Integer nextOnReject) { this.nextOnReject = nextOnReject; }

    public Long getCreatedAt() { return createdAt; }
    public void setCreatedAt(Long createdAt) { this.createdAt = createdAt; }

    public Long getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Long updatedAt) { this.updatedAt = updatedAt; }
}
