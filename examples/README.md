# MartianPay SDK Examples

This directory contains example programs demonstrating how to use the MartianPay Java SDK.

> **⚠️ Important**: These examples show the **API-only integration approach** to demonstrate all SDK methods. For production use, we recommend the **MartianPay.js Widget** for easier integration.

## Prerequisites

- Java 8 or higher
- MartianPay API key (get one from [MartianPay Dashboard](https://dashboard.martianpay.com))

## Quick Start (Recommended)

### Option 1: Run without Maven

```bash
# From the project root directory
./run_without_maven.sh
```

This will:
1. Download all dependencies automatically
2. Compile the SDK and examples
3. Launch the interactive menu with 27 example options

### Option 2: Build JAR and run

```bash
# Build executable JAR (includes all dependencies)
./build_jar.sh

# Run the interactive menu
java -jar build/jars/martianpay-examples-1.0.0.jar
```

## Setup with Maven (Optional)

If you have Maven installed:

1. **Build the SDK and install to local Maven repository**:
```bash
# From the project root directory
mvn clean install -DskipTests
```

2. **Build the examples**:
```bash
cd examples
mvn clean package
```

3. **Run the interactive menu**:
```bash
# Run the fat JAR with all dependencies
java -jar target/martianpay-examples-1.0.0-with-dependencies.jar
```

## Configuration

Update the API key in `Common.java`:
```java
public class Common {
    public static final String API_KEY = "your_api_key_here";  // Replace with your actual API key
    public static final String WEBHOOK_SECRET = "your_webhook_secret"; // Replace with your webhook secret
}
```

After changing the configuration, recompile:
```bash
./run_without_maven.sh
# or
./build_jar.sh
```

## Available Examples

### Customer Management
- **CustomerExample.java** - Create, update, list, and delete customers

### Payment Processing
- **PaymentIntentExample.java** - Create payment intents, handle crypto and card payments
- **RefundExample.java** - Create and manage refunds

### Payroll
- **PayrollExample.java** - Create and manage payrolls

### Merchant Addresses
- **MerchantAddressExample.java** - Manage blockchain withdrawal addresses

### Webhooks
- **WebhookExample.java** - Receive and verify webhook events from MartianPay

## Webhook Testing

The `WebhookExample` demonstrates how to receive and verify webhook events from MartianPay.

### Running the Webhook Server

1. **Start the webhook server** (option 27 in ExamplesMain):
```bash
./run_without_maven.sh
# Then select: 27
```

2. **In another terminal**, send a test webhook event using curl:
```bash
curl --location 'http://localhost:8080/v1/webhook_test' \
--header 'Content-Type: application/json' \
--header 'Martian-Pay-Signature: t=1745580845,v1=c16a830eae640a659025a5f4bf91866ddd4be0c85619a82defad3c10af42ec89' \
--header 'User-Agent: MartianPay/1.0' \
--data '{"id":"evt_056qw9fr9PndljykFUqSIf6t","object":"event","api_version":"2025-01-22","created":1745580845,"data":{"previous_attributes":null,"object":{"id":"pi_nKSxQrU2Pjh9KGzyIRJcWpGJ","object":"payment_intent","amount":{"asset_id":"USD","amount":"1"},"payment_details":{"amount_captured":{"asset_id":"USD","amount":"1"},"amount_refunded":{"asset_id":"USD","amount":"0"},"tx_fee":{"asset_id":"USD","amount":"0"},"tax_fee":{"asset_id":"USD","amount":"0"},"frozen_amount":{"asset_id":"USD","amount":"0"},"net_amount":{"asset_id":"USD","amount":"0"},"gas_fee":{},"network_fee":{"asset_id":"USD","amount":"0"}},"canceled_at":0,"cancellation_reason":"","client_secret":"pi_nKSxQrU2Pjh9KGzyIRJcWpGJ_secret_S77UnKrHOv10a6x1SSjbKwwI6","created":1745580777,"updated":1745580781,"currency":"USD","customer":{"id":"cus_7Xpxk2n22WAEBDaBVlG5dnRf","object":"customer","total_expense":300,"total_payment":320,"total_refund":20,"currency":"USD","created":1740731398,"name":"","email":"yihuazhai@163.com","description":"","phone":""},"description":"test","livemode":false,"metadata":{"merchant_id":"accu_M7PTgveSgMtTtPHbjFgEtAlD","merchant_name":"ABC Company 1","payment_link":{"active":true,"created_at":1744181243,"id":"test_NivLsKfDfKuNPdULFVPvrhVx","product_items":[{"product":{"active":true,"created_at":1744181220,"description":"","id":"prod_7pwJj8FLyBsehx","metadata":null,"name":"test","picture_url":"","price":{"amount":"1","asset_id":"USD"},"tax_code":"","updated_at":1744181220},"quantity":1}],"total_price":{"amount":"1","asset_id":"USD"},"updated_at":1744181243}},"payment_link_details":{"merchant_id":"accu_M7PTgveSgMtTtPHbjFgEtAlD","merchant_name":"ABC Company 1","payment_link":{"id":"test_NivLsKfDfKuNPdULFVPvrhVx","product_items":[{"product":{"id":"prod_7pwJj8FLyBsehx","name":"test","price":{"asset_id":"USD","amount":"1"},"description":"","picture_url":"","tax_code":"","metadata":null,"active":true,"updated_at":1744181220,"created_at":1744181220},"quantity":1}],"total_price":{"asset_id":"USD","amount":"1"},"active":true,"updated_at":1744181243,"created_at":1744181243}},"merchant_order_id":"test_NivLsKfDfKuNPdULFVPvrhVx","payment_method_type":"crypto","charges":[{"id":"ch_UQBFpYEomiYmkAF0wfRIQQ7g","object":"charge","amount":{"asset_id":"USDC-Ethereum-TEST","amount":"1"},"payment_details":{"amount_captured":{"asset_id":"USDC-Ethereum-TEST","amount":"1"},"amount_refunded":{"asset_id":"USDC-Ethereum-TEST","amount":"0"},"tx_fee":{"asset_id":"USDC-Ethereum-TEST","amount":"0"},"tax_fee":{"asset_id":"USDC-Ethereum-TEST","amount":"0"},"frozen_amount":{"asset_id":"USDC-Ethereum-TEST","amount":"0"},"net_amount":{"asset_id":"USDC-Ethereum-TEST","amount":"0"},"gas_fee":{},"network_fee":{"asset_id":"USDC-Ethereum-TEST","amount":"0"}},"exchange_rate":"1.0","calculated_statement_descriptor":"","captured":false,"created":0,"customer":"","description":"","disputed":false,"failure_code":"","failure_message":"","fraud_details":null,"livemode":false,"metadata":null,"paid":false,"payment_intent":"pi_nKSxQrU2Pjh9KGzyIRJcWpGJ","payment_method_type":"crypto","payment_method_options":{"crypto":{"amount":"1000000","token":"USDC","asset_id":"USDC-Ethereum-TEST","network":"Ethereum Sepolia","decimals":6,"exchange_rate":"1.0","deposit_address":"0xa4547D6644a46ed4F395D36d4680800eF5c53bf6","expired_at":1745582581}},"transactions":[{"tx_id":"de3ce20e-1407-47e5-a406-ded38947c486","source_address":"0x36279Ac046498bF0cb742622cCe22F3cE3c2AfD9","destination_address":"0xa4547D6644a46ed4F395D36d4680800eF5c53bf6","tx_hash":"0xa2b3ed89adab6fa946c3be99d65a43f718e12a87eb92f548b3d1ded241fb8e12","amount":"1000000","decimals":6,"asset_id":"USDC-Ethereum-TEST","token":"USDC","network":"Ethereum Sepolia","type":"deposit","created_at":1745580844,"status":"confirmed","aml_status":"approved","aml_info":"","charge_id":"ch_UQBFpYEomiYmkAF0wfRIQQ7g","refund_id":"","fee_info":"network_fee:\"0.001791756437565262\"","fee_currency":"ETH_TEST5"}],"receipt_email":"","receipt_url":"","refunded":false,"refunds":[],"review":null}],"receipt_email":"yihuazhai@163.com","status":"Success","payment_intent_status":"Confirmed","one_time_payment":false}},"livemode":false,"pending_webhooks":0,"type":"payment_intent.succeeded"}'
```

The webhook server will:
- Verify the webhook signature for security
- Parse the event data
- Display detailed event information based on event type (payment_intent, refund, payout, payroll, etc.)

**Supported Event Types:**
- `payment_intent.*` - Payment intent events
- `refund.*` - Refund events
- `payout.*` - Payout events
- `payroll.*` - Payroll events
- `payroll_item.*` - Payroll item events

## Integration Approaches

The payment intent examples demonstrate **two integration approaches**:

### Option 1: MartianPay.js Widget (Recommended)
The easiest way to integrate payments:
- Use the MartianPay.js widget on your frontend
- Simply pass `payment_intent.client_secret` to the widget
- Widget automatically handles payment method selection (crypto or card)
- Widget calls `UpdatePaymentIntent` API for you
- **No need to call UpdatePaymentIntent from your backend**

```javascript
// Frontend integration example
const widget = MartianPay.create(paymentIntent.getClientSecret());
widget.mount('#payment-container');
```

📖 **Documentation**: https://docs.martianpay.com/v1/docs/martianpay-js-usage

### Option 2: API-Only Integration (Advanced)
Direct backend-to-backend integration (shown in examples):
- Create payment intent via API
- Call `UpdatePaymentIntent` with payment method details
- For crypto: Get deposit address from response
- For cards: Get Stripe payload and use Stripe.js on frontend
- Handle webhooks for payment status updates

**Examples in this directory show the API-only approach** to demonstrate all API calls. In production, we recommend using MartianPay.js Widget for easier integration.

## Error Handling

All examples include proper error handling:

```java
try {
    // API call
    CustomerService service = new CustomerService(apiKey);
    Customer customer = service.getCustomer("cus_123");
    System.out.println("Customer: " + customer.getName());
} catch (IOException e) {
    System.err.println("API Error: " + e.getMessage());
    e.printStackTrace();
}
```

## Learn More

- [SDK Documentation](../README.md)
- [API Reference](https://docs.martianpay.com)
- [MartianPay Dashboard](https://dashboard.martianpay.com)
