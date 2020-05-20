package com.cnlaunch.x431pro.module.p258f.p260b;

/* renamed from: com.cnlaunch.x431pro.module.f.b.l */
/* loaded from: classes.dex */
public class CyOrderTypeResponse extends CyBaseResponse {
    CyOrderTypeResult cyOrderTypeResult;

    public CyOrderTypeResult getCyOrderTypeResult() {
        return this.cyOrderTypeResult;
    }

    public void setCyOrderTypeResult(CyOrderTypeResult cyOrderTypeResult) {
        this.cyOrderTypeResult = cyOrderTypeResult;
    }

    @Override // com.cnlaunch.x431pro.module.p258f.p260b.CyBaseResponse
    public String toString() {
        return "CyOrderTypeResponse{cyOrderTypeResult=" + this.cyOrderTypeResult + '}';
    }
}
