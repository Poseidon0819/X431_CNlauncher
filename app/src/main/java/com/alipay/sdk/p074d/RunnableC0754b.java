package com.alipay.sdk.p074d;

import com.alipay.sdk.p074d.C0752a;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.alipay.sdk.d.b */
/* loaded from: classes.dex */
public final class RunnableC0754b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0752a f3552a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0754b(C0752a c0752a) {
        this.f3552a = c0752a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0752a.AlertDialogC0753a alertDialogC0753a;
        C0752a.AlertDialogC0753a alertDialogC0753a2;
        C0752a.AlertDialogC0753a alertDialogC0753a3;
        alertDialogC0753a = this.f3552a.f3548b;
        if (alertDialogC0753a == null) {
            C0752a c0752a = this.f3552a;
            c0752a.f3548b = new C0752a.AlertDialogC0753a(c0752a.f3549c);
        }
        try {
            alertDialogC0753a2 = this.f3552a.f3548b;
            if (alertDialogC0753a2.isShowing()) {
                return;
            }
            alertDialogC0753a3 = this.f3552a.f3548b;
            alertDialogC0753a3.show();
        } catch (Exception unused) {
        }
    }
}
