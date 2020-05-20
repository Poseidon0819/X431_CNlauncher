package com.unionpay.tsmservice;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class AppID implements Parcelable {
    public static final Parcelable.Creator<AppID> CREATOR = new Parcelable.Creator<AppID>() { // from class: com.unionpay.tsmservice.AppID.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AppID createFromParcel(Parcel parcel) {
            return new AppID(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AppID[] newArray(int i) {
            return new AppID[i];
        }
    };

    /* renamed from: a */
    String f23521a;

    /* renamed from: b */
    String f23522b;

    public AppID(Parcel parcel) {
        this.f23521a = "";
        this.f23522b = "";
        this.f23521a = parcel.readString();
        this.f23522b = parcel.readString();
    }

    public AppID(String str, String str2) {
        this.f23521a = "";
        this.f23522b = "";
        this.f23521a = str;
        this.f23522b = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAppAid() {
        return this.f23521a;
    }

    public String getAppVersion() {
        return this.f23522b;
    }

    public void setAppAid(String str) {
        this.f23521a = str;
    }

    public void setAppVersion(String str) {
        this.f23522b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f23521a);
        parcel.writeString(this.f23522b);
    }
}
