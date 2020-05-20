package com.cnlaunch.x431pro.utils.p282d;

import com.cnlaunch.x431pro.module.p252d.p254b.DiagReportOrHistoryInfo;
import java.util.Comparator;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* compiled from: ReportDBUtils.java */
/* renamed from: com.cnlaunch.x431pro.utils.d.g */
/* loaded from: classes.dex */
final class C2753g implements Comparator<DiagReportOrHistoryInfo> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(DiagReportOrHistoryInfo diagReportOrHistoryInfo, DiagReportOrHistoryInfo diagReportOrHistoryInfo2) {
        return m5068a(diagReportOrHistoryInfo, diagReportOrHistoryInfo2);
    }

    /* renamed from: a */
    private static int m5068a(DiagReportOrHistoryInfo diagReportOrHistoryInfo, DiagReportOrHistoryInfo diagReportOrHistoryInfo2) {
        try {
            String replace = diagReportOrHistoryInfo.getStrTime().replace("-", "").replace(":", "").replace(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, "");
            String replace2 = diagReportOrHistoryInfo2.getStrTime().replace("-", "").replace(":", "").replace(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, "");
            if (Long.valueOf(replace).longValue() > Long.valueOf(replace2).longValue()) {
                return -1;
            }
            return Long.valueOf(replace).longValue() < Long.valueOf(replace2).longValue() ? 1 : 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
