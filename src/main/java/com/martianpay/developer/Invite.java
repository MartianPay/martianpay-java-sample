package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Invite represents an invitation to join a merchant account
 */
public class Invite {
    /**
     * ID is the unique identifier for the invitation
     */
    @SerializedName("id")
    private String id;

    /**
     * MerchantName is the name of the merchant the user is invited to
     */
    @SerializedName("merchant_name")
    private String merchantName;

    /**
     * Inviter is the email of the person who sent the invitation
     */
    @SerializedName("inviter")
    private String inviter;

    /**
     * Invitee is the email address of the person being invited
     */
    @SerializedName("invitee")
    private String invitee;

    public Invite() {
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getInviter() {
        return inviter;
    }

    public void setInviter(String inviter) {
        this.inviter = inviter;
    }

    public String getInvitee() {
        return invitee;
    }

    public void setInvitee(String invitee) {
        this.invitee = invitee;
    }
}
