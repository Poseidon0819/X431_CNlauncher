package com.unionpay.tsmservice.result;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class VendorPayStatusResult implements Parcelable {
    public static final Parcelable.Creator<VendorPayStatusResult> CREATOR = new Parcelable.Creator<VendorPayStatusResult>() { // from class: com.unionpay.tsmservice.result.VendorPayStatusResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VendorPayStatusResult createFromParcel(Parcel parcel) {
            return new VendorPayStatusResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
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
