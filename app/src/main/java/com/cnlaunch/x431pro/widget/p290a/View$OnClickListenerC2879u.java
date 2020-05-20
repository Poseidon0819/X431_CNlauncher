package com.cnlaunch.x431pro.widget.p290a;

import android.app.Activity;
import android.view.View;
import com.cnlaunch.x431pro.utils.C2744aa;

/* compiled from: DivisionSoftDownloadDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.a.u */
/* loaded from: classes.dex */
final class View$OnClickListenerC2879u implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2870l f16465a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2879u(HandlerC2870l handlerC2870l) {
        this.f16465a = handlerC2870l;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f16465a.f16456a.dismiss();
        C2744aa.m5189a((Activity) this.f16465a.f16456a.f16441t);
    }
}
