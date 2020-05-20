package com.cnlaunch.gmap.map.p145a.p147b.p148a;

import android.content.Context;
import com.cnlaunch.gmap.map.p145a.p147b.SuggestionSearch;
import com.cnlaunch.gmap.map.p151c.HttpMsgCenter;
import com.cnlaunch.gmap.map.p151c.HttpParamsUtils;
import com.google.android.gms.maps.model.LatLng;
import com.itextpdf.text.pdf.PdfBoolean;
import com.p099c.p100a.p103c.p105b.HttpRequest;
import java.util.HashMap;

/* renamed from: com.cnlaunch.gmap.map.a.b.a.a */
/* loaded from: classes.dex */
public final class SuggestionInterface {

    /* renamed from: a */
    private static String f7507a = "https://maps.googleapis.com/maps/api/place/search/json?";

    /* renamed from: b */
    private Context f7508b;

    public SuggestionInterface(Context context) {
        this.f7508b = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m9320a(SuggestionInterface suggestionInterface, LatLng latLng, String str, String str2, SuggestionSearch.InterfaceC1518a interfaceC1518a) {
        if (latLng != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("location", latLng.f19310c + "," + latLng.f19311d);
            hashMap.put("keyword", str2);
            hashMap.put("name", str);
            hashMap.put("key", "AIzaSyD6CdoYJ6mZFfaclEf3mSd8veF3SWTKGc4");
            hashMap.put("radius", "5000000");
            hashMap.put("sensor", PdfBoolean.TRUE);
            HttpMsgCenter.m9287a(suggestionInterface.f7508b).f7599a.m9765a(suggestionInterface.f7508b, HttpRequest.EnumC1391a.GET, f7507a + "&" + HttpParamsUtils.m9285a(hashMap).trim(), new C1521c(suggestionInterface, interfaceC1518a, str));
        }
    }
}
