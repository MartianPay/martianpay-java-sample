package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * ApprovalStep represents a single step in a multi-stage approval workflow.
 *
 * An approval workflow consists of multiple sequential or conditional steps,
 * where each step requires approval from specific roles before proceeding.
 * This enables complex approval chains such as:
 * - Sequential approval: Manager → Director → CFO
 * - Parallel approval: Two managers must both approve
 * - Conditional routing: Different paths based on approve/reject decisions
 *
 * Each step defines:
 * - Which roles can approve at this stage
 * - The order in the workflow sequence
 * - Next step to transition to upon approval
 * - Next step to transition to upon rejection
 *
 * Example workflow:
 * Step 1 (Order 0): Finance team reviews → Approve goes to Step 2, Reject ends workflow
 * Step 2 (Order 1): Executive approval → Approve executes operation, Reject goes back to Step 1
 */
public class ApprovalStep {
    /**
     * Unique identifier for this approval step.
     * Format: step_[random_id]
     */
    @SerializedName("id")
    private String id;

    /**
     * ID of the approval flow that this step belongs to.
     * Links this step to its parent workflow configuration.
     */
    @SerializedName("flow_id")
    private String flowID;

    /**
     * Order/sequence number of this step in the workflow.
     * Lower numbers execute first (e.g., 0, 1, 2...).
     * Used to determine the execution sequence of steps.
     */
    @SerializedName("step_order")
    private Integer stepOrder;

    /**
     * Namespace for role-based access control.
     * Defines the scope or context for role permissions.
     * Example: "merchant", "admin", "finance_department"
     */
    @SerializedName("namespace")
    private String namespace;

    /**
     * List of role IDs that are authorized to approve/reject at this step.
     * Users must have at least one of these roles to act on this step.
     * Example: ["role_finance_manager", "role_cfo"]
     */
    @SerializedName("roles")
    private List<String> roles;

    /**
     * The step order to transition to if this step is approved.
     * - Positive number: Go to that specific step order
     * - -1 or null: Complete the workflow (final approval)
     * - 0: Stay at current step (for parallel approvals)
     */
    @SerializedName("next_on_approve")
    private Integer nextOnApprove;

    /**
     * The step order to transition to if this step is rejected.
     * - Positive number: Go to that specific step order (e.g., route back to previous step)
     * - -1 or null: Terminate the workflow (rejection ends process)
     * - 0: Stay at current step for re-evaluation
     */
    @SerializedName("next_on_reject")
    private Integer nextOnReject;

    /**
     * Unix timestamp (in seconds) when this approval step was created.
     */
    @SerializedName("created_at")
    private Long createdAt;

    /**
     * Unix timestamp (in seconds) when this approval step was last updated.
     */
    @SerializedName("updated_at")
    private Long updatedAt;

    // Getters and Setters

    /**
     * Gets the unique identifier for this approval step.
     * @return The step ID
     */
    public String getId() { return id; }

    /**
     * Sets the unique identifier for this approval step.
     * @param id The step ID
     */
    public void setId(String id) { this.id = id; }

    /**
     * Gets the ID of the approval flow that this step belongs to.
     * @return The flow ID
     */
    public String getFlowID() { return flowID; }

    /**
     * Sets the ID of the approval flow that this step belongs to.
     * @param flowID The flow ID
     */
    public void setFlowID(String flowID) { this.flowID = flowID; }

    /**
     * Gets the order/sequence number of this step in the workflow.
     * @return The step order (0-based index)
     */
    public Integer getStepOrder() { return stepOrder; }

    /**
     * Sets the order/sequence number of this step in the workflow.
     * @param stepOrder The step order (0-based index)
     */
    public void setStepOrder(Integer stepOrder) { this.stepOrder = stepOrder; }

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

    /**
     * Gets the list of role IDs authorized to act on this step.
     * @return List of role IDs
     */
    public List<String> getRoles() { return roles; }

    /**
     * Sets the list of role IDs authorized to act on this step.
     * @param roles List of role IDs
     */
    public void setRoles(List<String> roles) { this.roles = roles; }

    /**
     * Gets the next step order to transition to upon approval.
     * @return The next step order, or -1/null for workflow completion
     */
    public Integer getNextOnApprove() { return nextOnApprove; }

    /**
     * Sets the next step order to transition to upon approval.
     * @param nextOnApprove The next step order, or -1/null for workflow completion
     */
    public void setNextOnApprove(Integer nextOnApprove) { this.nextOnApprove = nextOnApprove; }

    /**
     * Gets the next step order to transition to upon rejection.
     * @return The next step order, or -1/null for workflow termination
     */
    public Integer getNextOnReject() { return nextOnReject; }

    /**
     * Sets the next step order to transition to upon rejection.
     * @param nextOnReject The next step order, or -1/null for workflow termination
     */
    public void setNextOnReject(Integer nextOnReject) { this.nextOnReject = nextOnReject; }

    /**
     * Gets the Unix timestamp when this step was created.
     * @return Creation timestamp in seconds
     */
    public Long getCreatedAt() { return createdAt; }

    /**
     * Sets the Unix timestamp when this step was created.
     * @param createdAt Creation timestamp in seconds
     */
    public void setCreatedAt(Long createdAt) { this.createdAt = createdAt; }

    /**
     * Gets the Unix timestamp when this step was last updated.
     * @return Last update timestamp in seconds
     */
    public Long getUpdatedAt() { return updatedAt; }

    /**
     * Sets the Unix timestamp when this step was last updated.
     * @param updatedAt Last update timestamp in seconds
     */
    public void setUpdatedAt(Long updatedAt) { this.updatedAt = updatedAt; }
}
