package com.unionpay.mobile.android.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.unionpay.mobile.android.global.C4149a;
import com.unionpay.mobile.android.languages.C4171c;
import java.io.File;
import java.net.NetworkInterface;
import java.util.Locale;
import java.util.TimeZone;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* renamed from: com.unionpay.mobile.android.utils.f */
/* loaded from: classes2.dex */
public final class C4385f {
    /* renamed from: a */
    public static String m873a() {
        return Locale.getDefault().toString().startsWith("zh") ? "zh_CN" : "en_US";
    }

    /* renamed from: a */
    public static String m872a(Context context) {
        Activity activity = (Activity) context;
        try {
            String str = activity.getPackageManager().getPackageInfo(activity.getPackageName(), 4160).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return C4171c.f22227bD.f22254a;
    }

    /* renamed from: a */
    private static String m871a(String str) {
        try {
            byte[] hardwareAddress = NetworkInterface.getByName(str).getHardwareAddress();
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
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: b */
    public static String m870b() {
        return new File("/system/bin/su").exists() ? "1" : "0";
    }

    /* renamed from: b */
    public static String m869b(Context context) {
        String packageName;
        return (context == null || !(context instanceof Activity) || (packageName = ((Activity) context).getPackageName()) == null) ? "" : packageName;
    }

    /* renamed from: c */
    public static String m868c() {
        String trim = Build.MODEL.trim();
        if (trim != null) {
            trim.replace(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, "");
        }
        return trim;
    }

    /* renamed from: c */
    public static final String m867c(Context context) {
        String str = "";
        if (Build.VERSION.SDK_INT < 23) {
            try {
                WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
                if (connectionInfo != null && connectionInfo.getMacAddress() != null) {
                    str = connectionInfo.getMacAddress();
                }
                if (str == null || str.length() == 0) {
                    str = m871a("wlan0");
                }
            } catch (Exception unused) {
            }
            return (str == null || str == "") ? "" : str.replaceAll(":", "");
        }
        str = m871a("wlan0");
        if (str == null) {
            return "";
        }
    }

    /* renamed from: d */
    public static String m866d() {
        return (C4149a.f22105I + "*" + C4149a.f22131t).trim();
    }

    /* renamed from: d */
    public static String m865d(Context context) {
        String str;
        try {
            str = new File("/system/bin/su").exists() ? m867c(context) : ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception unused) {
            str = "";
        }
        if (str == null || str.length() == 0) {
            str = PreferenceUtils.m905a(context);
        }
        C4390k.m838a("uppay", "user=".concat(String.valueOf(str)));
        return str;
    }

    /* renamed from: e */
    public static String m864e() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls.newInstance(), "gsm.version.baseband", "no message");
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: e */
    public static String m863e(Context context) {
        try {
            String subscriberId = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
            return subscriberId == null ? "" : subscriberId;
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: f */
    public static String m862f() {
        return TimeZone.getDefault().getDisplayName(false, 0);
    }

    /* renamed from: f */
    public static String m861f(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            if (activeNetworkInfo.getType() != 0) {
                return activeNetworkInfo.getType() == 1 ? "wifi" : "other";
            } else if (activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED) {
                return "mobile:" + activeNetworkInfo.getExtraInfo();
            } else {
                return "mobile";
            }
        }
        return "disConnect";
    }

    /* renamed from: g */
    public static Location m860g(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        Location location = null;
        try {
            if (locationManager.isProviderEnabled("gps")) {
                location = locationManager.getLastKnownLocation("gps");
                if (location == null && locationManager.isProviderEnabled("network")) {
                    return locationManager.getLastKnownLocation("network");
                }
            } else if (locationManager.isProviderEnabled("network")) {
                location = locationManager.getLastKnownLocation("network");
            }
        } catch (Exception unused) {
        }
        return location;
    }

    /* renamed from: h */
    public static String m859h(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getLine1Number();
        } catch (Exception unused) {
            return "";
        }
    }
}
