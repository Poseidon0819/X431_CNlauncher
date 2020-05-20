package message.model;

import android.util.Log;
import org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension;
import org.jivesoftware.smackx.workgroup.packet.UserID;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: message.model.c */
/* loaded from: classes2.dex */
public final class MessageLoginEntity {

    /* renamed from: a */
    public String f24091a;

    /* renamed from: b */
    public String f24092b;

    /* renamed from: c */
    public String f24093c;

    /* renamed from: d */
    public int f24094d;

    /* renamed from: e */
    public String f24095e;

    /* renamed from: f */
    public String f24096f;

    public MessageLoginEntity(String str) {
        try {
            this.f24096f = str;
            JSONObject jSONObject = new JSONObject(str).getJSONObject(DataPacketExtension.ELEMENT_NAME);
            JSONObject jSONObject2 = jSONObject.getJSONObject(UserID.ELEMENT_NAME);
            JSONObject jSONObject3 = jSONObject.getJSONObject("xmpp");
            this.f24091a = m189a(jSONObject, "token");
            this.f24092b = m189a(jSONObject2, "user_id");
            this.f24093c = m189a(jSONObject3, "ip");
            this.f24094d = m188b(jSONObject3, "port");
            this.f24095e = m189a(jSONObject3, "domain");
        } catch (JSONException e) {
            Log.e("MessageLoginEntity", e.toString());
        }
    }

    /* renamed from: a */
    private static String m189a(JSONObject jSONObject, String str) {
        try {
            String string = jSONObject.getString(str);
            if ("null".equals(string)) {
                return null;
            }
            return string;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    private static int m188b(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getInt(str);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
