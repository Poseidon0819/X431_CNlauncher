package com.cnlaunch.diagnosemodule.utils;

import com.cnlaunch.diagnosemodule.JsonConstText;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class NewFrameData2JsonUtil {
    public static JSONObject createBaseNewJson(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(JsonConstText.Const_Text_Ver, "3");
        jSONObject.put(JsonConstText.Const_Text_Type, str);
        return jSONObject;
    }

    public static JSONObject AddDataJsonObjToNewJson(JSONObject jSONObject, String str) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(JsonConstText.Const_Text_Ui_type, str);
        jSONObject.put(JsonConstText.Const_Text_Data, jSONObject2);
        return jSONObject2;
    }
}
