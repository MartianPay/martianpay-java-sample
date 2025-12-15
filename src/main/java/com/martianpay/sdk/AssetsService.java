package com.martianpay.sdk;

import com.martianpay.developer.Asset;
import com.martianpay.developer.AssetListResponse;
import com.martianpay.developer.NetworkFeesResponse;

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
     * Retrieves all available assets
     *
     * @return Asset list response
     * @throws IOException if request fails
     */
    public AssetListResponse listAssets() throws IOException {
        return sendRequest("GET", "/v1/assets", null, AssetListResponse.class);
    }

    /**
     * Gets all available assets
     *
     * @return List of all assets
     * @throws IOException if request fails
     */
    public List<Asset> getAllAssets() throws IOException {
        com.google.gson.reflect.TypeToken<List<Asset>> typeToken =
            new com.google.gson.reflect.TypeToken<List<Asset>>() {};
        return sendRequestWithTypeToken("GET", "/v1/assets/all", null, typeToken);
    }

    /**
     * Lists asset network fees
     *
     * @return Network fees response
     * @throws IOException if request fails
     */
    public NetworkFeesResponse listAssetFees() throws IOException {
        return sendRequest("GET", "/v1/assets/fees", null, NetworkFeesResponse.class);
    }
}
