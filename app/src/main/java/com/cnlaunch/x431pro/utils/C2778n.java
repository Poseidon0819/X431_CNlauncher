package com.cnlaunch.x431pro.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.p012v4.content.FileProvider;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceConstant;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.physics.DPUDownloadbinVersionManager;
import com.cnlaunch.physics.DPUHardwareInformation;
import com.cnlaunch.physics.DeviceFactoryManager;
import com.cnlaunch.physics.p195b.DownloadBinUpdate;
import com.cnlaunch.physics.p197c.DPUHardwareInfo;
import com.cnlaunch.physics.p199e.IPhysics;
import com.cnlaunch.physics.p205k.DeviceUtils;
import com.cnlaunch.physics.p205k.Tools;
import com.cnlaunch.x431pro.activity.GDApplication;
import com.cnlaunch.x431pro.module.config.ConfigDBManager;
import com.cnlaunch.x431pro.module.p269j.p271b.X431PadDtoSoft;
import com.cnlaunch.x431pro.utils.p286f.CarIconUtils;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.NetworkInterface;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import org.apache.mina.proxy.handlers.http.ntlm.NTLMConstants;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* compiled from: CommonUtils.java */
/* renamed from: com.cnlaunch.x431pro.utils.n */
/* loaded from: classes.dex */
public class C2778n {

    /* renamed from: a */
    private static final String f15907a = "n";

    /* renamed from: b */
    private static long f15908b;

    /* renamed from: c */
    private static long f15909c;

