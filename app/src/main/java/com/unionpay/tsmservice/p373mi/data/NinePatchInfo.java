package com.unionpay.tsmservice.p373mi.data;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.unionpay.tsmservice.mi.data.NinePatchInfo */
/* loaded from: classes2.dex */
public class NinePatchInfo implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.unionpay.tsmservice.mi.data.NinePatchInfo.1
        @Override // android.os.Parcelable.Creator
        public final NinePatchInfo createFromParcel(Parcel parcel) {
            return new NinePatchInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final NinePatchInfo[] newArray(int i) {
            return new NinePatchInfo[i];
        }
    };
    private Bitmap mBitmap;
    private byte[] mChunk;
    private Rect mPadding;

    public NinePatchInfo() {
    }

    public NinePatchInfo(Parcel parcel) {
        this.mBitmap = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        this.mPadding = (Rect) parcel.readParcelable(Rect.class.getClassLoader());
        int readInt = parcel.readInt();
        if (readInt <= 0) {
            this.mChunk = null;
            return;
        }
        this.mChunk = new byte[readInt];
        parcel.readByteArray(this.mChunk);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public byte[] getChunk() {
        return this.mChunk;
    }

    public Rect getPadding() {
        return this.mPadding;
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public void setChunk(byte[] bArr) {
        this.mChunk = bArr;
    }

    public void setPadding(Rect rect) {
        this.mPadding = rect;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mBitmap, i);
        parcel.writeParcelable(this.mPadding, i);
        byte[] bArr = this.mChunk;
        if (bArr != null) {
            parcel.writeInt(bArr.length);
            parcel.writeByteArray(this.mChunk);
        }
    }
}
