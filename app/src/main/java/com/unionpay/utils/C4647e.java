package com.unionpay.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import java.net.NetworkInterface;

/* renamed from: com.unionpay.utils.e */
/* loaded from: classes2.dex */
public final class C4647e {
    /* renamed from: a */
    public static String m449a() {
        try {
            return Build.getRadioVersion();
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: a */
    public static final String m448a(Context context) {
        String str = "";
        if (Build.VERSION.SDK_INT < 23) {
            try {
                WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
                if (connectionInfo != null && connectionInfo.getMacAddress() != null) {
                    str = connectionInfo.getMacAddress();
                }
                if (str == null || str.length() == 0) {
                    str = m447a("wlan0");
                }
            } catch (Exception unused) {
            }
            return (str == null || str == "") ? "" : str.replaceAll(":", "");
        }
        str = m447a("wlan0");
        if (str == null) {
            return "";
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    private static String m447a(String str) {
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
    public static String m446b(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: c */
    public static String m445c(Context context) {
        try {
            String subscriberId = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
            return subscriberId == null ? "" : subscriberId;
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: d */
    public static Location m444d(Context context) {
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

    /* renamed from: e */
    public static String m443e(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getLine1Number();
        } catch (Exception unused) {
            return "";
        }
    }
}
