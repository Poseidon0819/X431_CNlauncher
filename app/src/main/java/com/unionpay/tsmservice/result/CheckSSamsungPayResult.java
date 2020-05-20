package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class CheckSSamsungPayResult implements Parcelable {
    public static final Parcelable.Creator<CheckSSamsungPayResult> CREATOR = new Parcelable.Creator<CheckSSamsungPayResult>() { // from class: com.unionpay.tsmservice.result.CheckSSamsungPayResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CheckSSamsungPayResult createFromParcel(Parcel parcel) {
            return new CheckSSamsungPayResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CheckSSamsungPayResult[] newArray(int i) {
            return new CheckSSamsungPayResult[i];
        }
    };

    public CheckSSamsungPayResult() {
    }

    public CheckSSamsungPayResult(Parcel parcel) {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
    }
}
