package com.cnlaunch.x431pro.module.p263h.p265b;

import com.cnlaunch.x431pro.module.p241a.BaseResponse;

/* renamed from: com.cnlaunch.x431pro.module.h.b.k */
/* loaded from: classes.dex */
public class UploadServerCheckLogResponse extends BaseResponse {
    private static final long serialVersionUID = -6811013980069644970L;
    private Object data;

    /* renamed from: message  reason: collision with root package name */
    private String f24486message;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object obj) {
        this.data = obj;
    }

    @Override // com.cnlaunch.x431pro.module.p241a.BaseResponse
    public String getMessage() {
        return this.f24486message;
    }

    @Override // com.cnlaunch.x431pro.module.p241a.BaseResponse
    public void setMessage(String str) {
        this.f24486message = str;
    }

    @Override // com.cnlaunch.x431pro.module.p241a.BaseResponse
    public String toString() {
        return "SendServerCheckLogResponse [data=" + this.data + ", message=" + this.f24486message + "]";
    }
}
