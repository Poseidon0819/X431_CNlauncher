package com.cnlaunch.x431pro.module.p272k.p274b;

import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;

/* renamed from: com.cnlaunch.x431pro.module.k.b.a */
/* loaded from: classes.dex */
public final class City extends AbstractC2709c {
    private static final long serialVersionUID = -3317250513605695444L;
    private String ccode;
    private String display;

    public final String getCcode() {
        return this.ccode;
    }

    public final void setCcode(String str) {
        this.ccode = str;
    }

    public final String getDisplay() {
        return this.display;
    }

    public final void setDisplay(String str) {
        this.display = str;
    }

    public final String toString() {
        return "City [ccode=" + this.ccode + ", display=" + this.display + "]";
    }
}
