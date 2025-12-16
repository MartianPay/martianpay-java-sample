package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Member represents a member of a merchant account in the MartianPay system.
 *
 * Members are users who have access to a merchant account. Each member can have different
 * roles and permissions, enabling fine-grained access control and team collaboration.
 * The member model supports team management, role-based access control, and invitation workflows.
 *
 * Member lifecycle:
 * 1. Owner creates an invitation for a new member
 * 2. Invitee receives invitation email (status: "inviting")
 * 3. Invitee accepts invitation and completes onboarding
 * 4. Member record created with "active" status
 * 5. Member can be deactivated (status: "inactive") without deletion
 *
 * Member statuses:
 * - active: Member has full access according to their roles
 * - inactive: Member is temporarily disabled, cannot access account
 * - inviting: Invitation sent but not yet accepted
 *
 * Role-based access control:
 * - owner: Account owner with full administrative privileges (only one per account)
 * - admin: Administrative privileges but cannot delete account
 * - developer: Can access API keys and technical resources
 * - finance: Can view billing and financial information
 * - support: Can assist customers and view transactions
 * - custom roles: Merchants can define custom role permissions
 *
 * Use cases:
 * - Team collaboration on merchant accounts
 * - Delegating specific responsibilities to team members
 * - Managing access permissions for employees and contractors
 * - Audit trail of who has access to merchant resources
 * - Temporary access grants via invitations
 * - Role-based UI and API access restrictions
 */
public class Member {
    public static final String MEMBER_OBJECT = "member";
    public static final int MEMBER_ID_LENGTH = 24;
    public static final String MEMBER_ID_PREFIX = "member_";

    public static final int INVITE_ID_LENGTH = 36;
    public static final String INVITE_ID_PREFIX = "invite_";

    public static final String MEMBER_STATUS_ACTIVE = "active";
    public static final String MEMBER_STATUS_INACTIVE = "inactive";
    public static final String MEMBER_STATUS_INVITING = "inviting";

    /**
     * ID is the unique identifier for the member
     */
    @SerializedName("id")
    private String id;

    /**
     * Object is the type identifier, always "member"
     */
    @SerializedName("object")
    private String object;

    /**
     * Email is the member's email address
     */
    @SerializedName("email")
    private String email;

    /**
     * Owner indicates whether this member is the account owner
     */
    @SerializedName("owner")
    private Boolean owner;

    /**
     * Roles is the list of roles assigned to this member
     */
    @SerializedName("roles")
    private List<Role> roles;

    /**
     * Status is the current status of the member (active, inactive, inviting)
     */
    @SerializedName("status")
    private String status;

    /**
     * InviteId is the ID of the invitation if the member is in inviting status
     */
    @SerializedName("invite_id")
    private String inviteId;

    public Member() {
    }

    // Getters and Setters

    /**
     * Gets the unique identifier for the member.
     * @return The member ID
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the member.
     * @param id The member ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the type identifier, always "member".
     * @return The object type
     */
    public String getObject() {
        return object;
    }

    /**
     * Sets the type identifier.
     * @param object The object type
     */
    public void setObject(String object) {
        this.object = object;
    }

    /**
     * Gets the member's email address.
     * @return The email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the member's email address.
     * @param email The email address
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets whether this member is the account owner.
     * @return True if owner, false otherwise
     */
    public Boolean getOwner() {
        return owner;
    }

    /**
     * Sets whether this member is the account owner.
     * @param owner True if owner, false otherwise
     */
    public void setOwner(Boolean owner) {
        this.owner = owner;
    }

    /**
     * Gets the list of roles assigned to this member.
     * @return The list of roles
     */
    public List<Role> getRoles() {
        return roles;
    }

    /**
     * Sets the list of roles assigned to this member.
     * @param roles The list of roles
     */
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    /**
     * Gets the current status of the member.
     * @return The status (active, inactive, or inviting)
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the current status of the member.
     * @param status The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the invitation ID if the member is in inviting status.
     * @return The invitation ID, or null if not applicable
     */
    public String getInviteId() {
        return inviteId;
    }

    /**
     * Sets the invitation ID if the member is in inviting status.
     * @param inviteId The invitation ID
     */
    public void setInviteId(String inviteId) {
        this.inviteId = inviteId;
    }
}
