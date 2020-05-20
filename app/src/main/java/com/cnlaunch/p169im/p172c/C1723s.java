package com.cnlaunch.p169im.p172c;

import com.cnlaunch.p169im.p172c.ProMessageFragment;
import com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog;
import message.model.ChatMessage;

/* compiled from: ProMessageFragment.java */
/* renamed from: com.cnlaunch.im.c.s */
/* loaded from: classes.dex */
final class C1723s extends SelectMessageDialog {

    /* renamed from: a */
    final /* synthetic */ int f9155a;

    /* renamed from: b */
    final /* synthetic */ ProMessageFragment.HandlerC1713a f9156b;

    @Override // com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog
    /* renamed from: b */
    public final void mo4608b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1723s(ProMessageFragment.HandlerC1713a handlerC1713a, int i) {
        this.f9156b = handlerC1713a;
        this.f9155a = i;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog
    /* renamed from: a */
    public final void mo4611a() {
        ChatMessage m8910b = ProMessageFragment.this.f9124g.m8910b(this.f9155a);
        if (m8910b != null) {
            ProMessageFragment.this.m8846a(m8910b);
        }
    }
}
