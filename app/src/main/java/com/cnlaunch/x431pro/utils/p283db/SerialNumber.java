package com.cnlaunch.x431pro.utils.p283db;

/* renamed from: com.cnlaunch.x431pro.utils.db.c */
/* loaded from: classes.dex */
public class SerialNumber {

    /* renamed from: a */
    public Long f15831a;

    /* renamed from: b */
    public Boolean f15832b;

    /* renamed from: c */
    public Boolean f15833c;

    /* renamed from: d */
    public String f15834d;

    /* renamed from: e */
    public String f15835e;

    /* renamed from: f */
    public String f15836f;

    /* renamed from: g */
    public String f15837g;

    public SerialNumber() {
    }

    public SerialNumber(Long l, Boolean bool, Boolean bool2, String str, String str2, String str3, String str4) {
        this.f15831a = l;
        this.f15832b = bool;
        this.f15833c = bool2;
        this.f15834d = str;
        this.f15835e = str2;
        this.f15836f = str3;
        this.f15837g = str4;
    }

    public String toString() {
        return "SerialNumber{id=" + this.f15831a + ", isMine=" + this.f15832b + ", isDefault=" + this.f15833c + ", serialNo='" + this.f15834d + "', cc='" + this.f15835e + "', vciCategory='" + this.f15836f + "', state='" + this.f15837g + "'}";
    }
}
