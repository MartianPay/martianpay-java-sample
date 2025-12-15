package com.martianpay.sdk;

import com.martianpay.developer.Product;
import com.martianpay.developer.ProductCreateRequest;
import com.martianpay.developer.ProductListRequest;
import com.martianpay.developer.ProductListResp;
import com.martianpay.developer.ProductUpdateRequest;

import java.io.IOException;

/**
 * ProductService provides methods for managing products
 */
public class ProductService extends MartianPayClient {

    public ProductService(String apiKey) {
        super(apiKey);
    }

    public ProductService(String apiKey, String baseUrl) {
        super(apiKey, baseUrl);
    }

    /**
     * Lists products with pagination
     *
     * @param params Product list request parameters
     * @return Product list response
     * @throws IOException if request fails
     */
    public ProductListResp listProducts(ProductListRequest params) throws IOException {
        return sendRequestWithQuery("GET", "/v1/products", params, ProductListResp.class);
    }

    /**
     * Creates a product with variants
     *
     * @param params Product creation parameters
     * @return Created product
     * @throws IOException if request fails
     */
    public Product createProduct(ProductCreateRequest params) throws IOException {
        return sendRequest("POST", "/v1/products", params, Product.class);
    }

    /**
     * Retrieves product details
     *
     * @param productID Product ID
     * @return Product details
     * @throws IOException if request fails
     */
    public Product getProduct(String productID) throws IOException {
        String path = String.format("/v1/products/%s", productID);
        return sendRequest("GET", path, null, Product.class);
    }

    /**
     * Updates product configuration
     *
     * @param productID Product ID
     * @param params Update parameters
     * @return Updated product
     * @throws IOException if request fails
     */
    public Product updateProduct(String productID, ProductUpdateRequest params) throws IOException {
        String path = String.format("/v1/products/%s", productID);
        return sendRequest("POST", path, params, Product.class);
    }

    /**
     * Deletes inactive product
     *
     * @param productID Product ID
     * @throws IOException if request fails
     */
    public void deleteProduct(String productID) throws IOException {
        String path = String.format("/v1/products/%s", productID);
        sendRequest("DELETE", path, null, Void.class);
    }
}
