package com.cnlaunch.gmap.map.p150b;

import com.cnlaunch.gmap.map.logic.p153a.LcLatlng;
import com.google.android.gms.maps.model.LatLng;

/* renamed from: com.cnlaunch.gmap.map.b.f */
/* loaded from: classes.dex */
public final class BaseMapTools {
    /* renamed from: d */
    private static boolean m9301d(double d, double d2) {
        return d2 < 72.004d || d2 > 137.8347d || d < 0.8293d || d > 55.8271d;
    }

    /* renamed from: a */
    public static LatLng m9304a(boolean z, LcLatlng lcLatlng) {
        LatLng latLng = new LatLng(lcLatlng.latitude, lcLatlng.longitude);
        if (z && m9301d(latLng.f19310c, latLng.f19311d)) {
            m9305a(latLng.f19310c, latLng.f19311d);
        }
        return new LatLng(lcLatlng.latitude, lcLatlng.longitude);
    }

    /* renamed from: a */
    private static LatLng m9305a(double d, double d2) {
        if (m9301d(d, d2)) {
            return new LatLng(d, d2);
        }
        double d3 = d2 - 105.0d;
        double d4 = d - 35.0d;
        double m9303b = m9303b(d3, d4);
        double m9302c = m9302c(d3, d4);
        double d5 = (d / 180.0d) * 3.141592653589793d;
        double sin = Math.sin(d5);
        double d6 = 1.0d - ((0.006693421622965943d * sin) * sin);
        double sqrt = Math.sqrt(d6);
        return new LatLng(d + ((m9303b * 180.0d) / ((6335552.717000426d / (d6 * sqrt)) * 3.141592653589793d)), d2 + ((m9302c * 180.0d) / (((6378245.0d / sqrt) * Math.cos(d5)) * 3.141592653589793d)));
    }

    /* renamed from: b */
    private static double m9303b(double d, double d2) {
        double d3 = d * 2.0d;
        double d4 = d2 * 3.141592653589793d;
        return (-100.0d) + d3 + (d2 * 3.0d) + (d2 * 0.2d * d2) + (0.1d * d * d2) + (Math.sqrt(Math.abs(d)) * 0.2d) + ((((Math.sin((6.0d * d) * 3.141592653589793d) * 20.0d) + (Math.sin(d3 * 3.141592653589793d) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(d4) * 20.0d) + (Math.sin((d2 / 3.0d) * 3.141592653589793d) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d2 / 12.0d) * 3.141592653589793d) * 160.0d) + (Math.sin(d4 / 30.0d) * 320.0d)) * 2.0d) / 3.0d);
    }

    /* renamed from: c */
    private static double m9302c(double d, double d2) {
        double d3 = d * 0.1d;
        return d + 300.0d + (d2 * 2.0d) + (d3 * d) + (d3 * d2) + (Math.sqrt(Math.abs(d)) * 0.1d) + ((((Math.sin((6.0d * d) * 3.141592653589793d) * 20.0d) + (Math.sin((d * 2.0d) * 3.141592653589793d) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(d * 3.141592653589793d) * 20.0d) + (Math.sin((d / 3.0d) * 3.141592653589793d) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d / 12.0d) * 3.141592653589793d) * 150.0d) + (Math.sin((d / 30.0d) * 3.141592653589793d) * 300.0d)) * 2.0d) / 3.0d);
    }
}