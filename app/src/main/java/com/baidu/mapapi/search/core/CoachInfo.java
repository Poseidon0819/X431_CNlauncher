package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class CoachInfo extends TransitBaseInfo {
    public static final Parcelable.Creator<CoachInfo> CREATOR = new Parcelable.Creator<CoachInfo>() { // from class: com.baidu.mapapi.search.core.CoachInfo.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final CoachInfo createFromParcel(Parcel parcel) {
            return new CoachInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final CoachInfo[] newArray(int i) {
            return new CoachInfo[i];
        }
    };

    /* renamed from: a */
    private double f5439a;

    /* renamed from: b */
    private String f5440b;

    /* renamed from: c */
    private String f5441c;

    /* renamed from: d */
    private String f5442d;

    public CoachInfo() {
    }

    protected CoachInfo(Parcel parcel) {
        super(parcel);
        this.f5439a = parcel.readDouble();
        this.f5440b = parcel.readString();
        this.f5441c = parcel.readString();
        this.f5442d = parcel.readString();
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBooking() {
        return this.f5440b;
    }

    public double getPrice() {
        return this.f5439a;
    }

    public String getProviderName() {
        return this.f5441c;
    }

    public String getProviderUrl() {
        return this.f5442d;
    }

    public void setBooking(String str) {
        this.f5440b = str;
    }

    public void setPrice(double d) {
        this.f5439a = d;
    }

    public void setProviderName(String str) {
        this.f5441c = str;
    }

    public void setProviderUrl(String str) {
        this.f5442d = str;
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeDouble(this.f5439a);
        parcel.writeString(this.f5440b);
        parcel.writeString(this.f5441c);
        parcel.writeString(this.f5442d);
    }
}
