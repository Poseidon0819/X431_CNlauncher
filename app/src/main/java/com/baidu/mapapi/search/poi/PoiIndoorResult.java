package com.baidu.mapapi.search.poi;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.List;

/* loaded from: classes.dex */
public class PoiIndoorResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<PoiIndoorResult> CREATOR = new Parcelable.Creator<PoiIndoorResult>() { // from class: com.baidu.mapapi.search.poi.PoiIndoorResult.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final PoiIndoorResult createFromParcel(Parcel parcel) {
            return new PoiIndoorResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final PoiIndoorResult[] newArray(int i) {
            return new PoiIndoorResult[i];
        }
    };

    /* renamed from: a */
    private List<PoiIndoorInfo> f5531a;
    public int pageNum;
    public int poiNum;

    public PoiIndoorResult() {
    }

    protected PoiIndoorResult(Parcel parcel) {
        super(parcel);
        this.poiNum = parcel.readInt();
        this.pageNum = parcel.readInt();
    }

    public PoiIndoorResult(SearchResult.ERRORNO errorno) {
        super(errorno);
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public int getPoiNum() {
        return this.poiNum;
    }

    public List<PoiIndoorInfo> getmArrayPoiInfo() {
        return this.f5531a;
    }

    public void setPageNum(int i) {
        this.pageNum = i;
    }

    public void setPoiNum(int i) {
        this.poiNum = i;
    }

    public void setmArrayPoiInfo(List<PoiIndoorInfo> list) {
        this.f5531a = list;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.poiNum);
        parcel.writeInt(this.pageNum);
    }
}
