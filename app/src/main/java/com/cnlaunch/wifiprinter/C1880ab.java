package com.cnlaunch.wifiprinter;

import android.net.wifi.WifiInfo;
import android.view.View;
import android.widget.AdapterView;
import com.cnlaunch.wifiprinter.C1900at;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PrintTestTwo.java */
/* renamed from: com.cnlaunch.wifiprinter.ab */
/* loaded from: classes.dex */
public final class C1880ab implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentC1934u f10353a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1880ab(FragmentC1934u fragmentC1934u) {
        this.f10353a = fragmentC1934u;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        WifiInfo connectionInfo = this.f10353a.f10507B.getConnectionInfo();
        if (connectionInfo != null && connectionInfo.getSSID() != null) {
            String ssid = connectionInfo.getSSID();
            if (ssid.indexOf("\"") == 0) {
                ssid = ssid.substring(1, ssid.length() - 1);
            }
            this.f10353a.f10517j = ssid;
        }
        FragmentC1934u.m7980e(this.f10353a);
        PrinterWifiInfo printerWifiInfo = (PrinterWifiInfo) this.f10353a.f10530x.get(i);
        String trim = printerWifiInfo.f10405a.trim();
        this.f10353a.f10511d.setText(trim);
        this.f10353a.f10513f.setText("");
        if (trim.equals(this.f10353a.f10517j)) {
            FragmentC1934u fragmentC1934u = this.f10353a;
            fragmentC1934u.f10524r = false;
            fragmentC1934u.f10516i.setVisibility(8);
            this.f10353a.f10515h.setVisibility(8);
        } else {
            FragmentC1934u fragmentC1934u2 = this.f10353a;
            fragmentC1934u2.f10524r = true;
            fragmentC1934u2.f10516i.setVisibility(0);
            this.f10353a.f10515h.setVisibility(0);
        }
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
            this.f10353a.f10514g.setText("");
            this.f10353a.f10510c.setVisibility(0);
            this.f10353a.f10510c.setEnabled(true);
            this.f10353a.f10510c.setTextColor(this.f10353a.f10519m.getResources().getColor(C1900at.C1902b.white));
        } else {
            String string = this.f10353a.f10519m.getResources().getString(C1900at.C1907g.Notsurpost);
            this.f10353a.f10514g.setTextColor(this.f10353a.f10519m.getResources().getColor(C1900at.C1902b.red));
            this.f10353a.f10514g.append(string);
            this.f10353a.f10510c.setEnabled(false);
            this.f10353a.f10510c.setTextColor(this.f10353a.f10519m.getResources().getColor(C1900at.C1902b.hui));
        }
        this.f10353a.f10512e.setSelection(i2, false);
        this.f10353a.f10513f.setFocusable(true);
        this.f10353a.f10513f.setFocusableInTouchMode(true);
        this.f10353a.f10513f.requestFocus();
        this.f10353a.f10513f.requestFocusFromTouch();
        this.f10353a.f10518l.dismiss();
    }
}
