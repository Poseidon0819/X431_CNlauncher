package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class VehicleInfo implements Parcelable {
    public static final Parcelable.Creator<VehicleInfo> CREATOR = new Parcelable.Creator<VehicleInfo>() { // from class: com.baidu.mapapi.search.core.VehicleInfo.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final VehicleInfo createFromParcel(Parcel parcel) {
            return new VehicleInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final VehicleInfo[] newArray(int i) {
            return new VehicleInfo[i];
        }
    };

    /* renamed from: a */
    private String f5482a;

    /* renamed from: b */
    private int f5483b;

    /* renamed from: c */
    private String f5484c;

    /* renamed from: d */
    private int f5485d;

    /* renamed from: e */
    private int f5486e;

    public VehicleInfo() {
    }

    protected VehicleInfo(Parcel parcel) {
        this.f5482a = parcel.readString();
        this.f5483b = parcel.readInt();
        this.f5484c = parcel.readString();
        this.f5485d = parcel.readInt();
        this.f5486e = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getPassStationNum() {
        return this.f5483b;
    }

    public String getTitle() {
        return this.f5484c;
    }

    public int getTotalPrice() {
        return this.f5486e;
    }

    public String getUid() {
        return this.f5482a;
    }

    public int getZonePrice() {
        return this.f5485d;
    }

    public void setPassStationNum(int i) {
        this.f5483b = i;
    }

    public void setTitle(String str) {
        this.f5484c = str;
    }

    public void setTotalPrice(int i) {
        this.f5486e = i;
    }

    public void setUid(String str) {
        this.f5482a = str;
    }

    public void setZonePrice(int i) {
        this.f5485d = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5482a);
        parcel.writeInt(this.f5483b);
        parcel.writeString(this.f5484c);
        parcel.writeInt(this.f5485d);
        parcel.writeInt(this.f5486e);
    }
}
