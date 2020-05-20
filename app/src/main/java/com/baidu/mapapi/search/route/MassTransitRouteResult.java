package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.TaxiInfo;
import com.baidu.mapapi.search.core.TransitResultNode;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class MassTransitRouteResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<MassTransitRouteResult> CREATOR = new Parcelable.Creator<MassTransitRouteResult>() { // from class: com.baidu.mapapi.search.route.MassTransitRouteResult.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final MassTransitRouteResult createFromParcel(Parcel parcel) {
            return new MassTransitRouteResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final MassTransitRouteResult[] newArray(int i) {
            return new MassTransitRouteResult[i];
        }
    };

    /* renamed from: a */
    private TransitResultNode f5612a;

    /* renamed from: b */
    private TransitResultNode f5613b;

    /* renamed from: c */
    private TaxiInfo f5614c;

    /* renamed from: d */
    private int f5615d;

    /* renamed from: e */
    private List<MassTransitRouteLine> f5616e;

    /* renamed from: f */
    private SuggestAddrInfo f5617f;

    public MassTransitRouteResult() {
    }

    MassTransitRouteResult(Parcel parcel) {
        this.f5612a = (TransitResultNode) parcel.readParcelable(TransitResultNode.class.getClassLoader());
        this.f5613b = (TransitResultNode) parcel.readParcelable(TransitResultNode.class.getClassLoader());
        this.f5614c = (TaxiInfo) parcel.readParcelable(TaxiInfo.class.getClassLoader());
        this.f5615d = parcel.readInt();
        this.f5616e = new ArrayList();
        parcel.readList(this.f5616e, MassTransitRouteLine.class.getClassLoader());
        this.f5617f = (SuggestAddrInfo) parcel.readParcelable(SuggestAddrInfo.class.getClassLoader());
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final TransitResultNode getDestination() {
        return this.f5613b;
    }

    public final TransitResultNode getOrigin() {
        return this.f5612a;
    }

    public final List<MassTransitRouteLine> getRouteLines() {
        return this.f5616e;
    }

    public final SuggestAddrInfo getSuggestAddrInfo() {
        return this.f5617f;
    }

    public final TaxiInfo getTaxiInfo() {
        return this.f5614c;
    }

    public final int getTotal() {
        return this.f5615d;
    }

    public final void setDestination(TransitResultNode transitResultNode) {
        this.f5613b = transitResultNode;
    }

    public final void setOrigin(TransitResultNode transitResultNode) {
        this.f5612a = transitResultNode;
    }

    public final void setRoutelines(List<MassTransitRouteLine> list) {
        this.f5616e = list;
    }

    public final void setSuggestAddrInfo(SuggestAddrInfo suggestAddrInfo) {
        this.f5617f = suggestAddrInfo;
    }

    public final void setTaxiInfo(TaxiInfo taxiInfo) {
        this.f5614c = taxiInfo;
    }

    public final void setTotal(int i) {
        this.f5615d = i;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f5612a, 1);
        parcel.writeParcelable(this.f5613b, 1);
        parcel.writeParcelable(this.f5614c, 1);
        parcel.writeInt(this.f5615d);
        parcel.writeList(this.f5616e);
        parcel.writeParcelable(this.f5617f, 1);
    }
}
