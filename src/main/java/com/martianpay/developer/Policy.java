package com.martianpay.developer;

/**
 * Policy represents a single access control policy rule
 */
public class Policy {
    /**
     * Role is the role name this policy applies to
     */
    private String role;

    /**
     * Resource is the resource pattern this policy controls
     */
    private String resource;

    /**
     * Action is the action type (e.g., "read", "write", "delete")
     */
    private String action;

    /**
     * Allow indicates whether the action is allowed (true) or denied (false)
     */
    private Boolean allow;

    public Policy() {
    }

    // Getters and Setters
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Boolean getAllow() {
        return allow;
    }

    public void setAllow(Boolean allow) {
        this.allow = allow;
    }
}
