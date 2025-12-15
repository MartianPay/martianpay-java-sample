package com.martianpay.sdk;

import com.martianpay.developer.MerchantAddress;
import com.martianpay.developer.MerchantAddressCreateRequest;
import com.martianpay.developer.MerchantAddressUpdateRequest;
import com.martianpay.developer.MerchantAddressVerifyRequest;
import com.martianpay.developer.MerchantAddressListRequest;
import com.martianpay.developer.MerchantAddressListResponse;

import java.io.IOException;

/**
 * MerchantAddressService provides methods for managing merchant addresses (wallets)
 */
public class MerchantAddressService extends MartianPayClient {

    public MerchantAddressService(String apiKey) {
        super(apiKey);
    }

    public MerchantAddressService(String apiKey, String baseUrl) {
        super(apiKey, baseUrl);
    }

    /**
     * Creates a new merchant address
     *
     * @param request Merchant address creation parameters
     * @return Created merchant address
     * @throws IOException if request fails
     */
    public MerchantAddress createMerchantAddress(MerchantAddressCreateRequest request) throws IOException {
        return sendRequest("POST", "/v1/addresses", request, MerchantAddress.class);
    }

    /**
     * Retrieves a merchant address by ID
     *
     * @param id Merchant address ID
     * @return Merchant address details
     * @throws IOException if request fails
     */
    public MerchantAddress getMerchantAddress(String id) throws IOException {
        return sendRequest("GET", "/v1/addresses/" + id, null, MerchantAddress.class);
    }

    /**
     * Updates a merchant address
     *
     * @param id Address ID to update
     * @param request Update parameters
     * @return Updated merchant address
     * @throws IOException if request fails
     */
    public MerchantAddress updateMerchantAddress(String id, MerchantAddressUpdateRequest request) throws IOException {
        String path = String.format("/v1/addresses/%s", id);
        return sendRequest("POST", path, request, MerchantAddress.class);
    }

    /**
     * Verifies a merchant address
     *
     * @param id Address ID to verify
     * @param request Verification parameters
     * @return Verified merchant address
     * @throws IOException if request fails
     */
    public MerchantAddress verifyMerchantAddress(String id, MerchantAddressVerifyRequest request) throws IOException {
        String path = String.format("/v1/addresses/%s/verify", id);
        return sendRequest("POST", path, request, MerchantAddress.class);
    }

    /**
     * Deletes a merchant address by ID
     *
     * @param id Address ID to delete
     * @throws IOException if request fails
     */
    public void deleteMerchantAddress(String id) throws IOException {
        sendRequest("DELETE", "/v1/addresses/" + id, null, Void.class);
    }

    /**
     * Retrieves a paginated list of merchant addresses
     *
     * @param request List parameters
     * @return Merchant address list response
     * @throws IOException if request fails
     */
    public MerchantAddressListResponse listMerchantAddresses(MerchantAddressListRequest request) throws IOException {
        return sendRequestWithQuery("GET", "/v1/addresses", request, MerchantAddressListResponse.class);
    }
}
