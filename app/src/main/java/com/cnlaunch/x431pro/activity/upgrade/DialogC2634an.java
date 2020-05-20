package com.cnlaunch.x431pro.activity.upgrade;

import android.content.Context;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.x431pro.widget.p290a.TipDialog;

/* compiled from: UpgradeFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.an */
/* loaded from: classes.dex */
final class DialogC2634an extends TipDialog {

    /* renamed from: a */
    final /* synthetic */ HandlerC2633am f15131a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogC2634an(HandlerC2633am handlerC2633am, Context context, String str, String str2) {
        super(context, str, str2, (byte) 0);
        this.f15131a = handlerC2633am;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.TipDialog
    /* renamed from: a */
    public final void mo4580a(int i, boolean z) {
        PreferencesManager preferencesManager;
        if (i == 1) {
            preferencesManager = this.f15131a.f15130a.f15118x;
            preferencesManager.m9587a("expired_remind", z);
        }
    }
}
