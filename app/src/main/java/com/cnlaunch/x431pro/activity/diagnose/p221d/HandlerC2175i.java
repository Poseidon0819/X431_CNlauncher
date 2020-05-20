package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.widget.button.IconRadioButton;
import com.cnlaunch.x431pro.widget.p290a.WaitDialog;
import com.ifoer.expedition.pro.R;

/* compiled from: ActiveTestFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.i */
/* loaded from: classes.dex */
final class HandlerC2175i extends Handler {

    /* renamed from: a */
    final /* synthetic */ ActiveTestFragment f12336a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2175i(ActiveTestFragment activeTestFragment) {
        this.f12336a = activeTestFragment;
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
            progressBar = this.f12336a.f11849A;
            progressBar.setProgress(message2.arg1);
        } else if (i != 131313) {
        } else {
            context = this.f12336a.mContext;
            NToast.m9450a(context, (int) R.string.translation_failure);
            ActiveTestFragment.m7305r(this.f12336a);
            waitDialog = this.f12336a.f11877z;
            waitDialog.dismiss();
            iconRadioButton = this.f12336a.f11867p;
            iconRadioButton.setChecked(false);
            iconRadioButton2 = this.f12336a.f11867p;
            iconRadioButton2.setEnabled(true);
        }
    }
}
