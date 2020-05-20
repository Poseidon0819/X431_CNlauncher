package com.baidu.mapapi.search.poi;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.PoiDetailInfo;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.List;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* loaded from: classes.dex */
public class PoiDetailSearchResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<PoiDetailSearchResult> CREATOR = new Parcelable.Creator<PoiDetailSearchResult>() { // from class: com.baidu.mapapi.search.poi.PoiDetailSearchResult.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final PoiDetailSearchResult createFromParcel(Parcel parcel) {
            return new PoiDetailSearchResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final PoiDetailSearchResult[] newArray(int i) {
            return new PoiDetailSearchResult[i];
        }
    };

    /* renamed from: a */
    private List<PoiDetailInfo> f5513a;

    public PoiDetailSearchResult() {
    }

    protected PoiDetailSearchResult(Parcel parcel) {
        super(parcel);
        this.f5513a = parcel.createTypedArrayList(PoiDetailInfo.CREATOR);
    }

    public PoiDetailSearchResult(SearchResult.ERRORNO errorno) {
        super(errorno);
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<PoiDetailInfo> getPoiDetailInfoList() {
        return this.f5513a;
    }

    public void setPoiDetailInfoList(List<PoiDetailInfo> list) {
        this.f5513a = list;
    }

    public String toString() {
        List<PoiDetailInfo> list = this.f5513a;
        if (list == null || list.isEmpty()) {
            return "PoiDetailSearchResult is null";
        }
        StringBuffer stringBuffer = new StringBuffer("PoiDetailSearchResult:");
        for (int i = 0; i < this.f5513a.size(); i++) {
            stringBuffer.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            stringBuffer.append(i);
            stringBuffer.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            PoiDetailInfo poiDetailInfo = this.f5513a.get(i);
            stringBuffer.append(poiDetailInfo != null ? poiDetailInfo.toString() : "null");
        }
        return stringBuffer.toString();
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.f5513a);
    }
}
