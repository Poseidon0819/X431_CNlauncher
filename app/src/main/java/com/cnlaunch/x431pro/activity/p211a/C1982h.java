package com.cnlaunch.x431pro.activity.p211a;

import android.view.View;
import android.widget.AdapterView;
import com.cnlaunch.x431pro.activity.p211a.p212a.HistoryDiagDesItemAdapter;
import com.cnlaunch.x431pro.activity.p211a.p212a.HistoryListViewAdapter;

/* compiled from: HistoryFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.a.h */
/* loaded from: classes.dex */
final class C1982h implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ HistoryFragment f10877a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1982h(HistoryFragment historyFragment) {
        this.f10877a = historyFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        View view2;
        HistoryListViewAdapter historyListViewAdapter;
        View view3;
        View view4;
        HistoryListViewAdapter historyListViewAdapter2;
        int i2;
        int i3;
        HistoryDiagDesItemAdapter historyDiagDesItemAdapter;
        int i4;
        View view5;
        view2 = this.f10877a.f10865t;
        if (view2 == view) {
            return;
        }
        historyListViewAdapter = this.f10877a.f10861p;
        if (historyListViewAdapter.f10829b != null) {
            historyListViewAdapter.f10829b.setBackgroundColor(0);
        }
        view3 = this.f10877a.f10865t;
        if (view3 != null) {
            view5 = this.f10877a.f10865t;
            view5.setBackgroundColor(0);
        }
        this.f10877a.f10865t = view;
        view4 = this.f10877a.f10865t;
        view4.setBackgroundColor(-14540254);
        this.f10877a.f10866u = i;
        historyListViewAdapter2 = this.f10877a.f10861p;
        i2 = this.f10877a.f10866u;
        historyListViewAdapter2.f10830c = i2;
        this.f10877a.m7822j();
        i3 = this.f10877a.f10867v;
        if (i3 != -1) {
            HistoryFragment.m7815o(this.f10877a);
            historyDiagDesItemAdapter = this.f10877a.f10862q;
            i4 = this.f10877a.f10867v;
            historyDiagDesItemAdapter.f10807b = i4;
        }
    }
}
