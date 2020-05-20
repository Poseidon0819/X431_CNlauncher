package com.cnlaunch.golo3.p163e;

import android.text.TextUtils;
import com.cnlaunch.golo3.p160b.ApplicationConfig;
import com.cnlaunch.golo3.p165g.GoloLog;
import com.p099c.p100a.p103c.RequestParams;
import java.util.HashMap;
import java.util.Map;

/* compiled from: HttpParamsUtils.java */
/* renamed from: com.cnlaunch.golo3.e.b */
/* loaded from: classes.dex */
public class C1610b {
    /* renamed from: a */
    public static RequestParams m9161a(Map<String, String> map) {
        RequestParams requestParams = new RequestParams();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            requestParams.m9702a(entry.getKey(), entry.getValue());
        }
        return requestParams;
    }

    /* renamed from: b */
    private static String m9160b(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getKey() + "=" + entry.getValue() + "&");
        }
        return sb.substring(0, sb.toString().length() - 1);
    }

    /* renamed from: a */
    public static String m9162a(int i, String str, Map<String, String> map) {
        if (str != null) {
            String str2 = str.split("\\?action=").length > 1 ? str.split("\\?action=")[1] : str;
            HashMap hashMap = new HashMap();
            hashMap.put("action", str2);
            if (!TextUtils.isEmpty(ApplicationConfig.m9181a())) {
                hashMap.put("user_id", ApplicationConfig.m9181a());
            }
            hashMap.put("app_id", ApplicationConfig.f7814m);
            hashMap.put("ver", ApplicationConfig.f7816o);
            hashMap.putAll(map);
            String m9158a = SignUtils.m9158a(ApplicationConfig.m9178b(), hashMap);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("app_id", ApplicationConfig.f7814m);
            hashMap2.put("sign", m9158a);
            if (!TextUtils.isEmpty(ApplicationConfig.m9181a())) {
                hashMap2.put("user_id", ApplicationConfig.m9181a());
            }
            hashMap2.put("ver", ApplicationConfig.f7816o);
            if (i == 0) {
                hashMap2.putAll(map);
            }
            String str3 = str + "&" + m9160b(hashMap2);
            C1610b.class.getSimpleName();
            GoloLog.m9131b();
            return str3;
        }
        throw new IllegalArgumentException("Url is null");
    }
}
