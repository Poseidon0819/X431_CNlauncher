package com.baidu.mapapi;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import com.baidu.mapsdkplatform.comapi.util.SysUpdateObservable;

/* loaded from: classes.dex */
public class NetworkUtil {
    public static NetworkInfo getActiveNetworkInfo(Context context) {
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getCurrentNetMode(Context context) {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        int i = 1;
        if (activeNetworkInfo != null) {
            if (activeNetworkInfo.getType() != 1) {
                switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                    case 1:
                    case 2:
                        i = 6;
                        break;
                    case 3:
                    case 9:
                    case 10:
                    case 15:
                        i = 9;
                        break;
                    case 4:
                        i = 5;
                        break;
                    case 5:
                    case 6:
                    case 7:
                    case 12:
                        i = 7;
                        break;
                    case 8:
                        i = 8;
                        break;
                    case 11:
                        i = 2;
                        break;
                    case 13:
                        i = 4;
                        break;
                    case 14:
                        i = 10;
                        break;
                }
            }
            return Integer.toString(i);
        }
        i = 0;
        return Integer.toString(i);
    }

    public static boolean initConnectState() {
        return true;
    }

    public static boolean isNetworkAvailable(Context context) {
        if (isWifiConnected(context)) {
            return true;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            if (activeNetworkInfo.isConnectedOrConnecting()) {
                return true;
            }
        }
        return false;
    }

    public static boolean isWifiConnected(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || 1 != activeNetworkInfo.getType()) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isWifiConnected(NetworkInfo networkInfo) {
        if (networkInfo != null) {
            try {
                if (1 == networkInfo.getType()) {
                    return networkInfo.isConnected();
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public static boolean isWifiState(Context context) {
        if (context == null) {
            return false;
        }
        int i = -1;
        try {
            i = ((WifiManager) context.getSystemService("wifi")).getWifiState();
        } catch (Exception unused) {
        }
        return i == 3;
    }

    public static void updateNetworkProxy(Context context) {
        SysUpdateObservable.getInstance().updateNetworkProxy(context);
    }
}
