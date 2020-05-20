package com.cnlaunch.x431pro.module.cloud.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: CloudSystemInfo.java */
/* renamed from: com.cnlaunch.x431pro.module.cloud.model.l */
/* loaded from: classes.dex */
final class C2721l implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new CloudSystemInfo[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        CloudSystemInfo cloudSystemInfo = new CloudSystemInfo();
        cloudSystemInfo.f15497a = parcel.readString();
        cloudSystemInfo.f15498b = parcel.readString();
        cloudSystemInfo.f15499c = parcel.readString();
        return cloudSystemInfo;
    }
}
