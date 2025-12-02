package com.martianpay.sdk;

import com.google.gson.annotations.SerializedName;
import com.martianpay.model.MerchantAddress;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

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
     * Request parameters for creating a merchant address
     */
    public static class MerchantAddressCreateRequest {
        @SerializedName("network")
        private String network;

        @SerializedName("address")
        private String address;

        public String getNetwork() { return network; }
        public void setNetwork(String network) { this.network = network; }
        public String getAddress() { return address; }
        public void setAddress(String address) { this.address = address; }
    }

    /**
     * Request parameters for updating a merchant address
     */
    public static class MerchantAddressUpdateRequest {
        @SerializedName("alias")
        private String alias;

        public String getAlias() { return alias; }
        public void setAlias(String alias) { this.alias = alias; }
    }

    /**
     * Request parameters for verifying a merchant address
     */
    public static class MerchantAddressVerifyRequest {
        @SerializedName("amount")
        private String amount;

        public String getAmount() { return amount; }
        public void setAmount(String amount) { this.amount = amount; }
    }

    /**
     * Request parameters for listing merchant addresses
     */
    public static class MerchantAddressListRequest {
        @SerializedName("network")
        private String network;

        @SerializedName("page")
        private int page;

        @SerializedName("page_size")
        private int pageSize;

        public String getNetwork() { return network; }
        public void setNetwork(String network) { this.network = network; }
        public int getPage() { return page; }
        public void setPage(int page) { this.page = page; }
        public int getPageSize() { return pageSize; }
        public void setPageSize(int pageSize) { this.pageSize = pageSize; }
    }

    /**
     * Response for listing merchant addresses
     */
    public static class MerchantAddressListResponse {
        @SerializedName("merchant_addresses")
        private List<MerchantAddress> merchantAddresses;

        @SerializedName("total")
        private long total;

        @SerializedName("page")
        private int page;

        @SerializedName("page_size")
        private int pageSize;

        public List<MerchantAddress> getMerchantAddresses() { return merchantAddresses; }
        public long getTotal() { return total; }
        public int getPage() { return page; }
        public int getPageSize() { return pageSize; }
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
     * Retrieves a specific merchant address by ID
     *
     * @param addressId Merchant address ID
     * @return Merchant address details
     * @throws IOException if request fails
     */
    public MerchantAddress getMerchantAddress(String addressId) throws IOException {
        return sendRequest("GET", "/v1/addresses/" + addressId, null, MerchantAddress.class);
    }

    /**
     * Updates an existing merchant address
     *
     * @param addressId Address ID to update
     * @param request Update parameters
     * @return Updated merchant address
     * @throws IOException if request fails
     */
    public MerchantAddress updateMerchantAddress(String addressId, MerchantAddressUpdateRequest request) throws IOException {
        return sendRequest("POST", "/v1/addresses/" + addressId, request, MerchantAddress.class);
    }

    /**
     * Verifies a merchant address
     *
     * @param addressId Address ID to verify
     * @param request Verification parameters
     * @return Verified merchant address
     * @throws IOException if request fails
     */
    public MerchantAddress verifyMerchantAddress(String addressId, MerchantAddressVerifyRequest request) throws IOException {
        return sendRequest("POST", "/v1/addresses/" + addressId + "/verify", request, MerchantAddress.class);
    }

    /**
     * Deletes a merchant address by ID
     *
     * @param addressId Address ID to delete
     * @throws IOException if request fails
     */
    public void deleteMerchantAddress(String addressId) throws IOException {
        sendRequest("DELETE", "/v1/addresses/" + addressId, null, Void.class);
    }

    /**
     * Retrieves a list of merchant addresses
     *
     * @param request List parameters
     * @return Merchant address list response
     * @throws IOException if request fails
     */
    public MerchantAddressListResponse listMerchantAddresses(MerchantAddressListRequest request) throws IOException {
        StringBuilder query = new StringBuilder();
        query.append("page=").append(request.getPage());
        query.append("&page_size=").append(request.getPageSize());

        if (request.getNetwork() != null && !request.getNetwork().isEmpty()) {
            try {
                query.append("&network=").append(URLEncoder.encode(request.getNetwork(), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                throw new IOException("Failed to encode network parameter", e);
            }
        }

        return sendRequestWithQuery("/v1/addresses", query.toString(), MerchantAddressListResponse.class);
    }
}
