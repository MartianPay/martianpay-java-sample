package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * PayrollGetAddressVerificationResponse represents address verification details for payroll.
 *
 * This response contains information about the address verification process for a payroll batch.
 * Address verification ensures that recipient cryptocurrency addresses are valid and controlled
 * by the intended recipients before large payouts are processed.
 *
 * The verification process involves sending a small test amount to the recipient's address.
 * The recipient must acknowledge receiving this amount to confirm address ownership and validity.
 *
 * Response fields:
 * - coin: The cryptocurrency being used for verification
 * - network: The blockchain network (e.g., ERC20, TRC20, BEP20)
 * - address: The recipient address being verified
 * - amount_start_decimal: Minimum verification amount (inclusive)
 * - amount_end_decimal: Maximum verification amount (inclusive)
 *
 * Verification workflow:
 * 1. System generates random verification amount within range
 * 2. Small test transaction is sent to the address
 * 3. Recipient checks their wallet for the exact amount
 * 4. Recipient confirms receipt through verification endpoint
 * 5. Address is marked as verified
 * 6. Payroll batch can proceed with confidence
 *
 * The amount range prevents automated verification and ensures human confirmation.
 * Typical ranges are very small (e.g., 0.001 to 0.009 USDT) to minimize costs.
 *
 * Use cases:
 * - Verify new recipient addresses before first payout
 * - Ensure addresses are accessible and monitored
 * - Prevent sending funds to incorrect or lost addresses
 * - Meet internal compliance requirements
 * - Reduce risk in high-value payroll batches
 */
public class PayrollGetAddressVerificationResponse {
    /**
     * The cryptocurrency coin symbol used for verification.
     * Examples: "USDT", "USDC", "BTC", "ETH"
     */
    @SerializedName("coin")
    private String coin;

    /**
     * The blockchain network for the verification transaction.
     * Examples: "ERC20", "TRC20", "BEP20", "Polygon", "Arbitrum"
     */
    @SerializedName("network")
    private String network;

    /**
     * The cryptocurrency address being verified.
     * The recipient must have access to this address to complete verification.
     */
    @SerializedName("address")
    private String address;

    /**
     * The minimum verification amount (inclusive) in decimal format.
     * Represents the smallest possible test amount that could be sent.
     */
    @SerializedName("amount_start_decimal")
    private String amountStartDecimal;

    /**
     * The maximum verification amount (inclusive) in decimal format.
     * Represents the largest possible test amount that could be sent.
     */
    @SerializedName("amount_end_decimal")
    private String amountEndDecimal;

    /**
     * Default constructor for PayrollGetAddressVerificationResponse.
     */
    public PayrollGetAddressVerificationResponse() {
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

    public String getAmountStartDecimal() {
        return amountStartDecimal;
    }

    public void setAmountStartDecimal(String amountStartDecimal) {
        this.amountStartDecimal = amountStartDecimal;
    }

    public String getAmountEndDecimal() {
        return amountEndDecimal;
    }

    public void setAmountEndDecimal(String amountEndDecimal) {
        this.amountEndDecimal = amountEndDecimal;
    }
}
