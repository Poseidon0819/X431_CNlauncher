package com.cnlaunch.p181j;

import android.content.Context;
import com.cnlaunch.diagnosemodule.DiagnoseBusiness;
import com.mopub.mobileads.VastExtensionXmlManager;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.cnlaunch.j.ad */
/* loaded from: classes.dex */
public final class TechDataAdapter implements SocketDataAdapter {

    /* renamed from: a */
    private Context f9424a;

    public TechDataAdapter(Context context) {
        this.f9424a = null;
        this.f9424a = context;
    }

    @Override // com.cnlaunch.p181j.SocketDataAdapter
    /* renamed from: a */
    public final void mo8677a(int i) {
        DiagnoseBusiness.getInstance(this.f9424a).sendRemoteDiagStatus(i);
    }

    @Override // com.cnlaunch.p181j.SocketDataAdapter
    /* renamed from: a */
    public final void mo8676a(String str) {
        if (str.contains("special_cmd")) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString(VastExtensionXmlManager.TYPE);
                String string2 = jSONObject.getString("cmd");
                if (string.equalsIgnoreCase("special_cmd")) {
                    DiagSocketController.m8651a().m8648a(string2, jSONObject);
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            if (new JSONObject(str).getString(VastExtensionXmlManager.TYPE).equalsIgnoreCase("remote_message")) {
                DiagSocketController.m8651a().m8646c(str);
                return;
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        DiagnoseBusiness.getInstance(this.f9424a).sendUIDataRemote(str);
    }
}
