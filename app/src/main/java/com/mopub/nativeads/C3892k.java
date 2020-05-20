package com.mopub.nativeads;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: MoPubAdAdapter.java */
/* renamed from: com.mopub.nativeads.k */
/* loaded from: classes2.dex */
final class C3892k implements AdapterView.OnItemLongClickListener {

    /* renamed from: a */
    final /* synthetic */ AdapterView.OnItemLongClickListener f21156a;

    /* renamed from: b */
    final /* synthetic */ MoPubAdAdapter f21157b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3892k(MoPubAdAdapter moPubAdAdapter, AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.f21157b = moPubAdAdapter;
        this.f21156a = onItemLongClickListener;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        MoPubStreamAdPlacer moPubStreamAdPlacer;
        if (this.f21157b.isAd(i)) {
            return true;
        }
        AdapterView.OnItemLongClickListener onItemLongClickListener = this.f21156a;
        moPubStreamAdPlacer = this.f21157b.f20821d;
        return onItemLongClickListener.onItemLongClick(adapterView, view, moPubStreamAdPlacer.getOriginalPosition(i), j);
    }
}
