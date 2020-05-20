package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.CityInfo;
import com.baidu.mapapi.search.core.PoiInfo;
import java.util.List;

/* loaded from: classes.dex */
public class SuggestAddrInfo implements Parcelable {
    public static final Parcelable.Creator<SuggestAddrInfo> CREATOR = new Parcelable.Creator<SuggestAddrInfo>() { // from class: com.baidu.mapapi.search.route.SuggestAddrInfo.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final SuggestAddrInfo createFromParcel(Parcel parcel) {
            return new SuggestAddrInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final SuggestAddrInfo[] newArray(int i) {
            return new SuggestAddrInfo[i];
        }
    };

    /* renamed from: a */
    private List<PoiInfo> f5623a;

    /* renamed from: b */
    private List<PoiInfo> f5624b;

    /* renamed from: c */
    private List<List<PoiInfo>> f5625c;

    /* renamed from: d */
    private List<CityInfo> f5626d;

    /* renamed from: e */
    private List<CityInfo> f5627e;

    /* renamed from: f */
    private List<List<CityInfo>> f5628f;

    public SuggestAddrInfo() {
    }

    SuggestAddrInfo(Parcel parcel) {
        this.f5623a = parcel.readArrayList(PoiInfo.class.getClassLoader());
        this.f5624b = parcel.readArrayList(PoiInfo.class.getClassLoader());
        this.f5625c = parcel.readArrayList(PoiInfo.class.getClassLoader());
        this.f5626d = parcel.readArrayList(CityInfo.class.getClassLoader());
        this.f5627e = parcel.readArrayList(CityInfo.class.getClassLoader());
        this.f5628f = parcel.readArrayList(CityInfo.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<CityInfo> getSuggestEndCity() {
        return this.f5627e;
    }

    public List<PoiInfo> getSuggestEndNode() {
        return this.f5624b;
    }

    public List<CityInfo> getSuggestStartCity() {
        return this.f5626d;
    }

    public List<PoiInfo> getSuggestStartNode() {
        return this.f5623a;
    }

    public List<List<CityInfo>> getSuggestWpCity() {
        return this.f5628f;
    }

    public List<List<PoiInfo>> getSuggestWpNode() {
        return this.f5625c;
    }

    public void setSuggestEndCity(List<CityInfo> list) {
        this.f5627e = list;
    }

    public void setSuggestEndNode(List<PoiInfo> list) {
        this.f5624b = list;
    }

    public void setSuggestStartCity(List<CityInfo> list) {
        this.f5626d = list;
    }

    public void setSuggestStartNode(List<PoiInfo> list) {
        this.f5623a = list;
    }

    public void setSuggestWpCity(List<List<CityInfo>> list) {
        this.f5628f = list;
    }

    public void setSuggestWpNode(List<List<PoiInfo>> list) {
        this.f5625c = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f5623a);
        parcel.writeList(this.f5624b);
        parcel.writeList(this.f5625c);
        parcel.writeList(this.f5626d);
        parcel.writeList(this.f5627e);
        parcel.writeList(this.f5628f);
    }
}
