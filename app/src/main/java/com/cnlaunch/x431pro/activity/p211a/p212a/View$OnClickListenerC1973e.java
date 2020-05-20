package com.cnlaunch.x431pro.activity.p211a.p212a;

import android.view.View;
import com.cnlaunch.x431pro.activity.p211a.HistoryFragment;

/* compiled from: HistoryDiagDesItemAdapter.java */
/* renamed from: com.cnlaunch.x431pro.activity.a.a.e */
/* loaded from: classes.dex */
final class View$OnClickListenerC1973e implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f10824a;

    /* renamed from: b */
    final /* synthetic */ HistoryDiagDesItemAdapter f10825b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1973e(HistoryDiagDesItemAdapter historyDiagDesItemAdapter, int i) {
        this.f10825b = historyDiagDesItemAdapter;
        this.f10824a = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        HistoryFragment historyFragment;
        HistoryFragment historyFragment2;
        z = this.f10825b.f10812g;
        if (!z) {
            historyFragment = this.f10825b.f10808c;
            if (historyFragment != null) {
                historyFragment2 = this.f10825b.f10808c;
                historyFragment2.m7837b(this.f10824a);
                return;
            }
            return;
        }
        this.f10825b.m7846a(this.f10824a);
    }
}
