package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Parameters for a single payroll payment item.
 */
public class PayrollItemParams {
    /**
     * External reference ID from your payroll or HR system.
     * Unique identifier linking this payment to your records.
     *
     * Purpose:
     * - Link to employee/contractor ID
     * - Track payment in your payroll system
     * - Enable reconciliation
     * - Support idempotency in batch processing
     * - Facilitate payment lookups
     * - Audit trail maintenance
     *
     * ID format suggestions:
     * - Include employee/contractor ID
     * - Add payment period identifier
     * - Make human-readable
     * - Ensure uniqueness per batch
     *
     * Examples:
     * - "EMP-12345-2024-12" (Employee 12345, December 2024)
     * - "CONTRACTOR-789-2024-W48" (Contractor 789, Week 48)
     * - "VENDOR-INV-20241215-001" (Vendor invoice payment)
     * - "COMM-AGENT-42-Q4-2024" (Commission payment)
     *
     * Best practices:
     * - Use your existing payroll ID format
     * - Include date/period for clarity
     * - Maintain consistency across batches
     * - Ensure uniqueness to prevent duplicates
     * - Store mapping in your database
     *
     * Usage:
     * - Reconcile with payroll records
     * - Track payment status
     * - Generate payroll reports
     * - Handle failed payment retries
     * - Support employee inquiries
     *
     * Required: Yes (strongly recommended)
     */
    @SerializedName("external_id")
    private String externalId;

    /**
     * Full name of the payment recipient.
     * Employee, contractor, or vendor name.
     *
     * Name format:
     * - Use legal name for compliance
     * - Include first and last name
     * - Support international characters
     * - Match official employment records
     * - Use business name for vendors
     *
     * Examples:
     * - "John Doe" (Employee)
     * - "Jane Smith" (Contractor)
     * - "Acme Consulting LLC" (Vendor)
     * - "María García" (International employee)
     * - "李明" (Employee with Chinese name)
     *
     * Usage:
     * - Payment confirmations and receipts
     * - Compliance and tax reporting
     * - Payment notifications
     * - Audit trails
     * - Employee communication
     *
     * Compliance considerations:
     * - Must match identity verification
     * - Used in tax documentation
     * - Required for regulatory reporting
     * - Appears on payment records
     *
     * Best practices:
     * - Verify name spelling
     * - Match employment contracts
     * - Support unicode characters
     * - Update when changed legally
     * - Maintain name history
     *
     * Required: Yes
     */
    @SerializedName("name")
    private String name;

    /**
     * Email address of the payment recipient.
     * Used for payment notifications and receipts.
     *
     * Email purposes:
     * - Send payment confirmations
     * - Deliver payment receipts
     * - Notify of payment status
     * - Tax document delivery
     * - Payment issue alerts
     * - Account notifications
     *
     * Format requirements:
     * - Valid email format
     * - Active and monitored address
     * - Preferably work or business email
     * - Should match employee records
     *
     * Email notifications include:
     * - Payment processed confirmation
     * - Payment amount and date
     * - Transaction reference numbers
     * - Payment method used
     * - Expected delivery time
     * - Tax withholding details (if applicable)
     *
     * Privacy and compliance:
     * - Obtain consent for communications
     * - Secure email transmission
     * - GDPR/privacy regulation compliance
     * - Protect from unauthorized access
     * - Allow email updates
     *
     * Examples:
     * - "john.doe@company.com" (Employee)
     * - "contractor@freelance.com" (Contractor)
     * - "billing@vendor.com" (Vendor)
     *
     * Required: Yes (strongly recommended for notifications)
     */
    @SerializedName("email")
    private String email;

