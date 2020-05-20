package com.mopub.nativeads;

import android.view.View;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NativeClickHandler.java */
/* renamed from: com.mopub.nativeads.ak */
/* loaded from: classes2.dex */
public final class C3867ak implements UrlHandler.ResultActions {

    /* renamed from: a */
    final /* synthetic */ View f21068a;

    /* renamed from: b */
    final /* synthetic */ SpinningProgressView f21069b;

    /* renamed from: c */
    final /* synthetic */ NativeClickHandler f21070c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3867ak(NativeClickHandler nativeClickHandler, View view, SpinningProgressView spinningProgressView) {
        this.f21070c = nativeClickHandler;
        this.f21068a = view;
        this.f21069b = spinningProgressView;
    }

    @Override // com.mopub.common.UrlHandler.ResultActions
    public final void urlHandlingSucceeded(String str, UrlAction urlAction) {
        m2083a();
        NativeClickHandler.m2125a(this.f21070c);
    }

    @Override // com.mopub.common.UrlHandler.ResultActions
    public final void urlHandlingFailed(String str, UrlAction urlAction) {
        m2083a();
        NativeClickHandler.m2125a(this.f21070c);
    }

    /* renamed from: a */
    private void m2083a() {
        if (this.f21068a != null) {
            this.f21069b.m2067a();
        }
    }
}
