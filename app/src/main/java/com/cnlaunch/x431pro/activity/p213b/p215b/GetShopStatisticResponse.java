package com.cnlaunch.x431pro.activity.p213b.p215b;

import com.cnlaunch.x431pro.module.p241a.BaseResponse;

/* renamed from: com.cnlaunch.x431pro.activity.b.b.e */
/* loaded from: classes.dex */
public class GetShopStatisticResponse extends BaseResponse {
    private static final long serialVersionUID = 1;
    private int data;

    public int getData() {
        return this.data;
    }

    public void setData(int i) {
        this.data = i;
    }

    @Override // com.cnlaunch.x431pro.module.p241a.BaseResponse
    public String toString() {
        return "getShopStatisticResponse [data=" + this.data + "]";
    }
}
