package com.cnlaunch.x431pro.activity.mine;

import com.cnlaunch.x431pro.module.p255e.p257b.ReportFileInfo;
import java.util.Comparator;

/* compiled from: ReportPagersFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.cu */
/* loaded from: classes.dex */
final class C2470cu implements Comparator<ReportFileInfo> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(ReportFileInfo reportFileInfo, ReportFileInfo reportFileInfo2) {
        return reportFileInfo.getReportTime().before(reportFileInfo2.getReportTime()) ? 1 : -1;
    }
}
