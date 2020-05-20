package com.baidu.platform.core.p098f;

import android.util.Log;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiChildrenInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.sug.OnGetSuggestionResultListener;
import com.baidu.mapapi.search.sug.SuggestionResult;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.base.AbstractC1322b;
import com.unionpay.tsmservice.data.Constant;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.platform.core.f.c */
/* loaded from: classes.dex */
public class C1378c extends AbstractC1322b {

    /* renamed from: b */
    private static final String f6526b = "c";

    /* renamed from: a */
    private LatLng m9791a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        double optDouble = jSONObject.optDouble("lat");
        double optDouble2 = jSONObject.optDouble("lng");
        return SDKInitializer.getCoordType() == CoordType.GCJ02 ? CoordTrans.baiduToGcj(new LatLng(optDouble, optDouble2)) : new LatLng(optDouble, optDouble2);
    }

    /* renamed from: a */
    private List<PoiChildrenInfo> m9792a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null && optJSONObject.length() != 0) {
                PoiChildrenInfo poiChildrenInfo = new PoiChildrenInfo();
                poiChildrenInfo.setUid(optJSONObject.optString("uid"));
                poiChildrenInfo.setName(optJSONObject.optString("name"));
                poiChildrenInfo.setShowName(optJSONObject.optString("show_name"));
                poiChildrenInfo.setTag(optJSONObject.optString(Constant.KEY_TAG));
                poiChildrenInfo.setAddress(optJSONObject.optString("address"));
                arrayList.add(poiChildrenInfo);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private boolean m9793a(String str, SuggestionResult suggestionResult) {
        SearchResult.ERRORNO errorno;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.length() != 0) {
                int optInt = jSONObject.optInt("status");
                if (optInt == 0) {
                    return m9790a(jSONObject, suggestionResult);
                }
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
                suggestionResult.error = errorno;
                return false;
            }
        } catch (JSONException e) {
            Log.e(f6526b, "Parse sug search error", e);
        }
        suggestionResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        return false;
    }

    /* renamed from: a */
    private boolean m9790a(JSONObject jSONObject, SuggestionResult suggestionResult) {
        if (jSONObject != null && jSONObject.length() != 0) {
            suggestionResult.error = SearchResult.ERRORNO.NO_ERROR;
            JSONArray optJSONArray = jSONObject.optJSONArray("result");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                ArrayList<SuggestionResult.SuggestionInfo> arrayList = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i);
                    if (jSONObject2 != null && jSONObject2.length() != 0) {
                        SuggestionResult.SuggestionInfo suggestionInfo = new SuggestionResult.SuggestionInfo();
                        suggestionInfo.setKey(jSONObject2.optString("name"));
                        suggestionInfo.setCity(jSONObject2.optString("city"));
                        suggestionInfo.setDistrict(jSONObject2.optString("district"));
                        suggestionInfo.setUid(jSONObject2.optString("uid"));
                        suggestionInfo.setTag(jSONObject2.optString(Constant.KEY_TAG));
                        suggestionInfo.setAddress(jSONObject2.optString("address"));
                        suggestionInfo.setPt(m9791a(jSONObject2.optJSONObject("location")));
                        JSONArray optJSONArray2 = jSONObject2.optJSONArray("children");
                        if (optJSONArray2 != null && optJSONArray2.length() != 0) {
                            suggestionInfo.setPoiChildrenInfoList(m9792a(optJSONArray2));
                        }
                        arrayList.add(suggestionInfo);
                    }
                }
                suggestionResult.setSuggestionInfo(arrayList);
                return true;
            }
            suggestionResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x005c, code lost:
        if (r6.equals("REQUEST_ERROR") == false) goto L31;
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
            com.baidu.mapapi.search.sug.SuggestionResult r0 = new com.baidu.mapapi.search.sug.SuggestionResult
            r0.<init>()
            if (r6 == 0) goto L19
            boolean r1 = r6.isEmpty()
            if (r1 == 0) goto Le
            goto L19
        Le:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: org.json.JSONException -> L83
            r1.<init>(r6)     // Catch: org.json.JSONException -> L83
            int r2 = r1.length()
            if (r2 != 0) goto L1e
        L19:
            com.baidu.mapapi.search.core.SearchResult$ERRORNO r6 = com.baidu.mapapi.search.core.SearchResult.ERRORNO.RESULT_NOT_FOUND
        L1b:
            r0.error = r6
            return r0
        L1e:
            java.lang.String r2 = "SDK_InnerError"
            boolean r2 = r1.has(r2)
            r3 = 1
            if (r2 == 0) goto L79
            java.lang.String r2 = "SDK_InnerError"
            org.json.JSONObject r1 = r1.optJSONObject(r2)
            java.lang.String r2 = "PermissionCheckError"
            boolean r2 = r1.has(r2)
            if (r2 == 0) goto L38
            com.baidu.mapapi.search.core.SearchResult$ERRORNO r6 = com.baidu.mapapi.search.core.SearchResult.ERRORNO.PERMISSION_UNFINISHED
            goto L1b
        L38:
            java.lang.String r2 = "httpStateError"
            boolean r2 = r1.has(r2)
            if (r2 == 0) goto L79
            java.lang.String r6 = "httpStateError"
            java.lang.String r6 = r1.optString(r6)
            r1 = -1
            int r2 = r6.hashCode()
            r4 = -879828873(0xffffffffcb8ee077, float:-1.872715E7)
            if (r2 == r4) goto L5f
            r4 = 1470557208(0x57a6ec18, float:3.670659E14)
            if (r2 == r4) goto L56
            goto L69
        L56:
            java.lang.String r2 = "REQUEST_ERROR"
            boolean r6 = r6.equals(r2)
            if (r6 == 0) goto L69
            goto L6a
        L5f:
            java.lang.String r2 = "NETWORK_ERROR"
            boolean r6 = r6.equals(r2)
            if (r6 == 0) goto L69
            r3 = 0
            goto L6a
        L69:
            r3 = -1
        L6a:
            switch(r3) {
                case 0: goto L75;
                case 1: goto L72;
                default: goto L6d;
            }
        L6d:
            com.baidu.mapapi.search.core.SearchResult$ERRORNO r6 = com.baidu.mapapi.search.core.SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR
        L6f:
            r0.error = r6
            goto L78
        L72:
            com.baidu.mapapi.search.core.SearchResult$ERRORNO r6 = com.baidu.mapapi.search.core.SearchResult.ERRORNO.REQUEST_ERROR
            goto L6f
        L75:
            com.baidu.mapapi.search.core.SearchResult$ERRORNO r6 = com.baidu.mapapi.search.core.SearchResult.ERRORNO.NETWORK_ERROR
            goto L6f
        L78:
            return r0
        L79:
            boolean r1 = r5.m9939a(r6, r0, r3)
            if (r1 != 0) goto L82
            r5.m9793a(r6, r0)
        L82:
            return r0
        L83:
            r6 = move-exception
            java.lang.String r1 = com.baidu.platform.core.p098f.C1378c.f6526b
            java.lang.String r2 = "Parse suggestion search result error"
            android.util.Log.e(r1, r2, r6)
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.core.p098f.C1378c.mo9794a(java.lang.String):com.baidu.mapapi.search.core.SearchResult");
    }

    @Override // com.baidu.platform.base.AbstractC1322b
    /* renamed from: a */
    public void mo9795a(SearchResult searchResult, Object obj) {
        if (obj == null || !(obj instanceof OnGetSuggestionResultListener)) {
            return;
        }
        ((OnGetSuggestionResultListener) obj).onGetSuggestionResult((SuggestionResult) searchResult);
    }
}
