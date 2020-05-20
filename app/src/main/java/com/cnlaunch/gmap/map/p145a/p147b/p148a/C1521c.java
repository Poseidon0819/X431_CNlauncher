package com.cnlaunch.gmap.map.p145a.p147b.p148a;

import android.text.TextUtils;
import com.cnlaunch.gmap.map.p145a.p147b.SuggestionSearch;
import com.cnlaunch.gmap.map.p145a.p147b.p149b.SuggestionInfo;
import com.cnlaunch.gmap.map.p145a.p147b.p149b.SuggestionObj;
import com.cnlaunch.gmap.map.p145a.p147b.p149b.SuggestionResult;
import com.cnlaunch.x431pro.activity.GDApplication;
import com.p099c.p100a.p103c.ResponseInfo;
import com.p099c.p100a.p103c.p104a.RequestCallBack;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SuggestionInterface.java */
/* renamed from: com.cnlaunch.gmap.map.a.b.a.c */
/* loaded from: classes.dex */
public final class C1521c extends RequestCallBack<String> {

    /* renamed from: a */
    final /* synthetic */ SuggestionSearch.InterfaceC1518a f7514a;

    /* renamed from: b */
    final /* synthetic */ String f7515b;

    /* renamed from: c */
    final /* synthetic */ SuggestionInterface f7516c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1521c(SuggestionInterface suggestionInterface, SuggestionSearch.InterfaceC1518a interfaceC1518a, String str) {
        this.f7516c = suggestionInterface;
        this.f7514a = interfaceC1518a;
        this.f7515b = str;
    }

    @Override // com.p099c.p100a.p103c.p104a.RequestCallBack
    /* renamed from: a */
    public final void mo250a(ResponseInfo<String> responseInfo) {
        char c;
        JSONArray jSONArray;
        SuggestionObj suggestionObj = new SuggestionObj();
        try {
            JSONObject jSONObject = new JSONObject(responseInfo.f6665a);
            String string = jSONObject.getString("status");
            if (!(!TextUtils.isEmpty(string) && string.equals("OK")) || !jSONObject.has("results") || jSONObject.get("results").equals("null") || jSONObject.get("results").equals("") || jSONObject.get("results").equals("[]") || !(jSONObject.get("results") instanceof JSONArray)) {
                c = 65535;
            } else {
                suggestionObj.f7524a = jSONObject.getJSONArray("results");
                c = 0;
            }
            if (c != 0 || (jSONArray = suggestionObj.f7524a) == null) {
                return;
            }
            int length = jSONArray.length();
            if (length != 0) {
                SuggestionResult suggestionResult = new SuggestionResult();
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < length; i++) {
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        SuggestionInfo suggestionInfo = new SuggestionInfo();
                        JSONObject jSONObject3 = jSONObject2.getJSONObject("geometry").getJSONObject("location");
                        suggestionInfo.f7522c = jSONObject3.getDouble("lat");
                        suggestionInfo.f7523d = jSONObject3.getDouble("lng");
                        suggestionInfo.f7520a = jSONObject2.getString("name");
                        suggestionInfo.f7521b = this.f7515b;
                        arrayList.add(suggestionInfo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                suggestionResult.f7525a = arrayList;
                GDApplication.f10695c.post(new RunnableC1522d(this.f7516c, this.f7514a, suggestionResult));
                return;
            }
            GDApplication.f10695c.post(new RunnableC1522d(this.f7516c, this.f7514a, null));
        } catch (Exception e2) {
            SuggestionSearch.InterfaceC1518a interfaceC1518a = this.f7514a;
            if (interfaceC1518a != null) {
                interfaceC1518a.mo9314a(null);
            }
            e2.printStackTrace();
        }
    }

    @Override // com.p099c.p100a.p103c.p104a.RequestCallBack
    /* renamed from: a */
    public final void mo249a(String str) {
        SuggestionSearch.InterfaceC1518a interfaceC1518a = this.f7514a;
        if (interfaceC1518a != null) {
            interfaceC1518a.mo9314a(null);
        }
    }
}
