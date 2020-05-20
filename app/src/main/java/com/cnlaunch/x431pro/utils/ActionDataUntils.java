package com.cnlaunch.x431pro.utils;

import android.util.Log;
import org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.cnlaunch.x431pro.utils.a */
/* loaded from: classes.dex */
public final class ActionDataUntils {
    /* renamed from: a */
    public static boolean m5195a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.getString(DataPacketExtension.ELEMENT_NAME).equals("")) {
                Log.e("Sanda", "空白项 checkJson=".concat(String.valueOf(str)));
                return false;
            } else if (jSONObject.getString(DataPacketExtension.ELEMENT_NAME).equals("[]")) {
                Log.e("Sanda", "空白数组 checkJson=".concat(String.valueOf(str)));
                return false;
            } else {
                return true;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("Sanda", "checkJson=" + str + "  e=" + e.toString());
            return false;
        }
    }
}
