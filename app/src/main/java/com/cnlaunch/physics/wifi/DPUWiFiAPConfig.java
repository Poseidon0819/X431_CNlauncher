package com.cnlaunch.physics.wifi;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class DPUWiFiAPConfig implements Parcelable {
    public static final Parcelable.Creator<DPUWiFiAPConfig> CREATOR = new C1863a();

    /* renamed from: a */
    private int f10160a;

    /* renamed from: b */
    private boolean f10161b;

    /* renamed from: c */
    private String f10162c;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DPUWiFiAPConfig() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DPUWiFiAPConfig(Parcel parcel) {
        this.f10160a = parcel.readInt();
        this.f10161b = parcel.readByte() != 0;
        this.f10162c = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f10160a);
        parcel.writeByte(this.f10161b ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f10162c);
    }
}
