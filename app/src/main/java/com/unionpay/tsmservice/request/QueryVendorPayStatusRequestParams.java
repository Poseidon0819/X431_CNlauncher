package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class QueryVendorPayStatusRequestParams extends RequestParams {
    public static final Parcelable.Creator<QueryVendorPayStatusRequestParams> CREATOR = new Parcelable.Creator<QueryVendorPayStatusRequestParams>() { // from class: com.unionpay.tsmservice.request.QueryVendorPayStatusRequestParams.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final QueryVendorPayStatusRequestParams createFromParcel(Parcel parcel) {
            return new QueryVendorPayStatusRequestParams(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final QueryVendorPayStatusRequestParams[] newArray(int i) {
            return new QueryVendorPayStatusRequestParams[i];
        }
    };

    public QueryVendorPayStatusRequestParams() {
    }

    public QueryVendorPayStatusRequestParams(Parcel parcel) {
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
