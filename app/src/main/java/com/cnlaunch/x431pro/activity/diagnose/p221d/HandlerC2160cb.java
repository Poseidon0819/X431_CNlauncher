package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.widget.button.IconRadioButton;
import com.cnlaunch.x431pro.widget.p290a.WaitDialog;
import com.ifoer.expedition.pro.R;

/* compiled from: SpeciaFunctionFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.cb */
/* loaded from: classes.dex */
final class HandlerC2160cb extends Handler {

    /* renamed from: a */
    final /* synthetic */ SpeciaFunctionFragment f12234a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2160cb(SpeciaFunctionFragment speciaFunctionFragment) {
        this.f12234a = speciaFunctionFragment;
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
            progressBar = this.f12234a.f12221y;
            progressBar.setProgress(message2.arg1);
        } else if (i != 131313) {
        } else {
            context = this.f12234a.mContext;
            NToast.m9450a(context, (int) R.string.translation_failure);
            waitDialog = this.f12234a.f12220x;
            waitDialog.dismiss();
            this.f12234a.f12201O = true;
            iconRadioButton = this.f12234a.f12217u;
            iconRadioButton.setChecked(false);
            iconRadioButton2 = this.f12234a.f12217u;
            iconRadioButton2.setEnabled(true);
        }
    }
}
