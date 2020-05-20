package com.unionpay.tsmservice.data;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class AppStatus implements Parcelable {
    public static final String APPLY = "06";
    public static final String APPROVED = "00";
    public static final String APPROVING = "02";
    public static final Parcelable.Creator<AppStatus> CREATOR = new Parcelable.Creator<AppStatus>() { // from class: com.unionpay.tsmservice.data.AppStatus.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AppStatus createFromParcel(Parcel parcel) {
            return new AppStatus(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AppStatus[] newArray(int i) {
            return new AppStatus[i];
        }
    };
    public static final String NOT_APPROVED = "01";
    public static final String OPEN = "05";
    public static final String VIEW = "07";
    private String mStatus;

    public AppStatus() {
        this.mStatus = "";
    }

    public AppStatus(Parcel parcel) {
        this.mStatus = "";
        this.mStatus = parcel.readString();
    }

    public AppStatus(String str) {
        this.mStatus = "";
        this.mStatus = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getStatus() {
        return this.mStatus;
    }

    public void setStatus(String str) {
        this.mStatus = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mStatus);
    }
}
