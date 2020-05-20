package com.mopub.nativeads;

import android.view.View;

/* compiled from: NativeClickHandler.java */
/* renamed from: com.mopub.nativeads.aj */
/* loaded from: classes2.dex */
final class View$OnClickListenerC3866aj implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ClickInterface f21066a;

    /* renamed from: b */
    final /* synthetic */ NativeClickHandler f21067b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC3866aj(NativeClickHandler nativeClickHandler, ClickInterface clickInterface) {
        this.f21067b = nativeClickHandler;
        this.f21066a = clickInterface;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f21066a.handleClick(view);
    }
}
