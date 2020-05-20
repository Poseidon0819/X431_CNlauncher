package com.cnlaunch.x431pro.activity.upgrade;

import android.content.Context;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;

/* compiled from: DownloadFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.j */
/* loaded from: classes.dex */
final class DialogC2688j extends MessageDialog {

    /* renamed from: a */
    final /* synthetic */ HandlerC2687i f15415a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogC2688j(HandlerC2687i handlerC2687i, Context context) {
        super(context);
        this.f15415a = handlerC2687i;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        this.f15415a.f15414a.m5483g();
    }
}
