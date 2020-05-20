package com.cnlaunch.golo3.p165g;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PropertyObservable.java */
/* renamed from: com.cnlaunch.golo3.g.r */
/* loaded from: classes.dex */
public final class RunnableC1620r implements Runnable {

    /* renamed from: a */
    final /* synthetic */ InterfaceC1618p f8481a;

    /* renamed from: b */
    final /* synthetic */ Object f8482b;

    /* renamed from: c */
    final /* synthetic */ int f8483c;

    /* renamed from: d */
    final /* synthetic */ Object[] f8484d;

    /* renamed from: e */
    final /* synthetic */ C1619q f8485e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1620r(C1619q c1619q, InterfaceC1618p interfaceC1618p, Object obj, int i, Object[] objArr) {
        this.f8485e = c1619q;
        this.f8481a = interfaceC1618p;
        this.f8482b = obj;
        this.f8483c = i;
        this.f8484d = objArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f8481a.mo8851a(this.f8483c);
    }
}
