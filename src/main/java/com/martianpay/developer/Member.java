package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Member represents a member of a merchant account
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
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getOwner() {
        return owner;
    }

    public void setOwner(Boolean owner) {
        this.owner = owner;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInviteId() {
        return inviteId;
    }

    public void setInviteId(String inviteId) {
        this.inviteId = inviteId;
    }
}
