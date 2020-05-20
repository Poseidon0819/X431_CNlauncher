package com.cnlaunch.x431pro.activity.setting;

import android.os.Handler;
import android.os.Message;
import android.widget.Button;

/* compiled from: OrientationSetting.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.ao */
/* loaded from: classes.dex */
final class HandlerC2529ao extends Handler {

    /* renamed from: a */
    final /* synthetic */ OrientationSetting f14586a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2529ao(OrientationSetting orientationSetting) {
        this.f14586a = orientationSetting;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        int i;
        int i2;
        Button button;
        Button button2;
        if (message2.what == 0) {
            i = this.f14586a.f14582e;
            i2 = this.f14586a.f14583f;
            if (i == i2) {
                button2 = this.f14586a.f14581d;
                button2.setEnabled(false);
                return;
            }
            button = this.f14586a.f14581d;
            button.setEnabled(true);
            return;
        }
        super.handleMessage(message2);
    }
}
