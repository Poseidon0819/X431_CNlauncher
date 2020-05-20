package com.baidu.lbsapi.auth;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.baidu.lbsapi.auth.f */
/* loaded from: classes.dex */
public class C0883f extends Thread {

    /* renamed from: a */
    Handler f3758a;

    /* renamed from: b */
    private Object f3759b;

    /* renamed from: c */
    private boolean f3760c;

    C0883f() {
        this.f3758a = null;
        this.f3759b = new Object();
        this.f3760c = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0883f(String str) {
        super(str);
        this.f3758a = null;
        this.f3759b = new Object();
        this.f3760c = false;
    }

    /* renamed from: a */
    public void m12334a() {
        if (C0872a.f3743a) {
            C0872a.m12369a("Looper thread quit()");
        }
        this.f3758a.getLooper().quit();
    }

    /* renamed from: b */
    public void m12333b() {
        synchronized (this.f3759b) {
            try {
                if (!this.f3760c) {
                    this.f3759b.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: c */
    public void m12332c() {
        synchronized (this.f3759b) {
            this.f3760c = true;
            this.f3759b.notifyAll();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.f3758a = new Handler();
        if (C0872a.f3743a) {
            C0872a.m12369a("new Handler() finish!!");
        }
        Looper.loop();
        if (C0872a.f3743a) {
            C0872a.m12369a("LooperThread run() thread id:" + String.valueOf(Thread.currentThread().getId()));
        }
    }
}
