package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

public class CustomerAuthToken {
    @SerializedName("token")
    private String token;

    @SerializedName("token_id")
    private String tokenId;

    @SerializedName("expires_at")
    private Long expiresAt;

    public CustomerAuthToken() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public Long getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Long expiresAt) {
        this.expiresAt = expiresAt;
    }
}
