package com.cnlaunch.x431pro.widget.slidingmenu;

import android.os.Parcel;
import android.os.Parcelable;
import com.cnlaunch.x431pro.widget.slidingmenu.SlidingMenu;

/* compiled from: SlidingMenu.java */
/* renamed from: com.cnlaunch.x431pro.widget.slidingmenu.f */
/* loaded from: classes.dex */
final class C2959f implements Parcelable.Creator<SlidingMenu.SavedState> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ SlidingMenu.SavedState[] newArray(int i) {
        return new SlidingMenu.SavedState[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SlidingMenu.SavedState createFromParcel(Parcel parcel) {
        return new SlidingMenu.SavedState(parcel, (byte) 0);
    }
}
