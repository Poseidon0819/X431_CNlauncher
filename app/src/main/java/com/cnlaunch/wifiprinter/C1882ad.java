package com.cnlaunch.wifiprinter;

import android.net.ConnectivityManager;
import android.net.wifi.WifiInfo;
import android.os.Message;
import com.cnlaunch.wifiprinter.C1900at;
import com.itextpdf.text.pdf.codec.TIFFConstants;

/* compiled from: PrintTestTwo.java */
/* renamed from: com.cnlaunch.wifiprinter.ad */
/* loaded from: classes.dex */
final class C1882ad extends Thread {

    /* renamed from: a */
    long f10355a = System.currentTimeMillis() + 35000;

    /* renamed from: b */
    final /* synthetic */ FragmentC1934u f10356b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1882ad(FragmentC1934u fragmentC1934u) {
        this.f10356b = fragmentC1934u;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (this.f10356b.f10523q) {
            if (this.f10356b.f10507B.isWifiEnabled()) {
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                WifiInfo connectionInfo = this.f10356b.f10507B.getConnectionInfo();
                if (connectionInfo != null && connectionInfo.getSSID() != null) {
                    String ssid = connectionInfo.getSSID();
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.f10356b.f10519m.getResources().getString(C1900at.C1907g.curConnet));
                    sb.append(ssid);
                    if (ssid.indexOf("\"") == 0) {
                        ssid = ssid.substring(1, ssid.length() - 1);
                    }
                    if (this.f10356b.f10525s != null && ssid.equalsIgnoreCase(this.f10356b.f10525s) && ((ConnectivityManager) this.f10356b.f10519m.getSystemService("connectivity")).getNetworkInfo(1).isConnected()) {
                        this.f10356b.f10527u.sendEmptyMessage(TIFFConstants.TIFFTAG_RESOLUTIONUNIT);
                        this.f10356b.f10523q = false;
                    }
                }
                if (System.currentTimeMillis() > this.f10355a) {
                    this.f10356b.f10523q = false;
                    Message message2 = new Message();
                    message2.what = TIFFConstants.TIFFTAG_PAGENUMBER;
                    this.f10356b.f10527u.sendMessage(message2);
                }
            }
        }
    }
}
