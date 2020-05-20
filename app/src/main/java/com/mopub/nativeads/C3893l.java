package com.mopub.nativeads;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: MoPubAdAdapter.java */
/* renamed from: com.mopub.nativeads.l */
/* loaded from: classes2.dex */
final class C3893l implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ AdapterView.OnItemSelectedListener f21158a;

    /* renamed from: b */
    final /* synthetic */ MoPubAdAdapter f21159b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3893l(MoPubAdAdapter moPubAdAdapter, AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.f21159b = moPubAdAdapter;
        this.f21158a = onItemSelectedListener;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        MoPubStreamAdPlacer moPubStreamAdPlacer;
        if (this.f21159b.isAd(i)) {
            return;
        }
        AdapterView.OnItemSelectedListener onItemSelectedListener = this.f21158a;
        moPubStreamAdPlacer = this.f21159b.f20821d;
        onItemSelectedListener.onItemSelected(adapterView, view, moPubStreamAdPlacer.getOriginalPosition(i), j);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView<?> adapterView) {
        this.f21158a.onNothingSelected(adapterView);
    }
}
