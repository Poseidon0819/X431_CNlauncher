package com.baidu.mapapi.map;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.map.C1234x;
import com.itextpdf.text.pdf.ColumnText;

/* loaded from: classes.dex */
public final class BaiduMapOptions implements Parcelable {
    public static final Parcelable.Creator<BaiduMapOptions> CREATOR = new Parcelable.Creator<BaiduMapOptions>() { // from class: com.baidu.mapapi.map.BaiduMapOptions.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final BaiduMapOptions createFromParcel(Parcel parcel) {
            return new BaiduMapOptions(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final BaiduMapOptions[] newArray(int i) {
            return new BaiduMapOptions[i];
        }
    };

    /* renamed from: a */
    MapStatus f4970a;

    /* renamed from: b */
    boolean f4971b;

    /* renamed from: c */
    int f4972c;

    /* renamed from: d */
    boolean f4973d;

    /* renamed from: e */
    boolean f4974e;

    /* renamed from: f */
    boolean f4975f;

    /* renamed from: g */
    boolean f4976g;

    /* renamed from: h */
    boolean f4977h;

    /* renamed from: i */
    boolean f4978i;

    /* renamed from: j */
    LogoPosition f4979j;

    /* renamed from: k */
    Point f4980k;

    /* renamed from: l */
    Point f4981l;

    public BaiduMapOptions() {
        this.f4970a = new MapStatus(ColumnText.GLOBAL_SPACE_CHAR_RATIO, new LatLng(39.914935d, 116.403119d), ColumnText.GLOBAL_SPACE_CHAR_RATIO, 12.0f, null, null);
        this.f4971b = true;
        this.f4972c = 1;
        this.f4973d = true;
        this.f4974e = true;
        this.f4975f = true;
        this.f4976g = true;
        this.f4977h = true;
        this.f4978i = true;
    }

    protected BaiduMapOptions(Parcel parcel) {
        this.f4970a = new MapStatus(ColumnText.GLOBAL_SPACE_CHAR_RATIO, new LatLng(39.914935d, 116.403119d), ColumnText.GLOBAL_SPACE_CHAR_RATIO, 12.0f, null, null);
        this.f4971b = true;
        this.f4972c = 1;
        this.f4973d = true;
        this.f4974e = true;
        this.f4975f = true;
        this.f4976g = true;
        this.f4977h = true;
        this.f4978i = true;
        this.f4970a = (MapStatus) parcel.readParcelable(MapStatus.class.getClassLoader());
        this.f4971b = parcel.readByte() != 0;
        this.f4972c = parcel.readInt();
        this.f4973d = parcel.readByte() != 0;
        this.f4974e = parcel.readByte() != 0;
        this.f4975f = parcel.readByte() != 0;
        this.f4976g = parcel.readByte() != 0;
        this.f4977h = parcel.readByte() != 0;
        this.f4978i = parcel.readByte() != 0;
        this.f4980k = (Point) parcel.readParcelable(Point.class.getClassLoader());
        this.f4981l = (Point) parcel.readParcelable(Point.class.getClassLoader());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final C1234x m11222a() {
        return new C1234x().m10564a(this.f4970a.m11179c()).m10563a(this.f4971b).m10565a(this.f4972c).m10562b(this.f4973d).m10561c(this.f4974e).m10560d(this.f4975f).m10559e(this.f4976g);
    }

    public final BaiduMapOptions compassEnabled(boolean z) {
        this.f4971b = z;
        return this;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final BaiduMapOptions logoPosition(LogoPosition logoPosition) {
        this.f4979j = logoPosition;
        return this;
    }

    public final BaiduMapOptions mapStatus(MapStatus mapStatus) {
        if (mapStatus != null) {
            this.f4970a = mapStatus;
        }
        return this;
    }

    public final BaiduMapOptions mapType(int i) {
        this.f4972c = i;
        return this;
    }

    public final BaiduMapOptions overlookingGesturesEnabled(boolean z) {
        this.f4975f = z;
        return this;
    }

    public final BaiduMapOptions rotateGesturesEnabled(boolean z) {
        this.f4973d = z;
        return this;
    }

    public final BaiduMapOptions scaleControlEnabled(boolean z) {
        this.f4978i = z;
        return this;
    }

    public final BaiduMapOptions scaleControlPosition(Point point) {
        this.f4980k = point;
        return this;
    }

    public final BaiduMapOptions scrollGesturesEnabled(boolean z) {
        this.f4974e = z;
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f4970a, i);
        parcel.writeByte(this.f4971b ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f4972c);
        parcel.writeByte(this.f4973d ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f4974e ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f4975f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f4976g ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f4977h ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f4978i ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.f4980k, i);
        parcel.writeParcelable(this.f4981l, i);
    }

    public final BaiduMapOptions zoomControlsEnabled(boolean z) {
        this.f4977h = z;
        return this;
    }

    public final BaiduMapOptions zoomControlsPosition(Point point) {
        this.f4981l = point;
        return this;
    }

    public final BaiduMapOptions zoomGesturesEnabled(boolean z) {
        this.f4976g = z;
        return this;
    }
}
