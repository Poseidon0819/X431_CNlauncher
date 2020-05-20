package com.cnlaunch.gmap.map.p145a.p146a;

import com.cnlaunch.gmap.map.logic.p153a.LcLatlng;
import com.cnlaunch.gmap.map.logic.p153a.LocationResult;
import com.cnlaunch.gmap.map.p145a.p146a.LocationSearch;
import com.cnlaunch.x431pro.activity.GDApplication;
import com.p099c.p100a.p103c.ResponseInfo;
import com.p099c.p100a.p103c.p104a.RequestCallBack;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LocationInterface.java */
/* renamed from: com.cnlaunch.gmap.map.a.a.d */
/* loaded from: classes.dex */
public final class C1515d extends RequestCallBack<String> {

    /* renamed from: a */
    final /* synthetic */ double f7489a;

    /* renamed from: b */
    final /* synthetic */ double f7490b;

    /* renamed from: c */
    final /* synthetic */ LocationSearch.InterfaceC1517a f7491c;

    /* renamed from: d */
    final /* synthetic */ LocationInterface f7492d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1515d(LocationInterface locationInterface, double d, double d2, LocationSearch.InterfaceC1517a interfaceC1517a) {
        this.f7492d = locationInterface;
        this.f7489a = d;
        this.f7490b = d2;
        this.f7491c = interfaceC1517a;
    }

    @Override // com.p099c.p100a.p103c.p104a.RequestCallBack
    /* renamed from: a */
    public final void mo250a(ResponseInfo<String> responseInfo) {
        JSONArray jSONArray;
        LocationResult locationResult = new LocationResult();
        locationResult.setLclatlng(new LcLatlng(this.f7489a, this.f7490b));
        try {
            try {
                JSONObject jSONObject = new JSONObject(responseInfo.f6665a);
                if ("OK".equals(jSONObject.getString("status")) && (jSONArray = jSONObject.getJSONArray("results")) != null && jSONArray.length() > 0) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(0);
                    if (jSONObject2.has("formatted_address")) {
                        locationResult.setAddress(jSONObject2.getString("formatted_address"));
                    }
                    if (jSONArray.length() > 1) {
                        LocationInterface.m9326a(locationResult, jSONArray.getJSONObject(1), false);
                    } else {
                        LocationInterface.m9326a(locationResult, jSONObject2, true);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } finally {
            GDApplication.f10695c.post(new RunnableC1516e(this.f7492d, this.f7491c, locationResult));
        }
    }

    @Override // com.p099c.p100a.p103c.p104a.RequestCallBack
    /* renamed from: a */
    public final void mo249a(String str) {
        this.f7491c.mo6551a(null);
    }
}
