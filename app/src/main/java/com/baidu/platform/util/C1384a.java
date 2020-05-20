package com.baidu.platform.util;

import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: com.baidu.platform.util.a */
/* loaded from: classes.dex */
public class C1384a implements ParamBuilder<C1384a> {

    /* renamed from: a */
    protected Map<String, String> f6527a;

    /* renamed from: a */
    public C1384a m9767a(String str, String str2) {
        if (this.f6527a == null) {
            this.f6527a = new LinkedHashMap();
        }
        this.f6527a.put(str, str2);
        return this;
    }

    /* renamed from: a */
    public String m9768a() {
        StringBuilder sb;
        Map<String, String> map = this.f6527a;
        if (map == null || map.isEmpty()) {
            return null;
        }
        String str = new String();
        int i = 0;
        for (String str2 : this.f6527a.keySet()) {
            String encodeUrlParamsValue = AppMD5.encodeUrlParamsValue(this.f6527a.get(str2));
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
