package com.cnlaunch.x431pro.activity;

import android.content.Context;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.x431pro.widget.p290a.TipDialog;
import com.ifoer.expedition.pro.R;

/* compiled from: MainActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.r */
/* loaded from: classes.dex */
final class DialogC2513r extends TipDialog {

    /* renamed from: a */
    final /* synthetic */ MainActivity f14452a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogC2513r(MainActivity mainActivity, Context context) {
        super(context, (int) R.string.feedback_information_prompt, (int) R.string.feedback_information_content, false);
        this.f14452a = mainActivity;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.TipDialog
    /* renamed from: a */
    public final void mo4580a(int i, boolean z) {
        PreferencesManager preferencesManager;
        if (i == 1) {
            preferencesManager = this.f14452a.f10742h;
            preferencesManager.m9587a("is_show_diaglog_tip", z);
        }
    }
}
