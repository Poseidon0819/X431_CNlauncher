package com.baidu.mapapi.map;

import android.graphics.Point;
import android.graphics.PointF;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.C1210e;
import com.baidu.mapsdkplatform.comapi.map.C1236z;
import com.itextpdf.text.pdf.ColumnText;

/* loaded from: classes.dex */
public final class Projection {

    /* renamed from: a */
    private C1210e f5237a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Projection(C1210e c1210e) {
        this.f5237a = c1210e;
    }

    public final LatLng fromScreenLocation(Point point) {
        C1210e c1210e;
        if (point == null || (c1210e = this.f5237a) == null) {
            return null;
        }
        return CoordUtil.mc2ll(c1210e.m10707b(point.x, point.y));
    }

    public final float metersToEquatorPixels(float f) {
        if (f <= ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            return ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        }
        double d = f;
        double m10748J = this.f5237a.m10748J();
        Double.isNaN(d);
        return (float) (d / m10748J);
    }

    public final PointF toOpenGLLocation(LatLng latLng, MapStatus mapStatus) {
        if (latLng == null || mapStatus == null) {
            return null;
        }
        GeoPoint ll2mc = CoordUtil.ll2mc(latLng);
        C1236z c1236z = mapStatus.f5079a;
        return new PointF((float) (ll2mc.getLongitudeE6() - c1236z.f6117d), (float) (ll2mc.getLatitudeE6() - c1236z.f6118e));
    }

    public final PointF toOpenGLNormalization(LatLng latLng, MapStatus mapStatus) {
        if (latLng == null || mapStatus == null) {
            return null;
        }
        GeoPoint ll2mc = CoordUtil.ll2mc(latLng);
        C1236z.C1237a c1237a = mapStatus.f5079a.f6124k;
        double abs = Math.abs(c1237a.f6134b - c1237a.f6133a);
        double abs2 = Math.abs(c1237a.f6135c - c1237a.f6136d);
        double longitudeE6 = ll2mc.getLongitudeE6();
        double d = c1237a.f6133a;
        Double.isNaN(d);
        Double.isNaN(abs);
        double latitudeE6 = ll2mc.getLatitudeE6();
        double d2 = c1237a.f6136d;
        Double.isNaN(d2);
        Double.isNaN(abs2);
        return new PointF((float) ((((longitudeE6 - d) * 2.0d) / abs) - 1.0d), (float) ((((latitudeE6 - d2) * 2.0d) / abs2) - 1.0d));
    }

    public final Point toScreenLocation(LatLng latLng) {
        if (latLng == null || this.f5237a == null) {
            return null;
        }
        return this.f5237a.m10723a(CoordUtil.ll2mc(latLng));
    }
}
