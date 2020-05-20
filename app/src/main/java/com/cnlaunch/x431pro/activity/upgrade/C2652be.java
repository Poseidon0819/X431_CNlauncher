package com.cnlaunch.x431pro.activity.upgrade;

import com.cnlaunch.x431pro.module.p269j.p271b.X431PadDtoSoft;
import java.util.Comparator;

/* compiled from: UpgradeFragmentForPro.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.be */
/* loaded from: classes.dex */
final class C2652be implements Comparator {

    /* renamed from: a */
    final /* synthetic */ UpgradeFragmentForPro f15238a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2652be(UpgradeFragmentForPro upgradeFragmentForPro) {
        this.f15238a = upgradeFragmentForPro;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        X431PadDtoSoft x431PadDtoSoft = (X431PadDtoSoft) obj;
        X431PadDtoSoft x431PadDtoSoft2 = (X431PadDtoSoft) obj2;
        if (!x431PadDtoSoft.isMust() || x431PadDtoSoft2.isMust()) {
            return (x431PadDtoSoft.isMust() || !x431PadDtoSoft2.isMust()) ? 0 : 1;
        }
        return -1;
    }
}
