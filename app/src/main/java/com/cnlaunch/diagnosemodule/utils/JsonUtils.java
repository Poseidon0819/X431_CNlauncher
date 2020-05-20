package com.cnlaunch.diagnosemodule.utils;

import android.util.Log;
import com.mopub.mobileads.VastExtensionXmlManager;
import com.unionpay.tsmservice.data.Constant;
import org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class JsonUtils {
    static boolean dataStreamExit = false;

    public static String cmdToJson(String str, String str2) {
        String replace = str2.replace("\"", "\\\"");
        if (DiagnoseConstants.DIAG_LIB_OLD) {
            sendOldDiagCommand(str, false, replace);
        }
        return String.format("{\"ver\":\"%1$s\",\"type\":\"%2$s\",\"cmd\":\"%3$s\"}", 3, str, replace);
    }

    public static String bytecmdToJson(String str, String str2) {
        if (DiagnoseConstants.DIAG_LIB_OLD) {
            sendOldDiagCommand(str, false, str2);
        }
        return String.format("{\"ver\":\"%1$s\",\"bytedata\":\"%2$s\",\"type\":\"%3$s\",\"cmd\":\"%4$s\"}", 3, "1", str, str2);
    }

    public static String specialRemotePageJson(String str, String str2, int i) {
        return String.format("{\"ver\":\"%1$s\",\"page_type\":\"%2$s\",\"cmd\":\"%3$s\",\"page\":\"%4$d\",\"type\":\"%5$s\"}", 3, str, str2, Integer.valueOf(i), "special_cmd");
    }

    public static String specialRemoteScrllJson(String str, String str2, int i) {
        return String.format("{\"ver\":\"%1$s\",\"type\":\"%2$s\",\"cmd\":\"%3$s\",\"position\":\"%4$s\"}", 3, str, str2, Integer.valueOf(i));
    }

    public static String specialRemoteConfigJson(JSONObject jSONObject, int i) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("ver", 3);
            jSONObject2.put(VastExtensionXmlManager.TYPE, "special_cmd");
            jSONObject2.put("cmd", "config_datastream");
            jSONObject2.put(DataPacketExtension.ELEMENT_NAME, jSONObject);
            jSONObject2.put("page_num", i);
            Log.w("Sanda", "specialRemoteConfigJson :" + jSONObject2.toString());
            return jSONObject2.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("Sanda", "specialRemoteConfigJson :" + e.toString());
            return "";
        }
    }

    public static String specialRemoteConfigJsonUser(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("ver", 3);
            jSONObject2.put(VastExtensionXmlManager.TYPE, "special_cmd");
            jSONObject2.put("cmd", "config_datastream");
            jSONObject2.put(DataPacketExtension.ELEMENT_NAME, jSONObject);
            return jSONObject2.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("Sanda", "specialRemoteConfigJson :" + e.toString());
            return "";
        }
    }

    public static String specialRemoteVehicleInfoJsonUser(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("ver", 3);
            jSONObject2.put(VastExtensionXmlManager.TYPE, "special_cmd");
            jSONObject2.put("cmd", "vehicle_info");
            jSONObject2.put(DataPacketExtension.ELEMENT_NAME, jSONObject);
            return jSONObject2.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("XEE", "specialRemoteVehicleInfoJsonUser :" + e.toString());
            return "";
        }
    }

    public static String specialWebRemoteSyestemFaultCodeJsonUser(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("ver", 3);
            jSONObject2.put(VastExtensionXmlManager.TYPE, "special_cmd");
            jSONObject2.put("cmd", "system_fault_code_info");
            jSONObject2.put(DataPacketExtension.ELEMENT_NAME, jSONObject);
            return jSONObject2.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("XEE", "specialRemoteVehicleInfoJsonUser :" + e.toString());
            return "";
        }
    }

    public static String specialRemoteOtherJsonUser(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("ver", 3);
            jSONObject2.put(VastExtensionXmlManager.TYPE, "special_cmd");
            jSONObject2.put("cmd", str);
            jSONObject2.put(DataPacketExtension.ELEMENT_NAME, jSONObject);
            return jSONObject2.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("XEE", "specialRemoteVehicleInfoJsonUser :" + e.toString());
            return "";
        }
    }

    public static String specialRemoteOtherJsonUser(JSONObject jSONObject, String str, int i) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("ver", 3);
            jSONObject2.put(VastExtensionXmlManager.TYPE, "special_cmd");
            jSONObject2.put("cmd", str);
            jSONObject2.put(DataPacketExtension.ELEMENT_NAME, jSONObject);
            if (i != -1) {
                jSONObject2.put("progress", i);
            }
            return jSONObject2.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("XEE", "specialRemoteVehicleInfoJsonUser :" + e.toString());
            return "";
        }
    }

    public static String cmdToJsonNoSendOld(String str, String str2) {
        return String.format("{\"ver\":\"%1$s\",\"type\":\"%2$s\",\"cmd\":\"%3$s\"}", 3, str, str2);
    }

    public static String cmdToJsonForRemote(String str, String str2) {
        return cmdToJson(str, str2);
    }

    public static String cmdToJson(String str, int i) {
        return cmdToJson(str, String.valueOf(i));
    }

    public static String sendWaitDialog(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ver", 3);
            jSONObject.put(VastExtensionXmlManager.TYPE, str);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("ui_type", str2);
            jSONObject2.put("cancelable", true);
            jSONObject2.put("title", str3);
            jSONObject2.put("content", str4);
            jSONObject.put(DataPacketExtension.ELEMENT_NAME, jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static void sendOldDiagCommand(String str, boolean z, String str2) {
        byte[] intToFourHexBytesTwo;
        if (str.equals("7")) {
            try {
                intToFourHexBytesTwo = ByteHexHelper.intToFourHexBytesTwo(Integer.valueOf(str2).intValue());
            } catch (NumberFormatException unused) {
                intToFourHexBytesTwo = ByteHexHelper.intToFourHexBytesTwo(-1);
            }
        } else if (str.equals("8")) {
            intToFourHexBytesTwo = (str2 + "\u0000").getBytes();
        } else if (str.equals(DiagnoseConstants.FEEDBACK_INPUT_NUMBER) || str.equals("16")) {
            intToFourHexBytesTwo = ByteHexHelper.byteMerger(ByteHexHelper.byteMerger(ByteHexHelper.intToHexBytes(Integer.parseInt("0" + str2.substring(0, 1))), ByteHexHelper.bin2hex2byte(str2.substring(1))), ByteHexHelper.intToHexBytes(0));
        } else if (str.equals("3")) {
            DiagnoseConstants.DATASTREAM_MASK = str2;
            intToFourHexBytesTwo = ByteHexHelper.byteMerger(ByteHexHelper.byteMerger(ByteHexHelper.intToTwoHexBytes(0), ByteHexHelper.intToTwoHexBytes(ByteHexHelper.binaryString2hexString(str2).length() / 2)), ByteHexHelper.binaryString2bytes(str2));
        } else if (str.equals(DiagnoseConstants.FEEDBACK_DATASTREAM_PAGE) || str.equals("0") || str.equals(DiagnoseConstants.FEEDBACK_COMBINATION_MENU)) {
            intToFourHexBytesTwo = ByteHexHelper.hexStringToBytes(str2);
        } else if (str.equals(DiagnoseConstants.FEEDBACK_DATASTREAM_PAGE_MASK) || str.equals(DiagnoseConstants.FEEDBACK_FAULTCODES) || str.equals(DiagnoseConstants.FEEDBACK_DISPLAY_VERSION) || str.equals(DiagnoseConstants.UI_TYPE_GET_DEVICE_DISTRICT)) {
            intToFourHexBytesTwo = str2.equals(DiagnoseConstants.FEEDBACK_FAULTCODE_BACK) ? new byte[]{-1} : ByteHexHelper.hexStringToBytes(str2);
        } else if (str.equals("-1")) {
            intToFourHexBytesTwo = ByteHexHelper.intToTwoHexBytes(Integer.parseInt(str2));
        } else if (str.equals(DiagnoseConstants.FEEDBACK_SPECIA_FUNCTION)) {
            if (str2.equals(DiagnoseConstants.FEEDBACK_SPECIA_FUNCTION_REFRESH)) {
                intToFourHexBytesTwo = new byte[]{-1, -1};
            } else if (str2.contains(Constant.DEFAULT_CVN2)) {
                intToFourHexBytesTwo = ByteHexHelper.intToTwoHexBytes(Integer.parseInt(str2));
            } else {
                intToFourHexBytesTwo = ByteHexHelper.hexStringToBytes(str2);
            }
        } else if (str.equals("1")) {
            if (str2.lastIndexOf("-") != -1) {
                intToFourHexBytesTwo = ByteHexHelper.byteMerger(new byte[]{-1}, ByteHexHelper.intToHexBytes(Integer.parseInt(str2.substring(2))));
            } else {
                intToFourHexBytesTwo = ByteHexHelper.hexStringToBytes(str2);
            }
        } else if (str.equals(DiagnoseConstants.FEEDBACK_FAULTCODES_ACTIVE)) {
            if (str2.equals(DiagnoseConstants.FEEDBACK_FAULTCODE_BACK)) {
                DiagnoseConstants.OLD_DIAG_FEEDBACK = null;
                intToFourHexBytesTwo = new byte[]{-1, -1};
            } else {
                intToFourHexBytesTwo = ByteHexHelper.intToTwoHexBytes(Integer.parseInt(str2));
            }
        } else if (str.equals(DiagnoseConstants.FEEDBACK_GET_VIN) || str.equals(DiagnoseConstants.FEEDBACK_SET_VIN)) {
            intToFourHexBytesTwo = ByteHexHelper.byteMerger(ByteHexHelper.intToHexBytes(str2.length()), ByteHexHelper.bin2hex2byte(str2));
            DiagnoseConstants.OLD_DIAG_FEEDBACK = intToFourHexBytesTwo;
        } else {
            intToFourHexBytesTwo = ByteHexHelper.intToHexBytes(Integer.parseInt(str2));
        }
        if (DiagnoseConstants.OLD_DIAG_FEEDBACK == null) {
            DiagnoseConstants.OLD_DIAG_FEEDBACK = intToFourHexBytesTwo;
        }
        DiagnoseConstants.OLD_DIAG_WAIT = z;
    }
}
