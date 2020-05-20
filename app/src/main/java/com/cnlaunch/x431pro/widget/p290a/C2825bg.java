package com.cnlaunch.x431pro.widget.p290a;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: MulitInputDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.a.bg */
/* loaded from: classes.dex */
final class C2825bg implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ View$OnClickListenerC2824bf f16285a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2825bg(View$OnClickListenerC2824bf view$OnClickListenerC2824bf) {
        this.f16285a = view$OnClickListenerC2824bf;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f16285a.f16282a.setText((CharSequence) this.f16285a.f16283b.get(i));
    }
}
