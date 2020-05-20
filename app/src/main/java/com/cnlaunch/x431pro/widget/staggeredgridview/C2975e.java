package com.cnlaunch.x431pro.widget.staggeredgridview;

import android.os.Parcel;
import android.os.Parcelable;
import com.cnlaunch.x431pro.widget.staggeredgridview.StaggeredGridView;

/* compiled from: StaggeredGridView.java */
/* renamed from: com.cnlaunch.x431pro.widget.staggeredgridview.e */
/* loaded from: classes.dex */
final class C2975e implements Parcelable.Creator<StaggeredGridView.GridItemRecord> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ StaggeredGridView.GridItemRecord[] newArray(int i) {
        return new StaggeredGridView.GridItemRecord[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ StaggeredGridView.GridItemRecord createFromParcel(Parcel parcel) {
        return new StaggeredGridView.GridItemRecord(parcel, (byte) 0);
    }
}
