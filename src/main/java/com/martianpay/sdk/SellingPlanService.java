package com.martianpay.sdk;

import com.martianpay.developer.Pagination;
import com.martianpay.developer.ListSellingPlanGroupsResponse;
import com.martianpay.developer.CreateSellingPlanGroupRequest;
import com.martianpay.developer.SellingPlanGroupResponse;
import com.martianpay.developer.UpdateSellingPlanGroupRequest;
import com.martianpay.developer.ListSellingPlansResponse;
import com.martianpay.developer.CreateSellingPlanRequest;
import com.martianpay.developer.SellingPlanResponse;
import com.martianpay.developer.UpdateSellingPlanRequest;
import com.martianpay.developer.CalculatePriceResponse;

import java.io.IOException;
import java.util.Map;

/**
 * SellingPlanService provides methods for managing selling plans and selling plan groups
 */
public class SellingPlanService extends MartianPayClient {

    public SellingPlanService(String apiKey) {
        super(apiKey);
    }

    public SellingPlanService(String apiKey, String baseUrl) {
        super(apiKey, baseUrl);
    }

    /**
     * Lists selling plan groups
     *
     * @param params Pagination parameters
     * @return Selling plan group list response
     * @throws IOException if request fails
     */
    public ListSellingPlanGroupsResponse listSellingPlanGroups(Pagination params) throws IOException {
        return sendRequestWithQuery("GET", "/v1/selling_plan_groups", params, ListSellingPlanGroupsResponse.class);
    }

    /**
     * Creates a selling plan group
     *
     * @param params Creation parameters
     * @return Created selling plan group
     * @throws IOException if request fails
     */
    public SellingPlanGroupResponse createSellingPlanGroup(CreateSellingPlanGroupRequest params) throws IOException {
        return sendRequest("POST", "/v1/selling_plan_groups", params, SellingPlanGroupResponse.class);
    }

    /**
     * Gets a selling plan group
     *
     * @param groupID Selling plan group ID
     * @return Selling plan group details
     * @throws IOException if request fails
     */
    public SellingPlanGroupResponse getSellingPlanGroup(String groupID) throws IOException {
        String path = String.format("/v1/selling_plan_groups/%s", groupID);
        return sendRequest("GET", path, null, SellingPlanGroupResponse.class);
    }

    /**
     * Updates a selling plan group
     *
     * @param groupID Selling plan group ID
     * @param params Update parameters
     * @return Updated selling plan group
     * @throws IOException if request fails
     */
    public SellingPlanGroupResponse updateSellingPlanGroup(String groupID, UpdateSellingPlanGroupRequest params) throws IOException {
        String path = String.format("/v1/selling_plan_groups/%s", groupID);
        return sendRequest("POST", path, params, SellingPlanGroupResponse.class);
    }

    /**
     * Deletes a selling plan group
     *
     * @param groupID Selling plan group ID
     * @throws IOException if request fails
     */
    public void deleteSellingPlanGroup(String groupID) throws IOException {
        String path = String.format("/v1/selling_plan_groups/%s", groupID);
        sendRequest("DELETE", path, null, Void.class);
    }

    /**
     * Lists selling plans
     *
     * @param params Pagination parameters
     * @return Selling plan list response
     * @throws IOException if request fails
     */
    public ListSellingPlansResponse listSellingPlans(Pagination params) throws IOException {
        return sendRequestWithQuery("GET", "/v1/selling_plans", params, ListSellingPlansResponse.class);
    }

    /**
     * Creates a selling plan
     *
     * @param params Creation parameters
     * @return Created selling plan
     * @throws IOException if request fails
     */
    public SellingPlanResponse createSellingPlan(CreateSellingPlanRequest params) throws IOException {
        return sendRequest("POST", "/v1/selling_plans", params, SellingPlanResponse.class);
    }

    /**
     * Calculates selling plan price
     *
     * @param params Calculation parameters
     * @return Price calculation response
     * @throws IOException if request fails
     */
    public CalculatePriceResponse calculateSellingPlanPrice(Map<String, Object> params) throws IOException {
        return sendRequest("POST", "/v1/selling_plans/calculate_price", params, CalculatePriceResponse.class);
    }

    /**
     * Gets a selling plan
     *
     * @param planID Selling plan ID
     * @return Selling plan details
     * @throws IOException if request fails
     */
    public SellingPlanResponse getSellingPlan(String planID) throws IOException {
        String path = String.format("/v1/selling_plans/%s", planID);
        return sendRequest("GET", path, null, SellingPlanResponse.class);
    }

    /**
     * Updates a selling plan
     *
     * @param planID Selling plan ID
     * @param params Update parameters
     * @return Updated selling plan
     * @throws IOException if request fails
     */
    public SellingPlanResponse updateSellingPlan(String planID, UpdateSellingPlanRequest params) throws IOException {
        String path = String.format("/v1/selling_plans/%s", planID);
        return sendRequest("POST", path, params, SellingPlanResponse.class);
    }

    /**
     * Deletes a selling plan
     *
     * @param planID Selling plan ID
     * @throws IOException if request fails
     */
    public void deleteSellingPlan(String planID) throws IOException {
        String path = String.format("/v1/selling_plans/%s", planID);
        sendRequest("DELETE", path, null, Void.class);
    }
}
