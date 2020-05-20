package com.unionpay.mobile.android.pboctransaction;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class AppIdentification implements Parcelable, Comparable<AppIdentification> {
    public static final Parcelable.Creator<AppIdentification> CREATOR = new C4260a();

    /* renamed from: a */
    private String f22721a;

    /* renamed from: b */
    private String f22722b;

    private AppIdentification() {
        this.f22721a = "";
        this.f22722b = "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ AppIdentification(byte b) {
        this();
    }

    public AppIdentification(String str, String str2) {
        this.f22721a = str;
        this.f22722b = str2;
    }

    /* renamed from: a */
    public final String m1336a() {
        return this.f22721a;
    }

    /* renamed from: b */
    public final String m1334b() {
        try {
            return this.f22721a.substring(14, 16);
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: c */
    public final boolean m1332c() {
        String str = this.f22721a;
        if (str != null) {
            return str.startsWith("A000000333");
        }
        return false;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(AppIdentification appIdentification) {
        String str;
        String str2;
        AppIdentification appIdentification2 = appIdentification;
        if (!this.f22721a.equalsIgnoreCase(appIdentification2.f22721a)) {
            str = this.f22721a;
            str2 = appIdentification2.f22721a;
        } else if (this.f22722b.equalsIgnoreCase(appIdentification2.f22722b)) {
            return 0;
        } else {
            str = this.f22722b;
            str2 = appIdentification2.f22722b;
        }
        return str.compareTo(str2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AppIdentification)) {
            AppIdentification appIdentification = (AppIdentification) obj;
            if (this.f22721a.equalsIgnoreCase(appIdentification.f22721a) && this.f22722b.equalsIgnoreCase(appIdentification.f22722b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f22721a.hashCode() + 31) * 31) + this.f22722b.hashCode();
    }

    public String toString() {
        return "{appId:" + this.f22721a + ", appVersion:" + this.f22722b + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f22721a);
        parcel.writeString(this.f22722b);
    }
}
