package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class CityInfo implements Parcelable {
    public static final Parcelable.Creator<CityInfo> CREATOR = new Parcelable.Creator<CityInfo>() { // from class: com.baidu.mapapi.search.core.CityInfo.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final CityInfo createFromParcel(Parcel parcel) {
            return new CityInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final CityInfo[] newArray(int i) {
            return new CityInfo[i];
        }
    };
    public String city;
    public int num;

    public CityInfo() {
    }

    protected CityInfo(Parcel parcel) {
        this.city = parcel.readString();
        this.num = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.city);
        parcel.writeInt(this.num);
    }
}
