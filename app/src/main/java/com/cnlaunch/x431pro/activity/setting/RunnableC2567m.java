package com.cnlaunch.x431pro.activity.setting;

import android.content.Context;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;
import com.ifoer.expedition.pro.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DiagnosticLogVehicleListFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.m */
/* loaded from: classes.dex */
public final class RunnableC2567m implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C2565k f14836a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2567m(C2565k c2565k) {
        this.f14836a = c2565k;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        Context context;
        Context context2;
        DiagnosticLogVehicleListFragment.m5901i(this.f14836a.f14834a);
        z = this.f14836a.f14834a.f14826i;
        if (z) {
            context2 = this.f14836a.f14834a.mContext;
            MessageDialog messageDialog = new MessageDialog(context2, (int) R.string.common_title_tips, (int) R.string.feedback_update_success_tip, false, (byte) 0);
            messageDialog.m4719a(R.string.btn_confirm, true, new View$OnClickListenerC2568n(this));
            messageDialog.m4717b(R.string.btn_canlce, true, new View$OnClickListenerC2569o(this));
            if (this.f14836a.f14834a.getActivity().isFinishing()) {
                return;
            }
            messageDialog.show();
            return;
        }
        context = this.f14836a.f14834a.mContext;
        MessageDialog messageDialog2 = new MessageDialog(context, (int) R.string.common_title_tips, (int) R.string.txt_update_ok, false, (byte) 0);
        messageDialog2.m4719a(R.string.btn_confirm, true, new View$OnClickListenerC2570p(this));
        if (this.f14836a.f14834a.getActivity().isFinishing()) {
            return;
        }
        messageDialog2.show();
    }
}
