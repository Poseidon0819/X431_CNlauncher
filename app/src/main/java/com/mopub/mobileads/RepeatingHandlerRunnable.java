package com.mopub.mobileads;

import android.os.Handler;
import com.mopub.common.Preconditions;

/* loaded from: classes.dex */
public abstract class RepeatingHandlerRunnable implements Runnable {

    /* renamed from: a */
    protected final Handler f20386a;

    /* renamed from: b */
    protected volatile long f20387b;

    /* renamed from: c */
    private volatile boolean f20388c;

    public abstract void doWork();

    public RepeatingHandlerRunnable(Handler handler) {
        Preconditions.checkNotNull(handler);
        this.f20386a = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f20388c) {
            doWork();
            this.f20386a.postDelayed(this, this.f20387b);
        }
    }

    public void startRepeating(long j) {
        Preconditions.checkArgument(j > 0, "intervalMillis must be greater than 0. Saw: %d", Long.valueOf(j));
        this.f20387b = j;
        if (this.f20388c) {
            return;
        }
        this.f20388c = true;
        this.f20386a.post(this);
    }

    public void stop() {
        this.f20388c = false;
    }
}
