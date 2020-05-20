package com.mopub.nativeads;

import android.os.SystemClock;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.mopub.nativeads.bd */
/* loaded from: classes2.dex */
public final class TimestampWrapper<T> {

    /* renamed from: a */
    final T f21119a;

    /* renamed from: b */
    long f21120b = SystemClock.uptimeMillis();

    /* JADX INFO: Access modifiers changed from: package-private */
    public TimestampWrapper(T t) {
        this.f21119a = t;
    }
}
