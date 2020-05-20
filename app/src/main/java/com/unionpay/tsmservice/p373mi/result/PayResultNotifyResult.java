package com.unionpay.tsmservice.p373mi.result;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.unionpay.tsmservice.mi.result.PayResultNotifyResult */
/* loaded from: classes2.dex */
public class PayResultNotifyResult implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.unionpay.tsmservice.mi.result.PayResultNotifyResult.1
        @Override // android.os.Parcelable.Creator
        public final PayResultNotifyResult createFromParcel(Parcel parcel) {
            return new PayResultNotifyResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final PayResultNotifyResult[] newArray(int i) {
            return new PayResultNotifyResult[i];
        }
    };
    private Bundle mResultData;

    public PayResultNotifyResult() {
    }

    public PayResultNotifyResult(Parcel parcel) {
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
