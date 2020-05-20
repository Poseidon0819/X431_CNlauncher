package com.cnlaunch.x431pro.module.p258f.p260b;

/* renamed from: com.cnlaunch.x431pro.module.f.b.i */
/* loaded from: classes.dex */
public class CyOrderResponse extends CyBaseResponse {
    CyOrderResult cyOrderResult;

    public CyOrderResult getCyOrderResult() {
        return this.cyOrderResult;
    }

    public void setCyOrderResult(CyOrderResult cyOrderResult) {
        this.cyOrderResult = cyOrderResult;
    }

    @Override // com.cnlaunch.x431pro.module.p258f.p260b.CyBaseResponse
    public String toString() {
        return "CyOrderResponse{cyOrderResult=" + this.cyOrderResult + '}';
    }
}
