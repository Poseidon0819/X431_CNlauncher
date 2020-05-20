package com.cnlaunch.gmap.map.p145a.p146a;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import com.cnlaunch.gmap.map.logic.p153a.LocationResult;
import com.cnlaunch.gmap.map.p145a.p146a.LocationSearch;
import com.cnlaunch.gmap.map.p151c.HttpMsgCenter;
import com.cnlaunch.gmap.map.p151c.HttpParamsUtils;
import com.google.android.gms.maps.model.LatLng;
import com.itextpdf.text.pdf.PdfBoolean;
import com.p099c.p100a.p103c.p105b.HttpRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.cnlaunch.gmap.map.a.a.a */
/* loaded from: classes.dex */
public final class LocationInterface {

    /* renamed from: a */
    private static String f7479a = "http://maps.googleapis.com/maps/api/geocode/json?";

    /* renamed from: b */
    private Context f7480b;

    public LocationInterface(Context context) {
        this.f7480b = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public Address m9325a(LatLng latLng) {
        if (latLng != null) {
            try {
                List<Address> fromLocation = new Geocoder(this.f7480b, Locale.getDefault()).getFromLocation(latLng.f19310c, latLng.f19311d, 1);
                if (fromLocation.size() > 0) {
                    return fromLocation.get(0);
                }
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    /* renamed from: a */
    public final void m9330a(double d, double d2, String str, LocationSearch.InterfaceC1517a interfaceC1517a) {
        new Thread(new RunnableC1514c(this, d, d2, str, interfaceC1517a)).start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m9329a(LocationInterface locationInterface, double d, double d2, String str, LocationSearch.InterfaceC1517a interfaceC1517a) {
        HashMap hashMap = new HashMap();
        hashMap.put("latlng", String.format("%s%s%s", Double.valueOf(d), ",", Double.valueOf(d2)));
        if (str != null) {
            String country = Locale.getDefault().getCountry();
            if (!country.contains("-")) {
                country = str + "-" + country;
            }
            hashMap.put("language", country);
        }
        hashMap.put("sensor", PdfBoolean.FALSE);
        HttpMsgCenter.m9287a(locationInterface.f7480b).f7599a.m9765a(locationInterface.f7480b, HttpRequest.EnumC1391a.GET, String.format("%s%s%s", f7479a, "&", HttpParamsUtils.m9285a(hashMap).trim()), new C1515d(locationInterface, d, d2, interfaceC1517a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m9326a(LocationResult locationResult, JSONObject jSONObject, boolean z) throws JSONException {
        JSONArray jSONArray;
        if (!jSONObject.has("address_components") || (jSONArray = jSONObject.getJSONArray("address_components")) == null || jSONArray.length() <= 0) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            if (jSONObject2.has("types") && jSONObject2.getJSONArray("types") != null && jSONObject2.getJSONArray("types").length() > 0 && "locality".equals(jSONObject2.getJSONArray("types").get(0)) && jSONObject2.has("long_name")) {
                String string = jSONObject2.getString("long_name");
                if (z) {
                    if (string.contains("市")) {
                        string = string.substring(0, string.lastIndexOf("市"));
                    }
                    if (string.contains("shi")) {
                        string = string.substring(0, string.lastIndexOf("shi"));
                    }
                }
                locationResult.setCityName(string);
                return;
            }
        }
    }
}
