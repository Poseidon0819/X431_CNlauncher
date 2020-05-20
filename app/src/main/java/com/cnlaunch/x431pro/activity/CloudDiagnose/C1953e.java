package com.cnlaunch.x431pro.activity.CloudDiagnose;

import java.io.File;
import java.util.Comparator;

/* compiled from: CloudGetReportCacheTask.java */
/* renamed from: com.cnlaunch.x431pro.activity.CloudDiagnose.e */
/* loaded from: classes.dex */
final class C1953e implements Comparator<File> {

    /* renamed from: a */
    final /* synthetic */ CloudGetReportCacheTask f10620a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1953e(CloudGetReportCacheTask cloudGetReportCacheTask) {
        this.f10620a = cloudGetReportCacheTask;
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(File file, File file2) {
        return file.lastModified() > file2.lastModified() ? 1 : -1;
    }
}
