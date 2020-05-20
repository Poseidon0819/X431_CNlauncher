package com.cnlaunch.x431pro.activity;

import com.cnlaunch.p120d.p121a.AppCrashHandler;
import java.io.File;

/* compiled from: GDApplication.java */
/* renamed from: com.cnlaunch.x431pro.activity.n */
/* loaded from: classes.dex */
final class C2500n implements AppCrashHandler.InterfaceC1416a {

    /* renamed from: a */
    final /* synthetic */ GDApplication f14346a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2500n(GDApplication gDApplication) {
        this.f14346a = gDApplication;
    }

    @Override // com.cnlaunch.p120d.p121a.AppCrashHandler.InterfaceC1416a
    /* renamed from: a */
    public final boolean mo6072a(File file) {
        return this.f14346a.m7910a(file);
    }
}
