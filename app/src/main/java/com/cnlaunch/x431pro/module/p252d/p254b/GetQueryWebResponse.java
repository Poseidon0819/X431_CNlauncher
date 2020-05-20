package com.cnlaunch.x431pro.module.p252d.p254b;

import com.cnlaunch.x431pro.module.p241a.BaseResponse;

/* renamed from: com.cnlaunch.x431pro.module.d.b.g */
/* loaded from: classes.dex */
public class GetQueryWebResponse extends BaseResponse {
    private static final long serialVersionUID = 1570309200167841855L;
    private String requestTime;
    private String responseTime;
    private String type;

    public String getRequestTime() {
        return this.requestTime;
    }

    public void setRequestTime(String str) {
        this.requestTime = str;
    }

    public String getResponseTime() {
        return this.responseTime;
    }

    public void setResponseTime(String str) {
        this.responseTime = str;
    }

    public String gettype() {
        return this.type;
    }

    public void settype(String str) {
        this.type = str;
    }

    @Override // com.cnlaunch.x431pro.module.p241a.BaseResponse
    public String toString() {
        return "GetQueryWebInfo [type=" + this.type + ", code=" + getCode() + ", message=" + getMessage() + "]";
    }
}
