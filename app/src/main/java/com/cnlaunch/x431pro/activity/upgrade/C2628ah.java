package com.cnlaunch.x431pro.activity.upgrade;

import com.cnlaunch.x431pro.module.p269j.p271b.X431PadDtoSoft;
import java.util.Comparator;

/* compiled from: UpgradeFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.ah */
/* loaded from: classes.dex */
final class C2628ah implements Comparator {

    /* renamed from: a */
    final /* synthetic */ UpgradeFragment f15125a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2628ah(UpgradeFragment upgradeFragment) {
        this.f15125a = upgradeFragment;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return ((X431PadDtoSoft) obj2).getVersionNo().compareToIgnoreCase(((X431PadDtoSoft) obj).getVersionNo());
    }
}
