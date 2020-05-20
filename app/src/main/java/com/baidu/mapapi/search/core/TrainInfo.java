package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class TrainInfo extends TransitBaseInfo {
    public static final Parcelable.Creator<TrainInfo> CREATOR = new Parcelable.Creator<TrainInfo>() { // from class: com.baidu.mapapi.search.core.TrainInfo.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final TrainInfo createFromParcel(Parcel parcel) {
            return new TrainInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final TrainInfo[] newArray(int i) {
            return new TrainInfo[i];
        }
    };

    /* renamed from: a */
    private double f5471a;

    /* renamed from: b */
    private String f5472b;

    public TrainInfo() {
    }

    protected TrainInfo(Parcel parcel) {
        super(parcel);
        this.f5471a = parcel.readDouble();
        this.f5472b = parcel.readString();
    }

    /* renamed from: a */
    public void m11033a(double d) {
        this.f5471a = d;
    }

    /* renamed from: a */
    public void m11032a(String str) {
        this.f5472b = str;
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeDouble(this.f5471a);
        parcel.writeString(this.f5472b);
    }
}
