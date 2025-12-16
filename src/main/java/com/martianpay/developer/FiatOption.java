package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * FiatOption represents configuration options for fiat currency payments.
 *
 * This class encapsulates the preferences and settings for processing fiat currency
 * payments within the MartianPay platform. It allows merchants and customers to
 * specify their payment method preferences and manage saved payment instruments.
 *
 * Key features:
 * - Specify preferred fiat currency for payment
 * - Reference saved payment methods for quick checkout
 * - Control whether to save payment method for future use
 * - Enable one-click payments with saved instruments
 *
 * Use cases:
 * - Customer selects payment method at checkout
 * - Merchant specifies accepted currencies
 * - Enable recurring payments with saved cards
 * - Implement quick checkout flows
 * - Manage customer payment preferences
 * - Support subscription billing
 *
 * Payment method workflow:
 * 1. Customer initiates payment with fiat currency
 * 2. Selects or provides payment method (card, bank account, etc.)
 * 3. Optionally saves payment method for future use
 * 4. System processes payment through specified method
 * 5. Saved method available for subsequent payments
 *
 * Saved payment methods:
 * - Credit/debit cards (tokenized for security)
 * - Bank accounts for ACH/SEPA transfers
 * - Digital wallets (Apple Pay, Google Pay)
 * - Alternative payment methods
 * - Reduces friction in repeat purchases
 * - Enables subscription and recurring billing
 *
 * Security considerations:
 * - Payment methods are tokenized, never stored raw
 * - PCI DSS compliance for card data
 * - Customer consent required to save methods
 * - Ability to delete saved methods
 * - Fraud prevention and monitoring
 * - Secure authentication (3DS, etc.)
 *
 * Currency selection:
 * - Customer's preferred currency
 * - Merchant's accepted currencies
 * - Regional currency defaults
 * - Exchange rate transparency
 * - Multi-currency support
 */
public class FiatOption {
    /**
     * The fiat currency to be used for this payment.
     * ISO 4217 three-letter currency code.
     *
     * Example:
     * - "USD" - United States Dollar (Currently only USD is supported for fiat)
     *
     * This determines:
     * - Which currency the customer will be charged in
     * - Exchange rates applied (if converting from crypto)
     * - Available payment methods for that currency
     * - Display formatting and symbols
     * - Regional compliance requirements
     *
     * The currency must be:
     * - Supported by the merchant's account
     * - Available in the customer's region
     * - Supported by the selected payment method
     */
    @SerializedName("currency")
    private String currency;

    /**
     * The unique identifier of a saved payment method.
     * References a previously saved payment instrument for quick checkout.
     * Format: pm_[random_id]
     *
     * When provided:
     * - System uses the saved payment method
     * - Customer doesn't need to re-enter payment details
     * - Enables one-click or quick checkout
     * - Suitable for subscription and recurring payments
     *
     * Payment method types:
     * - Tokenized credit/debit cards
     * - Bank account details (ACH/SEPA)
     * - Digital wallet connections
     * - Alternative payment method references
     *
     * Security:
     * - Only references owned by the customer can be used
     * - Payment methods are tokenized and encrypted
     * - No sensitive data exposed in the ID
     * - Subject to fraud detection and verification
     *
     * Leave null when:
     * - Customer is entering new payment details
     * - First-time payment for this customer
     * - Customer chooses not to use saved methods
     */
    @SerializedName("payment_method_id")
    private String paymentMethodId;

    /**
     * Indicates whether to save this payment method for future use.
     *
     * When true:
     * - Payment method is tokenized and saved to customer account
     * - Available for future one-click payments
     * - Reduces checkout friction for repeat customers
     * - Enables subscription and recurring billing
     * - Customer can manage saved methods in their account
     *
     * When false:
     * - Payment method used only for this transaction
     * - No payment details stored after transaction
     * - Customer must re-enter details for future payments
     * - More privacy-focused approach
     *
     * Best practices:
     * - Always obtain explicit customer consent
     * - Clearly communicate what will be saved
     * - Provide option to manage saved methods
     * - Comply with regional data protection laws
     * - Use secure tokenization (never store raw card data)
     * - Allow customers to delete saved methods
     *
     * Null or false when:
     * - Customer declines to save
     * - One-time payment scenario
     * - Guest checkout
     * - Privacy-sensitive situations
     */
    @SerializedName("save_payment_method")
    private Boolean savePaymentMethod;

    /**
     * Creates a new FiatOption instance.
     */
    public FiatOption() {
    }

    /**
     * Gets the fiat currency for this payment.
     * @return The ISO 4217 currency code (e.g., "USD")
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the fiat currency for this payment.
     * @param currency The ISO 4217 currency code
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * Gets the saved payment method ID.
     * @return The payment method ID, or null if using a new payment method
     */
    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    /**
     * Sets the saved payment method ID.
     * @param paymentMethodId The payment method ID
     */
    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    /**
     * Gets whether to save this payment method for future use.
     * @return true to save, false or null otherwise
     */
    public Boolean getSavePaymentMethod() {
        return savePaymentMethod;
    }

    /**
     * Sets whether to save this payment method for future use.
     * @param savePaymentMethod true to save, false otherwise
     */
    public void setSavePaymentMethod(Boolean savePaymentMethod) {
        this.savePaymentMethod = savePaymentMethod;
    }
}
