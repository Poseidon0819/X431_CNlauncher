package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class PriceInfo implements Parcelable {
    public static final Parcelable.Creator<PriceInfo> CREATOR = new Parcelable.Creator<PriceInfo>() { // from class: com.baidu.mapapi.search.core.PriceInfo.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final PriceInfo createFromParcel(Parcel parcel) {
            return new PriceInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final PriceInfo[] newArray(int i) {
            return new PriceInfo[i];
        }
    };

    /* renamed from: a */
    private int f5448a;

    /* renamed from: b */
    private double f5449b;

    public PriceInfo() {
    }

    protected PriceInfo(Parcel parcel) {
        this.f5448a = parcel.readInt();
        this.f5449b = parcel.readDouble();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public double getTicketPrice() {
        return this.f5449b;
    }

    public int getTicketType() {
        return this.f5448a;
    }

    public void setTicketPrice(double d) {
        this.f5449b = d;
    }

    public void setTicketType(int i) {
        this.f5448a = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f5448a);
        parcel.writeDouble(this.f5449b);
    }
}
