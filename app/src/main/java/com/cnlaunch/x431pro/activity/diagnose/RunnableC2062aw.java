package com.cnlaunch.x431pro.activity.diagnose;

import android.content.Context;
import com.cnlaunch.x431pro.module.report.ReportProduceTool;
import com.cnlaunch.x431pro.module.report.p277b.UpLoadReportInfo;

/* compiled from: DiagnoseActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.aw */
/* loaded from: classes.dex */
final class RunnableC2062aw implements Runnable {

    /* renamed from: a */
    final /* synthetic */ DiagnoseActivity f11516a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2062aw(DiagnoseActivity diagnoseActivity) {
        this.f11516a = diagnoseActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        UpLoadReportInfo upLoadReportInfo;
        context = this.f11516a.f11019H;
        upLoadReportInfo = this.f11516a.f11082at;
        ReportProduceTool.m5231a(context, upLoadReportInfo);
        DiagnoseActivity.m7697Y(this.f11516a);
    }
}
