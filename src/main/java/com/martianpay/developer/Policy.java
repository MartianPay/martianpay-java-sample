package com.martianpay.developer;

/**
 * Single access control policy rule specifying whether a role can perform an action on a resource.
 * Supports wildcards for role, resource, and action fields.
 */
public class Policy {
    /**
     * Role name this policy applies to. Supports wildcards.
     */
    private String role;

    /**
     * Resource pattern this policy controls. Supports wildcards.
     */
    private String resource;

    /**
     * Action type being controlled. Supports wildcards.
     */
    private String action;

    /**
     * Whether the action is allowed (true) or denied (false).
     */
    private Boolean allow;

    /**
     * Default constructor for Policy.
     */
    public Policy() {
    }

    /**
     * Gets the role name this policy applies to.
     * @return The role name
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the role name this policy applies to.
     * @param role The role name
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Gets the resource pattern this policy controls.
     * @return The resource pattern
     */
    public String getResource() {
        return resource;
    }

    /**
     * Sets the resource pattern this policy controls.
     * @param resource The resource pattern
     */
    public void setResource(String resource) {
        this.resource = resource;
    }

    /**
     * Gets the action type being controlled.
     * @return The action type
     */
    public String getAction() {
        return action;
    }

    /**
     * Sets the action type being controlled.
     * @param action The action type
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * Gets whether the action is allowed.
     * @return true if allowed, false if denied
     */
    public Boolean getAllow() {
        return allow;
    }

    /**
     * Sets whether the action is allowed.
     * @param allow true to allow, false to deny
     */
    public void setAllow(Boolean allow) {
        this.allow = allow;
    }
}
