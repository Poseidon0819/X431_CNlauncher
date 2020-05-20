package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class ExecuteCmdRequestParams extends RequestParams {
    public static final Parcelable.Creator<ExecuteCmdRequestParams> CREATOR = new Parcelable.Creator<ExecuteCmdRequestParams>() { // from class: com.unionpay.tsmservice.request.ExecuteCmdRequestParams.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ExecuteCmdRequestParams createFromParcel(Parcel parcel) {
            return new ExecuteCmdRequestParams(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ExecuteCmdRequestParams[] newArray(int i) {
            return new ExecuteCmdRequestParams[i];
        }
    };
    private String mSign;
    private String mSsid;

    public ExecuteCmdRequestParams() {
    }

    public ExecuteCmdRequestParams(Parcel parcel) {
        super(parcel);
        this.mSsid = parcel.readString();
        this.mSign = parcel.readString();
    }

    public String getSign() {
        return this.mSign;
    }

    public String getSsid() {
        return this.mSsid;
    }

    public void setSign(String str) {
        this.mSign = str;
    }

    public void setSsid(String str) {
        this.mSsid = str;
    }

    @Override // com.unionpay.tsmservice.request.RequestParams, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mSsid);
        parcel.writeString(this.mSign);
    }
}
