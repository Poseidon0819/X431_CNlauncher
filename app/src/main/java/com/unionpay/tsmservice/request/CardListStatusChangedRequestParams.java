package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class CardListStatusChangedRequestParams extends RequestParams {
    public static final Parcelable.Creator<CardListStatusChangedRequestParams> CREATOR = new Parcelable.Creator<CardListStatusChangedRequestParams>() { // from class: com.unionpay.tsmservice.request.CardListStatusChangedRequestParams.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CardListStatusChangedRequestParams createFromParcel(Parcel parcel) {
            return new CardListStatusChangedRequestParams(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CardListStatusChangedRequestParams[] newArray(int i) {
            return new CardListStatusChangedRequestParams[i];
        }
    };

    public CardListStatusChangedRequestParams() {
    }

    public CardListStatusChangedRequestParams(Parcel parcel) {
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
