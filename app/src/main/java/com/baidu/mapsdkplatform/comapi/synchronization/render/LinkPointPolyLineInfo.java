package com.baidu.mapsdkplatform.comapi.synchronization.render;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;

/* loaded from: classes.dex */
public final class LinkPointPolyLineInfo implements Parcelable {
    public static final Parcelable.Creator<LinkPointPolyLineInfo> CREATOR = new Parcelable.Creator<LinkPointPolyLineInfo>() { // from class: com.baidu.mapsdkplatform.comapi.synchronization.render.LinkPointPolyLineInfo.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final LinkPointPolyLineInfo createFromParcel(Parcel parcel) {
            return new LinkPointPolyLineInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final LinkPointPolyLineInfo[] newArray(int i) {
            return new LinkPointPolyLineInfo[i];
        }
    };

    /* renamed from: a */
    private long f6290a;

    /* renamed from: b */
    private LatLng f6291b;

    /* renamed from: c */
    private LatLng f6292c;

    /* renamed from: d */
    private int f6293d;

    public LinkPointPolyLineInfo() {
        this.f6290a = 0L;
        this.f6293d = 0;
        this.f6290a = 0L;
        this.f6291b = null;
        this.f6292c = null;
        this.f6293d = 0;
    }

    protected LinkPointPolyLineInfo(Parcel parcel) {
        this.f6290a = 0L;
        this.f6293d = 0;
        this.f6290a = parcel.readLong();
        this.f6291b = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f6292c = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f6293d = parcel.readInt();
    }

    /* renamed from: a */
    public final LatLng m10298a() {
        return this.f6291b;
    }

    /* renamed from: a */
    public final void m10297a(int i) {
        this.f6293d = i;
    }

    /* renamed from: a */
    public final void m10296a(LatLng latLng) {
        this.f6291b = latLng;
    }

    /* renamed from: b */
    public final LatLng m10295b() {
        return this.f6292c;
    }

    /* renamed from: b */
    public final void m10294b(LatLng latLng) {
        this.f6292c = latLng;
    }

    /* renamed from: c */
    public final int m10293c() {
        return this.f6293d;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f6290a);
        parcel.writeParcelable(this.f6291b, i);
        parcel.writeParcelable(this.f6292c, i);
        parcel.writeInt(this.f6293d);
    }
}
