package com.cnlaunch.diagnosemodule.utils;

import android.util.Log;
import com.cnlaunch.physics.p205k.C1856n;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.io.UnsupportedEncodingException;
import org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class VersionCompatibileTool {
    public static boolean isVersionCom = false;

    public static boolean isVersionCom() {
        return isVersionCom;
    }

    public static void setVersionCom(boolean z) {
        isVersionCom = z;
    }

    public static String compatibleSendData(String str, int i) throws JSONException, UnsupportedEncodingException {
        setVersionCom(true);
        JSONObject jSONObject = new JSONObject(str);
        int i2 = 0;
        if (i != 0) {
            if (i == 1) {
                String string = jSONObject.has("cmd") ? jSONObject.getString("cmd") : "";
                String string2 = jSONObject.getString(VastExtensionXmlManager.TYPE);
                if (string2.equals("1")) {
                    if (string.contains("-1")) {
                        return createBaseOldJsonCMD(1).put(DataPacketExtension.ELEMENT_NAME, "back").toString();
                    }
                    return createBaseOldJsonCMD(1).put(DataPacketExtension.ELEMENT_NAME, string).toString();
                } else if (string2.equals("6")) {
                    if (string.equals("00")) {
                        return createBaseOldJsonCMD(6).put(DataPacketExtension.ELEMENT_NAME, 0).toString();
                    }
                    if (string.equals("01")) {
                        return createBaseOldJsonCMD(6).put(DataPacketExtension.ELEMENT_NAME, 1).toString();
                    }
                    if (string.equals("02")) {
                        return createBaseOldJsonCMD(6).put(DataPacketExtension.ELEMENT_NAME, 2).toString();
                    }
                    if (string.equals("03")) {
                        return createBaseOldJsonCMD(6).put(DataPacketExtension.ELEMENT_NAME, 3).toString();
                    }
                    return string.equals("04") ? createBaseOldJsonCMD(6).put(DataPacketExtension.ELEMENT_NAME, 4).toString() : "";
                } else if (string2.equals("7") || string2.equals("8") || string2.equals(DiagnoseConstants.FEEDBACK_INPUT_NUMBER) || string2.equals("16")) {
                    return createBaseOldJsonCMD(7).put(DataPacketExtension.ELEMENT_NAME, string).toString();
                } else {
                    if (string2.equals("9")) {
                        return createBaseOldJsonCMD(-9).put(DataPacketExtension.ELEMENT_NAME, string).toString();
                    }
                    if (string2.equals("3")) {
                        if (string.contains("1")) {
                            return createBaseOldJsonCMD(17).put(DataPacketExtension.ELEMENT_NAME, string).toString();
                        }
                        return createBaseOldJsonCMD(17).put(DataPacketExtension.ELEMENT_NAME, "back").toString();
                    } else if (string2.equals(DiagnoseConstants.FEEDBACK_DATASTREAM)) {
                        return createBaseOldJsonCMD(18).put(DataPacketExtension.ELEMENT_NAME, "back").toString();
                    } else {
                        if (string2.equals(DiagnoseConstants.FEEDBACK_DATASTREAM_VW)) {
                            return createBaseOldJsonCMD(19).put(DataPacketExtension.ELEMENT_NAME, "back").toString();
                        }
                        if (string2.equals(DiagnoseConstants.FEEDBACK_DATASTREAM_PAGE)) {
                            return createBaseOldJsonCMD(14).put(DataPacketExtension.ELEMENT_NAME, "back").toString();
                        }
                        if (string2.equals(DiagnoseConstants.FEEDBACK_FAULTCODES)) {
                            return createBaseOldJsonCMD(14).put(DataPacketExtension.ELEMENT_NAME, "back").toString();
                        }
                        if (string2.equals(DiagnoseConstants.FEEDBACK_FREEZEFRAME)) {
                            if (string.equals(DiagnoseConstants.FEEDBACK_FAULTCODE_BACK)) {
                                return createBaseOldJsonCMD(27).put(DataPacketExtension.ELEMENT_NAME, "back").toString();
                            }
                            return createBaseOldJsonCMD(27).put(DataPacketExtension.ELEMENT_NAME, string).toString();
                        } else if (string2.equals(DiagnoseConstants.FEEDBACK_COMBINATION_MENU)) {
                            return createBaseOldJsonCMD(46).put(DataPacketExtension.ELEMENT_NAME, "back").toString();
                        } else {
                            C1856n.m8127b("Sanda", "[compatibleReciveData:identify=" + i + "|type=" + string2 + "|cmdStr=" + string + "]");
                            return createBaseOldJsonCMD(0).put(DataPacketExtension.ELEMENT_NAME, "").toString();
                        }
                    }
                }
            }
            return "";
        }
        int i3 = jSONObject.getInt(VastExtensionXmlManager.TYPE);
        JSONObject jSONObject2 = jSONObject.getJSONObject(DataPacketExtension.ELEMENT_NAME);
        if (i3 == 100) {
            int i4 = jSONObject2.getInt("ui_type");
            if (i4 == 100) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("messageTitle", jSONObject2.get("title"));
                jSONObject3.put("messageContent", jSONObject2.get("content"));
                String jSONObject4 = createBaseOldJsonDAT(5).put(DataPacketExtension.ELEMENT_NAME, jSONObject3).toString();
                StringBuilder sb = new StringBuilder();
                sb.append(i == 0 ? "车主" : "技师");
                sb.append("Send数据：旧版");
                sb.append(jSONObject4);
                C1856n.m8130a("Sanda", sb.toString());
                return jSONObject4;
            }
            int i5 = i4 != 110 ? i4 != 120 ? i4 != 130 ? i4 != 140 ? i4 != 150 ? 0 : 5 : 4 : 3 : 2 : 1;
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("dialogStyle", i5);
            jSONObject5.put("messageTitle", jSONObject2.get("title"));
            jSONObject5.put("messageContent", jSONObject2.get("content"));
            return createBaseOldJsonDAT(6).put(DataPacketExtension.ELEMENT_NAME, jSONObject5).toString();
        } else if (i3 == 200) {
            int i6 = jSONObject2.getInt("ui_type");
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("messageTitle", jSONObject2.get("title"));
            jSONObject6.put("messageContent", jSONObject2.get("content"));
            if (i6 != 210) {
                if (i6 != 220) {
                    return i6 != 230 ? "" : createBaseOldJsonDAT(15).put(DataPacketExtension.ELEMENT_NAME, jSONObject6).toString();
                }
                return createBaseOldJsonDAT(7).put(DataPacketExtension.ELEMENT_NAME, jSONObject6).toString();
            }
            return createBaseOldJsonDAT(8).put(DataPacketExtension.ELEMENT_NAME, jSONObject6).toString();
        } else if (i3 == 300) {
            JSONArray jSONArray = jSONObject2.getJSONArray("menudata");
            JSONArray jSONArray2 = new JSONArray();
            for (int i7 = 1; i7 < jSONArray.length(); i7++) {
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.put("content", jSONArray.getJSONObject(i7).get("title"));
                jSONArray2.put(i2, jSONObject7);
                i2++;
            }
            return createBaseOldJsonDAT(1).put(DataPacketExtension.ELEMENT_NAME, jSONArray2).toString();
        } else if (i3 == 500) {
            JSONArray jSONArray3 = jSONObject2.getJSONArray("menudata");
            JSONArray jSONArray4 = new JSONArray();
            while (i2 < jSONArray3.length()) {
                JSONObject jSONObject8 = new JSONObject();
                jSONObject8.put("content", jSONArray3.getJSONObject(i2).get("title"));
                jSONArray4.put(i2, jSONObject8);
                i2++;
            }
            return createBaseOldJsonDAT(17).put(DataPacketExtension.ELEMENT_NAME, jSONArray4).toString();
        } else if (i3 == 600) {
            try {
                JSONObject createBaseOldJsonDAT = createBaseOldJsonDAT(9);
                JSONArray jSONArray5 = jSONObject2.getJSONArray("menudata");
                JSONArray jSONArray6 = jSONObject2.getJSONArray("buttondata");
                JSONArray jSONArray7 = new JSONArray();
                for (int i8 = 0; i8 < jSONArray5.length(); i8++) {
                    JSONObject jSONObject9 = new JSONObject();
                    jSONObject9.put("datastreamName", jSONArray5.getJSONObject(i8).get("title"));
                    jSONObject9.put("datastreamValue", jSONArray5.getJSONObject(i8).get("value"));
                    jSONObject9.put("datastreamUnit", jSONArray5.getJSONObject(i8).get("unit"));
                    jSONArray7.put(i8, jSONObject9);
                }
                createBaseOldJsonDAT.put("data1", jSONArray7);
                JSONArray jSONArray8 = new JSONArray();
                while (i2 < jSONArray6.length()) {
                    JSONObject jSONObject10 = new JSONObject();
                    jSONObject10.put("text", jSONArray6.getJSONObject(i2).get("title"));
                    jSONObject10.put("buttonId", jSONArray6.getJSONObject(i2).get("cmd"));
                    jSONArray8.put(i2, jSONObject10);
                    i2++;
                }
                createBaseOldJsonDAT.put(DataPacketExtension.ELEMENT_NAME, jSONArray8);
                return createBaseOldJsonDAT.toString();
            } catch (Exception e) {
                Log.e("Sanda", e.toString());
                return "";
            }
        } else if (i3 == 700) {
            JSONArray jSONArray9 = jSONObject2.getJSONArray("menudata");
            JSONArray jSONArray10 = new JSONArray();
            while (i2 < jSONArray9.length()) {
                JSONObject jSONObject11 = new JSONObject();
                jSONObject11.put("dtcCode", jSONArray9.getJSONObject(i2).get("title"));
                jSONObject11.put("dtcDescription", jSONArray9.getJSONObject(i2).get("context"));
                jSONObject11.put("dtcStatus", jSONArray9.getJSONObject(i2).get("status"));
                jSONObject11.put("dtcHelp", jSONArray9.getJSONObject(i2).get("help"));
                jSONArray10.put(i2, jSONObject11);
                i2++;
            }
            if (jSONObject2.getInt("ui_type") == 710) {
                return createBaseOldJsonDAT(38).put(DataPacketExtension.ELEMENT_NAME, jSONArray10).toString();
            }
            return createBaseOldJsonDAT(14).put(DataPacketExtension.ELEMENT_NAME, jSONArray10).toString();
        } else if (i3 == 800) {
            JSONArray jSONArray11 = jSONObject2.getJSONArray("menudata");
            JSONArray jSONArray12 = new JSONArray();
            while (i2 < jSONArray11.length()) {
                JSONObject jSONObject12 = new JSONObject();
                jSONObject12.put("datastreamID", jSONArray11.getJSONObject(i2).has("id") ? jSONArray11.getJSONObject(i2).get("id") : "");
                jSONObject12.put("datastreamName", jSONArray11.getJSONObject(i2).get("title"));
                jSONObject12.put("datastreamValue", jSONArray11.getJSONObject(i2).get("value"));
                jSONObject12.put("datastreamUnit", jSONArray11.getJSONObject(i2).get("unit"));
                jSONObject12.put("dtcHelp", "");
                jSONArray12.put(i2, jSONObject12);
                i2++;
            }
            return createBaseOldJsonDAT(18).put(DataPacketExtension.ELEMENT_NAME, jSONArray12).toString();
        } else {
            C1856n.m8127b("Sanda", "[compatibleReciveData:identify=" + i + "|type=" + i3 + "]");
            return jSONObject.toString();
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:817)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:856)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:856)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:856)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:856)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0145  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String compatibleReciveData(java.lang.String r10, int r11) throws org.json.JSONException, java.io.UnsupportedEncodingException {
        /*
            Method dump skipped, instructions count: 1656
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.diagnosemodule.utils.VersionCompatibileTool.compatibleReciveData(java.lang.String, int):java.lang.String");
    }

    public static JSONObject createBaseNewJson(int i) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ver", "3");
        jSONObject.put(VastExtensionXmlManager.TYPE, i);
        return jSONObject;
    }

    public static JSONObject createBaseOldJsonCMD(int i) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(VastExtensionXmlManager.TYPE, i);
        jSONObject.put("app", "android");
        jSONObject.put("mode", "CMD");
        return jSONObject;
    }

    public static JSONObject createBaseOldJsonDAT(int i) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(VastExtensionXmlManager.TYPE, i);
        jSONObject.put("app", "android");
        jSONObject.put("mode", "DAT");
        jSONObject.put("position", "0");
        return jSONObject;
    }
}
