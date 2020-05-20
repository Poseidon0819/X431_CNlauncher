package com.cnlaunch.wifiprinter;

import android.os.Handler;
import android.os.Message;
import com.cnlaunch.wifiprinter.C1900at;
import com.cnlaunch.wifiprinter.PrintTest;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import java.net.MulticastSocket;
import java.util.Timer;
import okhttp3.internal.http.StatusLine;
import org.apache.mina.proxy.handlers.http.HttpProxyConstants;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PrintTest.java */
/* renamed from: com.cnlaunch.wifiprinter.p */
/* loaded from: classes.dex */
public final class HandlerC1929p extends Handler {

    /* renamed from: a */
    final /* synthetic */ PrintTest f10499a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC1929p(PrintTest printTest) {
        this.f10499a = printTest;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        MulticastSocket multicastSocket;
        MulticastSocket multicastSocket2;
        switch (message2.what) {
            case 304:
                PrintTest printTest = this.f10499a;
                printTest.f10485u = true;
                printTest.f10469e.setText(this.f10499a.f10481q.getResources().getString(C1900at.C1907g.FindPrinter));
                this.f10499a.f10469e.setBackgroundResource(C1900at.C1904d.printer_select_btn_hui);
                this.f10499a.f10472h.setBackgroundResource(C1900at.C1904d.printer_select_btn_hui);
                this.f10499a.f10482r.setVisibility(8);
                this.f10499a.f10469e.setEnabled(true);
                this.f10499a.f10473i.setTextColor(this.f10499a.f10481q.getResources().getColor(C1900at.C1902b.black));
                this.f10499a.f10473i.setText(message2.obj.toString() + HttpProxyConstants.CRLF + this.f10499a.f10481q.getResources().getString(C1900at.C1907g.PrinterReady) + HttpProxyConstants.CRLF);
                this.f10499a.f10470f.setVisibility(0);
                this.f10499a.f10468d.setVisibility(0);
                try {
                    this.f10499a.f10464C = new MulticastSocket();
                    multicastSocket = this.f10499a.f10464C;
                    multicastSocket.setSoTimeout(10000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (this.f10499a.f10488x) {
                    this.f10499a.f10470f.setClickable(false);
                    PrintTest printTest2 = this.f10499a;
                    printTest2.f10478n = new PrintTest.C1928d(printTest2.f10462A, "*******************************\r\n" + this.f10499a.f10463B + "IP:" + this.f10499a.f10462A + "\r\n*******************************\r\n\r\n\r\n");
                    this.f10499a.f10478n.start();
                    return;
                }
                return;
            case TIFFConstants.TIFFTAG_SOFTWARE /* 305 */:
                this.f10499a.f10470f.setClickable(true);
                this.f10499a.f10471g.setClickable(true);
                return;
            case TIFFConstants.TIFFTAG_DATETIME /* 306 */:
                PrintTest printTest3 = this.f10499a;
                printTest3.f10485u = true;
                printTest3.f10469e.setEnabled(true);
                this.f10499a.f10469e.setText(this.f10499a.f10481q.getResources().getString(C1900at.C1907g.retry));
                this.f10499a.f10473i.setTextColor(this.f10499a.f10481q.getResources().getColor(C1900at.C1902b.red));
                this.f10499a.f10473i.setText(message2.obj.toString() + HttpProxyConstants.CRLF);
                this.f10499a.f10482r.setVisibility(0);
                this.f10499a.f10468d.setVisibility(0);
                this.f10499a.f10470f.setVisibility(8);
                try {
                    this.f10499a.f10464C = new MulticastSocket();
                    multicastSocket2 = this.f10499a.f10464C;
                    multicastSocket2.setSoTimeout(10000);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.f10499a.f10470f.setVisibility(8);
                return;
            case StatusLine.HTTP_TEMP_REDIRECT /* 307 */:
                String obj = message2.obj.toString();
                if (this.f10499a.f10475k != null) {
                    if (obj.indexOf(this.f10499a.f10475k) != -1) {
                        this.f10499a.f10474j.setTextColor(this.f10499a.f10481q.getResources().getColor(C1900at.C1902b.black));
                        this.f10499a.f10474j.setText(obj);
                        return;
                    } else if (obj.indexOf("0x") != -1) {
                        this.f10499a.f10474j.setTextColor(this.f10499a.f10481q.getResources().getColor(C1900at.C1902b.red));
                        this.f10499a.f10474j.setText(this.f10499a.f10481q.getResources().getString(C1900at.C1907g.curnotConnet));
                        this.f10499a.f10473i.setText("");
                        this.f10499a.f10482r.setVisibility(0);
                        this.f10499a.f10468d.setVisibility(0);
                        this.f10499a.f10470f.setVisibility(8);
                        return;
                    } else {
                        this.f10499a.f10474j.setTextColor(this.f10499a.f10481q.getResources().getColor(C1900at.C1902b.red));
                        this.f10499a.f10474j.setText(obj + "  " + this.f10499a.f10481q.getResources().getString(C1900at.C1907g.curConnet1));
                        this.f10499a.f10473i.setText("");
                        this.f10499a.f10482r.setVisibility(0);
                        this.f10499a.f10468d.setVisibility(0);
                        this.f10499a.f10470f.setVisibility(8);
                        return;
                    }
                }
                this.f10499a.f10474j.setText(obj);
                return;
            case StatusLine.HTTP_PERM_REDIRECT /* 308 */:
                this.f10499a.f10474j.setTextColor(this.f10499a.f10481q.getResources().getColor(C1900at.C1902b.black));
                this.f10499a.f10486v = false;
                new Timer().schedule(new C1930q(this), 12000L);
                return;
            case 309:
                this.f10499a.f10474j.setTextColor(this.f10499a.f10481q.getResources().getColor(C1900at.C1902b.red));
                this.f10499a.f10474j.append("\n" + this.f10499a.f10481q.getResources().getString(C1900at.C1907g.connetfailed));
                this.f10499a.f10482r.setVisibility(0);
                this.f10499a.f10468d.setVisibility(0);
                return;
            default:
                return;
        }
    }
}
