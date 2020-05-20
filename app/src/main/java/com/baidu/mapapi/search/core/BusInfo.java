package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class BusInfo extends TransitBaseInfo {
    public static final Parcelable.Creator<BusInfo> CREATOR = new Parcelable.Creator<BusInfo>() { // from class: com.baidu.mapapi.search.core.BusInfo.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final BusInfo createFromParcel(Parcel parcel) {
            return new BusInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final BusInfo[] newArray(int i) {
            return new BusInfo[i];
        }
    };

    /* renamed from: a */
    private int f5437a;

    /* renamed from: b */
    private int f5438b;

    public BusInfo() {
    }

    protected BusInfo(Parcel parcel) {
        super(parcel);
        this.f5437a = parcel.readInt();
        this.f5438b = parcel.readInt();
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getStopNum() {
        return this.f5438b;
    }

    public int getType() {
        return this.f5437a;
    }

    public void setStopNum(int i) {
        this.f5438b = i;
    }

    public void setType(int i) {
        this.f5437a = i;
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f5437a);
        parcel.writeInt(this.f5438b);
    }
}
