package com.unionpay.tsmservice.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class TransactionDetail implements Parcelable {
    public static final Parcelable.Creator<TransactionDetail> CREATOR = new Parcelable.Creator<TransactionDetail>() { // from class: com.unionpay.tsmservice.data.TransactionDetail.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TransactionDetail createFromParcel(Parcel parcel) {
            return new TransactionDetail(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TransactionDetail[] newArray(int i) {
            return new TransactionDetail[i];
        }
    };
    private Bundle mDetail;
    private MessageDetail[] mMessageDetails;

    public TransactionDetail() {
    }

    public TransactionDetail(Parcel parcel) {
        this.mDetail = parcel.readBundle();
        this.mMessageDetails = (MessageDetail[]) parcel.createTypedArray(MessageDetail.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bundle getDetail() {
        return this.mDetail;
    }

    public MessageDetail[] getMessageDetails() {
        return this.mMessageDetails;
    }

    public void setDetail(Bundle bundle) {
        this.mDetail = bundle;
    }

    public void setMessageDetails(MessageDetail[] messageDetailArr) {
        this.mMessageDetails = messageDetailArr;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.mDetail);
        parcel.writeTypedArray(this.mMessageDetails, i);
    }
}
