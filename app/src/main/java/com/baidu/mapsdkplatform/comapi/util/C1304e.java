package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.android.bbalbs.common.util.CommonParam;
import com.baidu.mapapi.VersionInfo;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.baidu.mapsdkplatform.comjni.util.C1313a;
import com.unionpay.tsmservice.data.Constant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.baidu.mapsdkplatform.comapi.util.e */
/* loaded from: classes.dex */
public class C1304e {

    /* renamed from: A */
    private static final String f6399A = "e";

    /* renamed from: b */
    static String f6406b;

    /* renamed from: c */
    static String f6407c;

    /* renamed from: d */
    static String f6408d;

    /* renamed from: e */
    static String f6409e;

    /* renamed from: f */
    static int f6410f;

    /* renamed from: g */
    static int f6411g;

    /* renamed from: h */
    static int f6412h;

    /* renamed from: i */
    static int f6413i;

    /* renamed from: j */
    static int f6414j;

    /* renamed from: k */
    static int f6415k;

    /* renamed from: l */
    static String f6416l;

    /* renamed from: m */
    static String f6417m;

    /* renamed from: s */
    static String f6423s;

    /* renamed from: t */
    static String f6424t;

    /* renamed from: w */
    public static Context f6427w;

    /* renamed from: z */
    public static String f6430z;

    /* renamed from: B */
    private static C1313a f6400B = new C1313a();

    /* renamed from: a */
    static String f6405a = "02";

    /* renamed from: n */
    static String f6418n = "baidu";

    /* renamed from: o */
    static String f6419o = "baidu";

    /* renamed from: p */
    static String f6420p = "";

    /* renamed from: q */
    static String f6421q = "";

    /* renamed from: r */
    static String f6422r = "";

    /* renamed from: u */
    static String f6425u = "-1";

    /* renamed from: v */
    static String f6426v = "-1";

    /* renamed from: x */
    public static final int f6428x = Integer.parseInt(Build.VERSION.SDK);

    /* renamed from: y */
    public static float f6429y = 1.0f;

    /* renamed from: C */
    private static boolean f6401C = true;

    /* renamed from: D */
    private static int f6402D = 0;

    /* renamed from: E */
    private static int f6403E = 0;

    /* renamed from: F */
    private static Map<String, String> f6404F = new HashMap();

    /* renamed from: a */
    public static void m10075a() {
        m10067d();
    }

    /* renamed from: a */
    public static void m10073a(String str) {
        f6416l = str;
        m10063f();
    }

    /* renamed from: a */
    public static void m10072a(String str, String str2) {
        f6425u = str2;
        f6426v = str;
        m10063f();
    }

    /* renamed from: a */
    public static byte[] m10074a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    public static Bundle m10071b() {
        Bundle bundle = new Bundle();
        bundle.putString("cpu", f6420p);
        bundle.putString("resid", f6405a);
        bundle.putString(Constant.KEY_CHANNEL, f6418n);
        bundle.putString("glr", f6421q);
        bundle.putString("glv", f6422r);
        bundle.putString("mb", m10061g());
        bundle.putString("sv", m10059i());
        bundle.putString("os", m10057k());
        bundle.putInt("dpi_x", m10056l());
        bundle.putInt("dpi_y", m10056l());
        bundle.putString("net", f6416l);
        bundle.putString("cuid", m10053o());
        bundle.putByteArray("signature", m10074a(f6427w));
        bundle.putString("pcn", f6427w.getPackageName());
        bundle.putInt("screen_x", m10060h());
        bundle.putInt("screen_y", m10058j());
        C1313a c1313a = f6400B;
        if (c1313a != null) {
            c1313a.m9958a(bundle);
            Log.d("phoneInfo", "mAppSysOSAPI not null");
        }
        Log.d("phoneInfo", bundle.toString());
        return bundle;
    }

