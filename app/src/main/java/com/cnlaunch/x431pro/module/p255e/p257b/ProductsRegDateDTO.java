package com.cnlaunch.x431pro.module.p255e.p257b;

import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;

/* renamed from: com.cnlaunch.x431pro.module.e.b.f */
/* loaded from: classes.dex */
public final class ProductsRegDateDTO extends AbstractC2709c {
    private static final long serialVersionUID = 3915347426207964865L;
    private String regDate;
    private String serialNo;
    private String snState;

    public final String getSerialNo() {
        return this.serialNo;
    }

    public final void setSerialNo(String str) {
        this.serialNo = str;
    }

    public final String getSnState() {
        return this.snState;
    }

    public final void setSnState(String str) {
        this.snState = str;
    }

    public final String getRegDate() {
        return this.regDate;
    }

    public final void setRegDate(String str) {
        this.regDate = str;
    }

    public final String toString() {
        return "ProductsRegDateDTO [serialNo=" + this.serialNo + ", snState=" + this.snState + ", regDate=" + this.regDate + "]";
    }
}
