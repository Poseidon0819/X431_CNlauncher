package com.cnlaunch.x431pro.activity.diagnose;

import android.content.Context;
import android.view.View;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DiagnoseActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.z */
/* loaded from: classes.dex */
public final class DialogC2218z extends MessageDialog {

    /* renamed from: a */
    final /* synthetic */ DiagnoseActivity f12494a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogC2218z(DiagnoseActivity diagnoseActivity, Context context) {
        super(context);
        this.f12494a = diagnoseActivity;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog
    /* renamed from: a */
    public final void mo4579a(View view, int i) {
        this.f12494a.m7620n();
        this.f12494a.m7598y();
        dismiss();
    }
}
