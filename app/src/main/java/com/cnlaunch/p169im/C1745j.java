package com.cnlaunch.p169im;

import message.p383f.SendTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShowImageDetailActivity.java */
/* renamed from: com.cnlaunch.im.j */
/* loaded from: classes.dex */
public final class C1745j implements SendTask.InterfaceC4739a {

    /* renamed from: a */
    final /* synthetic */ ShowImageDetailActivity f9290a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1745j(ShowImageDetailActivity showImageDetailActivity) {
        this.f9290a = showImageDetailActivity;
    }

    @Override // message.p383f.SendTask.InterfaceC4739a
    /* renamed from: a */
    public final void mo254a() {
        this.f9290a.runOnUiThread(new RunnableC1751k(this));
    }

    @Override // message.p383f.SendTask.InterfaceC4739a
    /* renamed from: b */
    public final void mo253b() {
        this.f9290a.runOnUiThread(new RunnableC1752l(this));
    }
}
