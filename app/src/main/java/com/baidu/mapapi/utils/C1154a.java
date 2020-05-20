package com.baidu.mapapi.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.common.AppTools;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapapi.navi.NaviParaOption;
import com.baidu.mapapi.utils.poi.DispathcPoiData;
import com.baidu.mapapi.utils.poi.PoiParaOption;
import com.baidu.mapapi.utils.route.RouteParaOption;
import com.baidu.mapframework.open.aidl.IComOpenClient;
import com.baidu.mapframework.open.aidl.InterfaceC1163a;
import com.baidu.mapframework.open.aidl.InterfaceC1166b;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.comapi.p092a.C1324a;
import com.itextpdf.text.Annotation;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.util.ArrayList;
import java.util.List;
import org.apache.mina.proxy.handlers.http.ntlm.NTLMConstants;
import org.jivesoftware.smack.packet.PrivacyItem;
import org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.mapapi.utils.a */
/* loaded from: classes.dex */
public class C1154a {

    /* renamed from: a */
    public static int f5759a = -1;

    /* renamed from: c */
    private static final String f5761c = "com.baidu.mapapi.utils.a";

    /* renamed from: d */
    private static InterfaceC1163a f5762d;

    /* renamed from: e */
    private static IComOpenClient f5763e;

    /* renamed from: f */
    private static int f5764f;

    /* renamed from: g */
    private static String f5765g;

    /* renamed from: h */
    private static String f5766h;

    /* renamed from: i */
    private static String f5767i;

    /* renamed from: o */
    private static RouteParaOption.EBusStrategyType f5773o;

    /* renamed from: v */
    private static Thread f5780v;

    /* renamed from: j */
    private static List<DispathcPoiData> f5768j = new ArrayList();

    /* renamed from: k */
    private static LatLng f5769k = null;

    /* renamed from: l */
    private static LatLng f5770l = null;

    /* renamed from: m */
    private static String f5771m = null;

    /* renamed from: n */
    private static String f5772n = null;

    /* renamed from: p */
    private static String f5774p = null;

    /* renamed from: q */
    private static String f5775q = null;

    /* renamed from: r */
    private static LatLng f5776r = null;

    /* renamed from: s */
    private static int f5777s = 0;

    /* renamed from: t */
    private static boolean f5778t = false;

    /* renamed from: u */
    private static boolean f5779u = false;

    /* renamed from: b */
    static ServiceConnection f5760b = new ServiceConnection() { // from class: com.baidu.mapapi.utils.a.2
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (C1154a.f5780v != null) {
                C1154a.f5780v.interrupt();
            }
            Log.d(C1154a.f5761c, "onServiceConnected ".concat(String.valueOf(componentName)));
            try {
                if (C1154a.f5762d != null) {
                    InterfaceC1163a unused = C1154a.f5762d = null;
                }
                InterfaceC1163a unused2 = C1154a.f5762d = InterfaceC1163a.AbstractBinderC1164a.m10883a(iBinder);
                C1154a.f5762d.mo10882a(new InterfaceC1166b.AbstractBinderC1167a() { // from class: com.baidu.mapapi.utils.a.2.1
                    @Override // com.baidu.mapframework.open.aidl.InterfaceC1166b
                    /* renamed from: a */
                    public void mo10880a(IBinder iBinder2) throws RemoteException {
                        Log.d(C1154a.f5761c, "onClientReady");
                        if (C1154a.f5763e != null) {
                            IComOpenClient unused3 = C1154a.f5763e = null;
                        }
                        IComOpenClient unused4 = C1154a.f5763e = IComOpenClient.AbstractBinderC1161a.m10886a(iBinder2);
                        if (!C1154a.f5778t) {
                            C1154a.m10929a(C1154a.f5759a);
                        }
                        boolean unused5 = C1154a.f5778t = true;
                    }
                });
            } catch (RemoteException e) {
                Log.d(C1154a.f5761c, "getComOpenClient ", e);
                if (C1154a.f5762d != null) {
                    InterfaceC1163a unused3 = C1154a.f5762d = null;
                }
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            Log.d(C1154a.f5761c, "onServiceDisconnected ".concat(String.valueOf(componentName)));
            if (C1154a.f5762d != null) {
                InterfaceC1163a unused = C1154a.f5762d = null;
                boolean unused2 = C1154a.f5779u = false;
            }
        }
    };

