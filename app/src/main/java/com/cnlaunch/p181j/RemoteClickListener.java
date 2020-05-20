package com.cnlaunch.p181j;

import org.json.JSONObject;

/* renamed from: com.cnlaunch.j.x */
/* loaded from: classes.dex */
public interface RemoteClickListener {
    void initDataStreamConifg(String str, int i);

    void initVehicleInfo(JSONObject jSONObject);

    void onClick(String str);

    void onScrollPage(int i);

    void remoteOtherMessage(String str, int i);

    void switchPage(String str, String str2, int i);
}
