package com.cnlaunch.x431pro.module.cloud.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class CloudSystemInfo implements Parcelable {
    public static final Parcelable.Creator<CloudSystemInfo> CREATOR = new C2721l();

    /* renamed from: a */
    public String f15497a;

    /* renamed from: b */
    public String f15498b;

    /* renamed from: c */
    public String f15499c;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f15497a);
        parcel.writeString(this.f15498b);
        parcel.writeString(this.f15499c);
    }
}
