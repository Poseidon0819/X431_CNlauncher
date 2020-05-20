package com.cnlaunch.x431pro.utils.p283db;

/* renamed from: com.cnlaunch.x431pro.utils.db.e */
/* loaded from: classes.dex */
public class UserInfoTable {

    /* renamed from: a */
    Long f15846a;

    /* renamed from: b */
    String f15847b;

    /* renamed from: c */
    String f15848c;

    /* renamed from: d */
    String f15849d;

    public UserInfoTable() {
    }

    public UserInfoTable(Long l, String str, String str2, String str3) {
        this.f15846a = l;
        this.f15847b = str;
        this.f15848c = str2;
        this.f15849d = str3;
    }

    public String toString() {
        return "UserInfoTable{id=" + this.f15846a + ", userName='" + this.f15847b + "', serialNo='" + this.f15848c + "', userId='" + this.f15849d + "'}";
    }
}
