package com.cnlaunch.x431pro.module.p258f.p260b;

/* renamed from: com.cnlaunch.x431pro.module.f.b.g */
/* loaded from: classes.dex */
public class CyOrderListResponse extends CyBaseResponse {
    CyOrderListResult cyOrderInfoListResult;

    public CyOrderListResult getCyOrderInfoListResult() {
        return this.cyOrderInfoListResult;
    }

    public void setCyOrderInfoListResult(CyOrderListResult cyOrderListResult) {
        this.cyOrderInfoListResult = cyOrderListResult;
    }

    @Override // com.cnlaunch.x431pro.module.p258f.p260b.CyBaseResponse
    public String toString() {
        return "CyOrderListResponse{cyOrderInfoListResult=" + this.cyOrderInfoListResult + '}';
    }
}
