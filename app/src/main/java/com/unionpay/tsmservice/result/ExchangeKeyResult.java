package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class ExchangeKeyResult implements Parcelable {
    public static final Parcelable.Creator<ExchangeKeyResult> CREATOR = new Parcelable.Creator<ExchangeKeyResult>() { // from class: com.unionpay.tsmservice.result.ExchangeKeyResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ExchangeKeyResult createFromParcel(Parcel parcel) {
            return new ExchangeKeyResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ExchangeKeyResult[] newArray(int i) {
            return new ExchangeKeyResult[i];
        }
    };
    private String key;

    public ExchangeKeyResult() {
    }

    public ExchangeKeyResult(Parcel parcel) {
        this.key = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.key);
    }
}
