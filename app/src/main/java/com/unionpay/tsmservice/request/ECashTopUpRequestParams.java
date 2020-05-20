package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.unionpay.tsmservice.AppID;

/* loaded from: classes2.dex */
public class ECashTopUpRequestParams extends RequestParams {
    public static final Parcelable.Creator<ECashTopUpRequestParams> CREATOR = new Parcelable.Creator<ECashTopUpRequestParams>() { // from class: com.unionpay.tsmservice.request.ECashTopUpRequestParams.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ECashTopUpRequestParams createFromParcel(Parcel parcel) {
            return new ECashTopUpRequestParams(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ECashTopUpRequestParams[] newArray(int i) {
            return new ECashTopUpRequestParams[i];
        }
    };
    private String mAmount;
    private AppID mAppID;
    private String mEncrpytPin;
    private String mType;

    public ECashTopUpRequestParams() {
        this.mType = "0";
    }

    public ECashTopUpRequestParams(Parcel parcel) {
        super(parcel);
        this.mType = "0";
        this.mAppID = (AppID) parcel.readParcelable(AppID.class.getClassLoader());
        this.mType = parcel.readString();
        this.mAmount = parcel.readString();
        this.mEncrpytPin = parcel.readString();
    }

    public String getAmount() {
        return this.mAmount;
    }

    public AppID getAppID() {
        return this.mAppID;
    }

    public String getEncrpytPin() {
        return this.mEncrpytPin;
    }

    public String getType() {
        return this.mType;
    }

    public void setAmount(String str) {
        this.mAmount = str;
    }

    public void setAppID(AppID appID) {
        this.mAppID = appID;
    }

    public void setEncrpytPin(String str) {
        this.mEncrpytPin = str;
    }

    public void setType(String str) {
        this.mType = str;
    }

    @Override // com.unionpay.tsmservice.request.RequestParams, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.mAppID, i);
        parcel.writeString(this.mType);
        parcel.writeString(this.mAmount);
        parcel.writeString(this.mEncrpytPin);
    }
}
