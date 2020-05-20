package com.baidu.mapsdkplatform.comapi.synchronization.data;

import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.mapsdkplatform.comapi.synchronization.data.C1269b;
import com.baidu.mapsdkplatform.comapi.synchronization.p090c.C1254d;
import com.baidu.mapsdkplatform.comapi.synchronization.p091d.C1255a;
import com.baidu.mapsdkplatform.comapi.synchronization.p091d.C1257c;
import com.baidu.mapsdkplatform.comapi.synchronization.p091d.C1258d;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.mapsdkplatform.comapi.util.SyncSysInfo;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;

/* renamed from: com.baidu.mapsdkplatform.comapi.synchronization.data.g */
/* loaded from: classes.dex */
public class C1279g {

    /* renamed from: a */
    private static final String f6285a = "g";

    /* renamed from: e */
    private static boolean f6286e = true;

    /* renamed from: b */
    private C1258d f6287b = new C1258d();

    /* renamed from: c */
    private boolean f6288c = true;

    /* renamed from: d */
    private boolean f6289d = true;

    public C1279g(C1269b c1269b) {
        m10304a(c1269b);
    }

    /* renamed from: a */
    private void m10304a(C1269b c1269b) {
        this.f6287b.m10447a("order_id", m10302b(c1269b));
        this.f6287b.m10447a("company", c1269b.m10374c());
        this.f6287b.m10447a("order_attr", c1269b.m10376b());
        this.f6287b.m10447a("status", String.valueOf(c1269b.m10366h()));
        this.f6287b.m10447a("pull_type", String.valueOf(c1269b.m10365i()));
        this.f6287b.m10447a("route_finger", c1269b.m10372d());
        this.f6287b.m10447a("traffic_finger", c1269b.m10370e());
        this.f6287b.m10447a("pos_num", String.valueOf(c1269b.m10364j()));
        m10300c(c1269b);
        m10299d(c1269b);
        if (this.f6288c) {
            m10303b();
        }
    }

    /* renamed from: b */
    private String m10302b(C1269b c1269b) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(c1269b.m10374c().toLowerCase());
        stringBuffer.append("-");
        stringBuffer.append(c1269b.m10379a().toLowerCase());
        stringBuffer.append("-");
        stringBuffer.append("9sc87244121ip32590fq234mn6641tx7".toLowerCase());
        String m10450a = C1257c.m10450a(stringBuffer.toString());
        String str = f6285a;
        C1255a.m10457a(str, "The orderId = " + stringBuffer.toString() + "; result = " + m10450a);
        return m10450a;
    }

    /* renamed from: b */
    private void m10303b() {
        String authToken = SyncSysInfo.getAuthToken();
        if (authToken == null) {
            C1255a.m10453b(f6285a, "Token is null, permission check again");
            int permissionCheck = PermissionCheck.permissionCheck();
            if (permissionCheck != 0) {
                C1255a.m10453b(f6285a, "Permission check result is: ".concat(String.valueOf(permissionCheck)));
            }
            authToken = SyncSysInfo.getAuthToken();
        }
        this.f6287b.m10447a("token", authToken);
    }

    /* renamed from: c */
    private String m10301c() {
        return f6286e ? C1254d.m10460a() : C1254d.m10459b();
    }

    /* renamed from: c */
    private void m10300c(C1269b c1269b) {
        C1258d c1258d;
        String str;
        String str2;
        C1269b.EnumC1271b m10367g = c1269b.m10367g();
        if (C1269b.EnumC1271b.DRIVING != m10367g && C1269b.EnumC1271b.RIDING == m10367g) {
            c1258d = this.f6287b;
            str = "trip_mode";
            str2 = "riding";
        } else {
            c1258d = this.f6287b;
            str = "trip_mode";
            str2 = "driving";
        }
        c1258d.m10447a(str, str2);
    }

    /* renamed from: d */
    private void m10299d(C1269b c1269b) {
        C1258d c1258d;
        String str;
        String str2;
        C1269b.EnumC1270a m10368f = c1269b.m10368f();
        if (C1269b.EnumC1270a.BD09LL != m10368f) {
            if (C1269b.EnumC1270a.BD09MC == m10368f) {
                c1258d = this.f6287b;
                str = "coord_type";
                str2 = CoordinateType.BD09MC;
            } else if (C1269b.EnumC1270a.GPS == m10368f) {
                c1258d = this.f6287b;
                str = "coord_type";
                str2 = CoordinateType.WGS84;
            } else if (C1269b.EnumC1270a.COMMON == m10368f) {
                c1258d = this.f6287b;
                str = "coord_type";
                str2 = CoordinateType.GCJ02;
            }
            c1258d.m10447a(str, str2);
        }
        c1258d = this.f6287b;
        str = "coord_type";
        str2 = "bd09ll";
        c1258d.m10447a(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public String m10305a() {
        StringBuffer stringBuffer = new StringBuffer(this.f6287b.m10448a());
        stringBuffer.append(SyncSysInfo.getPhoneInfo());
        if (this.f6289d) {
            String signMD5String = AppMD5.getSignMD5String(stringBuffer.toString());
            stringBuffer.append("&sign=");
            stringBuffer.append(signMD5String);
        }
        StringBuffer stringBuffer2 = new StringBuffer(m10301c());
        stringBuffer2.append("?");
        stringBuffer2.append(stringBuffer);
        return stringBuffer2.toString();
    }
}
