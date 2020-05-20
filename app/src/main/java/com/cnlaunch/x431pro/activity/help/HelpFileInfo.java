package com.cnlaunch.x431pro.activity.help;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class HelpFileInfo implements Parcelable {

    /* renamed from: a */
    String f12718a;

    /* renamed from: b */
    String f12719b;

    /* renamed from: c */
    String f12720c;

    /* renamed from: d */
    String f12721d;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12718a);
        parcel.writeString(this.f12719b);
        parcel.writeString(this.f12720c);
        parcel.writeString(this.f12721d);
    }
}
