package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.TaxiInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class DrivingRouteResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<DrivingRouteResult> CREATOR = new Parcelable.Creator<DrivingRouteResult>() { // from class: com.baidu.mapapi.search.route.DrivingRouteResult.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final DrivingRouteResult createFromParcel(Parcel parcel) {
            return new DrivingRouteResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final DrivingRouteResult[] newArray(int i) {
            return new DrivingRouteResult[i];
        }
    };

    /* renamed from: a */
    private List<DrivingRouteLine> f5571a;

    /* renamed from: b */
    private List<TaxiInfo> f5572b;

    /* renamed from: c */
    private TaxiInfo f5573c;

    /* renamed from: d */
    private SuggestAddrInfo f5574d;

    public DrivingRouteResult() {
    }

    protected DrivingRouteResult(Parcel parcel) {
        this.f5571a = new ArrayList();
        parcel.readTypedList(this.f5571a, DrivingRouteLine.CREATOR);
        this.f5572b = new ArrayList();
        parcel.readTypedList(this.f5572b, TaxiInfo.CREATOR);
        this.f5574d = (SuggestAddrInfo) parcel.readParcelable(SuggestAddrInfo.class.getClassLoader());
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final List<DrivingRouteLine> getRouteLines() {
        return this.f5571a;
    }

    public final SuggestAddrInfo getSuggestAddrInfo() {
        return this.f5574d;
    }

    @Deprecated
    public final TaxiInfo getTaxiInfo() {
        return this.f5573c;
    }

    public final List<TaxiInfo> getTaxiInfos() {
        return this.f5572b;
    }

    public final void setRouteLines(List<DrivingRouteLine> list) {
        this.f5571a = list;
    }

    public final void setSuggestAddrInfo(SuggestAddrInfo suggestAddrInfo) {
        this.f5574d = suggestAddrInfo;
    }

    public final void setTaxiInfos(List<TaxiInfo> list) {
        this.f5572b = list;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f5571a);
        parcel.writeTypedList(this.f5572b);
        parcel.writeParcelable(this.f5574d, 1);
    }
}
