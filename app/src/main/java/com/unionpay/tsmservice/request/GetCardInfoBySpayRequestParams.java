package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.unionpay.tsmservice.data.Amount;

/* loaded from: classes2.dex */
public class GetCardInfoBySpayRequestParams extends RequestParams {
    public static final Parcelable.Creator<GetCardInfoBySpayRequestParams> CREATOR = new Parcelable.Creator<GetCardInfoBySpayRequestParams>() { // from class: com.unionpay.tsmservice.request.GetCardInfoBySpayRequestParams.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GetCardInfoBySpayRequestParams createFromParcel(Parcel parcel) {
            return new GetCardInfoBySpayRequestParams(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GetCardInfoBySpayRequestParams[] newArray(int i) {
            return new GetCardInfoBySpayRequestParams[i];
        }
    };
    private Amount mAmount;

    public GetCardInfoBySpayRequestParams() {
    }

    public GetCardInfoBySpayRequestParams(Parcel parcel) {
        super(parcel);
        this.mAmount = (Amount) parcel.readParcelable(Amount.class.getClassLoader());
    }

    public Amount getAmount() {
        return this.mAmount;
    }

    public void setAmount(Amount amount) {
        this.mAmount = amount;
    }

    @Override // com.unionpay.tsmservice.request.RequestParams, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.mAmount, i);
    }
}
