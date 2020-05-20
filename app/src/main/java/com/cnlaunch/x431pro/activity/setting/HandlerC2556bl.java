package com.cnlaunch.x431pro.activity.setting;

import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.TextView;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.x431pro.p210a.C1947h;
import com.ifoer.expedition.pro.R;

/* compiled from: WifiPrintSettingFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.bl */
/* loaded from: classes.dex */
final class HandlerC2556bl extends Handler {

    /* renamed from: a */
    final /* synthetic */ WifiPrintSettingFragment f14709a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2556bl(WifiPrintSettingFragment wifiPrintSettingFragment) {
        this.f14709a = wifiPrintSettingFragment;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        PreferencesManager preferencesManager;
        String str;
        TextView textView;
        Button button;
        Button button2;
        Button button3;
        TextView textView2;
        Button button4;
        Button button5;
        Button button6;
        switch (message2.what) {
            case 0:
                WifiPrintSettingFragment wifiPrintSettingFragment = this.f14709a;
                wifiPrintSettingFragment.f14692a = false;
                wifiPrintSettingFragment.f14705n = message2.obj.toString();
                preferencesManager = this.f14709a.f14700i;
                String str2 = C1947h.f10554f;
                str = this.f14709a.f14705n;
                preferencesManager.m9588a(str2, str);
                textView = this.f14709a.f14694c;
                textView.setText(R.string.print_launch_set_threestep_successresult);
                button = this.f14709a.f14696e;
                button.setEnabled(true);
                button2 = this.f14709a.f14696e;
                button2.setText(R.string.print_launch_set_threestep_connectbutton);
                button3 = this.f14709a.f14698g;
                button3.setEnabled(true);
                return;
            case 1:
                WifiPrintSettingFragment wifiPrintSettingFragment2 = this.f14709a;
                wifiPrintSettingFragment2.f14692a = false;
                textView2 = wifiPrintSettingFragment2.f14694c;
                textView2.setText(R.string.print_launch_set_threestep_failureresult);
                button4 = this.f14709a.f14696e;
                button4.setEnabled(true);
                button5 = this.f14709a.f14696e;
                button5.setText(R.string.print_launch_set_threestep_connectbutton);
                button6 = this.f14709a.f14698g;
                button6.setEnabled(false);
                return;
            default:
                return;
        }
    }
}
