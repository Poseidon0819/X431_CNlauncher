package com.baidu.mapsdkplatform.comapi.synchronization.p091d;

import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: com.baidu.mapsdkplatform.comapi.synchronization.d.d */
/* loaded from: classes.dex */
public final class C1258d {

    /* renamed from: a */
    private Map<String, String> f6209a;

    /* renamed from: a */
    public final C1258d m10447a(String str, String str2) {
        if (this.f6209a == null) {
            this.f6209a = new LinkedHashMap();
        }
        this.f6209a.put(str, str2);
        return this;
    }

    /* renamed from: a */
    public final String m10448a() {
        StringBuilder sb;
        Map<String, String> map = this.f6209a;
        if (map == null || map.isEmpty()) {
            return null;
        }
        String str = new String();
        int i = 0;
        for (String str2 : this.f6209a.keySet()) {
            String encodeUrlParamsValue = AppMD5.encodeUrlParamsValue(this.f6209a.get(str2));
            if (i == 0) {
                sb = new StringBuilder();
            } else {
                sb = new StringBuilder();
                sb.append(str);
                str = "&";
            }
            sb.append(str);
            sb.append(str2);
            sb.append("=");
            sb.append(encodeUrlParamsValue);
            str = sb.toString();
            i++;
        }
        return str;
    }
}
