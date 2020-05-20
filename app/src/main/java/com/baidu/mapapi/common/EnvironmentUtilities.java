package com.baidu.mapapi.common;

import android.content.Context;
import com.baidu.mapsdkplatform.comapi.util.C1303d;
import java.io.File;

/* loaded from: classes.dex */
public class EnvironmentUtilities {

    /* renamed from: a */
    static String f4875a;

    /* renamed from: b */
    static String f4876b;

    /* renamed from: c */
    static String f4877c;

    /* renamed from: d */
    static int f4878d;

    /* renamed from: e */
    static int f4879e;

    /* renamed from: f */
    static int f4880f;

    /* renamed from: g */
    private static C1303d f4881g;

    public static String getAppCachePath() {
        return f4876b;
    }

    public static String getAppSDCardPath() {
        String str = f4875a + "/BaiduMapSDKNew";
        if (str.length() != 0) {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return str;
    }

    public static String getAppSecondCachePath() {
        return f4877c;
    }

    public static int getDomTmpStgMax() {
        return f4879e;
    }

    public static int getItsTmpStgMax() {
        return f4880f;
    }

    public static int getMapTmpStgMax() {
        return f4878d;
    }

    public static String getSDCardPath() {
        return f4875a;
    }

    public static void initAppDirectory(Context context) {
        String m10085c;
        if (f4881g == null) {
            C1303d m10083a = C1303d.m10083a();
            f4881g = m10083a;
            m10083a.m10082a(context);
        }
        String str = f4875a;
        if (str == null || str.length() <= 0) {
            f4875a = f4881g.m10079b().m10087a();
            m10085c = f4881g.m10079b().m10085c();
        } else {
            m10085c = f4875a + File.separator + "BaiduMapSDKNew" + File.separator + "cache";
        }
        f4876b = m10085c;
        f4877c = f4881g.m10079b().m10084d();
        f4878d = 20971520;
        f4879e = 52428800;
        f4880f = 5242880;
    }

    public static void setSDCardPath(String str) {
        f4875a = str;
    }
}
