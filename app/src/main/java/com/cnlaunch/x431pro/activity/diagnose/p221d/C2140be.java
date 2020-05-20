package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.view.View;
import android.widget.AdapterView;
import java.util.List;

/* compiled from: MulitInputFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.be */
/* loaded from: classes.dex */
final class C2140be implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ List f12088a;

    /* renamed from: b */
    final /* synthetic */ View$OnClickListenerC2139bd f12089b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2140be(View$OnClickListenerC2139bd view$OnClickListenerC2139bd, List list) {
        this.f12089b = view$OnClickListenerC2139bd;
        this.f12088a = list;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f12089b.f12086b.setText((CharSequence) this.f12088a.get(i));
    }
}
