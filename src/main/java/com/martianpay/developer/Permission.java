package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Access control rules using allow and deny lists with pattern matching.
 * Deny patterns take precedence over allow patterns. Supports wildcards for flexible resource matching.
 */
public class Permission {
    /**
     * Allowed resource patterns. Supports wildcards. Deny patterns take precedence.
     */
    @SerializedName("allow")
    private List<String> allow;

    /**
     * Denied resource patterns. Takes precedence over allow patterns. Supports wildcards.
     */
    @SerializedName("deny")
    private List<String> deny;

    /**
     * Default constructor for Permission.
     */
    public Permission() {
    }

    /**
     * Gets the list of allowed resource patterns.
     * @return List of allow patterns, or null if not set
     */
    public List<String> getAllow() {
        return allow;
    }

    /**
     * Sets the list of allowed resource patterns.
     * @param allow List of allow patterns
     */
    public void setAllow(List<String> allow) {
        this.allow = allow;
    }

    /**
     * Gets the list of denied resource patterns.
     * @return List of deny patterns, or null if not set
     */
    public List<String> getDeny() {
        return deny;
    }

    /**
     * Sets the list of denied resource patterns.
     * @param deny List of deny patterns
     */
    public void setDeny(List<String> deny) {
        this.deny = deny;
    }
}
