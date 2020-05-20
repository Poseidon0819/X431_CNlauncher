package com.cnlaunch.x431pro.activity.login;

import android.os.Handler;
import android.os.Message;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;

/* compiled from: LoginActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.v */
/* loaded from: classes.dex */
final class HandlerC2379v extends Handler {

    /* renamed from: a */
    final /* synthetic */ LoginActivity f13535a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2379v(LoginActivity loginActivity) {
        this.f13535a = loginActivity;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        switch (message2.what) {
            case 123:
                LoginActivity.m6766a(this.f13535a, message2.arg1);
                return;
            case Opcodes.IUSHR /* 124 */:
                this.f13535a.finish();
                return;
            default:
                return;
        }
    }
}
