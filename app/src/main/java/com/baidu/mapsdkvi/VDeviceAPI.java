package com.baidu.mapsdkvi;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Environment;
import android.os.PowerManager;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.CellLocation;
import android.telephony.PhoneNumberUtils;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.webkit.MimeTypeMap;
import com.itextpdf.text.Meta;
import com.itextpdf.text.pdf.ColumnText;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* loaded from: classes.dex */
public class VDeviceAPI {

    /* renamed from: a */
    private static PowerManager.WakeLock f6446a;

    /* renamed from: b */
    private static BroadcastReceiver f6447b;

    public static String getAppVersion() {
        try {
            return C1316a.m9955a().getPackageManager().getPackageInfo(C1316a.m9955a().getApplicationInfo().packageName, 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static long getAvailableMemory() {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) C1316a.m9955a().getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem / 1024;
    }

    public static String getCachePath() {
        return Environment.getDataDirectory().getAbsolutePath();
    }

    public static String getCellId() {
        TelephonyManager telephonyManager = (TelephonyManager) C1316a.m9955a().getSystemService("phone");
        if (telephonyManager == null) {
            return null;
        }
        CellLocation cellLocation = telephonyManager.getCellLocation();
        if (cellLocation instanceof GsmCellLocation) {
            return MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + ((GsmCellLocation) cellLocation).getCid();
        }
        return MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
    }

    public static int getCurrentNetworkType() {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) C1316a.m9955a().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception unused) {
            networkInfo = null;
        }
        if (networkInfo == null) {
            return 0;
        }
        switch (networkInfo.getType()) {
            case 0:
                return 3;
            case 1:
                return 2;
            default:
                return 1;
        }
    }

    public static long getFreeSpace() {
        StatFs statFs = new StatFs(Environment.getRootDirectory().getPath());
        return (statFs.getBlockSize() * statFs.getAvailableBlocks()) / 1024;
    }

    public static String getImei() {
        TelephonyManager telephonyManager = (TelephonyManager) C1316a.m9955a().getSystemService("phone");
        if (telephonyManager != null) {
            return telephonyManager.getDeviceId();
        }
        return null;
    }

    public static String getImsi() {
        TelephonyManager telephonyManager = (TelephonyManager) C1316a.m9955a().getSystemService("phone");
        if (telephonyManager != null) {
            return telephonyManager.getSubscriberId();
        }
        return null;
    }

    public static String getLac() {
        TelephonyManager telephonyManager = (TelephonyManager) C1316a.m9955a().getSystemService("phone");
        if (telephonyManager == null) {
            return null;
        }
        CellLocation cellLocation = telephonyManager.getCellLocation();
        if (cellLocation instanceof GsmCellLocation) {
            StringBuilder sb = new StringBuilder();
            sb.append(((GsmCellLocation) cellLocation).getLac());
            return sb.toString();
        }
        return "";
    }

    public static String getModuleFileName() {
        return C1316a.m9955a().getFilesDir().getAbsolutePath();
    }

