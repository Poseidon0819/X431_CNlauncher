package com.cnlaunch.p182k;

import android.util.Log;
import java.io.InterruptedIOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UDPController.java */
/* renamed from: com.cnlaunch.k.j */
/* loaded from: classes.dex */
public final class RunnableC1795j implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f9516a;

    /* renamed from: b */
    final /* synthetic */ int f9517b;

    /* renamed from: c */
    final /* synthetic */ UDPController f9518c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1795j(UDPController uDPController, int i, int i2) {
        this.f9518c = uDPController;
        this.f9516a = i;
        this.f9517b = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            DatagramSocket datagramSocket = new DatagramSocket(this.f9516a);
            DatagramPacket datagramPacket = new DatagramPacket(new byte[1024], 1024);
            datagramSocket.setSoTimeout(this.f9517b);
            boolean z = false;
            int i = 0;
            while (!z && i < 2) {
                try {
                    datagramSocket.receive(datagramPacket);
                    Log.e("ReceiveUDPData", "dp_receive ip:" + datagramPacket.getAddress().getHostAddress());
                    Log.e("ReceiveUDPData", "dp_receive port:" + datagramPacket.getPort());
                    UDPController.f9506c = datagramPacket.getAddress().getHostAddress();
                    UDPController.f9507d = datagramPacket.getPort();
                    z = true;
                } catch (InterruptedIOException unused) {
                    i++;
                    Log.e("ReceiveUDPData", "Time out," + (2 - i) + " more tries...");
                }
            }
            if (z) {
                this.f9518c.f9509b = Arrays.copyOfRange(datagramPacket.getData(), 0, datagramPacket.getLength());
                datagramPacket.setLength(1024);
                this.f9518c.f9508a = true;
            } else {
                Log.d("ReceiveUDPData", "No response -- give up.");
                this.f9518c.f9509b = new byte[0];
                this.f9518c.f9508a = false;
            }
            datagramSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
            UDPController uDPController = this.f9518c;
            uDPController.f9509b = new byte[0];
            uDPController.f9508a = false;
        }
    }
}
