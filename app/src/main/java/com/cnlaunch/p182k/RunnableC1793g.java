package com.cnlaunch.p182k;

import java.io.IOException;
import java.io.OutputStream;
import java.net.UnknownHostException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TCPSocketController.java */
/* renamed from: com.cnlaunch.k.g */
/* loaded from: classes.dex */
public final class RunnableC1793g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ byte[] f9503a;

    /* renamed from: b */
    final /* synthetic */ int f9504b;

    /* renamed from: c */
    final /* synthetic */ TCPSocketController f9505c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1793g(TCPSocketController tCPSocketController, byte[] bArr, int i) {
        this.f9505c = tCPSocketController;
        this.f9503a = bArr;
        this.f9504b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            try {
                OutputStream outputStream = this.f9505c.f9491a.getOutputStream();
                outputStream.write(this.f9503a, 0, this.f9504b);
                outputStream.flush();
                this.f9505c.f9494d = this.f9504b;
            } catch (IOException e) {
                this.f9505c.f9494d = -3;
                e.printStackTrace();
            }
        } catch (UnknownHostException e2) {
            this.f9505c.f9494d = -2;
            e2.printStackTrace();
        }
    }
}
