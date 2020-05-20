package com.unionpay.tsmservice.result;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class UniteResult implements Parcelable {
    public static final Parcelable.Creator<UniteResult> CREATOR = new Parcelable.Creator<UniteResult>() { // from class: com.unionpay.tsmservice.result.UniteResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final UniteResult createFromParcel(Parcel parcel) {
            return new UniteResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final UniteResult[] newArray(int i) {
            return new UniteResult[i];
        }
    };
    Bundle mResult;

    public UniteResult() {
    }

    public UniteResult(Parcel parcel) {
        this.mResult = parcel.readBundle();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bundle getResultData() {
        return this.mResult;
    }

    public void setResult(Bundle bundle) {
        this.mResult = bundle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.mResult);
    }
}
