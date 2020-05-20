package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.widget.button.IconRadioButton;
import com.cnlaunch.x431pro.widget.p290a.WaitDialog;
import com.ifoer.expedition.pro.R;

/* compiled from: FaultCodeFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.ar */
/* loaded from: classes.dex */
final class HandlerC2129ar extends Handler {

    /* renamed from: a */
    final /* synthetic */ FaultCodeFragment f12016a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2129ar(FaultCodeFragment faultCodeFragment) {
        this.f12016a = faultCodeFragment;
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
            progressBar = this.f12016a.f11981B;
            progressBar.setProgress(message2.arg1);
        } else if (i != 131313) {
        } else {
            context = this.f12016a.mContext;
            NToast.m9450a(context, (int) R.string.translation_failure);
            waitDialog = this.f12016a.f11980A;
            waitDialog.dismiss();
            FaultCodeFragment.m7243i(this.f12016a);
            FaultCodeFragment.m7242j(this.f12016a);
            iconRadioButton = this.f12016a.f12004s;
            iconRadioButton.setChecked(false);
            iconRadioButton2 = this.f12016a.f12004s;
            iconRadioButton2.setEnabled(true);
        }
    }
}
