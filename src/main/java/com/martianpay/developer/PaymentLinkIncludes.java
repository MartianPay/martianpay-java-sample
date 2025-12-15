package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * PaymentLinkIncludes contains included resources for a payment link
 */
public class PaymentLinkIncludes {
    /**
     * Media contains media assets referenced by the product/variants
     */
    @SerializedName("media")
    private List<PaymentLinkMedia> media;

    public List<PaymentLinkMedia> getMedia() {
        return media;
    }

    public void setMedia(List<PaymentLinkMedia> media) {
        this.media = media;
    }
}
