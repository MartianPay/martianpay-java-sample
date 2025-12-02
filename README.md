# MartianPay Java SDK

Official Java SDK for the MartianPay payment platform.

> **🚀 Quick Start**: Check out the [Interactive Examples](#interactive-examples) to get started quickly!

## Features

- **Payment Intents**: Create, update, retrieve, list, and cancel payment intents
- **Customers**: Create, update, retrieve, list, and delete customers
- **Payment Methods**: List customer's saved payment methods (cards)
- **Refunds**: Create, retrieve, and list refunds
- **Payroll**: Create direct payroll, retrieve, and list payrolls and payroll items
- **Merchant Addresses (Wallets)**: Add, verify, update, list, and delete blockchain addresses for withdrawals
- **Assets**: List all available crypto and fiat assets with network details
- **Balance**: Query merchant balance across different currencies and assets
- **Crypto Payments**: Support for crypto payment methods (USDT, USDC, ETH, etc.)
- **Fiat/Card Payments**: Support for card payments via Stripe (new card and saved card)
- **Webhook Events**: Receive and verify webhook events

## Installation

### Maven

Add this dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>com.martianpay</groupId>
    <artifactId>martianpay-java-sample</artifactId>
    <version>1.0.0</version>
</dependency>
```

### Gradle

Add this to your `build.gradle`:

```gradle
implementation 'com.martianpay:martianpay-java-sample:1.0.0'
```

## Integration Approaches

MartianPay offers flexible integration options to suit different use cases. For detailed integration guides including frontend code examples, see the [examples directory](examples/README.md).

## Quick Start

Here's a simple example of using the SDK to list customers:

```java
package com.example;

import com.martianpay.sdk.CustomerService;
import com.martianpay.sdk.CustomerService.CustomerListRequest;
import com.martianpay.sdk.CustomerService.CustomerListResponse;
import com.martianpay.model.Customer;

import java.io.IOException;

public class Example {
    public static void main(String[] args) {
        // Initialize the MartianPay client with your API key
        String apiKey = "your_api_key_here"; // Replace with your actual API key
        CustomerService customerService = new CustomerService(apiKey);

        try {
            // Create request to list customers
            CustomerListRequest request = new CustomerListRequest();
            request.setPage(0);  // Start from page 0
            request.setPageSize(10); // Get 10 customers per page

            // Call the ListCustomers API
            CustomerListResponse response = customerService.listCustomers(request);

            // Display results
            System.out.println("Total customers: " + response.getTotal());
            System.out.println("Customers on this page: " + response.getCustomers().size());
            System.out.println();

            // Print each customer
            int index = 1;
            for (Customer customer : response.getCustomers()) {
                System.out.println("Customer " + index + ":");
                System.out.println("  ID: " + customer.getId());
                if (customer.getEmail() != null) {
                    System.out.println("  Email: " + customer.getEmail());
                }
                if (customer.getName() != null) {
                    System.out.println("  Name: " + customer.getName());
                }
                System.out.println("  Total Payment: " +
                    String.format("%.2f", customer.getTotalPayment() / 100.0) + " " +
                    customer.getCurrency());
                System.out.println();
                index++;
            }
        } catch (IOException e) {
            System.err.println("Failed to list customers: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
```

## Running Unit Tests

The SDK includes comprehensive unit tests for all features. See [src/test/README.md](src/test/README.md) for detailed testing instructions.

To run tests:

```bash
# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=CustomerServiceTest

# Run with coverage
mvn clean test jacoco:report
```

## Keeping SDK Up to Date

To ensure you're using the latest features and bug fixes:

```bash
# Update to the latest SDK version in Maven
mvn versions:use-latest-releases

# Or update manually in pom.xml
<dependency>
    <groupId>com.martianpay</groupId>
    <artifactId>martianpay-java-sample</artifactId>
    <version>1.0.0</version> <!-- Update to latest version -->
</dependency>
```

> **💡 Tip**: Check for updates periodically to get the latest features, improvements, and bug fixes.

### What's New

The SDK is regularly updated with:
- ✅ Enhanced error handling with `error_code` field support
- ✅ Comprehensive integration documentation and examples
- ✅ Support for the latest MartianPay API features
- ✅ Bug fixes and performance improvements

## Documentation & Resources

- 📖 [Interactive Examples](examples/README.md) - Ready-to-run examples
- 📖 [SDK Unit Tests](src/test/README.md) - Comprehensive SDK testing guide
- 📖 [MartianPay.js Widget Guide](https://docs.martianpay.com/v1/docs/martianpay-js-usage) - Recommended integration method
- 📖 [API Reference](https://docs.martianpay.com) - Full API documentation
- 🏠 [MartianPay Dashboard](https://dashboard.martianpay.com) - Get your API key

## Requirements

- Java 8 or higher
- Maven 3.6+ or Gradle 6+

## Dependencies

The SDK uses the following dependencies:
- **Gson** - JSON serialization/deserialization
- **OkHttp** - HTTP client
- **SLF4J & Logback** - Logging
- **JUnit 5** - Testing framework

## Support

Need help? Here are your options:

- 📚 Check the [examples directory](examples/) for code samples
- 📖 Read the [API documentation](https://docs.martianpay.com)
- 💬 Contact support through the [MartianPay Dashboard](https://dashboard.martianpay.com)

## License

This SDK is released under the MIT License.
