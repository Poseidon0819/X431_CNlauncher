package com.cnlaunch.x431pro.module.cloud.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class CloudData implements Parcelable {
    public static final Parcelable.Creator<CloudData> CREATOR = new C2719d();

    /* renamed from: a */
    public String f15491a;

    /* renamed from: b */
    public String f15492b;

    /* renamed from: c */
    public String f15493c;

    /* renamed from: d */
    public String f15494d;

    /* renamed from: e */
    public String f15495e;

    /* renamed from: f */
    public String f15496f;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "CloudData{serial_no='" + this.f15491a + "', type='" + this.f15492b + "', diagnose_no='" + this.f15493c + "', content='" + this.f15494d + "', bag_no='" + this.f15495e + "', fileName='" + this.f15496f + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f15491a);
        parcel.writeString(this.f15492b);
        parcel.writeString(this.f15493c);
        parcel.writeString(this.f15494d);
        parcel.writeString(this.f15495e);
        parcel.writeString(this.f15496f);
    }
}
