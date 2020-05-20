package com.cnlaunch.x431pro.activity.golousa;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.view.KeyEvent;

/* compiled from: GoloUSAFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.golousa.d */
/* loaded from: classes.dex */
final class DialogInterface$OnKeyListenerC2248d implements DialogInterface.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ GoloUSAFragment f12712a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterface$OnKeyListenerC2248d(GoloUSAFragment goloUSAFragment) {
        this.f12712a = goloUSAFragment;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        ProgressDialog progressDialog;
        if (i == 4) {
            progressDialog = this.f12712a.f12702g;
            progressDialog.dismiss();
            boolean unused = GoloUSAFragment.f12695n = true;
        }
        return true;
    }
}
