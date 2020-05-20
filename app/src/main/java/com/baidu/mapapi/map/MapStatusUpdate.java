package com.baidu.mapapi.map;

import android.graphics.Point;
import android.util.Log;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.C1210e;

/* loaded from: classes.dex */
public final class MapStatusUpdate {

    /* renamed from: p */
    private static final String f5091p = "MapStatusUpdate";

    /* renamed from: a */
    int f5092a;

    /* renamed from: b */
    MapStatus f5093b;

    /* renamed from: c */
    LatLng f5094c;

    /* renamed from: d */
    LatLngBounds f5095d;

    /* renamed from: e */
    int f5096e;

    /* renamed from: f */
    int f5097f;

    /* renamed from: g */
    float f5098g;

    /* renamed from: h */
    int f5099h;

    /* renamed from: i */
    int f5100i;

    /* renamed from: j */
    float f5101j;

    /* renamed from: k */
    Point f5102k;

    /* renamed from: l */
    int f5103l = 0;

    /* renamed from: m */
    int f5104m = 0;

    /* renamed from: n */
    int f5105n = 0;

    /* renamed from: o */
    int f5106o = 0;

    MapStatusUpdate() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MapStatusUpdate(int i) {
        this.f5092a = i;
    }

    /* renamed from: a */
    private float m11174a(LatLngBounds latLngBounds, C1210e c1210e, int i, int i2) {
        GeoPoint ll2mc = CoordUtil.ll2mc(latLngBounds.southwest);
        GeoPoint ll2mc2 = CoordUtil.ll2mc(latLngBounds.northeast);
        Point m10723a = c1210e.m10723a(ll2mc);
        Point m10723a2 = c1210e.m10723a(ll2mc2);
        Point point = new Point(m10723a.x - Math.abs(this.f5103l), m10723a.y + Math.abs(this.f5106o));
        Point point2 = new Point(m10723a2.x + Math.abs(this.f5105n), m10723a2.y - Math.abs(this.f5104m));
        GeoPoint m10707b = c1210e.m10707b(point.x, point.y);
        GeoPoint m10707b2 = c1210e.m10707b(point2.x, point2.y);
        return c1210e.m10732a((int) m10707b.getLongitudeE6(), (int) m10707b.getLatitudeE6(), (int) m10707b2.getLongitudeE6(), (int) m10707b2.getLatitudeE6(), i, i2);
    }

    /* renamed from: a */
    private boolean m11175a(LatLngBounds latLngBounds, C1210e c1210e) {
        if (c1210e.f6017q == null) {
            return true;
        }
        return (latLngBounds.southwest.latitude == c1210e.f6017q.southwest.latitude && latLngBounds.southwest.longitude == c1210e.f6017q.southwest.longitude && latLngBounds.northeast.latitude == c1210e.f6017q.northeast.latitude && latLngBounds.northeast.longitude == c1210e.f6017q.northeast.longitude) ? false : true;
    }

