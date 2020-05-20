package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.view.View;
import android.widget.AdapterView;
import java.util.List;

/* compiled from: ActiveTestFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.g */
/* loaded from: classes.dex */
final class C2173g implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ List f12330a;

    /* renamed from: b */
    final /* synthetic */ View$OnClickListenerC2172f f12331b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2173g(View$OnClickListenerC2172f view$OnClickListenerC2172f, List list) {
        this.f12331b = view$OnClickListenerC2172f;
        this.f12330a = list;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f12331b.f12328b.setText((CharSequence) this.f12330a.get(i));
    }
}
