package com.cnlaunch.x431pro.activity.p211a.p212a;

import android.view.View;

/* compiled from: HistoryDiagDesItemAdapter.java */
/* renamed from: com.cnlaunch.x431pro.activity.a.a.f */
/* loaded from: classes.dex */
final class View$OnClickListenerC1974f implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f10826a;

    /* renamed from: b */
    final /* synthetic */ HistoryDiagDesItemAdapter f10827b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1974f(HistoryDiagDesItemAdapter historyDiagDesItemAdapter, int i) {
        this.f10827b = historyDiagDesItemAdapter;
        this.f10826a = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f10827b.m7846a(this.f10826a);
    }
}
