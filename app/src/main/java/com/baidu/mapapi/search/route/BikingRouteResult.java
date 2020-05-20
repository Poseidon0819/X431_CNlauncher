package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class BikingRouteResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<BikingRouteLine> CREATOR = new Parcelable.Creator<BikingRouteLine>() { // from class: com.baidu.mapapi.search.route.BikingRouteResult.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final BikingRouteLine createFromParcel(Parcel parcel) {
            return new BikingRouteLine(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final BikingRouteLine[] newArray(int i) {
            return new BikingRouteLine[i];
        }
    };

    /* renamed from: a */
    private List<BikingRouteLine> f5551a;

    /* renamed from: b */
    private SuggestAddrInfo f5552b;

    public BikingRouteResult() {
    }

    protected BikingRouteResult(Parcel parcel) {
        this.f5551a = new ArrayList();
        parcel.readList(this.f5551a, BikingRouteLine.class.getClassLoader());
        this.f5552b = (SuggestAddrInfo) parcel.readParcelable(SuggestAddrInfo.class.getClassLoader());
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<BikingRouteLine> getRouteLines() {
        return this.f5551a;
    }

    public SuggestAddrInfo getSuggestAddrInfo() {
        return this.f5552b;
    }

    public void setRouteLines(List<BikingRouteLine> list) {
        this.f5551a = list;
    }

    public void setSuggestAddrInfo(SuggestAddrInfo suggestAddrInfo) {
        this.f5552b = suggestAddrInfo;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f5551a);
        parcel.writeParcelable(this.f5552b, 1);
    }
}