    /* renamed from: a */
    public static String m4916a(Context context, String str) {
        try {
            Properties properties = new Properties();
            InputStream open = context.getAssets().open("config.properties");
            if (open != null) {
                properties.load(open);
                return properties.getProperty(str);
            }
            return "";
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    public static String m4911a(String str, String str2) {
        try {
            File file = new File(str);
            Properties properties = new Properties();
            properties.load(new FileInputStream(file));
            return properties.getProperty(str2);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    public static boolean m4917a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    /* renamed from: a */
    public static boolean m4920a() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    /* renamed from: b */
    public static int m4904b(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    /* renamed from: c */
    public static int m4900c(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    /* renamed from: d */
    public static float m4897d(Context context) {
        return (context.getResources().getDisplayMetrics().densityDpi / 160.0f) * 30.0f;
    }

    /* renamed from: a */
    public static void m4918a(Activity activity) {
        InputMethodManager inputMethodManager;
        if (activity == null || (inputMethodManager = (InputMethodManager) activity.getSystemService("input_method")) == null || !inputMethodManager.isActive() || activity.getCurrentFocus() == null || activity.getCurrentFocus() == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }

    /* renamed from: b */
    public static void m4903b(Context context, String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        if (Build.VERSION.SDK_INT >= 24) {
            intent.setFlags(1);
            intent.addFlags(NTLMConstants.FLAG_UNIDENTIFIED_11);
            intent.setDataAndType(FileProvider.m14921a(context, "com.ifoer.expedition.pro.fileprovider", new File(str)), "application/vnd.android.package-archive");
        } else {
            intent.addFlags(NTLMConstants.FLAG_UNIDENTIFIED_11);
            intent.setDataAndType(Uri.fromFile(new File(str)), "application/vnd.android.package-archive");
        }
        context.startActivity(intent);
    }

    /* renamed from: c */
    public static boolean m4899c(Context context, String str) {
        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 1);
        return packageArchiveInfo != null && C2744aa.m5171b(context).equalsIgnoreCase(packageArchiveInfo.packageName);
    }

    /* renamed from: a */
    public static void m4915a(Context context, String str, Bundle bundle) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(NTLMConstants.FLAG_UNIDENTIFIED_11);
        intent.setDataAndType(Uri.fromFile(new File(str)), "application/vnd.android.package-archive");
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    /* renamed from: d */
    public static int m4896d(Context context, String str) {
        PackageInfo packageArchiveInfo;
        int i = -1;
        try {
            packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 1);
        } catch (IOException e) {
            e.printStackTrace();
            NLog.m9456a(f15907a, "installAPKSilently: IOException!");
        } catch (InterruptedException e2) {
            e2.printStackTrace();
            NLog.m9456a(f15907a, "installAPKSilently: IOException1!");
        }
        if (packageArchiveInfo == null) {
            return -1;
        }
        String m5171b = C2744aa.m5171b(context);
        String replace = str.replace(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, "\\ ");
        NLog.m9456a(f15907a, "installAPKSilently filePath: ".concat(String.valueOf(replace)));
        Process exec = Runtime.getRuntime().exec("per-up");
        DataOutputStream dataOutputStream = new DataOutputStream(exec.getOutputStream());
        dataOutputStream.writeBytes("chmod 777 " + replace + "\n");
        dataOutputStream.writeBytes("LD_LIBRARY_PATH=/vendor/lib:/system/lib pm install -r " + replace + "\n");
        if (m5171b.equalsIgnoreCase(packageArchiveInfo.packageName)) {
            dataOutputStream.writeBytes((("am start -n " + packageArchiveInfo.packageName) + '/') + packageArchiveInfo.activities[0].name);
        }
        dataOutputStream.flush();
        dataOutputStream.close();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(exec.getErrorStream()));
        NLog.m9456a(f15907a, "installAPKSilently: end!");
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                break;
            }
            NLog.m9456a("Result: ", readLine);
            if (readLine.contains(HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_SUCCESS)) {
                i = 0;
            }
        }
        while (true) {
            String readLine2 = bufferedReader2.readLine();
            if (readLine2 == null) {
                break;
            }
            if (readLine2.contains("Failure") && readLine2.contains("INSTALL_PARSE_FAILED_INCONSISTENT_CERTIFICATES")) {
                i = -2;
            }
            NLog.m9456a("Result Error: ", readLine2);
        }
        NLog.m9456a(f15907a, "installAPKSilently: end1!");
        exec.waitFor();
        NLog.m9456a(f15907a, "installAPKSilently: end2!");
        NLog.m9456a(f15907a, "installAPKSilently: end3!");
        return i;
    }

    /* renamed from: a */
    public static int m4913a(String str) {
        int i;
        try {
            Process exec = Runtime.getRuntime().exec("per-up");
            DataOutputStream dataOutputStream = new DataOutputStream(exec.getOutputStream());
            dataOutputStream.writeBytes("LD_LIBRARY_PATH=/vendor/lib:/system/lib pm uninstall ".concat(String.valueOf(str)));
            dataOutputStream.flush();
            dataOutputStream.close();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(exec.getErrorStream()));
            i = -1;
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    NLog.m9456a("Result: ", readLine);
                    if (readLine.contains(HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_SUCCESS)) {
                        i = 0;
                    }
                } catch (IOException e) {
                    e = e;
                    e.printStackTrace();
                    return i;
                } catch (InterruptedException e2) {
                    e = e2;
                    e.printStackTrace();
                    return i;
                }
            }
            while (true) {
                String readLine2 = bufferedReader2.readLine();
                if (readLine2 == null) {
                    break;
                }
                if (readLine2.contains("Failure")) {
                    i = -1;
                }
                NLog.m9456a("Result Error: ", readLine2);
            }
            exec.waitFor();
        } catch (IOException e3) {
            e = e3;
            i = -1;
        } catch (InterruptedException e4) {
            e = e4;
            i = -1;
        }
        return i;
    }

    /* renamed from: b */
    public static boolean m4905b() {
        return m4919a(1500L);
    }

    /* renamed from: a */
    public static synchronized boolean m4919a(long j) {
        synchronized (C2778n.class) {
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - f15908b) < j) {
                return true;
            }
            f15908b = currentTimeMillis;
            return false;
        }
    }

    /* renamed from: c */
    public static synchronized boolean m4901c() {
        synchronized (C2778n.class) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - f15909c > 5000) {
                f15909c = currentTimeMillis;
                return false;
            }
            f15909c = currentTimeMillis;
            return true;
        }
    }

    /* renamed from: e */
    public static final boolean m4895e(Context context) {
        String m9584b = PreferencesManager.m9595a(context).m9584b("login_state", "0");
        return !TextUtils.isEmpty(m9584b) && m9584b.equals("1");
    }

    /* renamed from: a */
    public static String m4910a(String str, String str2, Context context) {
        if (str == null) {
            return null;
        }
        if (str.equalsIgnoreCase("X-431 PAD II USA") || str.equalsIgnoreCase("X-431 PAD II") || str.equalsIgnoreCase("X431 Pro APP") || str.equalsIgnoreCase("X431_PRO_EURO_APP") || str.equalsIgnoreCase("X431_PRO_USA_APP") || str.equalsIgnoreCase("X431_PROSPLUS_DBScar5_APP") || str.equalsIgnoreCase("X431_PROSPLUS_EURO_DBScar5_APP") || str.equalsIgnoreCase("X431 Pro3 APP") || str.equalsIgnoreCase("X431PRO3S_APP") || str.equalsIgnoreCase("ScanPad071_2016_APP") || str.equalsIgnoreCase("ScanPad071_2017_APP") || str.equalsIgnoreCase("ScanPad071_V4_APP") || str.equalsIgnoreCase("X431PRO3S_USA_APP") || str.equalsIgnoreCase("X431PRO3S_EURO_APP") || str.equalsIgnoreCase("X431PROJ_APP") || str.equalsIgnoreCase("X431_PRO3S_HD2_APP") || str.equalsIgnoreCase("X431_PRO3S_HDIII_APP") || str.equalsIgnoreCase("X431_PRO3C_APP") || str.equalsIgnoreCase("X431 Pro4 APP") || str.equalsIgnoreCase("X431 PRO3 HD") || str.equalsIgnoreCase("X431 PRO4 HD") || str.equalsIgnoreCase("X431_PADII_HD") || str.equalsIgnoreCase("X-431 PRO3_JINBEIHD_APP") || str.contains("Maximus2.0APK") || str.contains("MaxGo Application") || str.equalsIgnoreCase("ScanPad071") || str.equalsIgnoreCase("ScanPad071_APP") || str.equalsIgnoreCase("ScanPad071_AUS") || str.equalsIgnoreCase("ScanPad071_AUS_APP") || str.equalsIgnoreCase("ScanPad101") || str.equalsIgnoreCase("X-431V") || str.equalsIgnoreCase("X-431 VPlus Application") || str.equalsIgnoreCase("X-431 5C") || str.equalsIgnoreCase("X431_5C_2016_APP") || str.equalsIgnoreCase("X431_PROS_APP") || str.equalsIgnoreCase("X431_PROS_USA_APP") || str.equalsIgnoreCase("X431_PROS_EURO_APP") || str.equalsIgnoreCase("X431_PROS_HDIII_APP") || str.equalsIgnoreCase("X431V_2016_APP") || str.equalsIgnoreCase("X431VPLUS_2016_APP") || str.equalsIgnoreCase("X431_HD2_APP") || str.equalsIgnoreCase("X431_PAD3_APP") || str.equalsIgnoreCase("X431_PRO3S_HD2_APP") || str.equalsIgnoreCase("X431HDIV_APPLICATION") || str.equalsIgnoreCase("X431_PADII_2016_USA_APP") || str.equalsIgnoreCase("ScanPlus_APP") || str.equalsIgnoreCase("X431V_2016_DBSCAR1_APP")) {
            return m4912a(context.getPackageName(), context);
        }
        if (str.equalsIgnoreCase("DOWNLOAD_X431PADII") || str.equalsIgnoreCase("DOWNLOADBIN_X431 Pro") || str.equalsIgnoreCase("DOWNLOADBIN_X431PROD5") || str.equalsIgnoreCase("DOWNLOADBIN_X431 Pro3") || str.equalsIgnoreCase("DOWNLOADBIN_X431_PRO3S") || str.equalsIgnoreCase("DOWNLOADBIN_X431PROJ") || str.equalsIgnoreCase("DOWNLOADBIN_X431PRO3C") || str.equalsIgnoreCase("DOWNLOADBIN_ScanPad071_2016") || str.equalsIgnoreCase("DOWNLOADBIN_ScanPad071_2017") || str.equalsIgnoreCase("DOWNLOADBIN_X431 Pro4") || str.contains("DOWNLOAD_MAXIMUS2.0") || str.contains("DOWNLOAD_MaxGo") || str.equalsIgnoreCase("ScanPad071 firmware") || str.equalsIgnoreCase("DOWNLOADBIN_SCANPAD071D5") || str.equalsIgnoreCase("ScanPad101 firmware") || str.equalsIgnoreCase("DOWNLOADHEX_X431 HD") || str.equalsIgnoreCase("DOWNLOADHEX_X431 HD") || str.equalsIgnoreCase("X431 V firmware") || str.equalsIgnoreCase("X431VPlus Firmware") || str.equalsIgnoreCase("X-431 5C Firmware") || str.equalsIgnoreCase("DOWNLOADBIN_X431_PROS") || str.equalsIgnoreCase("DOWNLOADBIN_X431PROSPLUS") || str.equalsIgnoreCase("DOWNLOADBIN_X431V_2016") || str.equalsIgnoreCase("DOWNLOADBIN_X431VPLUS_2016") || str.equalsIgnoreCase("DOWNLOADBIN_X431_HD2") || str.equalsIgnoreCase("DOWNLOADBIN_X431_PAD3") || str.equalsIgnoreCase("DOWNLOADBIN_X431PRO3S_X431HD2") || str.equalsIgnoreCase("DOWNLOADBIN_X431HDIV") || str.equalsIgnoreCase("DOWNBIN_X431_PADII_2016") || str.equalsIgnoreCase("DOWNLOADBIN_X431_HD2") || str.equalsIgnoreCase("DOWNLOADBIN_X431_HDIII") || str.equalsIgnoreCase("DOWNLOADBIN_X431_HDIII_WIFI") || str.equalsIgnoreCase("DOWNLOADBIN_X431_HDIII_WIFI_RM08")) {
            return m4894e(context, str2);
        }
        if (str.equalsIgnoreCase("BatteryTest_X431PADII") || str.equalsIgnoreCase("BatteryTest_X431Pro") || str.contains("BatteryTest_MAXIMUS2.0")) {
            return m4912a("com.cnlaunch.batterytest", context);
        }
        if (str.equalsIgnoreCase("SensorApp_X431PADII") || str.equalsIgnoreCase("SensorApp_X431Pro") || str.contains("Sensor_MAXIMUS2.0")) {
            return m4912a("com.cnlaunch.sensor", context);
        }
        if (str.equalsIgnoreCase("Oscilloscope_X431PADII") || str.equalsIgnoreCase("Oscilloscope_X431Pro") || str.contains("Oscilloscope_X431PADII") || str.contains("Oscilloscope_MAXIMUS2.0")) {
            return m4912a("com.cnlaunch.oscilloscope", context);
        }
        if (str.equalsIgnoreCase("Ignition_X431PADII") || str.equalsIgnoreCase("Ignition_X431Pro") || str.contains("Ignition_MAXIMUS2.0")) {
            return m4912a("com.cnlaunch.oscilloscope", context);
        }
        if (str.equalsIgnoreCase("golo_Business_Manager_APK_PADII") || str.equalsIgnoreCase("golo_Business_Manager_APK_Pro") || str.contains("golo_Business_Manager_APK_Pro3") || str.contains("golo_Business_Manager_APK_Pro3S")) {
            return m4912a("com.cnlaunch.golo3.seller.oversea.pro", context);
        }
        if (str.equalsIgnoreCase("DiagBaseService_App")) {
            return m4912a("com.cnlaunch.DiagBaseService", context);
        }
        if (str.equalsIgnoreCase("DPULinkManagerServices")) {
            return m4912a("com.cnlaunch.dpulinkmanager", context);
        }
        return null;
    }

    /* renamed from: a */
    private static String m4912a(String str, Context context) {
        try {
            StringBuffer stringBuffer = new StringBuffer(context.getPackageManager().getPackageInfo(str, 0).versionName);
            if (stringBuffer.charAt(0) != 'V' && stringBuffer.charAt(0) != 'v') {
                stringBuffer.insert(0, 'V');
            }
            String str2 = f15907a;
            NLog.m9456a(str2, "packageName: " + str + " verLocal：" + ((Object) stringBuffer));
            return stringBuffer.toString();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: e */
    private static String m4894e(Context context, String str) {
        String m4854d = PathUtils.m4854d(context, str);
        File file = new File(m4854d + "Diagnostic/Configure/Download/DOWNLOAD.ini");
        if (file.isFile()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                Properties properties = new Properties();
                try {
                    properties.load(fileInputStream);
                    StringBuffer stringBuffer = new StringBuffer(properties.get("Version").toString());
                    if (stringBuffer.length() > 0 && stringBuffer.charAt(0) != 'V' && stringBuffer.charAt(0) != 'v') {
                        stringBuffer.insert(0, 'V');
                    }
                    String str2 = f15907a;
                    NLog.m9456a(str2, "getFirmwareVersion: " + stringBuffer.toString());
                    return stringBuffer.toString();
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static String m4909a(String str, String str2, Context context, String str3) {
        String str4 = f15907a;
        NLog.m9456a(str4, "getDiagSoftVersion enter,softId=" + str + ",lanId=" + str2);
        CarIconUtils carIconUtils = new CarIconUtils(context);
        String m4963b = carIconUtils.m4963b(str3, str, LangManager.m9464b(str2));
        if (TextUtils.isEmpty(m4963b)) {
            m4963b = carIconUtils.m4963b(str3, str, LangManager.m9461c(str2));
        }
        return (TextUtils.isEmpty(m4963b) || m4963b.compareToIgnoreCase("V00.00") != 0) ? m4963b : "";
    }

    /* renamed from: a */
    public static List<X431PadDtoSoft> m4907a(List<X431PadDtoSoft> list) {
        NLog.m9456a(f15907a, "removeDuplicate enter,upgradeList.size = " + list.size());
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size() - 1; i++) {
                for (int size = list.size() - 1; size > i; size--) {
                    if (list.get(size).getSoftPackageID().equals(list.get(i).getSoftPackageID())) {
                        list.remove(size);
                    }
                }
            }
        }
        NLog.m9456a(f15907a, "删除重复元素后upgradeList.size = " + list.size());
        return list;
    }

    /* renamed from: a */
    public static List<X431PadDtoSoft> m4906a(List<X431PadDtoSoft> list, Context context) {
        if (list != null && !list.isEmpty()) {
            String m4916a = m4916a(context, "enable_AutoSearch");
            if (!TextUtils.isEmpty(m4916a)) {
                int i = 0;
                if (Boolean.parseBoolean(m4916a)) {
                    while (true) {
                        if (i < list.size()) {
                            X431PadDtoSoft x431PadDtoSoft = list.get(i);
                            if (x431PadDtoSoft != null && x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("AUTOSEARCH")) {
                                x431PadDtoSoft.setMust(true);
                                break;
                            }
                            i++;
                        } else {
                            break;
                        }
                    }
                } else {
                    while (i < list.size()) {
                        X431PadDtoSoft x431PadDtoSoft2 = list.get(i);
                        if (x431PadDtoSoft2 != null && x431PadDtoSoft2.getSoftPackageID().equalsIgnoreCase("AUTOSEARCH")) {
                            list.remove(i);
                            i--;
                        }
                        i++;
                    }
                }
            }
        }
        return list;
    }

    /* compiled from: CommonUtils.java */
    /* renamed from: com.cnlaunch.x431pro.utils.n$b */
    /* loaded from: classes.dex */
    public static class C2782b {
        /* renamed from: a */
        public static String m4890a(String str, String str2, String str3) {
            try {
                return new SimpleDateFormat(str3).format(Long.valueOf(new SimpleDateFormat(str2).parse(str).getTime()));
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    /* renamed from: b */
    public static boolean m4902b(String str) {
        if (str == null) {
            return false;
        }
        return str.equalsIgnoreCase("DiagBaseService_App") || str.equalsIgnoreCase("APP_ETHERNETSERVICE_PADIII") || str.equalsIgnoreCase("DPULinkManagerServices");
    }

    /* renamed from: a */
    public static void m4908a(String str, String str2, String[] strArr) {
        try {
            DeviceUtils.m8149a();
            DeviceUtils.m8144a(str, str2, strArr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static boolean m4914a(IPhysics iPhysics, String str, String str2) {
        try {
            String[] m8370b = DownloadBinUpdate.m8370b(iPhysics);
            if (m8370b == null) {
                return false;
            }
            if (!Tools.m8114a() || Tools.m8101b()) {
                if (m8370b != null) {
                    try {
                        if (m8370b.length >= 5) {
                            DeviceUtils.m8149a();
                            DeviceUtils.m8144a(str, str2, m8370b);
                            String m8382b = DPUDownloadbinVersionManager.m8384a(PathUtils.m4858c()).m8382b(str);
                            if (!TextUtils.isEmpty(m8382b)) {
                                DeviceUtils.m8149a();
                                DeviceUtils.m8145a(str, str2, m8382b);
                            }
                            if (DeviceFactoryManager.m8305a().f9903c == 2) {
                                DPUHardwareInformation.m8315a(str2).m8316a(new DPUHardwareInfo(m8370b));
                                return true;
                            }
                            return true;
                        }
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return true;
                    }
                }
                return true;
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* renamed from: f */
    public static String m4893f(Context context) {
        try {
            String macAddress = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
            return macAddress.equals("02:00:00:00:00:00") ? m4898d() : macAddress;
        } catch (Exception e) {
            NLog.m9455a(e);
            return "";
        }
    }

    /* renamed from: d */
    private static String m4898d() {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i = 0; i < length; i++) {
                        sb.append(String.format("%02x:", Byte.valueOf(hardwareAddress[i])));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
            return "02:00:00:00:00:00";
        } catch (Exception unused) {
            return "02:00:00:00:00:00";
        }
    }

    /* renamed from: g */
    public static boolean m4892g(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.getType() == 1;
            }
            return false;
        } catch (Exception e) {
            NLog.m9455a(e);
            return false;
        }
    }

    /* compiled from: CommonUtils.java */
    /* renamed from: com.cnlaunch.x431pro.utils.n$a */
    /* loaded from: classes.dex */
    public static class C2779a {

        /* compiled from: CommonUtils.java */
        /* renamed from: com.cnlaunch.x431pro.utils.n$a$b */
        /* loaded from: classes.dex */
        public interface InterfaceC2781b {
        }

        /* renamed from: a */
        public static SpannableString m4891a(Context context, String str, String[] strArr) {
            if (str == null) {
                return null;
            }
            SpannableString spannableString = new SpannableString(str);
            for (int i = 0; i < 2; i++) {
                String str2 = strArr[i];
                if (str.contains(str2)) {
                    int indexOf = str.indexOf(str2);
                    spannableString.setSpan(new C2780a(context), indexOf, str2.length() + indexOf, 33);
                }
            }
            return spannableString;
        }

        /* compiled from: CommonUtils.java */
        /* renamed from: com.cnlaunch.x431pro.utils.n$a$a */
        /* loaded from: classes.dex */
        public static class C2780a extends ClickableSpan {

            /* renamed from: a */
            private Context f15910a;

            /* renamed from: b */
            private boolean f15911b;

            /* renamed from: c */
            private boolean f15912c;

            /* renamed from: d */
            private InterfaceC2781b f15913d = null;

            public C2780a(Context context) {
                this.f15912c = true;
                this.f15910a = context;
                this.f15912c = false;
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public final void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(this.f15911b ? -65536 : -16776961);
                textPaint.setUnderlineText(this.f15912c);
            }

            @Override // android.text.style.ClickableSpan
            public final void onClick(View view) {
                this.f15911b = true;
                view.invalidate();
            }
        }
    }

    /* compiled from: CommonUtils.java */
    /* renamed from: com.cnlaunch.x431pro.utils.n$c */
    /* loaded from: classes.dex */
    public static class C2783c {

        /* compiled from: CommonUtils.java */
        /* renamed from: com.cnlaunch.x431pro.utils.n$c$a */
        /* loaded from: classes.dex */
        public static class C2784a {

            /* renamed from: a */
            public String f15914a;

            /* renamed from: b */
            public String f15915b;

            public C2784a(String str, String str2) {
                this.f15914a = str;
                this.f15915b = str2;
            }
        }

        /* renamed from: a */
        public static String m4889a(C2784a c2784a) {
            return c2784a == null ? "" : m4888a(c2784a.f15914a, c2784a.f15915b);
        }

        /* renamed from: a */
        private static String m4888a(String str, String str2) {
            String m5396a;
            try {
                m5396a = ConfigDBManager.m5398a(GDApplication.f10694b).m5396a(str);
                new StringBuilder("getUrlByKey---defaultUrl.equals(url)=").append(str2.equals(m5396a));
            } catch (C1425f e) {
                e.printStackTrace();
            }
            return !TextUtils.isEmpty(m5396a) ? m5396a : str2;
        }

        /* renamed from: a */
        public static String m4886a(String... strArr) {
            return m4885b(strArr);
        }

        /* renamed from: b */
        private static String m4885b(String... strArr) {
            if (strArr == null || strArr.length == 0) {
                return null;
            }
            if (strArr[0] == null) {
                return null;
            }
            String str = strArr[0];
            new StringBuilder();
            int length = strArr.length / 2;
            if (strArr.length % 2 == 0) {
                length--;
            }
            for (int i = 0; i < length; i++) {
                int i2 = (i * 2) + 1;
                String str2 = strArr[i2];
                String str3 = strArr[i2 + 1];
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    str = m4887a(str, str2, str3);
                }
            }
            return str;
        }

        /* renamed from: a */
        private static String m4887a(String str, String str2, String str3) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(str.contains("?") ? "&" : "?");
            sb.append(str2);
            sb.append("=");
            sb.append(str3);
            return sb.toString();
        }
    }
}
