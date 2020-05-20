package com.cnlaunch.x431pro.module.cloud.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: CloudData.java */
/* renamed from: com.cnlaunch.x431pro.module.cloud.model.d */
/* loaded from: classes.dex */
final class C2719d implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new CloudData[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        CloudData cloudData = new CloudData();
        cloudData.f15491a = parcel.readString();
        cloudData.f15492b = parcel.readString();
        cloudData.f15493c = parcel.readString();
        cloudData.f15494d = parcel.readString();
        cloudData.f15495e = parcel.readString();
        cloudData.f15496f = parcel.readString();
        return cloudData;
    }
}