    /**
     * Phone number of the payment recipient in E.164 format.
     * Used for SMS notifications and verification.
     *
     * E.164 format: +[country code][number]
     *
     * Examples:
     * - US: "+12025551234"
     * - UK: "+442071234567"
     * - International mobile: "+819012345678"
     *
     * Usage:
     * - SMS payment notifications
     * - Two-factor authentication
     * - Payment verification
     * - Issue resolution contact
     * - Urgent payment alerts
     * - Account security
     *
     * Notification scenarios:
     * - Payment successfully processed
     * - Payment requires action
     * - Payment delivery confirmed
     * - Payment failed or delayed
     * - Verify large payment amounts
     *
     * Best practices:
     * - Verify number is active
     * - Obtain consent for SMS
     * - Use mobile numbers when possible
     * - Update when changed
     * - Respect time zones for SMS
     *
     * Privacy considerations:
     * - Secure phone number storage
     * - Comply with SMS regulations (TCPA in US)
     * - Provide opt-out capability
     * - Don't share with third parties
     *
     * Required: No (but recommended for enhanced security)
     */
    @SerializedName("phone")
    private String phone;

    /**
     * Payment amount in the smallest unit of the specified currency.
     *
     * Amount format:
     * - Cryptocurrencies: Smallest token unit (consider decimals)
     * - Fiat: Cents or minor currency unit
     * - String format to prevent precision loss
     * - Must be positive value
     * - Gross or net amount (depending on configuration)
     *
     * Examples by currency:
     * - USDT (6 decimals): "500000000" = 500 USDT
     * - ETH (18 decimals): "1000000000000000000" = 1 ETH
     * - USD: "150000" = $1,500.00
     * - BTC (8 decimals): "10000000" = 0.1 BTC
     *
     * Amount considerations:
     * - Include all decimal places
     * - Calculate taxes separately if needed
     * - Account for payment fees
     * - Verify against pay rate agreements
     * - Consider currency conversion
     *
     * Payroll calculations:
     * - Gross salary amount
     * - Net after deductions (if applicable)
     * - Bonus and commission amounts
     * - Hourly rate × hours worked
     * - Contract payment amounts
     *
     * Validation:
     * - Must be greater than zero
     * - Should not exceed reasonable limits
     * - Match employment contracts
     * - Verify against payroll budget
     * - Check for data entry errors
     *
     * Tax and compliance:
     * - May need to report gross amount
     * - Consider tax withholding
     * - Currency exchange implications
     * - Cross-border payment rules
     *
     * Required: Yes
     */
    @SerializedName("amount")
    private String amount;

    /**
     * Currency or cryptocurrency code for the payment.
     * Specifies what currency the recipient will receive.
     *
     * Common payment currencies:
     * - "USDT" - Tether stablecoin
     * - "USDC" - USD Coin stablecoin
     * - "BTC" - Bitcoin
     * - "ETH" - Ethereum
     * - "DAI" - Dai stablecoin
     * - "USD" - US Dollar (fiat, currently only USD is supported for fiat)
     *
     * Currency selection factors:
     * - Employee/contractor preference
     * - Location and regulations
     * - Payment method availability
     * - Exchange rate considerations
     * - Network fees (for crypto)
     * - Settlement speed requirements
     *
     * Cryptocurrency benefits for payroll:
     * - Instant global payments
     * - Lower international fees
     * - 24/7 payment processing
     * - Transparent on blockchain
     * - Easy multi-currency support
     *
     * Fiat currency for payroll:
     * - Traditional banking integration
     * - Local currency convenience
     * - Regulatory compliance easier
     * - Familiar to recipients
     * - Tax withholding integration
     *
     * Multi-chain consideration:
     * For tokens like USDT available on multiple chains,
     * the network field specifies which blockchain.
     *
     * Required: Yes
     */
    @SerializedName("coin")
    private String coin;

