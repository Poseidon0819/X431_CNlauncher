package com.baidu.platform.core.busline;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.busline.BusLineResult;
import com.baidu.mapapi.search.busline.OnGetBusLineSearchResultListener;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.platform.base.AbstractC1322b;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.platform.core.busline.a */
/* loaded from: classes.dex */
public class C1340a extends AbstractC1322b {
    @Override // com.baidu.platform.base.AbstractC1322b
    /* renamed from: a */
    public SearchResult mo9794a(String str) {
        BusLineResult busLineResult = new BusLineResult();
        if (str != null && !str.equals("")) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("SDK_InnerError")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                    if (optJSONObject.has("PermissionCheckError")) {
                        busLineResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                        return busLineResult;
                    } else if (optJSONObject.has("httpStateError")) {
                        String optString = optJSONObject.optString("httpStateError");
                        busLineResult.error = optString.equals("NETWORK_ERROR") ? SearchResult.ERRORNO.NETWORK_ERROR : optString.equals("REQUEST_ERROR") ? SearchResult.ERRORNO.REQUEST_ERROR : SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                        return busLineResult;
                    }
                }
                if (!m9939a(str, busLineResult, false) && !m9894a(str, busLineResult)) {
                    busLineResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                }
                return busLineResult;
            } catch (Exception unused) {
            }
        }
        busLineResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        return busLineResult;
    }

    @Override // com.baidu.platform.base.AbstractC1322b
    /* renamed from: a */
    public void mo9795a(SearchResult searchResult, Object obj) {
        if (obj == null || !(obj instanceof OnGetBusLineSearchResultListener)) {
            return;
        }
        ((OnGetBusLineSearchResultListener) obj).onGetBusLineResult((BusLineResult) searchResult);
    }

    /* renamed from: a */
    public boolean m9894a(String str, BusLineResult busLineResult) {
        if (str != null && !"".equals(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject optJSONObject = jSONObject.optJSONObject("result");
                JSONArray optJSONArray = jSONObject.optJSONArray("content");
                if (optJSONObject == null || optJSONArray == null || optJSONArray.length() <= 0) {
                    return false;
                }
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(0);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
                try {
                    busLineResult.setStartTime(simpleDateFormat.parse(optJSONObject2.optString("startTime")));
                    busLineResult.setEndTime(simpleDateFormat.parse(optJSONObject2.optString("endTime")));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                busLineResult.setBusLineName(optJSONObject2.optString("name"));
                busLineResult.setMonthTicket(optJSONObject2.optInt("isMonTicket") == 1);
                busLineResult.setUid(optJSONObject2.optString("uid"));
                busLineResult.setBasePrice(optJSONObject2.optInt("ticketPrice") / 100.0f);
                busLineResult.setLineDirection(optJSONObject2.optString("line_direction"));
                busLineResult.setMaxPrice(optJSONObject2.optInt("maxPrice") / 100.0f);
                ArrayList arrayList = new ArrayList();
                List<List<LatLng>> decodeLocationList2D = CoordUtil.decodeLocationList2D(optJSONObject2.optString("geo"));
                if (decodeLocationList2D != null) {
                    for (List<LatLng> list : decodeLocationList2D) {
                        BusLineResult.BusStep busStep = new BusLineResult.BusStep();
                        busStep.setWayPoints(list);
                        arrayList.add(busStep);
                    }
                }
                if (arrayList.size() > 0) {
                    busLineResult.setSteps(arrayList);
                }
                JSONArray optJSONArray2 = optJSONObject2.optJSONArray("stations");
                if (optJSONArray2 != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < optJSONArray2.length(); i++) {
                        JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i);
                        if (optJSONObject3 != null) {
                            BusLineResult.BusStation busStation = new BusLineResult.BusStation();
                            busStation.setTitle(optJSONObject3.optString("name"));
                            busStation.setLocation(CoordUtil.decodeLocation(optJSONObject3.optString("geo")));
                            busStation.setUid(optJSONObject3.optString("uid"));
                            arrayList2.add(busStation);
                        }
                    }
                    if (arrayList2.size() > 0) {
                        busLineResult.setStations(arrayList2);
                    }
                }
                busLineResult.error = SearchResult.ERRORNO.NO_ERROR;
                return true;
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }
}
