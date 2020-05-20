package com.unionpay.tsmservice.p373mi.result;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.unionpay.tsmservice.mi.result.EncryptDataResult */
/* loaded from: classes2.dex */
public class EncryptDataResult implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.unionpay.tsmservice.mi.result.EncryptDataResult.1
        @Override // android.os.Parcelable.Creator
        public final EncryptDataResult createFromParcel(Parcel parcel) {
            return new EncryptDataResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final EncryptDataResult[] newArray(int i) {
            return new EncryptDataResult[i];
        }
    };
    private List mEncryptData;

    public EncryptDataResult() {
    }

    public EncryptDataResult(Parcel parcel) {
        this.mEncryptData = new ArrayList();
        parcel.readList(this.mEncryptData, ClassLoader.getSystemClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List getEncryptData() {
        return this.mEncryptData;
    }

    public void setEncryptData(List list) {
        this.mEncryptData = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.mEncryptData);
    }
}
