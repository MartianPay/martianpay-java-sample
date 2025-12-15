package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.security.SecureRandom;

public class PayrollSwapItems {
    public static final String PAYROLL_SWAP_ITEM_ID_PREFIX = "payroll_swap_item_";
    public static final int PAYROLL_SWAP_ITEM_ID_LENGTH = 24;

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom RANDOM = new SecureRandom();

    @SerializedName("id")
    private String id;

    @SerializedName("payroll_id")
    private String payrollId;

    @SerializedName("from_coin")
    private String fromCoin;

    @SerializedName("to_coin")
    private String toCoin;

    @SerializedName("from_amount")
    private String fromAmount;

    @SerializedName("to_amount")
    private String toAmount;

    @SerializedName("exchange_rate")
    private String exchangeRate;

    @SerializedName("status")
    private String status;

    @SerializedName("created_at")
    private Long createdAt;

    @SerializedName("updated_at")
    private Long updatedAt;

    public PayrollSwapItems() {
    }

    public static String generatePayrollSwapItemId() {
        return PAYROLL_SWAP_ITEM_ID_PREFIX + generateRandomString(PAYROLL_SWAP_ITEM_ID_LENGTH);
    }

    private static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPayrollId() {
        return payrollId;
    }

    public void setPayrollId(String payrollId) {
        this.payrollId = payrollId;
    }

    public String getFromCoin() {
        return fromCoin;
    }

    public void setFromCoin(String fromCoin) {
        this.fromCoin = fromCoin;
    }

    public String getToCoin() {
        return toCoin;
    }

    public void setToCoin(String toCoin) {
        this.toCoin = toCoin;
    }

    public String getFromAmount() {
        return fromAmount;
    }

    public void setFromAmount(String fromAmount) {
        this.fromAmount = fromAmount;
    }

    public String getToAmount() {
        return toAmount;
    }

    public void setToAmount(String toAmount) {
        this.toAmount = toAmount;
    }

    public String getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(String exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }
}
