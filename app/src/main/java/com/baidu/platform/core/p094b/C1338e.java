package com.baidu.platform.core.p094b;

import android.text.TextUtils;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.base.AbstractC1322b;
import com.unionpay.tsmservice.data.Constant;
import java.util.ArrayList;
import java.util.List;
import org.jivesoftware.smackx.GroupChatInvitation;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.platform.core.b.e */
/* loaded from: classes.dex */
public class C1338e extends AbstractC1322b {
    /* renamed from: a */
    private PoiInfo.ParentPoiInfo m9902a(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return null;
        }
        PoiInfo.ParentPoiInfo parentPoiInfo = new PoiInfo.ParentPoiInfo();
        parentPoiInfo.setParentPoiAddress(jSONObject.optString("addr"));
        parentPoiInfo.setParentPoiDirection(jSONObject.optString("direction"));
        parentPoiInfo.setParentPoiDistance(jSONObject.optInt("distance"));
        parentPoiInfo.setParentPoiName(jSONObject.optString("name"));
        parentPoiInfo.setParentPoiTag(jSONObject.optString(Constant.KEY_TAG));
        parentPoiInfo.setParentPoiUid(jSONObject.optString("uid"));
        parentPoiInfo.setParentPoiLocation(m9897c(jSONObject, "point"));
        return parentPoiInfo;
    }

    /* renamed from: a */
    private ReverseGeoCodeResult.AddressComponent m9900a(JSONObject jSONObject, String str) {
        JSONObject optJSONObject;
        if (jSONObject == null || TextUtils.isEmpty(str) || (optJSONObject = jSONObject.optJSONObject(str)) == null) {
            return null;
        }
        ReverseGeoCodeResult.AddressComponent addressComponent = new ReverseGeoCodeResult.AddressComponent();
        addressComponent.city = optJSONObject.optString("city");
        addressComponent.setTown(optJSONObject.optString("town"));
        addressComponent.district = optJSONObject.optString("district");
        addressComponent.province = optJSONObject.optString("province");
        addressComponent.adcode = optJSONObject.optInt("adcode");
        addressComponent.street = optJSONObject.optString("street");
        addressComponent.streetNumber = optJSONObject.optString("street_number");
        addressComponent.countryName = optJSONObject.optString("country");
        addressComponent.countryCode = optJSONObject.optInt("country_code");
        addressComponent.setDirection(optJSONObject.optString("direction"));
        addressComponent.setDistance(optJSONObject.optString("distance"));
        return addressComponent;
    }

    /* renamed from: a */
    private List<PoiInfo> m9899a(JSONObject jSONObject, String str, String str2) {
        JSONArray optJSONArray;
        if (jSONObject == null || str == null || "".equals(str) || (optJSONArray = jSONObject.optJSONArray(str)) == null || optJSONArray.length() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                PoiInfo poiInfo = new PoiInfo();
                poiInfo.setAddress(optJSONObject.optString("addr"));
                poiInfo.setPhoneNum(optJSONObject.optString("tel"));
                poiInfo.setUid(optJSONObject.optString("uid"));
                poiInfo.setPostCode(optJSONObject.optString("zip"));
                poiInfo.setName(optJSONObject.optString("name"));
                poiInfo.setLocation(m9897c(optJSONObject, "point"));
                poiInfo.setCity(str2);
                poiInfo.setDirection(optJSONObject.optString("direction"));
                poiInfo.setDistance(optJSONObject.optInt("distance"));
                poiInfo.setParentPoi(m9902a(optJSONObject.optJSONObject("parent_poi")));
                arrayList.add(poiInfo);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private boolean m9903a(String str, ReverseGeoCodeResult reverseGeoCodeResult) {
        SearchResult.ERRORNO errorno;
        if (str != null) {
            try {
                if (str.length() > 0) {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("status");
                    if (optInt == 0) {
                        if (m9901a(jSONObject, reverseGeoCodeResult)) {
                            return true;
                        }
                        reverseGeoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                        return false;
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
                    reverseGeoCodeResult.error = errorno;
                    return false;
                }
            } catch (JSONException e) {
                e.printStackTrace();
                reverseGeoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                return false;
            }
        }
        reverseGeoCodeResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
        return false;
    }

    /* renamed from: a */
    private boolean m9901a(JSONObject jSONObject, ReverseGeoCodeResult reverseGeoCodeResult) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("result")) == null) {
            return false;
        }
        reverseGeoCodeResult.setCityCode(optJSONObject.optInt("cityCode"));
        reverseGeoCodeResult.setAddress(optJSONObject.optString("formatted_address"));
        reverseGeoCodeResult.setBusinessCircle(optJSONObject.optString("business"));
        reverseGeoCodeResult.setAddressDetail(m9900a(optJSONObject, "addressComponent"));
        reverseGeoCodeResult.setLocation(m9896d(optJSONObject, "location"));
        reverseGeoCodeResult.setPoiList(m9899a(optJSONObject, "pois", reverseGeoCodeResult.getAddressDetail() != null ? reverseGeoCodeResult.getAddressDetail().city : ""));
        reverseGeoCodeResult.setSematicDescription(optJSONObject.optString("sematic_description"));
        reverseGeoCodeResult.setPoiRegionsInfoList(m9898b(optJSONObject, "poiRegions"));
        reverseGeoCodeResult.error = SearchResult.ERRORNO.NO_ERROR;
        return true;
    }

    /* renamed from: b */
    private List<ReverseGeoCodeResult.PoiRegionsInfo> m9898b(JSONObject jSONObject, String str) {
        JSONArray optJSONArray;
        if (jSONObject == null || TextUtils.isEmpty(str) || (optJSONArray = jSONObject.optJSONArray(str)) == null || optJSONArray.length() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                ReverseGeoCodeResult.PoiRegionsInfo poiRegionsInfo = new ReverseGeoCodeResult.PoiRegionsInfo();
                poiRegionsInfo.setDirectionDesc(optJSONObject.optString("direction_desc"));
                poiRegionsInfo.setRegionName(optJSONObject.optString("name"));
                poiRegionsInfo.setRegionTag(optJSONObject.optString(Constant.KEY_TAG));
                arrayList.add(poiRegionsInfo);
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    private LatLng m9897c(JSONObject jSONObject, String str) {
        JSONObject optJSONObject;
        if (jSONObject == null || str == null || "".equals(str) || (optJSONObject = jSONObject.optJSONObject(str)) == null) {
            return null;
        }
        LatLng latLng = new LatLng(optJSONObject.optDouble("y"), optJSONObject.optDouble(GroupChatInvitation.ELEMENT_NAME));
        return SDKInitializer.getCoordType() == CoordType.GCJ02 ? CoordTrans.baiduToGcj(latLng) : latLng;
    }

    /* renamed from: d */
    private LatLng m9896d(JSONObject jSONObject, String str) {
        JSONObject optJSONObject;
        if (jSONObject == null || str == null || "".equals(str) || (optJSONObject = jSONObject.optJSONObject(str)) == null) {
            return null;
        }
        LatLng latLng = new LatLng(optJSONObject.optDouble("lat"), optJSONObject.optDouble("lng"));
        return SDKInitializer.getCoordType() == CoordType.GCJ02 ? CoordTrans.baiduToGcj(latLng) : latLng;
    }

    @Override // com.baidu.platform.base.AbstractC1322b
    /* renamed from: a */
    public SearchResult mo9794a(String str) {
        ReverseGeoCodeResult reverseGeoCodeResult = new ReverseGeoCodeResult();
        if (str != null && !str.equals("")) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("SDK_InnerError")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                    if (optJSONObject.has("PermissionCheckError")) {
                        reverseGeoCodeResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                        return reverseGeoCodeResult;
                    } else if (optJSONObject.has("httpStateError")) {
                        String optString = optJSONObject.optString("httpStateError");
                        reverseGeoCodeResult.error = optString.equals("NETWORK_ERROR") ? SearchResult.ERRORNO.NETWORK_ERROR : optString.equals("REQUEST_ERROR") ? SearchResult.ERRORNO.REQUEST_ERROR : SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                        return reverseGeoCodeResult;
                    }
                }
                if (!m9939a(str, (SearchResult) reverseGeoCodeResult, true)) {
                    m9903a(str, reverseGeoCodeResult);
                }
                return reverseGeoCodeResult;
            } catch (Exception unused) {
            }
        }
        reverseGeoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        return reverseGeoCodeResult;
    }

    @Override // com.baidu.platform.base.AbstractC1322b
    /* renamed from: a */
    public void mo9795a(SearchResult searchResult, Object obj) {
        if (obj == null || !(obj instanceof OnGetGeoCoderResultListener)) {
            return;
        }
        ((OnGetGeoCoderResultListener) obj).onGetReverseGeoCodeResult((ReverseGeoCodeResult) searchResult);
    }
}
