package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.unionpay.tsmservice.AppID;

/* loaded from: classes2.dex */
public class GetAccountInfoRequestParams extends RequestParams {
    public static final Parcelable.Creator<GetAccountInfoRequestParams> CREATOR = new Parcelable.Creator<GetAccountInfoRequestParams>() { // from class: com.unionpay.tsmservice.request.GetAccountInfoRequestParams.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GetAccountInfoRequestParams createFromParcel(Parcel parcel) {
            return new GetAccountInfoRequestParams(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GetAccountInfoRequestParams[] newArray(int i) {
            return new GetAccountInfoRequestParams[i];
        }
    };
    private AppID mAppID;

    public GetAccountInfoRequestParams() {
    }

    public GetAccountInfoRequestParams(Parcel parcel) {
        super(parcel);
        this.mAppID = (AppID) parcel.readParcelable(AppID.class.getClassLoader());
    }

    public AppID getAppID() {
        return this.mAppID;
    }

    public void setAppID(AppID appID) {
        this.mAppID = appID;
    }

    @Override // com.unionpay.tsmservice.request.RequestParams, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.mAppID, i);
    }
}
