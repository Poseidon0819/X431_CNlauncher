package com.baidu.platform.core.p096d;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.route.IndoorRouteLine;
import com.baidu.mapapi.search.route.IndoorRouteResult;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.platform.base.AbstractC1322b;
import com.mopub.mobileads.VastExtensionXmlManager;
import com.mopub.mobileads.VastIconXmlManager;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.platform.core.d.f */
/* loaded from: classes.dex */
public class C1357f extends AbstractC1322b {
    /* renamed from: a */
    private LatLng m9847a(JSONObject jSONObject, String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray != null) {
            GeoPoint geoPoint = new GeoPoint(0.0d, 0.0d);
            geoPoint.setLatitudeE6(optJSONArray.optDouble(1));
            geoPoint.setLongitudeE6(optJSONArray.optDouble(0));
            return CoordUtil.mc2ll(geoPoint);
        }
        return null;
    }

    /* renamed from: a */
    private boolean m9848a(String str, IndoorRouteResult indoorRouteResult) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONArray jSONArray;
        int i;
        IndoorRouteLine indoorRouteLine;
        JSONArray jSONArray2;
        int i2;
        IndoorRouteLine indoorRouteLine2;
        JSONArray jSONArray3;
        SearchResult.ERRORNO errorno;
        IndoorRouteResult indoorRouteResult2 = indoorRouteResult;
        if (str == null || "".equals(str)) {
            return false;
        }
        try {
            JSONObject optJSONObject3 = new JSONObject(str).optJSONObject("indoor_navi");
            if (optJSONObject3 == null || (optJSONObject = optJSONObject3.optJSONObject("option")) == null) {
                return false;
            }
            int optInt = optJSONObject.optInt("error");
            if (optInt != 0) {
                switch (optInt) {
                    case 6:
                        errorno = SearchResult.ERRORNO.INDOOR_ROUTE_NO_IN_BUILDING;
                        break;
                    case 7:
                        errorno = SearchResult.ERRORNO.INDOOR_ROUTE_NO_IN_SAME_BUILDING;
                        break;
                    default:
                        return false;
                }
                indoorRouteResult2.error = errorno;
                return true;
            }
            JSONArray optJSONArray = optJSONObject3.optJSONArray("routes");
            if (optJSONArray == null || (optJSONObject2 = optJSONArray.optJSONObject(0)) == null) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray2 = optJSONObject2.optJSONArray("legs");
            if (optJSONArray2 == null) {
                return false;
            }
            int i3 = 0;
            while (i3 < optJSONArray2.length()) {
                IndoorRouteLine indoorRouteLine3 = new IndoorRouteLine();
                JSONObject optJSONObject4 = optJSONArray2.optJSONObject(i3);
                if (optJSONObject4 != null) {
                    indoorRouteLine3.setDistance(optJSONObject4.optInt("distance"));
                    indoorRouteLine3.setDuration(optJSONObject4.optInt(VastIconXmlManager.DURATION));
                    indoorRouteLine3.setStarting(RouteNode.location(m9847a(optJSONObject4, "sstart_location")));
                    indoorRouteLine3.setTerminal(RouteNode.location(m9847a(optJSONObject4, "send_location")));
                    JSONArray optJSONArray3 = optJSONObject4.optJSONArray("steps");
                    if (optJSONArray3 != null) {
                        ArrayList arrayList2 = new ArrayList();
                        int i4 = 0;
                        while (i4 < optJSONArray3.length()) {
                            IndoorRouteLine.IndoorRouteStep indoorRouteStep = new IndoorRouteLine.IndoorRouteStep();
                            JSONObject optJSONObject5 = optJSONArray3.optJSONObject(i4);
                            if (optJSONObject5 != null) {
                                indoorRouteStep.setDistance(optJSONObject5.optInt("distance"));
                                indoorRouteStep.setDuration(optJSONObject5.optInt(VastIconXmlManager.DURATION));
                                indoorRouteStep.setBuildingId(optJSONObject5.optString("buildingid"));
                                indoorRouteStep.setFloorId(optJSONObject5.optString("floorid"));
                                indoorRouteStep.setEntrace(RouteNode.location(m9847a(optJSONObject5, "sstart_location")));
                                indoorRouteStep.setExit(RouteNode.location(m9847a(optJSONObject5, "send_location")));
                                JSONArray optJSONArray4 = optJSONObject5.optJSONArray("spath");
                                if (optJSONArray4 != null) {
                                    ArrayList arrayList3 = new ArrayList();
                                    int i5 = 5;
                                    i2 = i3;
                                    double d = 0.0d;
                                    double d2 = 0.0d;
                                    while (i5 < optJSONArray4.length()) {
                                        double optDouble = d + optJSONArray4.optDouble(i5 + 1);
                                        double optDouble2 = d2 + optJSONArray4.optDouble(i5);
                                        JSONArray jSONArray4 = optJSONArray2;
                                        GeoPoint geoPoint = new GeoPoint(0.0d, 0.0d);
                                        geoPoint.setLatitudeE6(optDouble);
                                        geoPoint.setLongitudeE6(optDouble2);
                                        LatLng mc2ll = CoordUtil.mc2ll(geoPoint);
                                        arrayList3.add(Double.valueOf(mc2ll.latitude));
                                        arrayList3.add(Double.valueOf(mc2ll.longitude));
                                        i5 += 2;
                                        optJSONArray2 = jSONArray4;
                                        indoorRouteLine3 = indoorRouteLine3;
                                        optJSONArray3 = optJSONArray3;
                                        d2 = optDouble2;
                                        d = optDouble;
                                    }
                                    jSONArray2 = optJSONArray2;
                                    indoorRouteLine2 = indoorRouteLine3;
                                    jSONArray3 = optJSONArray3;
                                    indoorRouteStep.setPath(arrayList3);
                                    indoorRouteStep.setInstructions(optJSONObject5.optString("instructions"));
                                    JSONArray optJSONArray5 = optJSONObject5.optJSONArray("pois");
                                    if (optJSONArray5 != null) {
                                        ArrayList arrayList4 = new ArrayList();
                                        for (int i6 = 0; i6 < optJSONArray5.length(); i6++) {
                                            JSONObject optJSONObject6 = optJSONArray5.optJSONObject(i6);
                                            if (optJSONObject6 != null) {
                                                IndoorRouteLine.IndoorRouteStep.IndoorStepNode indoorStepNode = new IndoorRouteLine.IndoorRouteStep.IndoorStepNode();
                                                indoorStepNode.setDetail(optJSONObject6.optString("detail"));
                                                indoorStepNode.setName(optJSONObject6.optString("name"));
                                                indoorStepNode.setType(optJSONObject6.optInt(VastExtensionXmlManager.TYPE));
                                                indoorStepNode.setLocation(m9847a(optJSONObject6, "location"));
                                                arrayList4.add(indoorStepNode);
                                            }
                                        }
                                        indoorRouteStep.setStepNodes(arrayList4);
                                    }
                                    arrayList2.add(indoorRouteStep);
                                    i4++;
                                    i3 = i2;
                                    optJSONArray2 = jSONArray2;
                                    indoorRouteLine3 = indoorRouteLine2;
                                    optJSONArray3 = jSONArray3;
                                }
                            }
                            jSONArray2 = optJSONArray2;
                            i2 = i3;
                            indoorRouteLine2 = indoorRouteLine3;
                            jSONArray3 = optJSONArray3;
                            i4++;
                            i3 = i2;
                            optJSONArray2 = jSONArray2;
                            indoorRouteLine3 = indoorRouteLine2;
                            optJSONArray3 = jSONArray3;
                        }
                        jSONArray = optJSONArray2;
                        i = i3;
                        IndoorRouteLine indoorRouteLine4 = indoorRouteLine3;
                        if (arrayList2.size() > 0) {
                            indoorRouteLine = indoorRouteLine4;
                            indoorRouteLine.setSteps(arrayList2);
                        } else {
                            indoorRouteLine = indoorRouteLine4;
                        }
                    } else {
                        jSONArray = optJSONArray2;
                        i = i3;
                        indoorRouteLine = indoorRouteLine3;
                    }
                    arrayList.add(indoorRouteLine);
                } else {
                    jSONArray = optJSONArray2;
                    i = i3;
                }
                i3 = i + 1;
                optJSONArray2 = jSONArray;
                indoorRouteResult2 = indoorRouteResult;
            }
            indoorRouteResult2.setRouteLines(arrayList);
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.baidu.platform.base.AbstractC1322b
    /* renamed from: a */
    public SearchResult mo9794a(String str) {
        IndoorRouteResult indoorRouteResult = new IndoorRouteResult();
        if (str != null && !str.equals("")) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("SDK_InnerError")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                    if (optJSONObject.has("PermissionCheckError")) {
                        indoorRouteResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                        return indoorRouteResult;
                    } else if (optJSONObject.has("httpStateError")) {
                        String optString = optJSONObject.optString("httpStateError");
                        indoorRouteResult.error = optString.equals("NETWORK_ERROR") ? SearchResult.ERRORNO.NETWORK_ERROR : optString.equals("REQUEST_ERROR") ? SearchResult.ERRORNO.REQUEST_ERROR : SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                        return indoorRouteResult;
                    }
                }
                if (!m9848a(str, indoorRouteResult)) {
                    indoorRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                }
                return indoorRouteResult;
            } catch (Exception unused) {
            }
        }
        indoorRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        return indoorRouteResult;
    }

    @Override // com.baidu.platform.base.AbstractC1322b
    /* renamed from: a */
    public void mo9795a(SearchResult searchResult, Object obj) {
        if (obj == null || !(obj instanceof OnGetRoutePlanResultListener)) {
            return;
        }
        ((OnGetRoutePlanResultListener) obj).onGetIndoorRouteResult((IndoorRouteResult) searchResult);
    }
}
