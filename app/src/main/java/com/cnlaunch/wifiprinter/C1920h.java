package com.cnlaunch.wifiprinter;

import android.view.View;
import android.widget.AdapterView;
import com.cnlaunch.wifiprinter.C1900at;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MainActivity.java */
/* renamed from: com.cnlaunch.wifiprinter.h */
/* loaded from: classes.dex */
public final class C1920h implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ MainActivity f10454a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1920h(MainActivity mainActivity) {
        this.f10454a = mainActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        boolean z;
        char c;
        z = this.f10454a.f10439q;
        if (z) {
            PrinterWifiInfo printerWifiInfo = (PrinterWifiInfo) this.f10454a.f10442t.get(i);
            MainActivity.f10423e.setText(printerWifiInfo.f10405a.trim());
            String upperCase = printerWifiInfo.f10406b.toString().toUpperCase();
            if (upperCase.indexOf("[WPA-PSK-CCMP]") != -1 && upperCase.indexOf("[WPA2-PSK-CCMP]") == -1) {
                c = 4;
            } else if (upperCase.indexOf("[WPA-PSK-TKIP]") != -1 && upperCase.indexOf("[WPA2-PSK-TKIP]") == -1) {
                c = 3;
            } else if (upperCase.indexOf("[WPA2-PSK-CCMP]") != -1 && upperCase.indexOf("[WPA-PSK-CCMP]") == -1) {
                c = 6;
            } else if (upperCase.indexOf("[WPA2-PSK-TKIP]") != -1 && upperCase.indexOf("[WPA-PSK-TKIP]") == -1) {
                c = 5;
            } else if ((upperCase.indexOf("[WPA-PSK-CCMP]") != -1 && upperCase.indexOf("[WPA2-PSK-CCMP]") != -1) || ((upperCase.indexOf("[WPA-PSK-TKIP+CCMP]") != -1 && upperCase.indexOf("[WPA2-PSK-TKIP+CCMP]") != -1) || (upperCase.indexOf("[WPA-PSK-CCMP+TKIP]") != -1 && upperCase.indexOf("[WPA2-PSK-CCMP+TKIP]") != -1))) {
                c = '\b';
            } else if (upperCase.indexOf("[WPA-PSK-TKIP][WPA2-PSK-TKIP]") != -1) {
                c = 7;
            } else {
                c = upperCase.indexOf("[WEP]") != -1 ? (char) 1 : (char) 0;
            }
            String[] stringArray = this.f10454a.f10432j.getResources().getStringArray(C1900at.C1901a.key_labels);
            MainActivity mainActivity = this.f10454a;
            mainActivity.f10429d = stringArray[c];
            mainActivity.f10427b.setVisibility(0);
            this.f10454a.f10431i.dismiss();
            return;
        }
        this.f10454a.f10431i.dismiss();
    }
}
