package com.mopub.nativeads;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: MoPubAdAdapter.java */
/* renamed from: com.mopub.nativeads.j */
/* loaded from: classes2.dex */
final class C3891j implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ AdapterView.OnItemClickListener f21154a;

    /* renamed from: b */
    final /* synthetic */ MoPubAdAdapter f21155b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3891j(MoPubAdAdapter moPubAdAdapter, AdapterView.OnItemClickListener onItemClickListener) {
        this.f21155b = moPubAdAdapter;
        this.f21154a = onItemClickListener;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        MoPubStreamAdPlacer moPubStreamAdPlacer;
        MoPubStreamAdPlacer moPubStreamAdPlacer2;
        moPubStreamAdPlacer = this.f21155b.f20821d;
        if (moPubStreamAdPlacer.isAd(i)) {
            return;
        }
        AdapterView.OnItemClickListener onItemClickListener = this.f21154a;
        moPubStreamAdPlacer2 = this.f21155b.f20821d;
        onItemClickListener.onItemClick(adapterView, view, moPubStreamAdPlacer2.getOriginalPosition(i), j);
    }
}
