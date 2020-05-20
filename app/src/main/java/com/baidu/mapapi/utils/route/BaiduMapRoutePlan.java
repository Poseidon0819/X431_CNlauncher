package com.baidu.mapapi.utils.route;

import android.content.Context;
import android.util.Log;
import com.baidu.mapapi.navi.IllegalNaviArgumentException;
import com.baidu.mapapi.utils.C1154a;
import com.baidu.mapapi.utils.OpenClientUtil;
import com.baidu.mapapi.utils.poi.IllegalPoiSearchArgumentException;
import com.baidu.mapapi.utils.route.RouteParaOption;

/* loaded from: classes.dex */
public class BaiduMapRoutePlan {

    /* renamed from: a */
    private static boolean f5794a = true;

    /* JADX WARN: Removed duplicated region for block: B:30:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e9  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void m10887a(com.baidu.mapapi.utils.route.RouteParaOption r4, android.content.Context r5, int r6) {
        /*
            Method dump skipped, instructions count: 314
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.utils.route.BaiduMapRoutePlan.m10887a(com.baidu.mapapi.utils.route.RouteParaOption, android.content.Context, int):void");
    }

    public static void finish(Context context) {
        if (context != null) {
            C1154a.m10927a(context);
        }
    }

    public static boolean openBaiduMapDrivingRoute(RouteParaOption routeParaOption, Context context) {
        if (routeParaOption == null || context == null) {
            throw new IllegalPoiSearchArgumentException("para or context can not be null.");
        }
        if (routeParaOption.f5796b == null && routeParaOption.f5795a == null && routeParaOption.f5798d == null && routeParaOption.f5797c == null) {
            throw new IllegalNaviArgumentException("startPoint and endPoint and endName and startName not all null.");
        }
        if (routeParaOption.f5797c == null && routeParaOption.f5795a == null) {
            throw new IllegalNaviArgumentException("startPoint and startName not all null.");
        }
        if (routeParaOption.f5798d == null && routeParaOption.f5796b == null) {
            throw new IllegalNaviArgumentException("endPoint and endName not all null.");
        }
        if (((routeParaOption.f5797c == null || routeParaOption.f5797c.equals("")) && routeParaOption.f5795a == null) || ((routeParaOption.f5798d == null || routeParaOption.f5798d.equals("")) && routeParaOption.f5796b == null)) {
            Log.e(BaiduMapRoutePlan.class.getName(), "poi startName or endName can not be empty string while pt is null");
            return false;
        }
        if (routeParaOption.f5800f == null) {
            routeParaOption.f5800f = RouteParaOption.EBusStrategyType.bus_recommend_way;
        }
        int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
        if (baiduMapVersion == 0) {
            Log.e("baidumapsdk", "BaiduMap app is not installed.");
            if (f5794a) {
                m10887a(routeParaOption, context, 0);
                return true;
            }
            throw new IllegalPoiSearchArgumentException("BaiduMap app is not installed.");
        } else if (baiduMapVersion >= 810) {
            return C1154a.m10923a(routeParaOption, context, 0);
        } else {
            Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.1");
            if (f5794a) {
                m10887a(routeParaOption, context, 0);
                return true;
            }
            throw new IllegalPoiSearchArgumentException("Baidumap app version is too lowl.Version is greater than 8.1");
        }
    }

    public static boolean openBaiduMapTransitRoute(RouteParaOption routeParaOption, Context context) {
        if (routeParaOption == null || context == null) {
            throw new IllegalPoiSearchArgumentException("para or context can not be null.");
        }
        if (routeParaOption.f5796b == null && routeParaOption.f5795a == null && routeParaOption.f5798d == null && routeParaOption.f5797c == null) {
            throw new IllegalNaviArgumentException("startPoint and endPoint and endName and startName not all null.");
        }
        if (routeParaOption.f5797c == null && routeParaOption.f5795a == null) {
            throw new IllegalNaviArgumentException("startPoint and startName not all null.");
        }
        if (routeParaOption.f5798d == null && routeParaOption.f5796b == null) {
            throw new IllegalNaviArgumentException("endPoint and endName not all null.");
        }
        if (((routeParaOption.f5797c == null || routeParaOption.f5797c.equals("")) && routeParaOption.f5795a == null) || ((routeParaOption.f5798d == null || routeParaOption.f5798d.equals("")) && routeParaOption.f5796b == null)) {
            Log.e(BaiduMapRoutePlan.class.getName(), "poi startName or endName can not be empty string while pt is null");
            return false;
        }
        if (routeParaOption.f5800f == null) {
            routeParaOption.f5800f = RouteParaOption.EBusStrategyType.bus_recommend_way;
        }
        int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
        if (baiduMapVersion == 0) {
            Log.e("baidumapsdk", "BaiduMap app is not installed.");
            if (f5794a) {
                m10887a(routeParaOption, context, 1);
                return true;
            }
            throw new IllegalPoiSearchArgumentException("BaiduMap app is not installed.");
        } else if (baiduMapVersion >= 810) {
            return C1154a.m10923a(routeParaOption, context, 1);
        } else {
            Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.1");
            if (f5794a) {
                m10887a(routeParaOption, context, 1);
                return true;
            }
            throw new IllegalPoiSearchArgumentException("Baidumap app version is too lowl.Version is greater than 8.1");
        }
    }

    public static boolean openBaiduMapWalkingRoute(RouteParaOption routeParaOption, Context context) {
        if (routeParaOption == null || context == null) {
            throw new IllegalPoiSearchArgumentException("para or context can not be null.");
        }
        if (routeParaOption.f5796b == null && routeParaOption.f5795a == null && routeParaOption.f5798d == null && routeParaOption.f5797c == null) {
            throw new IllegalNaviArgumentException("startPoint and endPoint and endName and startName not all null.");
        }
        if (routeParaOption.f5797c == null && routeParaOption.f5795a == null) {
            throw new IllegalNaviArgumentException("startPoint and startName not all null.");
        }
        if (routeParaOption.f5798d == null && routeParaOption.f5796b == null) {
            throw new IllegalNaviArgumentException("endPoint and endName not all null.");
        }
        if (((routeParaOption.f5797c == null || routeParaOption.f5797c.equals("")) && routeParaOption.f5795a == null) || ((routeParaOption.f5798d == null || routeParaOption.f5798d.equals("")) && routeParaOption.f5796b == null)) {
            Log.e(BaiduMapRoutePlan.class.getName(), "poi startName or endName can not be empty string while pt is null");
            return false;
        }
        if (routeParaOption.f5800f == null) {
            routeParaOption.f5800f = RouteParaOption.EBusStrategyType.bus_recommend_way;
        }
        int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
        if (baiduMapVersion == 0) {
            Log.e("baidumapsdk", "BaiduMap app is not installed.");
            if (f5794a) {
                m10887a(routeParaOption, context, 2);
                return true;
            }
            throw new IllegalPoiSearchArgumentException("BaiduMap app is not installed.");
        } else if (baiduMapVersion >= 810) {
            return C1154a.m10923a(routeParaOption, context, 2);
        } else {
            Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.1");
            if (f5794a) {
                m10887a(routeParaOption, context, 2);
                return true;
            }
            throw new IllegalPoiSearchArgumentException("Baidumap app version is too lowl.Version is greater than 8.1");
        }
    }

    public static void setSupportWebRoute(boolean z) {
        f5794a = z;
    }
}