    /* renamed from: b */
    private LatLng m11172b(LatLngBounds latLngBounds, C1210e c1210e) {
        if (latLngBounds == null || c1210e == null) {
            return null;
        }
        Point m10723a = c1210e.m10723a(CoordUtil.ll2mc(latLngBounds.getCenter()));
        int i = this.f5103l;
        int i2 = this.f5105n;
        int i3 = i > i2 ? m10723a.x - (this.f5103l - this.f5105n) : i < i2 ? m10723a.x + (this.f5105n - this.f5103l) : m10723a.x;
        int i4 = this.f5104m;
        int i5 = this.f5106o;
        GeoPoint m10707b = c1210e.m10707b(i3, i4 < i5 ? m10723a.y - (this.f5104m - this.f5106o) : i4 > i5 ? m10723a.y + (this.f5106o - this.f5104m) : m10723a.y);
        if (m10707b == null) {
            Log.e(f5091p, "New center geopoint is null");
            return null;
        }
        return CoordUtil.mc2ll(m10707b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final MapStatus m11173a(C1210e c1210e, MapStatus mapStatus) {
        if (c1210e == null || mapStatus == null) {
            return null;
        }
        switch (this.f5092a) {
            case 1:
                return this.f5093b;
            case 2:
                return new MapStatus(mapStatus.rotate, this.f5094c, mapStatus.overlook, mapStatus.zoom, mapStatus.targetScreen, null);
            case 3:
                LatLngBounds latLngBounds = this.f5095d;
                if (latLngBounds == null) {
                    return null;
                }
                GeoPoint ll2mc = CoordUtil.ll2mc(latLngBounds.southwest);
                GeoPoint ll2mc2 = CoordUtil.ll2mc(this.f5095d.northeast);
                float m10732a = c1210e.m10732a((int) ll2mc.getLongitudeE6(), (int) ll2mc2.getLatitudeE6(), (int) ll2mc2.getLongitudeE6(), (int) ll2mc.getLatitudeE6(), mapStatus.f5079a.f6123j.right - mapStatus.f5079a.f6123j.left, mapStatus.f5079a.f6123j.bottom - mapStatus.f5079a.f6123j.top);
                return new MapStatus(mapStatus.rotate, this.f5095d.getCenter(), mapStatus.overlook, m10732a, mapStatus.targetScreen, null);
            case 4:
                return new MapStatus(mapStatus.rotate, this.f5094c, mapStatus.overlook, this.f5098g, mapStatus.targetScreen, null);
            case 5:
                GeoPoint m10707b = c1210e.m10707b((c1210e.m10751G() / 2) + this.f5099h, (c1210e.m10750H() / 2) + this.f5100i);
                return new MapStatus(mapStatus.rotate, CoordUtil.mc2ll(m10707b), mapStatus.overlook, mapStatus.zoom, mapStatus.targetScreen, m10707b.getLongitudeE6(), m10707b.getLatitudeE6(), null);
            case 6:
                return new MapStatus(mapStatus.rotate, mapStatus.target, mapStatus.overlook, mapStatus.zoom + this.f5101j, mapStatus.targetScreen, mapStatus.m11183a(), mapStatus.m11181b(), null);
            case 7:
                LatLng mc2ll = CoordUtil.mc2ll(c1210e.m10707b(this.f5102k.x, this.f5102k.y));
                return new MapStatus(mapStatus.rotate, mc2ll, mapStatus.overlook, this.f5101j + mapStatus.zoom, this.f5102k, null);
            case 8:
                return new MapStatus(mapStatus.rotate, mapStatus.target, mapStatus.overlook, this.f5098g, mapStatus.targetScreen, mapStatus.m11183a(), mapStatus.m11181b(), null);
            case 9:
                LatLngBounds latLngBounds2 = this.f5095d;
                if (latLngBounds2 == null) {
                    return null;
                }
                GeoPoint ll2mc3 = CoordUtil.ll2mc(latLngBounds2.southwest);
                GeoPoint ll2mc4 = CoordUtil.ll2mc(this.f5095d.northeast);
                float m10732a2 = c1210e.m10732a((int) ll2mc3.getLongitudeE6(), (int) ll2mc4.getLatitudeE6(), (int) ll2mc4.getLongitudeE6(), (int) ll2mc3.getLatitudeE6(), this.f5096e, this.f5097f);
                return new MapStatus(mapStatus.rotate, this.f5095d.getCenter(), mapStatus.overlook, m10732a2, mapStatus.targetScreen, null);
            case 10:
                if (this.f5095d == null) {
                    return null;
                }
                int m10751G = (c1210e.m10751G() - this.f5103l) - this.f5105n;
                if (m10751G < 0) {
                    m10751G = c1210e.m10751G();
                    Log.e(f5091p, "Bound paddingLeft or paddingRight too larger, please check");
                }
                int m10750H = (c1210e.m10750H() - this.f5104m) - this.f5106o;
                if (m10750H < 0) {
                    m10750H = c1210e.m10750H();
                    Log.e(f5091p, "Bound paddingTop or paddingBottom too larger, please check");
                }
                LatLng m11172b = m11172b(this.f5095d, c1210e);
                if (m11172b == null) {
                    Log.e(f5091p, "Bound center error");
                    return null;
                }
                float m11174a = m11174a(this.f5095d, c1210e, m10751G, m10750H);
                if (m11175a(this.f5095d, c1210e)) {
                    MapStatus mapStatus2 = new MapStatus(mapStatus.rotate, m11172b, mapStatus.overlook, m11174a, mapStatus.targetScreen, null);
                    c1210e.f6018r = mapStatus2;
                    c1210e.f6017q = this.f5095d;
                    return mapStatus2;
                }
                return c1210e.f6018r;
            default:
                return null;
        }
    }
}
