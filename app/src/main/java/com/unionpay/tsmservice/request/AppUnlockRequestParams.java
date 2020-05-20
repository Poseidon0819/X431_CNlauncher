package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.unionpay.tsmservice.AppID;

/* loaded from: classes2.dex */
public class AppUnlockRequestParams extends RequestParams {
    public static final Parcelable.Creator<AppUnlockRequestParams> CREATOR = new Parcelable.Creator<AppUnlockRequestParams>() { // from class: com.unionpay.tsmservice.request.AppUnlockRequestParams.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AppUnlockRequestParams createFromParcel(Parcel parcel) {
            return new AppUnlockRequestParams(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AppUnlockRequestParams[] newArray(int i) {
            return new AppUnlockRequestParams[i];
        }
    };
    private AppID mAppID;

    public AppUnlockRequestParams() {
    }

    public AppUnlockRequestParams(Parcel parcel) {
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
