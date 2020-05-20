package com.cnlaunch.x431pro.activity.setting.wifi;

import android.net.wifi.WifiConfiguration;
import android.view.View;
import android.widget.TextView;
import com.cnlaunch.physics.p205k.C1856n;
import com.cnlaunch.physics.wifi.DPUWiFiModeConfig;
import com.cnlaunch.x431pro.activity.setting.wifi.DPUWiFiLinkModeSettings;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WiFiAccessPointSettingsDialog.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.wifi.q */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2592q implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ WiFiAccessPointSettingsDialog f14905a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2592q(WiFiAccessPointSettingsDialog wiFiAccessPointSettingsDialog) {
        this.f14905a = wiFiAccessPointSettingsDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        TextView textView;
        int i;
        TextView textView2;
        TextView textView3;
        String charSequence;
        String str;
        DPUWiFiLinkModeSettings.InterfaceC2579a interfaceC2579a;
        TextView textView4;
        int i2;
        TextView textView5;
        TextView textView6;
        String charSequence2;
        if (C1856n.f10135a) {
            Object[] objArr = new Object[3];
            textView4 = this.f14905a.f14893c;
            objArr[0] = textView4.getText().toString();
            i2 = this.f14905a.f14898k;
            objArr[1] = Integer.valueOf(i2);
            textView5 = this.f14905a.f14894g;
            if (textView5 == null) {
                charSequence2 = "";
            } else {
                textView6 = this.f14905a.f14894g;
                charSequence2 = textView6.getText().toString();
            }
            objArr[2] = charSequence2;
            C1856n.m8130a("WiFiAccessPointSettingsDialog", String.format(" WifiConfiguration SSID=%s Security=%d Password=%s", objArr));
        }
        textView = this.f14905a.f14893c;
        String charSequence3 = textView.getText().toString();
        i = this.f14905a.f14898k;
        textView2 = this.f14905a.f14894g;
        if (textView2 == null) {
            charSequence = "";
        } else {
            textView3 = this.f14905a.f14894g;
            charSequence = textView3.getText().toString();
        }
        WifiConfiguration m8037a = DPUWiFiModeConfig.m8037a(charSequence3, i, charSequence);
        str = this.f14905a.f14901n;
        DPUWiFiModeConfig dPUWiFiModeConfig = new DPUWiFiModeConfig(2, m8037a, str);
        interfaceC2579a = this.f14905a.f14900m;
        interfaceC2579a.mo5856a(dPUWiFiModeConfig);
    }
}
