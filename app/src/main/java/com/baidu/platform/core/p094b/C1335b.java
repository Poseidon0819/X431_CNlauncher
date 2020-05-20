package com.baidu.platform.core.p094b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.base.AbstractC1322b;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.platform.core.b.b */
/* loaded from: classes.dex */
public class C1335b extends AbstractC1322b {

    /* renamed from: b */
    private static final String f6509b = "b";

    /* renamed from: c */
    private String f6510c;

    /* renamed from: a */
    private LatLng m9910a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        double optDouble = jSONObject.optDouble("lat");
        double optDouble2 = jSONObject.optDouble("lng");
        return SDKInitializer.getCoordType() == CoordType.GCJ02 ? CoordTrans.baiduToGcj(new LatLng(optDouble, optDouble2)) : new LatLng(optDouble, optDouble2);
    }

    /* renamed from: a */
    private boolean m9911a(String str, GeoCodeResult geoCodeResult) {
        SearchResult.ERRORNO errorno;
        if (TextUtils.isEmpty(str) || geoCodeResult == null) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("status");
            if (optInt != 0) {
                switch (optInt) {
                    case 1:
                        errorno = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                        break;
                    case 2:
                        errorno = SearchResult.ERRORNO.SEARCH_OPTION_ERROR;
                        break;
                    default:
                        errorno = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                        break;
                }
                geoCodeResult.error = errorno;
                return false;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("result");
            if (optJSONObject == null) {
                geoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                return false;
            }
            geoCodeResult.setLocation(m9910a(optJSONObject.optJSONObject("location")));
            geoCodeResult.setAddress(this.f6510c);
            geoCodeResult.setPrecise(optJSONObject.optInt("precise"));
            geoCodeResult.setConfidence(optJSONObject.optInt("confidence"));
            geoCodeResult.setLevel(optJSONObject.optString("level"));
            geoCodeResult.error = SearchResult.ERRORNO.NO_ERROR;
            return true;
        } catch (JSONException e) {
            geoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            Log.e(f6509b, "Parse GeoCodeResult catch JSONException", e);
            return true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0072, code lost:
        if (r6.equals("NETWORK_ERROR") != false) goto L31;
     */
    @Override // com.baidu.platform.base.AbstractC1322b
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.baidu.mapapi.search.core.SearchResult mo9794a(java.lang.String r6) {
        /*
            r5 = this;
            com.baidu.mapapi.search.geocode.GeoCodeResult r0 = new com.baidu.mapapi.search.geocode.GeoCodeResult
            r0.<init>()
            if (r6 == 0) goto L85
            java.lang.String r1 = ""
            boolean r1 = r6.equals(r1)
            if (r1 == 0) goto L11
            goto L85
        L11:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: org.json.JSONException -> L88
            r1.<init>(r6)     // Catch: org.json.JSONException -> L88
            java.lang.String r2 = "SDK_InnerError"
            boolean r2 = r1.has(r2)
            r3 = 0
            if (r2 != 0) goto L31
            boolean r1 = r5.m9939a(r6, r0, r3)
            if (r1 == 0) goto L26
            return r0
        L26:
            boolean r6 = r5.m9911a(r6, r0)
            if (r6 != 0) goto L30
            com.baidu.mapapi.search.core.SearchResult$ERRORNO r6 = com.baidu.mapapi.search.core.SearchResult.ERRORNO.RESULT_NOT_FOUND
            r0.error = r6
        L30:
            return r0
        L31:
            java.lang.String r6 = "SDK_InnerError"
            org.json.JSONObject r6 = r1.optJSONObject(r6)
            java.lang.String r1 = "PermissionCheckError"
            boolean r1 = r6.has(r1)
            if (r1 == 0) goto L44
            com.baidu.mapapi.search.core.SearchResult$ERRORNO r6 = com.baidu.mapapi.search.core.SearchResult.ERRORNO.PERMISSION_UNFINISHED
        L41:
            r0.error = r6
            return r0
        L44:
            java.lang.String r1 = "httpStateError"
            boolean r1 = r6.has(r1)
            if (r1 == 0) goto L85
            java.lang.String r1 = "httpStateError"
            java.lang.String r6 = r6.optString(r1)
            r1 = -1
            int r2 = r6.hashCode()
            r4 = -879828873(0xffffffffcb8ee077, float:-1.872715E7)
            if (r2 == r4) goto L6c
            r3 = 1470557208(0x57a6ec18, float:3.670659E14)
            if (r2 == r3) goto L62
            goto L75
        L62:
            java.lang.String r2 = "REQUEST_ERROR"
            boolean r6 = r6.equals(r2)
            if (r6 == 0) goto L75
            r3 = 1
            goto L76
        L6c:
            java.lang.String r2 = "NETWORK_ERROR"
            boolean r6 = r6.equals(r2)
            if (r6 == 0) goto L75
            goto L76
        L75:
            r3 = -1
        L76:
            switch(r3) {
                case 0: goto L81;
                case 1: goto L7e;
                default: goto L79;
            }
        L79:
            com.baidu.mapapi.search.core.SearchResult$ERRORNO r6 = com.baidu.mapapi.search.core.SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR
        L7b:
            r0.error = r6
            goto L84
        L7e:
            com.baidu.mapapi.search.core.SearchResult$ERRORNO r6 = com.baidu.mapapi.search.core.SearchResult.ERRORNO.REQUEST_ERROR
            goto L7b
        L81:
            com.baidu.mapapi.search.core.SearchResult$ERRORNO r6 = com.baidu.mapapi.search.core.SearchResult.ERRORNO.NETWORK_ERROR
            goto L7b
        L84:
            return r0
        L85:
            com.baidu.mapapi.search.core.SearchResult$ERRORNO r6 = com.baidu.mapapi.search.core.SearchResult.ERRORNO.RESULT_NOT_FOUND
            goto L41
        L88:
            r6 = move-exception
            java.lang.String r1 = com.baidu.platform.core.p094b.C1335b.f6509b
            java.lang.String r2 = "JSONException caught"
            android.util.Log.e(r1, r2, r6)
            goto L85
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.core.p094b.C1335b.mo9794a(java.lang.String):com.baidu.mapapi.search.core.SearchResult");
    }

    @Override // com.baidu.platform.base.AbstractC1322b
    /* renamed from: a */
    public void mo9795a(SearchResult searchResult, Object obj) {
        if (obj == null || !(obj instanceof OnGetGeoCoderResultListener)) {
            return;
        }
        ((OnGetGeoCoderResultListener) obj).onGetGeoCodeResult((GeoCodeResult) searchResult);
    }

    /* renamed from: b */
    public void m9909b(String str) {
        this.f6510c = str;
    }
}
