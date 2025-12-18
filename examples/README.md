# MartianPay SDK Examples

This directory contains an interactive menu-driven example program demonstrating how to use the MartianPay Java SDK as a third-party library.

**✨ Key Features:**
- 📋 Two-level menu system organized by feature category
- 🎲 Automatic randomization of emails and order IDs to prevent duplicates
- 🎯 Interactive prompts for flexible input (addresses, amounts, networks)
- ✅ Comprehensive coverage of all SDK methods

> **⚠️ Important**: These examples show the **API-only integration approach** to demonstrate all SDK methods. For production use, we recommend the **MartianPay.js Widget** for easier integration. See [Integration Approaches](#integration-approaches) below.

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
3. Launch the interactive menu

### Option 2: Build JAR and run

```bash
# Build executable JAR (includes all dependencies)
./build_jar.sh

# Run the interactive menu
java -jar build/jars/martianpay-examples-1.0.0.jar
```

### Option 3: Using Maven (Optional)

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

Enter your API key when prompted:
```
================================================================================
MartianPay Java SDK Examples
================================================================================

Enter your API key (or press Enter to use default):
```

You can either:
- Enter your own API key from [MartianPay Dashboard](https://dashboard.martianpay.com)
- Press Enter to use the default key configured in `Common.java` (if set)

To set a default API key, update `Common.java`:
```java
public class Common {
    public static final String API_KEY = "your_api_key_here";  // Replace with your actual API key
    public static final String WEBHOOK_SECRET = "your_webhook_secret"; // Replace with your webhook secret
}
```

After changing the configuration, recompile:
```bash
./build_jar.sh
```

## How the Menu Works

The examples use a **two-level menu system** for better organization:

### Main Menu (Level 1)
Select a category:
1. **Payment Intent Examples**
2. **Customer Examples**
3. **Refund Examples**
4. **Payroll Examples**
5. **Merchant Address Examples**
6. **Payout Examples**
7. **Assets Examples**
8. **Balance Examples**
9. **Product Examples**
10. **Payment Link Examples**
11. **Subscription Examples**
12. **Webhook Examples**

### Submenu (Level 2)
After selecting a category, you'll see specific examples:

**Payment Intent Examples:**
1. Create and Update Payment Intent (Crypto)
2. Get Payment Intent
3. List Payment Intents
4. Cancel Payment Intent
5. List Payment Intents with Permanent Deposit
6. Fiat Payment with New Card
7. Fiat Payment with Saved Card
8. Create Payment Intent with Payment Link

**Customer Examples:**
1. Create and Update Customer
2. Get Customer
3. List Customers
4. Delete Customer
5. List Customer Payment Methods

**Refund Examples:**
1. Create Refund
2. Get Refund
3. List Refunds

**Payroll Examples:**
1. Create Direct Payroll (Normal Payment)
2. Create Direct Payroll (Binance Payment)
3. Get Payroll
4. List Payrolls
5. List Payroll Items

**Merchant Address Examples:**
1. Create Merchant Address
2. Get Merchant Address
3. Update Merchant Address
4. Verify Merchant Address
5. List Merchant Addresses
6. List Merchant Addresses by Network
7. Delete Merchant Address
8. Create and Verify Merchant Address (Full Workflow)

**Payout Examples:**
1. Preview Payout
2. Create Payout
3. Get Payout
4. List Payouts
5. Get Payout Approval Instance
6. Approve Payout
7. Reject Payout
8. Cancel Payout

**Assets Examples:**
1. List Enabled Assets
2. Get All Available Assets
3. List Asset Network Fees
4. Show Crypto Assets by Network
5. Show Payable Assets Only
6. Compare Mainnet vs Testnet Assets

**Balance Examples:**
1. Show Balance Summary
2. Show Balance by Currency
3. Show Available Balances Only
4. Show Locked and Pending Balances
5. Compare Balance Types

**Product Examples:**
1. List Products
2. Create Product with Variants
3. Create Product with Selling Plan
4. Get Product
5. Update Product
6. Delete Product
7. List Active Products
8. List Selling Plan Groups
9. Create Selling Plan Group
10. Get Selling Plan Group
11. Update Selling Plan Group
12. Delete Selling Plan Group
13. List Selling Plans
14. Create Selling Plan
15. Get Selling Plan
16. Update Selling Plan
17. Delete Selling Plan
18. Calculate Selling Plan Price

**Payment Link Examples:**
1. List Payment Links
2. Create Payment Link
3. Get Payment Link
4. Update Payment Link
5. Delete Payment Link
6. List Active Payment Links
7. List Payment Links by Product

**Subscription Examples:**
1. List Subscriptions
2. List Subscriptions by Customer
3. List Subscriptions by Status
4. Get Subscription
5. Cancel Subscription at Period End
6. Cancel Subscription Immediately
7. Pause Subscription
8. Pause Subscription with Auto-Resume
9. Resume Subscription
10. Update Subscription (Plan Change)
11. Preview Subscription Update

**Webhook Examples:**
1. Start Webhook Event Receiver Server

Enter `0` at any level to go back or exit.

## Smart Features

### 1. Automatic Randomization
To prevent duplicate errors, the examples automatically generate unique values:
- **Email addresses**: `customer_1733812345_123456@example.com`
- **Order IDs**: `order_1733812345_123456`
- **External IDs**: Timestamps and random numbers

### 2. Interactive Input
Key examples prompt for user input:
- **Payroll creation**: Select crypto asset (from available balance), enter recipient address and amount
- **Merchant address**: Enter network and blockchain address
- **Refund creation**: Enter payment intent ID and refund amount
- **Customer queries**: Enter customer ID or use defaults

### 3. User-Friendly Flow
- Two-level menu reduces clutter and improves navigation
- Clear prompts with default values (press Enter to use default)
- Input validation and helpful error messages
- Return to category submenu after each example
- Press `0` to go back or exit at any time

This is a third-party usage demonstration - the examples import the MartianPay SDK just like you would in your own application.

## File Structure

The examples are organized into separate files by functionality:

- `Main.java` - Main program entry point and interactive menu
- `Common.java` - Shared API key constant and webhook secret
- `PaymentIntentExample.java` - Payment intent examples (crypto & card payments)
- `CustomerExample.java` - Customer management examples
- `RefundExample.java` - Refund examples
- `PayrollExample.java` - Payroll examples (normal and Binance)
- `MerchantAddressExample.java` - Merchant address/wallet examples
- `PayoutExample.java` - Payout examples with approval workflow
- `AssetsExample.java` - Assets and network fee examples
- `BalanceExample.java` - Balance query examples
- `ProductExample.java` - Product and selling plan management examples
- `PaymentLinkExample.java` - Payment link management examples
- `SubscriptionExample.java` - Subscription management examples
- `WebhookExample.java` - Webhook event receiver server example

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

#### Stripe Card Payment Frontend Integration

When using the API-only approach for card payments, you'll receive a Stripe payload from the `UpdatePaymentIntent` response. Here's how to integrate it on your frontend:

**Step 1: Backend - Create and update payment intent** (see examples 6 & 7)
```java
// Backend receives Stripe payload from UpdatePaymentIntent response
StripePayload stripePayload = updateResponse.getPaymentMethodOptions().getFiat().getStripePayload();
```

**Step 2: Frontend - Include Stripe.js**
```html
<!-- Add Stripe.js to your page -->
<script src="https://js.stripe.com/v3/"></script>
```

**Step 3: Frontend - Initialize Stripe and confirm payment**
```javascript
// Initialize Stripe with the public key from backend response
const stripe = Stripe(stripePublicKey);  // From response.publicKey

// For new card payment
if (response.stripePayload.clientSecret) {
  // Confirm the card payment
  const { error, paymentIntent } = await stripe.confirmCardPayment(
    response.stripePayload.clientSecret,
    {
      payment_method: {
        card: cardElement,  // Your Stripe card element
        billing_details: {
          name: customerName,
          email: customerEmail
        }
      }
    }
  );

  if (error) {
    console.error('Payment failed:', error.message);
  } else if (paymentIntent.status === 'succeeded') {
    console.log('Payment successful!');
    // Redirect to success page or show confirmation
  }
}

// For saved card payment
if (response.stripePayload.paymentMethodId) {
  // Confirm payment with saved card
  const { error, paymentIntent } = await stripe.confirmCardPayment(
    response.stripePayload.clientSecret,
    {
      payment_method: response.stripePayload.paymentMethodId
    }
  );

  if (error) {
    console.error('Payment failed:', error.message);
  } else if (paymentIntent.status === 'succeeded') {
    console.log('Payment successful!');
  }
}
```

**Complete Frontend Example:**
```html
<!DOCTYPE html>
<html>
<head>
  <script src="https://js.stripe.com/v3/"></script>
</head>
<body>
  <form id="payment-form">
    <div id="card-element"></div>
    <button type="submit">Pay</button>
  </form>

  <script>
    // Get payment data from your backend
    const paymentData = {
      publicKey: 'pk_test_xxx',  // From UpdatePaymentIntent response
      clientSecret: 'pi_xxx_secret_xxx',  // From stripePayload
    };

    // Initialize Stripe
    const stripe = Stripe(paymentData.publicKey);
    const elements = stripe.elements();
    const cardElement = elements.create('card');
    cardElement.mount('#card-element');

    // Handle form submission
    document.getElementById('payment-form').addEventListener('submit', async (e) => {
      e.preventDefault();

      const { error, paymentIntent } = await stripe.confirmCardPayment(
        paymentData.clientSecret,
        {
          payment_method: {
            card: cardElement,
            billing_details: {
              name: 'Customer Name',
              email: 'customer@example.com'
            }
          }
        }
      );

      if (error) {
        alert('Payment failed: ' + error.message);
      } else if (paymentIntent.status === 'succeeded') {
        alert('Payment successful!');
        // Handle success - redirect or update UI
      }
    });
  </script>
</body>
</html>
```

📖 **Stripe Documentation**: https://stripe.com/docs/js/payment_intents/confirm_card_payment

## Webhook Testing

Example 83 (Webhook Examples menu) starts a webhook event receiver server. Here's how to test it:

1. **Start the webhook server** by selecting option 83 from the examples menu:
```bash
./build_jar.sh
java -jar build/jars/martianpay-examples-1.0.0.jar
# Then select: 12 → 1
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

**Payment Intent Events:**
- `payment_intent.created` - New payment intent is created
- `payment_intent.succeeded` - Payment intent has been fully paid and completed successfully
- `payment_intent.payment_failed` - Payment attempt for a payment intent fails
- `payment_intent.processing` - Payment intent is being processed (e.g., waiting for blockchain confirmation)
- `payment_intent.partially_paid` - Payment intent has received partial payment but is not yet fully paid
- `payment_intent.canceled` - Payment intent is canceled

**Refund Events:**
- `refund.created` - New refund is created
- `refund.succeeded` - Refund has been successfully processed and funds returned to customer
- `refund.updated` - Refund's details are updated
- `refund.failed` - Refund attempt fails

**Payout Events:**
- `payout.created` - New payout is created
- `payout.succeeded` - Payout has been successfully transferred to the recipient
- `payout.updated` - Payout's details are updated
- `payout.failed` - Payout attempt fails

**Payroll Events:**
- `payroll.created` - New payroll batch is created
- `payroll.approved` - Payroll batch has been approved for execution
- `payroll.rejected` - Payroll batch approval is rejected
- `payroll.canceled` - Payroll batch is canceled
- `payroll.executing` - Payroll batch execution has started
- `payroll.completed` - All items in a payroll batch have been processed successfully
- `payroll.failed` - Payroll batch execution fails

**Payroll Item Events:**
- `payroll_item.processing` - Individual payroll item is being processed
- `payroll_item.succeeded` - Individual payroll item has been successfully paid
- `payroll_item.failed` - Individual payroll item payment fails
- `payroll_item.address_verification_sent` - Address verification email has been sent to the recipient
- `payroll_item.address_verified` - Recipient has verified their wallet address

**Subscription Events:**
- `subscription.created` - New subscription is created
- `subscription.updated` - Subscription's details are updated (e.g., plan, quantity, billing cycle)
- `subscription.deleted` - Subscription is deleted or permanently canceled
- `subscription.paused` - Subscription is temporarily paused
- `subscription.resumed` - Paused subscription is resumed
- `subscription.trial_will_end` - Subscription's trial period is about to end (typically 3 days before)

**Invoice Events:**
- `invoice.created` - New invoice is created (draft state)
- `invoice.finalized` - Invoice is finalized and ready for payment
- `invoice.paid` - Invoice has been fully paid
- `invoice.payment_succeeded` - Payment attempt for an invoice succeeds
- `invoice.payment_failed` - Payment attempt for an invoice fails
- `invoice.payment_action_required` - Invoice payment requires additional action from the customer
- `invoice.upcoming` - Upcoming invoice will be generated soon (for subscriptions)
- `invoice.updated` - Invoice's details are updated
- `invoice.voided` - Invoice is voided and can no longer be paid

## Notes

- These examples use the martianpay-java-sdk package as an external dependency, just like you would in a real application
- Each example includes detailed integration comments explaining both approaches
- All API errors are printed with detailed error messages (`error_code` and `msg`)
- Payment intent examples include integration tips at the end of output
- Remember to update API key in `Common.java` before running
- The menu system allows you to run multiple examples in one session without restarting
- Emails and order IDs are automatically randomized to prevent duplicate errors

## Learn More

- [SDK Documentation](../README.md)
- [API Reference](https://docs.martianpay.com)
- [MartianPay Dashboard](https://dashboard.martianpay.com)
