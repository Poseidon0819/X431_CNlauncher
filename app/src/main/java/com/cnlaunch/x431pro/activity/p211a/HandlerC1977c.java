package com.cnlaunch.x431pro.activity.p211a;

import android.os.Handler;
import android.os.Message;
import com.cnlaunch.x431pro.widget.button.IconRadioButton;

/* compiled from: HistoricalRecordsFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.a.c */
/* loaded from: classes.dex */
final class HandlerC1977c extends Handler {

    /* renamed from: a */
    final /* synthetic */ HistoricalRecordsFragment f10839a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC1977c(HistoricalRecordsFragment historicalRecordsFragment) {
        this.f10839a = historicalRecordsFragment;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        IconRadioButton iconRadioButton;
        if (message2.what == 0) {
            iconRadioButton = this.f10839a.f10764B;
            iconRadioButton.setChecked(false);
            return;
        }
        super.handleMessage(message2);
    }
}
