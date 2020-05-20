package com.cnlaunch.x431pro.module.p252d.p254b;

import com.cnlaunch.x431pro.module.p241a.BaseResponse;

/* renamed from: com.cnlaunch.x431pro.module.d.b.p */
/* loaded from: classes.dex */
public class RemoteServiceInfoResponse extends BaseResponse {
    private static final long serialVersionUID = 823295161729937751L;
    private RemoteServiceInfoData data;

    public RemoteServiceInfoData getData() {
        return this.data;
    }

    public void setData(RemoteServiceInfoData remoteServiceInfoData) {
        this.data = remoteServiceInfoData;
    }
}
