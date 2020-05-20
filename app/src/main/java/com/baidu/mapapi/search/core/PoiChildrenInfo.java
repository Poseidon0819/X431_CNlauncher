package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;

/* loaded from: classes.dex */
public class PoiChildrenInfo implements Parcelable {
    public static final Parcelable.Creator<PoiChildrenInfo> CREATOR = new Parcelable.Creator<PoiChildrenInfo>() { // from class: com.baidu.mapapi.search.core.PoiChildrenInfo.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final PoiChildrenInfo createFromParcel(Parcel parcel) {
            return new PoiChildrenInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final PoiChildrenInfo[] newArray(int i) {
            return new PoiChildrenInfo[i];
        }
    };
    private String address;
    private LatLng location;
    private String name;
    private String showName;
    private String tag;
    private String uid;

    public PoiChildrenInfo() {
    }

    protected PoiChildrenInfo(Parcel parcel) {
        this.uid = parcel.readString();
        this.name = parcel.readString();
        this.showName = parcel.readString();
        this.tag = parcel.readString();
        this.location = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.address = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.address;
    }

    public LatLng getLocation() {
        return this.location;
    }

    public String getName() {
        return this.name;
    }

    public String getShowName() {
        return this.showName;
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

    public void setLocation(LatLng latLng) {
        this.location = latLng;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setShowName(String str) {
        this.showName = str;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("PoiChildrenInfo: ");
        stringBuffer.append("uid = ");
        stringBuffer.append(this.uid);
        stringBuffer.append("; name = ");
        stringBuffer.append(this.name);
        stringBuffer.append("; showName = ");
        stringBuffer.append(this.showName);
        stringBuffer.append("; tag = ");
        stringBuffer.append(this.tag);
        stringBuffer.append("; location = ");
        LatLng latLng = this.location;
        stringBuffer.append(latLng != null ? latLng.toString() : "null");
        stringBuffer.append("; address = ");
        stringBuffer.append(this.address);
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.uid);
        parcel.writeString(this.name);
        parcel.writeString(this.showName);
        parcel.writeString(this.tag);
        parcel.writeParcelable(this.location, i);
        parcel.writeString(this.address);
    }
}
