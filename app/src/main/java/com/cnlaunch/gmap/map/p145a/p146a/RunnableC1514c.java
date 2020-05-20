package com.cnlaunch.gmap.map.p145a.p146a;

import com.cnlaunch.gmap.map.p145a.p146a.LocationSearch;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LocationInterface.java */
/* renamed from: com.cnlaunch.gmap.map.a.a.c */
/* loaded from: classes.dex */
public final class RunnableC1514c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ double f7484a;

    /* renamed from: b */
    final /* synthetic */ double f7485b;

    /* renamed from: c */
    final /* synthetic */ String f7486c;

    /* renamed from: d */
    final /* synthetic */ LocationSearch.InterfaceC1517a f7487d;

    /* renamed from: e */
    final /* synthetic */ LocationInterface f7488e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1514c(LocationInterface locationInterface, double d, double d2, String str, LocationSearch.InterfaceC1517a interfaceC1517a) {
        this.f7488e = locationInterface;
        this.f7484a = d;
        this.f7485b = d2;
        this.f7486c = str;
        this.f7487d = interfaceC1517a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (Thread.currentThread().isInterrupted()) {
            return;
        }
        LocationInterface.m9329a(this.f7488e, this.f7484a, this.f7485b, this.f7486c, this.f7487d);
    }
}
