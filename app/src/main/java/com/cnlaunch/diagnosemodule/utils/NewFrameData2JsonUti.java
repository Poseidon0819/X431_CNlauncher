package com.cnlaunch.diagnosemodule.utils;

import com.cnlaunch.diagnosemodule.JsonConstText;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class NewFrameData2JsonUti {
    private static JSONObject dataObj;
    private static JSONObject root;

    public static JSONObject createBaseNewJson(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(JsonConstText.Const_Text_Ver, "3");
        jSONObject.put(JsonConstText.Const_Text_Type, str);
        return jSONObject;
    }

    public static JSONObject AddDataJsonObjToNewJson(String str, String str2) throws JSONException {
        root = createBaseNewJson(str);
        JSONObject jSONObject = new JSONObject();
        dataObj = jSONObject;
        jSONObject.put(JsonConstText.Const_Text_Ui_type, str2);
        root.put(JsonConstText.Const_Text_Data, dataObj);
        return dataObj;
    }

    public static String getRootObjStrAddReset() {
        JSONObject jSONObject = root;
        if (jSONObject == null) {
            return "";
        }
        String jSONObject2 = jSONObject.toString();
        if (root != null) {
            root = null;
        }
        if (dataObj != null) {
            dataObj = null;
        }
        return jSONObject2;
    }

    public static JSONObject getRoot() {
        return root;
    }

    public static JSONObject getDataObj() {
        return dataObj;
    }
}
