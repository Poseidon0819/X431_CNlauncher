package com.cnlaunch.physics.wifi;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: DPUWiFiAPConfig.java */
/* renamed from: com.cnlaunch.physics.wifi.a */
/* loaded from: classes.dex */
final class C1863a implements Parcelable.Creator<DPUWiFiAPConfig> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ DPUWiFiAPConfig[] newArray(int i) {
        return new DPUWiFiAPConfig[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DPUWiFiAPConfig createFromParcel(Parcel parcel) {
        return new DPUWiFiAPConfig(parcel);
    }
}
