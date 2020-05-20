package com.baidu.mapsdkplatform.comapi.synchronization.p089b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.Polyline;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceConstant;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceData;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceDisplayOptions;
import com.baidu.mapapi.synchronization.histroytrace.OnHistoryTraceListener;
import com.baidu.mapsdkplatform.comapi.synchronization.p091d.C1255a;
import com.itextpdf.text.pdf.ColumnText;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.baidu.mapsdkplatform.comapi.synchronization.b.c */
/* loaded from: classes.dex */
class HandlerC1244c extends Handler {

    /* renamed from: a */
    private static final String f6172a = "c";

    /* renamed from: b */
    private static OnHistoryTraceListener f6173b;

    /* renamed from: c */
    private HistoryTraceDisplayOptions f6174c;

    /* renamed from: d */
    private BaiduMap f6175d;

    /* renamed from: e */
    private int f6176e;

    /* renamed from: f */
    private Marker f6177f;

    /* renamed from: g */
    private Marker f6178g;

    /* renamed from: h */
    private Marker f6179h;

    /* renamed from: i */
    private List<Polyline> f6180i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC1244c(Looper looper) {
        super(looper);
        this.f6180i = new CopyOnWriteArrayList();
    }

    /* renamed from: a */
    private void m10500a(int i, String str) {
        OnHistoryTraceListener onHistoryTraceListener = f6173b;
        if (onHistoryTraceListener == null) {
            C1255a.m10453b(f6172a, "OnHistoryTraceListener is null");
        } else {
            onHistoryTraceListener.onRenderHistroyTrace(i, str);
        }
    }

    /* renamed from: a */
    private void m10499a(BitmapDescriptor bitmapDescriptor, int i, List<HistoryTraceData.HistoryTracePoint> list) {
        List<List<LatLng>> m10489b = m10489b(list);
        if (m10489b == null || m10489b.isEmpty()) {
            C1255a.m10453b(f6172a, "Calculate sub section points error");
            return;
        }
        m10492b();
        for (int i2 = 0; i2 < m10489b.size(); i2++) {
            List<LatLng> list2 = m10489b.get(i2);
            if (list2 != null && !list2.isEmpty()) {
                if (list2.size() < 2) {
                    C1255a.m10453b(f6172a, "Error points list, index = ".concat(String.valueOf(i2)));
                } else {
                    m10498a((Polyline) this.f6175d.addOverlay(new PolylineOptions().width(i).points(list2).dottedLine(true).customTexture(bitmapDescriptor).zIndex(4)));
                }
            }
        }
    }

    /* renamed from: a */
    private void m10498a(Polyline polyline) {
        this.f6180i.add(polyline);
    }

