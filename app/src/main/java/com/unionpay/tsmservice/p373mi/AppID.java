package com.unionpay.tsmservice.p373mi;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.unionpay.tsmservice.mi.AppID */
/* loaded from: classes2.dex */
public class AppID implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.unionpay.tsmservice.mi.AppID.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AppID(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppID[i];
        }
    };

    /* renamed from: a */
    String f23599a;

    /* renamed from: b */
    String f23600b;

    public AppID(Parcel parcel) {
        this.f23599a = "";
        this.f23600b = "";
        this.f23599a = parcel.readString();
        this.f23600b = parcel.readString();
    }

    public AppID(String str, String str2) {
        this.f23599a = "";
        this.f23600b = "";
        this.f23599a = str;
        this.f23600b = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAppAid() {
        return this.f23599a;
    }

    public String getAppVersion() {
        return this.f23600b;
    }

    public void setAppAid(String str) {
        this.f23599a = str;
    }

    public void setAppVersion(String str) {
        this.f23600b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f23599a);
        parcel.writeString(this.f23600b);
    }
}
