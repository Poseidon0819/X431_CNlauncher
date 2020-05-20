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
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.aq */
/* loaded from: classes.dex */
final class View$OnClickListenerC2128aq implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FaultCodeFragment f12015a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2128aq(FaultCodeFragment faultCodeFragment) {
        this.f12015a = faultCodeFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i;
        int i2;
        Context context;
        if (C2778n.m4905b()) {
            return;
        }
        i = this.f12015a.f12010y;
        if (i == -1) {
            context = this.f12015a.mContext;
            new MessageDialog(context).m4669a(this.f12015a.getString(R.string.dialog_title_default), this.f12015a.getString(R.string.toast_need_select_before));
            return;
        }
        IFragmentCallback iFragmentCallback = this.f12015a.f12357d;
        StringBuilder sb = new StringBuilder("01");
        i2 = this.f12015a.f12010y;
        sb.append(ByteHexHelper.intToTwoHexString(i2));
        iFragmentCallback.mo7093a(DiagnoseConstants.FEEDBACK_SPT_STD_EXT1, sb.toString(), 3);
    }
}
