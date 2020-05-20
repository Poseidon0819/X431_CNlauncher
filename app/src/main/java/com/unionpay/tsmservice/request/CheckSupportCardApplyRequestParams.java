package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class CheckSupportCardApplyRequestParams extends RequestParams {
    public static final Parcelable.Creator<CheckSupportCardApplyRequestParams> CREATOR = new Parcelable.Creator<CheckSupportCardApplyRequestParams>() { // from class: com.unionpay.tsmservice.request.CheckSupportCardApplyRequestParams.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CheckSupportCardApplyRequestParams createFromParcel(Parcel parcel) {
            return new CheckSupportCardApplyRequestParams(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CheckSupportCardApplyRequestParams[] newArray(int i) {
            return new CheckSupportCardApplyRequestParams[i];
        }
    };

    public CheckSupportCardApplyRequestParams() {
    }

    public CheckSupportCardApplyRequestParams(Parcel parcel) {
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
