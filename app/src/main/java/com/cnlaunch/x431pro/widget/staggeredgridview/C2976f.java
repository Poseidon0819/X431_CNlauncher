package com.cnlaunch.x431pro.widget.staggeredgridview;

import android.os.Parcel;
import android.os.Parcelable;
import com.cnlaunch.x431pro.widget.staggeredgridview.StaggeredGridView;

/* compiled from: StaggeredGridView.java */
/* renamed from: com.cnlaunch.x431pro.widget.staggeredgridview.f */
/* loaded from: classes.dex */
final class C2976f implements Parcelable.Creator<StaggeredGridView.GridListSavedState> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ StaggeredGridView.GridListSavedState[] newArray(int i) {
        return new StaggeredGridView.GridListSavedState[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ StaggeredGridView.GridListSavedState createFromParcel(Parcel parcel) {
        return new StaggeredGridView.GridListSavedState(parcel);
    }
}