    /**
     * Blockchain network for cryptocurrency payments.
     * Specifies which blockchain to use for the payment.
     *
     * Common networks:
     * - "ethereum" - Ethereum mainnet
     * - "polygon" - Polygon (MATIC)
     * - "binance-smart-chain" - BSC
     * - "tron" - Tron network
     * - "arbitrum" - Arbitrum L2
     * - "optimism" - Optimism L2
     * - "bitcoin" - Bitcoin network
     *
     * Network selection criteria:
     * - Transaction fees (gas costs)
     * - Confirmation speed
     * - Recipient wallet compatibility
     * - Token availability on network
     * - Reliability and uptime
     * - Recipient preference
     *
     * Network characteristics:
     *
     * Ethereum:
     * - High liquidity, most supported
     * - Higher gas fees
     * - 12-15 second blocks
     *
     * Polygon:
     * - Very low fees
     * - Fast confirmations
     * - Good for frequent payments
     *
     * Binance Smart Chain:
     * - Low fees
     * - Fast blocks (3 seconds)
     * - Wide wallet support
     *
     * Tron:
     * - Low to no fees
     * - Fast transfers
     * - Popular in Asia
     *
     * Important:
     * - Recipient wallet must support the network
     * - Sending to wrong network may lose funds
     * - Verify network compatibility
     * - Use testnet for initial testing
     *
     * Required: Yes (for cryptocurrency payments)
     */
    @SerializedName("network")
    private String network;

    /**
     * Recipient's wallet address or bank account identifier.
     * Where the payment will be sent.
     *
     * Address formats:
     *
     * Cryptocurrency wallet addresses:
     * - Ethereum/EVM: "0x742d35Cc6634C0532925a3b844Bc9e7595f0bEb" (42 chars)
     * - Bitcoin: "bc1qxy2kgdygjrsqtzq2n0yrf2493p83kkfjhx0wlh" (segwit)
     * - Tron: "TXYZopYRdj2D9XRtbG411XZZ3kM5VkAeBf" (34 chars)
     *
     * Bank account identifiers:
     * - IBAN (Europe): "DE89370400440532013000"
     * - US Account: "123456789" with routing number
     * - UK: Sort code + Account number
     *
     * Critical considerations:
     * - Cryptocurrency transactions are irreversible
     * - Wrong address = lost funds
     * - Verify address carefully
     * - Double-check network compatibility
     * - Use address validation
     * - Consider address whitelist
     *
     * Validation steps:
     * - Format verification
     * - Checksum validation (crypto)
     * - Network compatibility check
     * - Address ownership confirmation
     * - Test with small amount first
     * - Verify with recipient
     *
     * Security best practices:
     * - Collect address securely
     * - Verify via multiple channels
     * - Store encrypted
     * - Audit address changes
     * - Use saved/verified addresses
     * - Implement address book
     *
     * Common errors to avoid:
     * - Mixing up networks (e.g., sending ETH to BSC address)
     * - Typos in address
     * - Using exchange addresses without memo/tag
     * - Sending to smart contract addresses
     *
     * Required: Yes
     */
    @SerializedName("address")
    private String address;

    /**
     * Payment method type to be used for this payment.
     *
     * Supported payment methods:
     * - "crypto_wallet" - Cryptocurrency wallet transfer
     * - "bank_transfer" - Bank account transfer
     * - "ach" - ACH bank transfer (US)
     * - "sepa" - SEPA bank transfer (Europe)
     * - "wire" - Wire transfer
     * - "digital_wallet" - PayPal, Wise, etc.
     * - "internal" - Internal merchant transfer
     *
     * Payment method characteristics:
     *
     * Crypto wallet:
     * - Fast (minutes to hours)
     * - Global reach
     * - Network fees apply
     * - Irreversible
     * - 24/7 availability
     *
     * Bank transfer (ACH):
     * - 1-3 business days
     * - US domestic only
     * - Low fees
     * - Business hours only
     *
     * Bank transfer (SEPA):
     * - 1-2 business days
     * - Euro zone
     * - Low fees
     * - Business hours only
     *
     * Wire transfer:
     * - Same day possible
     * - International support
     * - Higher fees
     * - Business hours
     *
     * Selection factors:
     * - Recipient location
     * - Urgency of payment
     * - Cost considerations
     * - Recipient preference
     * - Compliance requirements
     * - Currency type
     *
     * Required: Yes
     */
    @SerializedName("payment_method")
    private String paymentMethod;

    public PayrollItemParams() {
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
