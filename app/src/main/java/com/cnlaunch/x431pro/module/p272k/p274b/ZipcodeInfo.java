package com.cnlaunch.x431pro.module.p272k.p274b;

import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;

/* renamed from: com.cnlaunch.x431pro.module.k.b.ab */
/* loaded from: classes.dex */
public final class ZipcodeInfo extends AbstractC2709c {
    private static final long serialVersionUID = 8731003770847062370L;
    private String city;
    private String country;
    private String province;
    private int user_id;
    private String zipcode;

    public final int getUser_id() {
        return this.user_id;
    }

    public final String getCountry() {
        return this.country;
    }

    public final void setCountry(String str) {
        this.country = str;
    }

    public final String getProvince() {
        return this.province;
    }

    public final void setProvince(String str) {
        this.province = str;
    }

    public final String getCity() {
        return this.city;
    }

    public final void setCity(String str) {
        this.city = str;
    }

    public final void setUser_id(int i) {
        this.user_id = i;
    }

    public final String getZipcode() {
        return this.zipcode;
    }

    public final void setZipcode(String str) {
        this.zipcode = str;
    }
}
