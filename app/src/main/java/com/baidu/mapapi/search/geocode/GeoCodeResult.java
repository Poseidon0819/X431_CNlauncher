package com.baidu.mapapi.search.geocode;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;

/* loaded from: classes.dex */
public class GeoCodeResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<GeoCodeResult> CREATOR = new Parcelable.Creator<GeoCodeResult>() { // from class: com.baidu.mapapi.search.geocode.GeoCodeResult.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final GeoCodeResult createFromParcel(Parcel parcel) {
            return new GeoCodeResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final GeoCodeResult[] newArray(int i) {
            return new GeoCodeResult[i];
        }
    };

    /* renamed from: a */
    private LatLng f5489a;

    /* renamed from: b */
    private String f5490b;

    /* renamed from: c */
    private int f5491c;

    /* renamed from: d */
    private int f5492d;

    /* renamed from: e */
    private String f5493e;

    public GeoCodeResult() {
    }

    protected GeoCodeResult(Parcel parcel) {
        this.f5489a = (LatLng) parcel.readValue(LatLng.class.getClassLoader());
        this.f5490b = parcel.readString();
        this.f5491c = parcel.readInt();
        this.f5492d = parcel.readInt();
        this.f5493e = parcel.readString();
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public String getAddress() {
        return this.f5490b;
    }

    public int getConfidence() {
        return this.f5492d;
    }

    public String getLevel() {
        return this.f5493e;
    }

    public LatLng getLocation() {
        return this.f5489a;
    }

    public int getPrecise() {
        return this.f5491c;
    }

    @Deprecated
    public void setAddress(String str) {
        this.f5490b = str;
    }

    public void setConfidence(int i) {
        this.f5492d = i;
    }

    public void setLevel(String str) {
        this.f5493e = str;
    }

    public void setLocation(LatLng latLng) {
        this.f5489a = latLng;
    }

    public void setPrecise(int i) {
        this.f5491c = i;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("GeoCodeResult: \n");
        stringBuffer.append("location = ");
        stringBuffer.append(this.f5489a);
        stringBuffer.append("; precise = ");
        stringBuffer.append(this.f5491c);
        stringBuffer.append("; confidence = ");
        stringBuffer.append(this.f5492d);
        stringBuffer.append("; level = ");
        stringBuffer.append(this.f5493e);
        return stringBuffer.toString();
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.f5489a);
        parcel.writeString(this.f5490b);
        parcel.writeInt(this.f5491c);
        parcel.writeInt(this.f5492d);
        parcel.writeString(this.f5493e);
    }
}
