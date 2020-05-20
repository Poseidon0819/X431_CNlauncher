package com.cnlaunch.x431pro.activity.p211a;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import com.cnlaunch.x431pro.activity.p211a.p212a.HistoryDiagDesItemAdapter;
import com.cnlaunch.x431pro.activity.p211a.p212a.HistoryListViewAdapter;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;
import java.util.List;

/* compiled from: HistoryFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.a.f */
/* loaded from: classes.dex */
final class C1980f implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ List f10874a;

    /* renamed from: b */
    final /* synthetic */ HistoryFragment f10875b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1980f(HistoryFragment historyFragment, List list) {
        this.f10875b = historyFragment;
        this.f10874a = list;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        TextView textView;
        HistoryListViewAdapter historyListViewAdapter;
        HistoryListViewAdapter historyListViewAdapter2;
        HistoryListViewAdapter historyListViewAdapter3;
        HistoryDiagDesItemAdapter historyDiagDesItemAdapter;
        HistoryDiagDesItemAdapter historyDiagDesItemAdapter2;
        Context context;
        Context context2;
        if (i >= 0) {
            try {
                String str = (String) this.f10874a.get(i);
                textView = this.f10875b.f10858m;
                if (str.equals(textView.getText().toString())) {
                    return;
                }
                HistoryFragment.m7839a(this.f10875b, str);
                historyListViewAdapter = this.f10875b.f10861p;
                historyListViewAdapter.f10828a = null;
                historyListViewAdapter2 = this.f10875b.f10861p;
                historyListViewAdapter2.f10831d = null;
                historyListViewAdapter3 = this.f10875b.f10861p;
                historyListViewAdapter3.notifyDataSetChanged();
                historyDiagDesItemAdapter = this.f10875b.f10862q;
                historyDiagDesItemAdapter.f10806a = null;
                historyDiagDesItemAdapter2 = this.f10875b.f10862q;
                historyDiagDesItemAdapter2.notifyDataSetChanged();
                context = this.f10875b.mContext;
                context2 = this.f10875b.mContext;
                LoadDialog.m4684a(context, context2.getString(R.string.refresh_txt));
                this.f10875b.request(10010, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
