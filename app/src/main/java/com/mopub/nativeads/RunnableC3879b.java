package com.mopub.nativeads;

import com.mopub.nativeads.PositioningSource;

/* compiled from: ClientPositioningSource.java */
/* renamed from: com.mopub.nativeads.b */
/* loaded from: classes2.dex */
final class RunnableC3879b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ PositioningSource.PositioningListener f21106a;

    /* renamed from: b */
    final /* synthetic */ ClientPositioningSource f21107b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC3879b(ClientPositioningSource clientPositioningSource, PositioningSource.PositioningListener positioningListener) {
        this.f21107b = clientPositioningSource;
        this.f21106a = positioningListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f21106a.onLoad(this.f21107b.f21042a);
    }
}
