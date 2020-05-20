package com.baidu.mapapi.search.share;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;

/* loaded from: classes.dex */
public class ShareUrlResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<ShareUrlResult> CREATOR = new Parcelable.Creator<ShareUrlResult>() { // from class: com.baidu.mapapi.search.share.ShareUrlResult.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final ShareUrlResult createFromParcel(Parcel parcel) {
            return new ShareUrlResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final ShareUrlResult[] newArray(int i) {
            return new ShareUrlResult[i];
        }
    };

    /* renamed from: a */
    private String f5653a;

    /* renamed from: b */
    private int f5654b;

    public ShareUrlResult() {
    }

    protected ShareUrlResult(Parcel parcel) {
        this.f5653a = parcel.readString();
        this.f5654b = parcel.readInt();
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getUrl() {
        return this.f5653a;
    }

    public void setType(int i) {
        this.f5654b = i;
    }

    public void setUrl(String str) {
        this.f5653a = str;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5653a);
        parcel.writeInt(this.f5654b);
    }
}
