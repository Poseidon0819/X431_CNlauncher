package com.mopub.common;

import android.os.SystemClock;
import com.mopub.common.logging.MoPubLog;

/* loaded from: classes.dex */
public class DoubleTimeTracker {

    /* renamed from: a */
    private volatile int f20061a;

    /* renamed from: b */
    private long f20062b;

    /* renamed from: c */
    private long f20063c;

    /* renamed from: d */
    private final Clock f20064d;

    /* loaded from: classes.dex */
    public interface Clock {
        long elapsedRealTime();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* renamed from: com.mopub.common.DoubleTimeTracker$a */
    /* loaded from: classes.dex */
    public static final class EnumC3680a {
        public static final int STARTED$273b45aa = 1;
        public static final int PAUSED$273b45aa = 2;

        /* renamed from: a */
        private static final /* synthetic */ int[] f20065a = {STARTED$273b45aa, PAUSED$273b45aa};

        public static int[] values$678e8a4() {
            return (int[]) f20065a.clone();
        }
    }

    public DoubleTimeTracker() {
        this(new C3681b((byte) 0));
    }

    @VisibleForTesting
    public DoubleTimeTracker(Clock clock) {
        this.f20064d = clock;
        this.f20061a = EnumC3680a.PAUSED$273b45aa;
    }

    public synchronized void start() {
        if (this.f20061a == EnumC3680a.STARTED$273b45aa) {
            MoPubLog.m2492v("DoubleTimeTracker already started.");
            return;
        }
        this.f20061a = EnumC3680a.STARTED$273b45aa;
        this.f20062b = this.f20064d.elapsedRealTime();
    }

    public synchronized void pause() {
        if (this.f20061a == EnumC3680a.PAUSED$273b45aa) {
            MoPubLog.m2492v("DoubleTimeTracker already paused.");
            return;
        }
        this.f20063c += m2568a();
        this.f20062b = 0L;
        this.f20061a = EnumC3680a.PAUSED$273b45aa;
    }

    public synchronized double getInterval() {
        return this.f20063c + m2568a();
    }

    /* renamed from: a */
    private synchronized long m2568a() {
        if (this.f20061a == EnumC3680a.PAUSED$273b45aa) {
            return 0L;
        }
        return this.f20064d.elapsedRealTime() - this.f20062b;
    }

    /* renamed from: com.mopub.common.DoubleTimeTracker$b */
    /* loaded from: classes.dex */
    static class C3681b implements Clock {
        private C3681b() {
        }

        /* synthetic */ C3681b(byte b) {
            this();
        }

        @Override // com.mopub.common.DoubleTimeTracker.Clock
        public final long elapsedRealTime() {
            return SystemClock.elapsedRealtime();
        }
    }
}
