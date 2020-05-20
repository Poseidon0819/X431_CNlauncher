package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.itextpdf.text.pdf.ColumnText;

/* loaded from: classes.dex */
public final class SyncResponseResult implements Parcelable {
    public static final Parcelable.Creator<SyncResponseResult> CREATOR = new Parcelable.Creator<SyncResponseResult>() { // from class: com.baidu.mapsdkplatform.comapi.synchronization.data.SyncResponseResult.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final SyncResponseResult createFromParcel(Parcel parcel) {
            return new SyncResponseResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final SyncResponseResult[] newArray(int i) {
            return new SyncResponseResult[i];
        }
    };

    /* renamed from: a */
    private RouteLineInfo f6220a;

    /* renamed from: b */
    private TrafficInfo f6221b;

    /* renamed from: c */
    private DriverPosition f6222c;

    /* renamed from: d */
    private float f6223d;

    /* renamed from: e */
    private long f6224e;

    /* renamed from: f */
    private float f6225f;

    /* renamed from: g */
    private long f6226g;

    /* renamed from: h */
    private int f6227h;

    /* renamed from: i */
    private String f6228i;

    /* renamed from: j */
    private String f6229j;

    public SyncResponseResult() {
        this.f6220a = new RouteLineInfo();
        this.f6221b = new TrafficInfo();
        this.f6222c = new DriverPosition();
        this.f6223d = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.f6224e = 0L;
        this.f6225f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.f6226g = 0L;
        this.f6227h = 0;
        this.f6228i = null;
        this.f6229j = null;
    }

    protected SyncResponseResult(Parcel parcel) {
        this.f6220a = (RouteLineInfo) parcel.readParcelable(RouteLineInfo.class.getClassLoader());
        this.f6221b = (TrafficInfo) parcel.readParcelable(TrafficInfo.class.getClassLoader());
        this.f6222c = (DriverPosition) parcel.readParcelable(DriverPosition.class.getClassLoader());
        this.f6223d = (float) parcel.readLong();
        this.f6224e = parcel.readLong();
        this.f6225f = (float) parcel.readLong();
        this.f6226g = parcel.readLong();
        this.f6227h = parcel.readInt();
        this.f6228i = parcel.readString();
        this.f6229j = parcel.readString();
    }

    /* renamed from: a */
    public final RouteLineInfo m10431a() {
        return this.f6220a;
    }

    /* renamed from: a */
    public final void m10430a(float f) {
        this.f6223d = f;
    }

    /* renamed from: a */
    public final void m10429a(int i) {
        this.f6227h = i;
    }

    /* renamed from: a */
    public final void m10428a(long j) {
        this.f6224e = j;
    }

    /* renamed from: a */
    public final void m10427a(String str) {
        this.f6228i = str;
    }

    /* renamed from: b */
    public final TrafficInfo m10426b() {
        return this.f6221b;
    }

    /* renamed from: b */
    public final void m10425b(float f) {
        this.f6225f = f;
    }

    /* renamed from: b */
    public final void m10424b(long j) {
        this.f6226g = j;
    }

    /* renamed from: b */
    public final void m10423b(String str) {
        this.f6229j = str;
    }

    /* renamed from: c */
    public final DriverPosition m10422c() {
        return this.f6222c;
    }

    /* renamed from: d */
    public final float m10421d() {
        return this.f6225f;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public final long m10420e() {
        return this.f6226g;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f6220a, 1);
        parcel.writeParcelable(this.f6221b, 1);
        parcel.writeParcelable(this.f6222c, 1);
        parcel.writeFloat(this.f6223d);
        parcel.writeLong(this.f6224e);
        parcel.writeFloat(this.f6225f);
        parcel.writeLong(this.f6226g);
        parcel.writeInt(this.f6227h);
        parcel.writeString(this.f6228i);
        parcel.writeString(this.f6229j);
    }
}
