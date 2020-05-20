package com.cnlaunch.x431pro.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.cnlaunch.diagnosemodule.utils.AndroidToLan;
import com.cnlaunch.diagnosemodule.utils.ByteHexHelper;
import com.cnlaunch.diagnosemodule.utils.DiagnoseInfo;
import com.cnlaunch.golo3.p160b.ApplicationConfig;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p125c.p128c.C1426i;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p120d.p130d.p131a.Lang;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.physics.p205k.DeviceUtils;
import com.cnlaunch.x431pro.activity.CloudDiagnose.AutoCodePresenter;
import com.cnlaunch.x431pro.activity.CloudDiagnose.CloudReportUploadService;
import com.cnlaunch.x431pro.activity.GDApplication;
import com.cnlaunch.x431pro.activity.MainActivity;
import com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity;
import com.cnlaunch.x431pro.module.cloud.model.CloudData;
import com.cnlaunch.x431pro.module.config.ConfigDBManager;
import com.cnlaunch.x431pro.module.history.model.VehicleInfo;
import com.cnlaunch.x431pro.module.history.p266a.HistoryDao;
import com.cnlaunch.x431pro.module.p252d.p254b.CarVersionInfo;
import com.cnlaunch.x431pro.module.p272k.p274b.ShopInfo;
import com.cnlaunch.x431pro.module.p272k.p274b.User;
import com.cnlaunch.x431pro.utils.p283db.CarIcon;
import com.cnlaunch.x431pro.utils.p283db.SerialNumber;
import com.cnlaunch.x431pro.utils.p283db.SerialNumberDao;
import com.cnlaunch.x431pro.utils.p283db.p284a.DBManager;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.cnlaunch.x431pro.utils.p285e.IniFile;
import com.cnlaunch.x431pro.utils.p286f.CarIconUtils;
import com.ifoer.expedition.pro.R;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.TimeZone;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import org.jivesoftware.smackx.packet.MultipleAddresses;

/* compiled from: Tools.java */
/* renamed from: com.cnlaunch.x431pro.utils.aa */
/* loaded from: classes.dex */
public final class C2744aa {

    /* renamed from: a */
    public static DecimalFormat f15711a = new DecimalFormat("0.00", new DecimalFormatSymbols(Locale.CHINA));

    /* renamed from: b */
    private static long f15712b = 0;

    /* renamed from: m */
    public static boolean m5135m() {
        return false;
    }

    /* renamed from: p */
    public static boolean m5129p() {
        return false;
    }

