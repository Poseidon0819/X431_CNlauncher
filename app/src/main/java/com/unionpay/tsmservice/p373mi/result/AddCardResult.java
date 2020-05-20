package com.unionpay.tsmservice.p373mi.result;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.unionpay.tsmservice.mi.result.AddCardResult */
/* loaded from: classes2.dex */
public class AddCardResult implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.unionpay.tsmservice.mi.result.AddCardResult.1
        @Override // android.os.Parcelable.Creator
        public final AddCardResult createFromParcel(Parcel parcel) {
            return new AddCardResult(parcel);
        }

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
