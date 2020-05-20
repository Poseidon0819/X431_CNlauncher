package com.cnlaunch.x431pro.activity;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.support.p011b.MultiDex;
import android.support.p011b.MultiDexApplication;
import android.text.TextUtils;
import android.util.Log;
import com.cnlaunch.golo3.p160b.ApplicationConfig;
import com.cnlaunch.p120d.p121a.AppCrashHandler;
import com.cnlaunch.p120d.p121a.CacheManager;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.p169im.GoloApplication;
import com.cnlaunch.physics.p205k.DeviceProperties;
import com.cnlaunch.x431pro.module.p242ad.AdUtil;
import com.cnlaunch.x431pro.module.p245c.p246a.CrashAction;
import com.cnlaunch.x431pro.p210a.C1947h;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.C2778n;
import com.cnlaunch.x431pro.utils.C2787z;
import com.cnlaunch.x431pro.utils.DataCleanManager;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.launch.p353a.p364k.LUAsdk;
import com.p297e.p298a.p299a.p300a.p303b.Md5FileNameGenerator;
import com.p297e.p298a.p306b.ImageLoader;
import com.p297e.p298a.p306b.ImageLoaderConfiguration;
import com.p297e.p298a.p306b.p307a.QueueProcessingType;
import com.p297e.p298a.p315c.L;
import java.io.File;
import java.io.FileNotFoundException;

/* loaded from: classes.dex */
public class GDApplication extends MultiDexApplication {

    /* renamed from: a */
    public static boolean f10693a = false;

    /* renamed from: b */
    public static Context f10694b = null;

    /* renamed from: c */
    public static Handler f10695c = null;

    /* renamed from: d */
    public static String f10696d = "93b42fb2eb0b4f1db3c2b2e2e42b9a23";

    /* renamed from: e */
    private final String f10697e = GDApplication.class.getSimpleName();

    /* renamed from: c */
    public static boolean m7908c() {
        return false;
    }

