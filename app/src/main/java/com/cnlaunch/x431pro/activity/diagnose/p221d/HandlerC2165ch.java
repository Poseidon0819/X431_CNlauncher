package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.widget.button.IconRadioButton;
import com.cnlaunch.x431pro.widget.p290a.WaitDialog;
import com.ifoer.expedition.pro.R;

/* compiled from: SystemStatusCodeFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.ch */
/* loaded from: classes.dex */
final class HandlerC2165ch extends Handler {

    /* renamed from: a */
    final /* synthetic */ SystemStatusCodeFragment f12287a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2165ch(SystemStatusCodeFragment systemStatusCodeFragment) {
        this.f12287a = systemStatusCodeFragment;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        ProgressBar progressBar;
        Context context;
        WaitDialog waitDialog;
        IconRadioButton iconRadioButton;
        IconRadioButton iconRadioButton2;
        int i = message2.what;
        if (i == 121212) {
            progressBar = this.f12287a.f12242F;
            progressBar.setProgress(message2.arg1);
        } else if (i != 131313) {
        } else {
            context = this.f12287a.mContext;
            NToast.m9450a(context, (int) R.string.translation_failure);
            waitDialog = this.f12287a.f12241E;
            waitDialog.dismiss();
            SystemStatusCodeFragment.m7141i(this.f12287a);
            SystemStatusCodeFragment.m7140j(this.f12287a);
            iconRadioButton = this.f12287a.f12277s;
            iconRadioButton.setChecked(false);
            iconRadioButton2 = this.f12287a.f12277s;
            iconRadioButton2.setEnabled(true);
        }
    }
}
