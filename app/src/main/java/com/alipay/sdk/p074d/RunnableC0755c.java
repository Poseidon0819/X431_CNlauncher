package com.alipay.sdk.p074d;

import com.alipay.sdk.p074d.C0752a;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.alipay.sdk.d.c */
/* loaded from: classes.dex */
public final class RunnableC0755c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0752a f3553a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0755c(C0752a c0752a) {
        this.f3553a = c0752a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0752a.AlertDialogC0753a alertDialogC0753a;
        C0752a.AlertDialogC0753a alertDialogC0753a2;
        alertDialogC0753a = this.f3553a.f3548b;
        if (alertDialogC0753a != null) {
            try {
                alertDialogC0753a2 = this.f3553a.f3548b;
                alertDialogC0753a2.dismiss();
            } catch (Exception unused) {
            }
        }
    }
}
