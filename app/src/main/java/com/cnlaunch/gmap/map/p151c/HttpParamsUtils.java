package com.cnlaunch.gmap.map.p151c;

import java.util.Map;

/* renamed from: com.cnlaunch.gmap.map.c.d */
/* loaded from: classes.dex */
public final class HttpParamsUtils {
    /* renamed from: a */
    public static String m9285a(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getKey() + "=" + entry.getValue() + "&");
        }
        return sb.substring(0, sb.toString().length() - 1);
    }
}
