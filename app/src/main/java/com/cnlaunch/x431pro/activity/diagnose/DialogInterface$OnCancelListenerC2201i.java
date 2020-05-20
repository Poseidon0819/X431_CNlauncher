package com.cnlaunch.x431pro.activity.diagnose;

import android.content.DialogInterface;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CarIconFragmentForAll.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.i */
/* loaded from: classes.dex */
public final class DialogInterface$OnCancelListenerC2201i implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ CarIconFragmentForAll f12475a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterface$OnCancelListenerC2201i(CarIconFragmentForAll carIconFragmentForAll) {
        this.f12475a = carIconFragmentForAll;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        MessageDialog messageDialog;
        MessageDialog messageDialog2;
        messageDialog = this.f12475a.f11203ao;
        if (messageDialog != null) {
            messageDialog2 = this.f12475a.f11203ao;
            messageDialog2.dismiss();
        }
        CarIconFragmentForAll.m7538n(this.f12475a);
    }
}
