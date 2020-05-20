package com.cnlaunch.wifiprinter;

import android.os.Handler;
import android.os.Message;
import com.cnlaunch.wifiprinter.C1900at;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import java.util.Timer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MainActivity.java */
/* renamed from: com.cnlaunch.wifiprinter.d */
/* loaded from: classes.dex */
public final class HandlerC1916d extends Handler {

    /* renamed from: a */
    final /* synthetic */ MainActivity f10450a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC1916d(MainActivity mainActivity) {
        this.f10450a = mainActivity;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        int i;
        int i2 = message2.what;
        if (i2 == 305) {
            this.f10450a.f10444v = -1;
            this.f10450a.f10426a.setEnabled(true);
            this.f10450a.f10427b.setEnabled(true);
            this.f10450a.f10427b.setTextColor(this.f10450a.f10432j.getResources().getColor(C1900at.C1902b.white));
            MainActivity.f10424f.setTextColor(this.f10450a.f10432j.getResources().getColor(C1900at.C1902b.red));
            MainActivity.f10424f.setText(C1900at.C1907g.wifi_connected_need_reset);
            return;
        }
        switch (i2) {
            case TIFFConstants.TIFFTAG_FREEBYTECOUNTS /* 289 */:
                return;
            case TIFFConstants.TIFFTAG_GRAYRESPONSEUNIT /* 290 */:
                MainActivity.f10424f.setText("");
                MainActivity.f10423e.setText("");
                return;
            case TIFFConstants.TIFFTAG_GRAYRESPONSECURVE /* 291 */:
                return;
            case TIFFConstants.TIFFTAG_GROUP3OPTIONS /* 292 */:
                this.f10450a.f10427b.setTextColor(this.f10450a.f10432j.getResources().getColor(C1900at.C1902b.white));
                MainActivity.f10424f.setTextColor(this.f10450a.f10432j.getResources().getColor(C1900at.C1902b.black));
                MainActivity.f10424f.setText(this.f10450a.f10432j.getResources().getString(C1900at.C1907g.connetok));
                this.f10450a.f10430h = MainActivity.f10423e.getText().toString();
                MySharedPreferences.m8002a(this.f10450a.f10432j, "PRINTERSSID", this.f10450a.f10430h);
                MySharedPreferences.m8001b(this.f10450a.f10432j, "Style", this.f10450a.f10429d);
                new Timer().schedule(new C1917e(this), 500L);
                return;
            case TIFFConstants.TIFFTAG_GROUP4OPTIONS /* 293 */:
                i = this.f10450a.f10444v;
                if (i == -1) {
                    return;
                }
                this.f10450a.f10426a.setEnabled(true);
                this.f10450a.f10427b.setEnabled(true);
                this.f10450a.f10427b.setTextColor(this.f10450a.f10432j.getResources().getColor(C1900at.C1902b.white));
                MainActivity.f10424f.setTextColor(this.f10450a.f10432j.getResources().getColor(C1900at.C1902b.red));
                MainActivity.f10424f.setText(message2.obj.toString());
                return;
            default:
                return;
        }
    }
}
