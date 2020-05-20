package com.cnlaunch.x431pro.widget.p290a;

import android.view.View;

/* compiled from: DivisionSoftDownloadDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.a.p */
/* loaded from: classes.dex */
final class View$OnClickListenerC2874p implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2870l f16460a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2874p(HandlerC2870l handlerC2870l) {
        this.f16460a = handlerC2870l;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f16460a.f16456a.f16419I.sendMessage(this.f16460a.f16456a.f16419I.obtainMessage(5, 0, 0));
    }
}
