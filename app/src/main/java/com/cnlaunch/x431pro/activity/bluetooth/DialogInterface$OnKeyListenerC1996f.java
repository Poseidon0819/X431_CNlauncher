package com.cnlaunch.x431pro.activity.bluetooth;

import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import com.cnlaunch.p120d.p130d.NToast;
import com.ifoer.expedition.pro.R;

/* compiled from: DownloadBinActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.bluetooth.f */
/* loaded from: classes.dex */
final class DialogInterface$OnKeyListenerC1996f implements DialogInterface.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ DownloadBinActivity f10952a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterface$OnKeyListenerC1996f(DownloadBinActivity downloadBinActivity) {
        this.f10952a = downloadBinActivity;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Context context;
        if (i == 4) {
            context = this.f10952a.f10912c;
            NToast.m9444c(context, (int) R.string.downloadbin_exit_hit);
            return true;
        }
        return true;
    }
}
