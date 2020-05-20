package com.cnlaunch.x431pro.widget.staggeredgridview;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: ClassLoaderSavedState.java */
/* renamed from: com.cnlaunch.x431pro.widget.staggeredgridview.a */
/* loaded from: classes.dex */
final class C2972a implements Parcelable.Creator<ClassLoaderSavedState> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ ClassLoaderSavedState[] newArray(int i) {
        return new ClassLoaderSavedState[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ClassLoaderSavedState createFromParcel(Parcel parcel) {
        if (parcel.readParcelable(null) != null) {
            throw new IllegalStateException("superState must be null");
        }
        return ClassLoaderSavedState.f16813a;
    }
}
