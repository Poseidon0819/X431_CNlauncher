package com.cnlaunch.x431pro.utils;

import android.content.Context;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.activity.GDApplication;
import com.cnlaunch.x431pro.utils.p286f.CarIconUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

/* renamed from: com.cnlaunch.x431pro.utils.u */
/* loaded from: classes.dex */
public class PathUtils {

    /* renamed from: a */
    public static String f15921a = "X-431 PAD II";

    /* renamed from: b */
    public static String f15922b = "VEHICLES";

    /* renamed from: c */
    private static final String f15923c = "u";

    /* renamed from: d */
    private static String f15924d = "cnlaunch";

    /* renamed from: e */
    private static String f15925e = "zipFile";

    /* renamed from: f */
    private static String f15926f = "unZip";

    /* renamed from: g */
    private static String f15927g = "images";

    /* renamed from: h */
    private static String f15928h = "downloadZip";

    /* renamed from: i */
    private static String f15929i = "DIAGNOSTIC";

    /* renamed from: j */
    private static String f15930j = "upgrade";

    /* renamed from: k */
    private static String f15931k = "assets";

    /* renamed from: l */
    private static String f15932l = "repairinfo";

    /* renamed from: m */
    private static String f15933m = "remotediag";

    /* renamed from: n */
    private static String f15934n = "Log";

    /* renamed from: o */
    private static String f15935o = "DiagnoseLog";

    /* renamed from: p */
    private static String f15936p = "Log/SpecificDiagnoseLog";

    /* renamed from: q */
    private static String f15937q = "checkServer";

    /* renamed from: r */
    private static String f15938r = "LogZip";

    /* renamed from: s */
    private static String f15939s = "SpeLogZip";

    /* renamed from: t */
    private static String f15940t = "apkDownLoad";

    /* renamed from: u */
    private CarIconUtils f15941u;

    public PathUtils(Context context) {
        this.f15941u = new CarIconUtils(context);
    }

    /* renamed from: a */
    public static String m4871a() {
        return (f15921a.equalsIgnoreCase("X431Pro") || f15921a.equalsIgnoreCase("ScanPad071")) ? m4839q() : Environment.getExternalStorageDirectory().getPath();
    }

