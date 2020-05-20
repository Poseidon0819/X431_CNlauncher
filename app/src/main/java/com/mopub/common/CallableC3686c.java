package com.mopub.common;

import java.io.Writer;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DiskLruCache.java */
/* renamed from: com.mopub.common.c */
/* loaded from: classes.dex */
public final class CallableC3686c implements Callable<Void> {

    /* renamed from: a */
    final /* synthetic */ DiskLruCache f20115a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallableC3686c(DiskLruCache diskLruCache) {
        this.f20115a = diskLruCache;
    }

    @Override // java.util.concurrent.Callable
    public final Void call() throws Exception {
        Writer writer;
        boolean m2582e;
        synchronized (this.f20115a) {
            writer = this.f20115a.f20037k;
            if (writer == null) {
                return null;
            }
            this.f20115a.m2578g();
            m2582e = this.f20115a.m2582e();
            if (m2582e) {
                this.f20115a.m2584d();
                DiskLruCache.m2581e(this.f20115a);
            }
            return null;
        }
    }
}
