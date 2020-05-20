package com.unionpay.tsmservice.p373mi.request;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.unionpay.tsmservice.mi.request.ExchangeKeyRequestParams */
/* loaded from: classes2.dex */
public class ExchangeKeyRequestParams extends RequestParams {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.unionpay.tsmservice.mi.request.ExchangeKeyRequestParams.1
        @Override // android.os.Parcelable.Creator
        public final ExchangeKeyRequestParams createFromParcel(Parcel parcel) {
            return new ExchangeKeyRequestParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final ExchangeKeyRequestParams[] newArray(int i) {
            return new ExchangeKeyRequestParams[i];
        }
    };
    private String mTempKey;
    private int mType;

    public ExchangeKeyRequestParams() {
    }

    public ExchangeKeyRequestParams(Parcel parcel) {
        super(parcel);
        this.mType = parcel.readInt();
        this.mTempKey = parcel.readString();
    }

    public String getTempKey() {
        return this.mTempKey;
    }

    public int getType() {
        return this.mType;
    }

    public void setTempKey(String str) {
        this.mTempKey = str;
    }

    public void setType(int i) {
        this.mType = i;
    }

    @Override // com.unionpay.tsmservice.p373mi.request.RequestParams, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.mType);
        parcel.writeString(this.mTempKey);
    }
}
