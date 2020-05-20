package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.List;

/* loaded from: classes.dex */
public class IndoorRouteResult extends SearchResult {
    public static final Parcelable.Creator<IndoorRouteResult> CREATOR = new Parcelable.Creator<IndoorRouteResult>() { // from class: com.baidu.mapapi.search.route.IndoorRouteResult.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final IndoorRouteResult createFromParcel(Parcel parcel) {
            return new IndoorRouteResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final IndoorRouteResult[] newArray(int i) {
            return new IndoorRouteResult[i];
        }
    };

    /* renamed from: a */
    private List<IndoorRouteLine> f5588a;

    public IndoorRouteResult() {
    }

    protected IndoorRouteResult(Parcel parcel) {
        super(parcel);
        this.f5588a = parcel.createTypedArrayList(IndoorRouteLine.CREATOR);
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<IndoorRouteLine> getRouteLines() {
        return this.f5588a;
    }

    public void setRouteLines(List<IndoorRouteLine> list) {
        this.f5588a = list;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.f5588a);
    }
}
