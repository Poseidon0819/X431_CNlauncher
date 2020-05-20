package com.cnlaunch.wifiprinter;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PrintTest.java */
/* renamed from: com.cnlaunch.wifiprinter.s */
/* loaded from: classes.dex */
public final class C1932s extends Thread {

    /* renamed from: a */
    final /* synthetic */ PrintTest f10502a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1932s(PrintTest printTest) {
        this.f10502a = printTest;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        MulticastSocket multicastSocket;
        MulticastSocket multicastSocket2;
        MulticastSocket multicastSocket3;
        MulticastSocket multicastSocket4;
        try {
            this.f10502a.f10485u = false;
            multicastSocket = this.f10502a.f10464C;
            multicastSocket.setTimeToLive(1);
            byte[] bytes = "HLK".getBytes();
            InetAddress byName = InetAddress.getByName("224.0.0.1");
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, byName, 988);
            while (!this.f10502a.f10485u) {
                multicastSocket4 = this.f10502a.f10464C;
                multicastSocket4.send(datagramPacket);
                Thread.sleep(1000L);
            }
            multicastSocket2 = this.f10502a.f10464C;
            multicastSocket2.leaveGroup(byName);
            multicastSocket3 = this.f10502a.f10464C;
            multicastSocket3.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
