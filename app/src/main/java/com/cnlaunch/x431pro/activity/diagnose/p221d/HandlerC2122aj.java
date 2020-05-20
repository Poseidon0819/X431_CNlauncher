package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.widget.button.IconRadioButton;
import com.cnlaunch.x431pro.widget.p290a.WaitDialog;
import com.ifoer.expedition.pro.R;

/* compiled from: DataStreamShowFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.aj */
/* loaded from: classes.dex */
final class HandlerC2122aj extends Handler {

    /* renamed from: a */
    final /* synthetic */ DataStreamShowFragment f11977a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2122aj(DataStreamShowFragment dataStreamShowFragment) {
        this.f11977a = dataStreamShowFragment;
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
            progressBar = this.f11977a.f11940ar;
            progressBar.setProgress(message2.arg1);
        } else if (i != 131313) {
        } else {
            context = this.f11977a.mContext;
            NToast.m9450a(context, (int) R.string.translation_failure);
            waitDialog = this.f11977a.f11939aq;
            waitDialog.dismiss();
            DataStreamShowFragment.m7258y(this.f11977a);
            iconRadioButton = this.f11977a.f11956u;
            iconRadioButton.setChecked(false);
            iconRadioButton2 = this.f11977a.f11956u;
            iconRadioButton2.setEnabled(true);
        }
    }
}
