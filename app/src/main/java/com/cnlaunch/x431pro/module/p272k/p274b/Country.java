package com.cnlaunch.x431pro.module.p272k.p274b;

import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;

/* renamed from: com.cnlaunch.x431pro.module.k.b.c */
/* loaded from: classes.dex */
public final class Country extends AbstractC2709c {
    private static final long serialVersionUID = 8173885715167729056L;
    private String display;
    private int is_sms;
    private String ncode;
    private int pre_code;

    public final String getNcode() {
        return this.ncode;
    }

    public final void setNcode(String str) {
        this.ncode = str;
    }

    public final String getDisplay() {
        return this.display;
    }

    public final void setDisplay(String str) {
        this.display = str;
    }

    public final int getIs_sms() {
        return this.is_sms;
    }

    public final void setIs_sms(int i) {
        this.is_sms = i;
    }

    public final int getPre_code() {
        return this.pre_code;
    }

    public final void setPre_code(int i) {
        this.pre_code = i;
    }

    public final String toString() {
        return "Country [ncode=" + this.ncode + ", display=" + this.display + ", is_sms=" + this.is_sms + ", pre_code=" + this.pre_code + "]";
    }
}
