package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.view.View;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MulitInputFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.bh */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2143bh implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MulitInputFragment f12095a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2143bh(MulitInputFragment mulitInputFragment) {
        this.f12095a = mulitInputFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f12095a.f12357d.mo7089a(DiagnoseConstants.FEEDBACK_SPT_MULTI_INPUT_COMB_WINDOW, new byte[]{0});
    }
}
