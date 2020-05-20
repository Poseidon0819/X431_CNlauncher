package com.cnlaunch.x431pro.activity.diagnose;

import android.content.Context;
import com.cnlaunch.x431pro.module.report.ReportProduceTool;
import com.cnlaunch.x431pro.module.report.p277b.UpLoadReportInfo;

/* compiled from: DiagnoseActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.av */
/* loaded from: classes.dex */
final class RunnableC2061av implements Runnable {

    /* renamed from: a */
    final /* synthetic */ DiagnoseActivity f11515a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2061av(DiagnoseActivity diagnoseActivity) {
        this.f11515a = diagnoseActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        UpLoadReportInfo upLoadReportInfo;
        context = this.f11515a.f11019H;
        upLoadReportInfo = this.f11515a.f11082at;
        ReportProduceTool.m5231a(context, upLoadReportInfo);
        DiagnoseActivity.m7697Y(this.f11515a);
    }
}
