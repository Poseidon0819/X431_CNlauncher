package com.cnlaunch.x431pro.module.p258f.p260b;

import com.cnlaunch.x431pro.module.p241a.BaseResponse;

/* renamed from: com.cnlaunch.x431pro.module.f.b.b */
/* loaded from: classes.dex */
public class ConfigPriceResponse extends BaseResponse {
    private String currencyName;
    private double price;
    private int softConfId;
    private String softConfName;

    public int getSoftConfId() {
        return this.softConfId;
    }

    public void setSoftConfId(int i) {
        this.softConfId = i;
    }

    public String getSoftConfName() {
        return this.softConfName;
    }

    public void setSoftConfName(String str) {
        this.softConfName = str;
    }

    public String getCurrencyName() {
        return this.currencyName;
    }

    public void setCurrencyName(String str) {
        this.currencyName = str;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double d) {
        this.price = d;
    }

    @Override // com.cnlaunch.x431pro.module.p241a.BaseResponse
    public String toString() {
        return "ConfigPriceResponse{softConfId=" + this.softConfId + ", softConfName='" + this.softConfName + "', currencyName='" + this.currencyName + "', price=" + this.price + '}';
    }
}
