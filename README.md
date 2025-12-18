# MartianPay Java SDK

Official Java SDK for the MartianPay payment platform.

> **🚀 Quick Start**: Check out the [Interactive Examples](#interactive-examples) to get started quickly!

## Features

- **Payment Intents**: Create, update, retrieve, list, and cancel payment intents
- **Customers**: Create, update, retrieve, list, and delete customers
- **Payment Methods**: List customer's saved payment methods (cards)
- **Refunds**: Create, retrieve, and list refunds
- **Payroll**: Create direct payroll (normal and Binance), retrieve, and list payrolls and payroll items
- **Payout**: Preview, create, retrieve, list, approve, reject, and cancel payouts with approval workflow
- **Merchant Addresses (Wallets)**: Add, verify, update, list, and delete blockchain addresses for withdrawals
- **Assets**: List enabled and available crypto and fiat assets with network details and fees
- **Balance**: Query merchant balance across different currencies and assets, with detailed breakdown
- **Products**: Create, update, retrieve, list, and delete products with variants and selling plans
- **Selling Plans**: Manage subscription and recurring payment plans with pricing strategies
- **Payment Links**: Create, update, retrieve, list, and delete payment links for products
- **Subscriptions**: Manage customer subscriptions with plan changes (upgrade/downgrade), proration, pause, resume, and cancel
- **Crypto Payments**: Support for crypto payment methods (USDT, USDC, ETH, etc.)
- **Fiat/Card Payments**: Support for card payments via Stripe (new card and saved card)
- **Webhook Events**: Receive and verify webhook events for real-time updates

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

## Interactive Examples

The fastest way to learn the SDK! We provide an interactive menu-driven interface with examples covering all features:

```bash
cd examples
./build_jar.sh   # Build executable JAR
java -jar build/jars/martianpay-examples-1.0.0.jar
```

**Features:**
- 📋 Two-level menu system organized by feature category
- 🎲 Automatic randomization of emails and order IDs to avoid duplicates
- 🎯 User-friendly prompts for interactive input
- ✅ Comprehensive coverage of all SDK methods

The examples demonstrate the **API-only integration approach** to show all SDK methods. For production, we recommend using the **MartianPay.js Widget** for simpler integration.

📁 **See [examples/README.md](examples/README.md) for full details**

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

## Testing the SDK

All SDK functionality can be tested through the interactive examples:

```bash
cd examples
./build_jar.sh
java -jar build/jars/martianpay-examples-1.0.0.jar
```

Select from organized categories:
1. **Payment Intent Examples** - Create, update, list, cancel payment intents with crypto and card payments
2. **Customer Examples** - Manage customers and payment methods
3. **Refund Examples** - Process and manage refunds
4. **Payroll Examples** - Create and manage crypto payrolls (normal and Binance)
5. **Merchant Address Examples** - Add and verify withdrawal addresses
6. **Payout Examples** - Preview, create, approve, reject, and manage payouts
7. **Assets Examples** - Query available crypto and fiat assets with network fees
8. **Balance Examples** - View merchant balances across currencies and asset types
9. **Product Examples** - Create and manage products with variants and selling plans
10. **Payment Link Examples** - Create and manage payment links for products
11. **Subscription Examples** - Manage subscriptions with plan changes, proration preview, pause/resume
12. **Webhook Examples** - Test webhook event handling for real-time updates

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

### Recent Improvements

Latest updates include:
- ✅ Two-level interactive menu for better navigation
- ✅ Automatic randomization of emails and order IDs to prevent duplicates
- ✅ User input prompts for flexible testing (addresses, amounts, networks)
- ✅ Enhanced error handling with `error_code` field support
- ✅ Product version field support for optimistic locking
- ✅ Complete event type documentation with detailed comments
- ✅ Comprehensive integration documentation and examples

## Documentation & Resources

- 📖 [Interactive Examples](examples/README.md) - Ready-to-run examples
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

## Support

Need help? Here are your options:

- 📚 Check the [examples directory](examples/) for code samples
- 📖 Read the [API documentation](https://docs.martianpay.com)
- 💬 Contact support through the [MartianPay Dashboard](https://dashboard.martianpay.com)

## License

This SDK is released under the MIT License.
