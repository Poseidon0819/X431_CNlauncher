package com.cnlaunch.x431pro.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.cnlaunch.x431pro.activity.MainActivity;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;
import com.ifoer.expedition.pro.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Tools.java */
/* renamed from: com.cnlaunch.x431pro.utils.ab */
/* loaded from: classes.dex */
public final class DialogC2745ab extends MessageDialog {

    /* renamed from: a */
    final /* synthetic */ Activity f15713a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogC2745ab(Context context, Activity activity) {
        super(context);
        this.f15713a = activity;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog
    /* renamed from: a */
    public final void mo4579a(View view, int i) {
        super.mo4579a(view, i);
        Activity activity = this.f15713a;
        if (activity instanceof MainActivity) {
            ((MainActivity) activity).m7894b(R.id.btn_upgrade);
        } else {
            ((MainActivity) activity.getParent()).m7894b(R.id.btn_upgrade);
        }
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog
    /* renamed from: b */
    public final void mo4577b(View view, int i) {
        super.mo4577b(view, i);
    }
}
