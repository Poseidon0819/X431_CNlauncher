package com.unionpay.tsmservice.p373mi.result;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.unionpay.tsmservice.mi.result.GetSeIdResult */
/* loaded from: classes2.dex */
public class GetSeIdResult implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.unionpay.tsmservice.mi.result.GetSeIdResult.1
        @Override // android.os.Parcelable.Creator
        public final GetSeIdResult createFromParcel(Parcel parcel) {
            return new GetSeIdResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final GetSeIdResult[] newArray(int i) {
            return new GetSeIdResult[i];
        }
    };
    private String mSeId;

    public GetSeIdResult() {
    }

    public GetSeIdResult(Parcel parcel) {
        this.mSeId = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getSeId() {
        return this.mSeId;
    }

    public void setSeId(String str) {
        this.mSeId = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mSeId);
    }
}
