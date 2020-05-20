package com.cnlaunch.x431pro.activity.p213b.p215b;

import com.cnlaunch.x431pro.module.p241a.BaseResponse;

/* renamed from: com.cnlaunch.x431pro.activity.b.b.g */
/* loaded from: classes.dex */
public final class VersionInfo extends BaseResponse {
    private static final long serialVersionUID = 1;
    private String remark;
    private String url;
    private String vision_no;

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final String getVision_no() {
        return this.vision_no;
    }

    public final void setVision_no(String str) {
        this.vision_no = str;
    }

    public final String getRemark() {
        return this.remark;
    }

    public final void setRemark(String str) {
        this.remark = str;
    }

    @Override // com.cnlaunch.x431pro.module.p241a.BaseResponse
    public final String toString() {
        return "VersionInfo [url=" + this.url + ", vision_no=" + this.vision_no + ", remark=" + this.remark + "]";
    }
}
