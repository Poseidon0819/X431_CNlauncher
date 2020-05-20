package com.baidu.mapapi.map;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.C1236z;

/* loaded from: classes.dex */
public final class MapStatus implements Parcelable {
    public static final Parcelable.Creator<MapStatus> CREATOR = new Parcelable.Creator<MapStatus>() { // from class: com.baidu.mapapi.map.MapStatus.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final MapStatus createFromParcel(Parcel parcel) {
            return new MapStatus(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final MapStatus[] newArray(int i) {
            return new MapStatus[i];
        }
    };

    /* renamed from: a */
    C1236z f5079a;

    /* renamed from: b */
    private double f5080b;
    public final LatLngBounds bound;

    /* renamed from: c */
    private double f5081c;
    public final float overlook;
    public final float rotate;
    public final LatLng target;
    public final Point targetScreen;
    public WinRound winRound;
    public final float zoom;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a */
        private float f5082a;

        /* renamed from: b */
        private LatLng f5083b;

        /* renamed from: c */
        private float f5084c;

        /* renamed from: d */
        private float f5085d;

        /* renamed from: e */
        private Point f5086e;

        /* renamed from: f */
        private LatLngBounds f5087f;

        /* renamed from: g */
        private double f5088g;

        /* renamed from: h */
        private double f5089h;

        /* renamed from: i */
        private final float f5090i;

        public Builder() {
            this.f5082a = -2.1474836E9f;
            this.f5083b = null;
            this.f5084c = -2.1474836E9f;
            this.f5085d = -2.1474836E9f;
            this.f5086e = null;
            this.f5087f = null;
            this.f5088g = 0.0d;
            this.f5089h = 0.0d;
            this.f5090i = 15.0f;
        }

        public Builder(MapStatus mapStatus) {
            this.f5082a = -2.1474836E9f;
            this.f5083b = null;
            this.f5084c = -2.1474836E9f;
            this.f5085d = -2.1474836E9f;
            this.f5086e = null;
            this.f5087f = null;
            this.f5088g = 0.0d;
            this.f5089h = 0.0d;
            this.f5090i = 15.0f;
            this.f5082a = mapStatus.rotate;
            this.f5083b = mapStatus.target;
            this.f5084c = mapStatus.overlook;
            this.f5085d = mapStatus.zoom;
            this.f5086e = mapStatus.targetScreen;
            this.f5088g = mapStatus.m11183a();
            this.f5089h = mapStatus.m11181b();
        }

        /* renamed from: a */
        private float m11176a(float f) {
            if (15.0f == f) {
                return 15.5f;
            }
            return f;
        }

        public final MapStatus build() {
            return new MapStatus(this.f5082a, this.f5083b, this.f5084c, this.f5085d, this.f5086e, this.f5087f);
        }

        public final Builder overlook(float f) {
            this.f5084c = f;
            return this;
        }

        public final Builder rotate(float f) {
            this.f5082a = f;
            return this;
        }

        public final Builder target(LatLng latLng) {
            this.f5083b = latLng;
            return this;
        }

        public final Builder targetScreen(Point point) {
            this.f5086e = point;
            return this;
        }

        public final Builder zoom(float f) {
            this.f5085d = m11176a(f);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MapStatus(float f, LatLng latLng, float f2, float f3, Point point, double d, double d2, LatLngBounds latLngBounds) {
        this.rotate = f;
        this.target = latLng;
        this.overlook = f2;
        this.zoom = f3;
        this.targetScreen = point;
        this.f5080b = d;
        this.f5081c = d2;
        this.bound = latLngBounds;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MapStatus(float f, LatLng latLng, float f2, float f3, Point point, LatLngBounds latLngBounds) {
        this.rotate = f;
        this.target = latLng;
        this.overlook = f2;
        this.zoom = f3;
        this.targetScreen = point;
        LatLng latLng2 = this.target;
        if (latLng2 != null) {
            this.f5080b = CoordUtil.ll2mc(latLng2).getLongitudeE6();
            this.f5081c = CoordUtil.ll2mc(this.target).getLatitudeE6();
        }
        this.bound = latLngBounds;
    }

    MapStatus(float f, LatLng latLng, float f2, float f3, Point point, C1236z c1236z, double d, double d2, LatLngBounds latLngBounds, WinRound winRound) {
        this.rotate = f;
        this.target = latLng;
        this.overlook = f2;
        this.zoom = f3;
        this.targetScreen = point;
        this.f5079a = c1236z;
        this.f5080b = d;
        this.f5081c = d2;
        this.bound = latLngBounds;
        this.winRound = winRound;
    }

    protected MapStatus(Parcel parcel) {
        this.rotate = parcel.readFloat();
        this.target = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.overlook = parcel.readFloat();
        this.zoom = parcel.readFloat();
        this.targetScreen = (Point) parcel.readParcelable(Point.class.getClassLoader());
        this.bound = (LatLngBounds) parcel.readParcelable(LatLngBounds.class.getClassLoader());
        this.f5080b = parcel.readDouble();
        this.f5081c = parcel.readDouble();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static MapStatus m11182a(C1236z c1236z) {
        if (c1236z == null) {
            return null;
        }
        float f = c1236z.f6115b;
        double d = c1236z.f6118e;
        double d2 = c1236z.f6117d;
        LatLng mc2ll = CoordUtil.mc2ll(new GeoPoint(d, d2));
        float f2 = c1236z.f6116c;
        float f3 = c1236z.f6114a;
        Point point = new Point(c1236z.f6119f, c1236z.f6120g);
        LatLng mc2ll2 = CoordUtil.mc2ll(new GeoPoint(c1236z.f6124k.f6137e.f5414y, c1236z.f6124k.f6137e.f5413x));
        LatLng mc2ll3 = CoordUtil.mc2ll(new GeoPoint(c1236z.f6124k.f6138f.f5414y, c1236z.f6124k.f6138f.f5413x));
        LatLng mc2ll4 = CoordUtil.mc2ll(new GeoPoint(c1236z.f6124k.f6140h.f5414y, c1236z.f6124k.f6140h.f5413x));
        LatLng mc2ll5 = CoordUtil.mc2ll(new GeoPoint(c1236z.f6124k.f6139g.f5414y, c1236z.f6124k.f6139g.f5413x));
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(mc2ll2);
        builder.include(mc2ll3);
        builder.include(mc2ll4);
        builder.include(mc2ll5);
        return new MapStatus(f, mc2ll, f2, f3, point, c1236z, d2, d, builder.build(), c1236z.f6123j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final double m11183a() {
        return this.f5080b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final double m11181b() {
        return this.f5081c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final C1236z m11180b(C1236z c1236z) {
        if (c1236z == null) {
            return null;
        }
        float f = this.rotate;
        if (f != -2.1474836E9f) {
            c1236z.f6115b = (int) f;
        }
        float f2 = this.zoom;
        if (f2 != -2.1474836E9f) {
            c1236z.f6114a = f2;
        }
        float f3 = this.overlook;
        if (f3 != -2.1474836E9f) {
            c1236z.f6116c = (int) f3;
        }
        LatLng latLng = this.target;
        if (latLng != null) {
            CoordUtil.ll2mc(latLng);
            c1236z.f6117d = this.f5080b;
            c1236z.f6118e = this.f5081c;
        }
        Point point = this.targetScreen;
        if (point != null) {
            c1236z.f6119f = point.x;
            c1236z.f6120g = this.targetScreen.y;
        }
        return c1236z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public final C1236z m11179c() {
        return m11180b(new C1236z());
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.target != null) {
            sb.append("target lat: " + this.target.latitude + "\n");
            sb.append("target lng: " + this.target.longitude + "\n");
        }
        if (this.targetScreen != null) {
            sb.append("target screen x: " + this.targetScreen.x + "\n");
            sb.append("target screen y: " + this.targetScreen.y + "\n");
        }
        sb.append("zoom: " + this.zoom + "\n");
        sb.append("rotate: " + this.rotate + "\n");
        sb.append("overlook: " + this.overlook + "\n");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.rotate);
        parcel.writeParcelable(this.target, i);
        parcel.writeFloat(this.overlook);
        parcel.writeFloat(this.zoom);
        parcel.writeParcelable(this.targetScreen, i);
        parcel.writeParcelable(this.bound, i);
        parcel.writeDouble(this.f5080b);
        parcel.writeDouble(this.f5081c);
    }
}
