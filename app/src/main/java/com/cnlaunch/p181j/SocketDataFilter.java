package com.cnlaunch.p181j;

import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.mopub.mobileads.VastExtensionXmlManager;
import org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.cnlaunch.j.ac */
/* loaded from: classes.dex */
public final class SocketDataFilter {

    /* renamed from: a */
    public static String f9422a = "";

    /* renamed from: b */
    private long f9423b;

    /* renamed from: a */
    public static boolean m8679a(String str, String str2) {
        if (str.equalsIgnoreCase(DiagnoseConstants.UI_TYPE_CURRENT_MENU_PATH)) {
            boolean equalsIgnoreCase = f9422a.equalsIgnoreCase(str2);
            f9422a = str2;
            return equalsIgnoreCase;
        }
        return false;
    }

    /* renamed from: a */
    public final boolean m8678a(String str, JSONObject jSONObject) {
        if (DiagnoseConstants.UI_Type_ShowTransDiagInfo.equals(str)) {
            try {
                if (jSONObject.has(VastExtensionXmlManager.TYPE) && jSONObject.has(DataPacketExtension.ELEMENT_NAME) && DiagnoseConstants.UI_Type_ShowTransDiagInfo.equals(jSONObject.getString(VastExtensionXmlManager.TYPE))) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(DataPacketExtension.ELEMENT_NAME);
                    if (jSONObject2.has("ui_type") && jSONObject2.has(VastExtensionXmlManager.TYPE) && DiagnoseConstants.UI_Type_ShowTransDiagInfo.equals(jSONObject2.getString("ui_type"))) {
                        if (DiagnoseConstants.EXT1_GET_DEVICE_ADAPTER_LICENSE.equals(jSONObject2.getString(VastExtensionXmlManager.TYPE))) {
                            return false;
                        }
                        if ("94".equals(jSONObject2.getString(VastExtensionXmlManager.TYPE)) && "3".equals(jSONObject2.getString("model"))) {
                            if (m8680a()) {
                                return false;
                            }
                        }
                    }
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else if (DiagnoseConstants.UI_TYPE_DIAG_CALL_SERVICE.equals(str)) {
            return false;
        } else {
            if ((DiagnoseConstants.UI_TYPE_PAGE_DATASTREAM.equals(str) || DiagnoseConstants.UI_TYPE_SPECIAL_FUNCTION.equals(str) || DiagnoseConstants.UI_TYPE_ACTIVE_TEST.equals(str) || DiagnoseConstants.UI_Type_STD_EXT1.equals(str) || DiagnoseConstants.UI_TYPE_DATASTREAM.equals(str)) && m8680a()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private synchronized boolean m8680a() {
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.f9423b) < 500) {
            return true;
        }
        this.f9423b = currentTimeMillis;
        return false;
    }
}
