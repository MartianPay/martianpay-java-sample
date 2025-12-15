package com.martianpay.sdk;

import com.martianpay.developer.OrderDetail;
import com.martianpay.developer.OrderListRequest;
import com.martianpay.developer.OrderListResponse;

import java.io.IOException;

/**
 * OrderService provides methods for managing orders
 */
public class OrderService extends MartianPayClient {

    public OrderService(String apiKey) {
        super(apiKey);
    }

    public OrderService(String apiKey, String baseUrl) {
        super(apiKey, baseUrl);
    }

    /**
     * Lists orders
     *
     * @param params Order list request parameters
     * @return Order list response
     * @throws IOException if request fails
     */
    public OrderListResponse listOrders(OrderListRequest params) throws IOException {
        return sendRequestWithQuery("GET", "/v1/orders", params, OrderListResponse.class);
    }

    /**
     * Gets order details
     *
     * @param orderNumber Order number
     * @return Order details
     * @throws IOException if request fails
     */
    public OrderDetail getOrder(String orderNumber) throws IOException {
        String path = String.format("/v1/orders/%s", orderNumber);
        return sendRequest("GET", path, null, OrderDetail.class);
    }
}
