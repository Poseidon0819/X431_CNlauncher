package com.baidu.mapsdkplatform.comjni.tools;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class ParcelItem implements Parcelable {
    public static final Parcelable.Creator<ParcelItem> CREATOR = new Parcelable.Creator<ParcelItem>() { // from class: com.baidu.mapsdkplatform.comjni.tools.ParcelItem.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final ParcelItem createFromParcel(Parcel parcel) {
            ParcelItem parcelItem = new ParcelItem();
            parcelItem.setBundle(parcel.readBundle());
            return parcelItem;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final ParcelItem[] newArray(int i) {
            return new ParcelItem[i];
        }
    };

    /* renamed from: a */
    private Bundle f6445a;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bundle getBundle() {
        return this.f6445a;
    }

    public void setBundle(Bundle bundle) {
        this.f6445a = bundle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.f6445a);
    }
}
