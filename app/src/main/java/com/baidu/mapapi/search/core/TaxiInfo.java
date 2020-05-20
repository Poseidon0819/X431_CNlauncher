package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class TaxiInfo implements Parcelable {
    public static final Parcelable.Creator<TaxiInfo> CREATOR = new Parcelable.Creator<TaxiInfo>() { // from class: com.baidu.mapapi.search.core.TaxiInfo.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final TaxiInfo createFromParcel(Parcel parcel) {
            return new TaxiInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final TaxiInfo[] newArray(int i) {
            return new TaxiInfo[i];
        }
    };

    /* renamed from: a */
    private float f5465a;

    /* renamed from: b */
    private String f5466b;

    /* renamed from: c */
    private int f5467c;

    /* renamed from: d */
    private int f5468d;

    /* renamed from: e */
    private float f5469e;

    /* renamed from: f */
    private float f5470f;

    public TaxiInfo() {
    }

    TaxiInfo(Parcel parcel) {
        this.f5465a = parcel.readFloat();
        this.f5466b = parcel.readString();
        this.f5467c = parcel.readInt();
        this.f5468d = parcel.readInt();
        this.f5469e = parcel.readFloat();
        this.f5470f = parcel.readFloat();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDesc() {
        return this.f5466b;
    }

    public int getDistance() {
        return this.f5467c;
    }

    public int getDuration() {
        return this.f5468d;
    }

    public float getPerKMPrice() {
        return this.f5469e;
    }

    public float getStartPrice() {
        return this.f5470f;
    }

    public float getTotalPrice() {
        return this.f5465a;
    }

    public void setDesc(String str) {
        this.f5466b = str;
    }

    public void setDistance(int i) {
        this.f5467c = i;
    }

    public void setDuration(int i) {
        this.f5468d = i;
    }

    public void setPerKMPrice(float f) {
        this.f5469e = f;
    }

    public void setStartPrice(float f) {
        this.f5470f = f;
    }

    public void setTotalPrice(float f) {
        this.f5465a = f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.f5465a);
        parcel.writeString(this.f5466b);
        parcel.writeInt(this.f5467c);
        parcel.writeInt(this.f5468d);
        parcel.writeFloat(this.f5469e);
        parcel.writeFloat(this.f5470f);
    }
}
