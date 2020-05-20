package com.mopub.nativeads;

import android.database.DataSetObserver;
import android.widget.Adapter;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MoPubAdAdapter.java */
/* renamed from: com.mopub.nativeads.h */
/* loaded from: classes2.dex */
public final class C3889h extends DataSetObserver {

    /* renamed from: a */
    final /* synthetic */ MoPubAdAdapter f21152a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3889h(MoPubAdAdapter moPubAdAdapter) {
        this.f21152a = moPubAdAdapter;
    }

    @Override // android.database.DataSetObserver
    public final void onChanged() {
        MoPubStreamAdPlacer moPubStreamAdPlacer;
        Adapter adapter;
        moPubStreamAdPlacer = this.f21152a.f20821d;
        adapter = this.f21152a.f20820c;
        moPubStreamAdPlacer.setItemCount(adapter.getCount());
        this.f21152a.notifyDataSetChanged();
    }

    @Override // android.database.DataSetObserver
    public final void onInvalidated() {
        this.f21152a.notifyDataSetInvalidated();
    }
}
