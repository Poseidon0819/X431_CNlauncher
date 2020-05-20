package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class CloseChannelRequestParams extends RequestParams {
    public static final Parcelable.Creator<CloseChannelRequestParams> CREATOR = new Parcelable.Creator<CloseChannelRequestParams>() { // from class: com.unionpay.tsmservice.request.CloseChannelRequestParams.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CloseChannelRequestParams createFromParcel(Parcel parcel) {
            return new CloseChannelRequestParams(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CloseChannelRequestParams[] newArray(int i) {
            return new CloseChannelRequestParams[i];
        }
    };
    private String mChannel;

    public CloseChannelRequestParams() {
    }

    public CloseChannelRequestParams(Parcel parcel) {
        super(parcel);
        this.mChannel = parcel.readString();
    }

    public CloseChannelRequestParams(String str) {
        this.mChannel = str;
    }

    public String getChannel() {
        return this.mChannel;
    }

    public void setChannel(String str) {
        this.mChannel = str;
    }

    @Override // com.unionpay.tsmservice.request.RequestParams, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mChannel);
    }
}
