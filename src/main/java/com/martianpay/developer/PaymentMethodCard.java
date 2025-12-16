package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * PaymentMethodCard represents a tokenized credit or debit card payment method.
 *
 * This class stores safe, PCI-compliant card information for saved payment methods.
 * Actual card numbers and CVV codes are never stored. Instead, the card is tokenized
 * by the payment provider (Stripe, PayerMax, etc.) and only metadata is retained.
 *
 * Card tokenization:
 * - Full card numbers are never stored in the database
 * - Sensitive data is replaced with secure tokens
 * - Tokens can be used to charge the card without exposing card details
 * - PCI DSS compliance is maintained by using provider tokens
 * - Card data never touches merchant servers
 *
 * Stored card information:
 * - Last 4 digits: For customer identification only
 * - Brand: For displaying card logos
 * - Expiration: For validity checking
 * - Fingerprint: For detecting duplicate cards
 * - Country: For risk assessment and compliance
 *
 * Use cases:
 * - Saving customer payment methods for future purchases
 * - One-click checkout experiences
 * - Subscription and recurring billing
 * - Displaying saved cards in customer account
 * - Card expiration reminders
 * - Fraud detection via fingerprinting
 * - Multi-card management per customer
 *
 * Security features:
 * - PCI DSS Level 1 compliant (via payment providers)
 * - No sensitive data stored
 * - Tokenized card references only
 * - Encrypted transmission
 * - 3D Secure (3DS) support for transactions
 * - CVV required for each transaction (not stored)
 *
 * Card lifecycle:
 * 1. Customer enters card details at checkout
 * 2. Card data sent directly to payment provider (Stripe/PayerMax)
 * 3. Provider validates and tokenizes the card
 * 4. Token and metadata returned to platform
 * 5. Only metadata stored in PaymentMethodCard
 * 6. Token used for future charges
 * 7. Card can be updated or removed by customer
 * 8. Expired cards automatically marked invalid
 */
public class PaymentMethodCard {
    /**
     * Unique identifier for this saved card.
     * This is the platform's internal ID, not the provider's token.
     * Format: pm_card_[random_id]
     *
     * Used to:
     * - Reference the card in payment requests
     * - Associate card with customer account
     * - Track card usage across payments
     * - Manage multiple cards per customer
     */
    @SerializedName("id")
    private String id;

    /**
     * Payment provider that processed and tokenized this card.
     * Identifies which third-party payment processor holds the actual card token.
     *
     * Common providers:
     * - "stripe": Stripe payment gateway
     * - "payermax": PayerMax for international payments
     * - "adyen": Adyen payment platform
     * - "checkout": Checkout.com
     *
     * Important:
     * - Each provider has different token formats
     * - Tokens are not portable between providers
     * - Provider determines available features (3DS, etc.)
     * - Affects transaction fees and success rates
     */
    @SerializedName("provider")
    private String provider;

    /**
     * Type of card based on its function.
     * Distinguishes between credit and debit cards.
     *
     * Common values:
     * - "credit": Credit card (borrowed funds)
     * - "debit": Debit card (direct bank account access)
     * - "prepaid": Prepaid card with preloaded funds
     * - "unknown": Type could not be determined
     *
     * Usage:
     * - Risk assessment (prepaid cards may be higher risk)
     * - Transaction routing optimization
     * - Customer display and organization
     * - Different processing rules per type
     */
    @SerializedName("type")
    private String type;

    /**
     * Last 4 digits of the card number.
     * Only piece of card number retained for identification.
     *
     * Purpose:
     * - Allows customers to identify which card is saved
     * - Displayed as "•••• 4242" in user interfaces
     * - Insufficient for fraudulent use alone
     * - Helps customer services identify customer cards
     *
     * Privacy:
     * - Only last 4 digits stored (never full number)
     * - Cannot be used to reconstruct full card number
     * - Safe to display to customers
     * - Insufficient for PCI scope
     *
     * Example display: "Visa ending in 4242"
     */
    @SerializedName("last4")
    private String last4;

    /**
     * Card brand or network.
     * Identifies the card issuer/network for display and routing.
     *
     * Common brands:
     * - "visa": Visa
     * - "mastercard": Mastercard
     * - "amex": American Express
     * - "discover": Discover
     * - "diners": Diners Club
     * - "jcb": Japan Credit Bureau
     * - "unionpay": China UnionPay
     *
     * Used for:
     * - Displaying correct card logo in UI
     * - Routing transactions to correct network
     * - Applying brand-specific rules (Amex limits, etc.)
     * - Different fee structures per brand
     * - Acceptance checking (not all merchants accept all brands)
     */
    @SerializedName("brand")
    private String brand;

