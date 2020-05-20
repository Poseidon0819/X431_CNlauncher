package com.cnlaunch.x431pro.utils;

import com.cnlaunch.p120d.p130d.MD5Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SignUtils.java */
/* renamed from: com.cnlaunch.x431pro.utils.y */
/* loaded from: classes.dex */
public final class C2786y {
    /* renamed from: a */
    public static String m4822a(String str, Map<String, String> map) {
        HashMap hashMap = new HashMap();
        if (map.size() > 0) {
            for (String str2 : map.keySet()) {
                String str3 = map.get(str2);
                if (str3 != null && !str3.equals("") && !str2.equalsIgnoreCase("sign")) {
                    hashMap.put(str2, str3);
                }
            }
        }
        ArrayList arrayList = new ArrayList(hashMap.keySet());
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            sb.append((String) hashMap.get((String) arrayList.get(i)));
        }
        sb.append(str);
        return MD5Utils.m9459b(sb.toString());
    }
}
