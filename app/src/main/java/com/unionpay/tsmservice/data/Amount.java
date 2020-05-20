package com.unionpay.tsmservice.data;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class Amount implements Parcelable {
    public static final Parcelable.Creator<Amount> CREATOR = new Parcelable.Creator<Amount>() { // from class: com.unionpay.tsmservice.data.Amount.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Amount createFromParcel(Parcel parcel) {
            return new Amount(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Amount[] newArray(int i) {
            return new Amount[i];
        }
    };
    private String mCurrencyType;
    private String mProductPrice;

    public Amount() {
        this.mCurrencyType = Constant.KEY_CURRENCYTYPE_CNY;
        this.mProductPrice = "0.0";
    }

    public Amount(Parcel parcel) {
        this.mCurrencyType = Constant.KEY_CURRENCYTYPE_CNY;
        this.mProductPrice = "0.0";
        this.mCurrencyType = parcel.readString();
        this.mProductPrice = parcel.readString();
    }

    public Amount(String str, String str2) {
        this.mCurrencyType = Constant.KEY_CURRENCYTYPE_CNY;
        this.mProductPrice = "0.0";
        this.mCurrencyType = str;
        this.mProductPrice = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCurrencyType() {
        return this.mCurrencyType;
    }

    public String getProductPrice() {
        return this.mProductPrice;
    }

    public void setCurrencyType(String str) {
        this.mCurrencyType = str;
    }

    public void setProductPrice(String str) {
        this.mProductPrice = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mCurrencyType);
        parcel.writeString(this.mProductPrice);
    }
}
