package com.mopub.volley;

import com.mopub.volley.VolleyLog;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Request.java */
/* renamed from: com.mopub.volley.c */
/* loaded from: classes2.dex */
public final class RunnableC3923c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f21294a;

    /* renamed from: b */
    final /* synthetic */ long f21295b;

    /* renamed from: c */
    final /* synthetic */ Request f21296c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC3923c(Request request, String str, long j) {
        this.f21296c = request;
        this.f21294a = str;
        this.f21295b = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VolleyLog.C3919a c3919a;
        VolleyLog.C3919a c3919a2;
        c3919a = this.f21296c.f21263a;
        c3919a.add(this.f21294a, this.f21295b);
        c3919a2 = this.f21296c.f21263a;
        c3919a2.finish(toString());
    }
}
