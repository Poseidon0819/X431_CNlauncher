package com.cnlaunch.gmap.p138a.p143e;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PropertyObservable.java */
/* renamed from: com.cnlaunch.gmap.a.e.d */
/* loaded from: classes.dex */
public final class RunnableC1511d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ PropertyListener f7452a;

    /* renamed from: b */
    final /* synthetic */ Object f7453b;

    /* renamed from: c */
    final /* synthetic */ int f7454c = 21;

    /* renamed from: d */
    final /* synthetic */ Object[] f7455d;

    /* renamed from: e */
    final /* synthetic */ PropertyObservable f7456e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1511d(PropertyObservable propertyObservable, PropertyListener propertyListener, Object obj, Object[] objArr) {
        this.f7456e = propertyObservable;
        this.f7452a = propertyListener;
        this.f7453b = obj;
        this.f7455d = objArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7452a.mo9288a(this.f7454c, this.f7455d);
    }
}
