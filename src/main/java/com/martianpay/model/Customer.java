package com.martianpay.model;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

/**
 * Customer represents a MartianPay customer
 */
public class Customer {
    @SerializedName("id")
    private String id;

    @SerializedName("object")
    private String object;

    @SerializedName("total_expense")
    private Long totalExpense;

    @SerializedName("total_payment")
    private Long totalPayment;

    @SerializedName("total_refund")
    private Long totalRefund;

    @SerializedName("currency")
    private String currency;

    @SerializedName("created")
    private Long created;

    @SerializedName("name")
    private String name;

    @SerializedName("email")
    private String email;

    @SerializedName("description")
    private String description;

    @SerializedName("metadata")
    private Map<String, String> metadata;

    @SerializedName("phone")
    private String phone;

    public Customer() {
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public Long getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(Long totalExpense) {
        this.totalExpense = totalExpense;
    }

    public Long getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(Long totalPayment) {
        this.totalPayment = totalPayment;
    }

    public Long getTotalRefund() {
        return totalRefund;
    }

    public void setTotalRefund(Long totalRefund) {
        this.totalRefund = totalRefund;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }
}
