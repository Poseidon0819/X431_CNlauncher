package com.unionpay.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.unionpay.utils.i */
/* loaded from: classes2.dex */
public final class C4651i {
    /* renamed from: a */
    public static Object m439a(JSONArray jSONArray, int i) {
        if (jSONArray != null && i < jSONArray.length() && i >= 0) {
            try {
                return jSONArray.get(i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: a */
    public static String m438a(JSONObject jSONObject, String str) {
        if (m435d(jSONObject, str)) {
            try {
                return jSONObject.getString(str);
            } catch (JSONException unused) {
                C4652j.m432b("uppay", C4651i.class.toString() + " get " + str + " failed!!");
                return "";
            }
        }
        return "";
    }

    /* renamed from: b */
    public static boolean m437b(JSONObject jSONObject, String str) {
        if (m435d(jSONObject, str)) {
            try {
                return jSONObject.getBoolean(str);
            } catch (JSONException unused) {
                C4652j.m432b("uppay", C4651i.class.toString() + " get " + str + " failed!!");
            }
        }
        return false;
    }

    /* renamed from: c */
    public static JSONArray m436c(JSONObject jSONObject, String str) {
        if (m435d(jSONObject, str)) {
            try {
                return jSONObject.getJSONArray(str);
            } catch (JSONException unused) {
                C4652j.m432b("uppay", C4651i.class.toString() + " get " + str + " failed!!");
            }
        }
        return null;
    }

    /* renamed from: d */
    private static boolean m435d(JSONObject jSONObject, String str) {
        return jSONObject != null && jSONObject.has(str);
    }
}
