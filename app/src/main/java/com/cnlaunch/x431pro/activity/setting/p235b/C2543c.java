package com.cnlaunch.x431pro.activity.setting.p235b;

import com.cnlaunch.x431pro.module.p263h.p265b.DiagLogHistoryInfo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

/* compiled from: DiagLogHistoryInfoManager.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.b.c */
/* loaded from: classes.dex */
final class C2543c implements Comparator {

    /* renamed from: a */
    final /* synthetic */ DiagLogHistoryInfoManager f14648a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2543c(DiagLogHistoryInfoManager diagLogHistoryInfoManager) {
        this.f14648a = diagLogHistoryInfoManager;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        Date date;
        DiagLogHistoryInfo diagLogHistoryInfo = (DiagLogHistoryInfo) obj;
        DiagLogHistoryInfo diagLogHistoryInfo2 = (DiagLogHistoryInfo) obj2;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        Date date2 = null;
        try {
            date = simpleDateFormat.parse(diagLogHistoryInfo.getFeedbackTime());
        } catch (ParseException e) {
            e = e;
            date = null;
        }
        try {
            date2 = simpleDateFormat.parse(diagLogHistoryInfo2.getFeedbackTime());
        } catch (ParseException e2) {
            e = e2;
            e.printStackTrace();
            return date2.compareTo(date);
        }
        return date2.compareTo(date);
    }
}
