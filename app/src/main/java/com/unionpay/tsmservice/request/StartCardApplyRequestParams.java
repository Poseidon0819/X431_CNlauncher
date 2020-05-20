package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class StartCardApplyRequestParams extends RequestParams {
    public static final Parcelable.Creator<StartCardApplyRequestParams> CREATOR = new Parcelable.Creator<StartCardApplyRequestParams>() { // from class: com.unionpay.tsmservice.request.StartCardApplyRequestParams.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final StartCardApplyRequestParams createFromParcel(Parcel parcel) {
            return new StartCardApplyRequestParams(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final StartCardApplyRequestParams[] newArray(int i) {
            return new StartCardApplyRequestParams[i];
        }
    };

    public StartCardApplyRequestParams() {
    }

    public StartCardApplyRequestParams(Parcel parcel) {
        super(parcel);
    }

    @Override // com.unionpay.tsmservice.request.RequestParams, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.unionpay.tsmservice.request.RequestParams, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }
}
