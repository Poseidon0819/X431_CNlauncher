package com.baidu.mapsdkplatform.comapi.synchronization.p089b;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceQueryOptions;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.mapsdkplatform.comapi.synchronization.p091d.C1255a;
import com.baidu.mapsdkplatform.comapi.synchronization.p091d.C1257c;
import com.baidu.mapsdkplatform.comapi.synchronization.p091d.C1258d;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.mapsdkplatform.comapi.util.SyncSysInfo;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;

/* renamed from: com.baidu.mapsdkplatform.comapi.synchronization.b.d */
/* loaded from: classes.dex */
public class C1245d {

    /* renamed from: a */
    private static final String f6181a = "d";

    /* renamed from: c */
    private static boolean f6182c = true;

    /* renamed from: d */
    private static int f6183d = 1;

    /* renamed from: b */
    private C1258d f6184b = new C1258d();

    public C1245d(HistoryTraceQueryOptions historyTraceQueryOptions) {
        m10484a(historyTraceQueryOptions);
    }

    /* renamed from: a */
    public static void m10485a(int i) {
        f6183d = i;
    }

    /* renamed from: a */
    private void m10484a(HistoryTraceQueryOptions historyTraceQueryOptions) {
        C1258d c1258d;
        String str;
        String str2;
        this.f6184b.m10447a("order_id", m10482b(historyTraceQueryOptions));
        this.f6184b.m10447a("original_order_id", historyTraceQueryOptions.getOrderId().toLowerCase());
        this.f6184b.m10447a("company", historyTraceQueryOptions.getUserId());
        this.f6184b.m10447a("order_attr", historyTraceQueryOptions.getDriverId());
        this.f6184b.m10447a("track_status", String.valueOf(historyTraceQueryOptions.getQueryOrderState()));
        this.f6184b.m10447a("status", String.valueOf(historyTraceQueryOptions.getCurrentOrderState()));
        if (CoordType.BD09LL != SDKInitializer.getCoordType() && CoordType.GCJ02 == SDKInitializer.getCoordType()) {
            c1258d = this.f6184b;
            str = "coord_type";
            str2 = CoordinateType.GCJ02;
        } else {
            c1258d = this.f6184b;
            str = "coord_type";
            str2 = "bd09ll";
        }
        c1258d.m10447a(str, str2);
        this.f6184b.m10447a("page_index", String.valueOf(f6183d));
        f6183d = 1;
        this.f6184b.m10447a("page_size", "5000");
        this.f6184b.m10447a("is_processed", "1");
        m10483b();
    }

    /* renamed from: b */
    private String m10482b(HistoryTraceQueryOptions historyTraceQueryOptions) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(historyTraceQueryOptions.getUserId().toLowerCase());
        stringBuffer.append("-");
        stringBuffer.append(historyTraceQueryOptions.getOrderId().toLowerCase());
        stringBuffer.append("-");
        stringBuffer.append("9sc87244121ip32590fq234mn6641tx7".toLowerCase());
        String m10450a = C1257c.m10450a(stringBuffer.toString());
        String str = f6181a;
        C1255a.m10457a(str, "The orderId = " + stringBuffer.toString() + "; result = " + m10450a);
        return m10450a;
    }

    /* renamed from: b */
    private void m10483b() {
        String authToken = SyncSysInfo.getAuthToken();
        if (authToken == null) {
            C1255a.m10453b(f6181a, "Token is null, permission check again");
            int permissionCheck = PermissionCheck.permissionCheck();
            if (permissionCheck != 0) {
                C1255a.m10453b(f6181a, "Permission check result is: ".concat(String.valueOf(permissionCheck)));
                return;
            }
            authToken = SyncSysInfo.getAuthToken();
        }
        this.f6184b.m10447a("token", authToken);
    }

    /* renamed from: c */
    private String m10481c() {
        return f6182c ? C1246e.m10480a() : C1246e.m10479b();
    }

    /* renamed from: a */
    public String m10486a() {
        StringBuffer stringBuffer = new StringBuffer(this.f6184b.m10448a());
        stringBuffer.append(SyncSysInfo.getPhoneInfo());
        String signMD5String = AppMD5.getSignMD5String(stringBuffer.toString());
        stringBuffer.append("&sign=");
        stringBuffer.append(signMD5String);
        StringBuffer stringBuffer2 = new StringBuffer(m10481c());
        stringBuffer2.append("?");
        stringBuffer2.append(stringBuffer);
        return stringBuffer2.toString();
    }
}
