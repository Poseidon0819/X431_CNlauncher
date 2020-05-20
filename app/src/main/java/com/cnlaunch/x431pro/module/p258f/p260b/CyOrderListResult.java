package com.cnlaunch.x431pro.module.p258f.p260b;

import java.util.List;

/* renamed from: com.cnlaunch.x431pro.module.f.b.h */
/* loaded from: classes.dex */
public final class CyOrderListResult extends CyResultBase {
    private List<CyOrderInfo> cyOrderInfoList;

    public final List<CyOrderInfo> getCyOrderInfoList() {
        return this.cyOrderInfoList;
    }

    public final void setCyOrderInfoList(List<CyOrderInfo> list) {
        this.cyOrderInfoList = list;
    }

    public final String toString() {
        return "CyOrderListResult{cyOrderInfoList=" + this.cyOrderInfoList + '}';
    }
}
