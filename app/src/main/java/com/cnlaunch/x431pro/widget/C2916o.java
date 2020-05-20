package com.cnlaunch.x431pro.widget;

import android.os.Parcel;
import android.os.Parcelable;
import com.cnlaunch.x431pro.widget.PagerSlidingTabStrip;

/* compiled from: PagerSlidingTabStrip.java */
/* renamed from: com.cnlaunch.x431pro.widget.o */
/* loaded from: classes.dex */
final class C2916o implements Parcelable.Creator<PagerSlidingTabStrip.SavedState> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ PagerSlidingTabStrip.SavedState[] newArray(int i) {
        return new PagerSlidingTabStrip.SavedState[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PagerSlidingTabStrip.SavedState createFromParcel(Parcel parcel) {
        return new PagerSlidingTabStrip.SavedState(parcel, (byte) 0);
    }
}
