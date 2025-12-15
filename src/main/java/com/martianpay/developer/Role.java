package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Role represents a user role with associated permissions
 */
public class Role {
    public static final String ROLE_OBJECT = "role";
    public static final int ROLE_ID_LENGTH = 24;
    public static final String ROLE_ID_PREFIX = "role_";

    /**
     * ID is the unique identifier for the role
     */
    @SerializedName("id")
    private String id;

    /**
     * Object is the type identifier, always "role"
     */
    @SerializedName("object")
    private String object;

    /**
     * Name is the role name (e.g., "admin", "developer", "viewer")
     */
    @SerializedName("name")
    private String name;

    /**
     * Description is a human-readable description of the role
     */
    @SerializedName("description")
    private String description;

    /**
     * Permissions defines the access control rules for this role
     */
    @SerializedName("permissions")
    private Permission permissions;

    /**
     * Policies is the list of policy rules associated with this role
     */
    @SerializedName("policies")
    private List<Policy> policies;

    public Role() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Permission getPermissions() {
        return permissions;
    }

    public void setPermissions(Permission permissions) {
        this.permissions = permissions;
    }

    public List<Policy> getPolicies() {
        return policies;
    }

    public void setPolicies(List<Policy> policies) {
        this.policies = policies;
    }
}
