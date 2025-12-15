package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class StatsBalanceFlowListResp {
    @SerializedName("balance_flows")
    private List<MerchantBalanceFlow> balanceFlows;

    @SerializedName("page")
    private Integer page;

    @SerializedName("page_size")
    private Integer pageSize;

    @SerializedName("total")
    private Integer total;

    public StatsBalanceFlowListResp() {
    }

    public List<MerchantBalanceFlow> getBalanceFlows() {
        return balanceFlows;
    }

    public void setBalanceFlows(List<MerchantBalanceFlow> balanceFlows) {
        this.balanceFlows = balanceFlows;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
