package com.cnlaunch.x431pro.module.p258f.p260b;

/* renamed from: com.cnlaunch.x431pro.module.f.b.e */
/* loaded from: classes.dex */
public class CyOrderInfoResponse extends CyBaseResponse {
    CyOrderInfoResult cyOrderInfoResult;

    public CyOrderInfoResult getCyOrderInfoResult() {
        return this.cyOrderInfoResult;
    }

    public void setCyOrderInfoResult(CyOrderInfoResult cyOrderInfoResult) {
        this.cyOrderInfoResult = cyOrderInfoResult;
    }

    @Override // com.cnlaunch.x431pro.module.p258f.p260b.CyBaseResponse
    public String toString() {
        return "CyOrderInfoResponse{cyOrderInfoResult=" + this.cyOrderInfoResult + '}';
    }
}
