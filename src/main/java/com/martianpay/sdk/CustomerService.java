package com.martianpay.sdk;

import com.martianpay.developer.Customer;
import com.martianpay.developer.CustomerCreateRequest;
import com.martianpay.developer.CustomerUpdateRequest;
import com.martianpay.developer.CustomerListRequest;
import com.martianpay.developer.CustomerListResponse;
import com.martianpay.developer.CustomerPaymentMethodListRequest;
import com.martianpay.developer.PaymentMethodListResponse;
import com.martianpay.developer.EphemeralTokenRequest;
import com.martianpay.developer.EphemeralTokenResponse;

import java.io.IOException;

/**
 * CustomerService provides methods for managing customers
 */
public class CustomerService extends MartianPayClient {

    public CustomerService(String apiKey) {
        super(apiKey);
    }

    public CustomerService(String apiKey, String baseUrl) {
        super(apiKey, baseUrl);
    }

    /**
     * Creates a new customer
     *
     * @param request Customer creation parameters
     * @return Created customer
     * @throws IOException if request fails
     */
    public Customer createCustomer(CustomerCreateRequest request) throws IOException {
        return sendRequest("POST", "/v1/customers", request, Customer.class);
    }

    /**
     * Updates an existing customer
     *
     * @param customerID Customer ID
     * @param request Customer update parameters
     * @return Updated customer
     * @throws IOException if request fails
     */
    public Customer updateCustomer(String customerID, CustomerUpdateRequest request) throws IOException {
        String path = String.format("/v1/customers/%s", customerID);
        return sendRequest("POST", path, request, Customer.class);
    }

    /**
     * Retrieves a specific customer by ID
     *
     * @param customerID Customer ID
     * @return Customer details
     * @throws IOException if request fails
     */
    public Customer getCustomer(String customerID) throws IOException {
        String path = String.format("/v1/customers/%s", customerID);
        return sendRequest("GET", path, null, Customer.class);
    }

    /**
     * Retrieves a list of customers based on the provided parameters
     *
     * @param request List parameters
     * @return Customer list response
     * @throws IOException if request fails
     */
    public CustomerListResponse listCustomers(CustomerListRequest request) throws IOException {
        return sendRequestWithQuery("GET", "/v1/customers", request, CustomerListResponse.class);
    }

    /**
     * Deletes a customer by ID
     *
     * @param customerID Customer ID to delete
     * @throws IOException if request fails
     */
    public void deleteCustomer(String customerID) throws IOException {
        String path = String.format("/v1/customers/%s", customerID);
        sendRequest("DELETE", path, null, Void.class);
    }

    /**
     * Retrieves a list of saved payment methods for a customer
     *
     * @param customerID Customer ID
     * @return Payment methods list response
     * @throws IOException if request fails
     */
    public PaymentMethodListResponse listCustomerPaymentMethods(String customerID) throws IOException {
        CustomerPaymentMethodListRequest request = new CustomerPaymentMethodListRequest();
        request.setCustomerID(customerID);
        return sendRequestWithQuery("GET", "/v1/customers/payment_methods", request, PaymentMethodListResponse.class);
    }

    /**
     * Generates an ephemeral token for customer authentication in checkout flows.
     * Ephemeral tokens allow social media integrations and third-party systems to authenticate customers
     * without exposing long-lived credentials.
     *
     * The token is short-lived (typically 5-15 minutes) and can be used for:
     * - Instagram/WhatsApp commerce integrations
     * - Telegram bot payments
     * - WeChat mini-program checkout flows
     * - Any third-party system requiring temporary customer authentication
     *
     * @param request Request containing identity provider info (idp_key, idp_subject), provider, return URL, etc.
     * @return Ephemeral token response with token and expiration time
     * @throws IOException if request fails
     */
    public EphemeralTokenResponse generateEphemeralToken(EphemeralTokenRequest request) throws IOException {
        return sendRequest("POST", "/v1/customers/ephemeral_tokens", request, EphemeralTokenResponse.class);
    }
}
