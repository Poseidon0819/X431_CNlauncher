package com.mopub.mobileads;

import com.mopub.common.CloseableLayout;

/* compiled from: BaseInterstitialActivity.java */
/* renamed from: com.mopub.mobileads.f */
/* loaded from: classes.dex */
final class C3775f implements CloseableLayout.OnCloseListener {

    /* renamed from: a */
    final /* synthetic */ BaseInterstitialActivity f20582a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3775f(BaseInterstitialActivity baseInterstitialActivity) {
        this.f20582a = baseInterstitialActivity;
    }

    @Override // com.mopub.common.CloseableLayout.OnCloseListener
    public final void onClose() {
        this.f20582a.finish();
    }
}
