package com.cnlaunch.x431pro.activity.diagnose.p218a;

import android.view.View;
import android.widget.TextView;
import com.cnlaunch.x431pro.activity.diagnose.p221d.DataStreamSelectFragment;

/* compiled from: DatastreamSelectListAdapter.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.a.g */
/* loaded from: classes.dex */
final class View$OnClickListenerC2020g implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f11328a;

    /* renamed from: b */
    final /* synthetic */ DatastreamSelectListAdapter f11329b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2020g(DatastreamSelectListAdapter datastreamSelectListAdapter, int i) {
        this.f11329b = datastreamSelectListAdapter;
        this.f11328a = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        DataStreamSelectFragment dataStreamSelectFragment;
        DataStreamSelectFragment dataStreamSelectFragment2;
        this.f11329b.m7512a(this.f11328a);
        dataStreamSelectFragment = this.f11329b.f11311d;
        if (dataStreamSelectFragment != null) {
            dataStreamSelectFragment2 = this.f11329b.f11311d;
            TextView textView = dataStreamSelectFragment2.f12411a;
            StringBuilder sb = new StringBuilder();
            sb.append(dataStreamSelectFragment2.f12412b.m7504e());
            textView.setText(sb.toString());
        }
    }
}
