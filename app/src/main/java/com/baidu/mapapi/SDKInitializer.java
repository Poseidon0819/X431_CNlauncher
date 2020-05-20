package com.baidu.mapapi;

import android.content.Context;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapsdkplatform.comapi.C1188b;

/* loaded from: classes.dex */
public class SDKInitializer {
    public static final String SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR = "network error";
    public static final String SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_ERROR = "permission check error";
    public static final String SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_OK = "permission check ok";
    public static final String SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE = "error_code";
    public static final String SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_MESSAGE = "error_message";

    /* renamed from: a */
    private static CoordType f4864a = CoordType.BD09LL;

    private SDKInitializer() {
    }

    public static CoordType getCoordType() {
        return f4864a;
    }

    public static void initialize(Context context) {
        initialize(null, context);
    }

    public static void initialize(Context context, boolean z, String str, String str2) {
        C1188b.m10824a(context, z, str, str2);
    }

    public static void initialize(String str, Context context) {
        C1188b.m10824a(context, false, null, str);
    }

    public static boolean isHttpsEnable() {
        return HttpClient.isHttpsEnable;
    }

    public static void setCoordType(CoordType coordType) {
        f4864a = coordType;
    }

    public static void setHttpsEnable(boolean z) {
        HttpClient.isHttpsEnable = z;
    }
}
