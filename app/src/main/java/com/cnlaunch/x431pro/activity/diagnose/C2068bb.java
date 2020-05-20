package com.cnlaunch.x431pro.activity.diagnose;

import android.os.Handler;
import android.os.Message;
import com.cnlaunch.p181j.DealDiagMessageHandler;
import com.cnlaunch.x431pro.activity.MainActivity;
import com.cnlaunch.x431pro.activity.diagnose.p223f.RemoteDiagHandler;
import com.cnlaunch.x431pro.p210a.RemoteDiagObserve;

/* compiled from: DiagnoseActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.bb */
/* loaded from: classes.dex */
final class C2068bb implements DealDiagMessageHandler.InterfaceC1766b {

    /* renamed from: a */
    final /* synthetic */ DiagnoseActivity f11530a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2068bb(DiagnoseActivity diagnoseActivity) {
        this.f11530a = diagnoseActivity;
    }

    @Override // com.cnlaunch.p181j.DealDiagMessageHandler.InterfaceC1766b
    /* renamed from: a */
    public final void mo7468a() {
        RemoteDiagHandler remoteDiagHandler;
        RemoteDiagHandler remoteDiagHandler2;
        if (MainActivity.m7895b()) {
            if (MainActivity.m7875f()) {
                RemoteDiagObserve.m7936c();
            }
            remoteDiagHandler = this.f11530a.f11015D;
            if (remoteDiagHandler.f12460b < 6) {
                remoteDiagHandler2 = this.f11530a.f11015D;
                remoteDiagHandler2.m7051a();
                this.f11530a.m7692a(Message.obtain((Handler) null, 52));
                this.f11530a.mo7085f(1);
            }
        }
    }
}
