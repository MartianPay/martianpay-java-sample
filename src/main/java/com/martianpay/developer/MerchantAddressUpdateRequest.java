package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Request to update properties of an existing merchant address.
 * Currently supports updating the alias (friendly name).
 */
public class MerchantAddressUpdateRequest {
    /**
     * Friendly name or label for the address.
     */
    @SerializedName("alias")
    private String alias;

    /**
     * Gets the address alias.
     * @return The friendly name for the address, or null if not set
     */
    public String getAlias() { return alias; }

    /**
     * Sets the address alias.
     * @param alias The friendly name for the address
     */
    public void setAlias(String alias) { this.alias = alias; }
}
