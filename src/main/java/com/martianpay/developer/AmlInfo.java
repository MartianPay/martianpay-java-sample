package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * AmlInfo contains Anti-Money Laundering (AML) screening information for transactions and addresses.
 *
 * AML screening is a critical compliance mechanism that evaluates transactions and addresses
 * against various risk indicators and regulatory requirements. This helps merchants:
 * - Comply with financial regulations (KYC/AML/CFT)
 * - Prevent money laundering and terrorist financing
 * - Identify high-risk transactions or addresses
 * - Maintain audit trails for regulatory reporting
 *
 * Risk scoring system:
 * - Score range: 0.0 to 10.0
 * - 0.0-2.0: Low risk (normal transactions)
 * - 2.1-5.0: Medium risk (requires monitoring)
 * - 5.1-7.0: High risk (additional verification needed)
 * - 7.1-10.0: Very high risk (likely blocked or reported)
 *
 * Rule-based detection:
 * The system checks against multiple AML rules including:
 * - Sanctioned addresses or entities
 * - High-value transaction patterns
 * - Suspicious geographic locations
 * - Known fraud indicators
 * - Rapid fund movement patterns
 * - Connections to risky addresses
 *
 * Use cases:
 * - Transaction risk assessment before processing
 * - Address verification for withdrawals
 * - Customer due diligence (CDD/EDD)
 * - Regulatory reporting and compliance
 * - Fraud prevention and detection
 */
public class AmlInfo {
    /**
     * AML risk score ranging from 0.0 (lowest risk) to 10.0 (highest risk).
     *
     * This score is calculated based on various risk factors including:
     * - Transaction amount and frequency
     * - Geographic risk factors
     * - Address reputation and history
     * - Connection to known risky entities
     * - Behavioral patterns
     *
     * Score interpretation:
     * - 0.0-2.0: Low risk - transaction can proceed normally
     * - 2.1-5.0: Medium risk - monitor but allow
     * - 5.1-7.0: High risk - require additional verification
     * - 7.1-10.0: Very high risk - likely blocked or flagged for review
     */
    @SerializedName("score")
    private Double score;

    /**
     * List of AML rule names that were triggered during screening.
     *
     * Each rule name identifies a specific risk indicator or compliance check that was matched.
     * Common rule names include:
     * - "sanctioned_address" - Address appears on sanctions lists
     * - "high_value_transaction" - Transaction exceeds risk thresholds
     * - "suspicious_geography" - Transaction involves high-risk jurisdictions
     * - "rapid_movement" - Funds moved quickly through multiple addresses
     * - "mixer_service" - Connection to cryptocurrency mixing services
     * - "dark_web" - Association with dark web marketplaces
     * - "ransomware" - Connection to known ransomware addresses
     *
     * Multiple rules can be triggered simultaneously, and the combination
     * contributes to the overall risk score.
     */
    @SerializedName("rule_names")
    private List<String> ruleNames;

    /**
     * Constructs a new empty AmlInfo object.
     */
    public AmlInfo() {
    }

    // Getters and Setters

    /**
     * Gets the AML risk score.
     * @return Risk score from 0.0 (lowest) to 10.0 (highest)
     */
    public Double getScore() {
        return score;
    }

    /**
     * Sets the AML risk score.
     * @param score Risk score from 0.0 (lowest) to 10.0 (highest)
     */
    public void setScore(Double score) {
        this.score = score;
    }

    /**
     * Gets the list of triggered AML rule names.
     * @return List of rule identifiers that were matched
     */
    public List<String> getRuleNames() {
        return ruleNames;
    }

    /**
     * Sets the list of triggered AML rule names.
     * @param ruleNames List of rule identifiers that were matched
     */
    public void setRuleNames(List<String> ruleNames) {
        this.ruleNames = ruleNames;
    }
}
