package com.cnlaunch.x431pro.module.p241a;

/* renamed from: com.cnlaunch.x431pro.module.a.e */
/* loaded from: classes.dex */
public class BaseResponse extends AbstractC2709c {
    public static final int ERROR_INVALID_TOKEN = -1;
    private static final long serialVersionUID = -8547901708373607611L;
    private int code;

    /* renamed from: message  reason: collision with root package name */
    private String f24483message;

    public int getCode() {
        return this.code;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public String getMessage() {
        return this.f24483message;
    }

    public void setMessage(String str) {
        this.f24483message = str;
    }

    public boolean isSuccess() {
        return this.code == 0;
    }

    public String toString() {
        return "BaseResponse [code=" + this.code + ", message=" + this.f24483message + "]";
    }
}
