package com.unionpay.tsmservice.p373mi.request;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.unionpay.tsmservice.mi.request.GetSeIdRequestParams */
/* loaded from: classes2.dex */
public class GetSeIdRequestParams extends RequestParams {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.unionpay.tsmservice.mi.request.GetSeIdRequestParams.1
        @Override // android.os.Parcelable.Creator
        public final GetSeIdRequestParams createFromParcel(Parcel parcel) {
            return new GetSeIdRequestParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final GetSeIdRequestParams[] newArray(int i) {
            return new GetSeIdRequestParams[i];
        }
    };

    public GetSeIdRequestParams() {
    }

    public GetSeIdRequestParams(Parcel parcel) {
        super(parcel);
    }

    @Override // com.unionpay.tsmservice.p373mi.request.RequestParams, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.unionpay.tsmservice.p373mi.request.RequestParams, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }
}
