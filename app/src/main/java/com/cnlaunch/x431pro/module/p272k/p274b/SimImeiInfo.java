package com.cnlaunch.x431pro.module.p272k.p274b;

import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;

/* renamed from: com.cnlaunch.x431pro.module.k.b.q */
/* loaded from: classes.dex */
public final class SimImeiInfo extends AbstractC2709c {
    private int code;

    /* renamed from: message  reason: collision with root package name */
    private String f24487message;

    public final int getCode() {
        return this.code;
    }

    public final void setCode(int i) {
        this.code = i;
    }

    public final String getMessage() {
        return this.f24487message;
    }

    public final void setMessage(String str) {
        this.f24487message = str;
    }

    public final String toString() {
        return "SimImeiInfo{code=" + this.code + ", message='" + this.f24487message + "'}";
    }
}
