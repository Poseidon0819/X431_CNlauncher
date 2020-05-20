package com.cnlaunch.p169im.p180j;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/* renamed from: com.cnlaunch.im.j.f */
/* loaded from: classes.dex */
public final class RunLastTask extends Thread {

    /* renamed from: a */
    public BlockingQueue<Runnable> f9298a = new LinkedBlockingDeque();

    /* renamed from: b */
    private long f9299b = 0;

    public RunLastTask() {
        start();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (true) {
            try {
                if (this.f9299b <= 0) {
                    this.f9299b = 4L;
                    m8704a();
                } else {
                    synchronized (this) {
                        wait(500L);
                    }
                    this.f9299b--;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private void m8704a() {
        synchronized (this) {
            Runnable poll = this.f9298a.poll();
            if (poll != null) {
                poll.run();
            }
        }
    }
}
