package com.mopub.common.util;

import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class Timer {

    /* renamed from: a */
    private long f20239a;

    /* renamed from: b */
    private long f20240b;

    /* renamed from: c */
    private int f20241c = EnumC3712a.STOPPED$28ed30e0;

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* renamed from: com.mopub.common.util.Timer$a */
    /* loaded from: classes.dex */
    static final class EnumC3712a {
        public static final int STARTED$28ed30e0 = 1;
        public static final int STOPPED$28ed30e0 = 2;

        /* renamed from: a */
        private static final /* synthetic */ int[] f20242a = {STARTED$28ed30e0, STOPPED$28ed30e0};

        public static int[] values$7baace9a() {
            return (int[]) f20242a.clone();
        }
    }

    public void start() {
        this.f20240b = System.nanoTime();
        this.f20241c = EnumC3712a.STARTED$28ed30e0;
    }

    public void stop() {
        if (this.f20241c != EnumC3712a.STARTED$28ed30e0) {
            throw new IllegalStateException("EventTimer was not started.");
        }
        this.f20241c = EnumC3712a.STOPPED$28ed30e0;
        this.f20239a = System.nanoTime();
    }

    public long getTime() {
        long j;
        if (this.f20241c == EnumC3712a.STARTED$28ed30e0) {
            j = System.nanoTime();
        } else {
            j = this.f20239a;
        }
        return TimeUnit.MILLISECONDS.convert(j - this.f20240b, TimeUnit.NANOSECONDS);
    }
}
