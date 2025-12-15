package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Permission defines access control rules for resources
 */
public class Permission {
    /**
     * Allow is the list of allowed resource patterns
     */
    @SerializedName("allow")
    private List<String> allow;

    /**
     * Deny is the list of denied resource patterns
     */
    @SerializedName("deny")
    private List<String> deny;

    public Permission() {
    }

    // Getters and Setters
    public List<String> getAllow() {
        return allow;
    }

    public void setAllow(List<String> allow) {
        this.allow = allow;
    }

    public List<String> getDeny() {
        return deny;
    }

    public void setDeny(List<String> deny) {
        this.deny = deny;
    }
}
