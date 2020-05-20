package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class ActivateVendorPayRequestParams extends RequestParams {
    public static final Parcelable.Creator<ActivateVendorPayRequestParams> CREATOR = new Parcelable.Creator<ActivateVendorPayRequestParams>() { // from class: com.unionpay.tsmservice.request.ActivateVendorPayRequestParams.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ActivateVendorPayRequestParams createFromParcel(Parcel parcel) {
            return new ActivateVendorPayRequestParams(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ActivateVendorPayRequestParams[] newArray(int i) {
            return new ActivateVendorPayRequestParams[i];
        }
    };

    public ActivateVendorPayRequestParams() {
    }

    public ActivateVendorPayRequestParams(Parcel parcel) {
        super(parcel);
    }

    @Override // com.unionpay.tsmservice.request.RequestParams, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.unionpay.tsmservice.request.RequestParams, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }
}
