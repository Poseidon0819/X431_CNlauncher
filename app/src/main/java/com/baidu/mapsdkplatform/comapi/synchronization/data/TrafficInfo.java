package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class TrafficInfo implements Parcelable {
    public static final Parcelable.Creator<TrafficInfo> CREATOR = new Parcelable.Creator<TrafficInfo>() { // from class: com.baidu.mapsdkplatform.comapi.synchronization.data.TrafficInfo.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final TrafficInfo createFromParcel(Parcel parcel) {
            return new TrafficInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final TrafficInfo[] newArray(int i) {
            return new TrafficInfo[i];
        }
    };

    /* renamed from: a */
    private boolean f6230a;

    /* renamed from: b */
    private String f6231b;

    /* renamed from: c */
    private ArrayList<Integer> f6232c;

    public TrafficInfo() {
        this.f6230a = false;
        this.f6231b = null;
        this.f6230a = false;
        this.f6231b = null;
        this.f6232c = new ArrayList<>();
    }

    protected TrafficInfo(Parcel parcel) {
        this.f6230a = false;
        this.f6231b = null;
        this.f6230a = parcel.readByte() != 0;
        this.f6231b = parcel.readString();
    }

    /* renamed from: a */
    public final String m10417a() {
        return this.f6231b;
    }

    /* renamed from: a */
    public final void m10416a(String str) {
        this.f6231b = str;
    }

    /* renamed from: a */
    public final void m10415a(ArrayList<Integer> arrayList) {
        this.f6232c = arrayList;
    }

    /* renamed from: a */
    public final void m10414a(boolean z) {
        this.f6230a = z;
    }

    /* renamed from: b */
    public final ArrayList<Integer> m10413b() {
        return this.f6232c;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.f6230a ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f6231b);
    }
}