    /**
     * Card expiration month (1-12).
     * Month when the card expires and can no longer be used.
     *
     * Values: 1 (January) through 12 (December)
     *
     * Expiration checking:
     * - Cards expire at end of the month specified
     * - System should warn customers before expiration
     * - Expired cards must be updated before use
     * - Subscriptions may fail if card expires
     * - Customers should update card before exp_month/exp_year
     *
     * Best practices:
     * - Check expiration before charging
     * - Send reminders 30/60 days before expiration
     * - Provide easy card update flow
     * - Handle expired card gracefully in UI
     */
    @SerializedName("exp_month")
    private Long expMonth;

    /**
     * Card expiration year (4 digits).
     * Year when the card expires and can no longer be used.
     *
     * Format: Four-digit year (e.g., 2025, 2026)
     *
     * Combined with exp_month to determine exact expiration:
     * - Card expires on last day of exp_month in exp_year
     * - Example: exp_month=12, exp_year=2025 means expires December 31, 2025
     *
     * Validation:
     * - Must be current year or future
     * - Typically not more than 10 years in future
     * - Check both month and year for expiration
     */
    @SerializedName("exp_year")
    private Long expYear;

    /**
     * Funding source for the card.
     * Indicates how the card is backed financially.
     *
     * Values:
     * - "credit": Credit card with credit limit
     * - "debit": Debit card linked to bank account
     * - "prepaid": Prepaid card with preloaded balance
     * - "unknown": Funding type could not be determined
     *
     * Risk considerations:
     * - Prepaid cards: Higher fraud risk, anonymous purchases
     * - Debit cards: Direct bank link, lower chargeback risk
     * - Credit cards: Higher chargeback risk, buyer protection
     *
     * Business implications:
     * - Some merchants block prepaid cards
     * - Different fee structures per funding type
     * - Affects authorization success rates
     * - Influences fraud scoring
     */
    @SerializedName("funding")
    private String funding;

    /**
     * Two-letter ISO 3166-1 country code where the card was issued.
     * Identifies the card's country of origin for compliance and risk assessment.
     *
     * Examples: "US", "GB", "CA", "DE", "JP"
     *
     * Use cases:
     * - Geographic risk assessment
     * - Fraud detection (mismatch with customer location)
     * - Regulatory compliance (GDPR, etc.)
     * - Currency optimization
     * - Region-specific processing rules
     *
     * Risk factors:
     * - Cards from high-risk countries may require additional verification
     * - Mismatch between card country and IP location is fraud signal
     * - Some countries have higher chargeback rates
     * - Sanctions and restricted countries must be blocked
     */
    @SerializedName("country")
    private String country;

    /**
     * Unique fingerprint identifier for this card.
     * Hash of card number used to detect duplicate cards without storing the actual number.
     *
     * Purpose:
     * - Detect when same card is added multiple times
     * - Prevent duplicate payment methods
     * - Track card reuse across accounts (fraud detection)
     * - Link cards without storing card numbers
     *
     * Security:
     * - One-way hash (cannot reverse to get card number)
     * - Same card always generates same fingerprint
     * - Different cards always generate different fingerprints
     * - Safe to store and compare
     *
     * Use cases:
     * - Prevent customer from saving same card twice
     * - Detect card sharing across accounts (fraud)
     * - Link failed payment attempts to card
     * - Analyze card performance (success rates per fingerprint)
     * - Block specific cards without storing card numbers
     *
     * Privacy:
     * - Cannot be used to reconstruct card number
     * - Safe from PCI compliance perspective
     * - Anonymized card identification
     */
    @SerializedName("fingerprint")
    private String fingerprint;

    public PaymentMethodCard() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLast4() {
        return last4;
    }

    public void setLast4(String last4) {
        this.last4 = last4;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Long getExpMonth() {
        return expMonth;
    }

    public void setExpMonth(Long expMonth) {
        this.expMonth = expMonth;
    }

    public Long getExpYear() {
        return expYear;
    }

    public void setExpYear(Long expYear) {
        this.expYear = expYear;
    }

    public String getFunding() {
        return funding;
    }

    public void setFunding(String funding) {
        this.funding = funding;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }
}
