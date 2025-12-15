package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * ProductOptionSwatch represents visual swatch metadata for product options
 */
public class ProductOptionSwatch {
    /**
     * Type is the swatch type ("color" or "image")
     */
    @SerializedName("type")
    private String type;

    /**
     * Value is the hex color or display value
     */
    @SerializedName("value")
    private String value;

    /**
     * MediaID is the reference to media asset when type=image
     */
    @SerializedName("media_id")
    private String mediaId;

    public ProductOptionSwatch() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}
