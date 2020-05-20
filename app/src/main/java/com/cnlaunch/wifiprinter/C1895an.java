package com.cnlaunch.wifiprinter;

import android.view.View;
import android.widget.AdapterView;
import com.cnlaunch.wifiprinter.C1900at;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PrinterLinkLocalNet.java */
/* renamed from: com.cnlaunch.wifiprinter.an */
/* loaded from: classes.dex */
public final class C1895an implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ PrinterLinkLocalNet f10399a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1895an(PrinterLinkLocalNet printerLinkLocalNet) {
        this.f10399a = printerLinkLocalNet;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        PrinterLinkLocalNet.m8025e(this.f10399a);
        PrinterWifiInfo printerWifiInfo = (PrinterWifiInfo) this.f10399a.f10381v.get(i);
        this.f10399a.f10365e.setText(printerWifiInfo.f10405a.trim());
        this.f10399a.f10367g.setText("");
        String upperCase = printerWifiInfo.f10406b.toString().toUpperCase();
        if (upperCase.indexOf("[WPA-PSK-CCMP]") != -1 && upperCase.indexOf("[WPA2-PSK-CCMP]") == -1) {
            i2 = 4;
        } else if (upperCase.indexOf("[WPA-PSK-TKIP]") != -1 && upperCase.indexOf("[WPA2-PSK-TKIP]") == -1) {
            i2 = 3;
        } else if (upperCase.indexOf("[WPA2-PSK-CCMP]") != -1 && upperCase.indexOf("[WPA-PSK-CCMP]") == -1) {
            i2 = 6;
        } else if (upperCase.indexOf("[WPA2-PSK-TKIP]") != -1 && upperCase.indexOf("[WPA-PSK-TKIP]") == -1) {
            i2 = 5;
        } else if ((upperCase.indexOf("[WPA-PSK-CCMP]") != -1 && upperCase.indexOf("[WPA2-PSK-CCMP]") != -1) || ((upperCase.indexOf("[WPA-PSK-TKIP+CCMP]") != -1 && upperCase.indexOf("[WPA2-PSK-TKIP+CCMP]") != -1) || (upperCase.indexOf("[WPA-PSK-CCMP+TKIP]") != -1 && upperCase.indexOf("[WPA2-PSK-CCMP+TKIP]") != -1))) {
            i2 = 8;
        } else if (upperCase.indexOf("[WPA-PSK-TKIP][WPA2-PSK-TKIP]") != -1) {
            i2 = 7;
        } else {
            i2 = upperCase.indexOf("[WEP]") != -1 ? 1 : 0;
        }
        if (i2 != 0) {
            this.f10399a.f10368h.setText("");
            this.f10399a.f10363c.setVisibility(0);
        } else {
            String string = this.f10399a.f10370k.getResources().getString(C1900at.C1907g.Notsurpost);
            this.f10399a.f10368h.setTextColor(this.f10399a.f10370k.getResources().getColor(C1900at.C1902b.red));
            this.f10399a.f10368h.setText(string);
            this.f10399a.f10363c.setEnabled(false);
            this.f10399a.f10363c.setTextColor(this.f10399a.f10370k.getResources().getColor(C1900at.C1902b.hui));
        }
        this.f10399a.f10366f.setSelection(i2, false);
        this.f10399a.f10367g.setFocusable(true);
        this.f10399a.f10367g.setFocusableInTouchMode(true);
        this.f10399a.f10367g.requestFocus();
        this.f10399a.f10367g.requestFocusFromTouch();
        this.f10399a.f10369j.dismiss();
    }
}
