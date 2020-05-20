package com.cnlaunch.p169im.p170a;

import android.content.Context;
import android.view.View;

/* compiled from: ChatMessageAdapter.java */
/* renamed from: com.cnlaunch.im.a.b */
/* loaded from: classes.dex */
final class View$OnLongClickListenerC1678b implements View.OnLongClickListener {

    /* renamed from: a */
    final /* synthetic */ int f8962a;

    /* renamed from: b */
    final /* synthetic */ ChatMessageAdapter f8963b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnLongClickListenerC1678b(ChatMessageAdapter chatMessageAdapter, int i) {
        this.f8963b = chatMessageAdapter;
        this.f8962a = i;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        Context unused;
        unused = this.f8963b.f8939v;
        ChatMessageAdapter.m8921a();
        return true;
    }
}
