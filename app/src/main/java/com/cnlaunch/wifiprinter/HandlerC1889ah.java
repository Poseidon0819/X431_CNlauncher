package com.cnlaunch.wifiprinter;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.cnlaunch.wifiprinter.C1900at;
import com.cnlaunch.wifiprinter.WifiConnect;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.util.Timer;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PrinterLinkLocalNet.java */
/* renamed from: com.cnlaunch.wifiprinter.ah */
/* loaded from: classes.dex */
public final class HandlerC1889ah extends Handler {

    /* renamed from: a */
    final /* synthetic */ PrinterLinkLocalNet f10393a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC1889ah(PrinterLinkLocalNet printerLinkLocalNet) {
        this.f10393a = printerLinkLocalNet;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        switch (message2.what) {
            case 294:
                if (message2.obj.toString().indexOf("OK") == -1) {
                    this.f10393a.f10368h.setTextColor(this.f10393a.f10370k.getResources().getColor(C1900at.C1902b.red));
                    this.f10393a.f10368h.setText(this.f10393a.f10370k.getResources().getString(C1900at.C1907g.Reason2));
                    this.f10393a.f10363c.setEnabled(true);
                    this.f10393a.f10363c.setTextColor(this.f10393a.f10370k.getResources().getColor(C1900at.C1902b.white));
                    this.f10393a.f10361a.setEnabled(true);
                    return;
                }
                Constant.f10346a = true;
                String obj = this.f10393a.f10367g.getText().toString();
                String trim = this.f10393a.f10366f.getSelectedItem().toString().trim();
                this.f10393a.f10368h.setTextColor(this.f10393a.f10370k.getResources().getColor(C1900at.C1902b.black));
                TextView textView = this.f10393a.f10368h;
                textView.setText(this.f10393a.f10370k.getResources().getString(C1900at.C1907g.connettolan) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.f10393a.f10376q + " ...");
                WifiConnect wifiConnect = new WifiConnect(this.f10393a.f10360A);
                if (trim.indexOf("WPA") != -1) {
                    wifiConnect.m8020a(this.f10393a.f10376q, obj, WifiConnect.EnumC1910b.WIFICIPHER_WPA);
                } else if (trim.indexOf("WEP") != -1) {
                    wifiConnect.m8020a(this.f10393a.f10376q, obj, WifiConnect.EnumC1910b.WIFICIPHER_WEP);
                } else if (trim.indexOf("NONE") != -1) {
                    wifiConnect.m8020a(this.f10393a.f10376q, obj, WifiConnect.EnumC1910b.WIFICIPHER_NOPASS);
                }
                new Timer().schedule(new C1890ai(this), 1500L);
                return;
            case MetaDo.META_RESTOREDC /* 295 */:
                this.f10393a.f10368h.setTextColor(this.f10393a.f10370k.getResources().getColor(C1900at.C1902b.red));
                this.f10393a.f10368h.setText(this.f10393a.f10370k.getResources().getString(C1900at.C1907g.Reason2));
                this.f10393a.f10363c.setEnabled(true);
                this.f10393a.f10363c.setTextColor(this.f10393a.f10370k.getResources().getColor(C1900at.C1902b.white));
                this.f10393a.f10361a.setEnabled(true);
                return;
            case TIFFConstants.TIFFTAG_RESOLUTIONUNIT /* 296 */:
                String obj2 = this.f10393a.f10367g.getText().toString();
                String trim2 = this.f10393a.f10366f.getSelectedItem().toString().trim();
                this.f10393a.f10368h.setTextColor(this.f10393a.f10370k.getResources().getColor(C1900at.C1902b.black));
                TextView textView2 = this.f10393a.f10368h;
                textView2.setText(this.f10393a.f10370k.getResources().getString(C1900at.C1907g.connettolan) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.f10393a.f10376q + " ...\n" + this.f10393a.f10370k.getResources().getString(C1900at.C1907g.connetok) + "\n" + this.f10393a.f10370k.getResources().getString(C1900at.C1907g.setok));
                MySharedPreferences.m8002a(this.f10393a.f10370k, "SSID", this.f10393a.f10376q);
                MySharedPreferences.m8001b(this.f10393a.f10370k, "Style", trim2);
                Context context = this.f10393a.f10370k;
                if (MySharedPreferences.f10460a == null) {
                    MySharedPreferences.m8004a(context);
                }
                MySharedPreferences.f10460a.edit().putString("PassWord", obj2).commit();
                new Timer().schedule(new C1891aj(this), 2000L);
                return;
            case TIFFConstants.TIFFTAG_PAGENUMBER /* 297 */:
                this.f10393a.f10368h.setTextColor(this.f10393a.f10370k.getResources().getColor(C1900at.C1902b.red));
                this.f10393a.f10368h.setText("");
                TextView textView3 = this.f10393a.f10368h;
                textView3.append("\n" + this.f10393a.f10370k.getResources().getString(C1900at.C1907g.Reason));
                this.f10393a.f10363c.setText(this.f10393a.f10370k.getResources().getString(C1900at.C1907g.checkag));
                PrinterLinkLocalNet printerLinkLocalNet = this.f10393a;
                printerLinkLocalNet.f10375p = true;
                printerLinkLocalNet.f10363c.setEnabled(true);
                this.f10393a.f10363c.setTextColor(this.f10393a.f10370k.getResources().getColor(C1900at.C1902b.white));
                this.f10393a.f10361a.setEnabled(true);
                return;
            default:
                return;
        }
    }
}
