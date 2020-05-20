package com.cnlaunch.x431pro.activity.upgrade;

import com.cnlaunch.x431pro.module.p269j.p271b.X431PadDtoSoft;
import java.util.Comparator;

/* compiled from: UpgradeFragmentForPro.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.bg */
/* loaded from: classes.dex */
final class C2654bg implements Comparator {

    /* renamed from: a */
    final /* synthetic */ UpgradeFragmentForPro f15240a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2654bg(UpgradeFragmentForPro upgradeFragmentForPro) {
        this.f15240a = upgradeFragmentForPro;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return ((X431PadDtoSoft) obj2).getVersionNo().compareToIgnoreCase(((X431PadDtoSoft) obj).getVersionNo());
    }
}
