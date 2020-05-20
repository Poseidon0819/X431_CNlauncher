package com.mopub.network;

import com.mopub.common.logging.MoPubLog;
import com.mopub.volley.VolleyError;

/* compiled from: ScribeRequestManager.java */
/* renamed from: com.mopub.network.g */
/* loaded from: classes2.dex */
final class RunnableC3916g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ VolleyError f21239a;

    /* renamed from: b */
    final /* synthetic */ ScribeRequestManager f21240b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC3916g(ScribeRequestManager scribeRequestManager, VolleyError volleyError) {
        this.f21240b = scribeRequestManager;
        this.f21239a = volleyError;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f21240b.f21223c.backoff(this.f21239a);
            this.f21240b.m2024b();
        } catch (VolleyError unused) {
            MoPubLog.m2498d("Failed to Scribe events: " + this.f21239a);
            this.f21240b.m2023c();
        }
    }
}
