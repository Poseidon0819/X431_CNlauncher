package com.cnlaunch.x431pro.activity.diagnose;

import android.os.Handler;
import android.os.Message;
import com.cnlaunch.x431pro.widget.button.IconRadioButton;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReportShowFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.bx */
/* loaded from: classes.dex */
public final class HandlerC2086bx extends Handler {

    /* renamed from: a */
    final /* synthetic */ ReportShowFragment f11670a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2086bx(ReportShowFragment reportShowFragment) {
        this.f11670a = reportShowFragment;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        IconRadioButton iconRadioButton;
        if (message2.what == 0) {
            iconRadioButton = this.f11670a.f11630ag;
            iconRadioButton.setChecked(false);
            return;
        }
        super.handleMessage(message2);
    }
}
