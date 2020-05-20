package com.cnlaunch.x431pro.activity.info;

import java.io.Serializable;

/* renamed from: com.cnlaunch.x431pro.activity.info.a */
/* loaded from: classes.dex */
public final class CyUserInfo implements Serializable {
    public String beginTime;
    public String endTime;
    public String password;

    /* renamed from: sn */
    public String f12871sn;

    public CyUserInfo(String str, String str2, String str3, String str4) {
        this.f12871sn = str;
        this.password = str2;
        this.beginTime = str3;
        this.endTime = str4;
    }

    public final String toString() {
        return "CyUserInfo{sn='" + this.f12871sn + "', password='" + this.password + "', beginTime='" + this.beginTime + "', endTime='" + this.endTime + "'}";
    }
}
