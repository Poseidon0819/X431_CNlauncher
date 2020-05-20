package com.baidu.mapapi.search.geocode;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.List;

/* loaded from: classes.dex */
public class ReverseGeoCodeResult extends SearchResult {
    public static final Parcelable.Creator<ReverseGeoCodeResult> CREATOR = new Parcelable.Creator<ReverseGeoCodeResult>() { // from class: com.baidu.mapapi.search.geocode.ReverseGeoCodeResult.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final ReverseGeoCodeResult createFromParcel(Parcel parcel) {
            return new ReverseGeoCodeResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final ReverseGeoCodeResult[] newArray(int i) {
            return new ReverseGeoCodeResult[i];
        }
    };

    /* renamed from: a */
    private String f5501a;

    /* renamed from: b */
    private String f5502b;

    /* renamed from: c */
    private AddressComponent f5503c;

    /* renamed from: d */
    private LatLng f5504d;

    /* renamed from: e */
    private int f5505e;

    /* renamed from: f */
    private List<PoiInfo> f5506f;

    /* renamed from: g */
    private String f5507g;

    /* renamed from: h */
    private List<PoiRegionsInfo> f5508h;

    /* loaded from: classes.dex */
    public static class AddressComponent implements Parcelable {
        public static final Parcelable.Creator<AddressComponent> CREATOR = new Parcelable.Creator<AddressComponent>() { // from class: com.baidu.mapapi.search.geocode.ReverseGeoCodeResult.AddressComponent.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final AddressComponent createFromParcel(Parcel parcel) {
                return new AddressComponent(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final AddressComponent[] newArray(int i) {
                return new AddressComponent[i];
            }
        };
        public int adcode;
        public String city;
        public int countryCode;
        public String countryName;
        public String direction;
        public String distance;
        public String district;
        public String province;
        public String street;
        public String streetNumber;
        public String town;

        public AddressComponent() {
        }

        protected AddressComponent(Parcel parcel) {
            this.streetNumber = parcel.readString();
            this.street = parcel.readString();
            this.town = parcel.readString();
            this.district = parcel.readString();
            this.city = parcel.readString();
            this.province = parcel.readString();
            this.countryName = parcel.readString();
            this.countryCode = parcel.readInt();
            this.adcode = parcel.readInt();
            this.direction = parcel.readString();
            this.distance = parcel.readString();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getDirection() {
            return this.direction;
        }

        public String getDistance() {
            return this.distance;
        }

        public String getTown() {
            return this.town;
        }

        public void setDirection(String str) {
            this.direction = str;
        }

        public void setDistance(String str) {
            this.distance = str;
        }

        public void setTown(String str) {
            this.town = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.streetNumber);
            parcel.writeString(this.street);
            parcel.writeString(this.town);
            parcel.writeString(this.district);
            parcel.writeString(this.city);
            parcel.writeString(this.province);
            parcel.writeString(this.countryName);
            parcel.writeInt(this.countryCode);
            parcel.writeInt(this.adcode);
            parcel.writeString(this.direction);
            parcel.writeString(this.distance);
        }
    }

    /* loaded from: classes.dex */
    public static class PoiRegionsInfo implements Parcelable {
        public static final Parcelable.Creator<PoiRegionsInfo> CREATOR = new Parcelable.Creator<PoiRegionsInfo>() { // from class: com.baidu.mapapi.search.geocode.ReverseGeoCodeResult.PoiRegionsInfo.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final PoiRegionsInfo createFromParcel(Parcel parcel) {
                return new PoiRegionsInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final PoiRegionsInfo[] newArray(int i) {
                return new PoiRegionsInfo[i];
            }
        };
        public String directionDesc;
        public String regionName;
        public String regionTag;

        public PoiRegionsInfo() {
        }

