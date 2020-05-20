package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.unionpay.tsmservice.data.SeAppDetail;

/* loaded from: classes2.dex */
public class AcquireSeAppListResult implements Parcelable {
    public static final Parcelable.Creator<AcquireSeAppListResult> CREATOR = new Parcelable.Creator<AcquireSeAppListResult>() { // from class: com.unionpay.tsmservice.result.AcquireSeAppListResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AcquireSeAppListResult createFromParcel(Parcel parcel) {
            return new AcquireSeAppListResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AcquireSeAppListResult[] newArray(int i) {
            return new AcquireSeAppListResult[i];
        }
    };
    private String mSeAliasType;
    private SeAppDetail[] mSeAppDetails;

    public AcquireSeAppListResult() {
        this.mSeAliasType = "";
    }

    public AcquireSeAppListResult(Parcel parcel) {
        this.mSeAliasType = "";
        this.mSeAppDetails = (SeAppDetail[]) parcel.createTypedArray(SeAppDetail.CREATOR);
        this.mSeAliasType = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getSeAliasType() {
        return this.mSeAliasType;
    }

    public SeAppDetail[] getSeAppDetails() {
        return this.mSeAppDetails;
    }

    public void setSeAliasType(String str) {
        this.mSeAliasType = str;
    }

    public void setSeAppDetails(SeAppDetail[] seAppDetailArr) {
        this.mSeAppDetails = seAppDetailArr;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.mSeAppDetails, i);
        parcel.writeString(this.mSeAliasType);
    }
}
