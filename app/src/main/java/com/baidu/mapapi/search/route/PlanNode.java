package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;

/* loaded from: classes.dex */
public class PlanNode implements Parcelable {
    public static final Parcelable.Creator<PlanNode> CREATOR = new Parcelable.Creator<PlanNode>() { // from class: com.baidu.mapapi.search.route.PlanNode.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final PlanNode createFromParcel(Parcel parcel) {
            return new PlanNode(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final PlanNode[] newArray(int i) {
            return new PlanNode[i];
        }
    };

    /* renamed from: a */
    private LatLng f5618a;

    /* renamed from: b */
    private String f5619b;

    /* renamed from: c */
    private String f5620c;

    protected PlanNode(Parcel parcel) {
        this.f5618a = null;
        this.f5619b = null;
        this.f5620c = null;
        this.f5618a = (LatLng) parcel.readValue(LatLng.class.getClassLoader());
        this.f5619b = parcel.readString();
        this.f5620c = parcel.readString();
    }

    PlanNode(LatLng latLng, String str, String str2) {
        this.f5618a = null;
        this.f5619b = null;
        this.f5620c = null;
        this.f5618a = latLng;
        this.f5619b = str;
        this.f5620c = str2;
    }

    public static PlanNode withCityCodeAndPlaceName(int i, String str) {
        return new PlanNode(null, String.valueOf(i), str);
    }

    public static PlanNode withCityNameAndPlaceName(String str, String str2) {
        return new PlanNode(null, str, str2);
    }

    public static PlanNode withLocation(LatLng latLng) {
        return new PlanNode(latLng, null, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCity() {
        return this.f5619b;
    }

    public LatLng getLocation() {
        return this.f5618a;
    }

    public String getName() {
        return this.f5620c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.f5618a);
        parcel.writeString(this.f5619b);
        parcel.writeString(this.f5620c);
    }
}
