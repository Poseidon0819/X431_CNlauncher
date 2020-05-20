package com.unionpay.tsmservice.p373mi.result;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.unionpay.tsmservice.mi.result.VendorPayStatusResult */
/* loaded from: classes2.dex */
public class VendorPayStatusResult implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.unionpay.tsmservice.mi.result.VendorPayStatusResult.1
        @Override // android.os.Parcelable.Creator
        public final VendorPayStatusResult createFromParcel(Parcel parcel) {
            return new VendorPayStatusResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final VendorPayStatusResult[] newArray(int i) {
            return new VendorPayStatusResult[i];
        }
    };
    private Bundle mStatus;

    public VendorPayStatusResult() {
    }

    public VendorPayStatusResult(Parcel parcel) {
        this.mStatus = parcel.readBundle();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bundle getVendorPayStatusResult() {
        return this.mStatus;
    }

    public void setVendorPayStatusResult(Bundle bundle) {
        this.mStatus = bundle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.mStatus);
    }
}
