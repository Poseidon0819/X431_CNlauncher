package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;

/* loaded from: classes.dex */
public class RouteNode implements Parcelable {
    public static final Parcelable.Creator<RouteNode> CREATOR = new Parcelable.Creator<RouteNode>() { // from class: com.baidu.mapapi.search.core.RouteNode.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final RouteNode createFromParcel(Parcel parcel) {
            return new RouteNode(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final RouteNode[] newArray(int i) {
            return new RouteNode[i];
        }
    };

    /* renamed from: a */
    private String f5459a;

    /* renamed from: b */
    private LatLng f5460b;

    /* renamed from: c */
    private String f5461c;

    public RouteNode() {
    }

    protected RouteNode(Parcel parcel) {
        this.f5459a = parcel.readString();
        this.f5460b = (LatLng) parcel.readValue(LatLng.class.getClassLoader());
        this.f5461c = parcel.readString();
    }

    public static RouteNode location(LatLng latLng) {
        RouteNode routeNode = new RouteNode();
        routeNode.setLocation(latLng);
        return routeNode;
    }

    public static RouteNode titleAndLocation(String str, LatLng latLng) {
        RouteNode routeNode = new RouteNode();
        routeNode.setTitle(str);
        routeNode.setLocation(latLng);
        return routeNode;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLng getLocation() {
        return this.f5460b;
    }

    public String getTitle() {
        return this.f5459a;
    }

    public String getUid() {
        return this.f5461c;
    }

    public void setLocation(LatLng latLng) {
        this.f5460b = latLng;
    }

    public void setTitle(String str) {
        this.f5459a = str;
    }

    public void setUid(String str) {
        this.f5461c = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5459a);
        parcel.writeValue(this.f5460b);
        parcel.writeString(this.f5461c);
    }
}
