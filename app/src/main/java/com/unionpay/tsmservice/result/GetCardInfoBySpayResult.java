package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.unionpay.tsmservice.data.VirtualCardInfo;

/* loaded from: classes2.dex */
public class GetCardInfoBySpayResult implements Parcelable {
    public static final Parcelable.Creator<GetCardInfoBySpayResult> CREATOR = new Parcelable.Creator<GetCardInfoBySpayResult>() { // from class: com.unionpay.tsmservice.result.GetCardInfoBySpayResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GetCardInfoBySpayResult createFromParcel(Parcel parcel) {
            return new GetCardInfoBySpayResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GetCardInfoBySpayResult[] newArray(int i) {
            return new GetCardInfoBySpayResult[i];
        }
    };
    private VirtualCardInfo mVirtualCardInfo;

    public GetCardInfoBySpayResult() {
    }

    public GetCardInfoBySpayResult(Parcel parcel) {
        this.mVirtualCardInfo = (VirtualCardInfo) parcel.readParcelable(VirtualCardInfo.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public VirtualCardInfo getVirtualCardInfo() {
        return this.mVirtualCardInfo;
    }

    public void setVirtualCardInfo(VirtualCardInfo virtualCardInfo) {
        this.mVirtualCardInfo = virtualCardInfo;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mVirtualCardInfo, i);
    }
}
