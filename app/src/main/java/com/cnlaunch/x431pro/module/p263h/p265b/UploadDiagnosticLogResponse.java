package com.cnlaunch.x431pro.module.p263h.p265b;

import com.cnlaunch.x431pro.module.p241a.BaseResponse;

/* renamed from: com.cnlaunch.x431pro.module.h.b.j */
/* loaded from: classes.dex */
public class UploadDiagnosticLogResponse extends BaseResponse {
    private static final long serialVersionUID = 249437280147693640L;
    private Object data;
    private String extraOriginalfullFilenamePath;
    private String extraZipfullFilenamePath;

    /* renamed from: message  reason: collision with root package name */
    private String f24485message;

    public String getExtraOriginalfullFilenamePath() {
        return this.extraOriginalfullFilenamePath;
    }

    public void setExtraOriginalfullFilenamePath(String str) {
        this.extraOriginalfullFilenamePath = str;
    }

    public String getExtraZipfullFilenamePath() {
        return this.extraZipfullFilenamePath;
    }

    public void setExtraZipfullFilenamePath(String str) {
        this.extraZipfullFilenamePath = str;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object obj) {
        this.data = obj;
    }

    @Override // com.cnlaunch.x431pro.module.p241a.BaseResponse
    public String toString() {
        return "UploadDiagnosticLogResponse [data=" + this.data + ", message=" + this.f24485message + ", getData()=" + getData() + ", getMessage()=" + getMessage() + ", getCode()=" + getCode() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
    }
}
