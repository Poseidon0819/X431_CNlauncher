package com.unionpay.mobile.android.pboctransaction;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.unionpay.mobile.android.pboctransaction.a */
/* loaded from: classes2.dex */
final class C4260a implements Parcelable.Creator<AppIdentification> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AppIdentification createFromParcel(Parcel parcel) {
        AppIdentification appIdentification = new AppIdentification((byte) 0);
        appIdentification.f22721a = parcel.readString();
        appIdentification.f22722b = parcel.readString();
        return appIdentification;
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ AppIdentification[] newArray(int i) {
        return new AppIdentification[i];
    }
}
