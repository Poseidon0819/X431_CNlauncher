package com.cnlaunch.x431pro.p210a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p167h.C1673a;
import com.ifoer.expedition.pro.R;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.a.d */
/* loaded from: classes.dex */
public final class CommonTools {
    /* renamed from: a */
    public static boolean m7969a(Context context) {
        if (PreferencesManager.m9595a(context).m9584b("login_state", "0").equals("1")) {
            return true;
        }
        NToast.m9450a(context, (int) R.string.login_tip);
        return false;
    }

    /* renamed from: b */
    public static boolean m7966b(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    /* renamed from: c */
    public static void m7965c(Context context) {
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < installedPackages.size(); i++) {
            arrayList.add(installedPackages.get(i).packageName);
        }
        Uri parse = Uri.parse("https://online.repcotrade.com.au/Portal/");
        Intent intent = new Intent();
        if (arrayList.contains("com.android.chrome")) {
            intent.setData(parse);
            intent.setClassName("com.android.chrome", "com.google.android.apps.chrome.Main");
        } else if (arrayList.contains("com.android.browser")) {
            intent.setData(parse);
            intent.setAction("android.intent.action.VIEW");
            intent.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
        } else {
            NToast.m9450a(context, (int) R.string.identifix_no_browser);
            return;
        }
        context.startActivity(intent);
    }

    /* renamed from: a */
    public static void m7968a(String str, String str2) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.append((CharSequence) str2);
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
            C1673a m8965a = C1673a.m8965a();
            m8965a.m8964a("writeFile() e:" + e.getMessage());
        }
    }

    /* renamed from: a */
    public static boolean m7970a() {
        String str = Build.MANUFACTURER;
        if (str.equals("LENOVO") || str.equals("QUALCOMM") || str.equals("alps")) {
            String str2 = Build.MODEL;
            String str3 = Build.DISPLAY;
            if (str2.contains("X30") && (str3.contains("_YZ") || str3.contains("_HFT") || str3.contains("_JLC") || str3.contains("_UK") || str3.contains("_SCP"))) {
                return true;
            }
            if ((str2.contains("TB-8504F") && str3.contains("_YZ")) || str3.contains("_SCP")) {
                return true;
            }
            return (str2.contains("TB-X304") && (str3.contains("_YZ") || str3.contains("PICC") || str3.contains("_SCP"))) || str2.contains("TB-X704N") || str2.contains("X304N") || str2.contains("X304F") || str2.contains("X704N ") || str2.contains("8504F") || str2.contains("X-431 PRO V4.0");
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m7967b() {
        boolean z;
        String str = Build.MANUFACTURER;
        if (str.equals("LENOVO") || str.equals("QUALCOMM")) {
            String str2 = Build.MODEL;
            String str3 = Build.DISPLAY;
            z = str2.contains("8505F");
        } else {
            z = false;
        }
        NLog.m9456a("yhx", "isLenovo850F.result = ".concat(String.valueOf(z)));
        return z;
    }
}
