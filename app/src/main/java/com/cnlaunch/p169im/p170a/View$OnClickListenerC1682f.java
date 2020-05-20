package com.cnlaunch.p169im.p170a;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatMessageAdapter.java */
/* renamed from: com.cnlaunch.im.a.f */
/* loaded from: classes.dex */
public final class View$OnClickListenerC1682f implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f8971a;

    /* renamed from: b */
    final /* synthetic */ ChatMessageAdapter f8972b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1682f(ChatMessageAdapter chatMessageAdapter, int i) {
        this.f8972b = chatMessageAdapter;
        this.f8971a = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f8972b.f8938u != null) {
            this.f8972b.f8938u.obtainMessage(6, this.f8971a, 0).sendToTarget();
        }
    }
}
