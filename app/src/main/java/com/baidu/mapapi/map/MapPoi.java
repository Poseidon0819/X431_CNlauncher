package com.baidu.mapapi.map;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class MapPoi {

    /* renamed from: d */
    private static final String f5075d = "MapPoi";

    /* renamed from: a */
    String f5076a;

    /* renamed from: b */
    LatLng f5077b;

    /* renamed from: c */
    String f5078c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m11184a(JSONObject jSONObject) {
        this.f5076a = jSONObject.optString("tx");
        String str = this.f5076a;
        if (str != null && !str.equals("")) {
            this.f5076a = this.f5076a.replaceAll("\\\\", "").replaceAll("/?[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>", "").replaceAll("[(/>)<]", "");
        }
        this.f5077b = CoordUtil.decodeNodeLocation(jSONObject.optString("geo"));
        this.f5078c = jSONObject.optString("ud");
    }

    public final String getName() {
        return this.f5076a;
    }

    public final LatLng getPosition() {
        return this.f5077b;
    }

    public final String getUid() {
        return this.f5078c;
    }
}
