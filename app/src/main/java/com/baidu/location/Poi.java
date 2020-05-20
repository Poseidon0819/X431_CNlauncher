package com.baidu.location;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class Poi implements Parcelable {
    public static final Parcelable.Creator<Poi> CREATOR = new Parcelable.Creator<Poi>() { // from class: com.baidu.location.Poi.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Poi createFromParcel(Parcel parcel) {
            return new Poi(parcel.readString(), parcel.readString(), parcel.readDouble());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Poi[] newArray(int i) {
            return new Poi[i];
        }
    };
    private final String mId;
    private final String mName;
    private final double mRank;

    public Poi(String str, String str2, double d) {
        this.mId = str;
        this.mName = str2;
        this.mRank = d;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getId() {
        return this.mId;
    }

    public final String getName() {
        return this.mName;
    }

    public final double getRank() {
        return this.mRank;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mId);
        parcel.writeString(this.mName);
        parcel.writeDouble(this.mRank);
    }
}
