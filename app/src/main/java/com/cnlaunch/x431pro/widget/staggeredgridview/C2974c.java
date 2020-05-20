package com.cnlaunch.x431pro.widget.staggeredgridview;

import android.os.Parcel;
import android.os.Parcelable;
import com.cnlaunch.x431pro.widget.staggeredgridview.ExtendableListView;

/* compiled from: ExtendableListView.java */
/* renamed from: com.cnlaunch.x431pro.widget.staggeredgridview.c */
/* loaded from: classes.dex */
final class C2974c implements Parcelable.Creator<ExtendableListView.ListSavedState> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ ExtendableListView.ListSavedState[] newArray(int i) {
        return new ExtendableListView.ListSavedState[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ExtendableListView.ListSavedState createFromParcel(Parcel parcel) {
        return new ExtendableListView.ListSavedState(parcel);
    }
}
