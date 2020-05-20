package com.cnlaunch.p182k;

import android.text.TextUtils;
import android.util.Log;
import java.io.InterruptedIOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Arrays;

/* compiled from: UDPController.java */
/* renamed from: com.cnlaunch.k.i */
/* loaded from: classes.dex */
final class RunnableC1794i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f9511a;

    /* renamed from: b */
    final /* synthetic */ int f9512b;

    /* renamed from: c */
    final /* synthetic */ byte[] f9513c;

    /* renamed from: d */
    final /* synthetic */ int f9514d;

    /* renamed from: e */
    final /* synthetic */ UDPController f9515e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1794i(UDPController uDPController, String str, int i, byte[] bArr, int i2) {
        this.f9515e = uDPController;
        this.f9511a = str;
        this.f9512b = i;
        this.f9513c = bArr;
        this.f9514d = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        InetSocketAddress inetSocketAddress;
        try {
            byte[] bArr = new byte[1024];
            DatagramSocket datagramSocket = new DatagramSocket();
            if (!TextUtils.isEmpty(this.f9511a)) {
                inetSocketAddress = new InetSocketAddress(InetAddress.getByName(this.f9511a), this.f9512b);
            } else {
                inetSocketAddress = new InetSocketAddress(InetAddress.getByName("255.255.255.255"), this.f9512b);
            }
            DatagramPacket datagramPacket = new DatagramPacket(this.f9513c, this.f9513c.length, inetSocketAddress);
            DatagramPacket datagramPacket2 = new DatagramPacket(bArr, 1024);
            datagramSocket.setSoTimeout(this.f9514d);
            boolean z = false;
            int i = 0;
            while (!z && i < 2) {
                datagramSocket.send(datagramPacket);
                try {
                    datagramSocket.receive(datagramPacket2);
                    Log.e("Sanda", "dp_receive ip:" + datagramPacket2.getAddress().getHostAddress());
                    Log.e("Sanda", "dp_receive port:" + datagramPacket2.getPort());
                    UDPController.f9506c = datagramPacket2.getAddress().getHostAddress();
                    UDPController.f9507d = datagramPacket2.getPort();
                    z = true;
                } catch (InterruptedIOException unused) {
                    i++;
                    Log.e("Sanda", "Time out," + (2 - i) + " more tries...");
                }
            }
            if (z) {
                this.f9515e.f9509b = Arrays.copyOfRange(datagramPacket2.getData(), 0, datagramPacket2.getLength());
                datagramPacket2.setLength(1024);
                this.f9515e.f9508a = true;
            } else {
                Log.d("Sanda", "No response -- give up.");
                this.f9515e.f9509b = new byte[0];
                this.f9515e.f9508a = false;
            }
            datagramSocket.close();
        } catch (Exception unused2) {
            UDPController uDPController = this.f9515e;
            uDPController.f9509b = new byte[0];
            uDPController.f9508a = false;
        }
    }
}
