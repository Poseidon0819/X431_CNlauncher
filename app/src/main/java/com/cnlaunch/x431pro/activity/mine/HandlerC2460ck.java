package com.cnlaunch.x431pro.activity.mine;

import android.os.Handler;
import android.os.Message;
import com.cnlaunch.x431pro.widget.button.IconRadioButton;

/* compiled from: ReadReportFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.ck */
/* loaded from: classes.dex */
final class HandlerC2460ck extends Handler {

    /* renamed from: a */
    final /* synthetic */ ReadReportFragment f14064a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2460ck(ReadReportFragment readReportFragment) {
        this.f14064a = readReportFragment;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        IconRadioButton iconRadioButton;
        if (message2.what == 0) {
            iconRadioButton = this.f14064a.f14054f;
            iconRadioButton.setChecked(false);
            return;
        }
        super.handleMessage(message2);
    }
}
