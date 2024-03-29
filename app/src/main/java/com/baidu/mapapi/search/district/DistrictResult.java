package com.baidu.mapapi.search.district;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DistrictResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<DistrictResult> CREATOR = new Parcelable.Creator<DistrictResult>() { // from class: com.baidu.mapapi.search.district.DistrictResult.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final DistrictResult createFromParcel(Parcel parcel) {
            return new DistrictResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final DistrictResult[] newArray(int i) {
            return new DistrictResult[i];
        }
    };
    public LatLng centerPt;
    public int cityCode;
    public String cityName;
    public List<List<LatLng>> polylines;

    public DistrictResult() {
        this.centerPt = null;
        this.polylines = null;
        this.cityName = null;
    }

    protected DistrictResult(Parcel parcel) {
        super(parcel);
        this.centerPt = null;
        this.polylines = null;
        this.cityName = null;
        this.centerPt = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.polylines = new ArrayList();
            for (int i = 0; i < readInt; i++) {
                this.polylines.add(parcel.createTypedArrayList(LatLng.CREATOR));
            }
        }
        this.cityCode = parcel.readInt();
        this.cityName = parcel.readString();
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLng getCenterPt() {
        return this.centerPt;
    }

    public int getCityCode() {
        return this.cityCode;
    }

    public String getCityName() {
        return this.cityName;
    }

    public List<List<LatLng>> getPolylines() {
        return this.polylines;
    }

    public void setCenterPt(LatLng latLng) {
        this.centerPt = latLng;
    }

    public void setCityCode(int i) {
        this.cityCode = i;
    }

    public void setCityName(String str) {
        this.cityName = str;
    }

    public void setPolylines(List<List<LatLng>> list) {
        this.polylines = list;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.centerPt, i);
        List<List<LatLng>> list = this.polylines;
        parcel.writeInt(list == null ? 0 : list.size());
        for (List<LatLng> list2 : this.polylines) {
            parcel.writeTypedList(list2);
        }
        parcel.writeInt(this.cityCode);
        parcel.writeString(this.cityName);
    }
}
