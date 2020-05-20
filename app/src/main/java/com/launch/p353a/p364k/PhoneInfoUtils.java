package com.launch.p353a.p364k;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* renamed from: com.launch.a.k.g */
/* loaded from: classes.dex */
public final class PhoneInfoUtils {
    @SuppressLint({"MissingPermission"})
    @TargetApi(23)
    /* renamed from: b */
    private static Map m2631b(Context context) {
        HashMap hashMap = new HashMap();
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class);
            String str = (String) method.invoke(null, "ril.gsm.imei", "");
            hashMap.put("meid", (String) method.invoke(null, "ril.cdma.meid", ""));
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split(",");
                if (split != null && split.length > 0) {
                    hashMap.put("imei1", split[0]);
                    if (split.length > 1) {
                        hashMap.put("imei2", split[1]);
                    } else {
                        hashMap.put("imei2", telephonyManager.getDeviceId(1));
                    }
                } else {
                    hashMap.put("imei1", telephonyManager.getDeviceId(0));
                    hashMap.put("imei2", telephonyManager.getDeviceId(1));
                }
            } else {
                hashMap.put("imei1", telephonyManager.getDeviceId(0));
                hashMap.put("imei2", telephonyManager.getDeviceId(1));
            }
        } catch (Exception unused) {
        }
        return hashMap;
    }

    @SuppressLint({"MissingPermission"})
    @TargetApi(26)
    /* renamed from: c */
    private static Map m2630c(Context context) {
        HashMap hashMap = new HashMap();
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            String imei = telephonyManager.getImei(0);
            String imei2 = telephonyManager.getImei(1);
            if (TextUtils.isEmpty(imei) && TextUtils.isEmpty(imei2)) {
                hashMap.put("imei1", telephonyManager.getMeid());
            } else {
                hashMap.put("imei1", imei);
                hashMap.put("imei2", imei2);
            }
            return hashMap;
        } catch (Exception unused) {
            return hashMap;
        }
    }

    /* renamed from: a */
    public static String m2633a(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (Build.VERSION.SDK_INT < 26) {
                return m2632a(m2631b(context));
            }
            return m2632a(m2630c(context));
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            return telephonyManager.getDeviceId();
        }
        return null;
    }

    /* renamed from: a */
    private static String m2632a(Map map) {
        if (map != null) {
            String str = (String) map.get("imei1");
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            String str2 = (String) map.get("imei2");
            if (str2 != null) {
                if (str.trim().length() == 15 && str2.trim().length() == 15) {
                    if (Long.parseLong(str.trim()) > Long.parseLong(str2.trim())) {
                        return str2 + ";" + str;
                    }
                    return str + ";" + str2;
                } else if (str.trim().length() != 15 && str2.trim().length() == 15) {
                    return str2;
                }
            }
            return str;
        }
        return "";
    }

    /* renamed from: a */
    public static String m2634a() {
        String str = DiagnoseConstants.FEEDBACK_DATASTREAM_PAGE_MASK + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) + (Build.DISPLAY.length() % 10) + (Build.HOST.length() % 10) + (Build.ID.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10) + (Build.TAGS.length() % 10) + (Build.TYPE.length() % 10) + (Build.USER.length() % 10);
        String str2 = null;
        try {
            str2 = Build.class.getField("SERIAL").get(null).toString();
            return new UUID(str.hashCode(), str2.hashCode()).toString();
        } catch (Exception unused) {
            return new UUID(str.hashCode(), str2.hashCode()).toString();
        }
    }
}
