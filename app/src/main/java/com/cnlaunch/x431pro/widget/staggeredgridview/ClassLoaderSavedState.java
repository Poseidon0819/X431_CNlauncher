package com.cnlaunch.x431pro.widget.staggeredgridview;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public abstract class ClassLoaderSavedState implements Parcelable {

    /* renamed from: b */
    Parcelable f16814b;

    /* renamed from: c */
    private ClassLoader f16815c;

    /* renamed from: a */
    public static final ClassLoaderSavedState f16813a = new ClassLoaderSavedState() { // from class: com.cnlaunch.x431pro.widget.staggeredgridview.ClassLoaderSavedState.1
    };
    public static final Parcelable.Creator<ClassLoaderSavedState> CREATOR = new C2972a();

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* synthetic */ ClassLoaderSavedState(byte b) {
        this();
    }

    private ClassLoaderSavedState() {
        this.f16814b = f16813a;
        this.f16814b = null;
        this.f16815c = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ClassLoaderSavedState(Parcelable parcelable, ClassLoader classLoader) {
        ClassLoaderSavedState classLoaderSavedState = f16813a;
        this.f16814b = classLoaderSavedState;
        this.f16815c = classLoader;
        if (parcelable == null) {
            throw new IllegalArgumentException("superState must not be null");
        }
        this.f16814b = parcelable == classLoaderSavedState ? null : parcelable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ClassLoaderSavedState(Parcel parcel) {
        this.f16814b = f16813a;
        Parcelable readParcelable = parcel.readParcelable(this.f16815c);
        this.f16814b = readParcelable == null ? f16813a : readParcelable;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f16814b, i);
    }
}
