package com.baidu.mapapi.search.sug;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiChildrenInfo;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* loaded from: classes.dex */
public class SuggestionResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<SuggestionResult> CREATOR = new Parcelable.Creator<SuggestionResult>() { // from class: com.baidu.mapapi.search.sug.SuggestionResult.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final SuggestionResult createFromParcel(Parcel parcel) {
            return new SuggestionResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final SuggestionResult[] newArray(int i) {
            return new SuggestionResult[i];
        }
    };
    private ArrayList<SuggestionInfo> suggestionList;

    /* loaded from: classes.dex */
    public static class SuggestionInfo implements Parcelable {
        public static final Parcelable.Creator<SuggestionInfo> CREATOR = new Parcelable.Creator<SuggestionInfo>() { // from class: com.baidu.mapapi.search.sug.SuggestionResult.SuggestionInfo.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final SuggestionInfo createFromParcel(Parcel parcel) {
                return new SuggestionInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final SuggestionInfo[] newArray(int i) {
                return new SuggestionInfo[i];
            }
        };
        public String address;
        public String city;
        public String district;
        public String key;
        public List<PoiChildrenInfo> poiChildrenInfoList;

        /* renamed from: pt */
        public LatLng f5657pt;
        public String tag;
        public String uid;

        public SuggestionInfo() {
        }

        protected SuggestionInfo(Parcel parcel) {
            this.key = parcel.readString();
            this.city = parcel.readString();
            this.district = parcel.readString();
            this.f5657pt = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            this.uid = parcel.readString();
            this.tag = parcel.readString();
            this.address = parcel.readString();
            this.poiChildrenInfoList = parcel.createTypedArrayList(PoiChildrenInfo.CREATOR);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getAddress() {
            return this.address;
        }

        public String getCity() {
            return this.city;
        }

        public String getDistrict() {
            return this.district;
        }

        public String getKey() {
            return this.key;
        }

        public List<PoiChildrenInfo> getPoiChildrenInfoList() {
            return this.poiChildrenInfoList;
        }

        public LatLng getPt() {
            return this.f5657pt;
        }

        public String getTag() {
            return this.tag;
        }

        public String getUid() {
            return this.uid;
        }

        public void setAddress(String str) {
            this.address = str;
        }

        public void setCity(String str) {
            this.city = str;
        }

        public void setDistrict(String str) {
            this.district = str;
        }

        public void setKey(String str) {
            this.key = str;
        }

        public void setPoiChildrenInfoList(List<PoiChildrenInfo> list) {
            this.poiChildrenInfoList = list;
        }

        public void setPt(LatLng latLng) {
            this.f5657pt = latLng;
        }

        public void setTag(String str) {
            this.tag = str;
        }

        public void setUid(String str) {
            this.uid = str;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("SuggestionInfo: ");
            stringBuffer.append("key = ");
            stringBuffer.append(this.key);
            stringBuffer.append("; city = ");
            stringBuffer.append(this.city);
            stringBuffer.append("; district = ");
            stringBuffer.append(this.district);
            stringBuffer.append("; pt = ");
            LatLng latLng = this.f5657pt;
            stringBuffer.append(latLng != null ? latLng.toString() : "null");
            stringBuffer.append("; uid = ");
            stringBuffer.append(this.uid);
            stringBuffer.append("; tag = ");
            stringBuffer.append(this.tag);
            stringBuffer.append("; address = ");
            stringBuffer.append(this.address);
            stringBuffer.append("; childrenInfo = ");
            List<PoiChildrenInfo> list = this.poiChildrenInfoList;
            if (list == null || list.isEmpty()) {
                stringBuffer.append("null");
            } else {
                for (int i = 0; i < this.poiChildrenInfoList.size(); i++) {
                    stringBuffer.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                    stringBuffer.append(i);
                    stringBuffer.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                    PoiChildrenInfo poiChildrenInfo = this.poiChildrenInfoList.get(i);
                    stringBuffer.append(poiChildrenInfo == null ? "null" : poiChildrenInfo.toString());
                }
            }
            return stringBuffer.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.key);
            parcel.writeString(this.city);
            parcel.writeString(this.district);
            parcel.writeParcelable(this.f5657pt, i);
            parcel.writeString(this.uid);
            parcel.writeString(this.tag);
            parcel.writeString(this.address);
            parcel.writeTypedList(this.poiChildrenInfoList);
        }
    }

    public SuggestionResult() {
    }

    protected SuggestionResult(Parcel parcel) {
        this.suggestionList = parcel.readArrayList(SuggestionInfo.class.getClassLoader());
    }

    public SuggestionResult(SearchResult.ERRORNO errorno) {
        super(errorno);
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<SuggestionInfo> getAllSuggestions() {
        return this.suggestionList;
    }

    public void setSuggestionInfo(ArrayList<SuggestionInfo> arrayList) {
        this.suggestionList = arrayList;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.suggestionList);
    }
}
