package com.baidu.platform.core.p096d;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.CityInfo;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.route.BikingRouteLine;
import com.baidu.mapapi.search.route.BikingRouteResult;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.SuggestAddrInfo;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.base.AbstractC1322b;
import com.itextpdf.text.Annotation;
import com.mopub.mobileads.VastExtensionXmlManager;
import com.mopub.mobileads.VastIconXmlManager;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.platform.core.d.a */
/* loaded from: classes.dex */
public class C1352a extends AbstractC1322b {
    /* renamed from: a */
    private LatLng m9864a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        LatLng latLng = new LatLng(jSONObject.optDouble("lat"), jSONObject.optDouble("lng"));
        return SDKInitializer.getCoordType() == CoordType.GCJ02 ? CoordTrans.baiduToGcj(latLng) : latLng;
    }

    /* renamed from: a */
    private RouteNode m9862a(JSONObject jSONObject, String str, String str2) {
        JSONObject optJSONObject;
        if (jSONObject == null || str == null || "".equals(str) || (optJSONObject = jSONObject.optJSONObject(str)) == null) {
            return null;
        }
        RouteNode routeNode = new RouteNode();
        routeNode.setTitle(optJSONObject.optString("cname"));
        routeNode.setUid(optJSONObject.optString("uid"));
        JSONObject optJSONObject2 = optJSONObject.optJSONObject(str2);
        if (optJSONObject2 != null) {
            LatLng latLng = new LatLng(optJSONObject2.optDouble("lat"), optJSONObject2.optDouble("lng"));
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng = CoordTrans.baiduToGcj(latLng);
            }
            routeNode.setLocation(latLng);
        }
        return routeNode;
    }

    /* renamed from: a */
    private List<BikingRouteLine.BikingStep> m9865a(JSONArray jSONArray) {
        boolean z = jSONArray == null;
        int length = jSONArray.length();
        if ((length <= 0) || z) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                BikingRouteLine.BikingStep bikingStep = new BikingRouteLine.BikingStep();
                bikingStep.setDirection(optJSONObject.optInt("direction") * 30);
                bikingStep.setDistance(optJSONObject.optInt("distance"));
                bikingStep.setDuration(optJSONObject.optInt(VastIconXmlManager.DURATION));
                bikingStep.setName(optJSONObject.optString("name"));
                bikingStep.setTurnType(optJSONObject.optString("turn_type"));
                bikingStep.setEntrance(RouteNode.location(m9864a(optJSONObject.optJSONObject("stepOriginLocation"))));
                bikingStep.setExit(RouteNode.location(m9864a(optJSONObject.optJSONObject("stepDestinationLocation"))));
                String optString = optJSONObject.optString("instructions");
                if (optString != null || optString.length() >= 4) {
                    optString = optString.replaceAll("</?[a-z]>", "");
                }
                bikingStep.setInstructions(optString);
                bikingStep.setEntranceInstructions(optJSONObject.optString("stepOriginInstruction"));
                bikingStep.setExitInstructions(optJSONObject.optString("stepDestinationInstruction"));
                bikingStep.setPathString(optJSONObject.optString("path"));
                arrayList.add(bikingStep);
            }
        }
        if (arrayList.size() > 0) {
            return arrayList;
        }
        return null;
    }

    /* renamed from: a */
    private boolean m9866a(String str, BikingRouteResult bikingRouteResult) {
        JSONArray optJSONArray;
        JSONObject optJSONObject;
        if (str != null && str.length() > 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                switch (jSONObject.optInt("status_sdk")) {
                    case 0:
                        JSONObject optJSONObject2 = jSONObject.optJSONObject("result");
                        if (optJSONObject2 == null) {
                            return false;
                        }
                        int optInt = jSONObject.optInt(VastExtensionXmlManager.TYPE);
                        if (optInt == 1) {
                            bikingRouteResult.setSuggestAddrInfo(m9861b(optJSONObject2));
                            bikingRouteResult.error = SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR;
                        } else if (optInt == 2 && (optJSONArray = optJSONObject2.optJSONArray("routes")) != null && optJSONArray.length() > 0) {
                            RouteNode m9862a = m9862a(optJSONObject2, "origin", "originPt");
                            RouteNode m9862a2 = m9862a(optJSONObject2, Annotation.DESTINATION, "destinationPt");
                            ArrayList arrayList = new ArrayList();
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                BikingRouteLine bikingRouteLine = new BikingRouteLine();
                                try {
                                    optJSONObject = optJSONArray.optJSONObject(i);
                                } catch (Exception unused) {
                                }
                                if (optJSONObject == null) {
                                    return false;
                                }
                                bikingRouteLine.setStarting(m9862a);
                                bikingRouteLine.setTerminal(m9862a2);
                                bikingRouteLine.setDistance(optJSONObject.optInt("distance"));
                                bikingRouteLine.setDuration(optJSONObject.optInt(VastIconXmlManager.DURATION));
                                bikingRouteLine.setSteps(m9865a(optJSONObject.optJSONArray("steps")));
                                arrayList.add(bikingRouteLine);
                            }
                            bikingRouteResult.setRouteLines(arrayList);
                        }
                        return true;
                    case 1:
                        bikingRouteResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                        return true;
                    case 2:
                        bikingRouteResult.error = SearchResult.ERRORNO.SEARCH_OPTION_ERROR;
                        break;
                }
                return false;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /* renamed from: b */
    private SuggestAddrInfo m9861b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        SuggestAddrInfo suggestAddrInfo = new SuggestAddrInfo();
        JSONObject optJSONObject = jSONObject.optJSONObject("origin");
        JSONObject optJSONObject2 = jSONObject.optJSONObject(Annotation.DESTINATION);
        if (optJSONObject != null) {
            int optInt = optJSONObject.optInt("listType");
            String optString = optJSONObject.optString("cityName");
            if (optInt == 1) {
                suggestAddrInfo.setSuggestStartCity(m9863a(optJSONObject, "content"));
            } else if (optInt == 0) {
                suggestAddrInfo.setSuggestStartNode(m9860b(optJSONObject, "content", optString));
            }
        }
        if (optJSONObject2 != null) {
            int optInt2 = optJSONObject2.optInt("listType");
            String optString2 = optJSONObject2.optString("cityName");
            if (optInt2 == 1) {
                suggestAddrInfo.setSuggestEndCity(m9863a(optJSONObject2, "content"));
            } else if (optInt2 == 0) {
                suggestAddrInfo.setSuggestEndNode(m9860b(optJSONObject2, "content", optString2));
            }
        }
        return suggestAddrInfo;
    }

    /* renamed from: b */
    private List<PoiInfo> m9860b(JSONObject jSONObject, String str, String str2) {
        JSONArray optJSONArray;
        if (jSONObject != null && str != null && !"".equals(str) && (optJSONArray = jSONObject.optJSONArray(str)) != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i);
                if (jSONObject2 != null) {
                    PoiInfo poiInfo = new PoiInfo();
                    if (jSONObject2.has("address")) {
                        poiInfo.address = jSONObject2.optString("address");
                    }
                    poiInfo.uid = jSONObject2.optString("uid");
                    poiInfo.name = jSONObject2.optString("name");
                    JSONObject optJSONObject = jSONObject2.optJSONObject("location");
                    if (optJSONObject != null) {
                        poiInfo.location = new LatLng(optJSONObject.optDouble("lat"), optJSONObject.optDouble("lng"));
                        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                            poiInfo.location = CoordTrans.baiduToGcj(poiInfo.location);
                        }
                    }
                    poiInfo.city = str2;
                    arrayList.add(poiInfo);
                }
            }
            if (arrayList.size() > 0) {
                return arrayList;
            }
        }
        return null;
    }

    @Override // com.baidu.platform.base.AbstractC1322b
    /* renamed from: a */
    public SearchResult mo9794a(String str) {
        BikingRouteResult bikingRouteResult = new BikingRouteResult();
        if (str != null && !str.equals("")) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("SDK_InnerError")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                    if (optJSONObject.has("PermissionCheckError")) {
                        bikingRouteResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                        return bikingRouteResult;
                    } else if (optJSONObject.has("httpStateError")) {
                        String optString = optJSONObject.optString("httpStateError");
                        bikingRouteResult.error = optString.equals("NETWORK_ERROR") ? SearchResult.ERRORNO.NETWORK_ERROR : optString.equals("REQUEST_ERROR") ? SearchResult.ERRORNO.REQUEST_ERROR : SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                        return bikingRouteResult;
                    }
                }
                if (!m9939a(str, (SearchResult) bikingRouteResult, false) && !m9866a(str, bikingRouteResult)) {
                    bikingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                }
                return bikingRouteResult;
            } catch (Exception unused) {
            }
        }
        bikingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        return bikingRouteResult;
    }

    /* renamed from: a */
    public List<CityInfo> m9863a(JSONObject jSONObject, String str) {
        JSONArray optJSONArray;
        if (jSONObject == null || str == null || str.equals("") || (optJSONArray = jSONObject.optJSONArray(str)) == null || optJSONArray.length() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i);
            if (jSONObject2 != null) {
                CityInfo cityInfo = new CityInfo();
                cityInfo.num = jSONObject2.optInt("number");
                cityInfo.city = jSONObject2.optString("name");
                arrayList.add(cityInfo);
            }
        }
        arrayList.trimToSize();
        return arrayList;
    }

    @Override // com.baidu.platform.base.AbstractC1322b
    /* renamed from: a */
    public void mo9795a(SearchResult searchResult, Object obj) {
        if (obj == null || !(obj instanceof OnGetRoutePlanResultListener)) {
            return;
        }
        ((OnGetRoutePlanResultListener) obj).onGetBikingRouteResult((BikingRouteResult) searchResult);
    }
}
