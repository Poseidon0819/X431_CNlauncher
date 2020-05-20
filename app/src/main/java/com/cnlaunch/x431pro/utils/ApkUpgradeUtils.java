package com.cnlaunch.x431pro.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import com.cnlaunch.p120d.p121a.KeyConstant;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.p131a.Lang;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.x431pro.activity.upgrade.p239b.OnDownloadListener;
import com.cnlaunch.x431pro.activity.upgrade.p239b.OnQueryListener;
import com.cnlaunch.x431pro.activity.upgrade.p240c.ApkUpgradeAndDownloadLogic;
import com.cnlaunch.x431pro.activity.upgrade.p240c.C2670g;
import com.cnlaunch.x431pro.activity.upgrade.p240c.DialogC2669f;
import com.cnlaunch.x431pro.module.config.ConfigDBManager;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;
import com.ifoer.expedition.pro.R;
import java.io.File;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* renamed from: com.cnlaunch.x431pro.utils.b */
/* loaded from: classes.dex */
public final class ApkUpgradeUtils {

    /* renamed from: a */
    public static ApkUpgradeUtils f15716a;

    /* renamed from: b */
    public Context f15717b;

    /* renamed from: c */
    public Handler f15718c = null;

    /* renamed from: d */
    private MessageDialog f15719d;

    /* renamed from: a */
    public static synchronized ApkUpgradeUtils m5111a(Context context) {
        ApkUpgradeUtils apkUpgradeUtils;
        synchronized (ApkUpgradeUtils.class) {
            if (f15716a == null) {
                f15716a = new ApkUpgradeUtils(context);
            }
            apkUpgradeUtils = f15716a;
        }
        return apkUpgradeUtils;
    }

    private ApkUpgradeUtils(Context context) {
        this.f15717b = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x016a  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m5108a(boolean r12) {
        /*
            Method dump skipped, instructions count: 441
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.x431pro.utils.ApkUpgradeUtils.m5108a(boolean):void");
    }

    /* renamed from: a */
    public static String m5112a() {
        return C2744aa.m5125r() ? LangManager.m9467a(Lang.f7199H) : LangManager.m9467a(Lang.f7203a);
    }

    /* renamed from: b */
    public static String m5107b() {
        return C2744aa.m5125r() ? Lang.f7199H : Lang.f7203a;
    }

    /* renamed from: b */
    public static String m5106b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: c */
    public static boolean m5104c() {
        Exception e;
        boolean z;
        try {
            z = new File("/system/xbin/per-up").exists();
            try {
                NLog.m9456a("yhx", "isRoot = ".concat(String.valueOf(z)));
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return z;
            }
        } catch (Exception e3) {
            e = e3;
            z = false;
        }
        return z;
    }

    /* renamed from: a */
    public static void m5110a(Context context, int i) {
        int i2;
        String str;
        NLog.m9456a("yhx", "showApkInstallMessage enter,returnCode=".concat(String.valueOf(i)));
        String m9591a = PreferencesManager.m9595a(context).m9591a("apk_soft_name");
        if (i != 1) {
            switch (i) {
                case -7:
                    i2 = R.string.install_failed_update_incompatible;
                    break;
                case -6:
                    i2 = R.string.install_failed_no_shared_user;
                    break;
                case -5:
                    i2 = R.string.install_failed_duplicate_package;
                    break;
                case -4:
                    i2 = R.string.install_failed_insufficient_storage;
                    break;
                case -3:
                    i2 = R.string.install_failed_invalid_uri;
                    break;
                case -2:
                    i2 = R.string.install_failed_invalid_apk;
                    break;
                case -1:
                    i2 = R.string.install_failed_already_exists;
                    break;
                default:
                    i2 = R.string.install_failed;
                    break;
            }
        } else {
            i2 = R.string.install_succeeded;
        }
        if (i == -116) {
            str = m9591a + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + context.getResources().getString(R.string.net_exception_tips);
        } else {
            str = m9591a + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + context.getResources().getString(R.string.show_error_code) + context.getResources().getString(i2) + "\n" + context.getResources().getString(R.string.failed_code) + i;
        }
        new DialogC2777j(context).m4669a(context.getResources().getString(R.string.install), str);
    }

    /* renamed from: c */
    public static void m5103c(Context context) {
        if (PreferencesManager.m9595a(context).m9585b("auto_download_select", 0) != 0 || !C2778n.m4892g(context)) {
            ApkUpgradeAndDownloadLogic.m5636a(context).m5634a((OnQueryListener) null);
        } else {
            ApkUpgradeAndDownloadLogic.m5636a(context).m5635a((OnDownloadListener) null, false);
        }
    }

    /* renamed from: d */
    public static String m5101d(Context context) {
        ConfigDBManager m5398a = ConfigDBManager.m5398a(context);
        String str = "";
        try {
            if (PreferencesManager.m9595a(context).m9583b("enable_breakpointresume", false)) {
                str = m5398a.m5396a(KeyConstant.f6831ae);
            } else {
                str = m5398a.m5396a(KeyConstant.f6830ad);
            }
        } catch (C1425f e) {
            e.printStackTrace();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m5109a(ApkUpgradeUtils apkUpgradeUtils) {
        ApkUpgradeAndDownloadLogic m5636a = ApkUpgradeAndDownloadLogic.m5636a(apkUpgradeUtils.f15717b);
        Context context = apkUpgradeUtils.f15717b;
        C2776i c2776i = new C2776i(apkUpgradeUtils, m5636a);
        m5636a.f15263g = new DialogC2669f(m5636a, context, c2776i);
        m5636a.f15263g.setTitle(R.string.update_apk);
        m5636a.f15263g.setCanceledOnTouchOutside(false);
        m5636a.f15263g.show();
        m5636a.m5635a((OnDownloadListener) new C2670g(m5636a, c2776i), true);
    }
}
