package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class CheckSSamsungPayRequestParams extends RequestParams {
    public static final Parcelable.Creator<CheckSSamsungPayRequestParams> CREATOR = new Parcelable.Creator<CheckSSamsungPayRequestParams>() { // from class: com.unionpay.tsmservice.request.CheckSSamsungPayRequestParams.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CheckSSamsungPayRequestParams createFromParcel(Parcel parcel) {
            return new CheckSSamsungPayRequestParams(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CheckSSamsungPayRequestParams[] newArray(int i) {
            return new CheckSSamsungPayRequestParams[i];
        }
    };

    public CheckSSamsungPayRequestParams() {
    }

    public CheckSSamsungPayRequestParams(Parcel parcel) {
        super(parcel);
    }

    @Override // com.unionpay.tsmservice.request.RequestParams, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }
}
