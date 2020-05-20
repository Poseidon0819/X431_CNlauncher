package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.view.View;
import com.cnlaunch.x431pro.activity.diagnose.p218a.DatastreamSelectListAdapter;

/* compiled from: DataStreamSelectFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.z */
/* loaded from: classes.dex */
final class View$OnLongClickListenerC2184z implements View.OnLongClickListener {

    /* renamed from: a */
    final /* synthetic */ DataStreamSelectFragment f12426a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnLongClickListenerC2184z(DataStreamSelectFragment dataStreamSelectFragment) {
        this.f12426a = dataStreamSelectFragment;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        DatastreamSelectListAdapter datastreamSelectListAdapter;
        DataStreamSelectFragment.m7103a(this.f12426a);
        datastreamSelectListAdapter = this.f12426a.f12412b;
        datastreamSelectListAdapter.m7513a();
        return false;
    }
}
