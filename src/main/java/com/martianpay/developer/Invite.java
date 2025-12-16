package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Invite represents an invitation to join a merchant account in the MartianPay system.
 *
 * Invitations enable merchant account owners and administrators to add new team members
 * to their merchant account. The invitation process ensures secure onboarding by:
 * 1. Creating an invitation record with a unique ID
 * 2. Sending an invitation email to the invitee
 * 3. Allowing the invitee to accept the invitation
 * 4. Converting the invitation into an active member upon acceptance
 *
 * Invitation workflow:
 * - An authorized user (owner/admin) creates an invitation
 * - The invitee receives an email with an invitation link
 * - The invitee clicks the link and accepts the invitation
 * - Upon acceptance, a new member record is created
 * - The invitation is marked as completed/consumed
 *
 * Key features:
 * - Email-based invitation delivery
 * - Secure invitation tokens to prevent unauthorized access
 * - Invitation expiration for security
 * - Role assignment upon acceptance
 * - Audit trail of who invited whom
 *
 * Use cases:
 * - Onboard new team members to merchant accounts
 * - Grant access to employees, contractors, or partners
 * - Manage team collaboration and permissions
 * - Track invitation history and acceptance rates
 * - Resend invitations if not accepted
 * - Revoke pending invitations if needed
 */
public class Invite {
    /**
     * Unique identifier for the invitation.
     * Format: invite_[uuid]
     * Used to track invitation status and for secure invitation links.
     */
    @SerializedName("id")
    private String id;

    /**
     * Display name of the merchant account the invitee is being invited to join.
     * Shown in the invitation email to provide context to the invitee.
     * Example: "Acme Corporation"
     */
    @SerializedName("merchant_name")
    private String merchantName;

    /**
     * Email address of the person who sent the invitation.
     * Used for audit trail and to inform the invitee who invited them.
     * Typically the merchant account owner or an administrator.
     */
    @SerializedName("inviter")
    private String inviter;

    /**
     * Email address of the person being invited.
     * This email will receive the invitation message with an acceptance link.
     * Upon acceptance, a member account will be created with this email.
     */
    @SerializedName("invitee")
    private String invitee;

    public Invite() {
    }

    // Getters and Setters

    /**
     * Gets the unique identifier for the invitation.
     * @return The invitation ID
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the invitation.
     * @param id The invitation ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the display name of the merchant account.
     * @return The merchant name
     */
    public String getMerchantName() {
        return merchantName;
    }

    /**
     * Sets the display name of the merchant account.
     * @param merchantName The merchant name
     */
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    /**
     * Gets the email address of the person who sent the invitation.
     * @return The inviter email address
     */
    public String getInviter() {
        return inviter;
    }

    /**
     * Sets the email address of the person who sent the invitation.
     * @param inviter The inviter email address
     */
    public void setInviter(String inviter) {
        this.inviter = inviter;
    }

    /**
     * Gets the email address of the person being invited.
     * @return The invitee email address
     */
    public String getInvitee() {
        return invitee;
    }

    /**
     * Sets the email address of the person being invited.
     * @param invitee The invitee email address
     */
    public void setInvitee(String invitee) {
        this.invitee = invitee;
    }
}
