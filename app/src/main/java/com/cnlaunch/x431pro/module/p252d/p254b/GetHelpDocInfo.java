package com.cnlaunch.x431pro.module.p252d.p254b;

import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;

/* renamed from: com.cnlaunch.x431pro.module.d.b.e */
/* loaded from: classes.dex */
public final class GetHelpDocInfo extends AbstractC2709c {
    private static final long serialVersionUID = 1;
    private String code;
    private String msg;
    private String url;

    public final String getCode() {
        return this.code;
    }

    public final void setCode(String str) {
        this.code = str;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final void setMsg(String str) {
        this.msg = str;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final String toString() {
        return "GetHelpDocInfo [url=" + this.url + ", code=" + this.code + ", msg=" + this.msg + "]";
    }
}
