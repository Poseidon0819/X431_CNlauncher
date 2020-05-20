package com.mopub.common;

import android.view.View;

/* compiled from: MoPubBrowser.java */
/* renamed from: com.mopub.common.k */
/* loaded from: classes.dex */
final class View$OnClickListenerC3697k implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MoPubBrowser f20217a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC3697k(MoPubBrowser moPubBrowser) {
        this.f20217a = moPubBrowser;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f20217a.finish();
    }
}
