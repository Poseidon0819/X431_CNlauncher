package com.cnlaunch.golo3.p165g;

import com.cnlaunch.golo3.p160b.ApplicationConfig;

/* renamed from: com.cnlaunch.golo3.g.x */
/* loaded from: classes.dex */
public final class UserFaceUtils {
    /* renamed from: a */
    public static String m9115a(String str, String str2) {
        String str3;
        String m9116a = m9116a(str);
        if (C1621v.m9121a(null)) {
            str3 = "?888";
        } else {
            str3 = "?" + ((String) null);
        }
        return m9113b(str2, str) + "/face/" + m9116a + str + str3;
    }

    /* renamed from: a */
    public static String m9114a(String str, String str2, String str3) {
        if (str2 == null || !"0".equals(str2)) {
            String m9116a = m9116a(str);
            String concat = C1621v.m9121a(str2) ? "?888" : "?".concat(String.valueOf(str2));
            return m9113b(str3, str) + "/face/" + m9116a + str + ".thumb" + concat;
        }
        return null;
    }

    /* renamed from: a */
    private static String m9116a(String str) {
        if (str.length() < 6) {
            for (int length = str.length(); length < 6; length++) {
                str = str + "0";
            }
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length / 2; i++) {
            char c = charArray[i];
            charArray[i] = charArray[(charArray.length - i) - 1];
            charArray[(charArray.length - i) - 1] = c;
        }
        String substring = new String(charArray).substring(0, 6);
        return substring.charAt(0) + substring.charAt(1) + "/" + substring.charAt(2) + substring.charAt(3) + "/" + substring.charAt(4) + substring.charAt(5) + "/";
    }

    /* renamed from: b */
    private static String m9113b(String str, String str2) {
        return !C1621v.m9121a(str) ? str.equals("1") ? C1621v.m9121a(ApplicationConfig.f7809h) ? "http://file.api.dbscar.com" : ApplicationConfig.f7809h : C1621v.m9121a(ApplicationConfig.f7810i) ? "http://file.us.api.dbscar.com" : ApplicationConfig.f7810i : (Integer.parseInt(str2) <= 500000000 || Integer.parseInt(str2) >= 600000000) ? C1621v.m9121a(ApplicationConfig.f7809h) ? "http://file.api.dbscar.com" : ApplicationConfig.f7809h : C1621v.m9121a(ApplicationConfig.f7810i) ? "http://file.us.api.dbscar.com" : ApplicationConfig.f7810i;
    }
}
