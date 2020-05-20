package com.cnlaunch.x431pro.module.p258f.p260b;

import com.cnlaunch.x431pro.utils.CardUtil;
import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonProperty;

/* renamed from: com.cnlaunch.x431pro.module.f.b.v */
/* loaded from: classes.dex */
public final class UserOrderDTO implements Serializable {
    @JsonProperty("currencyId")
    private int currencyid;
    @JsonProperty("googlePlayId")
    private String googleplayId;
    @JsonProperty("itunesid")
    private String itunesId;
    @JsonProperty("orderId")
    private int orderid;
    @JsonProperty("orderName")
    private String ordername;
    @JsonProperty("orderSN")
    private String ordersn;
    @JsonProperty("orderTime")
    private String ordertime;
    @JsonProperty("payTime")
    private String paytime;
    @JsonProperty("payType")
    private int paytype;
    @JsonProperty("serialNo")
    private String serialno;
    private int status;
    @JsonProperty("totalPrice")
    private double totalprice;

    public final int getOrderid() {
        return this.orderid;
    }

    public final void setOrderid(int i) {
        this.orderid = i;
    }

    public final String getOrdersn() {
        return this.ordersn;
    }

    public final void setOrdersn(String str) {
        this.ordersn = str;
    }

    public final String getOrdername() {
        return this.ordername;
    }

    public final void setOrdername(String str) {
        this.ordername = str;
    }

    public final String getSerialno() {
        return this.serialno;
    }

    public final void setSerialno(String str) {
        this.serialno = str;
    }

    public final double getTotalprice() {
        return this.totalprice;
    }

    public final void setTotalprice(double d) {
        this.totalprice = d;
    }

    public final int getCurrencyid() {
        return this.currencyid;
    }

    public final void setCurrencyid(int i) {
        this.currencyid = i;
    }

    public final int getStatus() {
        return this.status;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final int getPaytype() {
        return this.paytype;
    }

    public final void setPaytype(int i) {
        this.paytype = i;
    }

    public final String getOrdertime() {
        return CardUtil.m4921a(this.ordertime);
    }

    public final void setOrdertime(String str) {
        this.ordertime = str;
    }

    public final String getPaytime() {
        return CardUtil.m4921a(this.paytime);
    }

    public final void setPaytime(String str) {
        this.paytime = str;
    }

    public final String getGoogleplayId() {
        return this.googleplayId;
    }

    public final void setGoogleplayId(String str) {
        this.googleplayId = str;
    }

    public final String getItunesId() {
        return this.itunesId;
    }

    public final void setItunesId(String str) {
        this.itunesId = str;
    }
}
