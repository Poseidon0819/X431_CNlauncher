package com.unionpay.tsmservice.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class GetTransactionDetailsRequestParams extends RequestParams {
    public static final Parcelable.Creator<GetTransactionDetailsRequestParams> CREATOR = new Parcelable.Creator<GetTransactionDetailsRequestParams>() { // from class: com.unionpay.tsmservice.request.GetTransactionDetailsRequestParams.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GetTransactionDetailsRequestParams createFromParcel(Parcel parcel) {
            return new GetTransactionDetailsRequestParams(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GetTransactionDetailsRequestParams[] newArray(int i) {
            return new GetTransactionDetailsRequestParams[i];
        }
    };
    private Bundle mParams;

    public GetTransactionDetailsRequestParams() {
    }

    public GetTransactionDetailsRequestParams(Parcel parcel) {
        super(parcel);
        this.mParams = parcel.readBundle();
    }

    @Override // com.unionpay.tsmservice.request.RequestParams, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bundle getParams() {
        return this.mParams;
    }

    public void setParams(Bundle bundle) {
        this.mParams = bundle;
    }

    @Override // com.unionpay.tsmservice.request.RequestParams, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeBundle(this.mParams);
    }
}
