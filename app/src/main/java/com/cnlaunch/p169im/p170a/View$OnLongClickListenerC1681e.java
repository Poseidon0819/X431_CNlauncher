package com.cnlaunch.p169im.p170a;

import android.content.Context;
import android.view.View;

/* compiled from: ChatMessageAdapter.java */
/* renamed from: com.cnlaunch.im.a.e */
/* loaded from: classes.dex */
final class View$OnLongClickListenerC1681e implements View.OnLongClickListener {

    /* renamed from: a */
    final /* synthetic */ int f8968a;

    /* renamed from: b */
    final /* synthetic */ int f8969b;

    /* renamed from: c */
    final /* synthetic */ ChatMessageAdapter f8970c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnLongClickListenerC1681e(ChatMessageAdapter chatMessageAdapter, int i, int i2) {
        this.f8970c = chatMessageAdapter;
        this.f8968a = i;
        this.f8969b = i2;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        Context unused;
        unused = this.f8970c.f8939v;
        ChatMessageAdapter.m8921a();
        return true;
    }
}
