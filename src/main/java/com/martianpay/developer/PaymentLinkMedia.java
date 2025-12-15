package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * PaymentLinkMedia represents media assets for a payment link
 */
public class PaymentLinkMedia {
    @SerializedName("id")
    private String id;

    @SerializedName("url")
    private String url;

    @SerializedName("width")
    private Integer width;

    @SerializedName("height")
    private Integer height;

    @SerializedName("alt_text")
    private String altText;

    @SerializedName("content_type")
    private String contentType;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public Integer getWidth() { return width; }
    public void setWidth(Integer width) { this.width = width; }

    public Integer getHeight() { return height; }
    public void setHeight(Integer height) { this.height = height; }

    public String getAltText() { return altText; }
    public void setAltText(String altText) { this.altText = altText; }

    public String getContentType() { return contentType; }
    public void setContentType(String contentType) { this.contentType = contentType; }
}
