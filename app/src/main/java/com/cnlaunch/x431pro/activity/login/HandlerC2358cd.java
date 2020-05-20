package com.cnlaunch.x431pro.activity.login;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

/* compiled from: RegisterInstructionActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.cd */
/* loaded from: classes.dex */
final class HandlerC2358cd extends Handler {

    /* renamed from: a */
    final /* synthetic */ RegisterInstructionActivity f13470a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2358cd(RegisterInstructionActivity registerInstructionActivity) {
        this.f13470a = registerInstructionActivity;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        TextView textView;
        String str;
        TextView textView2;
        String str2;
        if (message2.what != 1) {
            return;
        }
        textView = this.f13470a.f13329C;
        str = this.f13470a.f13332F;
        textView.setText(str);
        textView2 = this.f13470a.f13335n;
        str2 = this.f13470a.f13333G;
        textView2.setText(str2);
    }
}
