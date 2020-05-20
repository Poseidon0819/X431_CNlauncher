package com.cnlaunch.x431pro.activity.diagnose.p221d;

import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog;

/* compiled from: ChooseFileFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.s */
/* loaded from: classes.dex */
final class C2180s extends SelectMessageDialog {

    /* renamed from: a */
    final /* synthetic */ ChooseFileFragment f12376a;

    @Override // com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog
    /* renamed from: b */
    public final void mo4608b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2180s(ChooseFileFragment chooseFileFragment) {
        this.f12376a = chooseFileFragment;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog
    /* renamed from: a */
    public final void mo4611a() {
        this.f12376a.f12357d.mo7093a(DiagnoseConstants.FEEDBACK_SELECT_FILEDIALOG, "00", 3);
    }
}
