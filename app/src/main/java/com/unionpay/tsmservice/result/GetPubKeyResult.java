package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class GetPubKeyResult implements Parcelable {
    public static final Parcelable.Creator<GetPubKeyResult> CREATOR = new Parcelable.Creator<GetPubKeyResult>() { // from class: com.unionpay.tsmservice.result.GetPubKeyResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GetPubKeyResult createFromParcel(Parcel parcel) {
            return new GetPubKeyResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
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
