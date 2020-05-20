package com.mopub.nativeads;

/* compiled from: MoPubAdAdapter.java */
/* renamed from: com.mopub.nativeads.i */
/* loaded from: classes2.dex */
final class C3890i implements MoPubNativeAdLoadedListener {

    /* renamed from: a */
    final /* synthetic */ MoPubAdAdapter f21153a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3890i(MoPubAdAdapter moPubAdAdapter) {
        this.f21153a = moPubAdAdapter;
    }

    @Override // com.mopub.nativeads.MoPubNativeAdLoadedListener
    public final void onAdLoaded(int i) {
        MoPubAdAdapter moPubAdAdapter = this.f21153a;
        if (moPubAdAdapter.f20818a != null) {
            moPubAdAdapter.f20818a.onAdLoaded(i);
        }
        moPubAdAdapter.notifyDataSetChanged();
    }

    @Override // com.mopub.nativeads.MoPubNativeAdLoadedListener
    public final void onAdRemoved(int i) {
        MoPubAdAdapter moPubAdAdapter = this.f21153a;
        if (moPubAdAdapter.f20818a != null) {
            moPubAdAdapter.f20818a.onAdRemoved(i);
        }
        moPubAdAdapter.notifyDataSetChanged();
    }
}
