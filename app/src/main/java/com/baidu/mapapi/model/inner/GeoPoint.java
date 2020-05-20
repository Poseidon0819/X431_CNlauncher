package com.baidu.mapapi.model.inner;

/* loaded from: classes.dex */
public class GeoPoint {

    /* renamed from: a */
    private double f5411a;

    /* renamed from: b */
    private double f5412b;

    public GeoPoint(double d, double d2) {
        this.f5411a = d;
        this.f5412b = d2;
    }

    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            GeoPoint geoPoint = (GeoPoint) obj;
            return this.f5411a == geoPoint.f5411a && this.f5412b == geoPoint.f5412b;
        }
        return false;
    }

    public double getLatitudeE6() {
        return this.f5411a;
    }

    public double getLongitudeE6() {
        return this.f5412b;
    }

    public void setLatitudeE6(double d) {
        this.f5411a = d;
    }

    public void setLongitudeE6(double d) {
        this.f5412b = d;
    }

    public String toString() {
        return "GeoPoint: Latitude: " + this.f5411a + ", Longitude: " + this.f5412b;
    }
}
