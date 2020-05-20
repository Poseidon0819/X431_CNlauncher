package com.unionpay.mobile.android.pboctransaction.icfcc;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.unionpay.mobile.android.pboctransaction.InterfaceC4261b;
import p000a.p001a.p002a.p003a.p004a.p005a.p006a.p007a.p008a.InterfaceC0000a;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.pboctransaction.icfcc.b */
/* loaded from: classes2.dex */
public final class ServiceConnectionC4267b implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ C4266a f22749a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ServiceConnectionC4267b(C4266a c4266a) {
        this.f22749a = c4266a;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        InterfaceC4261b interfaceC4261b;
        InterfaceC4261b interfaceC4261b2;
        InterfaceC4261b interfaceC4261b3;
        InterfaceC4261b interfaceC4261b4;
        try {
            this.f22749a.f22745c = InterfaceC0000a.AbstractBinderC0001a.m15309a(iBinder);
            interfaceC4261b3 = this.f22749a.f22746d;
            if (interfaceC4261b3 != null) {
                interfaceC4261b4 = this.f22749a.f22746d;
                interfaceC4261b4.mo1206a();
            }
        } catch (Exception unused) {
            interfaceC4261b = this.f22749a.f22746d;
            if (interfaceC4261b != null) {
                interfaceC4261b2 = this.f22749a.f22746d;
                interfaceC4261b2.mo1205b();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f22749a.f22745c = null;
    }
}
