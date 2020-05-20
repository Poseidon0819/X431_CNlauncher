package com.baidu.mapapi.search.poi;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.CityInfo;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.List;

/* loaded from: classes.dex */
public class PoiResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<PoiResult> CREATOR = new Parcelable.Creator<PoiResult>() { // from class: com.baidu.mapapi.search.poi.PoiResult.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final PoiResult createFromParcel(Parcel parcel) {
            return new PoiResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final PoiResult[] newArray(int i) {
            return new PoiResult[i];
        }
    };

    /* renamed from: a */
    private int f5532a;

    /* renamed from: b */
    private int f5533b;

    /* renamed from: c */
    private int f5534c;

    /* renamed from: d */
    private int f5535d;

    /* renamed from: e */
    private List<PoiInfo> f5536e;

    /* renamed from: f */
    private boolean f5537f;

    /* renamed from: g */
    private List<PoiAddrInfo> f5538g;

    /* renamed from: h */
    private List<CityInfo> f5539h;

    public PoiResult() {
        this.f5532a = 0;
        this.f5533b = 0;
        this.f5534c = 0;
        this.f5535d = 0;
        this.f5537f = false;
    }

    protected PoiResult(Parcel parcel) {
        super(parcel);
        this.f5532a = 0;
        this.f5533b = 0;
        this.f5534c = 0;
        this.f5535d = 0;
        this.f5537f = false;
        this.f5532a = parcel.readInt();
        this.f5533b = parcel.readInt();
        this.f5534c = parcel.readInt();
        this.f5535d = parcel.readInt();
        this.f5536e = parcel.createTypedArrayList(PoiInfo.CREATOR);
        this.f5537f = parcel.readByte() != 0;
        this.f5539h = parcel.createTypedArrayList(CityInfo.CREATOR);
    }

    public PoiResult(SearchResult.ERRORNO errorno) {
        super(errorno);
        this.f5532a = 0;
        this.f5533b = 0;
        this.f5534c = 0;
        this.f5535d = 0;
        this.f5537f = false;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<PoiAddrInfo> getAllAddr() {
        return this.f5538g;
    }

    public List<PoiInfo> getAllPoi() {
        return this.f5536e;
    }

    public int getCurrentPageCapacity() {
        return this.f5534c;
    }

    public int getCurrentPageNum() {
        return this.f5532a;
    }

    public List<CityInfo> getSuggestCityList() {
        return this.f5539h;
    }

    public int getTotalPageNum() {
        return this.f5533b;
    }

    public int getTotalPoiNum() {
        return this.f5535d;
    }

    public boolean isHasAddrInfo() {
        return this.f5537f;
    }

    public void setAddrInfo(List<PoiAddrInfo> list) {
        this.f5538g = list;
    }

    public void setCurrentPageCapacity(int i) {
        this.f5534c = i;
    }

    public void setCurrentPageNum(int i) {
        this.f5532a = i;
    }

    public void setHasAddrInfo(boolean z) {
        this.f5537f = z;
    }

    public void setPoiInfo(List<PoiInfo> list) {
        this.f5536e = list;
    }

    public void setSuggestCityList(List<CityInfo> list) {
        this.f5539h = list;
    }

    public void setTotalPageNum(int i) {
        this.f5533b = i;
    }

    public void setTotalPoiNum(int i) {
        this.f5535d = i;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f5532a);
        parcel.writeInt(this.f5533b);
        parcel.writeInt(this.f5534c);
        parcel.writeInt(this.f5535d);
        parcel.writeTypedList(this.f5536e);
        parcel.writeByte(this.f5537f ? (byte) 1 : (byte) 0);
        parcel.writeTypedList(this.f5539h);
    }
}
