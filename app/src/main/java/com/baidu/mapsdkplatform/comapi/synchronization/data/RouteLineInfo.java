package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public final class RouteLineInfo implements Parcelable {
    public static final Parcelable.Creator<RouteLineInfo> CREATOR = new Parcelable.Creator<RouteLineInfo>() { // from class: com.baidu.mapsdkplatform.comapi.synchronization.data.RouteLineInfo.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final RouteLineInfo createFromParcel(Parcel parcel) {
            return new RouteLineInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final RouteLineInfo[] newArray(int i) {
            return new RouteLineInfo[i];
        }
    };

    /* renamed from: a */
    private boolean f6215a;

    /* renamed from: b */
    private String f6216b;

    /* renamed from: c */
    private CopyOnWriteArrayList<RouteSectionInfo> f6217c;

    /* loaded from: classes.dex */
    public static final class RouteSectionInfo implements Parcelable {
        public static final Parcelable.Creator<RouteSectionInfo> CREATOR = new Parcelable.Creator<RouteSectionInfo>() { // from class: com.baidu.mapsdkplatform.comapi.synchronization.data.RouteLineInfo.RouteSectionInfo.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final RouteSectionInfo createFromParcel(Parcel parcel) {
                return new RouteSectionInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final RouteSectionInfo[] newArray(int i) {
                return new RouteSectionInfo[i];
            }
        };

        /* renamed from: a */
        private LatLng f6218a;

        /* renamed from: b */
        private LatLng f6219b;

        public RouteSectionInfo() {
            this.f6218a = null;
            this.f6219b = null;
            this.f6218a = null;
            this.f6219b = null;
        }

        protected RouteSectionInfo(Parcel parcel) {
            this.f6218a = null;
            this.f6219b = null;
            this.f6218a = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            this.f6219b = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        }

        /* renamed from: a */
        public final LatLng m10437a() {
            return this.f6218a;
        }

        /* renamed from: a */
        public final void m10436a(LatLng latLng) {
            this.f6218a = latLng;
        }

        /* renamed from: b */
        public final LatLng m10435b() {
            return this.f6219b;
        }

        /* renamed from: b */
        public final void m10434b(LatLng latLng) {
            this.f6219b = latLng;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f6218a, i);
            parcel.writeParcelable(this.f6219b, i);
        }
    }

    public RouteLineInfo() {
        this.f6215a = false;
        this.f6216b = null;
        this.f6217c = new CopyOnWriteArrayList<>();
    }

    protected RouteLineInfo(Parcel parcel) {
        this.f6215a = parcel.readByte() != 0;
        this.f6216b = parcel.readString();
    }

    /* renamed from: a */
    public final String m10444a() {
        return this.f6216b;
    }

    /* renamed from: a */
    public final void m10443a(RouteSectionInfo routeSectionInfo) {
        CopyOnWriteArrayList<RouteSectionInfo> copyOnWriteArrayList = this.f6217c;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.add(routeSectionInfo);
        }
    }

    /* renamed from: a */
    public final void m10442a(String str) {
        this.f6216b = str;
    }

    /* renamed from: a */
    public final void m10441a(boolean z) {
        this.f6215a = z;
    }

    /* renamed from: b */
    public final List<RouteSectionInfo> m10440b() {
        return this.f6217c;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.f6215a ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f6216b);
        parcel.writeTypedList(this.f6217c);
    }
}
