package com.baidu.platform.core.p095c;

import android.util.Log;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiDetailInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiDetailSearchResult;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.base.AbstractC1322b;
import com.mopub.mobileads.VastExtensionXmlManager;
import com.unionpay.tsmservice.data.Constant;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.platform.core.c.d */
/* loaded from: classes.dex */
public class C1346d extends AbstractC1322b {

    /* renamed from: b */
    private static final String f6512b = "d";

    /* renamed from: c */
    private boolean f6513c = false;

    /* renamed from: a */
    private LatLng m9884a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        double optDouble = jSONObject.optDouble("lat");
        double optDouble2 = jSONObject.optDouble("lng");
        return SDKInitializer.getCoordType() == CoordType.GCJ02 ? CoordTrans.baiduToGcj(new LatLng(optDouble, optDouble2)) : new LatLng(optDouble, optDouble2);
    }

    /* renamed from: a */
    private boolean m9887a(String str, SearchResult searchResult) {
        JSONArray optJSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.length() == 0 || jSONObject.optInt("status") != 0 || (optJSONArray = jSONObject.optJSONArray("result")) == null || optJSONArray.length() == 0) {
                return false;
            }
            return this.f6513c ? m9885a(optJSONArray, (PoiDetailSearchResult) searchResult) : m9886a(optJSONArray, (PoiDetailResult) searchResult);
        } catch (JSONException e) {
            Log.e(f6512b, "Parse detail search result error", e);
            return false;
        }
    }

    /* renamed from: a */
    private boolean m9886a(JSONArray jSONArray, PoiDetailResult poiDetailResult) {
        JSONObject jSONObject = (JSONObject) jSONArray.opt(0);
        if (jSONObject == null || jSONObject.length() == 0) {
            return false;
        }
        poiDetailResult.setName(jSONObject.optString("name"));
        poiDetailResult.setLocation(m9884a(jSONObject.optJSONObject("location")));
        poiDetailResult.setAddress(jSONObject.optString("address"));
        poiDetailResult.setTelephone(jSONObject.optString("telephone"));
        poiDetailResult.setUid(jSONObject.optString("uid"));
        JSONObject optJSONObject = jSONObject.optJSONObject("detail_info");
        if (optJSONObject != null && optJSONObject.length() != 0) {
            poiDetailResult.setTag(optJSONObject.optString(Constant.KEY_TAG));
            poiDetailResult.setDetailUrl(optJSONObject.optString("detail_url"));
            poiDetailResult.setType(optJSONObject.optString(VastExtensionXmlManager.TYPE));
            poiDetailResult.setPrice(optJSONObject.optDouble("price", 0.0d));
            poiDetailResult.setOverallRating(optJSONObject.optDouble("overall_rating", 0.0d));
            poiDetailResult.setTasteRating(optJSONObject.optDouble("taste_rating", 0.0d));
            poiDetailResult.setServiceRating(optJSONObject.optDouble("service_rating", 0.0d));
            poiDetailResult.setEnvironmentRating(optJSONObject.optDouble("environment_rating", 0.0d));
            poiDetailResult.setFacilityRating(optJSONObject.optDouble("facility_rating", 0.0d));
            poiDetailResult.setHygieneRating(optJSONObject.optDouble("hygiene_rating", 0.0d));
            poiDetailResult.setTechnologyRating(optJSONObject.optDouble("technology_rating", 0.0d));
            poiDetailResult.setImageNum(optJSONObject.optInt("image_num"));
            poiDetailResult.setGrouponNum(optJSONObject.optInt("groupon_num", 0));
            poiDetailResult.setCommentNum(optJSONObject.optInt("comment_num", 0));
            poiDetailResult.setDiscountNum(optJSONObject.optInt("discount_num", 0));
            poiDetailResult.setFavoriteNum(optJSONObject.optInt("favorite_num", 0));
            poiDetailResult.setCheckinNum(optJSONObject.optInt("checkin_num", 0));
            poiDetailResult.setShopHours(optJSONObject.optString("shop_hours"));
        }
        poiDetailResult.error = SearchResult.ERRORNO.NO_ERROR;
        return true;
    }

    /* renamed from: a */
    private boolean m9885a(JSONArray jSONArray, PoiDetailSearchResult poiDetailSearchResult) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = (JSONObject) jSONArray.opt(i);
            if (jSONObject != null && jSONObject.length() != 0) {
                PoiDetailInfo poiDetailInfo = new PoiDetailInfo();
                poiDetailInfo.setName(jSONObject.optString("name"));
                poiDetailInfo.setLocation(m9884a(jSONObject.optJSONObject("location")));
                poiDetailInfo.setAddress(jSONObject.optString("address"));
                poiDetailInfo.setProvince(jSONObject.optString("province"));
                poiDetailInfo.setCity(jSONObject.optString("city"));
                poiDetailInfo.setArea(jSONObject.optString("area"));
                poiDetailInfo.setTelephone(jSONObject.optString("telephone"));
                poiDetailInfo.setUid(jSONObject.optString("uid"));
                poiDetailInfo.setStreetId(jSONObject.optString("setStreetId"));
                poiDetailInfo.setDetail(jSONObject.optString("detail"));
                JSONObject optJSONObject = jSONObject.optJSONObject("detail_info");
                if (optJSONObject != null && optJSONObject.length() != 0) {
                    poiDetailInfo.setDistance(optJSONObject.optInt("distance", 0));
                    poiDetailInfo.setType(optJSONObject.optString(VastExtensionXmlManager.TYPE));
                    poiDetailInfo.setTag(optJSONObject.optString(Constant.KEY_TAG));
                    poiDetailInfo.setDetailUrl(optJSONObject.optString("detail_url"));
                    poiDetailInfo.setPrice(optJSONObject.optDouble("price", 0.0d));
                    poiDetailInfo.setShopHours(optJSONObject.optString("shop_hours"));
                    poiDetailInfo.setOverallRating(optJSONObject.optDouble("overall_rating", 0.0d));
                    poiDetailInfo.setTasteRating(optJSONObject.optDouble("taste_rating", 0.0d));
                    poiDetailInfo.setServiceRating(optJSONObject.optDouble("service_rating", 0.0d));
                    poiDetailInfo.setEnvironmentRating(optJSONObject.optDouble("environment_rating", 0.0d));
                    poiDetailInfo.setFacilityRating(optJSONObject.optDouble("facility_rating", 0.0d));
                    poiDetailInfo.setHygieneRating(optJSONObject.optDouble("hygiene_rating", 0.0d));
                    poiDetailInfo.setTechnologyRating(optJSONObject.optDouble("technology_rating", 0.0d));
                    poiDetailInfo.setImageNum(optJSONObject.optInt("image_num"));
                    poiDetailInfo.setGrouponNum(optJSONObject.optInt("groupon_num", 0));
                    poiDetailInfo.setCommentNum(optJSONObject.optInt("comment_num", 0));
                    poiDetailInfo.setDiscountNum(optJSONObject.optInt("discount_num", 0));
                    poiDetailInfo.setFavoriteNum(optJSONObject.optInt("favorite_num", 0));
                    poiDetailInfo.setCheckinNum(optJSONObject.optInt("checkin_num", 0));
                }
                arrayList.add(poiDetailInfo);
            }
        }
        poiDetailSearchResult.setPoiDetailInfoList(arrayList);
        poiDetailSearchResult.error = SearchResult.ERRORNO.NO_ERROR;
        return true;
    }

    @Override // com.baidu.platform.base.AbstractC1322b
    /* renamed from: a */
    public SearchResult mo9794a(String str) {
        SearchResult.ERRORNO errorno;
        JSONObject jSONObject;
        SearchResult.ERRORNO errorno2;
        SearchResult poiDetailSearchResult = this.f6513c ? new PoiDetailSearchResult() : new PoiDetailResult();
        if (str != null && !str.isEmpty()) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e) {
                Log.e(f6512b, "Parse detail search result failed", e);
            }
            if (jSONObject.length() == 0) {
                poiDetailSearchResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                return poiDetailSearchResult;
            } else if (!jSONObject.has("SDK_InnerError")) {
                if (!m9887a(str, poiDetailSearchResult)) {
                    poiDetailSearchResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                }
                return poiDetailSearchResult;
            } else {
                JSONObject optJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                if (optJSONObject != null && optJSONObject.length() != 0) {
                    if (optJSONObject.has("PermissionCheckError")) {
                        errorno = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                        poiDetailSearchResult.error = errorno;
                        return poiDetailSearchResult;
                    }
                    if (optJSONObject.has("httpStateError")) {
                        String optString = optJSONObject.optString("httpStateError");
                        char c = 65535;
                        int hashCode = optString.hashCode();
                        if (hashCode != -879828873) {
                            if (hashCode == 1470557208 && optString.equals("REQUEST_ERROR")) {
                                c = 1;
                            }
                        } else if (optString.equals("NETWORK_ERROR")) {
                            c = 0;
                        }
                        switch (c) {
                            case 0:
                                errorno2 = SearchResult.ERRORNO.NETWORK_ERROR;
                                break;
                            case 1:
                                errorno2 = SearchResult.ERRORNO.REQUEST_ERROR;
                                break;
                            default:
                                errorno2 = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                                break;
                        }
                        poiDetailSearchResult.error = errorno2;
                    }
                    return poiDetailSearchResult;
                }
            }
        }
        errorno = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        poiDetailSearchResult.error = errorno;
        return poiDetailSearchResult;
    }

    @Override // com.baidu.platform.base.AbstractC1322b
    /* renamed from: a */
    public void mo9795a(SearchResult searchResult, Object obj) {
        if (obj == null || !(obj instanceof OnGetPoiSearchResultListener)) {
            return;
        }
        if (this.f6513c) {
            ((OnGetPoiSearchResultListener) obj).onGetPoiDetailResult((PoiDetailSearchResult) searchResult);
        } else {
            ((OnGetPoiSearchResultListener) obj).onGetPoiDetailResult((PoiDetailResult) searchResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m9883a(boolean z) {
        this.f6513c = z;
    }
}
