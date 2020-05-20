package com.unionpay.mobile.android.upviews;

import com.unionpay.mobile.android.upviews.C4346b;
import java.util.TimerTask;

/* renamed from: com.unionpay.mobile.android.upviews.c */
/* loaded from: classes2.dex */
final class C4351c extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ C4346b.C4350d f23038a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4351c(C4346b.C4350d c4350d) {
        this.f23038a = c4350d;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        boolean z;
        z = C4346b.this.f23034e;
        if (!z) {
            C4346b.this.f23031b.sendEmptyMessage(3);
        }
        C4346b.this.f23033d.cancel();
        C4346b.this.f23033d.purge();
    }
}
