package com.unionpay.mobile.android.utils;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.utils.j */
/* loaded from: classes2.dex */
public final class C4389j {
    /* renamed from: a */
    public static String m847a(JSONArray jSONArray, int i) {
        if (jSONArray == null || i < 0 || i >= jSONArray.length()) {
            return "";
        }
        try {
            return jSONArray.getString(i);
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    public static String m846a(JSONObject jSONObject, String str) {
        if (m840f(jSONObject, str)) {
            try {
                return jSONObject.getString(str);
            } catch (JSONException unused) {
                C4390k.m836c("uppay", C4389j.class.toString() + " get " + str + " failed!!");
                return "";
            }
        }
        return "";
    }

    /* renamed from: b */
    public static int m844b(JSONObject jSONObject, String str) {
        if (m840f(jSONObject, str)) {
            try {
                return jSONObject.getInt(str);
            } catch (JSONException unused) {
                C4390k.m836c("uppay", C4389j.class.toString() + " get " + str + " failed!!");
            }
        }
        return 0;
    }

    /* renamed from: b */
    public static Object m845b(JSONArray jSONArray, int i) {
        if (jSONArray != null && i < jSONArray.length() && i >= 0) {
            try {
                return jSONArray.get(i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: c */
    public static JSONObject m843c(JSONObject jSONObject, String str) {
        if (m840f(jSONObject, str)) {
            try {
                return jSONObject.getJSONObject(str);
            } catch (JSONException unused) {
                C4390k.m836c("uppay", C4389j.class.toString() + " get " + str + " failed!!");
            }
        }
        return null;
    }

    /* renamed from: d */
    public static JSONArray m842d(JSONObject jSONObject, String str) {
        if (m840f(jSONObject, str)) {
            try {
                return jSONObject.getJSONArray(str);
            } catch (JSONException unused) {
                C4390k.m836c("uppay", C4389j.class.toString() + " get " + str + " failed!!");
            }
        }
        return null;
    }

    /* renamed from: e */
    public static List<JSONArray> m841e(JSONObject jSONObject, String str) {
        ArrayList arrayList = new ArrayList(1);
        JSONArray m842d = m842d(jSONObject, str);
        for (int i = 0; m842d != null && i < m842d.length(); i++) {
            arrayList.add((JSONArray) m845b(m842d, i));
        }
        return arrayList;
    }

    /* renamed from: f */
    private static boolean m840f(JSONObject jSONObject, String str) {
        return jSONObject != null && jSONObject.has(str);
    }
}
