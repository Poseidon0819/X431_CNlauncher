package com.cnlaunch.x431pro.widget.p290a;

import android.widget.TextView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProgressDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.a.bv */
/* loaded from: classes.dex */
public final class RunnableC2838bv implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f16335a;

    /* renamed from: b */
    final /* synthetic */ ProgressDialog f16336b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2838bv(ProgressDialog progressDialog, int i) {
        this.f16336b = progressDialog;
        this.f16335a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TextView textView;
        textView = this.f16336b.f16326g;
        textView.setTextColor(this.f16336b.getContext().getResources().getColor(this.f16335a));
    }
}
