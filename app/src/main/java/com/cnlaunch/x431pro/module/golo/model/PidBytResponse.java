package com.cnlaunch.x431pro.module.golo.model;

import com.cnlaunch.x431pro.module.p241a.BaseResponse;

/* renamed from: com.cnlaunch.x431pro.module.golo.model.p */
/* loaded from: classes.dex */
public class PidBytResponse extends BaseResponse {
    private static final long serialVersionUID = -5009241405679350180L;
    private PidBytData data;

    public PidBytData getData() {
        return this.data;
    }

    public void setData(PidBytData pidBytData) {
        this.data = pidBytData;
    }

    @Override // com.cnlaunch.x431pro.module.p241a.BaseResponse
    public String toString() {
        return "PidBytResponse [data=" + this.data + "]";
    }
}
