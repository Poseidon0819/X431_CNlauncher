package com.unionpay.tsmservice.p373mi.result;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.unionpay.tsmservice.mi.result.GetPubKeyResult */
/* loaded from: classes2.dex */
public class GetPubKeyResult implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.unionpay.tsmservice.mi.result.GetPubKeyResult.1
        @Override // android.os.Parcelable.Creator
        public final GetPubKeyResult createFromParcel(Parcel parcel) {
            return new GetPubKeyResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final GetPubKeyResult[] newArray(int i) {
            return new GetPubKeyResult[i];
        }
    };
    private String key;

    public GetPubKeyResult() {
    }

    public GetPubKeyResult(Parcel parcel) {
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
