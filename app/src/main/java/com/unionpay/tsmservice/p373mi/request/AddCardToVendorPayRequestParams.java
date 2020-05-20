package com.unionpay.tsmservice.p373mi.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.unionpay.tsmservice.mi.request.AddCardToVendorPayRequestParams */
/* loaded from: classes2.dex */
public class AddCardToVendorPayRequestParams extends RequestParams {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.unionpay.tsmservice.mi.request.AddCardToVendorPayRequestParams.1
        @Override // android.os.Parcelable.Creator
        public final AddCardToVendorPayRequestParams createFromParcel(Parcel parcel) {
            return new AddCardToVendorPayRequestParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final AddCardToVendorPayRequestParams[] newArray(int i) {
            return new AddCardToVendorPayRequestParams[i];
        }
    };
    private Bundle mParams;

    public AddCardToVendorPayRequestParams() {
    }

    public AddCardToVendorPayRequestParams(Parcel parcel) {
        super(parcel);
        this.mParams = parcel.readBundle();
    }

    @Override // com.unionpay.tsmservice.p373mi.request.RequestParams, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bundle getParams() {
        return this.mParams;
    }

    public void setParams(Bundle bundle) {
        this.mParams = bundle;
    }

    @Override // com.unionpay.tsmservice.p373mi.request.RequestParams, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeBundle(this.mParams);
    }
}
