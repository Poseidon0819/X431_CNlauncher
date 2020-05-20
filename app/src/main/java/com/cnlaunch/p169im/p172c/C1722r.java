package com.cnlaunch.p169im.p172c;

import com.cnlaunch.p169im.p172c.ProMessageFragment;
import com.cnlaunch.p169im.p178h.ConnectStatusObserver;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProMessageFragment.java */
/* renamed from: com.cnlaunch.im.c.r */
/* loaded from: classes.dex */
public final class C1722r implements ConnectStatusObserver {

    /* renamed from: a */
    final /* synthetic */ ProMessageFragment f9154a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1722r(ProMessageFragment proMessageFragment) {
        this.f9154a = proMessageFragment;
    }

    @Override // com.cnlaunch.p169im.p178h.ConnectStatusObserver
    /* renamed from: a */
    public final void mo8722a(int i) {
        ProMessageFragment.HandlerC1714b handlerC1714b;
        ProMessageFragment.HandlerC1714b handlerC1714b2;
        if (i == 0) {
            handlerC1714b2 = this.f9154a.f9115V;
            handlerC1714b2.obtainMessage(8).sendToTarget();
        } else if (i == 1) {
            handlerC1714b = this.f9154a.f9115V;
            handlerC1714b.obtainMessage(8).sendToTarget();
        }
    }
}
