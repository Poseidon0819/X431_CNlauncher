package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class GetEncryptDataRequestParams extends RequestParams {
    public static final Parcelable.Creator<GetEncryptDataRequestParams> CREATOR = new Parcelable.Creator<GetEncryptDataRequestParams>() { // from class: com.unionpay.tsmservice.request.GetEncryptDataRequestParams.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GetEncryptDataRequestParams createFromParcel(Parcel parcel) {
            return new GetEncryptDataRequestParams(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GetEncryptDataRequestParams[] newArray(int i) {
            return new GetEncryptDataRequestParams[i];
        }
    };
    private String mPan;
    private int mType;

    public GetEncryptDataRequestParams() {
    }

    public GetEncryptDataRequestParams(Parcel parcel) {
        super(parcel);
        this.mType = parcel.readInt();
        this.mPan = parcel.readString();
    }

    @Override // com.unionpay.tsmservice.request.RequestParams, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getPan() {
        return this.mPan;
    }

    public int getType() {
        return this.mType;
    }

    public void setPan(String str) {
        this.mPan = str;
    }

    public void setType(int i) {
        this.mType = i;
    }

    @Override // com.unionpay.tsmservice.request.RequestParams, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.mType);
        parcel.writeString(this.mPan);
    }
}
