package com.cnlaunch.x431pro.activity.upgrade;

import android.content.Context;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DownloadFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.v */
/* loaded from: classes.dex */
public final class DialogC2700v extends MessageDialog {

    /* renamed from: a */
    final /* synthetic */ DownloadFragment f15427a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogC2700v(DownloadFragment downloadFragment, Context context) {
        super(context);
        this.f15427a = downloadFragment;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        this.f15427a.m5483g();
    }
}
