package com.unionpay.tsmservice.data;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class UpdateInfo implements Parcelable {
    public static final Parcelable.Creator<UpdateInfo> CREATOR = new Parcelable.Creator<UpdateInfo>() { // from class: com.unionpay.tsmservice.data.UpdateInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final UpdateInfo createFromParcel(Parcel parcel) {
            return new UpdateInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final UpdateInfo[] newArray(int i) {
            return new UpdateInfo[i];
        }
    };
    public static final String TYPE_MUST = "02";
    public static final String TYPE_NONE = "00";
    public static final String TYPE_OPTION = "01";
    private String mClientDigest;
    private String[] mDesc;
    private String mDownloadUrl;
    private String mType;

    public UpdateInfo() {
    }

    public UpdateInfo(Parcel parcel) {
        this.mType = parcel.readString();
        this.mDownloadUrl = parcel.readString();
        this.mClientDigest = parcel.readString();
        this.mDesc = parcel.createStringArray();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getClientDigest() {
        return this.mClientDigest;
    }

    public String[] getDesc() {
        return this.mDesc;
    }

    public String getDownloadUrl() {
        return this.mDownloadUrl;
    }

    public String getType() {
        return this.mType;
    }

    public void setClientDigest(String str) {
        this.mClientDigest = str;
    }

    public void setDesc(String[] strArr) {
        this.mDesc = strArr;
    }

    public void setDownloadUrl(String str) {
        this.mDownloadUrl = str;
    }

    public void setType(String str) {
        this.mType = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mType);
        parcel.writeString(this.mDownloadUrl);
        parcel.writeString(this.mClientDigest);
        parcel.writeStringArray(this.mDesc);
    }
}
