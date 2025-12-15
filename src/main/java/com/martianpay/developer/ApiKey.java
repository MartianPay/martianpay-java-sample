package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.security.SecureRandom;

public class ApiKey {
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final SecureRandom RANDOM = new SecureRandom();

    @SerializedName("id")
    private String id;

    @SerializedName("object")
    private String object;

    @SerializedName("key")
    private String key;

    @SerializedName("key_type")
    private String keyType;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("created")
    private Long created;

    @SerializedName("last_accessed_at")
    private Long lastAccessedAt;

    @SerializedName("status")
    private String status;

    @SerializedName("expired_at")
    private Long expiredAt;

    public ApiKey() {
    }

    public static String generateApiKeyId() {
        return DeveloperConstants.API_KEY_ID_PREFIX + generateRandomString(DeveloperConstants.API_KEY_ID_LENGTH);
    }

    private static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }

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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKeyType() {
        return keyType;
    }

    public void setKeyType(String keyType) {
        this.keyType = keyType;
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

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Long getLastAccessedAt() {
        return lastAccessedAt;
    }

    public void setLastAccessedAt(Long lastAccessedAt) {
        this.lastAccessedAt = lastAccessedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(Long expiredAt) {
        this.expiredAt = expiredAt;
    }
}
