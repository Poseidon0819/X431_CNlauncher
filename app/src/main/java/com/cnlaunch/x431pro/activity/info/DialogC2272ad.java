package com.cnlaunch.x431pro.activity.info;

import android.content.Context;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.x431pro.widget.p290a.TipDialog;
import com.ifoer.expedition.pro.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RepairInfoActivityFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.info.ad */
/* loaded from: classes.dex */
public final class DialogC2272ad extends TipDialog {

    /* renamed from: a */
    final /* synthetic */ Context f12875a;

    /* renamed from: b */
    final /* synthetic */ FragmentC2297z f12876b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogC2272ad(FragmentC2297z fragmentC2297z, Context context, Context context2) {
        super(context, (int) R.string.common_title_tips, (int) R.string.repair_infomation_instruction);
        this.f12876b = fragmentC2297z;
        this.f12875a = context2;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.TipDialog
    /* renamed from: a */
    public final void mo4580a(int i, boolean z) {
        if (i == 1) {
            PreferencesManager.m9595a(this.f12875a).m9588a("show_cy_infomation_tips", z ? "1" : "0");
            this.f12876b.m6815a(false);
            dismiss();
        }
    }
}
