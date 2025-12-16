package com.martianpay.developer;

/**
 * PayrollAddressVerificationResponse represents the response after initiating address verification for payroll.
 *
 * This response is returned when a merchant initiates the address verification process for a payroll batch.
 * Address verification is a security measure to ensure that the recipient's cryptocurrency address is
 * valid and controlled by the intended recipient before processing bulk payments.
 *
 * The verification process typically involves:
 * 1. Sending a small verification amount to the provided address
 * 2. Recipient confirms receipt of the verification transaction
 * 3. System validates the address is accessible and correct
 * 4. Payroll batch can proceed once verification is complete
 *
 * This empty response indicates the verification process has been successfully initiated.
 * Use the corresponding get verification status endpoint to check the verification progress.
 *
 * Use cases:
 * - Initiating address verification before large payroll batches
 * - Ensuring recipient addresses are valid before bulk payouts
 * - Reducing risk of sending funds to incorrect addresses
 * - Compliance with internal security protocols
 */
public class PayrollAddressVerificationResponse {
    /**
     * Default constructor for PayrollAddressVerificationResponse.
     */
    public PayrollAddressVerificationResponse() {
    }
}
