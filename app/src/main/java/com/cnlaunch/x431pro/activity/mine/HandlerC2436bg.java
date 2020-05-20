package com.cnlaunch.x431pro.activity.mine;

import android.os.Handler;
import android.os.Message;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: PDFReportFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.bg */
/* loaded from: classes.dex */
final class HandlerC2436bg extends Handler {

    /* renamed from: a */
    final /* synthetic */ PDFReportFragment f13930a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2436bg(PDFReportFragment pDFReportFragment) {
        this.f13930a = pDFReportFragment;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        AtomicInteger atomicInteger;
        AtomicInteger atomicInteger2;
        if (message2.what == 0) {
            atomicInteger = this.f13930a.f13920h;
            if (atomicInteger.get() == 2) {
                new C2437bh(this).start();
            }
            atomicInteger2 = this.f13930a.f13920h;
            atomicInteger2.set(1);
        }
        super.handleMessage(message2);
    }
}
