package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.unionpay.tsmservice.data.TransactionDetail;

/* loaded from: classes2.dex */
public class TransactionDetailsResult implements Parcelable {
    public static final Parcelable.Creator<TransactionDetailsResult> CREATOR = new Parcelable.Creator<TransactionDetailsResult>() { // from class: com.unionpay.tsmservice.result.TransactionDetailsResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TransactionDetailsResult createFromParcel(Parcel parcel) {
            return new TransactionDetailsResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TransactionDetailsResult[] newArray(int i) {
            return new TransactionDetailsResult[i];
        }
    };
    private String mLastUpdatedTag;
    private TransactionDetail[] mTransactionDetails;

    public TransactionDetailsResult() {
        this.mLastUpdatedTag = "";
    }

    public TransactionDetailsResult(Parcel parcel) {
        this.mLastUpdatedTag = "";
        this.mTransactionDetails = (TransactionDetail[]) parcel.createTypedArray(TransactionDetail.CREATOR);
        this.mLastUpdatedTag = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getLastUpdatedTag() {
        return this.mLastUpdatedTag;
    }

    public TransactionDetail[] getTransactionDetails() {
        return this.mTransactionDetails;
    }

    public void setLastUpdatedTag(String str) {
        this.mLastUpdatedTag = str;
    }

    public void setTransactionDetails(TransactionDetail[] transactionDetailArr) {
        this.mTransactionDetails = transactionDetailArr;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.mTransactionDetails, i);
        parcel.writeString(this.mLastUpdatedTag);
    }
}
