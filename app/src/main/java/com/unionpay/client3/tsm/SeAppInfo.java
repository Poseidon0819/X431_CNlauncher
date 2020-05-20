package com.unionpay.client3.tsm;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class SeAppInfo implements Parcelable {
    public static final Parcelable.Creator<SeAppInfo> CREATOR = new Parcelable.Creator<SeAppInfo>() { // from class: com.unionpay.client3.tsm.SeAppInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SeAppInfo createFromParcel(Parcel parcel) {
            return new SeAppInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SeAppInfo[] newArray(int i) {
            return new SeAppInfo[i];
        }
    };
    private String mAppAid;
    private String mAppIcon;
    private String mAppName;
    private String mAppProviderLogo;
    private String mAppProviderName;
    private String mAppSummary;
    private String mAppVersion;
    private String mBalance;
    private String mBankId;
    private String mCVN2;
    private int mDownloadTimes;
    private String mPan;
    private String mValidDate;

    public SeAppInfo() {
    }

    public SeAppInfo(Parcel parcel) {
        readFromParcel(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAppAid() {
        return this.mAppAid;
    }

    public String getAppIcon() {
        return this.mAppIcon;
    }

    public String getAppName() {
        return this.mAppName;
    }

    public String getAppProviderLogo() {
        return this.mAppProviderLogo;
    }

    public String getAppProviderName() {
        return this.mAppProviderName;
    }

    public String getAppSummary() {
        return this.mAppSummary;
    }

    public String getAppVersion() {
        return this.mAppVersion;
    }

    public String getBalance() {
        return this.mBalance;
    }

    public String getBankId() {
        return this.mBankId;
    }

    public String getCVN2() {
        return this.mCVN2;
    }

    public int getDownloadTimes() {
        return this.mDownloadTimes;
    }

    public String getPan() {
        return this.mPan;
    }

    public String getValidDate() {
        return this.mValidDate;
    }

    public void readFromParcel(Parcel parcel) {
        this.mAppAid = parcel.readString();
        this.mAppIcon = parcel.readString();
        this.mAppName = parcel.readString();
        this.mBankId = parcel.readString();
        this.mAppProviderName = parcel.readString();
        this.mAppProviderLogo = parcel.readString();
        this.mAppSummary = parcel.readString();
        this.mAppVersion = parcel.readString();
        this.mDownloadTimes = parcel.readInt();
        this.mPan = parcel.readString();
        this.mValidDate = parcel.readString();
        this.mBalance = parcel.readString();
        this.mCVN2 = parcel.readString();
    }

    public void setAppAid(String str) {
        this.mAppAid = str;
    }

    public void setAppIcon(String str) {
        this.mAppIcon = str;
    }

    public void setAppName(String str) {
        this.mAppName = str;
    }

    public void setAppProviderLogo(String str) {
        this.mAppProviderLogo = str;
    }

    public void setAppProviderName(String str) {
        this.mAppProviderName = str;
    }

    public void setAppSummary(String str) {
        this.mAppSummary = str;
    }

    public void setAppVersion(String str) {
        this.mAppVersion = str;
    }

    public void setBalance(String str) {
        this.mBalance = str;
    }

    public void setBankId(String str) {
        this.mBankId = str;
    }

    public void setCVN2(String str) {
        this.mCVN2 = str;
    }

    public void setDownloadTimes(int i) {
        this.mDownloadTimes = i;
    }

    public void setPan(String str) {
        this.mPan = str;
    }

    public void setValidDate(String str) {
        this.mValidDate = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mAppAid);
        parcel.writeString(this.mAppIcon);
        parcel.writeString(this.mAppName);
        parcel.writeString(this.mBankId);
        parcel.writeString(this.mAppProviderName);
        parcel.writeString(this.mAppProviderLogo);
        parcel.writeString(this.mAppSummary);
        parcel.writeString(this.mAppVersion);
        parcel.writeInt(this.mDownloadTimes);
        parcel.writeString(this.mPan);
        parcel.writeString(this.mValidDate);
        parcel.writeString(this.mBalance);
        parcel.writeString(this.mCVN2);
    }
}
