package com.baidu.mapapi.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class LatLng implements Parcelable {
    public static final Parcelable.Creator<LatLng> CREATOR = new Parcelable.Creator<LatLng>() { // from class: com.baidu.mapapi.model.LatLng.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final LatLng createFromParcel(Parcel parcel) {
            return new LatLng(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final LatLng[] newArray(int i) {
            return new LatLng[i];
        }
    };

    /* renamed from: a */
    private static final String f5404a = "LatLng";
    public final double latitude;
    public final double latitudeE6;
    public final double longitude;
    public final double longitudeE6;

    public LatLng(double d, double d2) {
        if (Double.isNaN(d) || Double.isNaN(d2) || Double.isInfinite(d) || Double.isInfinite(d2)) {
            this.latitudeE6 = 0.0d;
            this.longitudeE6 = 0.0d;
            this.latitude = 0.0d;
            this.longitude = 0.0d;
            return;
        }
        double d3 = d * 1000000.0d;
        double d4 = d2 * 1000000.0d;
        this.latitudeE6 = d3;
        this.longitudeE6 = d4;
        this.latitude = d3 / 1000000.0d;
        this.longitude = d4 / 1000000.0d;
    }

    protected LatLng(Parcel parcel) {
        this.latitude = parcel.readDouble();
        this.longitude = parcel.readDouble();
        this.latitudeE6 = parcel.readDouble();
        this.longitudeE6 = parcel.readDouble();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return ((new String("latitude: ") + this.latitude) + ", longitude: ") + this.longitude;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.latitude);
        parcel.writeDouble(this.longitude);
        parcel.writeDouble(this.latitudeE6);
        parcel.writeDouble(this.longitudeE6);
    }
}