    /* renamed from: a */
    public static String m10930a() {
        return AppTools.getBaiduMapToken();
    }

    /* renamed from: a */
    public static void m10928a(int i, Context context) {
        switch (i) {
            case 0:
            case 1:
            case 2:
                m10908c(context, i);
                return;
            case 3:
                m10909c(context);
                return;
            case 4:
                m10906d(context);
                return;
            case 5:
                m10904e(context);
                return;
            case 6:
                return;
            case 7:
                m10902f(context);
                return;
            case 8:
                m10900g(context);
                return;
            case 9:
                m10898h(context);
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public static void m10927a(Context context) {
        if (f5779u) {
            context.unbindService(f5760b);
            f5779u = false;
        }
    }

    /* renamed from: a */
    private static void m10920a(List<DispathcPoiData> list, Context context) {
        f5765g = context.getPackageName();
        f5766h = m10916b(context);
        f5767i = "";
        List<DispathcPoiData> list2 = f5768j;
        if (list2 != null) {
            list2.clear();
        }
        for (DispathcPoiData dispathcPoiData : list) {
            f5768j.add(dispathcPoiData);
        }
    }

    /* renamed from: a */
    public static boolean m10929a(int i) {
        switch (i) {
            case 0:
            case 1:
            case 2:
                return m10901g();
            case 3:
                return m10899h();
            case 4:
                return m10893m();
            case 5:
                return m10896j();
            case 6:
                return m10897i();
            case 7:
                return m10895k();
            case 8:
                return m10894l();
            default:
                return false;
        }
    }

    /* renamed from: a */
    public static boolean m10926a(Context context, final int i) {
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!C1324a.m9934a(context)) {
            Log.d(f5761c, "package sign verify failed");
            return false;
        }
        f5778t = false;
        switch (i) {
            case 0:
                f5759a = 0;
                break;
            case 1:
                f5759a = 1;
                break;
            case 2:
                f5759a = 2;
                break;
            case 3:
                f5759a = 3;
                break;
            case 4:
                f5759a = 4;
                break;
            case 5:
                f5759a = 5;
                break;
            case 6:
                f5759a = 6;
                break;
            case 7:
                f5759a = 7;
                break;
            case 8:
                f5759a = 8;
                break;
            case 9:
                f5759a = 9;
                break;
        }
        if (i == 9) {
            f5779u = false;
        }
        if (f5762d == null || !f5779u) {
            m10915b(context, i);
        } else if (f5763e != null) {
            f5778t = true;
            return m10929a(i);
        } else {
            f5762d.mo10882a(new InterfaceC1166b.AbstractBinderC1167a() { // from class: com.baidu.mapapi.utils.a.1
                @Override // com.baidu.mapframework.open.aidl.InterfaceC1166b
                /* renamed from: a */
                public final void mo10880a(IBinder iBinder) throws RemoteException {
                    Log.d(C1154a.f5761c, "onClientReady");
                    if (C1154a.f5763e != null) {
                        IComOpenClient unused = C1154a.f5763e = null;
                    }
                    IComOpenClient unused2 = C1154a.f5763e = IComOpenClient.AbstractBinderC1161a.m10886a(iBinder);
                    C1154a.m10929a(i);
                    boolean unused3 = C1154a.f5778t = true;
                }
            });
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m10925a(NaviParaOption naviParaOption, Context context, int i) {
        m10914b(naviParaOption, context, i);
        return m10926a(context, i);
    }

    /* renamed from: a */
    public static boolean m10924a(PoiParaOption poiParaOption, Context context, int i) {
        m10913b(poiParaOption, context, i);
        return m10926a(context, i);
    }

    /* renamed from: a */
    public static boolean m10923a(RouteParaOption routeParaOption, Context context, int i) {
        m10912b(routeParaOption, context, i);
        return m10926a(context, i);
    }

    /* renamed from: a */
    public static boolean m10919a(List<DispathcPoiData> list, Context context, int i) {
        m10920a(list, context);
        return m10926a(context, i);
    }

    /* renamed from: b */
    public static String m10916b(Context context) {
        PackageManager packageManager;
        ApplicationInfo applicationInfo = null;
        try {
            packageManager = context.getPackageManager();
            try {
                applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            packageManager = null;
        }
        return (String) packageManager.getApplicationLabel(applicationInfo);
    }

    /* renamed from: b */
    private static void m10915b(final Context context, final int i) {
        Intent intent = new Intent();
        String m10930a = m10930a();
        if (m10930a == null) {
            return;
        }
        intent.putExtra("api_token", m10930a);
        intent.setAction("com.baidu.map.action.OPEN_SERVICE");
        intent.setPackage("com.baidu.BaiduMap");
        if (i != 9) {
            f5779u = context.bindService(intent, f5760b, 1);
        }
        if (!f5779u) {
            Log.e("baidumapsdk", "bind service failed，call openapi");
            m10928a(i, context);
            return;
        }
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.mapapi.utils.a.3
            @Override // java.lang.Runnable
            public final void run() {
                long currentTimeMillis = System.currentTimeMillis();
                do {
                    if (System.currentTimeMillis() - currentTimeMillis > 3000) {
                        C1154a.m10927a(context);
                        C1154a.m10928a(i, context);
                    }
                } while (!C1154a.f5780v.isInterrupted());
            }
        });
        f5780v = thread;
        thread.setDaemon(true);
        f5780v.start();
    }

    /* renamed from: b */
    private static void m10914b(NaviParaOption naviParaOption, Context context, int i) {
        f5765g = context.getPackageName();
        f5771m = null;
        f5769k = null;
        f5772n = null;
        f5770l = null;
        if (naviParaOption.getStartPoint() != null) {
            f5769k = naviParaOption.getStartPoint();
        }
        if (naviParaOption.getEndPoint() != null) {
            f5770l = naviParaOption.getEndPoint();
        }
        if (naviParaOption.getStartName() != null) {
            f5771m = naviParaOption.getStartName();
        }
        if (naviParaOption.getEndName() != null) {
            f5772n = naviParaOption.getEndName();
        }
    }

    /* renamed from: b */
    private static void m10913b(PoiParaOption poiParaOption, Context context, int i) {
        f5774p = null;
        f5775q = null;
        f5776r = null;
        f5777s = 0;
        f5765g = context.getPackageName();
        if (poiParaOption.getUid() != null) {
            f5774p = poiParaOption.getUid();
        }
        if (poiParaOption.getKey() != null) {
            f5775q = poiParaOption.getKey();
        }
        if (poiParaOption.getCenter() != null) {
            f5776r = poiParaOption.getCenter();
        }
        if (poiParaOption.getRadius() != 0) {
            f5777s = poiParaOption.getRadius();
        }
    }

    /* renamed from: b */
    private static void m10912b(RouteParaOption routeParaOption, Context context, int i) {
        int i2;
        f5771m = null;
        f5769k = null;
        f5772n = null;
        f5770l = null;
        f5765g = context.getPackageName();
        if (routeParaOption.getStartPoint() != null) {
            f5769k = routeParaOption.getStartPoint();
        }
        if (routeParaOption.getEndPoint() != null) {
            f5770l = routeParaOption.getEndPoint();
        }
        if (routeParaOption.getStartName() != null) {
            f5771m = routeParaOption.getStartName();
        }
        if (routeParaOption.getEndName() != null) {
            f5772n = routeParaOption.getEndName();
        }
        if (routeParaOption.getBusStrategyType() != null) {
            f5773o = routeParaOption.getBusStrategyType();
        }
        switch (i) {
            case 0:
                i2 = 0;
                break;
            case 1:
                i2 = 1;
                break;
            case 2:
                f5764f = 2;
                return;
            default:
                return;
        }
        f5764f = i2;
    }

    /* renamed from: c */
    private static void m10909c(Context context) {
        Thread thread = f5780v;
        if (thread != null) {
            thread.interrupt();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("baidumap://map/place/detail?");
        sb.append("uid=");
        sb.append(f5774p);
        sb.append("&show_type=detail_page");
        sb.append("&src=");
        sb.append("sdk_[" + f5765g + "]");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
        intent.setFlags(NTLMConstants.FLAG_UNIDENTIFIED_11);
        context.startActivity(intent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x007b, code lost:
        if (r2 != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00d6, code lost:
        if (r2 != null) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d4  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void m10908c(android.content.Context r4, int r5) {
        /*
            Method dump skipped, instructions count: 285
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.utils.C1154a.m10908c(android.content.Context, int):void");
    }

    /* renamed from: d */
    private static void m10906d(Context context) {
        Thread thread = f5780v;
        if (thread != null) {
            thread.interrupt();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("baidumap://map/nearbysearch?");
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            f5776r = CoordTrans.gcjToBaidu(f5776r);
        }
        sb.append("center=");
        sb.append(f5776r.latitude);
        sb.append(",");
        sb.append(f5776r.longitude);
        sb.append("&query=");
        sb.append(f5775q);
        sb.append("&radius=");
        sb.append(f5777s);
        sb.append("&src=");
        sb.append("sdk_[" + f5765g + "]");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
        intent.setFlags(NTLMConstants.FLAG_UNIDENTIFIED_11);
        context.startActivity(intent);
    }

    /* renamed from: e */
    private static void m10904e(Context context) {
        Thread thread = f5780v;
        if (thread != null) {
            thread.interrupt();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("baidumap://map/navi?");
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            f5769k = CoordTrans.gcjToBaidu(f5769k);
            f5770l = CoordTrans.gcjToBaidu(f5770l);
        }
        sb.append("origin=");
        sb.append(f5769k.latitude);
        sb.append(",");
        sb.append(f5769k.longitude);
        sb.append("&location=");
        sb.append(f5770l.latitude);
        sb.append(",");
        sb.append(f5770l.longitude);
        sb.append("&src=");
        sb.append("sdk_[" + f5765g + "]");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
        intent.setFlags(NTLMConstants.FLAG_UNIDENTIFIED_11);
        context.startActivity(intent);
    }

    /* renamed from: f */
    private static void m10902f(Context context) {
        Thread thread = f5780v;
        if (thread != null) {
            thread.interrupt();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("baidumap://map/walknavi?");
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            f5769k = CoordTrans.gcjToBaidu(f5769k);
            f5770l = CoordTrans.gcjToBaidu(f5770l);
        }
        sb.append("origin=");
        sb.append(f5769k.latitude);
        sb.append(",");
        sb.append(f5769k.longitude);
        sb.append("&destination=");
        sb.append(f5770l.latitude);
        sb.append(",");
        sb.append(f5770l.longitude);
        sb.append("&src=");
        sb.append("sdk_[" + f5765g + "]");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
        intent.setFlags(NTLMConstants.FLAG_UNIDENTIFIED_11);
        context.startActivity(intent);
    }

    /* renamed from: g */
    private static void m10900g(Context context) {
        Thread thread = f5780v;
        if (thread != null) {
            thread.interrupt();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("baidumap://map/bikenavi?");
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            f5769k = CoordTrans.gcjToBaidu(f5769k);
            f5770l = CoordTrans.gcjToBaidu(f5770l);
        }
        sb.append("origin=");
        sb.append(f5769k.latitude);
        sb.append(",");
        sb.append(f5769k.longitude);
        sb.append("&destination=");
        sb.append(f5770l.latitude);
        sb.append(",");
        sb.append(f5770l.longitude);
        sb.append("&src=");
        sb.append("sdk_[" + f5765g + "]");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
        intent.setFlags(NTLMConstants.FLAG_UNIDENTIFIED_11);
        context.startActivity(intent);
    }

    /* renamed from: g */
    private static boolean m10901g() {
        String mo10885a;
        String str;
        String str2;
        String str3;
        String str4;
        try {
            Log.d(f5761c, "callDispatchTakeOutRoute");
            mo10885a = f5763e.mo10885a("map.android.baidu.mainmap");
        } catch (RemoteException e) {
            Log.d(f5761c, "callDispatchTakeOut exception", e);
        }
        if (mo10885a == null) {
            Log.d(f5761c, "callDispatchTakeOut com not found");
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString("target", "route_search_page");
        Bundle bundle2 = new Bundle();
        bundle2.putInt("route_type", f5764f);
        bundle2.putInt("bus_strategy", f5773o.ordinal());
        bundle2.putInt("cross_city_bus_strategy", 5);
        if (f5769k != null) {
            bundle2.putInt("start_type", 1);
            bundle2.putInt("start_longitude", (int) CoordUtil.ll2mc(f5769k).getLongitudeE6());
            bundle2.putInt("start_latitude", (int) CoordUtil.ll2mc(f5769k).getLatitudeE6());
        } else {
            bundle2.putInt("start_type", 2);
            bundle2.putInt("start_longitude", 0);
            bundle2.putInt("start_latitude", 0);
        }
        if (f5771m != null) {
            str = "start_keyword";
            str2 = f5771m;
        } else {
            str = "start_keyword";
            str2 = "地图上的点";
        }
        bundle2.putString(str, str2);
        bundle2.putString("start_uid", "");
        if (f5770l != null) {
            bundle2.putInt("end_type", 1);
            bundle2.putInt("end_longitude", (int) CoordUtil.ll2mc(f5770l).getLongitudeE6());
            bundle2.putInt("end_latitude", (int) CoordUtil.ll2mc(f5770l).getLatitudeE6());
        } else {
            bundle2.putInt("end_type", 2);
            bundle2.putInt("end_longitude", 0);
            bundle2.putInt("end_latitude", 0);
        }
        if (f5772n != null) {
            str3 = "end_keyword";
            str4 = f5772n;
        } else {
            str3 = "end_keyword";
            str4 = "地图上的点";
        }
        bundle2.putString(str3, str4);
        bundle2.putString("end_uid", "");
        bundle.putBundle("base_params", bundle2);
        Bundle bundle3 = new Bundle();
        bundle3.putString("launch_from", "sdk_[" + f5765g + "]");
        bundle.putBundle("ext_params", bundle3);
        return f5763e.mo10884a("map.android.baidu.mainmap", mo10885a, bundle);
    }

    /* renamed from: h */
    private static void m10898h(Context context) {
        Thread thread = f5780v;
        if (thread != null) {
            thread.interrupt();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("baidumap://map/walknavi?");
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            f5769k = CoordTrans.gcjToBaidu(f5769k);
            f5770l = CoordTrans.gcjToBaidu(f5770l);
        }
        sb.append("origin=");
        sb.append(f5769k.latitude);
        sb.append(",");
        sb.append(f5769k.longitude);
        sb.append("&destination=");
        sb.append(f5770l.latitude);
        sb.append(",");
        sb.append(f5770l.longitude);
        sb.append("&mode=walking_ar");
        sb.append("&src=");
        sb.append("sdk_[" + f5765g + "]");
        Log.e("test", sb.toString());
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
        intent.setFlags(NTLMConstants.FLAG_UNIDENTIFIED_11);
        context.startActivity(intent);
    }

    /* renamed from: h */
    private static boolean m10899h() {
        String str;
        String str2;
        try {
            Log.d(f5761c, "callDispatchTakeOutPoiDetials");
            String mo10885a = f5763e.mo10885a("map.android.baidu.mainmap");
            if (mo10885a == null) {
                Log.d(f5761c, "callDispatchTakeOut com not found");
                return false;
            }
            Bundle bundle = new Bundle();
            bundle.putString("target", "request_poi_detail_page");
            Bundle bundle2 = new Bundle();
            if (f5774p != null) {
                str = "uid";
                str2 = f5774p;
            } else {
                str = "uid";
                str2 = "";
            }
            bundle2.putString(str, str2);
            bundle.putBundle("base_params", bundle2);
            Bundle bundle3 = new Bundle();
            bundle3.putString("launch_from", "sdk_[" + f5765g + "]");
            bundle.putBundle("ext_params", bundle3);
            return f5763e.mo10884a("map.android.baidu.mainmap", mo10885a, bundle);
        } catch (RemoteException e) {
            Log.d(f5761c, "callDispatchTakeOut exception", e);
            return false;
        }
    }

    /* renamed from: i */
    private static boolean m10897i() {
        List<DispathcPoiData> list = f5768j;
        if (list != null && list.size() > 0) {
            try {
                Log.d(f5761c, "callDispatchPoiToBaiduMap");
                String mo10885a = f5763e.mo10885a("map.android.baidu.mainmap");
                if (mo10885a != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("target", "favorite_page");
                    Bundle bundle2 = new Bundle();
                    JSONArray jSONArray = new JSONArray();
                    int i = 0;
                    for (int i2 = 0; i2 < f5768j.size(); i2++) {
                        if (f5768j.get(i2).name != null && !f5768j.get(i2).name.equals("") && f5768j.get(i2).f5789pt != null) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("name", f5768j.get(i2).name);
                                GeoPoint ll2mc = CoordUtil.ll2mc(f5768j.get(i2).f5789pt);
                                jSONObject.put("ptx", ll2mc.getLongitudeE6());
                                jSONObject.put("pty", ll2mc.getLatitudeE6());
                                jSONObject.put("addr", f5768j.get(i2).addr);
                                jSONObject.put("uid", f5768j.get(i2).uid);
                                i++;
                                jSONArray.put(jSONObject);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    if (i == 0) {
                        return false;
                    }
                    bundle2.putString(DataPacketExtension.ELEMENT_NAME, jSONArray.toString());
                    bundle2.putString(PrivacyItem.PrivacyRule.SUBSCRIPTION_FROM, f5766h);
                    bundle2.putString("pkg", f5765g);
                    bundle2.putString("cls", f5767i);
                    bundle2.putInt("count", i);
                    bundle.putBundle("base_params", bundle2);
                    Bundle bundle3 = new Bundle();
                    bundle3.putString("launch_from", "sdk_[" + f5765g + "]");
                    bundle.putBundle("ext_params", bundle3);
                    return f5763e.mo10884a("map.android.baidu.mainmap", mo10885a, bundle);
                }
                Log.d(f5761c, "callDispatchPoiToBaiduMap com not found");
            } catch (RemoteException e2) {
                Log.d(f5761c, "callDispatchPoiToBaiduMap exception", e2);
            }
        }
        return false;
    }

    /* renamed from: j */
    private static boolean m10896j() {
        String mo10885a;
        try {
            Log.d(f5761c, "callDispatchTakeOutRouteNavi");
            mo10885a = f5763e.mo10885a("map.android.baidu.mainmap");
        } catch (RemoteException e) {
            Log.d(f5761c, "callDispatchTakeOut exception", e);
        }
        if (mo10885a == null) {
            Log.d(f5761c, "callDispatchTakeOut com not found");
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString("target", "navigation_page");
        Bundle bundle2 = new Bundle();
        bundle2.putString("coord_type", "bd09ll");
        bundle2.putString(VastExtensionXmlManager.TYPE, "DIS");
        StringBuffer stringBuffer = new StringBuffer();
        if (f5771m != null) {
            stringBuffer.append("name:" + f5771m + "|");
        }
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            f5769k = CoordTrans.gcjToBaidu(f5769k);
        }
        stringBuffer.append(String.format("latlng:%f,%f", Double.valueOf(f5769k.latitude), Double.valueOf(f5769k.longitude)));
        StringBuffer stringBuffer2 = new StringBuffer();
        if (f5772n != null) {
            stringBuffer2.append("name:" + f5772n + "|");
        }
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            f5770l = CoordTrans.gcjToBaidu(f5770l);
        }
        stringBuffer2.append(String.format("latlng:%f,%f", Double.valueOf(f5770l.latitude), Double.valueOf(f5770l.longitude)));
        bundle2.putString("origin", stringBuffer.toString());
        bundle2.putString(Annotation.DESTINATION, stringBuffer2.toString());
        bundle.putBundle("base_params", bundle2);
        Bundle bundle3 = new Bundle();
        bundle3.putString("launch_from", "sdk_[" + f5765g + "]");
        bundle.putBundle("ext_params", bundle3);
        return f5763e.mo10884a("map.android.baidu.mainmap", mo10885a, bundle);
    }

    /* renamed from: k */
    private static boolean m10895k() {
        String mo10885a;
        try {
            Log.d(f5761c, "callDispatchTakeOutRouteNavi");
            mo10885a = f5763e.mo10885a("map.android.baidu.mainmap");
        } catch (Exception e) {
            Log.d(f5761c, "callDispatchTakeOut exception", e);
        }
        if (mo10885a == null) {
            Log.d(f5761c, "callDispatchTakeOut com not found");
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString("target", "walknavi_page");
        Bundle bundle2 = new Bundle();
        bundle2.putString("coord_type", "bd09ll");
        StringBuffer stringBuffer = new StringBuffer();
        if (f5771m != null) {
            stringBuffer.append("name:" + f5771m + "|");
        }
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            f5769k = CoordTrans.gcjToBaidu(f5769k);
        }
        stringBuffer.append(String.format("latlng:%f,%f", Double.valueOf(f5769k.latitude), Double.valueOf(f5769k.longitude)));
        StringBuffer stringBuffer2 = new StringBuffer();
        if (f5772n != null) {
            stringBuffer2.append("name:" + f5772n + "|");
        }
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            f5770l = CoordTrans.gcjToBaidu(f5770l);
        }
        stringBuffer2.append(String.format("latlng:%f,%f", Double.valueOf(f5770l.latitude), Double.valueOf(f5770l.longitude)));
        bundle2.putString("origin", stringBuffer.toString());
        bundle2.putString(Annotation.DESTINATION, stringBuffer2.toString());
        bundle.putBundle("base_params", bundle2);
        Bundle bundle3 = new Bundle();
        bundle3.putString("launch_from", "sdk_[" + f5765g + "]");
        bundle.putBundle("ext_params", bundle3);
        return f5763e.mo10884a("map.android.baidu.mainmap", mo10885a, bundle);
    }

    /* renamed from: l */
    private static boolean m10894l() {
        String mo10885a;
        try {
            Log.d(f5761c, "callDispatchTakeOutRouteRidingNavi");
            mo10885a = f5763e.mo10885a("map.android.baidu.mainmap");
        } catch (RemoteException e) {
            Log.d(f5761c, "callDispatchTakeOut exception", e);
        }
        if (mo10885a == null) {
            Log.d(f5761c, "callDispatchTakeOut com not found");
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString("target", "bikenavi_page");
        Bundle bundle2 = new Bundle();
        bundle2.putString("coord_type", "bd09ll");
        StringBuffer stringBuffer = new StringBuffer();
        if (f5771m != null) {
            stringBuffer.append("name:" + f5771m + "|");
        }
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            f5769k = CoordTrans.gcjToBaidu(f5769k);
        }
        stringBuffer.append(String.format("latlng:%f,%f", Double.valueOf(f5769k.latitude), Double.valueOf(f5769k.longitude)));
        StringBuffer stringBuffer2 = new StringBuffer();
        if (f5772n != null) {
            stringBuffer2.append("name:" + f5772n + "|");
        }
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            f5770l = CoordTrans.gcjToBaidu(f5770l);
        }
        stringBuffer2.append(String.format("latlng:%f,%f", Double.valueOf(f5770l.latitude), Double.valueOf(f5770l.longitude)));
        bundle2.putString("origin", stringBuffer.toString());
        bundle2.putString(Annotation.DESTINATION, stringBuffer2.toString());
        bundle.putBundle("base_params", bundle2);
        Bundle bundle3 = new Bundle();
        bundle3.putString("launch_from", "sdk_[" + f5765g + "]");
        bundle.putBundle("ext_params", bundle3);
        return f5763e.mo10884a("map.android.baidu.mainmap", mo10885a, bundle);
    }

    /* renamed from: m */
    private static boolean m10893m() {
        String str;
        String str2;
        try {
            Log.d(f5761c, "callDispatchTakeOutPoiNearbySearch");
            String mo10885a = f5763e.mo10885a("map.android.baidu.mainmap");
            if (mo10885a == null) {
                Log.d(f5761c, "callDispatchTakeOut com not found");
                return false;
            }
            Bundle bundle = new Bundle();
            bundle.putString("target", "poi_search_page");
            Bundle bundle2 = new Bundle();
            if (f5775q != null) {
                str = "search_key";
                str2 = f5775q;
            } else {
                str = "search_key";
                str2 = "";
            }
            bundle2.putString(str, str2);
            if (f5776r != null) {
                bundle2.putInt("center_pt_x", (int) CoordUtil.ll2mc(f5776r).getLongitudeE6());
                bundle2.putInt("center_pt_y", (int) CoordUtil.ll2mc(f5776r).getLatitudeE6());
            } else {
                bundle2.putString("search_key", "");
            }
            if (f5777s != 0) {
                bundle2.putInt("search_radius", f5777s);
            } else {
                bundle2.putInt("search_radius", 1000);
            }
            bundle2.putBoolean("is_direct_search", true);
            bundle2.putBoolean("is_direct_area_search", true);
            bundle.putBundle("base_params", bundle2);
            Bundle bundle3 = new Bundle();
            bundle3.putString("launch_from", "sdk_[" + f5765g + "]");
            bundle.putBundle("ext_params", bundle3);
            return f5763e.mo10884a("map.android.baidu.mainmap", mo10885a, bundle);
        } catch (RemoteException e) {
            Log.d(f5761c, "callDispatchTakeOut exception", e);
            return false;
        }
    }
}
