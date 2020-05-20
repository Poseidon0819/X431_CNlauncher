package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.view.View;
import android.widget.ExpandableListView;
import com.cnlaunch.x431pro.activity.diagnose.p218a.SystemStatusCodeListAdapter;
import com.cnlaunch.x431pro.widget.button.IconButton;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SystemStatusCodeFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.cf */
/* loaded from: classes.dex */
public final class C2163cf implements ExpandableListView.OnChildClickListener {

    /* renamed from: a */
    final /* synthetic */ SystemStatusCodeFragment f12285a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2163cf(SystemStatusCodeFragment systemStatusCodeFragment) {
        this.f12285a = systemStatusCodeFragment;
    }

    @Override // android.widget.ExpandableListView.OnChildClickListener
    public final boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
        int[] iArr;
        int[] iArr2;
        IconButton iconButton;
        SystemStatusCodeListAdapter systemStatusCodeListAdapter;
        iArr = this.f12285a.f12258V;
        iArr[0] = i;
        iArr2 = this.f12285a.f12258V;
        iArr2[1] = i2;
        iconButton = this.f12285a.f12282x;
        iconButton.setEnabled(true);
        systemStatusCodeListAdapter = this.f12285a.f12273o;
        systemStatusCodeListAdapter.m7478a(i, i2);
        return false;
    }
}
