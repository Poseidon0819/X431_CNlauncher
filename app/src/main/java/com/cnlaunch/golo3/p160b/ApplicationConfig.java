package com.cnlaunch.golo3.p160b;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Environment;
import android.os.Handler;
import com.cnlaunch.golo3.p165g.ThreadPoolManager;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* renamed from: com.cnlaunch.golo3.b.a */
/* loaded from: classes.dex */
public class ApplicationConfig {

    /* renamed from: B */
    private static HashMap<String, String> f7798B = null;

    /* renamed from: C */
    private static String f7799C = "";

    /* renamed from: D */
    private static String f7800D = "";

    /* renamed from: a */
    public static Context f7802a = null;

    /* renamed from: b */
    public static Resources f7803b = null;

    /* renamed from: c */
    public static String f7804c = null;

    /* renamed from: d */
    public static Handler f7805d = null;

    /* renamed from: e */
    public static boolean f7806e = false;

    /* renamed from: f */
    public static boolean f7807f = false;

    /* renamed from: g */
    public static boolean f7808g = false;

    /* renamed from: h */
    public static String f7809h = "";

    /* renamed from: i */
    public static String f7810i = "";

    /* renamed from: j */
    public static String f7811j = "";

    /* renamed from: k */
    public static String f7812k = "http://base.api.dbscar.com";

    /* renamed from: l */
    public static String f7813l = "721";

    /* renamed from: m */
    public static String f7814m = "141";

    /* renamed from: n */
    public static boolean f7815n = false;

    /* renamed from: o */
    public static String f7816o = "";

    /* renamed from: p */
    public static String f7817p = "151";

    /* renamed from: q */
    public static String f7818q = "2014042900000007";

    /* renamed from: r */
    public static String f7819r = "967790200455";

    /* renamed from: s */
    public static final String f7820s = Environment.getExternalStorageDirectory().getPath();

    /* renamed from: t */
    public static String f7821t = "0102030405060708";

    /* renamed from: u */
    public static String f7822u = "DECODE";

    /* renamed from: v */
    public static String f7823v = "ENCODE";

    /* renamed from: w */
    public static boolean f7824w = false;

    /* renamed from: x */
    public static String f7825x = "";

    /* renamed from: y */
    public static String f7826y = "0";

    /* renamed from: z */
    public static String f7827z = "0";

    /* renamed from: E */
    private static String f7801E = "0";

    /* renamed from: A */
    public static String f7797A = "";

    /* renamed from: a */
    public static void m9179a(String str, String str2) {
        f7799C = str;
        f7800D = str2;
    }

    /* renamed from: a */
    public static String m9181a() {
        return f7799C;
    }

    /* renamed from: b */
    public static String m9178b() {
        return f7800D;
    }

    /* renamed from: a */
    public static void m9180a(Context context, Properties properties) throws NullPointerException {
        if (context == null) {
            throw new NullPointerException("context is not null");
        }
        f7802a = context;
        f7803b = context.getResources();
        f7804c = context.getPackageName();
        f7805d = new Handler();
        try {
            f7816o = context.getPackageManager().getPackageInfo(f7804c, 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (properties == null || properties.isEmpty()) {
            throw new NullPointerException("config info is not null");
        }
        f7798B = new HashMap<>(properties.size());
        for (Map.Entry entry : properties.entrySet()) {
            f7798B.put(entry.getKey().toString(), entry.getValue().toString());
        }
        if (properties.containsKey("x431_golo_diag_app_id")) {
            f7814m = properties.getProperty("x431_golo_diag_app_id");
        }
        if (f7815n) {
            f7814m = "1522";
        }
        if (properties.containsKey("debug")) {
            f7807f = properties.getProperty("debug").equals("1");
        }
        if (properties.containsKey("log")) {
            f7808g = properties.getProperty("log").equals("1");
        }
        ThreadPoolManager.m9119a(ApplicationConfig.class.getName()).m9120a(new RunnableC1596b());
    }
}
