package com.cnlaunch.golo3.p163e;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.cnlaunch.golo3.e.d */
/* loaded from: classes.dex */
public final class SignUtils {
    /* renamed from: a */
    public static String m9158a(String str, Map<String, String> map) {
        String m9157a = m9157a(map);
        return MD5Util.m9159a(m9157a + str);
    }

    /* renamed from: a */
    private static String m9157a(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        if (map != null && map.size() > 0) {
            for (String str : map.keySet()) {
                String str2 = map.get(str);
                if (str2 != null && !str2.equals("") && !str.equalsIgnoreCase("sign")) {
                    hashMap.put(str, str2);
                }
            }
        }
        ArrayList arrayList = new ArrayList(hashMap.keySet());
        Collections.sort(arrayList);
        String str3 = "";
        for (int i = 0; i < arrayList.size(); i++) {
            String str4 = (String) arrayList.get(i);
            String str5 = (String) hashMap.get(str4);
            str3 = i == arrayList.size() - 1 ? str3 + str4 + "=" + str5 : str3 + str4 + "=" + str5 + "&";
        }
        return str3;
    }
}
