package com.baidu.platform.core.p096d;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.TaxiInfo;
import com.baidu.mapapi.search.core.VehicleInfo;
import com.baidu.mapapi.search.route.TransitRouteLine;
import com.baidu.mapapi.search.route.TransitRouteResult;
import com.cnlaunch.p181j.ExplainResult;
import com.itextpdf.text.pdf.ColumnText;
import com.mopub.mobileads.VastExtensionXmlManager;
import com.mopub.mobileads.VastIconXmlManager;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.platform.core.d.l */
/* loaded from: classes.dex */
public class C1364l extends C1362k {
    /* renamed from: a */
    private RouteNode m9819a(JSONObject jSONObject, String str) {
        if (jSONObject == null || str == null || "".equals(str)) {
            return null;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        RouteNode routeNode = new RouteNode();
        routeNode.setTitle(optJSONObject.optString("wd"));
        routeNode.setUid(optJSONObject.optString("uid"));
        routeNode.setLocation(CoordUtil.decodeLocation(optJSONObject.optString("pt")));
        return routeNode;
    }

    /* renamed from: a */
    private TaxiInfo m9820a(JSONObject jSONObject) {
        float f;
        float f2;
        float f3;
        if (jSONObject == null) {
            return null;
        }
        TaxiInfo taxiInfo = new TaxiInfo();
        JSONArray optJSONArray = jSONObject.optJSONArray("detail");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return null;
        }
        int length = optJSONArray.length();
        int i = 0;
        while (true) {
            f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            if (i >= length) {
                f2 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                f3 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                break;
            }
            JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i);
            if (jSONObject2 != null && jSONObject2.optString("desc").contains("白天")) {
                f2 = (float) jSONObject2.optDouble("km_price");
                f3 = (float) jSONObject2.optDouble("start_price");
                f = (float) jSONObject2.optDouble("total_price");
                break;
            }
            i++;
        }
        taxiInfo.setDesc(jSONObject.optString("remark"));
        taxiInfo.setDistance(jSONObject.optInt("distance"));
        taxiInfo.setDuration(jSONObject.optInt(VastIconXmlManager.DURATION));
        taxiInfo.setTotalPrice(f);
        taxiInfo.setStartPrice(f3);
        taxiInfo.setPerKMPrice(f2);
        return taxiInfo;
    }

    /* renamed from: b */
    private String m9818b(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        char[] charArray = str.toCharArray();
        boolean z = false;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '<') {
                z = true;
            } else if (charArray[i] == '>') {
                z = false;
            } else if (!z) {
                sb.append(charArray[i]);
            }
        }
        return sb.toString();
    }

    /* renamed from: b */
    private boolean m9817b(String str, TransitRouteResult transitRouteResult) {
        SearchResult.ERRORNO errorno;
        int i = 0;
        if (str == null || str.length() <= 0) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("result");
            if (optJSONObject == null) {
                return false;
            }
            int optInt = optJSONObject.optInt("error");
            if (optInt != 200) {
                switch (optInt) {
                    case 0:
                        JSONObject optJSONObject2 = jSONObject.optJSONObject("bus");
                        if (optJSONObject2 == null) {
                            return false;
                        }
                        JSONObject optJSONObject3 = optJSONObject2.optJSONObject("taxi");
                        if (optJSONObject3 != null) {
                            transitRouteResult.setTaxiInfo(m9820a(optJSONObject3));
                        }
                        JSONObject optJSONObject4 = optJSONObject2.optJSONObject("option");
                        if (optJSONObject4 == null) {
                            return false;
                        }
                        RouteNode m9819a = m9819a(optJSONObject4, ExplainResult.START);
                        RouteNode m9819a2 = m9819a(optJSONObject4, "end");
                        JSONArray optJSONArray = optJSONObject2.optJSONArray("routes");
                        if (optJSONArray == null || optJSONArray.length() <= 0) {
                            return false;
                        }
                        ArrayList arrayList = new ArrayList();
                        int i2 = 0;
                        while (i2 < optJSONArray.length()) {
                            JSONObject jSONObject2 = (JSONObject) ((JSONObject) optJSONArray.opt(i2)).optJSONArray("legs").opt(i);
                            if (jSONObject2 != null) {
                                TransitRouteLine transitRouteLine = new TransitRouteLine();
                                transitRouteLine.setDistance(jSONObject2.optInt("distance"));
                                transitRouteLine.setDuration(jSONObject2.optInt(VastIconXmlManager.DURATION));
                                transitRouteLine.setStarting(m9819a);
                                transitRouteLine.setTerminal(m9819a2);
                                JSONArray optJSONArray2 = jSONObject2.optJSONArray("steps");
                                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                                    ArrayList arrayList2 = new ArrayList();
                                    int i3 = 0;
                                    while (i3 < optJSONArray2.length()) {
                                        JSONArray optJSONArray3 = optJSONArray2.optJSONObject(i3).optJSONArray("step");
                                        if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                                            JSONObject optJSONObject5 = optJSONArray3.optJSONObject(i);
                                            TransitRouteLine.TransitStep transitStep = new TransitRouteLine.TransitStep();
                                            transitStep.setEntrace(RouteNode.location(CoordUtil.decodeLocation(optJSONObject5.optString("start_location"))));
                                            transitStep.setExit(RouteNode.location(CoordUtil.decodeLocation(optJSONObject5.optString("end_location"))));
                                            transitStep.setStepType(optJSONObject5.optInt(VastExtensionXmlManager.TYPE) == 5 ? TransitRouteLine.TransitStep.TransitRouteStepType.WAKLING : TransitRouteLine.TransitStep.TransitRouteStepType.BUSLINE);
                                            transitStep.setInstructions(m9818b(optJSONObject5.optString("instructions")));
                                            transitStep.setDistance(optJSONObject5.optInt("distance"));
                                            transitStep.setDuration(optJSONObject5.optInt(VastIconXmlManager.DURATION));
                                            transitStep.setPathString(optJSONObject5.optString("path"));
                                            if (optJSONObject5.has("vehicle")) {
                                                transitStep.setVehicleInfo(m9816c(optJSONObject5.optString("vehicle")));
                                                JSONObject optJSONObject6 = optJSONObject5.optJSONObject("vehicle");
                                                transitStep.getEntrance().setUid(optJSONObject6.optString("start_uid"));
                                                transitStep.getEntrance().setTitle(optJSONObject6.optString("start_name"));
                                                transitStep.getExit().setUid(optJSONObject6.optString("end_uid"));
                                                transitStep.getExit().setTitle(optJSONObject6.optString("end_name"));
                                                Integer valueOf = Integer.valueOf(optJSONObject6.optInt(VastExtensionXmlManager.TYPE));
                                                transitStep.setStepType((valueOf == null || valueOf.intValue() != 1) ? TransitRouteLine.TransitStep.TransitRouteStepType.BUSLINE : TransitRouteLine.TransitStep.TransitRouteStepType.SUBWAY);
                                            }
                                            arrayList2.add(transitStep);
                                        }
                                        i3++;
                                        i = 0;
                                    }
                                    transitRouteLine.setSteps(arrayList2);
                                    arrayList.add(transitRouteLine);
                                }
                            }
                            i2++;
                            i = 0;
                        }
                        transitRouteResult.setRoutelines(arrayList);
                        return true;
                    case 1:
                        errorno = SearchResult.ERRORNO.ST_EN_TOO_NEAR;
                        break;
                    default:
                        return false;
                }
            } else {
                errorno = SearchResult.ERRORNO.NOT_SUPPORT_BUS_2CITY;
            }
            transitRouteResult.error = errorno;
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: c */
    private VehicleInfo m9816c(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        VehicleInfo vehicleInfo = new VehicleInfo();
        vehicleInfo.setZonePrice(jSONObject.optInt("zone_price"));
        vehicleInfo.setTotalPrice(jSONObject.optInt("total_price"));
        vehicleInfo.setTitle(jSONObject.optString("name"));
        vehicleInfo.setPassStationNum(jSONObject.optInt("stop_num"));
        vehicleInfo.setUid(jSONObject.optString("uid"));
        return vehicleInfo;
    }

    /* renamed from: a */
    public void m9821a(String str, TransitRouteResult transitRouteResult) {
        if (str != null && !str.equals("")) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("SDK_InnerError")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                    if (optJSONObject.has("PermissionCheckError")) {
                        transitRouteResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                        return;
                    } else if (optJSONObject.has("httpStateError")) {
                        String optString = optJSONObject.optString("httpStateError");
                        if (optString.equals("NETWORK_ERROR")) {
                            transitRouteResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                            return;
                        } else if (optString.equals("REQUEST_ERROR")) {
                            transitRouteResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                            return;
                        } else {
                            transitRouteResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                            return;
                        }
                    }
                }
                if (m9939a(str, transitRouteResult, false) || m9817b(str, transitRouteResult)) {
                    return;
                }
                transitRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                return;
            } catch (Exception unused) {
            }
        }
        transitRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
    }
}
