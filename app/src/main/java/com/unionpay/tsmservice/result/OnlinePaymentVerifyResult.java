package com.unionpay.tsmservice.result;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class OnlinePaymentVerifyResult implements Parcelable {
    public static final Parcelable.Creator<OnlinePaymentVerifyResult> CREATOR = new Parcelable.Creator<OnlinePaymentVerifyResult>() { // from class: com.unionpay.tsmservice.result.OnlinePaymentVerifyResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OnlinePaymentVerifyResult createFromParcel(Parcel parcel) {
            return new OnlinePaymentVerifyResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OnlinePaymentVerifyResult[] newArray(int i) {
            return new OnlinePaymentVerifyResult[i];
        }
    };
    private Bundle mResultData;

    public OnlinePaymentVerifyResult() {
    }

    public OnlinePaymentVerifyResult(Parcel parcel) {
        this.mResultData = parcel.readBundle();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bundle getResultData() {
        return this.mResultData;
    }

    public void setResultData(Bundle bundle) {
        this.mResultData = bundle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.mResultData);
    }
}
