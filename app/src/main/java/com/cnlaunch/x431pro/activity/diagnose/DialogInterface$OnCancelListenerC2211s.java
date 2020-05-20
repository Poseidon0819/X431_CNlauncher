package com.cnlaunch.x431pro.activity.diagnose;

import android.content.Context;
import android.content.DialogInterface;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.x431pro.widget.p290a.BaseDialog;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CarIconFragmentForAll.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.s */
/* loaded from: classes.dex */
public final class DialogInterface$OnCancelListenerC2211s implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ CarIconFragmentForAll f12485a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterface$OnCancelListenerC2211s(CarIconFragmentForAll carIconFragmentForAll) {
        this.f12485a = carIconFragmentForAll;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Context context;
        BaseDialog baseDialog;
        context = this.f12485a.mContext;
        PreferencesManager.m9595a(context).m9589a("remind_update_time", System.currentTimeMillis());
        baseDialog = this.f12485a.f11200ak;
        baseDialog.dismiss();
    }
}
