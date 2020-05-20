package com.cnlaunch.x431pro.activity.upgrade;

import com.cnlaunch.x431pro.module.p269j.p271b.X431PadDtoSoft;
import java.util.Comparator;

/* compiled from: UpgradeFragmentForPro.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.bd */
/* loaded from: classes.dex */
final class C2651bd implements Comparator {

    /* renamed from: a */
    final /* synthetic */ UpgradeFragmentForPro f15237a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2651bd(UpgradeFragmentForPro upgradeFragmentForPro) {
        this.f15237a = upgradeFragmentForPro;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        X431PadDtoSoft x431PadDtoSoft = (X431PadDtoSoft) obj;
        X431PadDtoSoft x431PadDtoSoft2 = (X431PadDtoSoft) obj2;
        if (2 == x431PadDtoSoft.getType()) {
            return -1;
        }
        if (2 == x431PadDtoSoft2.getType()) {
            return 1;
        }
        if (1 != x431PadDtoSoft.getType() || 1 == x431PadDtoSoft2.getType()) {
            return (1 == x431PadDtoSoft.getType() || 1 != x431PadDtoSoft2.getType()) ? 0 : 1;
        }
        return -1;
    }
}
