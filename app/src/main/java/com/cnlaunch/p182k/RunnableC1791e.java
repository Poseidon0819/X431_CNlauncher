package com.cnlaunch.p182k;

import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TCPSocketController.java */
/* renamed from: com.cnlaunch.k.e */
/* loaded from: classes.dex */
public final class RunnableC1791e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ TCPSocketController f9499a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1791e(TCPSocketController tCPSocketController) {
        this.f9499a = tCPSocketController;
    }

    @Override // java.lang.Runnable
    public final void run() {
        byte[] bArr = new byte[1024];
        try {
            if (this.f9499a.f9491a == null || this.f9499a.f9491a.getInputStream().available() <= 0) {
                return;
            }
            int read = this.f9499a.f9491a.getInputStream().read(bArr);
            while (read == 1024) {
                this.f9499a.f9491a.getInputStream().read(bArr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
