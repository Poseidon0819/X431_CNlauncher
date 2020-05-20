package com.cnlaunch.x431pro.module.history.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: VehicleInfo.java */
/* renamed from: com.cnlaunch.x431pro.module.history.model.e */
/* loaded from: classes.dex */
final class C2733e implements Parcelable.Creator<VehicleInfo> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ VehicleInfo[] newArray(int i) {
        return new VehicleInfo[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ VehicleInfo createFromParcel(Parcel parcel) {
        return new VehicleInfo(parcel);
    }
}
