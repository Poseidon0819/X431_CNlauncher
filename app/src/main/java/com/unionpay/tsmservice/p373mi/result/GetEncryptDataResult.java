package com.unionpay.tsmservice.p373mi.result;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.unionpay.tsmservice.mi.result.GetEncryptDataResult */
/* loaded from: classes2.dex */
public class GetEncryptDataResult implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.unionpay.tsmservice.mi.result.GetEncryptDataResult.1
        @Override // android.os.Parcelable.Creator
        public final GetEncryptDataResult createFromParcel(Parcel parcel) {
            return new GetEncryptDataResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final GetEncryptDataResult[] newArray(int i) {
            return new GetEncryptDataResult[i];
        }
    };
    private String mData;

    public GetEncryptDataResult() {
    }

    public GetEncryptDataResult(Parcel parcel) {
        this.mData = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getData() {
        return this.mData;
    }

    public void setData(String str) {
        this.mData = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mData);
    }
}
