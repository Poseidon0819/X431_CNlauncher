package com.cnlaunch.x431pro.widget;

import android.os.Parcel;
import android.os.Parcelable;
import com.cnlaunch.x431pro.widget.SlidingUpPanelLayout;

/* compiled from: SlidingUpPanelLayout.java */
/* renamed from: com.cnlaunch.x431pro.widget.q */
/* loaded from: classes.dex */
final class C2946q implements Parcelable.Creator<SlidingUpPanelLayout.SavedState> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ SlidingUpPanelLayout.SavedState[] newArray(int i) {
        return new SlidingUpPanelLayout.SavedState[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SlidingUpPanelLayout.SavedState createFromParcel(Parcel parcel) {
        return new SlidingUpPanelLayout.SavedState(parcel, (byte) 0);
    }
}
