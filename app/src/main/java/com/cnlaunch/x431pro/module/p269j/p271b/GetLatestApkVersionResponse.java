package com.cnlaunch.x431pro.module.p269j.p271b;

import com.cnlaunch.x431pro.module.p241a.BaseResponse;

/* renamed from: com.cnlaunch.x431pro.module.j.b.d */
/* loaded from: classes.dex */
public class GetLatestApkVersionResponse extends BaseResponse {
    private static final long serialVersionUID = -5394747854907447074L;
    private LatestApkVersionInfo appSoftSoftMaxVersion;

    public LatestApkVersionInfo getAppSoftSoftMaxVersion() {
        return this.appSoftSoftMaxVersion;
    }

    public void setAppSoftSoftMaxVersion(LatestApkVersionInfo latestApkVersionInfo) {
        this.appSoftSoftMaxVersion = latestApkVersionInfo;
    }

    @Override // com.cnlaunch.x431pro.module.p241a.BaseResponse
    public String toString() {
        return "GetLatestApkVersionResponse{appSoftSoftMaxVersion=" + this.appSoftSoftMaxVersion + '}';
    }
}
