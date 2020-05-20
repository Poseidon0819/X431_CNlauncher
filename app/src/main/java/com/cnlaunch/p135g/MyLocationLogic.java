package com.cnlaunch.p135g;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mapapi.SDKInitializer;
import com.cnlaunch.p135g.p136a.LocationInfo;

/* renamed from: com.cnlaunch.g.h */
/* loaded from: classes.dex */
public final class MyLocationLogic {

    /* renamed from: a */
    public static int f7312a = 1;

    /* renamed from: b */
    public static int f7313b = 2;

    /* renamed from: c */
    public static int f7314c = 3;

    /* renamed from: d */
    private static MyLocationLogic f7315d;

    /* compiled from: MyLocationLogic.java */
    /* renamed from: com.cnlaunch.g.h$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1482a {
        /* renamed from: a */
        void mo5400a();

        /* renamed from: a */
        void mo5399a(LocationInfo locationInfo);
    }

    private MyLocationLogic() {
    }

    /* renamed from: a */
    public static MyLocationLogic m9420a() {
        if (f7315d == null) {
            f7315d = new MyLocationLogic();
        }
        return f7315d;
    }

    /* renamed from: a */
    public static void m9417a(Context context, InterfaceC1482a interfaceC1482a) {
        int i = f7314c;
        if (context != null) {
            LocationSuccessIndicator locationSuccessIndicator = new LocationSuccessIndicator();
            int i2 = f7312a;
            if ((i & i2) == i2) {
                SDKInitializer.initialize(context.getApplicationContext());
                SDKInitializer.setHttpsEnable(true);
                new BLocationLogic();
                if (BLocationLogic.f7288a == null) {
                    BLocationLogic.f7288a = new BLocationLogic();
                }
                BLocationLogic.f7288a.m9425a(context.getApplicationContext(), interfaceC1482a, locationSuccessIndicator);
            }
            int i3 = f7313b;
            if ((i & i3) == i3) {
                new MobileLocationLogic().m9421a(context.getApplicationContext(), interfaceC1482a, locationSuccessIndicator);
                return;
            }
            return;
        }
        interfaceC1482a.mo5400a();
    }

    /* renamed from: a */
    private static LocationInfo m9419a(Context context) {
        LocationInfo locationInfo = new LocationInfo();
        try {
            C1483i m9416a = C1483i.m9416a(context);
            double m9414a = m9416a.m9414a("my_latitude");
            double m9414a2 = m9416a.m9414a("my_longitude");
            locationInfo.setLocationType(m9416a.m9411b("location_type", LocationInfo.LOCATION_TYPE_ST));
            locationInfo.setLat(m9414a);
            locationInfo.setLon(m9414a2);
            locationInfo.setLocationAddress(m9416a.m9411b("location_address", ""));
            locationInfo.setCountry(m9416a.m9411b("location_contry", ""));
            locationInfo.setProvince(m9416a.m9411b("location_province", ""));
            locationInfo.setCity(m9416a.m9411b("location_city", ""));
            locationInfo.setDistrict(m9416a.m9411b("location_district", ""));
            locationInfo.setStreet(m9416a.m9411b("location_street", ""));
            locationInfo.setStreetNumber(m9416a.m9411b("location_street_number", ""));
            locationInfo.setLocationTime(m9416a.f7318a.getLong(TextUtils.isEmpty("location_time") ? "location_time" : "location_time".toLowerCase(), 0L));
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("myLocation:", "errorMessage" + e.getMessage());
        }
        return locationInfo;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0122 A[Catch: all -> 0x0133, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0024, B:8:0x002e, B:13:0x0045, B:42:0x0111, B:44:0x0122, B:46:0x0128, B:47:0x012c, B:14:0x005f, B:18:0x008d, B:22:0x00a3, B:26:0x00b9, B:30:0x00cf, B:34:0x00e5, B:38:0x00fb, B:41:0x010d, B:37:0x00f7, B:33:0x00e1, B:29:0x00cb, B:25:0x00b5, B:21:0x009f, B:17:0x0089), top: B:54:0x0003 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void m9418a(android.content.Context r6, com.cnlaunch.p135g.p136a.LocationInfo r7) {
        /*
            Method dump skipped, instructions count: 312
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.p135g.MyLocationLogic.m9418a(android.content.Context, com.cnlaunch.g.a.a):void");
    }
}