    /* renamed from: a */
    private void m10497a(LatLng latLng) {
        if (!this.f6174c.isShowStartPositionIcon()) {
            C1255a.m10453b(f6172a, "User set not render start point marker");
        } else if (latLng == null) {
            C1255a.m10453b(f6172a, "Start point is null");
            m10500a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_START_POINT_NULL, "History trace end point is null, can't render start point marker");
        } else {
            BitmapDescriptor startPositionIcon = this.f6174c.getStartPositionIcon();
            if (startPositionIcon == null) {
                C1255a.m10453b(f6172a, "There is no startPositionIcon");
                m10500a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_START_POINT_ICON_NULL, "History trace end point icon is null, can't render start point marker");
                return;
            }
            this.f6177f = (Marker) this.f6175d.addOverlay(new MarkerOptions().position(latLng).icon(startPositionIcon).zIndex(5));
        }
    }

    /* renamed from: a */
    private void m10496a(HistoryTraceData historyTraceData) {
        if (5 != this.f6176e) {
            C1255a.m10453b(f6172a, "Current order state not the complete state, render forbidden");
            m10500a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_CURRENT_ORDER_STATE_NOT_COMPLETE, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_CURRENT_ORDER_STATE_NOT_COMPLETE);
            return;
        }
        BaiduMap baiduMap = this.f6175d;
        if (baiduMap == null) {
            m10500a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_BAIDUMAP_NULL, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_BAIDUMAP_NULL);
            return;
        }
        baiduMap.clear();
        if (this.f6174c == null) {
            m10500a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_DISPLAY_OPTIONS_NULL, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_DISPLAY_OPTIONS_NULL);
            this.f6174c = new HistoryTraceDisplayOptions();
        }
        m10497a(historyTraceData.getOrderStartPosition());
        m10490b(historyTraceData.getOrderEndPosition());
        List<HistoryTraceData.HistoryTracePoint> pointsList = historyTraceData.getPointsList();
        if (pointsList != null && !pointsList.isEmpty()) {
            m10487c(pointsList.get(0).getPoint());
        }
        m10493a(pointsList);
        m10488c();
    }

    /* renamed from: a */
    private void m10493a(List<HistoryTraceData.HistoryTracePoint> list) {
        if (!this.f6174c.isShowRoutePlan()) {
            C1255a.m10453b(f6172a, "User set not render route polyline");
        } else if (list == null || list.isEmpty()) {
            C1255a.m10453b(f6172a, "There is no points data");
            m10500a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_POINTS_NULL, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_POINTS_NULL);
        } else if (list.size() < 2) {
            C1255a.m10453b(f6172a, "History trace points less than 2, can't render polyline");
            m10500a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_POINTS_LESS, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_POINTS_LESS);
        } else {
            BitmapDescriptor routeLineTexture = this.f6174c.getRouteLineTexture();
            if (routeLineTexture == null) {
                C1255a.m10453b(f6172a, "Route polyline texture is null");
                m10500a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_ROUTE_TEXTURE_NULL, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_ROUTE_TEXTURE_NULL);
                return;
            }
            int routeLineWidth = this.f6174c.getRouteLineWidth();
            if (this.f6174c.isRouteLineRenderBySubSection()) {
                m10491b(routeLineTexture, routeLineWidth, list);
            } else {
                m10499a(routeLineTexture, routeLineWidth, list);
            }
        }
    }

    /* renamed from: b */
    private List<List<LatLng>> m10489b(List<HistoryTraceData.HistoryTracePoint> list) {
        String str;
        String str2;
        HistoryTraceData.HistoryTracePoint historyTracePoint;
        if (list == null || list.isEmpty()) {
            str = f6172a;
            str2 = "History trace point list is null";
        } else if (list.size() >= 2) {
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size() - 1; i++) {
                HistoryTraceData.HistoryTracePoint historyTracePoint2 = list.get(i);
                if (historyTracePoint2 != null && (historyTracePoint = list.get(i + 1)) != null) {
                    arrayList.add(historyTracePoint2.getPoint());
                    if (historyTracePoint.getLocationTime() - historyTracePoint2.getLocationTime() > 300) {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.addAll(arrayList);
                        copyOnWriteArrayList.add(arrayList2);
                        arrayList.clear();
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                arrayList.add(list.get(list.size() - 1).getPoint());
                copyOnWriteArrayList.add(arrayList);
            }
            return copyOnWriteArrayList;
        } else {
            str = f6172a;
            str2 = "History trace point list size is less than 2, can't render polyline";
        }
        C1255a.m10453b(str, str2);
        return null;
    }

    /* renamed from: b */
    private void m10492b() {
        List<Polyline> list = this.f6180i;
        if (list != null && !list.isEmpty()) {
            this.f6180i.clear();
        }
        if (this.f6180i == null) {
            this.f6180i = new CopyOnWriteArrayList();
        }
    }

    /* renamed from: b */
    private void m10491b(BitmapDescriptor bitmapDescriptor, int i, List<HistoryTraceData.HistoryTracePoint> list) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (list.get(i2) != null) {
                arrayList.add(list.get(i2).getPoint());
            }
        }
        PolylineOptions zIndex = new PolylineOptions().width(i).points(arrayList).dottedLine(true).customTexture(bitmapDescriptor).zIndex(4);
        m10492b();
        m10498a((Polyline) this.f6175d.addOverlay(zIndex));
    }

    /* renamed from: b */
    private void m10490b(LatLng latLng) {
        if (!this.f6174c.isShowEndPositionIcon()) {
            C1255a.m10453b(f6172a, "User set not render end point marker");
        } else if (latLng == null) {
            C1255a.m10453b(f6172a, "End point is null");
            m10500a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_END_POINT_NULL, "History trace end point is null, can't render start point marker");
        } else {
            BitmapDescriptor endPositionIcon = this.f6174c.getEndPositionIcon();
            if (endPositionIcon == null) {
                C1255a.m10453b(f6172a, "There is no endPositionIcon");
                m10500a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_END_POINT_ICON_NULL, "History trace end point icon is null, can't render start point marker");
                return;
            }
            this.f6178g = (Marker) this.f6175d.addOverlay(new MarkerOptions().position(latLng).icon(endPositionIcon).zIndex(5));
        }
    }

    /* renamed from: c */
    private void m10488c() {
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        Marker marker = this.f6177f;
        if (marker != null) {
            builder.include(marker.getPosition());
        }
        Marker marker2 = this.f6178g;
        if (marker2 != null) {
            builder.include(marker2.getPosition());
        }
        Marker marker3 = this.f6179h;
        if (marker3 != null) {
            builder.include(marker3.getPosition());
        }
        List<Polyline> list = this.f6180i;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < this.f6180i.size(); i++) {
                Polyline polyline = this.f6180i.get(i);
                if (polyline != null && polyline.getPoints() != null && !polyline.getPoints().isEmpty()) {
                    for (int i2 = 0; i2 < polyline.getPoints().size(); i2++) {
                        builder.include(polyline.getPoints().get(i2));
                    }
                }
            }
        }
        LatLngBounds build = builder.build();
        if (build == null) {
            C1255a.m10453b(f6172a, "Visibility span is null");
            return;
        }
        this.f6175d.animateMapStatus(MapStatusUpdateFactory.newLatLngBounds(build, this.f6174c.getPaddingLeft(), this.f6174c.getPaddingTop(), this.f6174c.getPaddingRight(), this.f6174c.getPaddingBottom()));
    }

    /* renamed from: c */
    private void m10487c(LatLng latLng) {
        if (!this.f6174c.isShowCarIcon()) {
            C1255a.m10453b(f6172a, "User set not render car marker");
        } else if (latLng == null) {
            C1255a.m10453b(f6172a, "Car point is null");
            m10500a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_CAR_POINT_NULL, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_CAR_POINT_NULL);
        } else {
            BitmapDescriptor carIcon = this.f6174c.getCarIcon();
            if (carIcon == null) {
                C1255a.m10453b(f6172a, "Car icon is null");
                m10500a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_CAR_POINT_ICON_NULL, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_CAR_POINT_ICON_NULL);
                return;
            }
            this.f6179h = (Marker) this.f6175d.addOverlay(new MarkerOptions().position(latLng).icon(carIcon).flat(true).rotate(ColumnText.GLOBAL_SPACE_CHAR_RATIO).zIndex(5).anchor(0.5f, 0.5f));
        }
    }

    /* renamed from: a */
    public void m10501a() {
        f6173b = null;
        Marker marker = this.f6177f;
        if (marker != null) {
            marker.remove();
            this.f6177f = null;
        }
        Marker marker2 = this.f6178g;
        if (marker2 != null) {
            marker2.remove();
            this.f6178g = null;
        }
        Marker marker3 = this.f6179h;
        if (marker3 != null) {
            marker3.remove();
            this.f6179h = null;
        }
        List<Polyline> list = this.f6180i;
        if (list != null && !list.isEmpty()) {
            this.f6180i.clear();
            this.f6180i = null;
        }
        HistoryTraceDisplayOptions historyTraceDisplayOptions = this.f6174c;
        if (historyTraceDisplayOptions != null) {
            historyTraceDisplayOptions.getCarIcon().recycle();
            this.f6174c.getStartPositionIcon().recycle();
            this.f6174c.getEndPositionIcon().recycle();
            this.f6174c.getRouteLineTexture().recycle();
            this.f6174c = null;
        }
        BaiduMap baiduMap = this.f6175d;
        if (baiduMap != null) {
            baiduMap.clear();
        }
        removeCallbacksAndMessages(null);
    }

    /* renamed from: a */
    public void m10495a(HistoryTraceDisplayOptions historyTraceDisplayOptions, BaiduMap baiduMap, int i) {
        this.f6174c = historyTraceDisplayOptions;
        this.f6175d = baiduMap;
        this.f6176e = i;
    }

    /* renamed from: a */
    public void m10494a(OnHistoryTraceListener onHistoryTraceListener) {
        f6173b = onHistoryTraceListener;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message2) {
        String str = f6172a;
        C1255a.m10453b(str, "Render message type = " + message2.what);
        if (message2.what != 4) {
            C1255a.m10453b(f6172a, "Undefine Render message");
        } else {
            m10496a((HistoryTraceData) message2.obj);
        }
    }
}
