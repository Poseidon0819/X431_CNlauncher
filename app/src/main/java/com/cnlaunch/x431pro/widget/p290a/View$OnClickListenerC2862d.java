package com.cnlaunch.x431pro.widget.p290a;

import android.view.View;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CustomBtnDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.a.d */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2862d implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CustomBtnDialog f16397a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2862d(CustomBtnDialog customBtnDialog) {
        this.f16397a = customBtnDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        IFragmentCallback iFragmentCallback;
        IFragmentCallback iFragmentCallback2;
        StringBuilder sb = new StringBuilder();
        sb.append(view.getId());
        String sb2 = sb.toString();
        iFragmentCallback = this.f16397a.f16347a;
        if (iFragmentCallback != null) {
            iFragmentCallback2 = this.f16397a.f16347a;
            iFragmentCallback2.mo7093a(DiagnoseConstants.FEEDBACK_MESSAGEBOX_TEXT_CUSTOMBUTTON, sb2, 3);
        }
        this.f16397a.dismiss();
    }
}
