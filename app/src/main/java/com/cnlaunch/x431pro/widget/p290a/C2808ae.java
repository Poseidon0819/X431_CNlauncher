package com.cnlaunch.x431pro.widget.p290a;

import com.cnlaunch.x431pro.module.p269j.p271b.DivisionSoftDto;
import java.util.Comparator;

/* compiled from: DivisionSoftUpgradeTipDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.a.ae */
/* loaded from: classes.dex */
final class C2808ae implements Comparator {

    /* renamed from: a */
    final /* synthetic */ View$OnClickListenerC2884z f16141a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2808ae(View$OnClickListenerC2884z view$OnClickListenerC2884z) {
        this.f16141a = view$OnClickListenerC2884z;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        DivisionSoftDto divisionSoftDto = (DivisionSoftDto) obj;
        DivisionSoftDto divisionSoftDto2 = (DivisionSoftDto) obj2;
        if (!divisionSoftDto.isMust() || divisionSoftDto2.isMust()) {
            return (divisionSoftDto.isMust() || !divisionSoftDto2.isMust()) ? 0 : 1;
        }
        return -1;
    }
}
