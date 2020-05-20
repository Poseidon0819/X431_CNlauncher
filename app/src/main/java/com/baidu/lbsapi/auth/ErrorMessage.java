package com.baidu.lbsapi.auth;

import com.cnlaunch.p169im.p174db.MessageDao;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
class ErrorMessage {
    ErrorMessage() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m12392a(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", i);
            jSONObject.put(MessageDao.TABLENAME, str);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m12391a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", -1);
            jSONObject.put(MessageDao.TABLENAME, str);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }
}
