package com.cnlaunch.p120d.p121a;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: AppCrashHandler.java */
/* renamed from: com.cnlaunch.d.a.d */
/* loaded from: classes.dex */
final class C1418d implements FilenameFilter {

    /* renamed from: a */
    final /* synthetic */ AppCrashHandler f6770a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1418d(AppCrashHandler appCrashHandler) {
        this.f6770a = appCrashHandler;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        return str.endsWith(".cr");
    }
}
