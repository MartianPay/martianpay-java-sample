package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * EphemeralTokenResponse contains the ephemeral token details.
 * Ephemeral tokens are short-lived (typically 5-15 minutes) and used for
 * customer authentication in social media integrations.
 */
public class EphemeralTokenResponse {

    /**
     * Token is the ephemeral token string (short-lived, typically 5-15 minutes)
     */
    @SerializedName("token")
    private String token;

    /**
     * ExpiresAt is the Unix timestamp when the ephemeral token expires
     */
    @SerializedName("expires_at")
    private Long expiresAt;

    // Getters and Setters

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Long expiresAt) {
        this.expiresAt = expiresAt;
    }
}