        protected PoiRegionsInfo(Parcel parcel) {
            this.directionDesc = parcel.readString();
            this.regionName = parcel.readString();
            this.regionTag = parcel.readString();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getDirectionDesc() {
            return this.directionDesc;
        }

        public String getRegionName() {
            return this.regionName;
        }

        public String getRegionTag() {
            return this.regionTag;
        }

        public void setDirectionDesc(String str) {
            this.directionDesc = str;
        }

        public void setRegionName(String str) {
            this.regionName = str;
        }

        public void setRegionTag(String str) {
            this.regionTag = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.directionDesc);
            parcel.writeString(this.regionName);
            parcel.writeString(this.regionTag);
        }
    }

    public ReverseGeoCodeResult() {
    }

    protected ReverseGeoCodeResult(Parcel parcel) {
        super(parcel);
        this.f5501a = parcel.readString();
        this.f5502b = parcel.readString();
        this.f5503c = (AddressComponent) parcel.readParcelable(AddressComponent.class.getClassLoader());
        this.f5504d = (LatLng) parcel.readValue(LatLng.class.getClassLoader());
        this.f5506f = parcel.createTypedArrayList(PoiInfo.CREATOR);
        this.f5507g = parcel.readString();
        this.f5508h = parcel.createTypedArrayList(PoiRegionsInfo.CREATOR);
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAdcode() {
        return this.f5503c.adcode;
    }

    public String getAddress() {
        return this.f5502b;
    }

    public AddressComponent getAddressDetail() {
        return this.f5503c;
    }

    public String getBusinessCircle() {
        return this.f5501a;
    }

    public int getCityCode() {
        return this.f5505e;
    }

    public LatLng getLocation() {
        return this.f5504d;
    }

    public List<PoiInfo> getPoiList() {
        return this.f5506f;
    }

    public List<PoiRegionsInfo> getPoiRegionsInfoList() {
        return this.f5508h;
    }

    public String getSematicDescription() {
        return this.f5507g;
    }

    public void setAdcode(int i) {
        this.f5503c.adcode = i;
    }

    public void setAddress(String str) {
        this.f5502b = str;
    }

    public void setAddressDetail(AddressComponent addressComponent) {
        this.f5503c = addressComponent;
    }

    public void setBusinessCircle(String str) {
        this.f5501a = str;
    }

    public void setCityCode(int i) {
        this.f5505e = i;
    }

    public void setLocation(LatLng latLng) {
        this.f5504d = latLng;
    }

    public void setPoiList(List<PoiInfo> list) {
        this.f5506f = list;
    }

    public void setPoiRegionsInfoList(List<PoiRegionsInfo> list) {
        this.f5508h = list;
    }

    public void setSematicDescription(String str) {
        this.f5507g = str;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("ReverseGeoCodeResult: \n");
        stringBuffer.append("businessCircle = ");
        stringBuffer.append(this.f5501a);
        stringBuffer.append("; address = ");
        stringBuffer.append(this.f5502b);
        stringBuffer.append("; location = ");
        stringBuffer.append(this.f5504d);
        stringBuffer.append("; sematicDescription = ");
        stringBuffer.append(this.f5507g);
        if (this.f5503c != null) {
            stringBuffer.append("\n#AddressComponent Info BEGIN# \n");
            stringBuffer.append("streetNumber = ");
            stringBuffer.append(this.f5503c.streetNumber);
            stringBuffer.append("; street = ");
            stringBuffer.append(this.f5503c.street);
            stringBuffer.append("; town = ");
            stringBuffer.append(this.f5503c.town);
            stringBuffer.append("; district = ");
            stringBuffer.append(this.f5503c.district);
            stringBuffer.append("; city = ");
            stringBuffer.append(this.f5503c.city);
            stringBuffer.append("; province = ");
            stringBuffer.append(this.f5503c.province);
            stringBuffer.append("; countryName = ");
            stringBuffer.append(this.f5503c.countryName);
            stringBuffer.append("; countryCode = ");
            stringBuffer.append(this.f5503c.countryCode);
            stringBuffer.append("; adcode = ");
            stringBuffer.append(this.f5503c.adcode);
            stringBuffer.append("; direction = ");
            stringBuffer.append(this.f5503c.direction);
            stringBuffer.append("; distance = ");
            stringBuffer.append(this.f5503c.distance);
            stringBuffer.append("\n#AddressComponent Info END# \n");
        }
        List<PoiRegionsInfo> list = this.f5508h;
        if (list != null && !list.isEmpty()) {
            stringBuffer.append("\n#PoiRegions Info  BEGIN#");
            for (int i = 0; i < this.f5508h.size(); i++) {
                PoiRegionsInfo poiRegionsInfo = this.f5508h.get(i);
                if (poiRegionsInfo != null) {
                    stringBuffer.append("\ndirectionDesc = ");
                    stringBuffer.append(poiRegionsInfo.getDirectionDesc());
                    stringBuffer.append("; regionName = ");
                    stringBuffer.append(poiRegionsInfo.getRegionName());
                    stringBuffer.append("; regionTag = ");
                    stringBuffer.append(poiRegionsInfo.getRegionTag());
                }
            }
            stringBuffer.append("\n#PoiRegions Info  END# \n");
        }
        List<PoiInfo> list2 = this.f5506f;
        if (list2 != null && !list2.isEmpty()) {
            stringBuffer.append("\n #PoiList Info  BEGIN#");
            for (int i2 = 0; i2 < this.f5506f.size(); i2++) {
                PoiInfo poiInfo = this.f5506f.get(i2);
                if (poiInfo != null) {
                    stringBuffer.append("\n address = ");
                    stringBuffer.append(poiInfo.getAddress());
                    stringBuffer.append("; phoneNumber = ");
                    stringBuffer.append(poiInfo.getPhoneNum());
                    stringBuffer.append("; uid = ");
                    stringBuffer.append(poiInfo.getUid());
                    stringBuffer.append("; postCode = ");
                    stringBuffer.append(poiInfo.getPostCode());
                    stringBuffer.append("; name = ");
                    stringBuffer.append(poiInfo.getName());
                    stringBuffer.append("; location = ");
                    stringBuffer.append(poiInfo.getLocation());
                    stringBuffer.append("; city = ");
                    stringBuffer.append(poiInfo.getCity());
                    stringBuffer.append("; direction = ");
                    stringBuffer.append(poiInfo.getDirection());
                    stringBuffer.append("; distance = ");
                    stringBuffer.append(poiInfo.getDistance());
                    if (poiInfo.getParentPoi() != null) {
                        stringBuffer.append("\n parentPoiAddress = ");
                        stringBuffer.append(poiInfo.getParentPoi().getParentPoiAddress());
                        stringBuffer.append("; parentPoiDirection = ");
                        stringBuffer.append(poiInfo.getParentPoi().getParentPoiDirection());
                        stringBuffer.append("; parentPoiDistance = ");
                        stringBuffer.append(poiInfo.getParentPoi().getParentPoiDistance());
                        stringBuffer.append("; parentPoiName = ");
                        stringBuffer.append(poiInfo.getParentPoi().getParentPoiName());
                        stringBuffer.append("; parentPoiTag = ");
                        stringBuffer.append(poiInfo.getParentPoi().getParentPoiTag());
                        stringBuffer.append("; parentPoiUid = ");
                        stringBuffer.append(poiInfo.getParentPoi().getParentPoiUid());
                        stringBuffer.append("; parentPoiLocation = ");
                        stringBuffer.append(poiInfo.getParentPoi().getParentPoiLocation());
                    }
                }
            }
            stringBuffer.append("\n #PoiList Info  END# \n");
        }
        return stringBuffer.toString();
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f5501a);
        parcel.writeString(this.f5502b);
        parcel.writeParcelable(this.f5503c, 0);
        parcel.writeValue(this.f5504d);
        parcel.writeTypedList(this.f5506f);
        parcel.writeString(this.f5507g);
        parcel.writeTypedList(this.f5508h);
    }
}
