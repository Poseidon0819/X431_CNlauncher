package com.cnlaunch.x431pro.activity;

import android.app.NotificationManager;
import android.os.Handler;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p169im.p178h.GoloOBManager;
import com.cnlaunch.x431pro.activity.login.LoginFunction;
import com.cnlaunch.x431pro.module.report.ReportProduceTool;
import com.cnlaunch.x431pro.module.report.UpLoadSaveReportTask;
import com.cnlaunch.x431pro.utils.p289i.FixedThreadPool;

/* compiled from: MainActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.y */
/* loaded from: classes.dex */
final class C2707y implements LoginFunction.InterfaceC2303c {

    /* renamed from: a */
    final /* synthetic */ MainActivity f15437a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2707y(MainActivity mainActivity) {
        this.f15437a = mainActivity;
    }

    @Override // com.cnlaunch.x431pro.activity.login.LoginFunction.InterfaceC2303c
    /* renamed from: a */
    public final void mo5458a() {
        PreferencesManager.m9595a(this.f15437a.f10736a).m9587a("isconflict", false);
        GoloOBManager.m8721a().m8716c();
        ReportProduceTool.m5227b();
        FixedThreadPool.m4928a().m4927a(new UpLoadSaveReportTask(this.f15437a.getApplicationContext()));
    }

    @Override // com.cnlaunch.x431pro.activity.login.LoginFunction.InterfaceC2303c
    /* renamed from: b */
    public final void mo5457b() {
        PreferencesManager.m9595a(this.f15437a.f10736a).m9587a("isconflict", false);
        GoloOBManager.m8721a().m8716c();
    }

    @Override // com.cnlaunch.x431pro.activity.login.LoginFunction.InterfaceC2303c
    /* renamed from: c */
    public final void mo5456c() {
        Handler handler;
        handler = this.f15437a.f10728R;
        handler.obtainMessage(100, 0, 0);
        ((NotificationManager) this.f15437a.f10736a.getSystemService("notification")).cancel(0);
    }
}
