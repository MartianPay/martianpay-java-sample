package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

public class ApiKeyParams {
    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("key_type")
    private String keyType;

    public ApiKeyParams() {
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

    public String getKeyType() {
        return keyType;
    }

    public void setKeyType(String keyType) {
        this.keyType = keyType;
    }
}
