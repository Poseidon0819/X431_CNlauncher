package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class PlaneInfo extends TransitBaseInfo {
    public static final Parcelable.Creator<PlaneInfo> CREATOR = new Parcelable.Creator<PlaneInfo>() { // from class: com.baidu.mapapi.search.core.PlaneInfo.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final PlaneInfo createFromParcel(Parcel parcel) {
            return new PlaneInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final PlaneInfo[] newArray(int i) {
            return new PlaneInfo[i];
        }
    };

    /* renamed from: a */
    private double f5443a;

    /* renamed from: b */
    private String f5444b;

    /* renamed from: c */
    private double f5445c;

    /* renamed from: d */
    private String f5446d;

    public PlaneInfo() {
    }

    protected PlaneInfo(Parcel parcel) {
        super(parcel);
        this.f5443a = parcel.readDouble();
        this.f5444b = parcel.readString();
        this.f5445c = parcel.readDouble();
        this.f5446d = parcel.readString();
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAirlines() {
        return this.f5444b;
    }

    public String getBooking() {
        return this.f5446d;
    }

    public double getDiscount() {
        return this.f5443a;
    }

    public double getPrice() {
        return this.f5445c;
    }

    public void setAirlines(String str) {
        this.f5444b = str;
    }

    public void setBooking(String str) {
        this.f5446d = str;
    }

    public void setDiscount(double d) {
        this.f5443a = d;
    }

    public void setPrice(double d) {
        this.f5445c = d;
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeDouble(this.f5443a);
        parcel.writeString(this.f5444b);
        parcel.writeDouble(this.f5445c);
        parcel.writeString(this.f5446d);
    }
}
