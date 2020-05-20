package com.unionpay.mobile.android.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* loaded from: classes2.dex */
public class PreferenceUtils {
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003c, code lost:
        if (com.unionpay.mobile.android.utils.C4382c.m885a(r3) != false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x002b, code lost:
        if (com.unionpay.mobile.android.utils.C4382c.m885a(r3) != false) goto L8;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m905a(android.content.Context r7) {
        /*
            java.lang.String r0 = "uid"
            java.lang.String r1 = "tag1"
            java.lang.String r2 = "UnionPayPluginEx_v2.pref"
            r3 = 0
            android.content.SharedPreferences r2 = r7.getSharedPreferences(r2, r3)
            java.lang.String r3 = ""
            java.lang.String r3 = r2.getString(r0, r3)
            java.lang.String r4 = ""
            java.lang.String r4 = r2.getString(r1, r4)
            java.lang.String r5 = ""
            boolean r6 = android.text.TextUtils.isEmpty(r3)
            if (r6 != 0) goto L55
            int r4 = r3.length()
            r5 = 32
            if (r4 != r5) goto L2e
            boolean r4 = com.unionpay.mobile.android.utils.C4382c.m885a(r3)
            if (r4 == 0) goto L3e
            goto L40
        L2e:
            java.lang.String r3 = m902a(r3)
            int r4 = r3.length()
            if (r4 != r5) goto L3e
            boolean r4 = com.unionpay.mobile.android.utils.C4382c.m885a(r3)
            if (r4 != 0) goto L40
        L3e:
            java.lang.String r3 = ""
        L40:
            r5 = r3
            android.content.SharedPreferences$Editor r2 = r2.edit()
            r2.remove(r0)
            r2.commit()
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 != 0) goto L5f
            m903a(r7, r5, r1)
            goto L5f
        L55:
            boolean r7 = android.text.TextUtils.isEmpty(r4)
            if (r7 != 0) goto L5f
            java.lang.String r5 = m902a(r4)
        L5f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unionpay.mobile.android.utils.PreferenceUtils.m905a(android.content.Context):java.lang.String");
    }

    /* renamed from: a */
    public static String m904a(Context context, String str) {
        return m902a(context.getSharedPreferences("UnionPayPluginEx_v2.pref", 0).getString(str, ""));
    }

    /* renamed from: a */
    private static String m902a(String str) {
        String m897b = m897b(str, ("6972c2be8559884c23456789abcdef12123456786789abcd").substring(0, 32));
        return (m897b != null && m897b.endsWith("6972c2be8559884c")) ? m897b.substring(0, m897b.length() - 16) : "";
    }

    /* renamed from: a */
    private static String m901a(String str, String str2) {
        try {
            return C4381b.m889a(C4384e.m875a(C4381b.m890a(str2), str.getBytes("utf-8")));
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: a */
    public static void m903a(Context context, String str, String str2) {
        String substring = ("6972c2be8559884c23456789abcdef12123456786789abcd").substring(0, 32);
        String m901a = m901a(str + "6972c2be8559884c", substring);
        if (m901a == null) {
            m901a = "";
        }
        SharedPreferences.Editor edit = context.getSharedPreferences("UnionPayPluginEx_v2.pref", 0).edit();
        edit.putString(str2, m901a);
        edit.commit();
    }

    /* renamed from: b */
    public static String m900b(Context context) {
        return m898b(context, "last_pay_method", "tag2");
    }

    /* renamed from: b */
    private static String m898b(Context context, String str, String str2) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("UnionPayPluginEx_v2.pref", 0);
        String string = sharedPreferences.getString(str, "");
        String string2 = sharedPreferences.getString(str2, "");
        if (TextUtils.isEmpty(string)) {
            return !TextUtils.isEmpty(string2) ? m902a(string2) : "";
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.remove(str);
        edit.commit();
        return "";
    }

    /* renamed from: b */
    private static String m897b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new String(C4384e.m874b(C4381b.m890a(str2), C4381b.m890a(str)), "utf-8").trim();
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: b */
    public static void m899b(Context context, String str) {
        m903a(context, str, "tag1");
    }

    /* renamed from: c */
    public static String m896c(Context context) {
        return m898b(context, "last_user", "tag3");
    }

    /* renamed from: c */
    public static void m895c(Context context, String str) {
        m903a(context, str, "tag2");
    }

    /* renamed from: d */
    public static void m894d(Context context, String str) {
        m903a(context, str, "tag3");
    }

    public static native String decPrefData(String str, String str2);

    public static native String forConfig(int i, String str);
}
