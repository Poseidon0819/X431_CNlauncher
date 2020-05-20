package com.cnlaunch.x431pro.activity.p211a;

import android.app.Activity;
import com.cnlaunch.x431pro.activity.p211a.HistoryFragment;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog;
import com.ifoer.expedition.pro.R;

/* compiled from: HistoryFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.a.e */
/* loaded from: classes.dex */
final class C1979e extends SelectMessageDialog {

    /* renamed from: a */
    final /* synthetic */ HistoryFragment f10873a;

    @Override // com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog
    /* renamed from: b */
    public final void mo4608b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1979e(HistoryFragment historyFragment) {
        this.f10873a = historyFragment;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog
    /* renamed from: a */
    public final void mo4611a() {
        HistoryFragment.DialogInterface$OnCancelListenerC1978a dialogInterface$OnCancelListenerC1978a;
        this.f10873a.f10842C = false;
        this.f10873a.request(10012, false);
        Activity activity = this.f10873a.getActivity();
        String string = this.f10873a.getString(R.string.custom_diaglog_message);
        dialogInterface$OnCancelListenerC1978a = this.f10873a.f10846G;
        LoadDialog.m4683a(activity, string, dialogInterface$OnCancelListenerC1978a);
    }
}