    /* renamed from: b */
    public static void m10070b(Context context) {
        Map<String, String> map;
        String str;
        String str2;
        Object[] objArr;
        f6427w = context;
        if (context.getFilesDir() != null) {
            f6423s = context.getFilesDir().getAbsolutePath();
        }
        if (context.getCacheDir() != null) {
            f6424t = context.getCacheDir().getAbsolutePath();
        }
        f6407c = Build.MODEL;
        f6408d = "Android" + Build.VERSION.SDK;
        f6406b = context.getPackageName();
        m10068c(context);
        m10066d(context);
        m10064e(context);
        m10062f(context);
        try {
            try {
                LocationManager locationManager = (LocationManager) context.getSystemService("location");
                f6402D = locationManager.isProviderEnabled("gps") ? 1 : 0;
                f6403E = locationManager.isProviderEnabled("network") ? 1 : 0;
                f6404F.put("resid", AppMD5.encodeUrlParamsValue(f6405a));
                f6404F.put(Constant.KEY_CHANNEL, AppMD5.encodeUrlParamsValue(m10055m()));
                f6404F.put("mb", AppMD5.encodeUrlParamsValue(m10061g()));
                f6404F.put("sv", AppMD5.encodeUrlParamsValue(m10059i()));
                f6404F.put("os", AppMD5.encodeUrlParamsValue(m10057k()));
                f6404F.put("dpi", AppMD5.encodeUrlParamsValue(String.format("%d,%d", Integer.valueOf(m10056l()), Integer.valueOf(m10056l()))));
                f6404F.put("cuid", AppMD5.encodeUrlParamsValue(m10053o()));
                f6404F.put("pcn", AppMD5.encodeUrlParamsValue(f6427w.getPackageName()));
                map = f6404F;
                str = "screen";
                str2 = "%d,%d";
                objArr = new Object[]{Integer.valueOf(m10060h()), Integer.valueOf(m10058j())};
            } catch (Exception unused) {
                Log.w("baidumapsdk", "LocationManager error");
                f6404F.put("resid", AppMD5.encodeUrlParamsValue(f6405a));
                f6404F.put(Constant.KEY_CHANNEL, AppMD5.encodeUrlParamsValue(m10055m()));
                f6404F.put("mb", AppMD5.encodeUrlParamsValue(m10061g()));
                f6404F.put("sv", AppMD5.encodeUrlParamsValue(m10059i()));
                f6404F.put("os", AppMD5.encodeUrlParamsValue(m10057k()));
                f6404F.put("dpi", AppMD5.encodeUrlParamsValue(String.format("%d,%d", Integer.valueOf(m10056l()), Integer.valueOf(m10056l()))));
                f6404F.put("cuid", AppMD5.encodeUrlParamsValue(m10053o()));
                f6404F.put("pcn", AppMD5.encodeUrlParamsValue(f6427w.getPackageName()));
                map = f6404F;
                str = "screen";
                str2 = "%d,%d";
                objArr = new Object[]{Integer.valueOf(m10060h()), Integer.valueOf(m10058j())};
            }
            map.put(str, AppMD5.encodeUrlParamsValue(String.format(str2, objArr)));
            C1313a c1313a = f6400B;
            if (c1313a != null) {
                c1313a.m9959a();
            }
        } catch (Throwable th) {
            f6404F.put("resid", AppMD5.encodeUrlParamsValue(f6405a));
            f6404F.put(Constant.KEY_CHANNEL, AppMD5.encodeUrlParamsValue(m10055m()));
            f6404F.put("mb", AppMD5.encodeUrlParamsValue(m10061g()));
            f6404F.put("sv", AppMD5.encodeUrlParamsValue(m10059i()));
            f6404F.put("os", AppMD5.encodeUrlParamsValue(m10057k()));
            f6404F.put("dpi", AppMD5.encodeUrlParamsValue(String.format("%d,%d", Integer.valueOf(m10056l()), Integer.valueOf(m10056l()))));
            f6404F.put("cuid", AppMD5.encodeUrlParamsValue(m10053o()));
            f6404F.put("pcn", AppMD5.encodeUrlParamsValue(f6427w.getPackageName()));
            f6404F.put("screen", AppMD5.encodeUrlParamsValue(String.format("%d,%d", Integer.valueOf(m10060h()), Integer.valueOf(m10058j()))));
            throw th;
        }
    }

