package com.cnlaunch.x431pro.activity.upgrade;

import android.content.Context;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.x431pro.widget.p290a.TipDialog;

/* compiled from: UpgradeFragmentForPro.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.ay */
/* loaded from: classes.dex */
final class DialogC2646ay extends TipDialog {

    /* renamed from: a */
    final /* synthetic */ HandlerC2645ax f15231a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogC2646ay(HandlerC2645ax handlerC2645ax, Context context, String str, String str2) {
        super(context, str, str2, (byte) 0);
        this.f15231a = handlerC2645ax;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.TipDialog
    /* renamed from: a */
    public final void mo4580a(int i, boolean z) {
        PreferencesManager preferencesManager;
        if (i == 1) {
            preferencesManager = this.f15231a.f15230a.f15152O;
            preferencesManager.m9587a("expired_remind", z);
        }
    }
}
