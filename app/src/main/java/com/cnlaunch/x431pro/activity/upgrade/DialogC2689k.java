package com.cnlaunch.x431pro.activity.upgrade;

import android.content.Context;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;

/* compiled from: DownloadFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.k */
/* loaded from: classes.dex */
final class DialogC2689k extends MessageDialog {

    /* renamed from: a */
    final /* synthetic */ HandlerC2687i f15416a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogC2689k(HandlerC2687i handlerC2687i, Context context) {
        super(context);
        this.f15416a = handlerC2687i;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        this.f15416a.f15414a.m5483g();
    }
}