    public static C1317b getNetworkInfo(int i) {
        int i2;
        NetworkInfo networkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) C1316a.m9955a().getSystemService("connectivity");
        switch (i) {
            case 2:
                i2 = 1;
                networkInfo = connectivityManager.getNetworkInfo(i2);
                break;
            case 3:
                i2 = 0;
                networkInfo = connectivityManager.getNetworkInfo(i2);
                break;
            default:
                networkInfo = null;
                break;
        }
        if (networkInfo != null) {
            return new C1317b(networkInfo);
        }
        return null;
    }

    public static String getOsVersion() {
        return "android";
    }

    public static int getScreenBrightness() {
        int i;
        ContentResolver contentResolver = C1316a.m9955a().getContentResolver();
        try {
            i = Settings.System.getInt(contentResolver, "screen_brightness_mode");
        } catch (Settings.SettingNotFoundException unused) {
            i = 0;
        }
        if (i == 1) {
            return -1;
        }
        try {
            return Settings.System.getInt(contentResolver, "screen_brightness");
        } catch (Settings.SettingNotFoundException unused2) {
            return -1;
        }
    }

    public static float getScreenDensity() {
        if (C1316a.m9955a() == null) {
            return ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) C1316a.m9955a().getSystemService("window");
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics.density;
    }

    public static int getScreenDensityDpi() {
        if (C1316a.m9955a() == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) C1316a.m9955a().getSystemService("window");
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics.densityDpi;
    }

    public static long getSdcardFreeSpace() {
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return (statFs.getBlockSize() * statFs.getAvailableBlocks()) / 1024;
    }

    public static String getSdcardPath() {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory != null) {
            return externalStorageDirectory.getAbsolutePath();
        }
        return null;
    }

    public static long getSdcardTotalSpace() {
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return (statFs.getBlockSize() * statFs.getBlockCount()) / 1024;
    }

    public static float getSystemMetricsX() {
        if (C1316a.m9955a() == null) {
            return ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) C1316a.m9955a().getSystemService("window");
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics.widthPixels;
    }

    public static float getSystemMetricsY() {
        if (C1316a.m9955a() == null) {
            return ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) C1316a.m9955a().getSystemService("window");
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics.heightPixels;
    }

    public static long getTotalMemory() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            String readLine = bufferedReader.readLine();
            r1 = readLine != null ? Integer.valueOf(readLine.split("\\s+")[1]).intValue() : 0L;
            bufferedReader.close();
        } catch (IOException unused) {
        }
        return r1;
    }

    public static long getTotalSpace() {
        StatFs statFs = new StatFs(Environment.getRootDirectory().getPath());
        return (statFs.getBlockSize() * statFs.getBlockCount()) / 1024;
    }

    public static ScanResult[] getWifiHotpot() {
        List<ScanResult> scanResults = ((WifiManager) C1316a.m9955a().getSystemService("wifi")).getScanResults();
        return (ScanResult[]) scanResults.toArray(new ScanResult[scanResults.size()]);
    }

    public static boolean isWifiConnected() {
        NetworkInfo networkInfo = ((ConnectivityManager) C1316a.m9955a().getSystemService("connectivity")).getNetworkInfo(1);
        if (networkInfo == null) {
            return false;
        }
        return networkInfo.isConnected();
    }

    public static void makeCall(String str) {
        C1316a.m9955a().startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:".concat(String.valueOf(str)))));
    }

    public static native void onNetworkStateChanged();

    public static void openUrl(String str) {
        C1316a.m9955a().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    public static int sendMMS(String str, String str2, String str3, String str4) {
        if (PhoneNumberUtils.isWellFormedSmsAddress(str)) {
            try {
                String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(Uri.fromFile(new File(str4)).toString()));
                Intent intent = new Intent("android.intent.action.SEND");
                intent.putExtra("address", str);
                intent.putExtra(Meta.SUBJECT, str2);
                intent.putExtra("sms_body", str3);
                intent.putExtra("android.intent.extra.STREAM", Uri.parse("file://".concat(String.valueOf(str4))));
                intent.setType(mimeTypeFromExtension);
                C1316a.m9955a().startActivity(intent);
                return 0;
            } catch (Exception unused) {
                return 2;
            }
        }
        return 1;
    }

    public static void sendSMS(String str, String str2) {
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:".concat(String.valueOf(str))));
        intent.putExtra("sms_body", str2);
        C1316a.m9955a().startActivity(intent);
    }

    public static void setNetworkChangedCallback() {
        unsetNetworkChangedCallback();
        f6447b = new BroadcastReceiver() { // from class: com.baidu.mapsdkvi.VDeviceAPI.1
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                VDeviceAPI.onNetworkStateChanged();
            }
        };
        C1316a.m9955a().registerReceiver(f6447b, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public static void setScreenAlwaysOn(boolean z) {
        if (z) {
            if (f6446a == null) {
                f6446a = ((PowerManager) C1316a.m9955a().getSystemService("power")).newWakeLock(10, "VDeviceAPI");
            }
            f6446a.acquire();
            return;
        }
        PowerManager.WakeLock wakeLock = f6446a;
        if (wakeLock == null || !wakeLock.isHeld()) {
            return;
        }
        f6446a.release();
        f6446a = null;
    }

    public static void setupSoftware(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(new File(str)), "application/vnd.android.package-archive");
        C1316a.m9955a().startActivity(intent);
    }

    public static void unsetNetworkChangedCallback() {
        if (f6447b != null) {
            C1316a.m9955a().unregisterReceiver(f6447b);
            f6447b = null;
        }
    }
}
