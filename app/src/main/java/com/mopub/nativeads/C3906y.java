package com.mopub.nativeads;

/* compiled from: MoPubRecyclerAdapter.java */
/* renamed from: com.mopub.nativeads.y */
/* loaded from: classes2.dex */
final class C3906y implements MoPubNativeAdLoadedListener {

    /* renamed from: a */
    final /* synthetic */ MoPubRecyclerAdapter f21172a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3906y(MoPubRecyclerAdapter moPubRecyclerAdapter) {
        this.f21172a = moPubRecyclerAdapter;
    }

    @Override // com.mopub.nativeads.MoPubNativeAdLoadedListener
    public final void onAdLoaded(int i) {
        MoPubRecyclerAdapter moPubRecyclerAdapter = this.f21172a;
        if (moPubRecyclerAdapter.f20878a != null) {
            moPubRecyclerAdapter.f20878a.onAdLoaded(i);
        }
        moPubRecyclerAdapter.notifyItemInserted(i);
    }

    @Override // com.mopub.nativeads.MoPubNativeAdLoadedListener
    public final void onAdRemoved(int i) {
        MoPubRecyclerAdapter moPubRecyclerAdapter = this.f21172a;
        if (moPubRecyclerAdapter.f20878a != null) {
            moPubRecyclerAdapter.f20878a.onAdRemoved(i);
        }
        moPubRecyclerAdapter.notifyItemRemoved(i);
    }
}
