package com.cnlaunch.x431pro.utils.p283db;

/* renamed from: com.cnlaunch.x431pro.utils.db.b */
/* loaded from: classes.dex */
public class CarVersion {

    /* renamed from: a */
    Long f15825a;

    /* renamed from: b */
    public String f15826b;

    /* renamed from: c */
    public String f15827c;

    /* renamed from: d */
    public String f15828d;

    /* renamed from: e */
    public Boolean f15829e;

    /* renamed from: f */
    public String f15830f;

    public CarVersion() {
    }

    public CarVersion(Long l, String str, String str2, String str3, Boolean bool, String str4) {
        this.f15825a = l;
        this.f15826b = str;
        this.f15827c = str2;
        this.f15828d = str3;
        this.f15829e = bool;
        this.f15830f = str4;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof CarVersion) {
            CarVersion carVersion = (CarVersion) obj;
            if (carVersion.f15827c.equals(this.f15827c) && carVersion.f15826b.equals(this.f15826b) && carVersion.f15828d.equals(this.f15828d)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "CarVersion [id=" + this.f15825a + ", serialNo=" + this.f15826b + ", softPackageId=" + this.f15827c + ", versionNo=" + this.f15828d + ", languageList=" + this.f15830f + "]";
    }

    public int hashCode() {
        return this.f15827c.hashCode() + this.f15826b.hashCode() + this.f15828d.hashCode();
    }
}
