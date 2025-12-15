package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * AmlInfo contains Anti-Money Laundering (AML) screening information
 */
public class AmlInfo {
    /**
     * Score is the AML risk score from 0-10 (10 is the highest risk)
     */
    @SerializedName("score")
    private Double score;

    /**
     * RuleNames contains the list of AML rules that were triggered
     */
    @SerializedName("rule_names")
    private List<String> ruleNames;

    public AmlInfo() {
    }

    // Getters and Setters
    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public List<String> getRuleNames() {
        return ruleNames;
    }

    public void setRuleNames(List<String> ruleNames) {
        this.ruleNames = ruleNames;
    }
}
