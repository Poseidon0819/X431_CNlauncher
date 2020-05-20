package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class OpenChannelRequestParams extends RequestParams {
    public static final Parcelable.Creator<OpenChannelRequestParams> CREATOR = new Parcelable.Creator<OpenChannelRequestParams>() { // from class: com.unionpay.tsmservice.request.OpenChannelRequestParams.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OpenChannelRequestParams createFromParcel(Parcel parcel) {
            return new OpenChannelRequestParams(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OpenChannelRequestParams[] newArray(int i) {
            return new OpenChannelRequestParams[i];
        }
    };
    private String mAppAID;

    public OpenChannelRequestParams() {
    }

    public OpenChannelRequestParams(Parcel parcel) {
        super(parcel);
        this.mAppAID = parcel.readString();
    }

    public OpenChannelRequestParams(String str) {
        this.mAppAID = str;
    }

    public String getAppAID() {
        return this.mAppAID;
    }

    public void setAppAID(String str) {
        this.mAppAID = str;
    }

    @Override // com.unionpay.tsmservice.request.RequestParams, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mAppAID);
    }
}
