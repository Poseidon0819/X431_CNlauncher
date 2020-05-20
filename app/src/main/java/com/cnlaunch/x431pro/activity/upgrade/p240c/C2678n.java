package com.cnlaunch.x431pro.activity.upgrade.p240c;

import com.cnlaunch.x431pro.module.p269j.p271b.X431PadDtoSoft;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DownloadLogic.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.c.n */
/* loaded from: classes.dex */
public final class C2678n implements Comparator {

    /* renamed from: a */
    final /* synthetic */ DownloadLogic f15344a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2678n(DownloadLogic downloadLogic) {
        this.f15344a = downloadLogic;
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