    /* renamed from: a */
    public static boolean m5185a(Context context, String str) {
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        for (int i = 0; i < installedPackages.size(); i++) {
            if (installedPackages.get(i).packageName.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static String m5186a(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        return telephonyManager != null ? telephonyManager.getSimSerialNumber() : "";
    }

    /* renamed from: b */
    public static String m5171b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    public static boolean m5193a() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    /* renamed from: a */
    public static long m5180a(File file) throws Exception {
        if (file.exists()) {
            FileInputStream fileInputStream = new FileInputStream(file);
            long available = fileInputStream.available();
            fileInputStream.close();
            return available;
        }
        file.createNewFile();
        Log.e("获取文件大小", "文件不存在!");
        return 0L;
    }

    /* renamed from: a */
    public static String m5190a(long j, String str) {
        return j == 0 ? "" : new SimpleDateFormat(str).format(new Date(j));
    }

    /* renamed from: a */
    public static boolean m5178a(String str) {
        return (TextUtils.isEmpty(str) || "null".equalsIgnoreCase(str)) ? false : true;
    }

    /* renamed from: b */
    public static boolean m5175b() {
        return PreferencesManager.m9595a(GDApplication.f10694b).m9583b("is_cnlaunch_root", false);
    }

    /* renamed from: c */
    public static boolean m5166c() {
        return PreferencesManager.m9595a(GDApplication.f10694b).m9583b("is_usa_project", false);
    }

    /* renamed from: d */
    public static boolean m5160d() {
        return PreferencesManager.m9595a(GDApplication.f10694b).m9583b("is_euro_project", false);
    }

    /* renamed from: e */
    public static boolean m5155e() {
        return PreferencesManager.m9595a(GDApplication.f10694b).m9583b("is_japan_project", false);
    }

    /* renamed from: f */
    public static boolean m5151f() {
        return PreferencesManager.m9595a(GDApplication.f10694b).m9583b("is_scanpad_project", false);
    }

    /* renamed from: g */
    public static boolean m5148g() {
        return PreferencesManager.m9595a(GDApplication.f10694b).m9583b("is_ynht_project", false);
    }

    /* renamed from: h */
    public static boolean m5145h() {
        return PreferencesManager.m9595a(GDApplication.f10694b).m9583b("is_sp_aus", false);
    }

    /* renamed from: i */
    public static boolean m5143i() {
        return PreferencesManager.m9595a(GDApplication.f10694b).m9583b("is_allarea_contains_china", true);
    }

    /* renamed from: j */
    public static boolean m5141j() {
        return PreferencesManager.m9595a(GDApplication.f10694b).m9583b("is_reserve_seller", false);
    }

    /* renamed from: k */
    public static boolean m5139k() {
        return PreferencesManager.m9595a(GDApplication.f10694b).m9583b("is_left_enter_golousa", false);
    }

    /* renamed from: l */
    public static boolean m5137l() {
        return PreferencesManager.m9595a(GDApplication.f10694b).m9583b("is_support_advertise", false);
    }

    /* renamed from: n */
    public static boolean m5133n() {
        return PreferencesManager.m9595a(GDApplication.f10694b).m9583b("is_support_endoscope", false);
    }

    /* renamed from: b */
    public static boolean m5169b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}");
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x010f, code lost:
        if (r0 == false) goto L30;
     */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m5164c(android.content.Context r11) {
        /*
            Method dump skipped, instructions count: 291
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.x431pro.utils.C2744aa.m5164c(android.content.Context):boolean");
    }

    /* renamed from: c */
    public static boolean m5162c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("^\\d{12}$");
    }

    /* renamed from: a */
    public static boolean m5177a(String str, Context context) {
        if (!TextUtils.isEmpty(str)) {
            SerialNumber m5050a = DBManager.m5036a(context).f15794a.f15798a.m5050a(str);
            if (m5050a != null && !TextUtils.isEmpty(m5050a.f15836f)) {
                if ("1".equals(m5050a.f15836f)) {
                    return true;
                }
            } else {
                String m9591a = PreferencesManager.m9595a(context).m9591a("heavyduty_serialNo_Prefix");
                NLog.m9456a("Tools", "serialNo=" + str + ",heavyPrefix=" + m9591a);
                if (!TextUtils.isEmpty(str) && str.startsWith(m9591a)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: d */
    public static int m5158d(Context context) {
        String m9591a = PreferencesManager.m9595a(context).m9591a("pdt_type");
        if (m5151f() || m5171b(context).equals("com.cnlaunch.X431V") || m5155e() || m5160d() || m5166c() || m9591a.equals("383") || m9591a.equals("384") || m9591a.equals("385") || m9591a.equals("325") || m9591a.equals("326")) {
            return PreferencesManager.m9595a(context).m9585b("Measuresion", 1);
        }
        return PreferencesManager.m9595a(context).m9585b("Measuresion", 0);
    }

    @SuppressLint({"DefaultLocale"})
    /* renamed from: o */
    public static String m5131o() {
        String upperCase = LangManager.m9466b().toUpperCase();
        String upperCase2 = LangManager.m9469a().toUpperCase();
        if (upperCase2.equals("ZH")) {
            return AndroidToLan.toLan(upperCase);
        }
        return AndroidToLan.toLan(upperCase2);
    }

    /* renamed from: a */
    public static String m5191a(long j) {
        if (j == 0) {
            return "";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        return simpleDateFormat.format(new Date(j));
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0125, code lost:
        if (r11 == false) goto L31;
     */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m5154e(android.content.Context r11) {
        /*
            Method dump skipped, instructions count: 313
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.x431pro.utils.C2744aa.m5154e(android.content.Context):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x017c  */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m5150f(android.content.Context r13) {
        /*
            Method dump skipped, instructions count: 409
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.x431pro.utils.C2744aa.m5150f(android.content.Context):boolean");
    }

    /* renamed from: g */
    public static boolean m5147g(Context context) {
        return context.getResources().getConfiguration().orientation == 1;
    }

    /* renamed from: h */
    public static boolean m5144h(Context context) {
        PreferencesManager.m9595a(context).m9584b("current_country", Locale.getDefault().getCountry());
        String country = Locale.getDefault().getCountry();
        return country.equalsIgnoreCase("CN") || country.equalsIgnoreCase("ZH");
    }

    /* renamed from: i */
    public static boolean m5142i(Context context) {
        String m9584b = PreferencesManager.m9595a(context).m9584b("current_country", Locale.getDefault().getCountry());
        return TextUtils.isEmpty(m9584b) || "CN".equals(m9584b);
    }

    /* renamed from: j */
    public static void m5140j(Context context) {
        if (m5142i(context)) {
            ApplicationConfig.f7815n = false;
            ApplicationConfig.f7814m = "151";
            return;
        }
        ApplicationConfig.f7815n = true;
        ApplicationConfig.f7814m = "1522";
    }

    /* renamed from: k */
    public static String m5138k(Context context) {
        return !m5144h(context) ? "com.cnlaunch.golo3.seller.oversea.pro" : "com.cnlaunch.golo3.seller.pro";
    }

    /* renamed from: l */
    public static String m5136l(Context context) {
        return !m5144h(context) ? "3422" : "3421";
    }

    /* renamed from: q */
    public static boolean m5127q() {
        return Locale.getDefault().toString().startsWith("zh_CN") || LangManager.m9466b().equalsIgnoreCase("CN");
    }

    /* renamed from: r */
    public static boolean m5125r() {
        return Locale.getDefault().toString().equalsIgnoreCase("zh_CN");
    }

    /* renamed from: a */
    public static boolean m5176a(String str, String str2) {
        boolean z;
        NLog.m9456a("Tools", "isMergeChildVehicle enter, softPackageId=" + str + ",vehiclePath=" + str2);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !str2.contains(str)) {
            List<String> m5156d = m5156d(PathUtils.m4858c() + str2);
            NLog.m9456a("Tools", "allChildVehicles=".concat(String.valueOf(m5156d)));
            if (!m5156d.isEmpty() && m5156d.contains(str)) {
                z = true;
                NLog.m9456a("Tools", "isMergeChildVehicle exit, result=".concat(String.valueOf(z)));
                return z;
            }
        }
        z = false;
        NLog.m9456a("Tools", "isMergeChildVehicle exit, result=".concat(String.valueOf(z)));
        return z;
    }

    /* renamed from: d */
    public static List<String> m5156d(String str) {
        NLog.m9456a("Tools", "vehiclePath=".concat(String.valueOf(str)));
        ArrayList arrayList = new ArrayList();
        String str2 = str + File.separator + "ICON.INI";
        if (new File(str2).exists()) {
            for (Map.Entry<String, Properties> entry : FileUtils.m4996f(str2).entrySet()) {
                if (entry != null) {
                    String key = entry.getKey();
                    Properties value = entry.getValue();
                    if (!TextUtils.isEmpty(key) && !key.equals("MAKE") && value != null) {
                        arrayList.add(key);
                    }
                }
            }
        }
        NLog.m9456a("Tools", "childVehicles=".concat(String.valueOf(arrayList)));
        return arrayList;
    }

    /* renamed from: e */
    public static String m5152e(String str) {
        String[] split;
        return (TextUtils.isEmpty(str) || (split = str.split(PathUtils.f15922b)) == null || split.length != 2) ? "" : split[1].replace(File.separator, "");
    }

    /* renamed from: b */
    public static boolean m5168b(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        SerialNumber m5050a = DBManager.m5036a(context).f15794a.f15798a.m5050a(str);
        if (m5050a != null && !TextUtils.isEmpty(m5050a.f15836f)) {
            return "3".equals(m5050a.f15836f);
        }
        String m9591a = PreferencesManager.m9595a(context).m9591a("serialNo_Prefix");
        String m9591a2 = PreferencesManager.m9595a(context).m9591a("new_car_prefix");
        if (str != null) {
            if (str.startsWith(m9591a)) {
                return true;
            }
            boolean z = false;
            for (String str2 : m9591a2.split(",")) {
                if (str.startsWith(str2)) {
                    z = true;
                }
            }
            return z;
        }
        return false;
    }

    /* renamed from: c */
    public static boolean m5161c(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        SerialNumber m5050a = DBManager.m5036a(context).f15794a.f15798a.m5050a(str);
        if (m5050a != null && !TextUtils.isEmpty(m5050a.f15836f)) {
            return "2".equals(m5050a.f15836f);
        }
        String m9591a = PreferencesManager.m9595a(context).m9591a("car_and_heavyduty_prefix");
        if (str.startsWith(PreferencesManager.m9595a(context).m9591a("serialNo_debug_Prefix"))) {
            return true;
        }
        if (!m9591a.contains(",")) {
            return str.startsWith(m9591a);
        }
        String[] split = m9591a.split(",");
        if (split != null) {
            for (String str2 : split) {
                if (!TextUtils.isEmpty(str2) && str.startsWith(str2)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /* renamed from: m */
    public static void m5134m(Context context) {
        String m9591a = PreferencesManager.m9595a(context).m9591a("carSerialNo");
        String m9591a2 = PreferencesManager.m9595a(context).m9591a("heavydutySerialNo");
        String m9591a3 = PreferencesManager.m9595a(context).m9591a("carAndHeavydutySerialNo");
        if (!TextUtils.isEmpty(m9591a3)) {
            m9591a = m9591a3;
        } else if (TextUtils.isEmpty(m9591a)) {
            m9591a = m9591a2;
        }
        PreferencesManager.m9595a(context).m9588a("serialNo", m9591a);
    }

    /* renamed from: n */
    public static boolean m5132n(Context context) {
        return PreferencesManager.m9595a(context).m9583b("is_x30_or_a8050_device", false);
    }

    /* renamed from: s */
    public static boolean m5123s() {
        if (Build.MANUFACTURER.equals("CNLAUNCH")) {
            String str = Build.MODEL;
            String str2 = Build.DISPLAY;
            if (str.contains("X431-7")) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: t */
    public static boolean m5121t() {
        String str = Build.MANUFACTURER;
        if (!str.equals("LENOVO") && !str.equals("QUALCOMM")) {
            return Build.MODEL.equals("X431 PRO TP") || Build.MODEL.contains("PRO GT") || Build.MODEL.equals("X-431 ADS1") || Build.MODEL.equals("X431 EUROMINI") || Build.MODEL.contains("X-431 PRO V4.0") || Build.MODEL.contains("X-431 PROSPLUS V4.0") || Build.MODEL.equals("MAXLITE") || Build.MODEL.equals("Phoenix");
        }
        String str2 = Build.MODEL;
        String str3 = Build.DISPLAY;
        if (str2.contains("X30") && (str3.contains("_YZ") || str3.contains("_HFT") || str3.contains("_JLC") || str3.contains("_UK") || str3.contains("_SCP"))) {
            return true;
        }
        if (str2.contains("A8-50") && str3.contains("_YZ")) {
            return true;
        }
        if ((str2.contains("TB3-850M") && str3.contains("_YZ")) || str3.contains("_SCP")) {
            return true;
        }
        if (str2.contains("TB3-850F") && (str3.contains("_YZ") || str3.contains("_HFT") || str3.contains("_PAL") || str3.contains("_SCP"))) {
            return true;
        }
        if (str2.contains("TB3-730F") && str3.contains("_YZ")) {
            return true;
        }
        if ((str2.contains("TB-8504F") && str3.contains("_YZ")) || str3.contains("_SCP")) {
            return true;
        }
        return (str2.contains("TB-X304") && (str3.contains("_YZ") || str3.contains("PICC") || str3.contains("_SCP"))) || str2.contains("X304N") || str2.contains("X304F") || str2.contains("X704N") || str2.contains("8504F") || str2.contains("X605FC") || str2.contains("8505F");
    }

    /* renamed from: f */
    public static boolean m5149f(String str) {
        return (str.startsWith("98269") || str.startsWith("982789")) ? false : true;
    }

    /* renamed from: a */
    public static void m5187a(Activity activity, String str) {
        String m9591a = PreferencesManager.m9595a((Context) activity).m9591a("serialNo");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        CarIcon m4951e = CarIconUtils.m4977a(activity).m4951e(m9591a, str);
        if (m4951e != null) {
            if (m4951e.f15787k.booleanValue()) {
                Bundle bundle = new Bundle();
                bundle.putString("versionlist", m4951e.f15786j);
                bundle.putString("carname", m4951e.f15779c);
                bundle.putString("carname_zh", m4951e.m5038a(activity));
                bundle.putString("softpackageid", m4951e.f15778b);
                Intent intent = new Intent("startDiagnoseWithoutSelectVersion");
                intent.putExtras(bundle);
                activity.sendBroadcast(intent);
                return;
            }
            m5159d(activity, str);
            return;
        }
        m5159d(activity, str);
    }

    /* renamed from: d */
    private static void m5159d(Activity activity, String str) {
        Intent intent = new Intent("NEED_DOWN_LOAD_VEHICLES");
        intent.putExtra("vehicles", str);
        activity.sendBroadcast(intent);
    }

    /* renamed from: b */
    public static void m5172b(Activity activity, String str) {
        String m9591a = PreferencesManager.m9595a((Context) activity).m9591a("serialNo");
        if (TextUtils.isEmpty(str)) {
            NToast.m9450a(activity, (int) R.string.vin_length_fail);
            return;
        }
        boolean m4803p = C2787z.m4803p(str);
        if (m4803p && str.length() == 17) {
            CarIcon m4951e = new CarIconUtils(activity).m4951e(m9591a, "AUTOSEARCH");
            String upperCase = str.toUpperCase();
            if (m4951e != null) {
                if (m4951e.f15787k.booleanValue()) {
                    Bundle bundle = new Bundle();
                    bundle.putString("versionlist", m4951e.f15786j);
                    bundle.putString("carname", m4951e.f15779c);
                    bundle.putString("carname_zh", m4951e.m5038a(activity));
                    bundle.putString("softpackageid", m4951e.f15778b);
                    bundle.putString("vin_scan", upperCase);
                    Intent intent = new Intent("startDiagnoseWithoutSelectVersion");
                    intent.putExtras(bundle);
                    activity.sendBroadcast(intent);
                    return;
                }
                m5159d(activity, "AUTOSEARCH");
                return;
            }
            m5159d(activity, "AUTOSEARCH");
        } else if (str.length() != 17) {
            NToast.m9450a(activity, (int) R.string.vin_length_fail);
        } else if (m4803p) {
        } else {
            NToast.m9450a(activity, (int) R.string.vin_format_fail);
        }
    }

    /* renamed from: a */
    public static String m5184a(Context context, String str, Boolean bool) {
        if (!m5128p(context)) {
            bool = Boolean.FALSE;
        }
        if (!"EN".equals(LangManager.m9469a().toUpperCase())) {
            bool = Boolean.FALSE;
        }
        try {
            if (C2787z.m4821a(str) || "0".equals(str) || MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR.equals(str)) {
                return "";
            }
            if (TextUtils.isDigitsOnly(str)) {
                if (m5158d(context) == 1) {
                    long longValue = new BigDecimal(str).multiply(new BigDecimal("0.6214")).setScale(0, 5).longValue();
                    if (bool.booleanValue()) {
                        return m5179a(Double.valueOf(Double.parseDouble(String.valueOf(longValue)))) + " miles";
                    }
                    return longValue + " miles";
                } else if (bool.booleanValue()) {
                    return m5179a(Double.valueOf(Double.parseDouble(str))) + " km";
                } else {
                    return str + " km";
                }
            }
            String m4800s = C2787z.m4800s(str);
            if (str.contains("miles") && m5158d(context) == 0) {
                long longValue2 = new BigDecimal(m4800s).divide(new BigDecimal("0.6214"), 0, 5).longValue();
                if (bool.booleanValue()) {
                    return m5179a(Double.valueOf(Double.parseDouble(String.valueOf(longValue2)))) + " km";
                }
                return longValue2 + " km";
            } else if (str.contains("km") && m5158d(context) == 1) {
                long longValue3 = new BigDecimal(m4800s).multiply(new BigDecimal("0.6214")).setScale(0, 5).longValue();
                if (bool.booleanValue()) {
                    return m5179a(Double.valueOf(Double.parseDouble(String.valueOf(longValue3)))) + " miles";
                }
                return longValue3 + " miles";
            } else {
                return str;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            if (C2787z.m4821a(str) || "0".equals(str) || MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR.equals(str)) {
                return "";
            }
            if (TextUtils.isDigitsOnly(str)) {
                if (m5158d(context) == 1) {
                    long longValue4 = new BigDecimal(str).multiply(new BigDecimal("0.6214")).setScale(0, 5).longValue();
                    return longValue4 + " miles";
                }
                return str + " km";
            }
            return str;
        }
    }

    /* renamed from: a */
    public static void m5188a(Activity activity, VehicleInfo vehicleInfo, boolean z) {
        if (vehicleInfo == null || C2778n.m4919a(2000L)) {
            return;
        }
        if (!(activity instanceof DiagnoseActivity) && ((MainActivity) activity.getParent()).getLocalActivityManager().getActivity(DiagnoseActivity.class.getSimpleName()) == null) {
            MainActivity mainActivity = (MainActivity) activity.getParent();
            mainActivity.getLocalActivityManager().startActivity(DiagnoseActivity.class.getSimpleName(), new Intent(mainActivity.f10736a, DiagnoseActivity.class));
        }
        CarIconUtils m4977a = CarIconUtils.m4977a(activity);
        String str = "";
        String str2 = "";
        ArrayList<CarVersionInfo> m4968a = CarIconUtils.m4968a(new CarIconUtils(m4977a.f15880s).m4954d(vehicleInfo.getSN(), vehicleInfo.getVehicleUID()));
        if (m4968a != null) {
            Collections.sort(m4968a, new CarIconUtils.C2766a());
            str = m4968a.get(0).getVersion();
            str2 = m4968a.get(0).getLanguage();
        }
        String[] strArr = {str, str2};
        String str3 = strArr[0];
        NLog.m9452b("weixingtai", "max ver:" + str3 + " lan:" + strArr[1]);
        if (TextUtils.isEmpty(str3)) {
            m5165c(activity, vehicleInfo.getVehicleUID());
            return;
        }
        int vehicleId = vehicleInfo.getVehicleId();
        if (z) {
            vehicleId = (int) HistoryDao.m5300a(activity).m5297a(vehicleInfo);
        }
        Bundle bundle = new Bundle();
        bundle.putString("path", new PathUtils(activity).m4864a(vehicleInfo.getSN(), vehicleInfo.getVehicleUID(), str3));
        bundle.putString("language", strArr[1]);
        bundle.putString("serialNo", vehicleInfo.getSN());
        String str4 = "";
        CarIcon m4951e = CarIconUtils.m4977a(activity).m4951e(PreferencesManager.m9595a((Context) activity).m9591a("serialNo"), vehicleInfo.getVehicleUID());
        if (m4951e != null && m4951e.f15787k.booleanValue()) {
            if (LangManager.m9469a().equalsIgnoreCase("zh")) {
                str4 = m4951e.m5038a(activity);
            } else {
                str4 = m4951e.f15779c;
            }
        }
        bundle.putString("carName", str4);
        bundle.putString("softPackageid", vehicleInfo.getVehicleUID());
        bundle.putString("softVersion", str3);
        bundle.putString("softLan", m5131o());
        bundle.putInt("VID", vehicleId);
        bundle.putString("vin", vehicleInfo.getVIN());
        Log.i("XEE", "bundler:" + bundle.toString());
        DiagnoseInfo.getInstance().clear();
        DiagnoseInfo.getInstance().setMake(vehicleInfo.getMark());
        DiagnoseInfo.getInstance().setModel(vehicleInfo.getModel());
        DiagnoseInfo.getInstance().setYear(vehicleInfo.getYear());
        DiagnoseInfo.getInstance().setEngine(vehicleInfo.getEngine());
        DiagnoseInfo.getInstance().setVin(vehicleInfo.getVIN());
        Intent intent = new Intent("HISTORY_DIAG");
        intent.putExtras(bundle);
        activity.sendBroadcast(intent);
    }

    /* renamed from: c */
    public static void m5165c(Activity activity, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.equalsIgnoreCase("BENZ")) {
            str = "MERCEDES";
        }
        DialogC2745ab dialogC2745ab = new DialogC2745ab(activity, activity);
        dialogC2745ab.setTitle(R.string.remind_update_title);
        dialogC2745ab.m4715c(activity.getString(R.string.vinscan_download_tip, new Object[]{str}));
        dialogC2745ab.m4717b(R.string.remind_update_button_later, true, null);
        dialogC2745ab.m4719a(R.string.remind_update_button_now, true, null);
        dialogC2745ab.m4713f(2);
        dialogC2745ab.show();
    }

    /* renamed from: a */
    public static void m5182a(Context context, ArrayList<CloudData> arrayList) {
        Intent intent = new Intent(context, CloudReportUploadService.class);
        intent.setAction("com.cnlaunch.cloudreport.action.upload");
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("CloudData", arrayList);
        intent.putExtras(bundle);
        context.startService(intent);
    }

    /* renamed from: o */
    public static String m5130o(Context context) {
        try {
            StringBuffer stringBuffer = new StringBuffer(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName);
            if (stringBuffer.charAt(0) != 'V' && stringBuffer.charAt(0) != 'v') {
                stringBuffer.insert(0, 'V');
            }
            return stringBuffer.toString();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: u */
    public static synchronized boolean m5119u() {
        synchronized (C2744aa.class) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - f15712b <= 0 || currentTimeMillis - f15712b >= 500) {
                f15712b = currentTimeMillis;
                return false;
            }
            return true;
        }
    }

    /* renamed from: a */
    public static void m5183a(Context context, String str, String str2) {
        new AutoCodePresenter(context).m7933a(str, str2, new C2746ac());
    }

    /* renamed from: b */
    public static String m5173b(long j, String str) {
        return new SimpleDateFormat(str).format(new Date(j * 1000));
    }

    /* renamed from: b */
    public static String m5170b(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("/");
            if (split.length > 1) {
                for (String str2 : split) {
                    if (!m5153e(context, str2)) {
                        if (sb.length() > 0) {
                            str2 = "\\".concat(String.valueOf(str2));
                        }
                        sb.append(str2);
                    }
                }
            } else {
                sb.append(split[0]);
            }
        }
        return sb.toString();
    }

    /* renamed from: e */
    private static boolean m5153e(Context context, String str) {
        for (String str2 : context.getResources().getStringArray(R.array.china_cars)) {
            if (str2.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: g */
    public static boolean m5146g(String str) {
        String replace = str.replace("\ufeff", "");
        String[] strArr = {"\\", "/", ":", "*", "?", "\"", "<", ">", "|"};
        for (int i = 0; i < 9; i++) {
            if (replace.indexOf(strArr[i]) != -1) {
                return false;
            }
        }
        for (int i2 = 0; i2 < replace.length(); i2++) {
            char charAt = replace.charAt(i2);
            if (!(charAt == 0 || charAt == '\t' || charAt == '\n' || charAt == '\r' || (charAt >= ' ' && charAt <= 55295)) || (charAt >= 57344 && charAt <= 65533) || (charAt >= 0 && charAt <= 65535)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: c */
    public static boolean m5163c(Context context, String str) {
        return str.equalsIgnoreCase(context.getPackageName());
    }

    /* renamed from: a */
    public static void m5181a(ShopInfo shopInfo) {
        PrintInfoProperties.m4838a().m4836a("serialNo", C2787z.m4821a(shopInfo.getSerial_number()) ? "" : shopInfo.getSerial_number());
        PrintInfoProperties.m4838a().m4836a("companyName", C2787z.m4821a(shopInfo.getCompany_fullname()) ? "" : shopInfo.getCompany_fullname());
        PrintInfoProperties.m4838a().m4836a("companyAddress", C2787z.m4821a(shopInfo.getCompany_address()) ? "" : shopInfo.getCompany_address());
        PrintInfoProperties.m4838a().m4836a("companyPhoneNumber", C2787z.m4821a(shopInfo.getTelephone()) ? "" : shopInfo.getTelephone());
        PrintInfoProperties.m4838a().m4836a("companyEmail", C2787z.m4821a(shopInfo.getEmail()) ? "" : shopInfo.getEmail());
    }

    /* renamed from: p */
    public static boolean m5128p(Context context) {
        return PreferencesManager.m9595a(context).m9583b("report_style_table", false);
    }

    /* renamed from: q */
    public static boolean m5126q(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSimState() == 5;
    }

    /* renamed from: r */
    public static String m5124r(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        return telephonyManager != null ? telephonyManager.getDeviceId() : "";
    }

    /* renamed from: s */
    public static boolean m5122s(Context context) {
        return PreferencesManager.m9595a(context).m9583b("enable_paypal_pincard", false);
    }

    /* renamed from: a */
    private static String m5179a(Double d) {
        return new DecimalFormat("#,###").format(d);
    }

    /* renamed from: d */
    public static String m5157d(Context context, String str) {
        return (TextUtils.isEmpty(str) || "0".equals(str)) ? "" : (TextUtils.isDigitsOnly(str) && m5158d(context) == 1) ? String.valueOf(new BigDecimal(str).divide(new BigDecimal("0.6214"), 0, 5).longValue()) : str;
    }

    /* renamed from: t */
    public static void m5120t(Context context) {
        SerialNumberDao serialNumberDao = DBManager.m5036a(context).f15794a.f15798a;
        if (serialNumberDao.m5048b()) {
            List<String> m4993i = FileUtils.m4993i(PathUtils.m4858c());
            ArrayList<String> arrayList = new ArrayList();
            if (m4993i != null && m4993i.size() > 0) {
                for (String str : m4993i) {
                    if (m5168b(str, context) || m5177a(str, context) || m5161c(str, context)) {
                        arrayList.add(str);
                    }
                }
            }
            ArrayList arrayList2 = new ArrayList();
            if (arrayList.isEmpty()) {
                return;
            }
            File file = new File(PathUtils.m4840p());
            IniFile iniFile = file.exists() ? new IniFile(file) : null;
            for (String str2 : arrayList) {
                SerialNumber serialNumber = new SerialNumber();
                serialNumber.f15835e = "";
                serialNumber.f15832b = Boolean.FALSE;
                serialNumber.f15833c = Boolean.FALSE;
                serialNumber.f15834d = str2;
                if (iniFile != null) {
                    serialNumber.f15836f = FileUtils.m5022a(iniFile, "VCI_INFO", str2);
                }
                DeviceUtils.m8149a();
                String m8143b = DeviceUtils.m8143b(str2);
                if (TextUtils.isEmpty(m8143b)) {
                    m8143b = "0";
                }
                serialNumber.f15837g = m8143b;
                arrayList2.add(serialNumber);
            }
            serialNumberDao.m5046b(arrayList2);
        }
    }

    /* renamed from: v */
    public static String m5117v() {
        PreferencesManager m9595a = PreferencesManager.m9595a(GDApplication.f10694b);
        String m9591a = m9595a.m9591a("serialNo");
        if (TextUtils.isEmpty(m9591a)) {
            m9591a = m9595a.m9591a("carSerialNo");
            String m9591a2 = m9595a.m9591a("heavydutySerialNo");
            if (TextUtils.isEmpty(m9591a)) {
                m9591a = m9591a2;
            }
            m9595a.m9588a("serialNo", m9591a);
        }
        return m9591a;
    }

    /* renamed from: b */
    public static boolean m5174b(long j) {
        boolean z = System.currentTimeMillis() - j >= 86400000;
        NLog.m9456a("yhx", "isExceed24Hours result=".concat(String.valueOf(z)));
        return z;
    }

    /* renamed from: a */
    private static String m5192a(int i) {
        String hexString = Integer.toHexString(i);
        int length = hexString.length();
        while (length < 2) {
            hexString = "0".concat(String.valueOf(hexString));
            length = hexString.length();
        }
        return hexString;
    }

    /* renamed from: b */
    public static String m5167b(String str, String str2) {
        String str3 = "U";
        int byteToInt = ByteHexHelper.byteToInt(ByteHexHelper.hexStringToByte(str));
        int i = 128;
        if (byteToInt <= 63 && byteToInt >= 0) {
            str3 = "P";
            i = 0;
        } else if (byteToInt <= 127 && byteToInt >= 64) {
            str3 = "C";
            i = 64;
        } else if (byteToInt > 191 || byteToInt < 128) {
            i = 192;
        } else {
            str3 = "B";
        }
        return "(" + str3 + m5192a(byteToInt - i) + str2 + ")";
    }

    /* renamed from: u */
    public static String m5118u(Context context) {
        String m9467a;
        User user = (User) PreferencesManager.m9595a(context).m9593a(User.class);
        String str = null;
        if (user == null) {
            return null;
        }
        if (LangManager.m9469a().equalsIgnoreCase("zh")) {
            if (LangManager.m9466b().equalsIgnoreCase("TW")) {
                m9467a = LangManager.m9467a(Lang.f7198G);
            } else if (LangManager.m9466b().equalsIgnoreCase("HK")) {
                m9467a = LangManager.m9467a(Lang.f7197F);
            } else {
                m9467a = LangManager.m9467a(Lang.f7199H);
            }
        } else {
            m9467a = LangManager.m9467a(LangManager.m9469a());
        }
        String m9591a = PreferencesManager.m9595a(context).m9591a("carSerialNo");
        String m9591a2 = PreferencesManager.m9595a(context).m9591a("heavydutySerialNo");
        if (TextUtils.isEmpty(m9591a)) {
            m9591a = m9591a2;
        }
        try {
            str = ConfigDBManager.m5398a(context).m5396a("shopping_center");
        } catch (C1425f e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(str)) {
            str = "http://aitustest.x431.com/shop/#/software?";
        }
        StringBuilder sb = new StringBuilder(str);
        C1426i c1426i = new C1426i();
        c1426i.m9506a(MultipleAddresses.f24412CC, user.getUser_id());
        c1426i.m9506a("token", user.getToken());
        c1426i.m9506a("sn", m9591a);
        c1426i.m9506a("lan", m9467a);
        if (str.contains("?")) {
            sb.append(c1426i.toString());
        } else {
            sb.append("?");
            sb.append(c1426i.toString());
        }
        Log.i("Tools", "getShoppingUrlByKey=" + sb.toString());
        return sb.toString();
    }

    /* renamed from: a */
    public static void m5189a(Activity activity) {
        ((MainActivity) activity.getParent()).m7894b(R.id.btn_mall);
    }
}
