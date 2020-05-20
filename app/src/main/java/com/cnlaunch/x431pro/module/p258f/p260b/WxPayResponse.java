package com.cnlaunch.x431pro.module.p258f.p260b;

/* renamed from: com.cnlaunch.x431pro.module.f.b.y */
/* loaded from: classes.dex */
public class WxPayResponse extends CyBaseResponse {
    WxPayResult wxPayResult;

    public WxPayResult getWxPayResult() {
        return this.wxPayResult;
    }

    public void setWxPayResult(WxPayResult wxPayResult) {
        this.wxPayResult = wxPayResult;
    }

    @Override // com.cnlaunch.x431pro.module.p258f.p260b.CyBaseResponse
    public String toString() {
        return "WxPayResponse{wxPayResult=" + this.wxPayResult + '}';
    }
}
