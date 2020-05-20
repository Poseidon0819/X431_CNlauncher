package com.cnlaunch.x431pro.module.cloud.model;

import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;

/* renamed from: com.cnlaunch.x431pro.module.cloud.model.c */
/* loaded from: classes.dex */
public class CloudBaseResponse extends AbstractC2709c {
    private int code;
    private String msg;

    public int getCode() {
        return this.code;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String str) {
        this.msg = str;
    }
}
