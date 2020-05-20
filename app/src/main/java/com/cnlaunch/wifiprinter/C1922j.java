package com.cnlaunch.wifiprinter;

import android.net.ConnectivityManager;
import android.net.wifi.WifiInfo;
import android.os.Message;
import com.cnlaunch.wifiprinter.C1900at;
import com.cnlaunch.wifiprinter.MainActivity;
import com.itextpdf.text.pdf.codec.TIFFConstants;

/* compiled from: MainActivity.java */
/* renamed from: com.cnlaunch.wifiprinter.j */
/* loaded from: classes.dex */
final class C1922j extends Thread {

    /* renamed from: a */
    int f10456a = 0;

    /* renamed from: b */
    final /* synthetic */ MainActivity.View$OnClickListenerC1914a f10457b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1922j(MainActivity.View$OnClickListenerC1914a view$OnClickListenerC1914a) {
        this.f10457b = view$OnClickListenerC1914a;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        boolean z;
        while (true) {
            if (this.f10456a >= 15) {
                break;
            }
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            WifiInfo connectionInfo = MainActivity.this.f10440r.getConnectionInfo();
            if (connectionInfo != null && connectionInfo.getSSID() != null) {
                String ssid = connectionInfo.getSSID();
                if (ssid.indexOf("\"") == 0) {
                    ssid = ssid.substring(1, ssid.length() - 1);
                }
                if (ssid.equalsIgnoreCase(MainActivity.this.f10430h) && ((ConnectivityManager) MainActivity.this.f10432j.getSystemService("connectivity")).getNetworkInfo(1).isConnected()) {
                    MainActivity.this.f10436n.sendEmptyMessage(TIFFConstants.TIFFTAG_GROUP3OPTIONS);
                    MainActivity.m8010e(MainActivity.this);
                    break;
                }
            }
            this.f10456a++;
        }
        z = MainActivity.this.f10443u;
        if (z) {
            return;
        }
        Message message2 = new Message();
        message2.what = TIFFConstants.TIFFTAG_GROUP4OPTIONS;
        message2.obj = MainActivity.this.f10432j.getResources().getString(C1900at.C1907g.connetfailed);
        MainActivity.this.f10436n.sendMessage(message2);
    }
}
