package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class RouteStep implements Parcelable {
    public static final Parcelable.Creator<RouteStep> CREATOR = new Parcelable.Creator<RouteStep>() { // from class: com.baidu.mapapi.search.core.RouteStep.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final RouteStep createFromParcel(Parcel parcel) {
            return new RouteStep(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final RouteStep[] newArray(int i) {
            return new RouteStep[i];
        }
    };

    /* renamed from: a */
    int f5462a;

    /* renamed from: b */
    int f5463b;

    /* renamed from: c */
    String f5464c;
    protected List<LatLng> mWayPoints;

    /* JADX INFO: Access modifiers changed from: protected */
    public RouteStep() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RouteStep(Parcel parcel) {
        this.f5462a = parcel.readInt();
        this.f5463b = parcel.readInt();
        this.f5464c = parcel.readString();
        this.mWayPoints = new ArrayList();
        parcel.readList(this.mWayPoints, LatLng.class.getClassLoader());
        if (this.mWayPoints.size() == 0) {
            this.mWayPoints = null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDistance() {
        return this.f5462a;
    }

    public int getDuration() {
        return this.f5463b;
    }

    public String getName() {
        return this.f5464c;
    }

    public List<LatLng> getWayPoints() {
        return this.mWayPoints;
    }

    public void setDistance(int i) {
        this.f5462a = i;
    }

    public void setDuration(int i) {
        this.f5463b = i;
    }

    public void setName(String str) {
        this.f5464c = str;
    }

    public void setWayPoints(List<LatLng> list) {
        this.mWayPoints = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f5462a);
        parcel.writeInt(this.f5463b);
        parcel.writeString(this.f5464c);
        parcel.writeList(this.mWayPoints);
    }
}
