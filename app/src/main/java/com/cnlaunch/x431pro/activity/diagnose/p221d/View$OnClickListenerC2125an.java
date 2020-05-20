package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.content.Context;
import android.view.View;
import com.cnlaunch.diagnosemodule.utils.ByteHexHelper;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.x431pro.utils.C2778n;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;
import com.ifoer.expedition.pro.R;

/* compiled from: FaultCodeFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.an */
/* loaded from: classes.dex */
final class View$OnClickListenerC2125an implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FaultCodeFragment f12012a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2125an(FaultCodeFragment faultCodeFragment) {
        this.f12012a = faultCodeFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i;
        int i2;
        Context context;
        i = this.f12012a.f12010y;
        if (i == -1) {
            context = this.f12012a.mContext;
            new MessageDialog(context).m4669a(this.f12012a.getString(R.string.dialog_title_default), this.f12012a.getString(R.string.toast_need_select_before));
        } else if (C2778n.m4905b()) {
        } else {
            StringBuilder sb = new StringBuilder("00000302");
            i2 = this.f12012a.f12010y;
            sb.append(ByteHexHelper.intToTwoHexString(i2));
            this.f12012a.f12357d.mo7093a(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, sb.toString(), 3);
        }
    }
}
