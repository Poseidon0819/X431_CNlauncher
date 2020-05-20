package com.unionpay.tsmservice.result;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class AddCardResult implements Parcelable {
    public static final Parcelable.Creator<AddCardResult> CREATOR = new Parcelable.Creator<AddCardResult>() { // from class: com.unionpay.tsmservice.result.AddCardResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AddCardResult createFromParcel(Parcel parcel) {
            return new AddCardResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AddCardResult[] newArray(int i) {
            return new AddCardResult[i];
        }
    };
    private Bundle mBankCardInfo;

    public AddCardResult() {
    }

    public AddCardResult(Parcel parcel) {
        this.mBankCardInfo = parcel.readBundle();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bundle getBankCardInfo() {
        return this.mBankCardInfo;
    }

    public void setBankCardInfo(Bundle bundle) {
        this.mBankCardInfo = bundle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.mBankCardInfo);
    }
}
