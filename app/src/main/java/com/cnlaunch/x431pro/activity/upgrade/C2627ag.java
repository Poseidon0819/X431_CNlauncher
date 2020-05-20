package com.cnlaunch.x431pro.activity.upgrade;

import com.cnlaunch.x431pro.module.p269j.p271b.X431PadDtoSoft;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UpgradeFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.ag */
/* loaded from: classes.dex */
public final class C2627ag implements Comparator {

    /* renamed from: a */
    final /* synthetic */ UpgradeFragment f15124a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2627ag(UpgradeFragment upgradeFragment) {
        this.f15124a = upgradeFragment;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        X431PadDtoSoft x431PadDtoSoft = (X431PadDtoSoft) obj;
        X431PadDtoSoft x431PadDtoSoft2 = (X431PadDtoSoft) obj2;
        if (!x431PadDtoSoft.isChecked() || x431PadDtoSoft2.isChecked()) {
            return (x431PadDtoSoft.isChecked() || !x431PadDtoSoft2.isChecked()) ? 0 : 1;
        }
        return -1;
    }
}
