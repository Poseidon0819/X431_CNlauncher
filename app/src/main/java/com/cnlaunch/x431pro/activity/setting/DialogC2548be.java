package com.cnlaunch.x431pro.activity.setting;

import android.content.Context;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.x431pro.widget.p290a.TipDialog;
import com.ifoer.expedition.pro.R;

/* compiled from: SettingFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.be */
/* loaded from: classes.dex */
final class DialogC2548be extends TipDialog {

    /* renamed from: a */
    final /* synthetic */ SettingFragment f14681a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogC2548be(SettingFragment settingFragment, Context context) {
        super(context, (int) R.string.feedback_information_prompt, (int) R.string.feedback_information_content);
        this.f14681a = settingFragment;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.TipDialog
    /* renamed from: a */
    public final void mo4580a(int i, boolean z) {
        if (i == 1) {
            PreferencesManager.m9595a((Context) this.f14681a.getActivity()).m9587a("is_show_diaglog_tip", z);
        }
    }
}
