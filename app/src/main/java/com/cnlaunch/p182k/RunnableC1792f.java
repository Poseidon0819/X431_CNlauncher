package com.cnlaunch.p182k;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TCPSocketController.java */
/* renamed from: com.cnlaunch.k.f */
/* loaded from: classes.dex */
public final class RunnableC1792f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f9500a;

    /* renamed from: b */
    final /* synthetic */ int f9501b;

    /* renamed from: c */
    final /* synthetic */ TCPSocketController f9502c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1792f(TCPSocketController tCPSocketController, String str, int i) {
        this.f9502c = tCPSocketController;
        this.f9500a = str;
        this.f9501b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f9502c.m8636b();
            this.f9502c.f9491a = new Socket(this.f9500a, this.f9501b);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
