package com.unionpay.utils;

import android.content.Context;
import android.content.SharedPreferences;
import java.security.MessageDigest;

/* loaded from: classes2.dex */
public class UPUtils {
    /* renamed from: a */
    public static String m473a(Context context, String str) {
        String string = context.getSharedPreferences("UnionPayPluginEx.pref", 0).getString(str, "");
        String m468b = m468b(string, ("0000000023456789abcdef12123456786789abcd").substring(0, 32));
        return (m468b != null && m468b.endsWith("00000000")) ? m468b.substring(0, m468b.length() - 8) : "";
    }

    /* renamed from: a */
    public static String m471a(String str) {
        try {
            byte[] bytes = str.getBytes();
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.reset();
            messageDigest.update(bytes);
            return C4643a.m465a(messageDigest.digest());
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static String m470a(String str, String str2) {
        try {
            return C4643a.m465a(C4646d.m451a(C4643a.m466a(str2), str.getBytes("utf-8")));
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: a */
    public static void m474a(Context context, long j, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("UnionPayPluginEx.pref", 0).edit();
        edit.putLong(str, j);
        edit.commit();
    }

    /* renamed from: a */
    public static void m472a(Context context, String str, String str2) {
        String substring = ("0000000023456789abcdef12123456786789abcd").substring(0, 32);
        String m470a = m470a(str + "00000000", substring);
        if (m470a == null) {
            m470a = "";
        }
        SharedPreferences.Editor edit = context.getSharedPreferences("UnionPayPluginEx.pref", 0).edit();
        edit.putString(str2, m470a);
        edit.commit();
    }

    /* renamed from: b */
    private static String m468b(String str, String str2) {
        try {
            return new String(C4646d.m450b(C4643a.m466a(str2), C4643a.m466a(str)), "utf-8").trim();
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: b */
    public static void m469b(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("UnionPayPluginEx.pref", 0).edit();
        edit.remove(str);
        edit.commit();
    }

    /* renamed from: c */
    public static long m467c(Context context, String str) {
        return context.getSharedPreferences("UnionPayPluginEx.pref", 0).getLong(str, 0L);
    }

    public static native String forConfig(int i, String str);

    public static native String forUrl(int i);

    public static native String forWap(int i, String str);

    public static native String getIssuer(int i);

    public static native String getSubject(int i);

    public static native String getTalkingDataIdForAssist(int i);
}
