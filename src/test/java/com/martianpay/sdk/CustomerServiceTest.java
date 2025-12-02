package com.martianpay.sdk;

import com.martianpay.model.Customer;
import com.martianpay.sdk.CustomerService.CustomerCreateRequest;
import com.martianpay.sdk.CustomerService.CustomerListRequest;
import com.martianpay.sdk.CustomerService.CustomerListResponse;
import com.martianpay.sdk.CustomerService.CustomerUpdateRequest;
import com.martianpay.sdk.CustomerService.CustomerDeleteResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for CustomerService
 *
 * Before running tests, update the API_KEY constant with your actual API key.
 */
class CustomerServiceTest {
    private static final String API_KEY = "your_api_key_here"; // Replace with your actual API key
    private CustomerService service;

    @BeforeEach
    void setUp() {
        service = new CustomerService(API_KEY);
    }

    @Test
    void testCreateAndUpdateCustomer() throws IOException {
        System.out.println("=== Test: Create and Update Customer ===");

        // Create customer
        CustomerCreateRequest createRequest = new CustomerCreateRequest();
        createRequest.setName("Test Customer");
        createRequest.setEmail("test" + System.currentTimeMillis() + "@example.com");
        createRequest.setPhone("+1234567890");
        createRequest.setDescription("Test customer for unit testing");

        Map<String, String> metadata = new HashMap<>();
        metadata.put("test", "true");
        metadata.put("env", "junit");
        createRequest.setMetadata(metadata);

        Customer customer = service.createCustomer(createRequest);

        assertNotNull(customer);
        assertNotNull(customer.getId());
        assertEquals("Test Customer", customer.getName());
        assertNotNull(customer.getEmail());
        System.out.println("✓ Customer created: " + customer.getId());

        // Update customer
        CustomerUpdateRequest updateRequest = new CustomerUpdateRequest();
        updateRequest.setId(customer.getId());
        updateRequest.setName("Updated Test Customer");
        updateRequest.setDescription("Updated description");

        Customer updatedCustomer = service.updateCustomer(updateRequest);

        assertNotNull(updatedCustomer);
        assertEquals(customer.getId(), updatedCustomer.getId());
        assertEquals("Updated Test Customer", updatedCustomer.getName());
        System.out.println("✓ Customer updated: " + updatedCustomer.getId());

        // Clean up
        service.deleteCustomer(customer.getId());
        System.out.println("✓ Customer deleted");
    }

    @Test
    void testGetCustomer() throws IOException {
        System.out.println("=== Test: Get Customer ===");

        // Create a customer first
        CustomerCreateRequest createRequest = new CustomerCreateRequest();
        createRequest.setName("Get Test Customer");
        createRequest.setEmail("gettest" + System.currentTimeMillis() + "@example.com");

        Customer createdCustomer = service.createCustomer(createRequest);
        assertNotNull(createdCustomer);
        System.out.println("✓ Customer created: " + createdCustomer.getId());

        // Get the customer
        Customer retrievedCustomer = service.getCustomer(createdCustomer.getId());

        assertNotNull(retrievedCustomer);
        assertEquals(createdCustomer.getId(), retrievedCustomer.getId());
        assertEquals("Get Test Customer", retrievedCustomer.getName());
        System.out.println("✓ Customer retrieved: " + retrievedCustomer.getId());

        // Clean up
        service.deleteCustomer(createdCustomer.getId());
        System.out.println("✓ Customer deleted");
    }

    @Test
    void testListCustomers() throws IOException {
        System.out.println("=== Test: List Customers ===");

        CustomerListRequest request = new CustomerListRequest();
        request.setPage(0);
        request.setPageSize(10);

        CustomerListResponse response = service.listCustomers(request);

        assertNotNull(response);
        assertNotNull(response.getCustomers());
        assertTrue(response.getTotal() >= 0);
        assertEquals(0, response.getPage());
        System.out.println("✓ Listed customers: " + response.getCustomers().size() + " found");
    }

    @Test
    void testDeleteCustomer() throws IOException {
        System.out.println("=== Test: Delete Customer ===");

        // Create a customer to delete
        CustomerCreateRequest createRequest = new CustomerCreateRequest();
        createRequest.setName("Delete Test Customer");
        createRequest.setEmail("deletetest" + System.currentTimeMillis() + "@example.com");

        Customer customer = service.createCustomer(createRequest);
        assertNotNull(customer);
        System.out.println("✓ Customer created: " + customer.getId());

        // Delete the customer
        CustomerDeleteResponse deleteResponse = service.deleteCustomer(customer.getId());

        assertNotNull(deleteResponse);
        assertEquals(customer.getId(), deleteResponse.getId());
        assertTrue(deleteResponse.isDeleted());
        System.out.println("✓ Customer deleted: " + deleteResponse.getId());
    }
}
