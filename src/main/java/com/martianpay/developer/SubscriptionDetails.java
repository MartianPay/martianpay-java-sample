package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

public class SubscriptionDetails {
    @SerializedName("id")
    private String id;

    @SerializedName("merchant_id")
    private String merchantId;

    @SerializedName("customer_id")
    private String customerId;

    @SerializedName("selling_plan_id")
    private String sellingPlanId;

    @SerializedName("product_id")
    private String productId;

    @SerializedName("variant_id")
    private String variantId;

    @SerializedName("status")
    private String status;

    @SerializedName("collection_method")
    private String collectionMethod;

    @SerializedName("billing_cycle_anchor")
    private Long billingCycleAnchor;

    @SerializedName("current_period_start")
    private Long currentPeriodStart;

    @SerializedName("current_period_end")
    private Long currentPeriodEnd;

    @SerializedName("trial_start")
    private Long trialStart;

    @SerializedName("trial_end")
    private Long trialEnd;

    @SerializedName("canceled_at")
    private Long canceledAt;

    @SerializedName("cancel_at_period_end")
    private Boolean cancelAtPeriodEnd;

    @SerializedName("cancel_reason")
    private String cancelReason;

    @SerializedName("pause_collection_behavior")
    private String pauseCollectionBehavior;

    @SerializedName("paused_at")
    private Long pausedAt;

    @SerializedName("resumes_at")
    private Long resumesAt;

    @SerializedName("latest_invoice_id")
    private String latestInvoiceId;

    @SerializedName("default_payment_method_id")
    private String defaultPaymentMethodId;

    @SerializedName("default_provider_type")
    private String defaultProviderType;

    @SerializedName("default_payment_method_type")
    private String defaultPaymentMethodType;

    @SerializedName("metadata")
    private Map<String, Object> metadata;

    @SerializedName("external_id")
    private String externalId;

    @SerializedName("created_at")
    private Long createdAt;

    @SerializedName("updated_at")
    private Long updatedAt;

    @SerializedName("payment_required")
    private Boolean paymentRequired;

    @SerializedName("payment_url")
    private String paymentUrl;

    @SerializedName("payment_expires_at")
    private Long paymentExpiresAt;

    @SerializedName("hours_since_creation")
    private Double hoursSinceCreation;

    @SerializedName("current_cycle_number")
    private Integer currentCycleNumber;

    @SerializedName("current_pricing_tier")
    private SubscriptionCurrentPricingTier currentPricingTier;

    @SerializedName("upcoming_pricing_tier")
    private SubscriptionCurrentPricingTier upcomingPricingTier;

    @SerializedName("next_charge_amount")
    private String nextChargeAmount;

    @SerializedName("next_charge_amount_display")
    private String nextChargeAmountDisplay;

    @SerializedName("selling_plan_pricing")
    private SellingPlanPricing sellingPlanPricing;

    @SerializedName("merchant_name")
    private String merchantName;

    @SerializedName("customer_email")
    private String customerEmail;

    @SerializedName("customer_name")
    private String customerName;

    @SerializedName("product_name")
    private String productName;

    @SerializedName("product_description")
    private String productDescription;

    @SerializedName("product_image_url")
    private String productImageUrl;

    @SerializedName("variant_title")
    private String variantTitle;

    @SerializedName("variant_option_values")
    private Map<String, String> variantOptionValues;

    @SerializedName("variant_price")
    private String variantPrice;

    @SerializedName("selling_plan_name")
    private String sellingPlanName;

    @SerializedName("selling_plan_description")
    private String sellingPlanDescription;

    @SerializedName("payment_method_brand")
    private String paymentMethodBrand;

    @SerializedName("payment_method_last4")
    private String paymentMethodLast4;

    public SubscriptionDetails() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getSellingPlanId() {
        return sellingPlanId;
    }

