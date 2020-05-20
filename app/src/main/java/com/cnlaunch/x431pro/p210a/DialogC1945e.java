package com.cnlaunch.x431pro.p210a;

import android.content.Context;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.x431pro.widget.p290a.TipDialog;
import com.ifoer.expedition.pro.R;

/* compiled from: CommonTools.java */
/* renamed from: com.cnlaunch.x431pro.a.e */
/* loaded from: classes.dex */
public final class DialogC1945e extends TipDialog {

    /* renamed from: a */
    final /* synthetic */ Context f10544a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogC1945e(Context context, Context context2) {
        super(context, (int) R.string.tab_menu_navigatorpro, (int) R.string.navigatorpro_dialog_tips);
        this.f10544a = context2;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.TipDialog
    /* renamed from: a */
    public final void mo4580a(int i, boolean z) {
        if (i == 1) {
            if (z) {
                PreferencesManager.m9595a(this.f10544a).m9588a("show_navigatorpro_tips", "1");
            } else {
                PreferencesManager.m9595a(this.f10544a).m9588a("show_navigatorpro_tips", "0");
            }
            CommonTools.m7965c(this.f10544a);
        }
    }
}
