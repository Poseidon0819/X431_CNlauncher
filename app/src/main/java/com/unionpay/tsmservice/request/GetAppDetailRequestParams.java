package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.unionpay.tsmservice.AppID;

/* loaded from: classes2.dex */
public class GetAppDetailRequestParams extends RequestParams {
    public static final Parcelable.Creator<GetAppDetailRequestParams> CREATOR = new Parcelable.Creator<GetAppDetailRequestParams>() { // from class: com.unionpay.tsmservice.request.GetAppDetailRequestParams.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GetAppDetailRequestParams createFromParcel(Parcel parcel) {
            return new GetAppDetailRequestParams(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GetAppDetailRequestParams[] newArray(int i) {
            return new GetAppDetailRequestParams[i];
        }
    };
    private AppID mAppID;
    private String mTransType;

    public GetAppDetailRequestParams() {
    }

    public GetAppDetailRequestParams(Parcel parcel) {
        super(parcel);
        this.mAppID = (AppID) parcel.readParcelable(AppID.class.getClassLoader());
        this.mTransType = parcel.readString();
    }

    public AppID getAppID() {
        return this.mAppID;
    }

    public String getTransType() {
        return this.mTransType;
    }

    public void setAppID(AppID appID) {
        this.mAppID = appID;
    }

    public void setTransType(String str) {
        this.mTransType = str;
    }

    @Override // com.unionpay.tsmservice.request.RequestParams, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.mAppID, i);
        parcel.writeString(this.mTransType);
    }
}
