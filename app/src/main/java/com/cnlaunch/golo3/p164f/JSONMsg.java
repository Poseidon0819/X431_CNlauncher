package com.cnlaunch.golo3.p164f;

import com.cnlaunch.golo3.p165g.GoloLog;
import org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.cnlaunch.golo3.f.d */
/* loaded from: classes.dex */
public class JSONMsg {

    /* renamed from: a */
    public int f8441a = -1;

    /* renamed from: b */
    public String f8442b;

    /* renamed from: c */
    public JSONObject f8443c;

    /* renamed from: d */
    private String f8444d;

    /* renamed from: e */
    private JSONArray f8445e;

    /* renamed from: a */
    public final int m9156a(JSONObject jSONObject) throws JSONException {
        String simpleName = JSONMsg.class.getSimpleName();
        GoloLog.m9132a(simpleName, "response data:" + jSONObject.toString());
        this.f8441a = jSONObject.getInt("code");
        if (jSONObject.has("msg")) {
            this.f8442b = jSONObject.getString("msg");
        }
        if (!jSONObject.has(DataPacketExtension.ELEMENT_NAME) || jSONObject.get(DataPacketExtension.ELEMENT_NAME).equals("null") || jSONObject.get(DataPacketExtension.ELEMENT_NAME).equals("") || jSONObject.get(DataPacketExtension.ELEMENT_NAME).equals("[]")) {
            return 0;
        }
        if (jSONObject.get(DataPacketExtension.ELEMENT_NAME) instanceof JSONObject) {
            this.f8443c = jSONObject.getJSONObject(DataPacketExtension.ELEMENT_NAME);
            return 0;
        } else if (jSONObject.get(DataPacketExtension.ELEMENT_NAME) instanceof JSONArray) {
            this.f8445e = jSONObject.getJSONArray(DataPacketExtension.ELEMENT_NAME);
            return 0;
        } else if (jSONObject.get(DataPacketExtension.ELEMENT_NAME) instanceof String) {
            this.f8444d = jSONObject.getString(DataPacketExtension.ELEMENT_NAME);
            return 0;
        } else if (jSONObject.get(DataPacketExtension.ELEMENT_NAME) instanceof Integer) {
            this.f8444d = jSONObject.getString(DataPacketExtension.ELEMENT_NAME);
            return 0;
        } else {
            return 0;
        }
    }
}
