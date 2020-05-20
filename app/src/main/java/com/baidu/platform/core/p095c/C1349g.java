package com.baidu.platform.core.p095c;

import android.util.Log;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiChildrenInfo;
import com.baidu.mapapi.search.core.PoiDetailInfo;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiResult;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.base.AbstractC1322b;
import com.baidu.platform.base.SearchType;
import com.mopub.mobileads.VastExtensionXmlManager;
import com.unionpay.tsmservice.data.Constant;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.platform.core.c.g */
/* loaded from: classes.dex */
public class C1349g extends AbstractC1322b {

    /* renamed from: b */
    private static final String f6515b = "g";

    /* renamed from: c */
    private int f6516c;

    /* renamed from: d */
    private int f6517d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1349g(int i, int i2) {
        this.f6516c = i;
        this.f6517d = i2;
    }

    /* renamed from: a */
    private LatLng m9873a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        double optDouble = jSONObject.optDouble("lat");
        double optDouble2 = jSONObject.optDouble("lng");
        return SDKInitializer.getCoordType() == CoordType.GCJ02 ? CoordTrans.baiduToGcj(new LatLng(optDouble, optDouble2)) : new LatLng(optDouble, optDouble2);
    }

    /* renamed from: a */
    private boolean m9874a(String str, PoiResult poiResult) {
        SearchResult.ERRORNO errorno;
        if (str != null && !str.equals("") && !str.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("status");
                if (optInt == 0) {
                    return m9872a(jSONObject, poiResult);
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
                poiResult.error = errorno;
                return false;
            } catch (JSONException e) {
                Log.e(f6515b, "Parse poi search failed", e);
                poiResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            }
        }
        return false;
    }

    /* renamed from: a */
    private boolean m9872a(JSONObject jSONObject, PoiResult poiResult) {
        if (jSONObject != null && jSONObject.length() != 0) {
            poiResult.error = SearchResult.ERRORNO.NO_ERROR;
            JSONArray optJSONArray = jSONObject.optJSONArray("results");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int optInt = jSONObject.optInt("total");
                poiResult.setTotalPoiNum(optInt);
                int length = optJSONArray.length();
                poiResult.setCurrentPageCapacity(length);
                poiResult.setCurrentPageNum(this.f6516c);
                if (length != 0) {
                    int i = this.f6517d;
                    poiResult.setTotalPageNum((optInt / i) + (optInt % i > 0 ? 1 : 0));
                }
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i2);
                    if (jSONObject2 != null && jSONObject2.length() != 0) {
                        PoiInfo poiInfo = new PoiInfo();
                        poiInfo.setName(jSONObject2.optString("name"));
                        poiInfo.setAddress(jSONObject2.optString("address"));
                        poiInfo.setProvince(jSONObject2.optString("province"));
                        poiInfo.setCity(jSONObject2.optString("city"));
                        poiInfo.setArea(jSONObject2.optString("area"));
                        poiInfo.setStreetId(jSONObject2.optString("street_id"));
                        poiInfo.setUid(jSONObject2.optString("uid"));
                        poiInfo.setPhoneNum(jSONObject2.optString("telephone"));
                        poiInfo.setDetail(jSONObject2.optInt("detail"));
                        poiInfo.setLocation(m9873a(jSONObject2.optJSONObject("location")));
                        String optString = jSONObject2.optString("detail_info");
                        if (optString != null && optString.length() != 0) {
                            poiInfo.setPoiDetailInfo(m9871b(optString));
                        }
                        arrayList.add(poiInfo);
                    }
                }
                poiResult.setPoiInfo(arrayList);
                return true;
            }
            poiResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        }
        return false;
    }

    /* renamed from: b */
    private PoiDetailInfo m9871b(String str) {
        PoiDetailInfo poiDetailInfo = new PoiDetailInfo();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.length() == 0) {
                return null;
            }
            poiDetailInfo.setDistance(jSONObject.optInt("distance", 0));
            poiDetailInfo.setTag(jSONObject.optString(Constant.KEY_TAG));
            poiDetailInfo.setDetailUrl(jSONObject.optString("detail_url"));
            poiDetailInfo.setType(jSONObject.optString(VastExtensionXmlManager.TYPE));
            poiDetailInfo.setPrice(jSONObject.optDouble("price", 0.0d));
            poiDetailInfo.setOverallRating(jSONObject.optDouble("overall_rating", 0.0d));
            poiDetailInfo.setTasteRating(jSONObject.optDouble("taste_rating", 0.0d));
            poiDetailInfo.setServiceRating(jSONObject.optDouble("service_rating", 0.0d));
            poiDetailInfo.setEnvironmentRating(jSONObject.optDouble("environment_rating", 0.0d));
            poiDetailInfo.setFacilityRating(jSONObject.optDouble("facility_rating", 0.0d));
            poiDetailInfo.setHygieneRating(jSONObject.optDouble("hygiene_rating", 0.0d));
            poiDetailInfo.setTechnologyRating(jSONObject.optDouble("technology_rating", 0.0d));
            poiDetailInfo.setImageNum(jSONObject.optInt("image_num"));
            poiDetailInfo.setGrouponNum(jSONObject.optInt("groupon_num"));
            poiDetailInfo.setCommentNum(jSONObject.optInt("comment_num"));
            poiDetailInfo.setDiscountNum(jSONObject.optInt("discount_num"));
            poiDetailInfo.setFavoriteNum(jSONObject.optInt("favorite_num"));
            poiDetailInfo.setCheckinNum(jSONObject.optInt("checkin_num"));
            poiDetailInfo.setShopHours(jSONObject.optString("shop_hours"));
            poiDetailInfo.naviLocation = m9873a(jSONObject.optJSONObject("navi_location"));
            SearchType a = m9941a();
            if (SearchType.POI_IN_CITY_SEARCH == a || SearchType.POI_NEAR_BY_SEARCH == a) {
                poiDetailInfo.setPoiChildrenInfoList(m9870b(jSONObject));
            }
            return poiDetailInfo;
        } catch (JSONException e) {
            Log.e(f6515b, "Parse poi search detail info failed", e);
            return null;
        }
    }

    /* renamed from: b */
    private List<PoiChildrenInfo> m9870b(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("children");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null && optJSONObject.length() != 0) {
                PoiChildrenInfo poiChildrenInfo = new PoiChildrenInfo();
                poiChildrenInfo.setUid(optJSONObject.optString("uid"));
                poiChildrenInfo.setName(optJSONObject.optString("name"));
                poiChildrenInfo.setShowName(optJSONObject.optString("show_name"));
                poiChildrenInfo.setTag(optJSONObject.optString(Constant.KEY_TAG));
                poiChildrenInfo.setLocation(m9873a(optJSONObject.optJSONObject("location")));
                poiChildrenInfo.setAddress(optJSONObject.optString("address"));
                arrayList.add(poiChildrenInfo);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0066, code lost:
        if (r6.equals("NETWORK_ERROR") != false) goto L26;
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
            com.baidu.mapapi.search.poi.PoiResult r0 = new com.baidu.mapapi.search.poi.PoiResult
            r0.<init>()
            if (r6 == 0) goto L96
            java.lang.String r1 = ""
            boolean r1 = r6.equals(r1)
            if (r1 != 0) goto L96
            boolean r1 = r6.isEmpty()
            if (r1 == 0) goto L17
            goto L96
        L17:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: org.json.JSONException -> L8e
            r1.<init>(r6)     // Catch: org.json.JSONException -> L8e
            java.lang.String r2 = "SDK_InnerError"
            boolean r2 = r1.has(r2)
            r3 = 0
            if (r2 == 0) goto L79
            java.lang.String r2 = "SDK_InnerError"
            org.json.JSONObject r1 = r1.optJSONObject(r2)
            java.lang.String r2 = "PermissionCheckError"
            boolean r2 = r1.has(r2)
            if (r2 == 0) goto L38
            com.baidu.mapapi.search.core.SearchResult$ERRORNO r6 = com.baidu.mapapi.search.core.SearchResult.ERRORNO.PERMISSION_UNFINISHED
        L35:
            r0.error = r6
            return r0
        L38:
            java.lang.String r2 = "httpStateError"
            boolean r2 = r1.has(r2)
            if (r2 == 0) goto L79
            java.lang.String r6 = "httpStateError"
            java.lang.String r6 = r1.optString(r6)
            r1 = -1
            int r2 = r6.hashCode()
            r4 = -879828873(0xffffffffcb8ee077, float:-1.872715E7)
            if (r2 == r4) goto L60
            r3 = 1470557208(0x57a6ec18, float:3.670659E14)
            if (r2 == r3) goto L56
            goto L69
        L56:
            java.lang.String r2 = "REQUEST_ERROR"
            boolean r6 = r6.equals(r2)
            if (r6 == 0) goto L69
            r3 = 1
            goto L6a
        L60:
            java.lang.String r2 = "NETWORK_ERROR"
            boolean r6 = r6.equals(r2)
            if (r6 == 0) goto L69
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
            if (r1 == 0) goto L80
            return r0
        L80:
            boolean r6 = r5.m9874a(r6, r0)
            if (r6 == 0) goto L89
            com.baidu.mapapi.search.core.SearchResult$ERRORNO r6 = com.baidu.mapapi.search.core.SearchResult.ERRORNO.NO_ERROR
            goto L8b
        L89:
            com.baidu.mapapi.search.core.SearchResult$ERRORNO r6 = com.baidu.mapapi.search.core.SearchResult.ERRORNO.RESULT_NOT_FOUND
        L8b:
            r0.error = r6
            return r0
        L8e:
            r6 = move-exception
            java.lang.String r1 = com.baidu.platform.core.p095c.C1349g.f6515b
            java.lang.String r2 = "Parse poi search error"
            android.util.Log.e(r1, r2, r6)
        L96:
            com.baidu.mapapi.search.core.SearchResult$ERRORNO r6 = com.baidu.mapapi.search.core.SearchResult.ERRORNO.RESULT_NOT_FOUND
            goto L35
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.core.p095c.C1349g.mo9794a(java.lang.String):com.baidu.mapapi.search.core.SearchResult");
    }

    @Override // com.baidu.platform.base.AbstractC1322b
    /* renamed from: a */
    public void mo9795a(SearchResult searchResult, Object obj) {
        if (obj == null || !(obj instanceof OnGetPoiSearchResultListener)) {
            return;
        }
        switch (m9941a()) {
            case POI_NEAR_BY_SEARCH:
            case POI_IN_CITY_SEARCH:
            case POI_IN_BOUND_SEARCH:
                ((OnGetPoiSearchResultListener) obj).onGetPoiResult((PoiResult) searchResult);
                return;
            default:
                return;
        }
    }
}
