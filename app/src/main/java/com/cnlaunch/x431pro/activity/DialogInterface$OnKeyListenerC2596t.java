package com.cnlaunch.x431pro.activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.view.KeyEvent;

/* compiled from: MainActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.t */
/* loaded from: classes.dex */
final class DialogInterface$OnKeyListenerC2596t implements DialogInterface.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ MainActivity f14959a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterface$OnKeyListenerC2596t(MainActivity mainActivity) {
        this.f14959a = mainActivity;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        ProgressDialog progressDialog;
        if (i == 4) {
            progressDialog = this.f14959a.f10716E;
            progressDialog.dismiss();
            boolean unused = MainActivity.f10707N = true;
        }
        return true;
    }
}
