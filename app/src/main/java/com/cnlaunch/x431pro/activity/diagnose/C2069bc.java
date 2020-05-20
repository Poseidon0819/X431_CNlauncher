package com.cnlaunch.x431pro.activity.diagnose;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.physics.DeviceFactoryManager;
import com.cnlaunch.x431pro.utils.C2778n;
import com.cnlaunch.x431pro.utils.PathUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DiagnoseActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.bc */
/* loaded from: classes.dex */
public final class C2069bc extends Thread {

    /* renamed from: a */
    final /* synthetic */ int f11531a;

    /* renamed from: b */
    final /* synthetic */ DiagnoseActivity f11532b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2069bc(DiagnoseActivity diagnoseActivity, int i) {
        this.f11532b = diagnoseActivity;
        this.f11531a = i;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        if (C2778n.m4914a(DeviceFactoryManager.m8305a().f9901a, PreferencesManager.m9595a((Context) this.f11532b).m9584b("serialNo", ""), PathUtils.m4858c())) {
            handler3 = this.f11532b.f11103bO;
            Message obtainMessage = handler3.obtainMessage(20502, 1, this.f11531a);
            handler4 = this.f11532b.f11103bO;
            handler4.sendMessage(obtainMessage);
            return;
        }
        handler = this.f11532b.f11103bO;
        Message obtainMessage2 = handler.obtainMessage(20502, 0, this.f11531a);
        handler2 = this.f11532b.f11103bO;
        handler2.sendMessage(obtainMessage2);
    }
}
