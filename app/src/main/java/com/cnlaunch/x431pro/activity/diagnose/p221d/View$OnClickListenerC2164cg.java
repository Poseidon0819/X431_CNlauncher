package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.content.Context;
import android.view.View;
import com.cnlaunch.diagnosemodule.bean.BasicSystemStatusBean;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;

/* compiled from: SystemStatusCodeFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.cg */
/* loaded from: classes.dex */
final class View$OnClickListenerC2164cg implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SystemStatusCodeFragment f12286a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2164cg(SystemStatusCodeFragment systemStatusCodeFragment) {
        this.f12286a = systemStatusCodeFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int[] iArr;
        ArrayList arrayList;
        int[] iArr2;
        int m7149b;
        int[] iArr3;
        Context context;
        iArr = this.f12286a.f12258V;
        if (iArr[0] == -1) {
            context = this.f12286a.mContext;
            new MessageDialog(context).m4669a(this.f12286a.getString(R.string.dialog_title_default), this.f12286a.getString(R.string.toast_need_select_before));
            return;
        }
        arrayList = this.f12286a.f12263a;
        iArr2 = this.f12286a.f12258V;
        m7149b = this.f12286a.m7149b(((BasicSystemStatusBean) arrayList.get(iArr2[0])).getSystemName());
        iArr3 = this.f12286a.f12258V;
        int i = iArr3[1];
        this.f12286a.f12357d.mo7093a(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, "00000301" + SystemStatusCodeFragment.m7151b(m7149b) + SystemStatusCodeFragment.m7151b(i), 3);
    }
}
