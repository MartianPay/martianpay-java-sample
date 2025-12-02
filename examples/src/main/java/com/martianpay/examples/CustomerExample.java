package com.martianpay.examples;

import com.martianpay.model.Customer;
import com.martianpay.model.PaymentMethodCard;
import com.martianpay.sdk.CustomerService;
import com.martianpay.sdk.CustomerService.CustomerCreateRequest;
import com.martianpay.sdk.CustomerService.CustomerListRequest;
import com.martianpay.sdk.CustomerService.CustomerListResponse;
import com.martianpay.sdk.CustomerService.CustomerUpdateRequest;
import com.martianpay.sdk.CustomerService.CustomerDeleteResponse;
import com.martianpay.sdk.CustomerService.CustomerPaymentMethodListResponse;

import java.io.IOException;
import java.util.Scanner;

/**
 * Customer Examples
 *
 * This class demonstrates how to use the CustomerService to manage customers.
 */
public class CustomerExample {

    private final CustomerService customerService;
    private final Scanner scanner;

    public CustomerExample() {
        this.customerService = new CustomerService(Common.API_KEY);
        this.scanner = new Scanner(System.in);
    }

    /**
     * Creates and updates a customer.
     */
    public void createAndUpdateCustomer() {
        System.out.println("Creating and Updating Customer...");

        try {
            // Create customer
            String email = "newcustomer@example.com";
            String name = "John Doe";
            String description = "Test customer";

            CustomerCreateRequest createRequest = new CustomerCreateRequest();
            createRequest.setEmail(email);
            createRequest.setName(name);
            createRequest.setDescription(description);

            Customer createResponse = customerService.createCustomer(createRequest);

            System.out.println("✓ Customer Created:");
            System.out.println("  ID: " + createResponse.getId());
            System.out.println("  Email: " + createResponse.getEmail());
            System.out.println("  Name: " + createResponse.getName());
            System.out.println();

            // Update customer
            String newName = "John Updated";
            CustomerUpdateRequest updateRequest = new CustomerUpdateRequest();
            updateRequest.setId(createResponse.getId());
            updateRequest.setName(newName);

            Customer updateResponse = customerService.updateCustomer(updateRequest);

            System.out.println("✓ Customer Updated:");
            System.out.println("  ID: " + updateResponse.getId());
            System.out.println("  Name: " + updateResponse.getName());

        } catch (IOException e) {
            System.out.println("✗ API Error: " + e.getMessage());
        }
    }

    /**
     * Retrieves a customer by ID.
     */
    public void getCustomer() {
        System.out.println("Getting Customer...");
        System.out.print("Enter Customer ID: ");

        String id = scanner.nextLine().trim();
        if (id.isEmpty()) {
            id = "cus_example_id";
        }

        try {
            Customer response = customerService.getCustomer(id);

            System.out.println("✓ Customer Retrieved:");
            System.out.println("  ID: " + response.getId());
            if (response.getEmail() != null) {
                System.out.println("  Email: " + response.getEmail());
            }
            if (response.getName() != null) {
                System.out.println("  Name: " + response.getName());
            }
            System.out.println("  Currency: " + response.getCurrency());
            System.out.println("  Total Payment: " + response.getTotalPayment());

        } catch (IOException e) {
            System.out.println("✗ API Error: " + e.getMessage());
        }
    }

    /**
     * Lists customers with pagination.
     */
    public void listCustomers() {
        System.out.println("Listing Customers...");

        CustomerListRequest request = new CustomerListRequest();
        request.setPage(0);
        request.setPageSize(10);

        try {
            CustomerListResponse response = customerService.listCustomers(request);

            System.out.println("✓ Total Customers: " + response.getTotal());
            System.out.println("  Page: " + response.getPage() + ", Page Size: " + response.getPageSize());
            System.out.println();

            if (response.getCustomers() != null) {
                for (int i = 0; i < response.getCustomers().size(); i++) {
                    Customer customer = response.getCustomers().get(i);
                    System.out.print("  [" + (i + 1) + "] ID: " + customer.getId());
                    if (customer.getEmail() != null) {
                        System.out.print(", Email: " + customer.getEmail());
                    }
                    if (customer.getName() != null) {
                        System.out.print(", Name: " + customer.getName());
                    }
                    System.out.println();
                }
            }

        } catch (IOException e) {
            System.out.println("✗ API Error: " + e.getMessage());
        }
    }

    /**
     * Deletes a customer.
     */
    public void deleteCustomer() {
        System.out.println("Deleting Customer...");

        try {
            // Create a customer to delete
            String email = "delete_test@example.com";
            String name = "Delete Test Customer";

            CustomerCreateRequest createRequest = new CustomerCreateRequest();
            createRequest.setEmail(email);
            createRequest.setName(name);

            Customer createResponse = customerService.createCustomer(createRequest);
            System.out.println("  Created customer: " + createResponse.getId());

            // Delete it
            CustomerDeleteResponse deleteResponse = customerService.deleteCustomer(createResponse.getId());

            System.out.println("✓ Customer Deleted: " + deleteResponse.getId());

        } catch (IOException e) {
            System.out.println("✗ API Error: " + e.getMessage());
        }
    }

    /**
     * Lists customer's saved payment methods.
     */
    public void listCustomerPaymentMethods() {
        System.out.println("Listing Customer Payment Methods...");
        System.out.print("Enter Customer ID: ");

        String customerId = scanner.nextLine().trim();
        if (customerId.isEmpty()) {
            customerId = "cus_example_id";
        }

        try {
            CustomerPaymentMethodListResponse response = customerService.listCustomerPaymentMethods(customerId);

            System.out.println("✓ Found " + (response.getPaymentMethods() != null ?
                    response.getPaymentMethods().size() : 0) + " payment method(s)");
            System.out.println();

            if (response.getPaymentMethods() != null) {
                for (int i = 0; i < response.getPaymentMethods().size(); i++) {
                    PaymentMethodCard pm = response.getPaymentMethods().get(i);
                    System.out.println("  [" + (i + 1) + "] ID: " + pm.getId());
                    System.out.println("      Brand: " + pm.getBrand() + ", Last4: " + pm.getLast4());
                    System.out.println("      Expires: " + pm.getExpMonth() + "/" + pm.getExpYear());
                }
            }

        } catch (IOException e) {
            System.out.println("✗ API Error: " + e.getMessage());
        }
    }
}
