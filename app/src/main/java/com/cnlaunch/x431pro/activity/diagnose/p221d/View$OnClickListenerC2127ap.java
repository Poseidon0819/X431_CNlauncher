package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.content.Context;
import android.view.View;
import com.cnlaunch.diagnosemodule.utils.ByteHexHelper;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback;
import com.cnlaunch.x431pro.utils.C2778n;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;
import com.ifoer.expedition.pro.R;

/* compiled from: FaultCodeFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.ap */
/* loaded from: classes.dex */
final class View$OnClickListenerC2127ap implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FaultCodeFragment f12014a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2127ap(FaultCodeFragment faultCodeFragment) {
        this.f12014a = faultCodeFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i;
        int i2;
        Context context;
        if (C2778n.m4905b()) {
            return;
        }
        i = this.f12014a.f12010y;
        if (i == -1) {
            context = this.f12014a.mContext;
            new MessageDialog(context).m4669a(this.f12014a.getString(R.string.dialog_title_default), this.f12014a.getString(R.string.toast_need_select_before));
            return;
        }
        IFragmentCallback iFragmentCallback = this.f12014a.f12357d;
        i2 = this.f12014a.f12010y;
        iFragmentCallback.mo7093a(DiagnoseConstants.FEEDBACK_TROUBLE_CODE_ID_EX_RETURN_VALUE, ByteHexHelper.intToTwoHexString(i2 + 1), 3);
    }
}
