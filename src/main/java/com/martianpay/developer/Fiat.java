package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Fiat represents fiat currency payment options and conversion details.
 *
 * This class encapsulates information about fiat currency amounts when dealing with
 * cryptocurrency payments. It enables merchants to display prices in familiar fiat
 * currencies while accepting cryptocurrency payments, improving user experience.
 *
 * Key features:
 * - Display pricing in local fiat currencies (USD)
 * - Track exchange rates used for crypto-to-fiat conversion
 * - Handle multiple decimal precision for different currencies
 * - Support international payment scenarios
 * - Provide transparent pricing for customers
 *
 * Use cases:
 * - Show invoice amounts in customer's local currency
 * - Calculate cryptocurrency payment amounts from fiat prices
 * - Display exchange rates at time of payment
 * - Generate receipts with fiat and crypto amounts
 * - Support multi-currency payment gateways
 * - Enable price comparison across currencies
 *
 * Currency conversion workflow:
 * 1. Merchant sets price in fiat currency (e.g., 100 USD)
 * 2. System fetches current exchange rate for selected crypto
 * 3. Calculates equivalent crypto amount (e.g., 0.0025 BTC)
 * 4. Customer sees both amounts before payment
 * 5. Payment processed in cryptocurrency
 * 6. Receipt shows both fiat and crypto amounts with exchange rate
 *
 * Decimal precision:
 * - USD: Typically 2 decimals (cents)
 * - Other currencies may vary (e.g., JPY: 0 decimals)
 * - BTC equivalents: Up to 8 decimals
 * - Some currencies: 3 decimals (e.g., KWD, BHD)
 *
 * Exchange rate considerations:
 * - Rates are snapshots at transaction time
 * - May include conversion fees or spreads
 * - Locked for payment duration to prevent rate changes
 * - Historical rates preserved for accounting
 * - Compliant with financial regulations
 *
 * Important notes:
 * - All amounts stored as strings to preserve precision
 * - Currency codes follow ISO 4217 standard
 * - Exchange rates are decimal representations
 * - Decimal places vary by currency
 * - Suitable for display and reporting purposes
 */
public class Fiat {
    /**
     * The amount to be paid in fiat currency.
     * Represented as a string to maintain precision for fractional amounts.
     *
     * Format depends on the currency's decimal places:
     * - USD: "100.50" represents $100.50 (Currently only USD is supported for fiat)
     *
     * The amount is in the currency's standard units, not minor units.
     * This is the equivalent value of the cryptocurrency payment in fiat terms.
     */
    @SerializedName("amount")
    private String amount;

    /**
     * Unique identifier for the fiat currency asset in the system.
     * Links this fiat representation to the platform's asset management.
     * Format: asset_[random_id]
     *
     * This ID is used to:
     * - Reference currency-specific configurations
     * - Track supported currencies
     * - Apply currency-specific rules and validations
     * - Link to payment method configurations
     */
    @SerializedName("asset_id")
    private String assetId;

    /**
     * ISO 4217 three-letter currency code.
     * Standard international codes for identifying currencies.
     *
     * Example:
     * - "USD" - United States Dollar (Currently only USD is supported for fiat)
     *
     * Used for:
     * - Display formatting with correct symbols
     * - Currency-specific validation rules
     * - International payment processing
     * - Multi-currency support
     */
    @SerializedName("currency")
    private String currency;

    /**
     * The number of decimal places used for this currency.
     * Determines the precision for amount representation.
     *
     * Common values:
     * - 2: Most currencies including USD - cents/pennies
     * - 0: Some currencies like Japanese Yen - no fractional units
     * - 3: Kuwaiti Dinar, Bahraini Dinar - fils
     *
     * This affects:
     * - Amount formatting in user interfaces
     * - Rounding rules for calculations
     * - Validation of amount values
     * - Display precision requirements
     *
     * Example: USD has decimals=2, so $1.50 has 2 decimal places.
     */
    @SerializedName("decimals")
    private Integer decimals;

    /**
     * The exchange rate applied for currency conversion.
     * Represents the conversion rate from cryptocurrency to this fiat currency.
     * Represented as a string to maintain precision.
     *
     * Format examples:
     * - "42500.00" - 1 BTC = 42,500 USD
     * - "0.00002353" - 1 USDT = 0.00002353 BTC
     *
     * The exchange rate is:
     * - Locked at transaction creation time
     * - Includes any applicable spreads or fees
     * - Used for calculating equivalent crypto amounts
     * - Preserved for historical record keeping
     * - Compliant with financial reporting requirements
     *
     * Formula: cryptoAmount = fiatAmount / exchangeRate
     */
    @SerializedName("exchange_rate")
    private String exchangeRate;

    /**
     * Creates a new Fiat instance.
     */
    public Fiat() {
    }

    /**
     * Gets the amount in fiat currency.
     * @return The fiat amount as a string
     */
    public String getAmount() {
        return amount;
    }

    /**
     * Sets the amount in fiat currency.
     * @param amount The fiat amount as a string
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * Gets the unique identifier for the fiat currency asset.
     * @return The asset ID
     */
    public String getAssetId() {
        return assetId;
    }

    /**
     * Sets the unique identifier for the fiat currency asset.
     * @param assetId The asset ID
     */
    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    /**
     * Gets the ISO 4217 currency code.
     * @return The three-letter currency code (e.g., "USD")
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the ISO 4217 currency code.
     * @param currency The three-letter currency code
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * Gets the number of decimal places for this currency.
     * @return The decimal precision (e.g., 2 for USD)
     */
    public Integer getDecimals() {
        return decimals;
    }

    /**
     * Sets the number of decimal places for this currency.
     * @param decimals The decimal precision
     */
    public void setDecimals(Integer decimals) {
        this.decimals = decimals;
    }

    /**
     * Gets the exchange rate for currency conversion.
     * @return The exchange rate as a string
     */
    public String getExchangeRate() {
        return exchangeRate;
    }

    /**
     * Sets the exchange rate for currency conversion.
     * @param exchangeRate The exchange rate as a string
     */
    public void setExchangeRate(String exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}
