package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.unionpay.tsmservice.AppID;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class AppDeleteRequestParams extends RequestParams {
    public static final Parcelable.Creator<AppDeleteRequestParams> CREATOR = new Parcelable.Creator<AppDeleteRequestParams>() { // from class: com.unionpay.tsmservice.request.AppDeleteRequestParams.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AppDeleteRequestParams createFromParcel(Parcel parcel) {
            return new AppDeleteRequestParams(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AppDeleteRequestParams[] newArray(int i) {
            return new AppDeleteRequestParams[i];
        }
    };
    private AppID mAppID;
    private HashMap<String, String> mParams;

    public AppDeleteRequestParams() {
    }

    public AppDeleteRequestParams(Parcel parcel) {
        super(parcel);
        this.mAppID = (AppID) parcel.readParcelable(AppID.class.getClassLoader());
        this.mParams = parcel.readHashMap(HashMap.class.getClassLoader());
    }

    public AppID getAppID() {
        return this.mAppID;
    }

    public Map<String, String> getParams() {
        return this.mParams;
    }

    public void setAppID(AppID appID) {
        this.mAppID = appID;
    }

    public void setParams(HashMap<String, String> hashMap) {
        this.mParams = hashMap;
    }

    @Override // com.unionpay.tsmservice.request.RequestParams, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.mAppID, i);
        parcel.writeMap(this.mParams);
    }
}
