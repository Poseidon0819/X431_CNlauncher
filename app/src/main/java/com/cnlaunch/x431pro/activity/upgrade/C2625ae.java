package com.cnlaunch.x431pro.activity.upgrade;

import com.cnlaunch.x431pro.module.p269j.p271b.X431PadDtoSoft;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UpgradeFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.ae */
/* loaded from: classes.dex */
public final class C2625ae implements Comparator {

    /* renamed from: a */
    final /* synthetic */ UpgradeFragment f15122a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2625ae(UpgradeFragment upgradeFragment) {
        this.f15122a = upgradeFragment;
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
