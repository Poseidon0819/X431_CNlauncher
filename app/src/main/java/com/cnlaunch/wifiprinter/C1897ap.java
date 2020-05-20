package com.cnlaunch.wifiprinter;

import android.net.ConnectivityManager;
import android.net.wifi.WifiInfo;
import android.os.Message;
import com.cnlaunch.wifiprinter.C1900at;
import com.itextpdf.text.pdf.codec.TIFFConstants;

/* compiled from: PrinterLinkLocalNet.java */
/* renamed from: com.cnlaunch.wifiprinter.ap */
/* loaded from: classes.dex */
final class C1897ap extends Thread {

    /* renamed from: a */
    long f10401a = System.currentTimeMillis() + 35000;

    /* renamed from: b */
    final /* synthetic */ PrinterLinkLocalNet f10402b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1897ap(PrinterLinkLocalNet printerLinkLocalNet) {
        this.f10402b = printerLinkLocalNet;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (this.f10402b.f10374o) {
            if (this.f10402b.f10360A.isWifiEnabled()) {
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                WifiInfo connectionInfo = this.f10402b.f10360A.getConnectionInfo();
                if (connectionInfo != null && connectionInfo.getSSID() != null) {
                    String ssid = connectionInfo.getSSID();
                    StringBuilder sb = new StringBuilder();
                    if (ssid.indexOf("\"") == 0) {
                        ssid = ssid.substring(1, ssid.length() - 1);
                    }
                    sb.append(this.f10402b.f10370k.getResources().getString(C1900at.C1907g.curConnet));
                    sb.append(ssid);
                    if (this.f10402b.f10376q != null && ssid.equalsIgnoreCase(this.f10402b.f10376q) && ((ConnectivityManager) this.f10402b.f10370k.getSystemService("connectivity")).getNetworkInfo(1).isConnected()) {
                        this.f10402b.f10378s.sendEmptyMessage(TIFFConstants.TIFFTAG_RESOLUTIONUNIT);
                        this.f10402b.f10374o = false;
                    }
                }
                if (System.currentTimeMillis() > this.f10401a) {
                    this.f10402b.f10374o = false;
                    Message message2 = new Message();
                    message2.what = TIFFConstants.TIFFTAG_PAGENUMBER;
                    this.f10402b.f10378s.sendMessage(message2);
                }
            }
        }
    }
}
