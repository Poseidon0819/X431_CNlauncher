package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;

/* loaded from: classes.dex */
public class TransitResultNode implements Parcelable {
    public static final Parcelable.Creator<TransitResultNode> CREATOR = new Parcelable.Creator<TransitResultNode>() { // from class: com.baidu.mapapi.search.core.TransitResultNode.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final TransitResultNode createFromParcel(Parcel parcel) {
            return new TransitResultNode(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final TransitResultNode[] newArray(int i) {
            return new TransitResultNode[i];
        }
    };

    /* renamed from: a */
    private int f5478a;

    /* renamed from: b */
    private String f5479b;

    /* renamed from: c */
    private LatLng f5480c;

    /* renamed from: d */
    private String f5481d;

    public TransitResultNode(int i, String str, LatLng latLng, String str2) {
        this.f5479b = null;
        this.f5480c = null;
        this.f5481d = null;
        this.f5478a = i;
        this.f5479b = str;
        this.f5480c = latLng;
        this.f5481d = str2;
    }

    protected TransitResultNode(Parcel parcel) {
        this.f5479b = null;
        this.f5480c = null;
        this.f5481d = null;
        this.f5478a = parcel.readInt();
        this.f5479b = parcel.readString();
        this.f5480c = (LatLng) parcel.readValue(LatLng.class.getClassLoader());
        this.f5481d = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCityId() {
        return this.f5478a;
    }

    public String getCityName() {
        return this.f5479b;
    }

    public LatLng getLocation() {
        return this.f5480c;
    }

    public String getSearchWord() {
        return this.f5481d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f5478a);
        parcel.writeString(this.f5479b);
        parcel.writeValue(this.f5480c);
        parcel.writeString(this.f5481d);
    }
}
