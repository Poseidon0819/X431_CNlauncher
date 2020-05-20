package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class SendApduResult implements Parcelable {
    public static final Parcelable.Creator<SendApduResult> CREATOR = new Parcelable.Creator<SendApduResult>() { // from class: com.unionpay.tsmservice.result.SendApduResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SendApduResult createFromParcel(Parcel parcel) {
            return new SendApduResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SendApduResult[] newArray(int i) {
            return new SendApduResult[i];
        }
    };
    private String outHexApdu;

    public SendApduResult() {
    }

    public SendApduResult(Parcel parcel) {
        this.outHexApdu = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getOutHexApdu() {
        return this.outHexApdu;
    }

    public void setOutHexApdu(String str) {
        this.outHexApdu = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.outHexApdu);
    }
}
