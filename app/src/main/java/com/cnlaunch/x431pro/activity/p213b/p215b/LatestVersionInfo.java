package com.cnlaunch.x431pro.activity.p213b.p215b;

import com.cnlaunch.x431pro.module.p241a.BaseResponse;

/* renamed from: com.cnlaunch.x431pro.activity.b.b.f */
/* loaded from: classes.dex */
public class LatestVersionInfo extends BaseResponse {
    private static final long serialVersionUID = 1;
    private VersionInfo data;

    public VersionInfo getData() {
        return this.data;
    }

    public void setData(VersionInfo versionInfo) {
        this.data = versionInfo;
    }

    @Override // com.cnlaunch.x431pro.module.p241a.BaseResponse
    public String toString() {
        return "LatestVersionInfo [data=" + this.data + "]";
    }
}
