package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.TaxiInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class TransitRouteResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<TransitRouteResult> CREATOR = new Parcelable.Creator<TransitRouteResult>() { // from class: com.baidu.mapapi.search.route.TransitRouteResult.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final TransitRouteResult createFromParcel(Parcel parcel) {
            return new TransitRouteResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final TransitRouteResult[] newArray(int i) {
            return new TransitRouteResult[i];
        }
    };

    /* renamed from: a */
    private TaxiInfo f5638a;

    /* renamed from: b */
    private List<TransitRouteLine> f5639b;

    /* renamed from: c */
    private SuggestAddrInfo f5640c;

    public TransitRouteResult() {
    }

    protected TransitRouteResult(Parcel parcel) {
        this.f5638a = (TaxiInfo) parcel.readParcelable(TaxiInfo.class.getClassLoader());
        this.f5639b = new ArrayList();
        parcel.readList(this.f5639b, TransitRouteLine.class.getClassLoader());
        this.f5640c = (SuggestAddrInfo) parcel.readParcelable(SuggestAddrInfo.class.getClassLoader());
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final List<TransitRouteLine> getRouteLines() {
        return this.f5639b;
    }

    public final SuggestAddrInfo getSuggestAddrInfo() {
        return this.f5640c;
    }

    public final TaxiInfo getTaxiInfo() {
        return this.f5638a;
    }

    public final void setRoutelines(List<TransitRouteLine> list) {
        this.f5639b = list;
    }

    public final void setSuggestAddrInfo(SuggestAddrInfo suggestAddrInfo) {
        this.f5640c = suggestAddrInfo;
    }

    public final void setTaxiInfo(TaxiInfo taxiInfo) {
        this.f5638a = taxiInfo;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f5638a, 1);
        parcel.writeList(this.f5639b);
        parcel.writeParcelable(this.f5640c, 1);
    }
}
