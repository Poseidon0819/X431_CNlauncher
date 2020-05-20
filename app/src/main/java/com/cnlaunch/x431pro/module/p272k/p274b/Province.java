package com.cnlaunch.x431pro.module.p272k.p274b;

import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;

/* renamed from: com.cnlaunch.x431pro.module.k.b.j */
/* loaded from: classes.dex */
public final class Province extends AbstractC2709c {
    private static final long serialVersionUID = 5200559937107324792L;
    private String display;
    private String pcode;

    public final String getPcode() {
        return this.pcode;
    }

    public final void setPcode(String str) {
        this.pcode = str;
    }

    public final String getDisplay() {
        return this.display;
    }

    public final void setDisplay(String str) {
        this.display = str;
    }

    public final String toString() {
        return "Province [pcode=" + this.pcode + ", display=" + this.display + "]";
    }
}