    /* renamed from: q */
    private static String m4839q() {
        String path = Environment.getExternalStorageDirectory().getPath();
        if (Environment.isExternalStorageRemovable()) {
            if (GDApplication.f10694b != null) {
                StorageManager storageManager = (StorageManager) GDApplication.f10694b.getSystemService("storage");
                try {
                    String[] strArr = (String[]) storageManager.getClass().getMethod("getVolumePaths", new Class[0]).invoke(storageManager, new Object[0]);
                    return strArr.length > 1 ? strArr[1] : path;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    return null;
                } catch (IllegalArgumentException e2) {
                    e2.printStackTrace();
                    return null;
                } catch (NoSuchMethodException e3) {
                    e3.printStackTrace();
                    return null;
                } catch (InvocationTargetException e4) {
                    e4.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return path;
    }

    /* renamed from: b */
    public static String m4862b() {
        return m4863a(m4871a(), f15924d);
    }

    /* renamed from: a */
    public static String m4869a(Context context, String str) {
        return m4863a(m4851e(context, str), str);
    }

    /* renamed from: c */
    public static String m4858c() {
        return C2744aa.m5175b() ? m4862b() : m4863a(m4862b(), f15921a);
    }

    /* renamed from: d */
    public static String m4855d() {
        return m4863a(m4858c(), f15927g);
    }

    /* renamed from: e */
    public static String m4852e() {
        return m4863a(m4858c(), f15928h);
    }

    /* renamed from: b */
    public static String m4861b(Context context, String str) {
        return m4863a(m4851e(context, str), str, f15929i, f15922b);
    }

    /* renamed from: f */
    public static String m4850f() {
        return m4863a(m4858c(), f15934n, f15935o);
    }

    /* renamed from: g */
    public static String m4849g() {
        return m4863a(m4862b(), f15938r);
    }

    /* renamed from: h */
    public static String m4848h() {
        return m4863a(m4858c(), f15936p);
    }

    /* renamed from: i */
    public static String m4847i() {
        return m4863a(m4862b(), f15939s);
    }

    /* renamed from: j */
    public static String m4846j() {
        return m4863a(m4858c(), f15931k);
    }

    /* renamed from: a */
    public static String m4870a(Context context) {
        String[] strArr = new String[2];
        String m4916a = C2778n.m4916a(context, "package_path");
        if (!TextUtils.isEmpty(m4916a)) {
            NLog.m9451c(f15923c, "package_path: ".concat(String.valueOf(m4916a)));
        } else {
            m4916a = f15921a;
        }
        strArr[0] = C2744aa.m5175b() ? m4862b() : m4863a(m4862b(), m4916a);
        strArr[1] = f15931k;
        return m4863a(strArr);
    }

    /* renamed from: c */
    public static String m4857c(Context context, String str) {
        return m4863a(m4851e(context, str), f15931k);
    }

    /* renamed from: k */
    public static String m4845k() {
        return m4863a(m4858c(), f15932l);
    }

    /* renamed from: l */
    public static String m4844l() {
        return m4863a(m4858c(), f15937q);
    }

    /* renamed from: m */
    public static String m4843m() {
        return m4863a(m4862b(), "temp");
    }

    /* renamed from: a */
    public static String m4863a(String... strArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            try {
                if (!TextUtils.isEmpty(strArr[i])) {
                    sb.append(strArr[i]);
                    if (i < strArr.length - 1) {
                        sb.append("/");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        File file = new File(sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        return sb.toString() + "/";
    }

    /* renamed from: d */
    public static String m4854d(Context context, String str) {
        return m4869a(context, str) + File.separator;
    }

    /* renamed from: a */
    public final String m4864a(String str, String str2, String str3) {
        String m4859b = m4859b(str, str2, str3);
        String m4871a = m4871a();
        String replace = m4859b.contains(m4871a) ? m4859b.replace(m4871a, "") : "";
        NLog.m9456a(f15923c, "softLibPath=".concat(String.valueOf(replace)));
        return replace;
    }

    /* renamed from: b */
    public final String m4859b(String str, String str2, String str3) {
        this.f15941u.m4967b();
        String m4863a = m4863a(m4858c(), this.f15941u.m4964b(str, str2), str3);
        NLog.m9456a(f15923c, "theVersionPath=".concat(String.valueOf(m4863a)));
        return m4863a;
    }

    /* renamed from: a */
    public static boolean m4866a(String str) {
        try {
            String replaceAll = (m4871a() + str).replaceAll("//", "/");
            FileInputStream fileInputStream = new FileInputStream(new File(replaceAll + "Funcfg.so"));
            String m4867a = m4867a(fileInputStream, "ACT_BUTTON");
            fileInputStream.close();
            return m4867a.equals("1;");
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a */
    private static String m4867a(InputStream inputStream, String str) {
        try {
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties.getProperty(str);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: n */
    public static String m4842n() {
        return C2744aa.m5175b() ? m4862b() : m4863a(m4858c(), "DIAGNOSTIC");
    }

    /* renamed from: o */
    public static String m4841o() {
        return m4863a(m4858c(), "DevLog", "golo");
    }

    /* renamed from: e */
    public static String m4851e(Context context, String str) {
        String m4863a = m4863a(m4862b(), f15921a);
        return (!TextUtils.isEmpty(str) && str.startsWith(PreferencesManager.m9595a(context).m9591a("serialNo_Prefix")) && C2744aa.m5175b()) ? m4862b() : m4863a;
    }

    /* renamed from: b */
    public static boolean m4860b(String str) {
        NLog.m9456a("yhx", "getDocBoolean enter,path=".concat(String.valueOf(str)));
        try {
            String replaceAll = str.replaceAll("//", "/");
            FileInputStream fileInputStream = new FileInputStream(new File(replaceAll + "Funcfg.so"));
            String m4867a = m4867a(fileInputStream, "STATE");
            NLog.m9456a("yhx", "getDocBoolean enter,str=".concat(String.valueOf(m4867a)));
            fileInputStream.close();
            return m4867a.equals("1;");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: c */
    public static boolean m4856c(String str) {
        try {
            String replaceAll = (m4871a() + str).replaceAll("//", "/");
            FileInputStream fileInputStream = new FileInputStream(new File(replaceAll + "Funcfg.so"));
            String m4867a = m4867a(fileInputStream, "SetDiagMenuTitle");
            fileInputStream.close();
            return m4867a.equals("1;");
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a */
    public static String m4868a(Context context, String str, String str2) {
        NLog.m9456a("yhx", "getTheSoftDivisionPath enter, serialNo=" + str + ",softPackageId=" + str2);
        String str3 = "";
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (str2.toUpperCase().contains("RESET")) {
                str3 = m4863a(m4861b(context, str), "RESET_DIVISION");
            } else {
                String m4964b = CarIconUtils.m4977a(context).m4964b(str, str2);
                if (TextUtils.isEmpty(m4964b)) {
                    m4964b = m4863a(m4861b(context, str).replace(m4858c(), ""), str2);
                }
                str3 = m4863a(m4858c(), m4964b, "Division");
            }
        }
        NLog.m9456a("yhx", "getTheSoftDivisionPath exit, divisionPath=".concat(String.valueOf(str3)));
        return str3;
    }

    /* renamed from: p */
    public static String m4840p() {
        return m4858c() + "vciCategory.ini";
    }

    /* renamed from: a */
    public static boolean m4865a(String str, String str2) {
        try {
            String replaceAll = (m4871a() + str).replaceAll("//", "/");
            FileInputStream fileInputStream = new FileInputStream(new File(replaceAll + "Funcfg.so"));
            String m4867a = m4867a(fileInputStream, str2);
            fileInputStream.close();
            if (!TextUtils.isEmpty(m4867a)) {
                if (!m4867a.equals("0;")) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: d */
    public static boolean m4853d(String str) {
        try {
            String replaceAll = (m4871a() + str).replaceAll("//", "/");
            FileInputStream fileInputStream = new FileInputStream(new File(replaceAll + "Funcfg.so"));
            String m4867a = m4867a(fileInputStream, "RESCAN");
            fileInputStream.close();
            return m4867a.equals("1;");
        } catch (Exception unused) {
            return false;
        }
    }
}
