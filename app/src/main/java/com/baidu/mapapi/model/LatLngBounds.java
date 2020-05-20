package com.baidu.mapapi.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class LatLngBounds implements Parcelable {
    public static final Parcelable.Creator<LatLngBounds> CREATOR = new Parcelable.Creator<LatLngBounds>() { // from class: com.baidu.mapapi.model.LatLngBounds.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final LatLngBounds createFromParcel(Parcel parcel) {
            return new LatLngBounds(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final LatLngBounds[] newArray(int i) {
            return new LatLngBounds[i];
        }
    };
    public final LatLng northeast;
    public final LatLng southwest;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a */
        private double f5405a;

        /* renamed from: b */
        private double f5406b;

        /* renamed from: c */
        private double f5407c;

        /* renamed from: d */
        private double f5408d;

        /* renamed from: e */
        private boolean f5409e = true;

        public final LatLngBounds build() {
            return new LatLngBounds(new LatLng(this.f5406b, this.f5408d), new LatLng(this.f5405a, this.f5407c));
        }

        public final Builder include(LatLng latLng) {
            if (latLng == null) {
                return this;
            }
            if (this.f5409e) {
                this.f5409e = false;
                double d = latLng.latitude;
                this.f5405a = d;
                this.f5406b = d;
                double d2 = latLng.longitude;
                this.f5407c = d2;
                this.f5408d = d2;
            }
            double d3 = latLng.latitude;
            double d4 = latLng.longitude;
            if (d3 < this.f5405a) {
                this.f5405a = d3;
            }
            if (d3 > this.f5406b) {
                this.f5406b = d3;
            }
            if (d4 < this.f5407c) {
                this.f5407c = d4;
            }
            if (d4 > this.f5408d) {
                this.f5408d = d4;
            }
            return this;
        }
    }

    protected LatLngBounds(Parcel parcel) {
        this.northeast = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.southwest = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
    }

    LatLngBounds(LatLng latLng, LatLng latLng2) {
        this.northeast = latLng;
        this.southwest = latLng2;
    }

    public final boolean contains(LatLng latLng) {
        if (latLng == null) {
            return false;
        }
        double d = this.southwest.latitude;
        double d2 = this.northeast.latitude;
        double d3 = this.southwest.longitude;
        double d4 = this.northeast.longitude;
        double d5 = latLng.latitude;
        double d6 = latLng.longitude;
        return d5 >= d && d5 <= d2 && d6 >= d3 && d6 <= d4;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final LatLng getCenter() {
        return new LatLng(((this.northeast.latitude - this.southwest.latitude) / 2.0d) + this.southwest.latitude, ((this.northeast.longitude - this.southwest.longitude) / 2.0d) + this.southwest.longitude);
    }

    public final String toString() {
        return "southwest: " + this.southwest.latitude + ", " + this.southwest.longitude + "\nnortheast: " + this.northeast.latitude + ", " + this.northeast.longitude;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.northeast, i);
        parcel.writeParcelable(this.southwest, i);
    }
}
