package com.martianpay.sdk;

import com.google.gson.annotations.SerializedName;
import com.martianpay.model.Asset;

import java.io.IOException;
import java.util.List;

/**
 * AssetsService provides methods for querying available assets
 */
public class AssetsService extends MartianPayClient {

    public AssetsService(String apiKey) {
        super(apiKey);
    }

    public AssetsService(String apiKey, String baseUrl) {
        super(apiKey, baseUrl);
    }

    /**
     * Response for listing assets
     */
    public static class AssetsListResponse {
        @SerializedName("assets")
        private List<Asset> assets;

        public List<Asset> getAssets() { return assets; }
    }

    /**
     * Retrieves all available assets
     *
     * @return Asset list response
     * @throws IOException if request fails
     */
    public AssetsListResponse listAssets() throws IOException {
        return sendRequest("GET", "/v1/assets", null, AssetsListResponse.class);
    }
}
