package com.cnlaunch.x431pro.utils.p282d;

import com.cnlaunch.x431pro.utils.p282d.DiagnoseLogInfoSearchUtil;
import java.util.Comparator;

/* compiled from: DiagnoseLogInfoSearchUtil.java */
/* renamed from: com.cnlaunch.x431pro.utils.d.b */
/* loaded from: classes.dex */
final class C2750b implements Comparator<DiagnoseLogInfoSearchUtil.C2749a> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(DiagnoseLogInfoSearchUtil.C2749a c2749a, DiagnoseLogInfoSearchUtil.C2749a c2749a2) {
        DiagnoseLogInfoSearchUtil.C2749a c2749a3 = c2749a;
        DiagnoseLogInfoSearchUtil.C2749a c2749a4 = c2749a2;
        if (c2749a3.getCreateDate() > c2749a4.getCreateDate()) {
            return -1;
        }
        return c2749a3.getCreateDate() == c2749a4.getCreateDate() ? 0 : 1;
    }
}
