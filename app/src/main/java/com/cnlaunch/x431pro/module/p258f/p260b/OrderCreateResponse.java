package com.cnlaunch.x431pro.module.p258f.p260b;

import com.cnlaunch.x431pro.module.p241a.BaseResponse;
import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;

/* renamed from: com.cnlaunch.x431pro.module.f.b.q */
/* loaded from: classes.dex */
public class OrderCreateResponse extends BaseResponse {
    @JsonProperty("currencyId")
    private int currencyid;
    @JsonProperty("currencyName")
    private String currencyname;
    @JsonProperty("orderCreateTime")
    private String ordercreatetime;
    @JsonProperty("orderId")
    private int orderid;
    @JsonProperty("orderInfoList")
    private List<Object> orderinfolist;
    @JsonProperty("orderSn")
    private String ordersn;
    @JsonProperty("totalPrice")
    private double totalprice;

    public String getOrdercreatetime() {
        return this.ordercreatetime;
    }

    public void setOrdercreatetime(String str) {
        this.ordercreatetime = str;
    }

    public int getOrderid() {
        return this.orderid;
    }

    public void setOrderid(int i) {
        this.orderid = i;
    }

    public int getCurrencyid() {
        return this.currencyid;
    }

    public void setCurrencyid(int i) {
        this.currencyid = i;
    }

    public String getCurrencyname() {
        return this.currencyname;
    }

    public void setCurrencyname(String str) {
        this.currencyname = str;
    }

    public String getOrdersn() {
        return this.ordersn;
    }

    public void setOrdersn(String str) {
        this.ordersn = str;
    }

    public double getTotalprice() {
        return this.totalprice;
    }

    public void setTotalprice(double d) {
        this.totalprice = d;
    }

    public List<Object> getOrderinfolist() {
        return this.orderinfolist;
    }

    public void setOrderinfolist(List<Object> list) {
        this.orderinfolist = list;
    }
}
