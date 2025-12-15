package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class PayoutCreateResp extends Payout {
    @SerializedName("withdraw")
    private Withdraw withdraw;

    @SerializedName("swap_items")
    private List<PayoutSwapItem> swapItems;

    public PayoutCreateResp() {
    }

    public Withdraw getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(Withdraw withdraw) {
        this.withdraw = withdraw;
    }

    public List<PayoutSwapItem> getSwapItems() {
        return swapItems;
    }

    public void setSwapItems(List<PayoutSwapItem> swapItems) {
        this.swapItems = swapItems;
    }
}
