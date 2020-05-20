package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class TransitBaseInfo implements Parcelable {
    public static final Parcelable.Creator<TransitBaseInfo> CREATOR = new Parcelable.Creator<TransitBaseInfo>() { // from class: com.baidu.mapapi.search.core.TransitBaseInfo.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final TransitBaseInfo createFromParcel(Parcel parcel) {
            return new TransitBaseInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final TransitBaseInfo[] newArray(int i) {
            return new TransitBaseInfo[i];
        }
    };

    /* renamed from: a */
    private String f5473a;

    /* renamed from: b */
    private String f5474b;

    /* renamed from: c */
    private String f5475c;

    /* renamed from: d */
    private String f5476d;

    /* renamed from: e */
    private String f5477e;

    public TransitBaseInfo() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TransitBaseInfo(Parcel parcel) {
        this.f5473a = parcel.readString();
        this.f5474b = parcel.readString();
        this.f5475c = parcel.readString();
        this.f5476d = parcel.readString();
        this.f5477e = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getArriveStation() {
        return this.f5475c;
    }

    public String getArriveTime() {
        return this.f5477e;
    }

    public String getDepartureStation() {
        return this.f5474b;
    }

    public String getDepartureTime() {
        return this.f5476d;
    }

    public String getName() {
        return this.f5473a;
    }

    public void setArriveStation(String str) {
        this.f5475c = str;
    }

    public void setArriveTime(String str) {
        this.f5477e = str;
    }

    public void setDepartureStation(String str) {
        this.f5474b = str;
    }

    public void setDepartureTime(String str) {
        this.f5476d = str;
    }

    public void setName(String str) {
        this.f5473a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5473a);
        parcel.writeString(this.f5474b);
        parcel.writeString(this.f5475c);
        parcel.writeString(this.f5476d);
        parcel.writeString(this.f5477e);
    }
}
