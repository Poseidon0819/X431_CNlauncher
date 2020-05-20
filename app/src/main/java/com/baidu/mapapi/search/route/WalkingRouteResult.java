package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.TaxiInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class WalkingRouteResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<WalkingRouteResult> CREATOR = new Parcelable.Creator<WalkingRouteResult>() { // from class: com.baidu.mapapi.search.route.WalkingRouteResult.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final WalkingRouteResult createFromParcel(Parcel parcel) {
            return new WalkingRouteResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final WalkingRouteResult[] newArray(int i) {
            return new WalkingRouteResult[i];
        }
    };

    /* renamed from: a */
    private List<WalkingRouteLine> f5648a;

    /* renamed from: b */
    private TaxiInfo f5649b;

    /* renamed from: c */
    private SuggestAddrInfo f5650c;

    public WalkingRouteResult() {
    }

    protected WalkingRouteResult(Parcel parcel) {
        this.f5648a = new ArrayList();
        parcel.readList(this.f5648a, WalkingRouteLine.class.getClassLoader());
        this.f5649b = (TaxiInfo) parcel.readParcelable(TaxiInfo.class.getClassLoader());
        this.f5650c = (SuggestAddrInfo) parcel.readParcelable(SuggestAddrInfo.class.getClassLoader());
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<WalkingRouteLine> getRouteLines() {
        return this.f5648a;
    }

    public SuggestAddrInfo getSuggestAddrInfo() {
        return this.f5650c;
    }

    public TaxiInfo getTaxiInfo() {
        return this.f5649b;
    }

    public void setRouteLines(List<WalkingRouteLine> list) {
        this.f5648a = list;
    }

    public void setSuggestAddrInfo(SuggestAddrInfo suggestAddrInfo) {
        this.f5650c = suggestAddrInfo;
    }

    public void setTaxiInfo(TaxiInfo taxiInfo) {
        this.f5649b = taxiInfo;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f5648a);
        parcel.writeParcelable(this.f5649b, 1);
        parcel.writeParcelable(this.f5650c, 1);
    }
}
