package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class GetAssociatedAppRequestParams extends RequestParams {
    public static final Parcelable.Creator<GetAssociatedAppRequestParams> CREATOR = new Parcelable.Creator<GetAssociatedAppRequestParams>() { // from class: com.unionpay.tsmservice.request.GetAssociatedAppRequestParams.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GetAssociatedAppRequestParams createFromParcel(Parcel parcel) {
            return new GetAssociatedAppRequestParams(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GetAssociatedAppRequestParams[] newArray(int i) {
            return new GetAssociatedAppRequestParams[i];
        }
    };
    private String mEncryptPan;

    public GetAssociatedAppRequestParams() {
    }

    public GetAssociatedAppRequestParams(Parcel parcel) {
        super(parcel);
        this.mEncryptPan = parcel.readString();
    }

    public GetAssociatedAppRequestParams(String str) {
        this.mEncryptPan = str;
    }

    public String getEncryptPan() {
        return this.mEncryptPan;
    }

    public void setEncryptPan(String str) {
        this.mEncryptPan = str;
    }

    @Override // com.unionpay.tsmservice.request.RequestParams, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mEncryptPan);
    }
}