    public void setSellingPlanId(String sellingPlanId) {
        this.sellingPlanId = sellingPlanId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getVariantId() {
        return variantId;
    }

    public void setVariantId(String variantId) {
        this.variantId = variantId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCollectionMethod() {
        return collectionMethod;
    }

    public void setCollectionMethod(String collectionMethod) {
        this.collectionMethod = collectionMethod;
    }

    public Long getBillingCycleAnchor() {
        return billingCycleAnchor;
    }

    public void setBillingCycleAnchor(Long billingCycleAnchor) {
        this.billingCycleAnchor = billingCycleAnchor;
    }

    public Long getCurrentPeriodStart() {
        return currentPeriodStart;
    }

    public void setCurrentPeriodStart(Long currentPeriodStart) {
        this.currentPeriodStart = currentPeriodStart;
    }

    public Long getCurrentPeriodEnd() {
        return currentPeriodEnd;
    }

    public void setCurrentPeriodEnd(Long currentPeriodEnd) {
        this.currentPeriodEnd = currentPeriodEnd;
    }

    public Long getTrialStart() {
        return trialStart;
    }

    public void setTrialStart(Long trialStart) {
        this.trialStart = trialStart;
    }

    public Long getTrialEnd() {
        return trialEnd;
    }

    public void setTrialEnd(Long trialEnd) {
        this.trialEnd = trialEnd;
    }

    public Long getCanceledAt() {
        return canceledAt;
    }

    public void setCanceledAt(Long canceledAt) {
        this.canceledAt = canceledAt;
    }

    public Boolean getCancelAtPeriodEnd() {
        return cancelAtPeriodEnd;
    }

    public void setCancelAtPeriodEnd(Boolean cancelAtPeriodEnd) {
        this.cancelAtPeriodEnd = cancelAtPeriodEnd;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public String getPauseCollectionBehavior() {
        return pauseCollectionBehavior;
    }

    public void setPauseCollectionBehavior(String pauseCollectionBehavior) {
        this.pauseCollectionBehavior = pauseCollectionBehavior;
    }

    public Long getPausedAt() {
        return pausedAt;
    }

    public void setPausedAt(Long pausedAt) {
        this.pausedAt = pausedAt;
    }

    public Long getResumesAt() {
        return resumesAt;
    }

    public void setResumesAt(Long resumesAt) {
        this.resumesAt = resumesAt;
    }

    public String getLatestInvoiceId() {
        return latestInvoiceId;
    }

    public void setLatestInvoiceId(String latestInvoiceId) {
        this.latestInvoiceId = latestInvoiceId;
    }

    public String getDefaultPaymentMethodId() {
        return defaultPaymentMethodId;
    }

    public void setDefaultPaymentMethodId(String defaultPaymentMethodId) {
        this.defaultPaymentMethodId = defaultPaymentMethodId;
    }

    public String getDefaultProviderType() {
        return defaultProviderType;
    }

    public void setDefaultProviderType(String defaultProviderType) {
        this.defaultProviderType = defaultProviderType;
    }

    public String getDefaultPaymentMethodType() {
        return defaultPaymentMethodType;
    }

    public void setDefaultPaymentMethodType(String defaultPaymentMethodType) {
        this.defaultPaymentMethodType = defaultPaymentMethodType;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
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

    public Boolean getPaymentRequired() {
        return paymentRequired;
    }

    public void setPaymentRequired(Boolean paymentRequired) {
        this.paymentRequired = paymentRequired;
    }

    public String getPaymentUrl() {
        return paymentUrl;
    }

    public void setPaymentUrl(String paymentUrl) {
        this.paymentUrl = paymentUrl;
    }

    public Long getPaymentExpiresAt() {
        return paymentExpiresAt;
    }

    public void setPaymentExpiresAt(Long paymentExpiresAt) {
        this.paymentExpiresAt = paymentExpiresAt;
    }

    public Double getHoursSinceCreation() {
        return hoursSinceCreation;
    }

    public void setHoursSinceCreation(Double hoursSinceCreation) {
        this.hoursSinceCreation = hoursSinceCreation;
    }

    public Integer getCurrentCycleNumber() {
        return currentCycleNumber;
    }

    public void setCurrentCycleNumber(Integer currentCycleNumber) {
        this.currentCycleNumber = currentCycleNumber;
    }

    public SubscriptionCurrentPricingTier getCurrentPricingTier() {
        return currentPricingTier;
    }

    public void setCurrentPricingTier(SubscriptionCurrentPricingTier currentPricingTier) {
        this.currentPricingTier = currentPricingTier;
    }

    public SubscriptionCurrentPricingTier getUpcomingPricingTier() {
        return upcomingPricingTier;
    }

    public void setUpcomingPricingTier(SubscriptionCurrentPricingTier upcomingPricingTier) {
        this.upcomingPricingTier = upcomingPricingTier;
    }

    public String getNextChargeAmount() {
        return nextChargeAmount;
    }

    public void setNextChargeAmount(String nextChargeAmount) {
        this.nextChargeAmount = nextChargeAmount;
    }

    public String getNextChargeAmountDisplay() {
        return nextChargeAmountDisplay;
    }

    public void setNextChargeAmountDisplay(String nextChargeAmountDisplay) {
        this.nextChargeAmountDisplay = nextChargeAmountDisplay;
    }

    public SellingPlanPricing getSellingPlanPricing() {
        return sellingPlanPricing;
    }

    public void setSellingPlanPricing(SellingPlanPricing sellingPlanPricing) {
        this.sellingPlanPricing = sellingPlanPricing;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductImageUrl() {
        return productImageUrl;
    }

    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }

    public String getVariantTitle() {
        return variantTitle;
    }

    public void setVariantTitle(String variantTitle) {
        this.variantTitle = variantTitle;
    }

    public Map<String, String> getVariantOptionValues() {
        return variantOptionValues;
    }

    public void setVariantOptionValues(Map<String, String> variantOptionValues) {
        this.variantOptionValues = variantOptionValues;
    }

    public String getVariantPrice() {
        return variantPrice;
    }

    public void setVariantPrice(String variantPrice) {
        this.variantPrice = variantPrice;
    }

    public String getSellingPlanName() {
        return sellingPlanName;
    }

    public void setSellingPlanName(String sellingPlanName) {
        this.sellingPlanName = sellingPlanName;
    }

    public String getSellingPlanDescription() {
        return sellingPlanDescription;
    }

    public void setSellingPlanDescription(String sellingPlanDescription) {
        this.sellingPlanDescription = sellingPlanDescription;
    }

    public String getPaymentMethodBrand() {
        return paymentMethodBrand;
    }

    public void setPaymentMethodBrand(String paymentMethodBrand) {
        this.paymentMethodBrand = paymentMethodBrand;
    }

    public String getPaymentMethodLast4() {
        return paymentMethodLast4;
    }

    public void setPaymentMethodLast4(String paymentMethodLast4) {
        this.paymentMethodLast4 = paymentMethodLast4;
    }
}
