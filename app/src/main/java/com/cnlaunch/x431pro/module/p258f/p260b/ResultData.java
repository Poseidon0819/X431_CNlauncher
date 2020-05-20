package com.cnlaunch.x431pro.module.p258f.p260b;

import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;
import org.codehaus.jackson.annotate.JsonProperty;

/* renamed from: com.cnlaunch.x431pro.module.f.b.s */
/* loaded from: classes.dex */
public final class ResultData extends AbstractC2709c {
    @JsonProperty("codeUrl")
    private String codeUrl;
    @JsonProperty("outTradeNo")
    private String outTradeNo;
    private double price;

    public final String getCodeUrl() {
        return this.codeUrl;
    }

    public final void setCodeUrl(String str) {
        this.codeUrl = str;
    }

    public final String getOutTradeNo() {
        return this.outTradeNo;
    }

    public final void setOutTradeNo(String str) {
        this.outTradeNo = str;
    }

    public final double getPrice() {
        return this.price;
    }

    public final void setPrice(double d) {
        this.price = d;
    }

    public final String toString() {
        return "ResultData{codeUrl='" + this.codeUrl + "', outTradeNo='" + this.outTradeNo + "', price=" + this.price + '}';
    }
}
