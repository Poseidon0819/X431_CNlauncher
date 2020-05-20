package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class GetDefaultCardRequestParams extends RequestParams {
    public static final Parcelable.Creator<GetDefaultCardRequestParams> CREATOR = new Parcelable.Creator<GetDefaultCardRequestParams>() { // from class: com.unionpay.tsmservice.request.GetDefaultCardRequestParams.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GetDefaultCardRequestParams createFromParcel(Parcel parcel) {
            return new GetDefaultCardRequestParams(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GetDefaultCardRequestParams[] newArray(int i) {
            return new GetDefaultCardRequestParams[i];
        }
    };

    public GetDefaultCardRequestParams() {
    }

    public GetDefaultCardRequestParams(Parcel parcel) {
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
