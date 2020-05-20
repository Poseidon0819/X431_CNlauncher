package com.baidu.platform.core.p096d;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.search.core.CityInfo;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.route.DrivingRouteResult;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.SuggestAddrInfo;
import com.baidu.mapapi.search.route.TransitRouteResult;
import com.baidu.mapapi.search.route.WalkingRouteResult;
import com.baidu.platform.base.AbstractC1322b;
import com.baidu.platform.base.SearchType;
import com.cnlaunch.p181j.ExplainResult;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.platform.core.d.k */
/* loaded from: classes.dex */
public class C1362k extends AbstractC1322b {

    /* renamed from: b */
    SuggestAddrInfo f6520b = null;

    /* renamed from: c */
    protected boolean f6521c;

    /* renamed from: a */
    private SuggestAddrInfo m9825a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject jSONObject2;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("traffic_pois")) == null) {
            return null;
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("option");
        JSONObject optJSONObject3 = optJSONObject.optJSONObject("content");
        if (optJSONObject2 != null && optJSONObject3 != null) {
            JSONObject optJSONObject4 = optJSONObject2.optJSONObject("start_city");
            String optString = optJSONObject4 != null ? optJSONObject4.optString("cname") : null;
            JSONArray optJSONArray = optJSONObject2.optJSONArray("end_city");
            String optString2 = (optJSONArray == null || (jSONObject2 = (JSONObject) optJSONArray.opt(0)) == null) ? null : jSONObject2.optString("cname");
            JSONArray optJSONArray2 = optJSONObject2.optJSONArray("city_list");
            JSONArray optJSONArray3 = optJSONObject2.optJSONArray("prio_flag");
            if (optJSONArray2 != null && optJSONArray3 != null) {
                int length = optJSONArray2.length();
                boolean[] zArr = new boolean[length];
                boolean[] zArr2 = new boolean[length];
                for (int i = 0; i < length; i++) {
                    int parseInt = Integer.parseInt(optJSONArray2.optString(i));
                    int parseInt2 = Integer.parseInt(optJSONArray3.optString(i));
                    boolean z = true;
                    zArr[i] = parseInt == 1;
                    if (parseInt2 != 1) {
                        z = false;
                    }
                    zArr2[i] = z;
                }
                SuggestAddrInfo suggestAddrInfo = new SuggestAddrInfo();
                for (int i2 = 0; i2 < length; i2++) {
                    if (!zArr2[i2]) {
                        if (zArr[i2]) {
                            if (i2 == 0) {
                                suggestAddrInfo.setSuggestStartCity(m9827a(optJSONObject3.optJSONArray(ExplainResult.START)));
                            } else if (i2 != length - 1 || i2 <= 0) {
                                suggestAddrInfo.setSuggestWpCity(m9824a(optJSONObject3, "multi_waypoints"));
                            } else {
                                suggestAddrInfo.setSuggestEndCity(m9827a(optJSONObject3.optJSONArray("end")));
                            }
                        } else if (i2 == 0) {
                            suggestAddrInfo.setSuggestStartNode(m9826a(optJSONObject3.optJSONArray(ExplainResult.START), optString));
                        } else if (i2 != length - 1 || i2 <= 0) {
                            suggestAddrInfo.setSuggestWpNode(m9822b(optJSONObject3, "multi_waypoints"));
                        } else {
                            suggestAddrInfo.setSuggestEndNode(m9826a(optJSONObject3.optJSONArray("end"), optString2));
                        }
                    }
                }
                return suggestAddrInfo;
            }
        }
        return null;
    }

    /* renamed from: a */
    private List<CityInfo> m9827a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = (JSONObject) jSONArray.opt(i);
            if (jSONObject != null) {
                CityInfo cityInfo = new CityInfo();
                cityInfo.num = jSONObject.optInt("num");
                cityInfo.city = jSONObject.optString("name");
                arrayList.add(cityInfo);
            }
        }
        arrayList.trimToSize();
        return arrayList;
    }

    /* renamed from: a */
    private List<PoiInfo> m9826a(JSONArray jSONArray, String str) {
        if (jSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = (JSONObject) jSONArray.opt(i);
                if (jSONObject != null) {
                    PoiInfo poiInfo = new PoiInfo();
                    poiInfo.address = jSONObject.optString("addr");
                    poiInfo.uid = jSONObject.optString("uid");
                    poiInfo.name = jSONObject.optString("name");
                    poiInfo.location = CoordUtil.decodeLocation(jSONObject.optString("geo"));
                    poiInfo.city = str;
                    arrayList.add(poiInfo);
                }
            }
            if (arrayList.size() > 0) {
                return arrayList;
            }
            return null;
        }
        return null;
    }

    /* renamed from: a */
    private List<List<CityInfo>> m9824a(JSONObject jSONObject, String str) {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray(str)) == null) {
            return null;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            List<CityInfo> m9827a = m9827a((JSONArray) optJSONArray.opt(i));
            if (m9827a != null) {
                arrayList.add(m9827a);
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    private List<List<PoiInfo>> m9822b(JSONObject jSONObject, String str) {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray(str)) == null) {
            return null;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            List<PoiInfo> m9826a = m9826a((JSONArray) optJSONArray.opt(i), "");
            if (m9826a != null) {
                arrayList.add(m9826a);
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    private boolean m9823b(String str) {
        if (str != null && str.length() > 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject optJSONObject = jSONObject.optJSONObject("result");
                if (optJSONObject != null && optJSONObject.optInt(VastExtensionXmlManager.TYPE) == 23 && optJSONObject.optInt("error") == 0) {
                    this.f6520b = m9825a(jSONObject);
                    return this.f6520b != null;
                }
                return false;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.platform.base.AbstractC1322b
    /* renamed from: a */
    public SearchResult mo9794a(String str) {
        SearchType a = m9941a();
        this.f6521c = m9823b(str);
        switch (a) {
            case TRANSIT_ROUTE:
                TransitRouteResult transitRouteResult = new TransitRouteResult();
                if (!this.f6521c) {
                    ((C1364l) this).m9821a(str, transitRouteResult);
                    return transitRouteResult;
                }
                transitRouteResult.setSuggestAddrInfo(this.f6520b);
                transitRouteResult.error = SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR;
                return transitRouteResult;
            case DRIVE_ROUTE:
                DrivingRouteResult drivingRouteResult = new DrivingRouteResult();
                if (!this.f6521c) {
                    ((C1354c) this).m9858a(str, drivingRouteResult);
                    return drivingRouteResult;
                }
                drivingRouteResult.setSuggestAddrInfo(this.f6520b);
                drivingRouteResult.error = SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR;
                return drivingRouteResult;
            case WALK_ROUTE:
                WalkingRouteResult walkingRouteResult = new WalkingRouteResult();
                if (!this.f6521c) {
                    ((C1366n) this).m9814a(str, walkingRouteResult);
                    return walkingRouteResult;
                }
                walkingRouteResult.setSuggestAddrInfo(this.f6520b);
                walkingRouteResult.error = SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR;
                return walkingRouteResult;
            default:
                return null;
        }
    }

    @Override // com.baidu.platform.base.AbstractC1322b
    /* renamed from: a */
    public void mo9795a(SearchResult searchResult, Object obj) {
        if (obj == null || !(obj instanceof OnGetRoutePlanResultListener)) {
            return;
        }
        OnGetRoutePlanResultListener onGetRoutePlanResultListener = (OnGetRoutePlanResultListener) obj;
        switch (m9941a()) {
            case TRANSIT_ROUTE:
                onGetRoutePlanResultListener.onGetTransitRouteResult((TransitRouteResult) searchResult);
                return;
            case DRIVE_ROUTE:
                onGetRoutePlanResultListener.onGetDrivingRouteResult((DrivingRouteResult) searchResult);
                return;
            case WALK_ROUTE:
                onGetRoutePlanResultListener.onGetWalkingRouteResult((WalkingRouteResult) searchResult);
                return;
            default:
                return;
        }
    }
}