    /* renamed from: c */
    public static String m10069c() {
        Date date;
        if (f6404F == null) {
            return null;
        }
        long time = new Date().getTime() + (date.getSeconds() * 1000);
        double d = time / 1000;
        double d2 = time % 1000;
        Double.isNaN(d2);
        Double.isNaN(d);
        f6404F.put("ctm", AppMD5.encodeUrlParamsValue(String.format("%f", Double.valueOf(d + (d2 / 1000.0d)))));
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : f6404F.entrySet()) {
            sb.append("&");
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
        }
        return sb.toString();
    }

    /* renamed from: c */
    private static void m10068c(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            String apiVersion = VersionInfo.getApiVersion();
            f6409e = apiVersion;
            if (apiVersion != null && !f6409e.equals("")) {
                f6409e = f6409e.replace('_', '.');
            }
            f6410f = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            f6409e = "1.0.0";
            f6410f = 1;
        }
    }

    /* renamed from: d */
    public static void m10067d() {
        C1313a c1313a = f6400B;
        if (c1313a != null) {
            c1313a.m9957b();
        }
    }

    /* renamed from: d */
    private static void m10066d(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display defaultDisplay = windowManager != null ? windowManager.getDefaultDisplay() : null;
        if (defaultDisplay != null) {
            f6411g = defaultDisplay.getWidth();
            f6412h = defaultDisplay.getHeight();
            defaultDisplay.getMetrics(displayMetrics);
        }
        f6429y = displayMetrics.density;
        f6413i = (int) displayMetrics.xdpi;
        f6414j = (int) displayMetrics.ydpi;
        if (f6428x > 3) {
            f6415k = displayMetrics.densityDpi;
        } else {
            f6415k = 160;
        }
        if (f6415k == 0) {
            f6415k = 160;
        }
    }

    /* renamed from: e */
    public static String m10065e() {
        return f6416l;
    }

    /* renamed from: e */
    private static void m10064e(Context context) {
        f6417m = Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    /* renamed from: f */
    public static void m10063f() {
        f6404F.put("net", AppMD5.encodeUrlParamsValue(m10065e()));
        f6404F.put("appid", AppMD5.encodeUrlParamsValue(f6425u));
        f6404F.put("bduid", "");
        if (f6400B == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("cpu", f6420p);
        bundle.putString("resid", f6405a);
        bundle.putString(Constant.KEY_CHANNEL, f6418n);
        bundle.putString("glr", f6421q);
        bundle.putString("glv", f6422r);
        bundle.putString("mb", m10061g());
        bundle.putString("sv", m10059i());
        bundle.putString("os", m10057k());
        bundle.putInt("dpi_x", m10056l());
        bundle.putInt("dpi_y", m10056l());
        bundle.putString("net", f6416l);
        bundle.putString("cuid", m10053o());
        bundle.putString("pcn", f6427w.getPackageName());
        bundle.putInt("screen_x", m10060h());
        bundle.putInt("screen_y", m10058j());
        bundle.putString("appid", f6425u);
        bundle.putString("duid", f6426v);
        if (!TextUtils.isEmpty(f6430z)) {
            bundle.putString("token", f6430z);
        }
        f6400B.m9958a(bundle);
        SysUpdateObservable.getInstance().updatePhoneInfo();
    }

    /* renamed from: f */
    private static void m10062f(Context context) {
        f6416l = "0";
    }

    /* renamed from: g */
    public static String m10061g() {
        return f6407c;
    }

    /* renamed from: h */
    public static int m10060h() {
        return f6411g;
    }

    /* renamed from: i */
    public static String m10059i() {
        return f6409e;
    }

    /* renamed from: j */
    public static int m10058j() {
        return f6412h;
    }

    /* renamed from: k */
    public static String m10057k() {
        return f6408d;
    }

    /* renamed from: l */
    public static int m10056l() {
        return f6415k;
    }

    /* renamed from: m */
    public static String m10055m() {
        return f6418n;
    }

    /* renamed from: n */
    public static String m10054n() {
        return f6423s;
    }

    /* renamed from: o */
    public static String m10053o() {
        String str;
        try {
            str = CommonParam.m12426a(f6427w);
        } catch (Exception unused) {
            str = "";
        }
        return str == null ? "" : str;
    }
}
