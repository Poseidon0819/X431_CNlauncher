package com.unionpay.tsmservice.p373mi.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.unionpay.tsmservice.mi.request.OnlinePaymentVerifyRequestParams */
/* loaded from: classes2.dex */
public class OnlinePaymentVerifyRequestParams extends RequestParams {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.unionpay.tsmservice.mi.request.OnlinePaymentVerifyRequestParams.1
        @Override // android.os.Parcelable.Creator
        public final OnlinePaymentVerifyRequestParams createFromParcel(Parcel parcel) {
            return new OnlinePaymentVerifyRequestParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final OnlinePaymentVerifyRequestParams[] newArray(int i) {
            return new OnlinePaymentVerifyRequestParams[i];
        }
    };
    private Bundle mParams;

    public OnlinePaymentVerifyRequestParams() {
    }

    public OnlinePaymentVerifyRequestParams(Parcel parcel) {
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
