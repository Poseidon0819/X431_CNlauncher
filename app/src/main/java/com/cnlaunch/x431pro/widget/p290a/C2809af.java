package com.cnlaunch.x431pro.widget.p290a;

import com.cnlaunch.x431pro.module.p269j.p271b.DivisionSoftDto;
import com.cnlaunch.x431pro.utils.C2787z;
import java.util.Comparator;

/* compiled from: DivisionSoftUpgradeTipDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.a.af */
/* loaded from: classes.dex */
final class C2809af implements Comparator {

    /* renamed from: a */
    final /* synthetic */ View$OnClickListenerC2884z f16142a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2809af(View$OnClickListenerC2884z view$OnClickListenerC2884z) {
        this.f16142a = view$OnClickListenerC2884z;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        DivisionSoftDto divisionSoftDto = (DivisionSoftDto) obj;
        DivisionSoftDto divisionSoftDto2 = (DivisionSoftDto) obj2;
        boolean m4820a = C2787z.m4820a(divisionSoftDto.getvNum(), divisionSoftDto.getMaxOldVersion());
        boolean m4820a2 = C2787z.m4820a(divisionSoftDto2.getvNum(), divisionSoftDto2.getMaxOldVersion());
        if (!m4820a || m4820a2) {
            return (m4820a || !m4820a2) ? 0 : 1;
        }
        return -1;
    }
}
