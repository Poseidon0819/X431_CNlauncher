package com.cnlaunch.x431pro.activity.diagnose;

import android.content.Context;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.x431pro.widget.p290a.CustomInputDialog;

/* compiled from: DiagnoseActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.bg */
/* loaded from: classes.dex */
final class DialogC2073bg extends CustomInputDialog {

    /* renamed from: a */
    final /* synthetic */ C2071be f11541a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogC2073bg(C2071be c2071be, Context context, String str, String str2, int i, int i2, int i3, String str3) {
        super(context, str, str2, i, i2, i3, str3);
        this.f11541a = c2071be;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.CustomInputDialog
    /* renamed from: a */
    public final void mo4574a(String str) {
        this.f11541a.f11538d.mo7093a(DiagnoseConstants.FEEDBACK_SPT_INPUTSTRING_CUSTEOM, DiagnoseConstants.FEEDBACK_FAULTCODE_BACK.concat(String.valueOf(str)), 3);
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.CustomInputDialog
    /* renamed from: g_ */
    public final void mo4567g_() {
        this.f11541a.f11538d.mo7093a(DiagnoseConstants.FEEDBACK_SPT_INPUTSTRING_CUSTEOM, "00", 3);
    }
}
