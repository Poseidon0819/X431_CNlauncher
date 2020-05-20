package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class GetCurrentWalletClientRequestParams extends RequestParams {
    public static final Parcelable.Creator<GetCurrentWalletClientRequestParams> CREATOR = new Parcelable.Creator<GetCurrentWalletClientRequestParams>() { // from class: com.unionpay.tsmservice.request.GetCurrentWalletClientRequestParams.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GetCurrentWalletClientRequestParams createFromParcel(Parcel parcel) {
            return new GetCurrentWalletClientRequestParams(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GetCurrentWalletClientRequestParams[] newArray(int i) {
            return new GetCurrentWalletClientRequestParams[i];
        }
    };

    public GetCurrentWalletClientRequestParams() {
    }

    public GetCurrentWalletClientRequestParams(Parcel parcel) {
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
