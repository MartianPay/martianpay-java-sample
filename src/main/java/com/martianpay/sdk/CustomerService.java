package com.martianpay.sdk;

import com.google.gson.annotations.SerializedName;
import com.martianpay.model.Customer;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

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
     * Request parameters for creating a customer
     */
    public static class CustomerCreateRequest {
        @SerializedName("name")
        private String name;

        @SerializedName("email")
        private String email;

        @SerializedName("description")
        private String description;

        @SerializedName("metadata")
        private Map<String, String> metadata;

        @SerializedName("phone")
        private String phone;

        // Getters and Setters
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }
        public Map<String, String> getMetadata() { return metadata; }
        public void setMetadata(Map<String, String> metadata) { this.metadata = metadata; }
        public String getPhone() { return phone; }
        public void setPhone(String phone) { this.phone = phone; }
    }

    /**
     * Request parameters for updating a customer
     */
    public static class CustomerUpdateRequest extends CustomerCreateRequest {
        private String id;

        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
    }

    /**
     * Request parameters for listing customers
     */
    public static class CustomerListRequest {
        @SerializedName("page")
        private int page;

        @SerializedName("page_size")
        private int pageSize;

        @SerializedName("email")
        private String email;

        public int getPage() { return page; }
        public void setPage(int page) { this.page = page; }
        public int getPageSize() { return pageSize; }
        public void setPageSize(int pageSize) { this.pageSize = pageSize; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
    }

    /**
     * Response for listing customers
     */
    public static class CustomerListResponse {
        @SerializedName("customers")
        private List<Customer> customers;

        @SerializedName("total")
        private int total;

        @SerializedName("page")
        private int page;

        @SerializedName("page_size")
        private int pageSize;

        public List<Customer> getCustomers() { return customers; }
        public int getTotal() { return total; }
        public int getPage() { return page; }
        public int getPageSize() { return pageSize; }
    }

    /**
     * Response for deleting a customer
     */
    public static class CustomerDeleteResponse {
        @SerializedName("deleted")
        private boolean deleted;

        @SerializedName("id")
        private String id;

        public boolean isDeleted() { return deleted; }
        public String getId() { return id; }
    }

    /**
     * Response for listing customer payment methods
     */
    public static class CustomerPaymentMethodListResponse {
        @SerializedName("payment_methods")
        private List<com.martianpay.model.PaymentMethodCard> paymentMethods;

        public List<com.martianpay.model.PaymentMethodCard> getPaymentMethods() { return paymentMethods; }
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
     * @param request Customer update parameters
     * @return Updated customer
     * @throws IOException if request fails
     */
    public Customer updateCustomer(CustomerUpdateRequest request) throws IOException {
        return sendRequest("POST", "/v1/customers/" + request.getId(), request, Customer.class);
    }

    /**
     * Retrieves a specific customer by ID
     *
     * @param customerId Customer ID
     * @return Customer details
     * @throws IOException if request fails
     */
    public Customer getCustomer(String customerId) throws IOException {
        return sendRequest("GET", "/v1/customers/" + customerId, null, Customer.class);
    }

    /**
     * Retrieves a list of customers
     *
     * @param request List parameters
     * @return Customer list response
     * @throws IOException if request fails
     */
    public CustomerListResponse listCustomers(CustomerListRequest request) throws IOException {
        StringBuilder query = new StringBuilder();
        query.append("page=").append(request.getPage());
        query.append("&page_size=").append(request.getPageSize());
        if (request.getEmail() != null && !request.getEmail().isEmpty()) {
            try {
                query.append("&email=").append(URLEncoder.encode(request.getEmail(), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                throw new IOException("Failed to encode email parameter", e);
            }
        }

        return sendRequestWithQuery("/v1/customers", query.toString(), CustomerListResponse.class);
    }

    /**
     * Deletes a customer by ID
     *
     * @param customerId Customer ID to delete
     * @return Delete response
     * @throws IOException if request fails
     */
    public CustomerDeleteResponse deleteCustomer(String customerId) throws IOException {
        return sendRequest("DELETE", "/v1/customers/" + customerId, null, CustomerDeleteResponse.class);
    }

    /**
     * Lists customer's saved payment methods
     *
     * @param customerId Customer ID
     * @return Payment methods list response
     * @throws IOException if request fails
     */
    public CustomerPaymentMethodListResponse listCustomerPaymentMethods(String customerId) throws IOException {
        String query = "customer_id=" + URLEncoder.encode(customerId, "UTF-8");
        return sendRequestWithQuery("/v1/customers/payment_methods", query, CustomerPaymentMethodListResponse.class);
    }
}
