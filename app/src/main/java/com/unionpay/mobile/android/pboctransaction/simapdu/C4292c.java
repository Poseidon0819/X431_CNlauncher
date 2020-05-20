package com.unionpay.mobile.android.pboctransaction.simapdu;

import android.os.Handler;
import android.os.Message;
import com.unionpay.mobile.android.pboctransaction.InterfaceC4261b;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.pboctransaction.simapdu.c */
/* loaded from: classes2.dex */
public final class C4292c implements Handler.Callback {

    /* renamed from: a */
    final /* synthetic */ C4291b f22832a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4292c(C4291b c4291b) {
        this.f22832a = c4291b;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message2) {
        InterfaceC4261b interfaceC4261b;
        InterfaceC4261b interfaceC4261b2;
        InterfaceC4261b interfaceC4261b3;
        InterfaceC4261b interfaceC4261b4;
        switch (message2.what) {
            case 1:
                interfaceC4261b = this.f22832a.f22829c;
                if (interfaceC4261b != null) {
                    interfaceC4261b2 = this.f22832a.f22829c;
                    interfaceC4261b2.mo1206a();
                    break;
                } else {
                    return true;
                }
            case 2:
                interfaceC4261b3 = this.f22832a.f22829c;
                if (interfaceC4261b3 != null) {
                    interfaceC4261b4 = this.f22832a.f22829c;
                    interfaceC4261b4.mo1205b();
                    break;
                } else {
                    return true;
                }
            default:
                return true;
        }
        C4291b.m1232b(this.f22832a);
        return true;
    }
}
