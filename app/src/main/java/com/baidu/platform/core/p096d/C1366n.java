package com.baidu.platform.core.p096d;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.TaxiInfo;
import com.baidu.mapapi.search.route.WalkingRouteLine;
import com.baidu.mapapi.search.route.WalkingRouteResult;
import com.cnlaunch.p181j.ExplainResult;
import com.mopub.mobileads.VastIconXmlManager;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.platform.core.d.n */
/* loaded from: classes.dex */
public class C1366n extends C1362k {
    /* renamed from: a */
    private RouteNode m9812a(JSONArray jSONArray, List<RouteNode> list) {
        int length;
        if (jSONArray != null && (length = jSONArray.length()) > 0) {
            for (int i = 0; i < length; i++) {
                RouteNode m9811a = m9811a(jSONArray.optJSONObject(i));
                if (i == length - 1) {
                    return m9811a;
                }
                if (list == null) {
                    list = new ArrayList<>();
                }
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(m9811a);
            }
        }
        return null;
    }

    /* renamed from: a */
    private RouteNode m9811a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        RouteNode routeNode = new RouteNode();
        routeNode.setTitle(jSONObject.optString("wd"));
        routeNode.setUid(jSONObject.optString("uid"));
        routeNode.setLocation(CoordUtil.decodeLocation(jSONObject.optString("pt")));
        return routeNode;
    }

    /* renamed from: a */
    private List<WalkingRouteLine.WalkingStep> m9813a(JSONArray jSONArray) {
        int length;
        if (jSONArray == null || (length = jSONArray.length()) <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                WalkingRouteLine.WalkingStep walkingStep = new WalkingRouteLine.WalkingStep();
                walkingStep.setDirection(optJSONObject.optInt("direction") * 30);
                walkingStep.setDistance(optJSONObject.optInt("distance"));
                walkingStep.setDuration(optJSONObject.optInt(VastIconXmlManager.DURATION));
                walkingStep.setEntrance(RouteNode.location(CoordUtil.decodeLocation(optJSONObject.optString("start_location"))));
                walkingStep.setExit(RouteNode.location(CoordUtil.decodeLocation(optJSONObject.optString("end_location"))));
                String optString = optJSONObject.optString("instructions");
                if (optString != null || optString.length() >= 4) {
                    optString = optString.replaceAll("</?[a-z]>", "");
                }
                walkingStep.setInstructions(optString);
                walkingStep.setEntranceInstructions(optJSONObject.optString("start_instructions"));
                walkingStep.setExitInstructions(optJSONObject.optString("end_instructions"));
                walkingStep.setPathString(optJSONObject.optString("path"));
                arrayList.add(walkingStep);
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    private TaxiInfo m9810b(String str) {
        JSONObject jSONObject;
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        TaxiInfo taxiInfo = new TaxiInfo();
        taxiInfo.setDesc(jSONObject.optString("remark"));
        taxiInfo.setDistance(jSONObject.optInt("distance"));
        taxiInfo.setDuration(jSONObject.optInt(VastIconXmlManager.DURATION));
        taxiInfo.setTotalPrice((float) jSONObject.optDouble("total_price"));
        taxiInfo.setStartPrice((float) jSONObject.optDouble("start_price"));
        taxiInfo.setPerKMPrice((float) jSONObject.optDouble("km_price"));
        return taxiInfo;
    }

    /* renamed from: b */
    private boolean m9809b(String str, WalkingRouteResult walkingRouteResult) {
        JSONArray optJSONArray;
        if (str != null && !"".equals(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (walkingRouteResult == null) {
                    return false;
                }
                if (jSONObject.has("taxi")) {
                    walkingRouteResult.setTaxiInfo(m9810b(jSONObject.optString("taxi")));
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("result");
                if (optJSONObject == null) {
                    return false;
                }
                int optInt = optJSONObject.optInt("error");
                if (optInt != 0) {
                    if (optInt != 4) {
                        return false;
                    }
                    walkingRouteResult.error = SearchResult.ERRORNO.ST_EN_TOO_NEAR;
                    return true;
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("walk");
                if (optJSONObject2 == null) {
                    return false;
                }
                JSONArray optJSONArray2 = optJSONObject2.optJSONArray("routes");
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("option");
                if (optJSONObject3 == null || optJSONArray2 == null) {
                    return false;
                }
                RouteNode m9811a = m9811a(optJSONObject3.optJSONObject(ExplainResult.START));
                RouteNode m9812a = m9812a(optJSONObject3.optJSONArray("end"), (List<RouteNode>) null);
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    JSONObject optJSONObject4 = optJSONArray2.optJSONObject(i);
                    if (optJSONObject4 != null && (optJSONArray = optJSONObject4.optJSONArray("legs")) != null && optJSONArray.length() > 0) {
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            JSONObject optJSONObject5 = optJSONArray.optJSONObject(i);
                            if (optJSONObject5 != null) {
                                WalkingRouteLine walkingRouteLine = new WalkingRouteLine();
                                walkingRouteLine.setStarting(m9811a);
                                walkingRouteLine.setTerminal(m9812a);
                                walkingRouteLine.setDistance(optJSONObject5.optInt("distance"));
                                walkingRouteLine.setDuration(optJSONObject5.optInt(VastIconXmlManager.DURATION));
                                walkingRouteLine.setSteps(m9813a(optJSONObject5.optJSONArray("steps")));
                                arrayList.add(walkingRouteLine);
                            }
                        }
                    }
                }
                walkingRouteResult.setRouteLines(arrayList);
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /* renamed from: a */
    public void m9814a(String str, WalkingRouteResult walkingRouteResult) {
        if (str != null && !str.equals("")) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("SDK_InnerError")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                    if (optJSONObject.has("PermissionCheckError")) {
                        walkingRouteResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                        return;
                    } else if (optJSONObject.has("httpStateError")) {
                        String optString = optJSONObject.optString("httpStateError");
                        if (optString.equals("NETWORK_ERROR")) {
                            walkingRouteResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                            return;
                        } else if (optString.equals("REQUEST_ERROR")) {
                            walkingRouteResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                            return;
                        } else {
                            walkingRouteResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                            return;
                        }
                    }
                }
                if (m9939a(str, walkingRouteResult, false) || m9809b(str, walkingRouteResult)) {
                    return;
                }
                walkingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                return;
            } catch (Exception unused) {
            }
        }
        walkingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
    }
}
