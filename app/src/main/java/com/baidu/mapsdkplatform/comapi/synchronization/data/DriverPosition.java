package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;

/* loaded from: classes.dex */
public final class DriverPosition implements Parcelable {
    public static final Parcelable.Creator<DriverPosition> CREATOR = new Parcelable.Creator<DriverPosition>() { // from class: com.baidu.mapsdkplatform.comapi.synchronization.data.DriverPosition.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final DriverPosition createFromParcel(Parcel parcel) {
            return new DriverPosition(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final DriverPosition[] newArray(int i) {
            return new DriverPosition[i];
        }
    };

    /* renamed from: a */
    private String f6210a;

    /* renamed from: b */
    private LatLng f6211b;

    /* renamed from: c */
    private double f6212c;

    /* renamed from: d */
    private double f6213d;

    /* renamed from: e */
    private int f6214e;

    public DriverPosition() {
        this.f6210a = null;
        this.f6211b = null;
        this.f6212c = 0.0d;
        this.f6213d = 0.0d;
        this.f6214e = 0;
    }

    protected DriverPosition(Parcel parcel) {
        this.f6210a = parcel.readString();
        this.f6211b = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f6212c = parcel.readDouble();
        this.f6213d = parcel.readDouble();
        this.f6214e = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final double getAngle() {
        return this.f6212c;
    }

    public final int getOrderStateInPosition() {
        return this.f6214e;
    }

    public final LatLng getPoint() {
        return this.f6211b;
    }

    public final double getSpeed() {
        return this.f6213d;
    }

    public final String getTimeStamp() {
        return this.f6210a;
    }

    public final void setAngle(double d) {
        if (d < 0.0d) {
            this.f6212c = 0.0d;
        } else if (d >= 360.0d) {
            this.f6212c = 360.0d;
        } else {
            this.f6212c = d;
        }
    }

    public final void setOrderStateInPosition(int i) {
        this.f6214e = i;
    }

    public final void setPoint(LatLng latLng) {
        this.f6211b = latLng;
    }

    public final void setSpeed(double d) {
        this.f6213d = d;
    }

    public final void setTimeStamp(String str) {
        this.f6210a = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6210a);
        parcel.writeParcelable(this.f6211b, i);
        parcel.writeDouble(this.f6212c);
        parcel.writeDouble(this.f6213d);
        parcel.writeInt(this.f6214e);
    }
}
