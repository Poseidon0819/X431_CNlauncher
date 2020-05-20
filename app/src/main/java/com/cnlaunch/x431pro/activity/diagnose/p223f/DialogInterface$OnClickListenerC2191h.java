package com.cnlaunch.x431pro.activity.diagnose.p223f;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;

/* compiled from: MessageBoxDialog.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.f.h */
/* loaded from: classes.dex */
public final class DialogInterface$OnClickListenerC2191h implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MessageBoxDialog f12457a;

    public DialogInterface$OnClickListenerC2191h(MessageBoxDialog messageBoxDialog) {
        this.f12457a = messageBoxDialog;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        try {
            this.f12457a.f12455c.send(Message.obtain((Handler) null, 5));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
