package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class SetSamsungDefWalletRequestParams extends RequestParams {
    public static final Parcelable.Creator<SetSamsungDefWalletRequestParams> CREATOR = new Parcelable.Creator<SetSamsungDefWalletRequestParams>() { // from class: com.unionpay.tsmservice.request.SetSamsungDefWalletRequestParams.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SetSamsungDefWalletRequestParams createFromParcel(Parcel parcel) {
            return new SetSamsungDefWalletRequestParams(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SetSamsungDefWalletRequestParams[] newArray(int i) {
            return new SetSamsungDefWalletRequestParams[i];
        }
    };

    public SetSamsungDefWalletRequestParams() {
    }

    public SetSamsungDefWalletRequestParams(Parcel parcel) {
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
