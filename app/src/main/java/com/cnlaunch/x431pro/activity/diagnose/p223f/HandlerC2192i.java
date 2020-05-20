package com.cnlaunch.x431pro.activity.diagnose.p223f;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MessageBoxDialog.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.f.i */
/* loaded from: classes.dex */
public final class HandlerC2192i extends Handler {

    /* renamed from: a */
    final /* synthetic */ MessageBoxDialog f12458a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2192i(MessageBoxDialog messageBoxDialog) {
        this.f12458a = messageBoxDialog;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        switch (message2.what) {
            case 0:
                Bundle bundle = (Bundle) message2.obj;
                if (this.f12458a.f12453a == null) {
                    return;
                }
                this.f12458a.f12453a.setTitle(bundle.getString("MessageTitle", ""));
                this.f12458a.f12453a.setMessage(bundle.getString("MessageContent", ""));
                this.f12458a.f12453a.setProgress(bundle.getInt("MessageRatio", 0));
                return;
            case 1:
                Bundle bundle2 = (Bundle) message2.obj;
                this.f12458a.f12454b.setTitle(bundle2.getString("MessageTitle", ""));
                this.f12458a.f12454b.setMessage(bundle2.getString("MessageContent", ""));
                return;
            default:
                return;
        }
    }
}