    @Override // android.app.Application
    public void onCreate() {
        f10695c = new Handler();
        f10694b = this;
        MultiDex.m15264a(this);
        try {
            Class.forName("android.os.AsyncTask");
        } catch (Exception e) {
            e.printStackTrace();
        }
        ApplicationConfig.f7804c = getApplicationContext().getPackageName();
        if (C2744aa.m5144h(f10694b)) {
            ApplicationConfig.f7815n = false;
            ApplicationConfig.f7814m = "151";
        } else {
            ApplicationConfig.f7815n = true;
            ApplicationConfig.f7814m = "1522";
        }
        CacheManager.m9604a(getFilesDir().getPath());
        String m4916a = C2778n.m4916a(getApplicationContext(), "clean_app_data_switch");
        boolean booleanValue = !TextUtils.isEmpty(m4916a) ? Boolean.valueOf(m4916a).booleanValue() : false;
        boolean m9583b = PreferencesManager.m9595a(f10694b).m9583b("is_clean_app_data", false);
        if (booleanValue && !m9583b) {
            Context context = f10694b;
            DataCleanManager.m4884a(context.getCacheDir());
            if (Environment.getExternalStorageState().equals("mounted")) {
                DataCleanManager.m4884a(context.getExternalCacheDir());
            }
            DataCleanManager.m4884a(new File("/data/data/" + context.getPackageName() + "/databases"));
            PreferencesManager.m9595a(context).f7021a.edit().clear().commit();
            DataCleanManager.m4884a(new File("/data/data/" + context.getPackageName() + "/shared_prefs"));
            DataCleanManager.m4884a(context.getFilesDir());
            PreferencesManager.m9595a(f10694b).m9587a("is_clean_app_data", true);
        }
        String m4916a2 = C2778n.m4916a(getApplicationContext(), "debug");
        if (!TextUtils.isEmpty(m4916a2)) {
            f10693a = Boolean.parseBoolean(m4916a2);
            NLog.m9451c(this.f10697e, "isDebug: " + f10693a);
            NLog.m9453a(f10693a);
        }
        String m4916a3 = C2778n.m4916a(getApplicationContext(), "package_path");
        if (!TextUtils.isEmpty(m4916a3)) {
            NLog.m9451c(this.f10697e, "package_path: ".concat(String.valueOf(m4916a3)));
            PathUtils.f15921a = m4916a3;
            DeviceProperties.m8158a(m4916a3);
            AppCrashHandler.m9609a(m4916a3);
        }
        String m4916a4 = C2778n.m4916a(getApplicationContext(), "serialNo_Prefix");
        if (!TextUtils.isEmpty(m4916a4)) {
            NLog.m9451c(this.f10697e, "serialNo_Prefix: ".concat(String.valueOf(m4916a4)));
            PreferencesManager.m9595a(getApplicationContext()).m9588a("serialNo_Prefix", m4916a4);
        }
        String m4916a5 = C2778n.m4916a(getApplicationContext(), "serialNo_debug_Prefix");
        if (!TextUtils.isEmpty(m4916a5)) {
            NLog.m9451c(this.f10697e, "serialNo_Prefix_debug: ".concat(String.valueOf(m4916a5)));
            PreferencesManager.m9595a(getApplicationContext()).m9588a("serialNo_debug_Prefix", m4916a5);
        }
        String m4916a6 = C2778n.m4916a(getApplicationContext(), "productType");
        if (!TextUtils.isEmpty(m4916a6)) {
            NLog.m9451c(this.f10697e, "productType: ".concat(String.valueOf(m4916a6)));
            PreferencesManager.m9595a(getApplicationContext()).m9588a("productType", m4916a6);
        }
        String m4916a7 = C2778n.m4916a(getApplicationContext(), "pdt_type");
        if (!TextUtils.isEmpty(m4916a7)) {
            NLog.m9451c(this.f10697e, "pdt_type: ".concat(String.valueOf(m4916a7)));
            PreferencesManager.m9595a(getApplicationContext()).m9588a("pdt_type", m4916a7);
        }
        String m4916a8 = C2778n.m4916a(getApplicationContext(), "productTypeCode");
        if (!TextUtils.isEmpty(m4916a8)) {
            NLog.m9451c(this.f10697e, "productTypeCode: ".concat(String.valueOf(m4916a8)));
            PreferencesManager.m9595a(getApplicationContext()).m9588a("productTypeCode", m4916a8);
        }
        String m4916a9 = C2778n.m4916a(getApplicationContext(), "online_dtc_no_login");
        if (!TextUtils.isEmpty(m4916a9)) {
            PreferencesManager.m9595a(getApplicationContext()).m9587a("online_dtc_no_login", Boolean.parseBoolean(m4916a9));
        }
        String m4916a10 = C2778n.m4916a(getApplicationContext(), "seria_no_product_type");
        if (!TextUtils.isEmpty(m4916a10)) {
            NLog.m9451c(this.f10697e, "SERIA_NO_PRODUCT_TYPE: ".concat(String.valueOf(m4916a10)));
            PreferencesManager.m9595a(getApplicationContext()).m9588a("seria_no_product_type", m4916a10);
        }
        String m4916a11 = C2778n.m4916a(getApplicationContext(), "isRelease");
        if (!TextUtils.isEmpty(m4916a11)) {
            NLog.m9451c(this.f10697e, "isRelease: ".concat(String.valueOf(m4916a11)));
            PreferencesManager.m9595a(getApplicationContext()).m9587a("isRelease", Boolean.parseBoolean(m4916a11));
        }
        String m4916a12 = C2778n.m4916a(getApplicationContext(), "venderCode");
        if (!TextUtils.isEmpty(m4916a12)) {
            NLog.m9451c(this.f10697e, "venderCode: ".concat(String.valueOf(m4916a12)));
            PreferencesManager.m9595a(getApplicationContext()).m9588a("venderCode", m4916a12);
        }
        String m4916a13 = C2778n.m4916a(getApplicationContext(), "diagnose_log_switch");
        if (!TextUtils.isEmpty(m4916a13)) {
            NLog.m9451c(this.f10697e, "diagnoseLog Switch: " + m4916a13 + "Boolean.parseBoolean(diagnoseLogSwitch)=" + Boolean.parseBoolean(m4916a13));
            PreferencesManager.m9595a(getApplicationContext()).m9587a("diagnose_log_switch", Boolean.parseBoolean(m4916a13));
        }
        String m4916a14 = C2778n.m4916a(getApplicationContext(), "is_golo");
        if (!TextUtils.isEmpty(m4916a14)) {
            NLog.m9451c(this.f10697e, "golo Switch: " + m4916a14 + " Boolean.parseBoolean(golo)=" + Boolean.parseBoolean(m4916a14));
            PreferencesManager.m9595a(getApplicationContext()).m9587a("is_golo", Boolean.parseBoolean(m4916a14));
        }
        String m4916a15 = C2778n.m4916a(getApplicationContext(), "is_sort");
        if (!TextUtils.isEmpty(m4916a15)) {
            NLog.m9451c(this.f10697e, "Sort Switch: " + m4916a15 + " Boolean.parseBoolean(Sort)=" + Boolean.parseBoolean(m4916a15));
            PreferencesManager.m9595a(getApplicationContext()).m9587a("is_sort", Boolean.parseBoolean(m4916a15));
        }
        String m4916a16 = C2778n.m4916a(getApplicationContext(), "is_upload_report");
        if (!TextUtils.isEmpty(m4916a16)) {
            NLog.m9451c(this.f10697e, "isUpLoad Switch: " + m4916a16 + " Boolean.parseBoolean(IS_UpLoad_REPORT)=" + Boolean.parseBoolean(m4916a16));
            PreferencesManager.m9595a(getApplicationContext()).m9587a("is_upload_report", Boolean.parseBoolean(m4916a16));
        }
        String m4916a17 = C2778n.m4916a(getApplicationContext(), "is_swing_logo");
        if (!TextUtils.isEmpty(m4916a17)) {
            NLog.m9451c(this.f10697e, "isSwing Switch: " + m4916a17 + " Boolean.parseBoolean(IS_SWING_LOGO)=" + Boolean.parseBoolean(m4916a17));
            PreferencesManager.m9595a(getApplicationContext()).m9587a("is_swing_logo", Boolean.parseBoolean(m4916a17));
        }
        String m4916a18 = C2778n.m4916a(getApplicationContext(), "is_guide");
        if (!TextUtils.isEmpty(m4916a18)) {
            NLog.m9451c(this.f10697e, "IS_GUIDE Switch: " + m4916a17 + " Boolean.parseBoolean(IS_GUIDE)=" + Boolean.parseBoolean(m4916a18));
            PreferencesManager.m9595a(getApplicationContext()).m9587a("is_guide", Boolean.parseBoolean(m4916a18));
        }
        String m4916a19 = C2778n.m4916a(getApplicationContext(), "guide_pages");
        if (!TextUtils.isEmpty(m4916a19)) {
            NLog.m9451c(this.f10697e, "GUIDE_PAGES: ".concat(String.valueOf(m4916a19)));
            PreferencesManager.m9595a(getApplicationContext()).m9590a("guide_pages", C2787z.m4805n(m4916a19));
        }
        String m4916a20 = C2778n.m4916a(getApplicationContext(), "is_themes_colorful");
        if (!TextUtils.isEmpty(m4916a20)) {
            NLog.m9451c(this.f10697e, "isColorful Switch: " + m4916a20 + " Boolean.parseBoolean(isColorful)=" + Boolean.parseBoolean(m4916a20));
            PreferencesManager.m9595a(getApplicationContext()).m9587a("is_themes_colorful", Boolean.parseBoolean(m4916a20));
        }
        String m4916a21 = C2778n.m4916a(getApplicationContext(), "theme_type");
        if (!TextUtils.isEmpty(m4916a21)) {
            NLog.m9451c(this.f10697e, "themeType: ".concat(String.valueOf(m4916a21)));
            PreferencesManager.m9595a(getApplicationContext()).m9590a("theme_type", C2787z.m4805n(m4916a21));
        }
        String m4916a22 = C2778n.m4916a(getApplicationContext(), "is_screen_switch");
        if (!TextUtils.isEmpty(m4916a22)) {
            NLog.m9451c(this.f10697e, "isScreenSwitch Switch: " + m4916a22 + " Boolean.parseBoolean(isScreenSwitch)=" + Boolean.parseBoolean(m4916a22));
            PreferencesManager.m9595a(getApplicationContext()).m9587a("is_screen_switch", Boolean.parseBoolean(m4916a22));
        }
        String m4916a23 = C2778n.m4916a(getApplicationContext(), "need_update_gologuide");
        if (!TextUtils.isEmpty(m4916a23)) {
            NLog.m9451c(this.f10697e, "needUpdategoloGuide Switch: " + m4916a23 + " Boolean.parseBoolean(needUpdategoloGuide)=" + Boolean.parseBoolean(m4916a23));
            PreferencesManager.m9595a(getApplicationContext()).m9587a("need_update_gologuide", Boolean.parseBoolean(m4916a23));
        }
        String m4916a24 = C2778n.m4916a(getApplicationContext(), C1947h.f10555g);
        if (!TextUtils.isEmpty(m4916a24)) {
            NLog.m9451c(this.f10697e, "IS_SHOW_PRINTER_SET Switch: " + m4916a23 + " Boolean.parseBoolean(is_show_printer_set)=" + Boolean.parseBoolean(m4916a24));
            PreferencesManager.m9595a(getApplicationContext()).m9587a(C1947h.f10555g, Boolean.parseBoolean(m4916a24));
        }
        String m4916a25 = C2778n.m4916a(getApplicationContext(), "clear_history_versions_switch");
        if (!TextUtils.isEmpty(m4916a25)) {
            NLog.m9451c(this.f10697e, "CLEAR_HISTORY_VERSIONS_SWITCH: " + m4916a25 + " Boolean.parseBoolean(clear_history_versions_switch)=" + Boolean.parseBoolean(m4916a25));
            PreferencesManager.m9595a(getApplicationContext()).m9587a("clear_history_versions_switch", Boolean.parseBoolean(m4916a25));
        }
        String m4916a26 = C2778n.m4916a(getApplicationContext(), "is_reset_switch");
        if (!TextUtils.isEmpty(m4916a26)) {
            NLog.m9451c(this.f10697e, "isResetSwitch Switch: " + m4916a26 + " Boolean.parseBoolean(isScreenSwitch)=" + Boolean.parseBoolean(m4916a26));
            PreferencesManager.m9595a(getApplicationContext()).m9587a("is_reset_switch", Boolean.parseBoolean(m4916a26));
        }
        String m4916a27 = C2778n.m4916a(getApplicationContext(), "is_provides_search");
        if (!TextUtils.isEmpty(m4916a27)) {
            NLog.m9451c(this.f10697e, "isProvideSearch Switch: " + m4916a27 + " Boolean.parseBoolean(isProvideSearch)=" + Boolean.parseBoolean(m4916a27));
            PreferencesManager.m9595a(getApplicationContext()).m9587a("is_provides_search", Boolean.parseBoolean(m4916a27));
        }
        String m4916a28 = C2778n.m4916a(getApplicationContext(), "is_provides_translation");
        if (!TextUtils.isEmpty(m4916a28)) {
            NLog.m9451c(this.f10697e, "isProvideTranslation Switch: " + m4916a28 + " Boolean.parseBoolean(isProvideTranslation)=" + Boolean.parseBoolean(m4916a28));
            PreferencesManager.m9595a(getApplicationContext()).m9587a("is_provides_translation", Boolean.parseBoolean(m4916a28));
        }
        String m4916a29 = C2778n.m4916a(getApplicationContext(), "is_heavyduty");
        if (!TextUtils.isEmpty(m4916a29)) {
            NLog.m9451c(this.f10697e, "heavyduty Switch: " + m4916a29 + " Boolean.parseBoolean(heavyduty)=" + Boolean.parseBoolean(m4916a29));
            PreferencesManager.m9595a(getApplicationContext()).m9587a("is_heavyduty", Boolean.parseBoolean(m4916a29));
        }
        String m4916a30 = C2778n.m4916a(getApplicationContext(), "heavyduty_serialNo_Prefix");
        if (!TextUtils.isEmpty(m4916a30)) {
            NLog.m9451c(this.f10697e, "heavyduty_serialNo_Prefix: ".concat(String.valueOf(m4916a30)));
            PreferencesManager.m9595a(getApplicationContext()).m9588a("heavyduty_serialNo_Prefix", m4916a30);
        }
        String m4916a31 = C2778n.m4916a(getApplicationContext(), "heavyduty_seria_no_product_type");
        if (!TextUtils.isEmpty(m4916a31)) {
            NLog.m9451c(this.f10697e, "HEAVYDUTY_SERIA_NO_PRODUCT_TYPE: ".concat(String.valueOf(m4916a31)));
            PreferencesManager.m9595a(getApplicationContext()).m9588a("heavyduty_seria_no_product_type", m4916a31);
        }
        String m4916a32 = C2778n.m4916a(getApplicationContext(), "enable_breakpointresume");
        if (!TextUtils.isEmpty(m4916a32)) {
            NLog.m9451c(this.f10697e, "ENABLE_BREAKPOINTRESUME: " + m4916a32 + " Boolean.parseBoolean(ENABLE_BREAKPOINTRESUME)=" + Boolean.parseBoolean(m4916a32));
            PreferencesManager.m9595a(getApplicationContext()).m9587a("enable_breakpointresume", Boolean.parseBoolean(m4916a32));
        }
        String m4916a33 = C2778n.m4916a(getApplicationContext(), "enable_upload_downloadlog");
        if (!TextUtils.isEmpty(m4916a33)) {
            NLog.m9451c(this.f10697e, "ENABLE_UPLOAD_DOWNLOADLOG: " + m4916a33 + " Boolean.parseBoolean(ENABLE_UPLOAD_DOWNLOADLOG)=" + Boolean.parseBoolean(m4916a33));
            PreferencesManager.m9595a(getApplicationContext()).m9587a("enable_upload_downloadlog", Boolean.parseBoolean(m4916a33));
        }
        String m4916a34 = C2778n.m4916a(getApplicationContext(), "enable_history_diagnose");
        if (!TextUtils.isEmpty(m4916a34)) {
            NLog.m9451c(this.f10697e, "ENABLE_HISTORY_DIAGNOSE: " + m4916a34 + " Boolean.parseBoolean(ENABLE_HISTORY_DIAGNOSE)=" + Boolean.parseBoolean(m4916a34));
            PreferencesManager.m9595a(getApplicationContext()).m9587a("enable_history_diagnose", Boolean.parseBoolean(m4916a34));
        }
        String m4916a35 = C2778n.m4916a(getApplicationContext(), "enable_vinscan");
        if (!TextUtils.isEmpty(m4916a35)) {
            NLog.m9451c(this.f10697e, "isEnableVinscan Switch: " + m4916a35 + " Boolean.parseBoolean(isEnableVinscan)=" + Boolean.parseBoolean(m4916a35));
            PreferencesManager.m9595a(getApplicationContext()).m9587a("enable_vinscan", Boolean.parseBoolean(m4916a35));
        }
        String m4916a36 = C2778n.m4916a(getApplicationContext(), "enable_history_diagnose");
        if (!TextUtils.isEmpty(m4916a36)) {
            NLog.m9451c(this.f10697e, "isEnableHistory Switch: " + m4916a36 + " Boolean.parseBoolean(isEnableHistory)=" + Boolean.parseBoolean(m4916a36));
            PreferencesManager.m9595a(getApplicationContext()).m9587a("enable_history_diagnose", Boolean.parseBoolean(m4916a36));
        }
        String m4916a37 = C2778n.m4916a(getApplicationContext(), "clean_app_data_switch");
        if (!TextUtils.isEmpty(m4916a37)) {
            NLog.m9451c(this.f10697e, "clean_app_data_switch: " + m4916a37 + " Boolean.parseBoolean(clean_app_data_switch)=" + Boolean.parseBoolean(m4916a37));
            PreferencesManager.m9595a(getApplicationContext()).m9587a("clean_app_data_switch", Boolean.parseBoolean(m4916a37));
        }
        String m4916a38 = C2778n.m4916a(getApplicationContext(), "new_car_prefix");
        if (!TextUtils.isEmpty(m4916a38)) {
            NLog.m9451c(this.f10697e, "newCarPrefix=: ".concat(String.valueOf(m4916a38)));
            PreferencesManager.m9595a(getApplicationContext()).m9588a("new_car_prefix", m4916a38);
        }
        String m4916a39 = C2778n.m4916a(getApplicationContext(), "car_and_heavyduty_prefix");
        if (!TextUtils.isEmpty(m4916a39)) {
            NLog.m9451c(this.f10697e, "carAndHeavydutyPrefix=: ".concat(String.valueOf(m4916a39)));
            PreferencesManager.m9595a(getApplicationContext()).m9588a("car_and_heavyduty_prefix", m4916a39);
        }
        String m4916a40 = C2778n.m4916a(getApplicationContext(), "car_and_heavyduty_product_type");
        if (!TextUtils.isEmpty(m4916a40)) {
            NLog.m9451c(this.f10697e, "carAndHeavydutyProductType=: ".concat(String.valueOf(m4916a40)));
            PreferencesManager.m9595a(getApplicationContext()).m9588a("car_and_heavyduty_product_type", m4916a40);
        }
        String m4916a41 = C2778n.m4916a(getApplicationContext(), "new_car_product_type");
        if (!TextUtils.isEmpty(m4916a41)) {
            NLog.m9451c(this.f10697e, "newCarProductType=: ".concat(String.valueOf(m4916a41)));
            PreferencesManager.m9595a(getApplicationContext()).m9588a("new_car_product_type", m4916a41);
        }
        String m4916a42 = C2778n.m4916a(getApplicationContext(), "upgrade_center_version");
        if (!TextUtils.isEmpty(m4916a42)) {
            NLog.m9451c(this.f10697e, "upgradeVersion=: ".concat(String.valueOf(m4916a42)));
            PreferencesManager.m9595a(getApplicationContext()).m9588a("upgrade_center_version", m4916a42);
        }
        if (C2744aa.m5121t()) {
            PreferencesManager.m9595a((Context) this).m9587a("is_x30_or_a8050_device", true);
        } else {
            PreferencesManager.m9595a((Context) this).m9587a("is_x30_or_a8050_device", false);
        }
        String m4916a43 = C2778n.m4916a(getApplicationContext(), "link_mode_serialport_switch");
        if (!TextUtils.isEmpty(m4916a43)) {
            Log.e(this.f10697e, "serialport switch=: ".concat(String.valueOf(m4916a43)));
            PreferencesManager.m9595a(getApplicationContext()).m9587a("link_mode_serialport_switch", Boolean.parseBoolean(m4916a43));
        }
        String m4916a44 = C2778n.m4916a(getApplicationContext(), "wifi_support_serialno_prefix");
        if (!TextUtils.isEmpty(m4916a44)) {
            Log.e(this.f10697e, "wifi support serialno prefix=: ".concat(String.valueOf(m4916a44)));
            PreferencesManager.m9595a(getApplicationContext()).m9587a("wifi_support_serialno_prefix", Boolean.parseBoolean(m4916a43));
        }
        String m4916a45 = C2778n.m4916a(getApplicationContext(), "enable_online_service");
        if (!TextUtils.isEmpty(m4916a45)) {
            Log.e(this.f10697e, "enable_online_service= ".concat(String.valueOf(m4916a45)));
            PreferencesManager.m9595a(getApplicationContext()).m9587a("enable_online_service", Boolean.parseBoolean(m4916a45) && LangManager.m9466b().equalsIgnoreCase("CN"));
        }
        String m4916a46 = C2778n.m4916a(getApplicationContext(), "is_cnlaunch_root");
        if (!TextUtils.isEmpty(m4916a46)) {
            Log.e(this.f10697e, "is_cnlaunch_root= ".concat(String.valueOf(m4916a46)));
            PreferencesManager.m9595a(getApplicationContext()).m9587a("is_cnlaunch_root", Boolean.parseBoolean(m4916a46));
        }
        String m4916a47 = C2778n.m4916a(getApplicationContext(), "is_usa_project");
        if (!TextUtils.isEmpty(m4916a47)) {
            Log.e(this.f10697e, "is_usa_project= ".concat(String.valueOf(m4916a47)));
            PreferencesManager.m9595a(getApplicationContext()).m9587a("is_usa_project", Boolean.parseBoolean(m4916a47));
        }
        String m4916a48 = C2778n.m4916a(getApplicationContext(), "is_euro_project");
        if (!TextUtils.isEmpty(m4916a48)) {
            Log.e(this.f10697e, "is_euro_project= ".concat(String.valueOf(m4916a48)));
            PreferencesManager.m9595a(getApplicationContext()).m9587a("is_euro_project", Boolean.parseBoolean(m4916a48));
        }
        String m4916a49 = C2778n.m4916a(getApplicationContext(), "is_japan_project");
        if (!TextUtils.isEmpty(m4916a49)) {
            Log.e(this.f10697e, "is_japan_project= ".concat(String.valueOf(m4916a49)));
            PreferencesManager.m9595a(getApplicationContext()).m9587a("is_japan_project", Boolean.parseBoolean(m4916a49));
        }
        String m4916a50 = C2778n.m4916a(getApplicationContext(), "is_scanpad_project");
        if (!TextUtils.isEmpty(m4916a50)) {
            Log.e(this.f10697e, "is_scanpad_project= ".concat(String.valueOf(m4916a50)));
            PreferencesManager.m9595a(getApplicationContext()).m9587a("is_scanpad_project", Boolean.parseBoolean(m4916a50));
        }
        String m4916a51 = C2778n.m4916a(getApplicationContext(), "is_ynht_project");
        if (!TextUtils.isEmpty(m4916a51)) {
            Log.e(this.f10697e, "is_ynht_project= ".concat(String.valueOf(m4916a51)));
            PreferencesManager.m9595a(getApplicationContext()).m9587a("is_ynht_project", Boolean.parseBoolean(m4916a51));
        }
        String m4916a52 = C2778n.m4916a(getApplicationContext(), "is_reserve_seller");
        if (!TextUtils.isEmpty(m4916a52)) {
            Log.e(this.f10697e, "is_reserve_seller= ".concat(String.valueOf(m4916a52)));
            PreferencesManager.m9595a(getApplicationContext()).m9587a("is_reserve_seller", Boolean.parseBoolean(m4916a52));
        }
        String m4916a53 = C2778n.m4916a(getApplicationContext(), "is_left_enter_golousa");
        if (!TextUtils.isEmpty(m4916a53)) {
            Log.e(this.f10697e, "is_left_enter_golousa= ".concat(String.valueOf(m4916a53)));
            PreferencesManager.m9595a(getApplicationContext()).m9587a("is_left_enter_golousa", Boolean.parseBoolean(m4916a53));
        }
        String m4916a54 = C2778n.m4916a(getApplicationContext(), "is_support_advertise");
        if (!TextUtils.isEmpty(m4916a54)) {
            Log.e(this.f10697e, "is_support_advertise= ".concat(String.valueOf(m4916a54)));
            PreferencesManager.m9595a(getApplicationContext()).m9587a("is_support_advertise", Boolean.parseBoolean(m4916a54));
        }
        String m4916a55 = C2778n.m4916a(getApplicationContext(), "enable_paypal_pincard");
        if (!TextUtils.isEmpty(m4916a55)) {
            Log.e(this.f10697e, "enable_paypal_pincard= ".concat(String.valueOf(m4916a55)));
            PreferencesManager.m9595a(getApplicationContext()).m9587a("enable_paypal_pincard", Boolean.parseBoolean(m4916a55));
            String m4916a56 = C2778n.m4916a(getApplicationContext(), "report_style_table");
            if (!TextUtils.isEmpty(m4916a56)) {
                PreferencesManager.m9595a(getApplicationContext()).m9587a("report_style_table", Boolean.parseBoolean(m4916a56));
            }
            String m4916a57 = C2778n.m4916a(getApplicationContext(), "is_division_upgrade_show");
            if (!TextUtils.isEmpty(m4916a57)) {
                PreferencesManager.m9595a(getApplicationContext()).m9587a("is_division_upgrade_show", Boolean.parseBoolean(m4916a57));
            }
        }
        String m4916a58 = C2778n.m4916a(getApplicationContext(), "is_sp_aus");
        if (!TextUtils.isEmpty(m4916a58)) {
            PreferencesManager.m9595a(getApplicationContext()).m9587a("is_sp_aus", Boolean.parseBoolean(m4916a58));
        }
        String m4916a59 = C2778n.m4916a(getApplicationContext(), "enable_blacklist");
        if (!TextUtils.isEmpty(m4916a59)) {
            PreferencesManager.m9595a(getApplicationContext()).m9587a("enable_blacklist", Boolean.parseBoolean(m4916a59));
        }
        String m4916a60 = C2778n.m4916a(getApplicationContext(), "enable_delete_png");
        if (!TextUtils.isEmpty(m4916a60)) {
            Log.e(this.f10697e, "enable_online_service= ".concat(String.valueOf(m4916a60)));
            PreferencesManager.m9595a(getApplicationContext()).m9587a("enable_delete_png", Boolean.parseBoolean(m4916a60));
        }
        String m4916a61 = C2778n.m4916a(getApplicationContext(), "apk_soft_name");
        if (!TextUtils.isEmpty(m4916a61)) {
            PreferencesManager.m9595a(getApplicationContext()).m9588a("apk_soft_name", m4916a61);
        }
        String str = Environment.getExternalStorageDirectory() + File.separator + "DCIM" + File.separator + "report_logo" + File.separator + "report_logo.png";
        if (new File(str).exists()) {
            PreferencesManager.m9595a(getApplicationContext()).m9588a("report_logo_path", str);
        }
        String m4916a62 = C2778n.m4916a(getApplicationContext(), "current_device_district");
        if (!TextUtils.isEmpty(m4916a62)) {
            PreferencesManager.m9595a(getApplicationContext()).m9588a("current_device_district", m4916a62);
        }
        String m4916a63 = C2778n.m4916a(getApplicationContext(), "hide_golo");
        if (!TextUtils.isEmpty(m4916a63)) {
            PreferencesManager.m9595a(getApplicationContext()).m9587a("hide_golo", Boolean.parseBoolean(m4916a63));
        }
        String m4916a64 = C2778n.m4916a(getApplicationContext(), "agreement_cus");
        if (!TextUtils.isEmpty(m4916a64)) {
            PreferencesManager.m9595a(getApplicationContext()).m9588a("agreement_cus", m4916a64);
        }
        String m4916a65 = C2778n.m4916a(getApplicationContext(), "is_support_endoscope");
        if (!TextUtils.isEmpty(m4916a65)) {
            PreferencesManager.m9595a(getApplicationContext()).m9587a("is_support_endoscope", Boolean.parseBoolean(m4916a65));
        }
        String m4916a66 = C2778n.m4916a(getApplicationContext(), "is_support_mall");
        if (!TextUtils.isEmpty(m4916a66)) {
            PreferencesManager.m9595a(getApplicationContext()).m9587a("is_support_mall", Boolean.parseBoolean(m4916a66));
        }
        String str2 = PathUtils.m4862b() + "jiuzhang.properties";
        if (FileUtils.m5017a(str2)) {
            PreferencesManager.m9595a(getApplicationContext()).m9588a("jiuzhang_adsdk_key", C2778n.m4911a(str2, "jiuzhang_adsdk_key"));
            PreferencesManager.m9595a(getApplicationContext()).m9588a("jiuzhang_app_id", C2778n.m4911a(str2, "jiuzhang_app_id"));
            PreferencesManager.m9595a(getApplicationContext()).m9588a("jiuzhang_splash_id", C2778n.m4911a(str2, "jiuzhang_splash_id"));
            PreferencesManager.m9595a(getApplicationContext()).m9588a("jiuzhang_interstitial_id", C2778n.m4911a(str2, "jiuzhang_interstitial_id"));
            PreferencesManager.m9595a(getApplicationContext()).m9588a("lauip", C2778n.m4911a(str2, "lauip"));
        } else {
            String m4916a67 = C2778n.m4916a(getApplicationContext(), "jiuzhang_app_id");
            if (!TextUtils.isEmpty(m4916a67)) {
                PreferencesManager.m9595a(getApplicationContext()).m9588a("jiuzhang_app_id", m4916a67);
            }
            String m4916a68 = C2778n.m4916a(getApplicationContext(), "jiuzhang_splash_id");
            if (!TextUtils.isEmpty(m4916a68)) {
                PreferencesManager.m9595a(getApplicationContext()).m9588a("jiuzhang_splash_id", m4916a68);
            }
            String m4916a69 = C2778n.m4916a(getApplicationContext(), "jiuzhang_interstitial_id");
            if (!TextUtils.isEmpty(m4916a69)) {
                PreferencesManager.m9595a(getApplicationContext()).m9588a("jiuzhang_interstitial_id", m4916a69);
            }
        }
        if (!f10693a) {
            AppCrashHandler m9613a = AppCrashHandler.m9613a();
            m9613a.f6756a = getApplicationContext();
            m9613a.f6757b = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(m9613a);
            m9613a.f6758c = new C2500n(this);
        }
        ImageLoaderConfiguration.C3015a m4177a = new ImageLoaderConfiguration.C3015a(getApplicationContext()).m4177a(3);
        m4177a.f17179e = true;
        Md5FileNameGenerator md5FileNameGenerator = new Md5FileNameGenerator();
        if (m4177a.f17181g != null) {
            L.m4103c("diskCache() and diskCacheFileNameGenerator() calls overlap each other", new Object[0]);
        }
        m4177a.f17182h = md5FileNameGenerator;
        int i = QueueProcessingType.LIFO$2bbc75bd;
        if (m4177a.f17176b != null || m4177a.f17177c != null) {
            L.m4103c("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
        }
        m4177a.f17180f = i;
        ImageLoader.m4191a().m4189a(m4177a.m4178a());
        GoloApplication.m8924a(getApplicationContext());
        AdUtil.m5431a();
        String m9584b = PreferencesManager.m9595a((Context) this).m9584b("jiuzhang_app_id", "");
        if (TextUtils.isEmpty(m9584b)) {
            return;
        }
        AdUtil.m5428a("init()");
        LUAsdk.m2638a(this, m9584b);
        if (FileUtils.m5017a(PathUtils.m4862b() + "jiuzhang.properties")) {
            String m9591a = PreferencesManager.m9595a((Context) this).m9591a("jiuzhang_adsdk_key");
            if (TextUtils.isEmpty(m9591a)) {
                return;
            }
            LUAsdk.m2637a(m9584b, m9591a);
        }
    }

    /* renamed from: a */
    public static boolean m7911a() {
        return f10693a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean m7910a(File file) {
        try {
            return new CrashAction(getApplicationContext()).m5425a(file);
        } catch (C1425f e) {
            e.printStackTrace();
            return false;
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* renamed from: b */
    public static Context m7909b() {
        return f10694b;
    }
}
